package m2;

import aa.l0;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.manager.s;
import e4.f;
import f2.k;
import f2.n;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import k8.a0;
import k8.c0;
import o2.d0;
import o2.g1;
import o2.u;
import p1.g0;
import p1.h0;
import p1.n0;
import p2.i;
import s1.b0;
import s1.d;
import s2.e;
import s2.h;
import s2.j;
import s2.l;
import s2.m;
import s2.o;
import s2.p;
import v1.e0;
import v1.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends o2.a implements h {
    public final boolean B;
    public final Uri C;
    public final g D;
    public final s E;
    public final c0 F;
    public final n G;
    public final a0 H;
    public final long I;
    public final l0 J;
    public final o K;
    public final ArrayList L;
    public v1.h M;
    public m N;
    public s2.n O;
    public e0 P;
    public long Q;
    public n2.c R;
    public Handler S;
    public g0 T;

    static {
        h0.a("media3.exoplayer.smoothstreaming");
    }

    public c(g0 g0Var, g gVar, o oVar, s sVar, c0 c0Var, n nVar, a0 a0Var, long j5) {
        this.T = g0Var;
        p1.c0 c0Var2 = g0Var.f9757b;
        c0Var2.getClass();
        Uri uriWithAppendedPath = c0Var2.f9665a;
        this.R = null;
        if (uriWithAppendedPath.equals(Uri.EMPTY)) {
            uriWithAppendedPath = null;
        } else {
            int i = b0.f11647a;
            String path = uriWithAppendedPath.getPath();
            if (path != null) {
                Matcher matcher = b0.f11653h.matcher(path);
                if (matcher.matches() && matcher.group(1) == null) {
                    uriWithAppendedPath = Uri.withAppendedPath(uriWithAppendedPath, "Manifest");
                }
            }
        }
        this.C = uriWithAppendedPath;
        this.D = gVar;
        this.K = oVar;
        this.E = sVar;
        this.F = c0Var;
        this.G = nVar;
        this.H = a0Var;
        this.I = j5;
        this.J = b(null);
        this.B = false;
        this.L = new ArrayList();
    }

    @Override // o2.a
    public final boolean a(g0 g0Var) {
        p1.c0 c0Var = j().f9757b;
        c0Var.getClass();
        p1.c0 c0Var2 = g0Var.f9757b;
        return c0Var2 != null && c0Var2.f9665a.equals(c0Var.f9665a) && c0Var2.f9669e.equals(c0Var.f9669e) && Objects.equals(c0Var2.f9667c, c0Var.f9667c);
    }

    @Override // o2.a
    public final o2.b0 c(d0 d0Var, e eVar, long j5) {
        l0 l0VarB = b(d0Var);
        k kVar = new k(this.f9054x.f4741c, 0, d0Var);
        b bVar = new b(this.R, this.E, this.P, this.F, this.G, kVar, this.H, l0VarB, this.O, eVar);
        this.L.add(bVar);
        return bVar;
    }

    @Override // s2.h
    public final void d(j jVar, long j5, long j8) {
        p pVar = (p) jVar;
        long j10 = pVar.f11770u;
        Uri uri = pVar.f11773x.f13128w;
        u uVar = new u(j8);
        this.H.getClass();
        this.J.n(uVar, pVar.f11772w);
        this.R = (n2.c) pVar.f11775z;
        this.Q = j5 - j8;
        y();
        if (this.R.f8658d) {
            this.S.postDelayed(new a2.a(29, this), Math.max(0L, (this.Q + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    @Override // o2.a
    public final synchronized g0 j() {
        return this.T;
    }

    @Override // s2.h
    public final void k(j jVar, long j5, long j8, int i) {
        u uVar;
        p pVar = (p) jVar;
        if (i == 0) {
            long j10 = pVar.f11770u;
            uVar = new u(pVar.f11771v);
        } else {
            long j11 = pVar.f11770u;
            Uri uri = pVar.f11773x.f13128w;
            uVar = new u(j8);
        }
        u uVar2 = uVar;
        this.J.t(uVar2, pVar.f11772w, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, i);
    }

    @Override // s2.h
    public final f m(j jVar, long j5, long j8, IOException iOException, int i) {
        long jMin;
        p pVar = (p) jVar;
        long j10 = pVar.f11770u;
        Uri uri = pVar.f11773x.f13128w;
        u uVar = new u(j8);
        int i10 = pVar.f11772w;
        this.H.getClass();
        if ((iOException instanceof n0) || (iOException instanceof FileNotFoundException) || (iOException instanceof v1.u) || (iOException instanceof l)) {
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
        f fVar = jMin == -9223372036854775807L ? m.f11766z : new f(0, jMin, false);
        this.J.r(uVar, i10, iOException, !fVar.a());
        return fVar;
    }

    @Override // o2.a
    public final void n() {
        this.O.b();
    }

    @Override // o2.a
    public final void p(e0 e0Var) {
        this.P = e0Var;
        Looper looperMyLooper = Looper.myLooper();
        b2.o oVar = this.A;
        d.h(oVar);
        n nVar = this.G;
        nVar.g(looperMyLooper, oVar);
        nVar.d();
        if (this.B) {
            this.O = new k8.b0(25);
            y();
            return;
        }
        this.M = this.D.g();
        m mVar = new m("SsMediaSource");
        this.N = mVar;
        this.O = mVar;
        this.S = b0.n(null);
        z();
    }

    @Override // o2.a
    public final void r(o2.b0 b0Var) {
        b bVar = (b) b0Var;
        for (i iVar : bVar.G) {
            iVar.C(null);
        }
        bVar.E = null;
        this.L.remove(b0Var);
    }

    @Override // o2.a
    public final void t() {
        this.R = this.B ? this.R : null;
        this.M = null;
        this.Q = 0L;
        m mVar = this.N;
        if (mVar != null) {
            mVar.e(null);
            this.N = null;
        }
        Handler handler = this.S;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.S = null;
        }
        this.G.release();
    }

    @Override // s2.h
    public final void u(j jVar, long j5, long j8, boolean z2) {
        p pVar = (p) jVar;
        long j10 = pVar.f11770u;
        Uri uri = pVar.f11773x.f13128w;
        u uVar = new u(j8);
        this.H.getClass();
        this.J.m(uVar, pVar.f11772w, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    @Override // o2.a
    public final synchronized void x(g0 g0Var) {
        this.T = g0Var;
    }

    public final void y() {
        g1 g1Var;
        char c9;
        n2.b[] bVarArr;
        char c10 = 0;
        int i = 0;
        while (true) {
            ArrayList arrayList = this.L;
            if (i >= arrayList.size()) {
                break;
            }
            b bVar = (b) arrayList.get(i);
            n2.c cVar = this.R;
            bVar.F = cVar;
            for (i iVar : bVar.G) {
                a aVar = (a) iVar.f10158y;
                n2.b[] bVarArr2 = aVar.f.f;
                int i10 = aVar.f8290b;
                n2.b bVar2 = bVarArr2[i10];
                int i11 = bVar2.f8649k;
                long[] jArr = bVar2.f8653o;
                n2.b bVar3 = cVar.f[i10];
                if (i11 == 0 || bVar3.f8649k == 0) {
                    aVar.f8294g += i11;
                } else {
                    int i12 = i11 - 1;
                    long jB = bVar2.b(i12) + jArr[i12];
                    long j5 = bVar3.f8653o[0];
                    if (jB <= j5) {
                        aVar.f8294g += i11;
                    } else {
                        aVar.f8294g = b0.e(jArr, j5, true) + aVar.f8294g;
                    }
                }
                aVar.f = cVar;
            }
            o2.a0 a0Var = bVar.E;
            a0Var.getClass();
            a0Var.d(bVar);
            i++;
        }
        n2.b[] bVarArr3 = this.R.f;
        int length = bVarArr3.length;
        long jMax = Long.MIN_VALUE;
        int i13 = 0;
        long jMax2 = Long.MAX_VALUE;
        while (i13 < length) {
            n2.b bVar4 = bVarArr3[i13];
            int i14 = bVar4.f8649k;
            long[] jArr2 = bVar4.f8653o;
            if (i14 > 0) {
                c9 = c10;
                bVarArr = bVarArr3;
                jMax2 = Math.min(jMax2, jArr2[c9]);
                int i15 = bVar4.f8649k - 1;
                jMax = Math.max(jMax, bVar4.b(i15) + jArr2[i15]);
            } else {
                c9 = c10;
                bVarArr = bVarArr3;
            }
            i13++;
            c10 = c9;
            bVarArr3 = bVarArr;
        }
        if (jMax2 == Long.MAX_VALUE) {
            long j8 = this.R.f8658d ? -9223372036854775807L : 0L;
            n2.c cVar2 = this.R;
            boolean z2 = cVar2.f8658d;
            g1Var = new g1(j8, 0L, 0L, 0L, true, z2, z2, cVar2, j());
        } else {
            n2.c cVar3 = this.R;
            if (cVar3.f8658d) {
                long j10 = cVar3.f8661h;
                if (j10 != -9223372036854775807L && j10 > 0) {
                    jMax2 = Math.max(jMax2, jMax - j10);
                }
                long j11 = jMax2;
                long j12 = jMax - j11;
                long jO = j12 - b0.O(this.I);
                if (jO < 5000000) {
                    jO = Math.min(5000000L, j12 / 2);
                }
                g1Var = new g1(-9223372036854775807L, j12, j11, jO, true, true, true, this.R, j());
            } else {
                long j13 = cVar3.f8660g;
                if (j13 == -9223372036854775807L) {
                    j13 = jMax - jMax2;
                }
                long j14 = j13;
                long j15 = jMax2;
                g1Var = new g1(-9223372036854775807L, -9223372036854775807L, j15 + j14, j14, j15, 0L, true, false, false, this.R, j(), null);
            }
        }
        q(g1Var);
    }

    public final void z() {
        if (this.N.c()) {
            return;
        }
        Map map = Collections.EMPTY_MAP;
        Uri uri = this.C;
        d.i(uri, "The uri must be set.");
        p pVar = new p(this.M, new v1.m(uri, 0L, 1, null, map, 0L, -1L, null, 1), 4, this.K);
        this.N.f(pVar, this, this.H.k(pVar.f11772w));
    }
}
