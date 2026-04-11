package g4;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.measurement.f3;
import com.google.android.gms.internal.measurement.k4;
import com.google.android.gms.internal.measurement.n3;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import k8.x3;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k0 implements ea.s, r, g6.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Object f5097u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Serializable f5098v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f5099w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f5100x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f5101y;

    public k0(x3 x3Var) {
        this.f5101y = x3Var;
    }

    @Override // g4.r
    public void a(int i, p1.s0 s0Var) {
        m0 m0Var = (m0) this.f5101y;
        j1 j1Var = m0Var.f5115g.f4973t;
        int i10 = j1Var.e0(20) ? 4 : 0;
        if (m0Var.f5124q != i10) {
            m0Var.f5124q = i10;
            ((h4.t) m0Var.f5118k.f5867v).f5847a.setFlags(i10 | 3);
        }
        m0Var.N(j1Var);
    }

    @Override // g6.a
    public void b(c6.f fVar, a7.b bVar) {
        g6.b bVarA;
        boolean z2;
        String strC0 = ((h4.z) this.f5097u).c0(fVar);
        k4 k4Var = (k4) this.f5099w;
        synchronized (k4Var) {
            try {
                bVarA = (g6.b) ((HashMap) k4Var.f3070u).get(strC0);
                if (bVarA == null) {
                    bVarA = ((g6.c) k4Var.f3071v).a();
                    ((HashMap) k4Var.f3070u).put(strC0, bVarA);
                }
                bVarA.f5320b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        bVarA.f5319a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strC0 + " for for Key: " + fVar);
            }
            try {
                z5.c cVarL = l();
                if (cVarL.G(strC0) == null) {
                    a2.c cVarX = cVarL.x(strC0);
                    if (cVarX == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: ".concat(strC0));
                    }
                    try {
                        if (((c6.b) bVar.f618v).B(bVar.f619w, cVarX.f(), (c6.i) bVar.f620x)) {
                            z5.c.a((z5.c) cVarX.f175x, cVarX, true);
                            cVarX.f172u = true;
                        }
                        if (!z2) {
                            try {
                                cVarX.c();
                            } catch (IOException unused) {
                            }
                        }
                    } finally {
                        if (!cVarX.f172u) {
                            try {
                                cVarX.c();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            } catch (IOException e10) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e10);
                }
            }
        } finally {
            ((k4) this.f5099w).z(strC0);
        }
    }

    @Override // ea.s
    public void c(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        m0 m0Var = (m0) ((k0) this.f5101y).f5101y;
        if (this != m0Var.f5123p) {
            return;
        }
        m0.E(m0Var.f5118k, l.b((p1.j0) this.f5097u, (String) this.f5098v, (Uri) this.f5099w, this.f5100x, bitmap));
        b0 b0Var = m0Var.f5115g;
        s1.b0.S(b0Var.f4968o, new v(b0Var, 1));
    }

    @Override // g4.r
    public void d(int i, p1 p1Var, boolean z2, boolean z10, int i10) {
        m0 m0Var = (m0) this.f5101y;
        m0Var.N(m0Var.f5115g.f4973t);
    }

    @Override // g6.a
    public File f(c6.f fVar) {
        String strC0 = ((h4.z) this.f5097u).c0(fVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strC0 + " for for Key: " + fVar);
        }
        try {
            n.a1 a1VarG = l().G(strC0);
            if (a1VarG != null) {
                return ((File[]) a1VarG.f8343u)[0];
            }
            return null;
        } catch (IOException e10) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e10);
            return null;
        }
    }

    @Override // g4.r
    public void j(int i, m1 m1Var) {
        Bundle bundle = Bundle.EMPTY;
        h4.z zVar = ((m0) this.f5101y).f5118k;
        String str = m1Var.f5135b;
        zVar.getClass();
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        ((h4.t) zVar.f5867v).f5847a.sendSessionEvent(str, bundle);
    }

    public synchronized z5.c l() {
        try {
            if (((z5.c) this.f5101y) == null) {
                this.f5101y = z5.c.J((File) this.f5098v, this.f5100x);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (z5.c) this.f5101y;
    }

    public void m(p1.d dVar) {
        m0 m0Var = (m0) this.f5101y;
        m0Var.f5115g.f4973t.g0().getClass();
        int iE = l.e(dVar);
        h4.t tVar = (h4.t) m0Var.f5118k.f5867v;
        tVar.getClass();
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(iE);
        tVar.f5847a.setPlaybackToLocal(builder.build());
    }

    public void n() {
        m0 m0Var = (m0) this.f5101y;
        j1 j1Var = m0Var.f5115g.f4973t;
        j1Var.g0().getClass();
        int iE = l.e(j1Var.e0(21) ? j1Var.a0() : p1.d.f9682h);
        h4.t tVar = (h4.t) m0Var.f5118k.f5867v;
        tVar.getClass();
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(iE);
        tVar.f5847a.setPlaybackToLocal(builder.build());
    }

    public void o(p1.g0 g0Var) {
        m0 m0Var = (m0) this.f5101y;
        h4.z zVar = m0Var.f5118k;
        v();
        if (g0Var == null) {
            ((h4.t) zVar.f5867v).f5847a.setRatingType(0);
        } else {
            ((h4.t) zVar.f5867v).f5847a.setRatingType(l.f(g0Var.f9759d.i));
        }
        m0Var.N(m0Var.f5115g.f4973t);
    }

    @Override // ea.s
    public void p(Throwable th) {
        if (this != ((m0) ((k0) this.f5101y).f5101y).f5123p) {
            return;
        }
        s1.b.p("MediaSessionLegacyStub", "Failed to load bitmap: " + th.getMessage());
    }

    public void q(int i, j1 j1Var) {
        m0 m0Var = (m0) this.f5101y;
        u(j1Var.x());
        r(j1Var.e0(18) ? j1Var.O() : p1.j0.K);
        j1Var.B();
        v();
        t(j1Var.C0());
        s(j1Var.v0());
        j1Var.g0();
        n();
        int i10 = j1Var.e0(20) ? 4 : 0;
        if (m0Var.f5124q != i10) {
            m0Var.f5124q = i10;
            ((h4.t) m0Var.f5118k.f5867v).f5847a.setFlags(i10 | 3);
        }
        o(j1Var.g());
    }

    public void r(p1.j0 j0Var) {
        m0 m0Var = (m0) this.f5101y;
        h4.z zVar = m0Var.f5118k;
        CharSequence queueTitle = ((h4.l) ((u5.d) zVar.f5868w).f12784v).f5824a.getQueueTitle();
        CharSequence charSequence = j0Var.f9836a;
        if (TextUtils.equals(queueTitle, charSequence)) {
            return;
        }
        j1 j1Var = m0Var.f5115g.f4973t;
        if (!m0Var.f5129v.a(17) || !j1Var.w().a(17)) {
            charSequence = null;
        }
        ((h4.t) zVar.f5867v).f5847a.setQueueTitle(charSequence);
    }

    public void s(int i) {
        h4.z zVar = ((m0) this.f5101y).f5118k;
        int i10 = l.f5102a;
        int i11 = 0;
        if (i != 0) {
            if (i == 1) {
                i11 = 1;
            } else if (i != 2) {
                s1.b.p("LegacyConversions", "Unrecognized RepeatMode: " + i + " was converted to `PlaybackStateCompat.REPEAT_MODE_NONE`");
            } else {
                i11 = 2;
            }
        }
        h4.t tVar = (h4.t) zVar.f5867v;
        if (tVar.f5854j != i11) {
            tVar.f5854j = i11;
            synchronized (tVar.f5850d) {
                for (int iBeginBroadcast = tVar.f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((h4.f) tVar.f.getBroadcastItem(iBeginBroadcast)).d(i11);
                    } catch (RemoteException | SecurityException e10) {
                        Log.e("MediaSessionCompat", "Dead object in setRepeatMode.", e10);
                    }
                }
                tVar.f.finishBroadcast();
            }
        }
    }

    public void t(boolean z2) {
        h4.z zVar = ((m0) this.f5101y).f5118k;
        int i = l.f5102a;
        h4.t tVar = (h4.t) zVar.f5867v;
        if (tVar.f5855k != z2) {
            tVar.f5855k = z2 ? 1 : 0;
            synchronized (tVar.f5850d) {
                for (int iBeginBroadcast = tVar.f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((h4.f) tVar.f.getBroadcastItem(iBeginBroadcast)).s(z2 ? 1 : 0);
                    } catch (RemoteException | SecurityException e10) {
                        Log.e("MediaSessionCompat", "Dead object in setShuffleMode.", e10);
                    }
                }
                tVar.f.finishBroadcast();
            }
        }
    }

    public void u(p1.f1 f1Var) {
        w(f1Var);
        v();
    }

    public void v() {
        ea.y yVarK;
        Uri uri;
        Bitmap bitmap;
        Uri uri2;
        m0 m0Var = (m0) this.f5101y;
        b0 b0Var = m0Var.f5115g;
        j1 j1Var = b0Var.f4973t;
        p1.g0 g0VarG = j1Var.g();
        p1.j0 j0VarB = j1Var.B();
        long duration = -9223372036854775807L;
        if ((!j1Var.e0(16) || !j1Var.W0()) && j1Var.e0(16)) {
            duration = j1Var.getDuration();
        }
        String str = g0VarG != null ? g0VarG.f9756a : "";
        Uri uri3 = (g0VarG == null || (uri2 = g0VarG.f.f9697a) == null) ? null : uri2;
        if (Objects.equals((p1.j0) this.f5097u, j0VarB) && Objects.equals((String) this.f5098v, str) && Objects.equals((Uri) this.f5099w, uri3) && this.f5100x == duration) {
            return;
        }
        this.f5098v = str;
        this.f5099w = uri3;
        this.f5097u = j0VarB;
        this.f5100x = duration;
        h4.z zVar = b0Var.f4966m;
        zVar.getClass();
        byte[] bArr = j0VarB.f9844k;
        if (bArr != null) {
            yVarK = zVar.K(bArr);
        } else {
            Uri uri4 = j0VarB.f9846m;
            if (uri4 != null) {
                a7.b bVar = (a7.b) zVar.f5868w;
                if (bVar == null || (uri = (Uri) bVar.f619w) == null || !uri.equals(uri4)) {
                    v1.i iVar = (v1.i) zVar.f5867v;
                    ea.y yVarA = ((ea.a0) iVar.f13140a).a(new l5.d(iVar, 3, uri4));
                    zVar.f5868w = new a7.b(uri4, yVarA);
                    yVarK = yVarA;
                } else {
                    yVarK = (ea.y) ((a7.b) zVar.f5868w).f620x;
                    s1.d.h(yVarK);
                }
            } else {
                yVarK = null;
            }
        }
        if (yVarK != null) {
            m0Var.f5123p = null;
            if (yVarK.isDone()) {
                try {
                    bitmap = (Bitmap) b8.h.j(yVarK);
                } catch (CancellationException | ExecutionException e10) {
                    s1.b.p("MediaSessionLegacyStub", "Failed to load bitmap: " + e10.getMessage());
                    bitmap = null;
                }
            } else {
                k0 k0Var = new k0();
                k0Var.f5101y = this;
                k0Var.f5097u = j0VarB;
                k0Var.f5098v = str;
                k0Var.f5099w = uri3;
                k0Var.f5100x = duration;
                m0Var.f5123p = k0Var;
                Handler handler = b0Var.f4965l;
                Objects.requireNonNull(handler);
                yVarK.f(new ea.t(yVarK, 0, k0Var), new c2.c0(0, handler));
            }
            bitmap = null;
        } else {
            bitmap = null;
        }
        m0.E(m0Var.f5118k, l.b(j0VarB, str, uri3, duration, bitmap));
    }

    public void w(p1.f1 f1Var) {
        m0 m0Var = (m0) this.f5101y;
        b0 b0Var = m0Var.f5115g;
        j1 j1Var = b0Var.f4973t;
        if (!m0Var.f5129v.a(17) || !j1Var.w().a(17) || f1Var.p()) {
            m0.D(m0Var.f5118k, null);
            return;
        }
        int i = l.f5102a;
        ArrayList arrayList = new ArrayList();
        p1.e1 e1Var = new p1.e1();
        for (int i10 = 0; i10 < f1Var.o(); i10++) {
            arrayList.add(f1Var.m(i10, e1Var, 0L).f9715c);
        }
        ArrayList arrayList2 = new ArrayList();
        c2.w wVar = new c2.w(this, new AtomicInteger(0), arrayList, arrayList2, 3);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            byte[] bArr = ((p1.g0) arrayList.get(i11)).f9759d.f9844k;
            if (bArr == null) {
                arrayList2.add(null);
                wVar.run();
            } else {
                ea.y yVarK = b0Var.f4966m.K(bArr);
                arrayList2.add(yVarK);
                Handler handler = b0Var.f4965l;
                Objects.requireNonNull(handler);
                yVarK.f(wVar, new c2.c0(0, handler));
            }
        }
    }

    public void x(n3 n3Var) {
        this.f5097u = n3Var;
    }

    public boolean y(long j5, f3 f3Var) {
        x3 x3Var = (x3) this.f5101y;
        if (((ArrayList) this.f5099w) == null) {
            this.f5099w = new ArrayList();
        }
        if (((ArrayList) this.f5098v) == null) {
            this.f5098v = new ArrayList();
        }
        if (((ArrayList) this.f5099w).isEmpty() || ((((f3) ((ArrayList) this.f5099w).get(0)).z() / 1000) / 60) / 60 == ((f3Var.z() / 1000) / 60) / 60) {
            long jA = this.f5100x + ((long) f3Var.a(null));
            x3Var.S();
            if (jA < Math.max(0, ((Integer) k8.w.f7487j.a(null)).intValue())) {
                this.f5100x = jA;
                ((ArrayList) this.f5099w).add(f3Var);
                ((ArrayList) this.f5098v).add(Long.valueOf(j5));
                int size = ((ArrayList) this.f5099w).size();
                x3Var.S();
                if (size < Math.max(1, ((Integer) k8.w.f7490k.a(null)).intValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void z() {
        k8.z0 z0Var = (k8.z0) this.f5101y;
        z0Var.p1();
        ((k8.k1) z0Var.f2454v).H.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = z0Var.x1().edit();
        editorEdit.remove((String) this.f5097u);
        editorEdit.remove((String) this.f5099w);
        editorEdit.putLong((String) this.f5098v, jCurrentTimeMillis);
        editorEdit.apply();
    }

    @Override // g4.r
    public void h() {
    }

    @Override // g4.r
    public /* synthetic */ void g(int i) {
    }

    @Override // g4.r
    public /* synthetic */ void e(int i, m mVar) {
    }

    @Override // g4.r
    public /* synthetic */ void i(int i, q1 q1Var) {
    }

    @Override // g4.r
    public /* synthetic */ void k(int i, h1 h1Var, p1.s0 s0Var, boolean z2, boolean z10) {
    }
}
