package g2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e implements k1 {
    public h2.l A;
    public y1.v B;
    public int C;
    public s2.a1 D;
    public v1.p[] E;
    public long F;
    public long G;
    public boolean I;
    public boolean J;
    public s2.c0 L;
    public v2.o M;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f4658w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public o1 f4660y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f4661z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f4657v = new Object();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l4.c0 f4659x = new l4.c0(22, false);
    public long H = Long.MIN_VALUE;
    public v1.f1 K = v1.f1.f12674a;

    public e(int i) {
        this.f4658w = i;
    }

    public abstract int A(v1.p pVar);

    public int B() {
        return 0;
    }

    public final n a(Throwable th, v1.p pVar, boolean z10, int i) {
        int iA;
        if (pVar == null || this.J) {
            iA = 4;
        } else {
            this.J = true;
            try {
                iA = A(pVar) & 7;
            } catch (n unused) {
                iA = 4;
            } finally {
                this.J = false;
            }
        }
        return new n(1, th, i, j(), this.f4661z, pVar, pVar == null ? 4 : iA, this.L, z10);
    }

    public long e(long j4, long j7) {
        if (this.C == 1) {
            return (m() || l()) ? 1000000L : 10000L;
        }
        return 10000L;
    }

    public t0 i() {
        return null;
    }

    public abstract String j();

    public final boolean k() {
        return this.H == Long.MIN_VALUE;
    }

    public abstract boolean l();

    public abstract boolean m();

    public final boolean n() {
        if (k()) {
            return this.I;
        }
        s2.a1 a1Var = this.D;
        a1Var.getClass();
        return a1Var.b();
    }

    public abstract void o();

    public abstract void q(boolean z10, long j4);

    public final int w(l4.c0 c0Var, DecoderInputBuffer decoderInputBuffer, int i) {
        s2.a1 a1Var = this.D;
        a1Var.getClass();
        int iP = a1Var.p(c0Var, decoderInputBuffer, i);
        if (iP == -4) {
            if (decoderInputBuffer.isEndOfStream()) {
                this.H = Long.MIN_VALUE;
                return this.I ? -4 : -3;
            }
            long j4 = decoderInputBuffer.timeUs + this.F;
            decoderInputBuffer.timeUs = j4;
            this.H = Math.max(this.H, j4);
            return iP;
        }
        if (iP == -5) {
            v1.p pVar = (v1.p) c0Var.f7706x;
            pVar.getClass();
            long j7 = pVar.f12951s;
            if (j7 != Long.MAX_VALUE) {
                v1.o oVarA = pVar.a();
                oVarA.f12898r = j7 + this.F;
                c0Var.f7706x = new v1.p(oVarA);
            }
        }
        return iP;
    }

    public abstract void x(long j4, long j7);

    public final void y(v1.p[] pVarArr, s2.a1 a1Var, long j4, long j7, s2.c0 c0Var) {
        y1.d.g(!this.I);
        this.D = a1Var;
        this.L = c0Var;
        if (this.H == Long.MIN_VALUE) {
            this.H = j4;
        }
        this.E = pVarArr;
        this.F = j7;
        v(pVarArr, j4, j7, c0Var);
    }

    public void c() {
    }

    public void r() {
    }

    public void s() {
    }

    public void t() {
    }

    public void u() {
    }

    @Override // g2.k1
    public void b(int i, Object obj) {
    }

    public void p(boolean z10, boolean z11) {
    }

    public void z(float f, float f10) {
    }

    public void v(v1.p[] pVarArr, long j4, long j7, s2.c0 c0Var) {
    }
}
