package rc;

import android.app.Service;
import android.graphics.Path;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.MenuItem;
import android.view.Window;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.g0;
import androidx.fragment.app.k0;
import b8.j;
import bd.d;
import c2.n;
import com.google.android.gms.internal.measurement.g1;
import com.google.android.gms.internal.measurement.i1;
import com.google.android.gms.internal.measurement.j1;
import com.google.android.gms.internal.measurement.k4;
import com.google.android.material.navigation.NavigationView;
import f2.r;
import f2.z;
import h.a0;
import h.b0;
import h.i0;
import id.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import k8.d1;
import k8.g4;
import k8.k1;
import k8.l2;
import k8.p0;
import k8.r0;
import k8.x3;
import k8.y1;
import l6.k;
import m.e;
import m.i;
import m.m;
import m.v;
import n.g2;
import n.j3;
import n5.t;
import o2.u;
import o8.o;
import org.json.JSONObject;
import p1.n0;
import s2.h;
import s2.p;
import ta.f;
import wa.t1;
import x5.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements e.b, l, n, h, y6.a, z, v, g4, k, i, g2, o8.c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f11561u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f11562v;

    public /* synthetic */ b(int i, Object obj) {
        this.f11561u = i;
        this.f11562v = obj;
    }

    @Override // o8.c
    public void A(o oVar) {
        ((CountDownLatch) this.f11562v).countDown();
    }

    @Override // n.g2
    public void B(m.k kVar, MenuItem menuItem) {
        ((e) this.f11562v).f8189z.removeCallbacksAndMessages(kVar);
    }

    @Override // c2.n
    public void C(c2.k kVar) {
        k4 k4Var = ((androidx.media3.decoder.ffmpeg.c) this.f11562v).M;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new c2.h(k4Var, kVar, 9));
        }
    }

    @Override // id.l
    public boolean D() {
        return ((d) this.f11562v).f2027z;
    }

    @Override // c2.n
    public void F(int i, long j5, long j8) {
        k4 k4Var = ((androidx.media3.decoder.ffmpeg.c) this.f11562v).M;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new c2.h(k4Var, i, j5, j8));
        }
    }

    public void G(Path path) {
        ArrayList arrayList = (ArrayList) this.f11562v;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            t tVar = (t) arrayList.get(size);
            j jVar = g.f14267a;
            if (tVar != null && !tVar.f8812a) {
                g.a(path, tVar.f8815d.k() / 100.0f, tVar.f8816e.k() / 100.0f, tVar.f.k() / 360.0f);
            }
        }
    }

    public JSONObject I() throws Throwable {
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        FileInputStream fileInputStream2 = null;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Checking for cached settings...", null);
        }
        try {
            File file = (File) this.f11562v;
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        jSONObject = new JSONObject(f.i(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e10) {
                        e = e10;
                        Log.e("FirebaseCrashlytics", "Failed to fetch cached settings", e);
                        f.b(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    f.b(fileInputStream2, "Error while closing settings cache file.");
                    throw th;
                }
            } else {
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Settings file does not exist.", null);
                }
                jSONObject = null;
            }
            f.b(fileInputStream2, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e11) {
            e = e11;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            f.b(fileInputStream2, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void J(la.b bVar) {
        i1 i1Var = (i1) this.f11562v;
        synchronized (i1Var.f3047e) {
            for (int i = 0; i < i1Var.f3047e.size(); i++) {
                try {
                    if (bVar.equals(((Pair) i1Var.f3047e.get(i)).first)) {
                        Log.w(i1Var.f3043a, "OnEventListener already registered.");
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            g1 g1Var = new g1(bVar);
            i1Var.f3047e.add(new Pair(bVar, g1Var));
            if (i1Var.f3049h != null) {
                try {
                    i1Var.f3049h.registerOnMeasurementEventListener(g1Var);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(i1Var.f3043a, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            i1Var.e(new j1(i1Var, g1Var, 3));
        }
    }

    public void K(int i, String str, List list, boolean z2, boolean z10) {
        d1 d1Var = (d1) this.f11562v;
        int i10 = k8.g1.f7209a[v.e.c(i)];
        r0 r0Var = i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? d1Var.g().G : d1Var.g().I : z2 ? d1Var.g().E : !z10 ? d1Var.g().F : d1Var.g().D : z2 ? d1Var.g().B : !z10 ? d1Var.g().C : d1Var.g().A : d1Var.g().H;
        int size = list.size();
        if (size == 1) {
            r0Var.c(list.get(0), str);
            return;
        }
        if (size == 2) {
            r0Var.b(list.get(0), list.get(1), str);
        } else if (size != 3) {
            r0Var.d(str);
        } else {
            r0Var.e(str, list.get(0), list.get(1), list.get(2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void L(k8.y1 r2, int r3) {
        /*
            r1 = this;
            r0 = -30
            if (r3 == r0) goto L1e
            r0 = -20
            if (r3 == r0) goto L1b
            r0 = -10
            if (r3 == r0) goto L18
            if (r3 == 0) goto L1b
            r0 = 30
            if (r3 == r0) goto L15
            k8.h r3 = k8.h.UNSET
            goto L20
        L15:
            k8.h r3 = k8.h.INITIALIZATION
            goto L20
        L18:
            k8.h r3 = k8.h.MANIFEST
            goto L20
        L1b:
            k8.h r3 = k8.h.API
            goto L20
        L1e:
            k8.h r3 = k8.h.TCF
        L20:
            java.lang.Object r0 = r1.f11562v
            java.util.EnumMap r0 = (java.util.EnumMap) r0
            r0.put(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rc.b.L(k8.y1, int):void");
    }

    public void M(y1 y1Var, k8.h hVar) {
        ((EnumMap) this.f11562v).put(y1Var, hVar);
    }

    public p0 N() {
        p0 p0Var = k1.c((Service) this.f11562v, null, null).C;
        k1.f(p0Var);
        return p0Var;
    }

    @Override // c2.n
    public void a(boolean z2) {
        k4 k4Var = ((androidx.media3.decoder.ffmpeg.c) this.f11562v).M;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new c2.i(k4Var, z2));
        }
    }

    @Override // k8.g4
    public void b(String str, String str2, Bundle bundle) {
        x3 x3Var = (x3) this.f11562v;
        if (!TextUtils.isEmpty(str)) {
            x3Var.x().y1(new l2(this, str, str2, bundle));
            return;
        }
        k1 k1Var = x3Var.F;
        if (k1Var != null) {
            p0 p0Var = k1Var.C;
            k1.f(p0Var);
            p0Var.A.c(str2, "AppId not known when logging event");
        }
    }

    @Override // m.v
    public void c(m.k kVar, boolean z2) {
        a0 a0Var;
        b0 b0Var = (b0) this.f11562v;
        m.k kVarK = kVar.k();
        int i = 0;
        boolean z10 = kVarK != kVar;
        if (z10) {
            kVar = kVarK;
        }
        a0[] a0VarArr = b0Var.f5421g0;
        int length = a0VarArr != null ? a0VarArr.length : 0;
        while (true) {
            if (i < length) {
                a0Var = a0VarArr[i];
                if (a0Var != null && a0Var.f5405h == kVar) {
                    break;
                } else {
                    i++;
                }
            } else {
                a0Var = null;
                break;
            }
        }
        if (a0Var != null) {
            if (!z10) {
                b0Var.t(a0Var, z2);
            } else {
                b0Var.q(a0Var.f5399a, a0Var, kVarK);
                b0Var.t(a0Var, true);
            }
        }
    }

    @Override // s2.h
    public void d(s2.j jVar, long j5, long j8) {
        int i;
        boolean z2;
        long j10;
        p pVar = (p) jVar;
        d2.g gVar = (d2.g) this.f11562v;
        long j11 = pVar.f11770u;
        Uri uri = pVar.f11773x.f13128w;
        u uVar = new u(j8);
        gVar.G.getClass();
        gVar.K.n(uVar, pVar.f11772w);
        e2.c cVar = (e2.c) pVar.f11775z;
        e2.c cVar2 = gVar.f3719b0;
        int size = cVar2 == null ? 0 : cVar2.f4309m.size();
        long j12 = cVar.b(0).f4329b;
        int i10 = 0;
        while (i10 < size && gVar.f3719b0.b(i10).f4329b < j12) {
            i10++;
        }
        if (cVar.f4302d) {
            if (size - i10 > cVar.f4309m.size()) {
                s1.b.p("DashMediaSource", "Loaded out of sync manifest");
            } else {
                j10 = -9223372036854775807L;
                long j13 = gVar.f3725h0;
                if (j13 != -9223372036854775807L) {
                    i = i10;
                    z2 = true;
                    if (cVar.f4305h * 1000 <= j13) {
                        s1.b.p("DashMediaSource", "Loaded stale dynamic manifest: " + cVar.f4305h + ", " + gVar.f3725h0);
                    }
                } else {
                    i = i10;
                    z2 = true;
                }
                gVar.f3724g0 = 0;
            }
            int i11 = gVar.f3724g0;
            gVar.f3724g0 = i11 + 1;
            if (i11 < gVar.G.k(pVar.f11772w)) {
                gVar.X.postDelayed(gVar.P, Math.min((gVar.f3724g0 - 1) * 1000, 5000));
                return;
            } else {
                gVar.W = new c6.c();
                return;
            }
        }
        i = i10;
        z2 = true;
        j10 = -9223372036854775807L;
        gVar.f3719b0 = cVar;
        gVar.f3720c0 = cVar.f4302d & gVar.f3720c0;
        gVar.f3721d0 = j5 - j8;
        gVar.f3722e0 = j5;
        gVar.f3726i0 += i;
        synchronized (gVar.N) {
            if (pVar.f11771v.f13157a.equals(gVar.Z)) {
                Uri uriV = gVar.f3719b0.f4307k;
                if (uriV == null) {
                    uriV = t1.v(pVar.f11773x.f13128w);
                }
                gVar.Z = uriV;
            }
        }
        e2.c cVar3 = gVar.f3719b0;
        if (!cVar3.f4302d || gVar.f3723f0 != j10) {
            gVar.C(true);
            return;
        }
        e2.u uVar2 = cVar3.i;
        if (uVar2 == null) {
            gVar.z();
            return;
        }
        String str = uVar2.f4369b;
        if (Objects.equals(str, "urn:mpeg:dash:utc:direct:2014") || Objects.equals(str, "urn:mpeg:dash:utc:direct:2012")) {
            try {
                gVar.f3723f0 = s1.b0.R(uVar2.f4370c) - gVar.f3722e0;
                gVar.C(z2);
                return;
            } catch (n0 e10) {
                gVar.B(e10);
                return;
            }
        }
        if (Objects.equals(str, "urn:mpeg:dash:utc:http-iso:2014") || Objects.equals(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            gVar.D(uVar2, new d2.f());
            return;
        }
        if (Objects.equals(str, "urn:mpeg:dash:utc:http-xsdate:2014") || Objects.equals(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            gVar.D(uVar2, new lb.e(9));
        } else if (Objects.equals(str, "urn:mpeg:dash:utc:ntp:2014") || Objects.equals(str, "urn:mpeg:dash:utc:ntp:2012")) {
            gVar.z();
        } else {
            gVar.B(new IOException("Unsupported UTC timing scheme"));
        }
    }

    @Override // c2.n
    public void e(int i) {
        k4 k4Var = ((androidx.media3.decoder.ffmpeg.c) this.f11562v).M;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new a2.p0(i, 1, k4Var));
        }
    }

    @Override // c2.n
    public void f(long j5) {
        k4 k4Var = ((androidx.media3.decoder.ffmpeg.c) this.f11562v).M;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new c2.h(k4Var, j5));
        }
    }

    @Override // m.i
    public boolean g(m.k kVar, MenuItem menuItem) {
        boolean zOnMenuItemSelected;
        switch (this.f11561u) {
            case 22:
                l9.p pVar = ((NavigationView) this.f11562v).D;
                if (pVar == null) {
                    return false;
                }
                pVar.b(menuItem);
                return true;
            case 23:
            default:
                return false;
            case 24:
                n.n nVar = ((ActionMenuView) this.f11562v).U;
                if (nVar == null) {
                    return false;
                }
                Toolbar toolbar = (Toolbar) ((wb.c) nVar).f14088v;
                Iterator it = ((CopyOnWriteArrayList) toolbar.f929d0.f7621w).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        j3 j3Var = toolbar.f931f0;
                        zOnMenuItemSelected = j3Var != null ? ((i0) ((u5.c) j3Var).f12782v).f5503d.onMenuItemSelected(0, menuItem) : false;
                    } else if (((g0) it.next()).f1281a.o()) {
                        zOnMenuItemSelected = true;
                    }
                }
                return zOnMenuItemSelected;
        }
    }

    @Override // n.g2
    public void h(m.k kVar, m mVar) {
        e eVar = (e) this.f11562v;
        Handler handler = eVar.f8189z;
        handler.removeCallbacksAndMessages(null);
        ArrayList arrayList = eVar.B;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (kVar == ((m.d) arrayList.get(i)).f8183b) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int i10 = i + 1;
        handler.postAtTime(new l2(this, i10 < arrayList.size() ? (m.d) arrayList.get(i10) : null, mVar, kVar, 6), kVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // c2.n
    public void i() {
        r2.p pVar;
        androidx.media3.decoder.ffmpeg.c cVar = (androidx.media3.decoder.ffmpeg.c) this.f11562v;
        synchronized (cVar.f231u) {
            pVar = cVar.L;
        }
        if (pVar != null) {
            pVar.h();
        }
    }

    @Override // e.b
    public void j(Object obj) {
        Map map = (Map) obj;
        androidx.fragment.app.n0 n0Var = (androidx.fragment.app.n0) this.f11562v;
        ArrayList arrayList = new ArrayList(map.values());
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
        }
        k0 k0Var = (k0) n0Var.C.pollFirst();
        if (k0Var == null) {
            Log.w("FragmentManager", "No permissions were requested for " + this);
        } else {
            String str = k0Var.f1294u;
            if (n0Var.f1312c.o(str) == null) {
                Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
            }
        }
    }

    @Override // s2.h
    public void k(s2.j jVar, long j5, long j8, int i) {
        u uVar;
        p pVar = (p) jVar;
        d2.g gVar = (d2.g) this.f11562v;
        if (i == 0) {
            long j10 = pVar.f11770u;
            uVar = new u(pVar.f11771v);
        } else {
            long j11 = pVar.f11770u;
            Uri uri = pVar.f11773x.f13128w;
            uVar = new u(j8);
        }
        gVar.K.t(uVar, pVar.f11772w, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, i);
    }

    @Override // l6.k
    public short l() throws IOException {
        int i = ((InputStream) this.f11562v).read();
        if (i != -1) {
            return (short) i;
        }
        throw new l6.j();
    }

    @Override // s2.h
    public e4.f m(s2.j jVar, long j5, long j8, IOException iOException, int i) {
        long jMin;
        p pVar = (p) jVar;
        d2.g gVar = (d2.g) this.f11562v;
        long j10 = pVar.f11770u;
        Uri uri = pVar.f11773x.f13128w;
        u uVar = new u(j8);
        int i10 = pVar.f11772w;
        gVar.G.getClass();
        if ((iOException instanceof n0) || (iOException instanceof FileNotFoundException) || (iOException instanceof v1.u) || (iOException instanceof s2.l)) {
            jMin = -9223372036854775807L;
            break;
        }
        int i11 = v1.j.f13143v;
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof v1.j) && ((v1.j) cause).f13144u == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
        }
        jMin = Math.min((i - 1) * 1000, 5000);
        e4.f fVar = jMin == -9223372036854775807L ? s2.m.f11766z : new e4.f(0, jMin, false);
        gVar.K.r(uVar, i10, iOException, !fVar.a());
        return fVar;
    }

    @Override // c2.n
    public void n() {
        ((androidx.media3.decoder.ffmpeg.c) this.f11562v).f1559j0 = true;
    }

    @Override // c2.n
    public void o(Exception exc) {
        s1.b.h("DecoderAudioRenderer", "Audio sink error", exc);
        k4 k4Var = ((androidx.media3.decoder.ffmpeg.c) this.f11562v).M;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new c2.h(k4Var, exc, 5));
        }
    }

    @Override // f2.z
    public byte[] p(UUID uuid, r rVar) {
        return (byte[]) this.f11562v;
    }

    @Override // c2.n
    public void q(c2.k kVar) {
        k4 k4Var = ((androidx.media3.decoder.ffmpeg.c) this.f11562v).M;
        Handler handler = (Handler) k4Var.f3070u;
        if (handler != null) {
            handler.post(new c2.h(k4Var, kVar, 1));
        }
    }

    @Override // y6.a
    public Object r() {
        za.c cVar = (za.c) this.f11562v;
        return new e6.r((h6.d) cVar.f14934a, (h6.d) cVar.f14935b, (h6.d) cVar.f14936c, (h6.d) cVar.f14937d, (e6.n) cVar.f14938e, (e6.n) cVar.f, (kc.b) cVar.f14939g);
    }

    @Override // m.i
    public void s(m.k kVar) {
        switch (this.f11561u) {
            case 22:
                break;
            case 23:
            default:
                Toolbar toolbar = (Toolbar) this.f11562v;
                n.k kVar2 = toolbar.f942u.N;
                if (kVar2 == null || !kVar2.e()) {
                    Iterator it = ((CopyOnWriteArrayList) toolbar.f929d0.f7621w).iterator();
                    while (it.hasNext()) {
                        ((g0) it.next()).f1281a.s();
                    }
                }
                u5.d dVar = toolbar.l0;
                if (dVar != null) {
                    dVar.s(kVar);
                }
                break;
            case 24:
                i iVar = ((ActionMenuView) this.f11562v).P;
                if (iVar != null) {
                    iVar.s(kVar);
                }
                break;
        }
    }

    @Override // l6.k
    public long skip(long j5) throws IOException {
        InputStream inputStream = (InputStream) this.f11562v;
        if (j5 < 0) {
            return 0L;
        }
        long j8 = j5;
        while (j8 > 0) {
            long jSkip = inputStream.skip(j8);
            if (jSkip <= 0) {
                if (inputStream.read() == -1) {
                    break;
                }
                jSkip = 1;
            }
            j8 -= jSkip;
        }
        return j5 - j8;
    }

    @Override // c2.n
    public void t() {
        ((androidx.media3.decoder.ffmpeg.c) this.f11562v).f1553d0 = true;
    }

    public String toString() {
        switch (this.f11561u) {
            case 17:
                StringBuilder sb2 = new StringBuilder("1");
                for (y1 y1Var : y1.values()) {
                    k8.h hVar = (k8.h) ((EnumMap) this.f11562v).get(y1Var);
                    if (hVar == null) {
                        hVar = k8.h.UNSET;
                    }
                    sb2.append(hVar.f7223u);
                }
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    @Override // s2.h
    public void u(s2.j jVar, long j5, long j8, boolean z2) {
        ((d2.g) this.f11562v).A((p) jVar, j8);
    }

    @Override // l6.k
    public int v() {
        return (l() << 8) | l();
    }

    @Override // m.v
    public boolean x(m.k kVar) {
        Window.Callback callback;
        b0 b0Var = (b0) this.f11562v;
        if (kVar != kVar.k() || !b0Var.f5415a0 || (callback = b0Var.F.getCallback()) == null || b0Var.l0) {
            return true;
        }
        callback.onMenuOpened(108, kVar);
        return true;
    }

    @Override // f2.z
    public byte[] y(f2.t tVar) {
        throw new UnsupportedOperationException();
    }

    @Override // l6.k
    public int z(int i, byte[] bArr) throws l6.j {
        int i10 = 0;
        int i11 = 0;
        while (i10 < i && (i11 = ((InputStream) this.f11562v).read(bArr, i10, i - i10)) != -1) {
            i10 += i11;
        }
        if (i10 == 0 && i11 == -1) {
            throw new l6.j();
        }
        return i10;
    }

    public b(EnumMap enumMap) {
        this.f11561u = 17;
        EnumMap enumMap2 = new EnumMap(y1.class);
        this.f11562v = enumMap2;
        enumMap2.putAll(enumMap);
    }

    public b(int i) {
        this.f11561u = i;
        switch (i) {
            case 15:
                this.f11562v = new HashMap();
                break;
            case 17:
                this.f11562v = new EnumMap(y1.class);
                break;
            case 26:
                this.f11562v = new ArrayList();
                break;
            case 27:
                this.f11562v = new b(28);
                break;
            case 28:
                this.f11562v = new o();
                break;
            default:
                this.f11562v = new g2.d(5, 1.0f, false);
                break;
        }
    }

    public b(za.c cVar) {
        this.f11561u = 4;
        this.f11562v = new File((File) cVar.f14936c, "com.crashlytics.settings.json");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(ae.l lVar) {
        this.f11561u = 1;
        this.f11562v = (be.i) lVar;
    }

    public b(byte[] bArr) {
        this.f11561u = 10;
        bArr.getClass();
        this.f11562v = bArr;
    }

    @Override // c2.n
    public /* synthetic */ void E() {
    }

    @Override // c2.n
    public /* synthetic */ void w() {
    }

    private final void H(m.k kVar) {
    }
}
