package a2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class g implements w1 {
    public s1.w A;
    public int B;
    public o2.c1 C;
    public p1.q[] D;
    public long E;
    public long F;
    public boolean H;
    public boolean I;
    public o2.d0 K;
    public r2.p L;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f232v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a2 f234x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f235y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b2.o f236z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f231u = new Object();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final h4.z f233w = new h4.z(1, false);
    public long G = Long.MIN_VALUE;
    public p1.f1 J = p1.f1.f9741a;

    public g(int i) {
        this.f232v = i;
    }

    public abstract int A(p1.q qVar);

    public int B() {
        return 0;
    }

    public final q a(Throwable th, p1.q qVar, boolean z2, int i) {
        int iA;
        if (qVar == null || this.I) {
            iA = 4;
        } else {
            this.I = true;
            try {
                iA = A(qVar) & 7;
            } catch (q unused) {
                iA = 4;
            } finally {
                this.I = false;
            }
        }
        return new q(1, th, i, g(), this.f235y, qVar, qVar == null ? 4 : iA, this.K, z2);
    }

    public long d(long j5, long j8) {
        if (this.B == 1) {
            return (m() || l()) ? 1000000L : 10000L;
        }
        return 10000L;
    }

    public d1 f() {
        return null;
    }

    public abstract String g();

    public final boolean k() {
        return this.G == Long.MIN_VALUE;
    }

    public abstract boolean l();

    public abstract boolean m();

    public final boolean n() {
        if (k()) {
            return this.H;
        }
        o2.c1 c1Var = this.C;
        c1Var.getClass();
        return c1Var.j();
    }

    public abstract void o();

    public abstract void q(boolean z2, long j5);

    public final int w(h4.z zVar, DecoderInputBuffer decoderInputBuffer, int i) {
        o2.c1 c1Var = this.C;
        c1Var.getClass();
        int iE = c1Var.e(zVar, decoderInputBuffer, i);
        if (iE == -4) {
            if (decoderInputBuffer.isEndOfStream()) {
                this.G = Long.MIN_VALUE;
                return this.H ? -4 : -3;
            }
            long j5 = decoderInputBuffer.timeUs + this.E;
            decoderInputBuffer.timeUs = j5;
            this.G = Math.max(this.G, j5);
            return iE;
        }
        if (iE == -5) {
            p1.q qVar = (p1.q) zVar.f5868w;
            qVar.getClass();
            long j8 = qVar.f10028s;
            if (j8 != Long.MAX_VALUE) {
                p1.p pVarA = qVar.a();
                pVarA.f9972r = j8 + this.E;
                zVar.f5868w = new p1.q(pVarA);
            }
        }
        return iE;
    }

    public abstract void x(long j5, long j8);

    public final void y(p1.q[] qVarArr, o2.c1 c1Var, long j5, long j8, o2.d0 d0Var) {
        s1.d.g(!this.H);
        this.C = c1Var;
        this.K = d0Var;
        if (this.G == Long.MIN_VALUE) {
            this.G = j5;
        }
        this.D = qVarArr;
        this.E = j8;
        v(qVarArr, j5, j8, d0Var);
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

    @Override // a2.w1
    public void b(int i, Object obj) {
    }

    public void p(boolean z2, boolean z10) {
    }

    public void z(float f, float f4) {
    }

    public void v(p1.q[] qVarArr, long j5, long j8, o2.d0 d0Var) {
    }
}
