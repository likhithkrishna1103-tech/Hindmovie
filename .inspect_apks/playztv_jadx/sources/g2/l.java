package g2;

import aa.j0;
import aa.l0;
import android.net.Uri;
import android.os.Looper;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import k8.a0;
import k8.c0;
import o2.d0;
import o2.g1;
import p1.b0;
import p1.g0;
import p1.h0;
import v1.e0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends o2.a {
    public final c B;
    public final wb.c C;
    public final c0 D;
    public final f2.n E;
    public final a0 F;
    public final boolean G;
    public final int H;
    public final h2.c I;
    public final long J;
    public b0 K;
    public e0 L;
    public g0 M;

    static {
        h0.a("media3.exoplayer.hls");
    }

    public l(g0 g0Var, wb.c cVar, c cVar2, c0 c0Var, f2.n nVar, a0 a0Var, h2.c cVar3, long j5, boolean z2, int i) {
        this.M = g0Var;
        this.K = g0Var.f9758c;
        this.C = cVar;
        this.B = cVar2;
        this.D = c0Var;
        this.E = nVar;
        this.F = a0Var;
        this.I = cVar3;
        this.J = j5;
        this.G = z2;
        this.H = i;
    }

    public static h2.g y(long j5, List list) {
        h2.g gVar = null;
        for (int i = 0; i < list.size(); i++) {
            h2.g gVar2 = (h2.g) list.get(i);
            long j8 = gVar2.f5707y;
            if (j8 > j5 || !gVar2.F) {
                if (j8 > j5) {
                    break;
                }
            } else {
                gVar = gVar2;
            }
        }
        return gVar;
    }

    @Override // o2.a
    public final boolean a(g0 g0Var) {
        g0 g0VarJ = j();
        p1.c0 c0Var = g0VarJ.f9757b;
        c0Var.getClass();
        p1.c0 c0Var2 = g0Var.f9757b;
        return c0Var2 != null && c0Var2.f9665a.equals(c0Var.f9665a) && c0Var2.f9669e.equals(c0Var.f9669e) && Objects.equals(c0Var2.f9667c, c0Var.f9667c) && g0VarJ.f9758c.equals(g0Var.f9758c);
    }

    @Override // o2.a
    public final o2.b0 c(d0 d0Var, s2.e eVar, long j5) {
        l0 l0VarB = b(d0Var);
        f2.k kVar = new f2.k(this.f9054x.f4741c, 0, d0Var);
        e0 e0Var = this.L;
        b2.o oVar = this.A;
        s1.d.h(oVar);
        return new k(this.B, this.I, this.C, e0Var, this.E, kVar, this.F, l0VarB, eVar, this.D, this.G, this.H, oVar);
    }

    @Override // o2.a
    public final synchronized g0 j() {
        return this.M;
    }

    @Override // o2.a
    public final void n() throws IOException {
        h2.c cVar = this.I;
        s2.m mVar = cVar.A;
        if (mVar != null) {
            mVar.b();
        }
        Uri uri = cVar.E;
        if (uri != null) {
            h2.b bVar = (h2.b) cVar.f5663x.get(uri);
            bVar.f5655v.b();
            IOException iOException = bVar.D;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    @Override // o2.a
    public final void p(e0 e0Var) {
        this.L = e0Var;
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        b2.o oVar = this.A;
        s1.d.h(oVar);
        f2.n nVar = this.E;
        nVar.g(looperMyLooper, oVar);
        nVar.d();
        l0 l0VarB = b(null);
        p1.c0 c0Var = j().f9757b;
        c0Var.getClass();
        Uri uri = c0Var.f9665a;
        h2.c cVar = this.I;
        cVar.getClass();
        cVar.B = s1.b0.n(null);
        cVar.f5665z = l0VarB;
        cVar.C = this;
        Map map = Collections.EMPTY_MAP;
        s1.d.i(uri, "The uri must be set.");
        s2.p pVar = new s2.p(((v1.g) cVar.f5660u.f14088v).g(), new v1.m(uri, 0L, 1, null, map, 0L, -1L, null, 1), 4, cVar.f5661v.x());
        s1.d.g(cVar.A == null);
        s2.m mVar = new s2.m("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        cVar.A = mVar;
        mVar.f(pVar, cVar, cVar.f5662w.k(pVar.f11772w));
    }

    @Override // o2.a
    public final void r(o2.b0 b0Var) {
        k kVar = (k) b0Var;
        kVar.f4889v.f5664y.remove(kVar);
        for (q qVar : kVar.N) {
            if (qVar.X) {
                for (p pVar : qVar.P) {
                    pVar.k();
                    f2.h hVar = pVar.f9063h;
                    if (hVar != null) {
                        hVar.c(pVar.f9061e);
                        pVar.f9063h = null;
                        pVar.f9062g = null;
                    }
                }
            }
            i iVar = qVar.f4926x;
            h2.b bVar = (h2.b) iVar.f4869g.f5663x.get(iVar.f4868e[iVar.f4879r.j()]);
            if (bVar != null) {
                bVar.E = false;
            }
            iVar.f4875n = null;
            qVar.D.e(qVar);
            qVar.L.removeCallbacksAndMessages(null);
            qVar.f4907b0 = true;
            qVar.M.clear();
        }
        kVar.K = null;
    }

    @Override // o2.a
    public final void t() {
        h2.c cVar = this.I;
        cVar.E = null;
        cVar.F = null;
        cVar.D = null;
        cVar.H = -9223372036854775807L;
        cVar.A.e(null);
        cVar.A = null;
        HashMap map = cVar.f5663x;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((h2.b) it.next()).f5655v.e(null);
        }
        cVar.B.removeCallbacksAndMessages(null);
        cVar.B = null;
        map.clear();
        this.E.release();
    }

    @Override // o2.a
    public final synchronized void x(g0 g0Var) {
        this.M = g0Var;
    }

    public final void z(h2.l lVar) {
        long j5;
        g1 g1Var;
        long j8;
        long jO;
        long j10;
        boolean z2 = lVar.f5724p;
        boolean z10 = lVar.f5716g;
        j0 j0Var = lVar.f5726r;
        long j11 = lVar.f5729u;
        long jO2 = lVar.f5715e;
        int i = lVar.f5714d;
        long j12 = lVar.f5717h;
        long jB0 = z2 ? s1.b0.b0(j12) : -9223372036854775807L;
        long j13 = (i == 2 || i == 1) ? jB0 : -9223372036854775807L;
        h2.c cVar = this.I;
        cVar.D.getClass();
        pa.b bVar = new pa.b(12);
        long j14 = 0;
        if (cVar.G) {
            h2.k kVar = lVar.f5730v;
            long j15 = j12 - cVar.H;
            boolean z11 = lVar.f5723o;
            long j16 = z11 ? j15 + j11 : -9223372036854775807L;
            long jO3 = lVar.f5724p ? s1.b0.O(s1.b0.y(this.J)) - (j12 + j11) : 0L;
            long j17 = this.K.f9653a;
            if (j17 != -9223372036854775807L) {
                jO = s1.b0.O(j17);
            } else {
                if (jO2 != -9223372036854775807L) {
                    j8 = j11 - jO2;
                } else {
                    j8 = kVar.f5712d;
                    if (j8 == -9223372036854775807L || lVar.f5722n == -9223372036854775807L) {
                        j8 = kVar.f5711c;
                        if (j8 == -9223372036854775807L) {
                            j8 = 3 * lVar.f5721m;
                        }
                    }
                }
                jO = j8 + jO3;
            }
            long j18 = j11 + jO3;
            long j19 = s1.b0.j(jO, jO3, j18);
            b0 b0Var = j().f9758c;
            boolean z12 = b0Var.f9656d == -3.4028235E38f && b0Var.f9657e == -3.4028235E38f && kVar.f5711c == -9223372036854775807L && kVar.f5712d == -9223372036854775807L;
            e2.t tVar = new e2.t();
            tVar.f4363a = s1.b0.b0(j19);
            tVar.f4366d = z12 ? 1.0f : this.K.f9656d;
            tVar.f4367e = z12 ? 1.0f : this.K.f9657e;
            b0 b0Var2 = new b0(tVar);
            this.K = b0Var2;
            if (jO2 == -9223372036854775807L) {
                jO2 = j18 - s1.b0.O(b0Var2.f9653a);
            }
            if (z10) {
                j14 = jO2;
            } else {
                h2.g gVarY = y(jO2, lVar.f5727s);
                if (gVarY != null) {
                    j10 = gVarY.f5707y;
                } else if (!j0Var.isEmpty()) {
                    h2.i iVar = (h2.i) j0Var.get(s1.b0.c(j0Var, Long.valueOf(jO2), true));
                    h2.g gVarY2 = y(jO2, iVar.G);
                    j10 = gVarY2 != null ? gVarY2.f5707y : iVar.f5707y;
                }
                j14 = j10;
            }
            g1Var = new g1(j13, jB0, j16, lVar.f5729u, j15, j14, true, !z11, i == 2 && lVar.f, bVar, j(), this.K);
        } else {
            if (jO2 == -9223372036854775807L || j0Var.isEmpty()) {
                j5 = 0;
            } else {
                if (!z10 && jO2 != j11) {
                    jO2 = ((h2.i) j0Var.get(s1.b0.c(j0Var, Long.valueOf(jO2), true))).f5707y;
                }
                j5 = jO2;
            }
            long j20 = lVar.f5729u;
            g1Var = new g1(j13, jB0, j20, j20, 0L, j5, true, false, true, bVar, j(), null);
        }
        q(g1Var);
    }
}
