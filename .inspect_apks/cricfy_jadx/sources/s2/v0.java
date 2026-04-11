package s2;

import android.net.Uri;
import android.os.Looper;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 extends a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b2.g f11339h;
    public final kb.d i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l2.n f11340j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f9.a0 f11341k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f11342l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final v1.p f11343m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11344n = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f11345o = -9223372036854775807L;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f11346p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f11347q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b2.h0 f11348r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public v1.g0 f11349s;

    public v0(v1.g0 g0Var, b2.g gVar, kb.d dVar, l2.n nVar, f9.a0 a0Var, int i, v1.p pVar) {
        this.f11349s = g0Var;
        this.f11339h = gVar;
        this.i = dVar;
        this.f11340j = nVar;
        this.f11341k = a0Var;
        this.f11342l = i;
        this.f11343m = pVar;
    }

    @Override // s2.a
    public final boolean a(v1.g0 g0Var) {
        v1.c0 c0Var = i().f12697b;
        c0Var.getClass();
        v1.c0 c0Var2 = g0Var.f12697b;
        return c0Var2 != null && c0Var2.f12605a.equals(c0Var.f12605a) && c0Var2.f12611h == c0Var.f12611h && Objects.equals(c0Var2.f, c0Var.f);
    }

    @Override // s2.a
    public final a0 c(c0 c0Var, w2.e eVar, long j4) {
        b2.h hVarH = this.f11339h.h();
        b2.h0 h0Var = this.f11348r;
        if (h0Var != null) {
            hVarH.d(h0Var);
        }
        v1.c0 c0Var2 = i().f12697b;
        c0Var2.getClass();
        Uri uri = c0Var2.f12605a;
        y1.d.h(this.f11152g);
        return new s0(uri, hVarH, new l7.a((a3.s) this.i.f7399w), this.f11340j, new l2.k(this.f11150d.f7673c, 0, c0Var), this.f11341k, b(c0Var), this, eVar, c0Var2.f, this.f11342l, this.f11343m, y1.a0.O(c0Var2.f12611h), null);
    }

    @Override // s2.a
    public final synchronized v1.g0 i() {
        return this.f11349s;
    }

    @Override // s2.a
    public final void m(b2.h0 h0Var) {
        this.f11348r = h0Var;
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        h2.l lVar = this.f11152g;
        y1.d.h(lVar);
        l2.n nVar = this.f11340j;
        nVar.k(looperMyLooper, lVar);
        nVar.b();
        u();
    }

    @Override // s2.a
    public final void o(a0 a0Var) {
        s0 s0Var = (s0) a0Var;
        if (s0Var.S) {
            for (z0 z0Var : s0Var.P) {
                z0Var.k();
                l2.h hVar = z0Var.f11379h;
                if (hVar != null) {
                    hVar.c(z0Var.f11377e);
                    z0Var.f11379h = null;
                    z0Var.f11378g = null;
                }
            }
        }
        s0Var.H.e(s0Var);
        s0Var.M.removeCallbacksAndMessages(null);
        s0Var.N = null;
        s0Var.f11319k0 = true;
    }

    @Override // s2.a
    public final void q() {
        this.f11340j.release();
    }

    @Override // s2.a
    public final synchronized void t(v1.g0 g0Var) {
        this.f11349s = g0Var;
    }

    public final void u() {
        long j4 = this.f11345o;
        boolean z10 = this.f11346p;
        boolean z11 = this.f11347q;
        v1.g0 g0VarI = i();
        v1.f1 e1Var = new e1(-9223372036854775807L, -9223372036854775807L, j4, j4, 0L, 0L, z10, false, false, null, g0VarI, z11 ? g0VarI.f12698c : null);
        if (this.f11344n) {
            e1Var = new t0(e1Var);
        }
        n(e1Var);
    }

    public final void v(long j4, a3.c0 c0Var, boolean z10) {
        if (j4 == -9223372036854775807L) {
            j4 = this.f11345o;
        }
        boolean zG = c0Var.g();
        if (!this.f11344n && this.f11345o == j4 && this.f11346p == zG && this.f11347q == z10) {
            return;
        }
        this.f11345o = j4;
        this.f11346p = zG;
        this.f11347q = z10;
        this.f11344n = false;
        u();
    }

    @Override // s2.a
    public final void k() {
    }
}
