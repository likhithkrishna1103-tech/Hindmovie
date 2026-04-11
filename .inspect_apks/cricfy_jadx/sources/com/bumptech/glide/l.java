package com.bumptech.glide;

import a3.c0;
import a3.i0;
import a3.r;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.Spatializer;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.emoji2.text.w;
import com.bumptech.glide.manager.q;
import com.google.android.gms.internal.measurement.z3;
import com.google.firebase.messaging.FirebaseMessaging;
import f9.f1;
import g2.d0;
import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import kf.y;
import l2.a0;
import l2.t;
import l2.z;
import o8.u;
import ua.e1;
import w4.v;
import y1.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements s7.g, com.bumptech.glide.manager.o, z, r {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2222v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f2223w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f2224x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f2225y;

    public l(f1 f1Var, String str) {
        this.f2225y = f1Var;
        u.d(str);
        this.f2223w = str;
    }

    public static IOException d(l lVar, boolean z10, IOException iOException, int i) {
        boolean z11 = (i & 4) == 0;
        boolean z12 = (i & 8) == 0;
        if (iOException != null) {
            lVar.o(iOException);
        }
        return ((of.n) lVar.f2223w).h(lVar, z12 && !z10, z11 && !z10, z11 && z10, z12 && z10, iOException);
    }

    public static void f(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f = fArr2[10];
        float f10 = fArr2[8];
        float fSqrt = (float) Math.sqrt((f10 * f10) + (f * f));
        float f11 = fArr2[10] / fSqrt;
        fArr[0] = f11;
        float f12 = fArr2[8];
        fArr[2] = f12 / fSqrt;
        fArr[8] = (-f12) / fSqrt;
        fArr[10] = f11;
    }

    @Override // com.bumptech.glide.manager.o
    public void a() {
        ((ConnectivityManager) ((l8.i) this.f2224x).get()).unregisterNetworkCallback((q) this.f2225y);
    }

    @Override // com.bumptech.glide.manager.o
    public boolean b() {
        l8.i iVar = (l8.i) this.f2224x;
        this.f2222v = ((ConnectivityManager) iVar.get()).getActiveNetwork() != null;
        try {
            ((ConnectivityManager) iVar.get()).registerDefaultNetworkCallback((q) this.f2225y);
            return true;
        } catch (RuntimeException e9) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register callback", e9);
            }
            return false;
        }
    }

    public void c() {
        u6.c.a((u6.c) this.f2225y, this, false);
    }

    @Override // a3.r
    public void e() {
        SparseArray sparseArray = (SparseArray) this.f2225y;
        ((r) this.f2223w).e();
        if (this.f2222v) {
            for (int i = 0; i < sparseArray.size(); i++) {
                ((x3.q) sparseArray.valueAt(i)).i = true;
            }
        }
    }

    @Override // l2.z
    public byte[] g(UUID uuid, l2.r rVar) throws a0 {
        String str = rVar.f7678b;
        if (this.f2222v || TextUtils.isEmpty(str)) {
            str = (String) this.f2224x;
        }
        if (TextUtils.isEmpty(str)) {
            Map map = Collections.EMPTY_MAP;
            Uri uri = Uri.EMPTY;
            y1.d.i(uri, "The uri must be set.");
            throw new a0(new b2.o(uri, 0L, 1, null, map, 0L, -1L, null, 0), uri, e1.B, 0L, new IllegalStateException("No license URL"));
        }
        HashMap map2 = new HashMap();
        UUID uuid2 = v1.f.f12661e;
        map2.put("Content-Type", uuid2.equals(uuid) ? "text/xml" : v1.f.f12659c.equals(uuid) ? "application/json" : "application/octet-stream");
        if (uuid2.equals(uuid)) {
            map2.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (((HashMap) this.f2225y)) {
            map2.putAll((HashMap) this.f2225y);
        }
        return v.f(((b2.q) this.f2223w).h(), str, rVar.f7677a, map2);
    }

    @Override // s7.g
    public Object get() {
        if (this.f2222v) {
            throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
        }
        c.b("Glide registry");
        this.f2222v = true;
        try {
            return z3.j((b) this.f2223w, (List) this.f2224x, (v) this.f2225y);
        } finally {
            this.f2222v = false;
            Trace.endSection();
        }
    }

    public of.o h() {
        pf.e eVarF = ((pf.f) this.f2225y).f();
        of.o oVar = eVarF instanceof of.o ? (of.o) eVarF : null;
        if (oVar != null) {
            return oVar;
        }
        throw new IllegalStateException("no connection for CONNECT tunnels");
    }

    public File i() {
        File file;
        synchronized (((u6.c) this.f2225y)) {
            try {
                u6.b bVar = (u6.b) this.f2223w;
                if (bVar.f != this) {
                    throw new IllegalStateException();
                }
                if (!bVar.f12262e) {
                    ((boolean[]) this.f2224x)[0] = true;
                }
                file = bVar.f12261d[0];
                ((u6.c) this.f2225y).f12264v.mkdirs();
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    public synchronized void j() {
        try {
            if (this.f2222v) {
                return;
            }
            Boolean boolL = l();
            this.f2224x = boolL;
            if (boolL == null) {
                nc.l lVar = new nc.l(1);
                hb.l lVar2 = (hb.l) ((ec.c) this.f2223w);
                lVar2.a(lVar2.f5900c, lVar);
            }
            this.f2222v = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean k() {
        Boolean bool;
        try {
            j();
            bool = (Boolean) this.f2224x;
        } catch (Throwable th) {
            throw th;
        }
        return bool != null ? bool.booleanValue() : ((FirebaseMessaging) this.f2225y).f3038a.h();
    }

    public Boolean l() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        ab.g gVar = ((FirebaseMessaging) this.f2225y).f3038a;
        gVar.a();
        Context context = gVar.f390a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
        if (sharedPreferences.contains("auto_init")) {
            return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public y m(boolean z10) throws IOException {
        try {
            y yVarI = ((pf.f) this.f2225y).i(z10);
            if (yVarI == null) {
                return yVarI;
            }
            yVarI.f7592n = this;
            return yVarI;
        } catch (IOException e9) {
            o(e9);
            throw e9;
        }
    }

    public void n() {
        x xVar = (x) this.f2225y;
        if (this.f2222v) {
            xVar.c(new w(7, this));
            this.f2222v = false;
        }
    }

    public void o(IOException iOException) {
        this.f2222v = true;
        ((pf.f) this.f2225y).f().a((of.n) this.f2223w, iOException);
    }

    @Override // a3.r
    public i0 p(int i, int i10) {
        SparseArray sparseArray = (SparseArray) this.f2225y;
        r rVar = (r) this.f2223w;
        if (i10 != 3) {
            this.f2222v = true;
            return rVar.p(i, i10);
        }
        x3.q qVar = (x3.q) sparseArray.get(i);
        if (qVar != null) {
            return qVar;
        }
        x3.q qVar2 = new x3.q(rVar.p(i, i10), (x3.n) this.f2224x);
        sparseArray.put(i, qVar2);
        return qVar2;
    }

    public nb.w q() throws SocketException {
        of.n nVar = (of.n) this.f2223w;
        if (nVar.D) {
            throw new IllegalStateException("Check failed.");
        }
        nVar.D = true;
        nVar.f9820y.i();
        synchronized (nVar) {
            if (nVar.L == null) {
                throw new IllegalStateException("Check failed.");
            }
            if (nVar.H || nVar.I) {
                throw new IllegalStateException("Check failed.");
            }
            if (nVar.F) {
                throw new IllegalStateException("Check failed.");
            }
            if (!nVar.G) {
                throw new IllegalStateException("Check failed.");
            }
            nVar.G = false;
            nVar.H = true;
            nVar.I = true;
        }
        pf.e eVarF = ((pf.f) this.f2225y).f();
        ge.i.c(eVarF, "null cannot be cast to non-null type okhttp3.internal.connection.RealConnection");
        of.o oVar = (of.o) eVarF;
        oVar.f9825e.setSoTimeout(0);
        oVar.h();
        return new nb.w(this);
    }

    public String r() {
        if (!this.f2222v) {
            this.f2222v = true;
            f1 f1Var = (f1) this.f2225y;
            this.f2224x = f1Var.q1().getString((String) this.f2223w, null);
        }
        return (String) this.f2224x;
    }

    @Override // a3.r
    public void s(c0 c0Var) {
        ((r) this.f2223w).s(c0Var);
    }

    public void t(String str) {
        SharedPreferences.Editor editorEdit = ((f1) this.f2225y).q1().edit();
        editorEdit.putString((String) this.f2223w, str);
        editorEdit.apply();
        this.f2224x = str;
    }

    @Override // l2.z
    public byte[] w(t tVar) {
        return v.f(((b2.q) this.f2223w).h(), tVar.f7680b + "&signedRequest=" + y1.a0.o(tVar.f7679a), null, Collections.EMPTY_MAP);
    }

    public l() {
        this.f2223w = new float[16];
        this.f2224x = new float[16];
        this.f2225y = new pa.o();
    }

    public l(of.n nVar, of.h hVar, pf.f fVar) {
        ge.i.e(hVar, "finder");
        this.f2223w = nVar;
        this.f2224x = hVar;
        this.f2225y = fVar;
    }

    public l(r rVar, x3.n nVar) {
        this.f2223w = rVar;
        this.f2224x = nVar;
        this.f2225y = new SparseArray();
    }

    public l(Context context, Looper looper, Looper looper2, d0 d0Var, y1.v vVar) {
        this.f2223w = context.getApplicationContext();
        this.f2225y = vVar.a(looper, null);
        this.f2224x = new g2.a(this, vVar.a(looper2, null), d0Var);
    }

    public l(String str, boolean z10, b2.q qVar) {
        y1.d.b((z10 && TextUtils.isEmpty(str)) ? false : true);
        this.f2223w = qVar;
        this.f2224x = str;
        this.f2222v = z10;
        this.f2225y = new HashMap();
    }

    public l(b bVar, List list, v vVar) {
        this.f2223w = bVar;
        this.f2224x = list;
        this.f2225y = vVar;
    }

    public l(l8.i iVar, com.bumptech.glide.manager.n nVar) {
        this.f2225y = new q(0, this);
        this.f2224x = iVar;
        this.f2223w = nVar;
    }

    public l(tb.c cVar, boolean z10) {
        this.f2225y = cVar;
        this.f2224x = new AtomicReference(null);
        this.f2222v = z10;
        this.f2223w = new AtomicMarkableReference(new pb.d(z10 ? 8192 : 1024), false);
    }

    public l(FirebaseMessaging firebaseMessaging, ec.c cVar) {
        this.f2225y = firebaseMessaging;
        this.f2223w = cVar;
    }

    public l(u6.c cVar, u6.b bVar) {
        this.f2225y = cVar;
        this.f2223w = bVar;
        this.f2224x = bVar.f12262e ? null : new boolean[cVar.B];
    }

    public l(Context context, v2.o oVar, Boolean bool) {
        AudioManager audioManagerG = context == null ? null : w1.d.g(context);
        if (audioManagerG != null && (bool == null || !bool.booleanValue())) {
            Spatializer spatializer = audioManagerG.getSpatializer();
            this.f2223w = spatializer;
            this.f2222v = spatializer.getImmersiveAudioLevel() != 0;
            v2.j jVar = new v2.j(oVar);
            this.f2225y = jVar;
            Looper looperMyLooper = Looper.myLooper();
            y1.d.h(looperMyLooper);
            Handler handler = new Handler(looperMyLooper);
            this.f2224x = handler;
            spatializer.addOnSpatializerStateChangedListener(new i2.d0(0, handler), jVar);
            return;
        }
        this.f2223w = null;
        this.f2222v = false;
        this.f2224x = null;
        this.f2225y = null;
    }
}
