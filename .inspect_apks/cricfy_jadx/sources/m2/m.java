package m2;

import android.net.Uri;
import android.os.Looper;
import b2.h0;
import f9.a0;
import f9.b0;
import f9.z;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import s2.e1;
import ua.i0;
import v1.c0;
import v1.g0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends s2.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f8088h;
    public final l4.a i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z f8089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l2.n f8090k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a0 f8091l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f8092m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f8093n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final n2.c f8094o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f8095p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public v1.a0 f8096q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public h0 f8097r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public g0 f8098s;

    static {
        v1.h0.a("media3.exoplayer.hls");
    }

    public m(g0 g0Var, l4.a aVar, c cVar, z zVar, l2.n nVar, a0 a0Var, n2.c cVar2, long j4, boolean z10, int i) {
        this.f8098s = g0Var;
        this.f8096q = g0Var.f12698c;
        this.i = aVar;
        this.f8088h = cVar;
        this.f8089j = zVar;
        this.f8090k = nVar;
        this.f8091l = a0Var;
        this.f8094o = cVar2;
        this.f8095p = j4;
        this.f8092m = z10;
        this.f8093n = i;
    }

    public static n2.g u(long j4, List list) {
        n2.g gVar = null;
        for (int i = 0; i < list.size(); i++) {
            n2.g gVar2 = (n2.g) list.get(i);
            long j7 = gVar2.f8683z;
            if (j7 > j4 || !gVar2.G) {
                if (j7 > j4) {
                    break;
                }
            } else {
                gVar = gVar2;
            }
        }
        return gVar;
    }

    @Override // s2.a
    public final boolean a(g0 g0Var) {
        g0 g0VarI = i();
        c0 c0Var = g0VarI.f12697b;
        c0Var.getClass();
        c0 c0Var2 = g0Var.f12697b;
        return c0Var2 != null && c0Var2.f12605a.equals(c0Var.f12605a) && c0Var2.f12609e.equals(c0Var.f12609e) && Objects.equals(c0Var2.f12607c, c0Var.f12607c) && g0VarI.f12698c.equals(g0Var.f12698c);
    }

    @Override // s2.a
    public final s2.a0 c(s2.c0 c0Var, w2.e eVar, long j4) {
        f3.a aVarB = b(c0Var);
        l2.k kVar = new l2.k(this.f11150d.f7673c, 0, c0Var);
        h0 h0Var = this.f8097r;
        h2.l lVar = this.f11152g;
        y1.d.h(lVar);
        return new l(this.f8088h, this.f8094o, this.i, h0Var, this.f8090k, kVar, this.f8091l, aVarB, eVar, this.f8089j, this.f8092m, this.f8093n, lVar);
    }

    @Override // s2.a
    public final synchronized g0 i() {
        return this.f8098s;
    }

    @Override // s2.a
    public final void k() throws IOException {
        n2.c cVar = this.f8094o;
        w2.o oVar = cVar.B;
        if (oVar != null) {
            oVar.c();
        }
        Uri uri = cVar.F;
        if (uri != null) {
            n2.b bVar = (n2.b) cVar.f8640y.get(uri);
            bVar.f8633w.c();
            IOException iOException = bVar.E;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    @Override // s2.a
    public final void m(h0 h0Var) {
        this.f8097r = h0Var;
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        h2.l lVar = this.f11152g;
        y1.d.h(lVar);
        l2.n nVar = this.f8090k;
        nVar.k(looperMyLooper, lVar);
        nVar.b();
        f3.a aVarB = b(null);
        c0 c0Var = i().f12697b;
        c0Var.getClass();
        Uri uri = c0Var.f12605a;
        n2.c cVar = this.f8094o;
        cVar.getClass();
        cVar.C = y1.a0.n(null);
        cVar.A = aVarB;
        cVar.D = this;
        Map map = Collections.EMPTY_MAP;
        y1.d.i(uri, "The uri must be set.");
        w2.r rVar = new w2.r(((b2.g) cVar.f8637v.f7697v).h(), new b2.o(uri, 0L, 1, null, map, 0L, -1L, null, 1), 4, cVar.f8638w.m());
        y1.d.g(cVar.B == null);
        w2.o oVar = new w2.o("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        cVar.B = oVar;
        oVar.f(rVar, cVar, cVar.f8639x.m(rVar.f13889x));
    }

    @Override // s2.a
    public final void o(s2.a0 a0Var) {
        l lVar = (l) a0Var;
        lVar.f8084w.f8641z.remove(lVar);
        for (r rVar : lVar.O) {
            if (rVar.Y) {
                for (q qVar : rVar.Q) {
                    qVar.k();
                    l2.h hVar = qVar.f11379h;
                    if (hVar != null) {
                        hVar.c(qVar.f11377e);
                        qVar.f11379h = null;
                        qVar.f11378g = null;
                    }
                }
            }
            j jVar = rVar.f8132y;
            n2.b bVar = (n2.b) jVar.f8063g.f8640y.get(jVar.f8062e[jVar.f8073r.h()]);
            if (bVar != null) {
                bVar.F = false;
            }
            jVar.f8069n = null;
            rVar.E.e(rVar);
            rVar.M.removeCallbacksAndMessages(null);
            rVar.f8113c0 = true;
            rVar.N.clear();
        }
        lVar.L = null;
    }

    @Override // s2.a
    public final void q() {
        n2.c cVar = this.f8094o;
        cVar.F = null;
        cVar.G = null;
        cVar.E = null;
        cVar.I = -9223372036854775807L;
        cVar.B.e(null);
        cVar.B = null;
        HashMap map = cVar.f8640y;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((n2.b) it.next()).f8633w.e(null);
        }
        cVar.C.removeCallbacksAndMessages(null);
        cVar.C = null;
        map.clear();
        this.f8090k.release();
    }

    @Override // s2.a
    public final synchronized void t(g0 g0Var) {
        this.f8098s = g0Var;
    }

    public final void v(n2.l lVar) {
        long j4;
        e1 e1Var;
        long j7;
        long jO;
        long j10;
        boolean z10 = lVar.f8699p;
        boolean z11 = lVar.f8691g;
        i0 i0Var = lVar.f8701r;
        long j11 = lVar.f8704u;
        long jO2 = lVar.f8690e;
        int i = lVar.f8689d;
        long j12 = lVar.f8692h;
        long jB0 = z10 ? y1.a0.b0(j12) : -9223372036854775807L;
        long j13 = (i == 2 || i == 1) ? jB0 : -9223372036854775807L;
        n2.c cVar = this.f8094o;
        cVar.E.getClass();
        b0 b0Var = new b0(17);
        long j14 = 0;
        if (cVar.H) {
            n2.k kVar = lVar.f8705v;
            long j15 = j12 - cVar.I;
            boolean z12 = lVar.f8698o;
            long j16 = z12 ? j15 + j11 : -9223372036854775807L;
            long jO3 = lVar.f8699p ? y1.a0.O(y1.a0.y(this.f8095p)) - (j12 + j11) : 0L;
            long j17 = this.f8096q.f12571a;
            if (j17 != -9223372036854775807L) {
                jO = y1.a0.O(j17);
            } else {
                if (jO2 != -9223372036854775807L) {
                    j7 = j11 - jO2;
                } else {
                    j7 = kVar.f8687d;
                    if (j7 == -9223372036854775807L || lVar.f8697n == -9223372036854775807L) {
                        j7 = kVar.f8686c;
                        if (j7 == -9223372036854775807L) {
                            j7 = 3 * lVar.f8696m;
                        }
                    }
                }
                jO = j7 + jO3;
            }
            long j18 = j11 + jO3;
            long j19 = y1.a0.j(jO, jO3, j18);
            v1.a0 a0Var = i().f12698c;
            boolean z13 = a0Var.f12574d == -3.4028235E38f && a0Var.f12575e == -3.4028235E38f && kVar.f8686c == -9223372036854775807L && kVar.f8687d == -9223372036854775807L;
            k2.t tVar = new k2.t();
            tVar.f6892a = y1.a0.b0(j19);
            tVar.f6895d = z13 ? 1.0f : this.f8096q.f12574d;
            tVar.f6896e = z13 ? 1.0f : this.f8096q.f12575e;
            v1.a0 a0Var2 = new v1.a0(tVar);
            this.f8096q = a0Var2;
            if (jO2 == -9223372036854775807L) {
                jO2 = j18 - y1.a0.O(a0Var2.f12571a);
            }
            if (z11) {
                j14 = jO2;
            } else {
                n2.g gVarU = u(jO2, lVar.f8702s);
                if (gVarU != null) {
                    j10 = gVarU.f8683z;
                } else if (!i0Var.isEmpty()) {
                    n2.i iVar = (n2.i) i0Var.get(y1.a0.c(i0Var, Long.valueOf(jO2), true));
                    n2.g gVarU2 = u(jO2, iVar.H);
                    j10 = gVarU2 != null ? gVarU2.f8683z : iVar.f8683z;
                }
                j14 = j10;
            }
            e1Var = new e1(j13, jB0, j16, lVar.f8704u, j15, j14, true, !z12, i == 2 && lVar.f, b0Var, i(), this.f8096q);
        } else {
            if (jO2 == -9223372036854775807L || i0Var.isEmpty()) {
                j4 = 0;
            } else {
                if (!z11 && jO2 != j11) {
                    jO2 = ((n2.i) i0Var.get(y1.a0.c(i0Var, Long.valueOf(jO2), true))).f8683z;
                }
                j4 = jO2;
            }
            long j20 = lVar.f8704u;
            e1Var = new e1(j13, jB0, j20, j20, 0L, j4, true, false, true, b0Var, i(), null);
        }
        n(e1Var);
    }
}
