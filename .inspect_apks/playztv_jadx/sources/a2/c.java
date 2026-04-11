package a2;

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
import com.google.android.gms.internal.measurement.r4;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements x6.g, com.bumptech.glide.manager.n, f2.z, w2.q {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f172u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f173v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f174w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f175x;

    public c(k8.z0 z0Var, String str) {
        this.f175x = z0Var;
        t7.v.d(str);
        this.f173v = str;
    }

    public static void d(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f = fArr2[10];
        float f4 = fArr2[8];
        float fSqrt = (float) Math.sqrt((f4 * f4) + (f * f));
        float f10 = fArr2[10] / fSqrt;
        fArr[0] = f10;
        float f11 = fArr2[8];
        fArr[2] = f11 / fSqrt;
        fArr[8] = (-f11) / fSqrt;
        fArr[10] = f10;
    }

    @Override // com.bumptech.glide.manager.n
    public void a() {
        ((ConnectivityManager) ((q7.h) this.f174w).get()).unregisterNetworkCallback((com.bumptech.glide.manager.p) this.f175x);
    }

    @Override // com.bumptech.glide.manager.n
    public boolean b() {
        q7.h hVar = (q7.h) this.f174w;
        this.f172u = ((ConnectivityManager) hVar.get()).getActiveNetwork() != null;
        try {
            ((ConnectivityManager) hVar.get()).registerDefaultNetworkCallback((com.bumptech.glide.manager.p) this.f175x);
            return true;
        } catch (RuntimeException e10) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register callback", e10);
            }
            return false;
        }
    }

    public void c() {
        z5.c.a((z5.c) this.f175x, this, false);
    }

    @Override // w2.q
    public void e() {
        SparseArray sparseArray = (SparseArray) this.f175x;
        ((w2.q) this.f173v).e();
        if (this.f172u) {
            for (int i = 0; i < sparseArray.size(); i++) {
                ((t3.n) sparseArray.valueAt(i)).i = true;
            }
        }
    }

    public File f() {
        File file;
        synchronized (((z5.c) this.f175x)) {
            try {
                z5.b bVar = (z5.b) this.f173v;
                if (bVar.f != this) {
                    throw new IllegalStateException();
                }
                if (!bVar.f14871e) {
                    ((boolean[]) this.f174w)[0] = true;
                }
                file = bVar.f14870d[0];
                ((z5.c) this.f175x).f14873u.mkdirs();
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    public synchronized void g() {
        try {
            if (this.f172u) {
                return;
            }
            Boolean boolI = i();
            this.f174w = boolI;
            if (boolI == null) {
                r2.h hVar = new r2.h(8);
                na.l lVar = (na.l) ((kb.c) this.f173v);
                lVar.a(lVar.f8904c, hVar);
            }
            this.f172u = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // x6.g
    public Object get() {
        if (this.f172u) {
            throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
        }
        com.bumptech.glide.d.e("Glide registry");
        this.f172u = true;
        try {
            return cf.l.k((com.bumptech.glide.b) this.f173v, (List) this.f174w, (com.bumptech.glide.c) this.f175x);
        } finally {
            this.f172u = false;
            Trace.endSection();
        }
    }

    public synchronized boolean h() {
        Boolean bool;
        try {
            g();
            bool = (Boolean) this.f174w;
        } catch (Throwable th) {
            throw th;
        }
        return bool != null ? bool.booleanValue() : ((FirebaseMessaging) this.f175x).f3575a.h();
    }

    public Boolean i() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        ga.g gVar = ((FirebaseMessaging) this.f175x).f3575a;
        gVar.a();
        Context context = gVar.f5346a;
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

    @Override // w2.q
    public void j(w2.b0 b0Var) {
        ((w2.q) this.f173v).j(b0Var);
    }

    public void k() {
        s1.y yVar = (s1.y) this.f175x;
        if (this.f172u) {
            yVar.c(new a(0, this));
            this.f172u = false;
        }
    }

    public r4 l(String str, long j5) {
        Long lValueOf = Long.valueOf(j5);
        Object obj = r4.f3172g;
        return new r4(this, str, lValueOf, 0);
    }

    public r4 m(String str, String str2) {
        Object obj = r4.f3172g;
        return new r4(this, str, str2, 3);
    }

    public r4 n(String str, boolean z2) {
        Boolean boolValueOf = Boolean.valueOf(z2);
        Object obj = r4.f3172g;
        return new r4(this, str, boolValueOf, 2);
    }

    public String o() {
        if (!this.f172u) {
            this.f172u = true;
            this.f174w = ((k8.z0) this.f175x).x1().getString((String) this.f173v, null);
        }
        return (String) this.f174w;
    }

    @Override // f2.z
    public byte[] p(UUID uuid, f2.r rVar) throws f2.a0 {
        String str = rVar.f4745b;
        if (this.f172u || TextUtils.isEmpty(str)) {
            str = (String) this.f174w;
        }
        if (TextUtils.isEmpty(str)) {
            Map map = Collections.EMPTY_MAP;
            Uri uri = Uri.EMPTY;
            s1.d.i(uri, "The uri must be set.");
            throw new f2.a0(new v1.m(uri, 0L, 1, null, map, 0L, -1L, null, 0), uri, aa.h1.A, 0L, new IllegalStateException("No license URL"));
        }
        HashMap map2 = new HashMap();
        UUID uuid2 = p1.g.f9749e;
        map2.put("Content-Type", uuid2.equals(uuid) ? "text/xml" : p1.g.f9747c.equals(uuid) ? "application/json" : "application/octet-stream");
        if (uuid2.equals(uuid)) {
            map2.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (((HashMap) this.f175x)) {
            map2.putAll((HashMap) this.f175x);
        }
        return cf.l.q(((a0.g) this.f173v).g(), str, rVar.f4744a, map2);
    }

    @Override // w2.q
    public w2.h0 q(int i, int i10) {
        SparseArray sparseArray = (SparseArray) this.f175x;
        w2.q qVar = (w2.q) this.f173v;
        if (i10 != 3) {
            this.f172u = true;
            return qVar.q(i, i10);
        }
        t3.n nVar = (t3.n) sparseArray.get(i);
        if (nVar != null) {
            return nVar;
        }
        t3.n nVar2 = new t3.n(qVar.q(i, i10), (t3.k) this.f174w);
        sparseArray.put(i, nVar2);
        return nVar2;
    }

    public void r(String str) {
        SharedPreferences.Editor editorEdit = ((k8.z0) this.f175x).x1().edit();
        editorEdit.putString((String) this.f173v, str);
        editorEdit.apply();
        this.f174w = str;
    }

    @Override // f2.z
    public byte[] y(f2.t tVar) {
        return cf.l.q(((a0.g) this.f173v).g(), tVar.f4747b + "&signedRequest=" + s1.b0.o(tVar.f4746a), null, Collections.EMPTY_MAP);
    }

    public c(Uri uri, String str, String str2, boolean z2, boolean z10) {
        this.f173v = uri;
        this.f174w = str;
        this.f175x = str2;
        this.f172u = z2;
    }

    public c() {
        this.f173v = new float[16];
        this.f174w = new float[16];
        this.f175x = new q3.d();
    }

    public c(w2.q qVar, t3.k kVar) {
        this.f173v = qVar;
        this.f174w = kVar;
        this.f175x = new SparseArray();
    }

    public c(Context context, Looper looper, Looper looper2, l0 l0Var, s1.w wVar) {
        this.f173v = context.getApplicationContext();
        this.f175x = wVar.a(looper, null);
        this.f174w = new b(this, wVar.a(looper2, null), l0Var);
    }

    public c(String str, boolean z2, a0.g gVar) {
        s1.d.b((z2 && TextUtils.isEmpty(str)) ? false : true);
        this.f173v = gVar;
        this.f174w = str;
        this.f172u = z2;
        this.f175x = new HashMap();
    }

    public c(com.bumptech.glide.b bVar, List list, com.bumptech.glide.c cVar) {
        this.f173v = bVar;
        this.f174w = list;
        this.f175x = cVar;
    }

    public c(q7.h hVar, com.bumptech.glide.manager.m mVar) {
        this.f175x = new com.bumptech.glide.manager.p(0, this);
        this.f174w = hVar;
        this.f173v = mVar;
    }

    public c(za.c cVar, boolean z2) {
        this.f175x = cVar;
        this.f174w = new AtomicReference(null);
        this.f172u = z2;
        this.f173v = new AtomicMarkableReference(new va.d(z2 ? 8192 : 1024), false);
    }

    public c(int i) {
        this.f173v = new ReentrantLock();
        this.f174w = new long[i];
        this.f175x = new boolean[i];
    }

    public c(FirebaseMessaging firebaseMessaging, kb.c cVar) {
        this.f175x = firebaseMessaging;
        this.f173v = cVar;
    }

    public c(z5.c cVar, z5.b bVar) {
        this.f175x = cVar;
        this.f173v = bVar;
        this.f174w = bVar.f14871e ? null : new boolean[cVar.A];
    }

    public c(Context context, r2.p pVar, Boolean bool) {
        AudioManager audioManagerC = context == null ? null : q1.c.C(context);
        if (audioManagerC != null && (bool == null || !bool.booleanValue())) {
            Spatializer spatializer = audioManagerC.getSpatializer();
            this.f173v = spatializer;
            this.f172u = spatializer.getImmersiveAudioLevel() != 0;
            r2.k kVar = new r2.k(pVar);
            this.f175x = kVar;
            Looper looperMyLooper = Looper.myLooper();
            s1.d.h(looperMyLooper);
            Handler handler = new Handler(looperMyLooper);
            this.f174w = handler;
            spatializer.addOnSpatializerStateChangedListener(new c2.c0(0, handler), kVar);
            return;
        }
        this.f173v = null;
        this.f172u = false;
        this.f174w = null;
        this.f175x = null;
    }
}
