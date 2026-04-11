package f9;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a4 implements v3.g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f4008v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f4009w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f4010x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f4011y;

    public a4(int i, long j4) {
        y1.d.g(((w2.a) this.f4010x) == null);
        this.f4008v = j4;
        this.f4009w = j4 + ((long) i);
    }

    public boolean a(long j4, boolean z10, boolean z11) {
        b4 b4Var = (b4) this.f4011y;
        b4Var.m1();
        b4Var.n1();
        r1 r1Var = (r1) b4Var.f307w;
        boolean zA = r1Var.a();
        w0 w0Var = r1Var.A;
        if (zA) {
            f1 f1Var = r1Var.f4367z;
            r1.e(f1Var);
            e1 e1Var = f1Var.L;
            r1Var.F.getClass();
            e1Var.e(System.currentTimeMillis());
        }
        long j7 = j4 - this.f4008v;
        if (!z10 && j7 < 1000) {
            r1.g(w0Var);
            w0Var.J.b(Long.valueOf(j7), "Screen exposed for less than 1000 ms. Event not sent. time");
            return false;
        }
        if (!z11) {
            j7 = j4 - this.f4009w;
            this.f4009w = j4;
        }
        r1.g(w0Var);
        w0Var.J.b(Long.valueOf(j7), "Recording user engagement, ms");
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j7);
        boolean z12 = !r1Var.f4366y.A1();
        j3 j3Var = r1Var.G;
        r1.f(j3Var);
        u4.e2(j3Var.s1(z12), bundle, true);
        if (!z11) {
            x2 x2Var = r1Var.H;
            r1.f(x2Var);
            x2Var.t1("auto", "_e", bundle);
        }
        this.f4008v = j4;
        z3 z3Var = (z3) this.f4010x;
        z3Var.c();
        z3Var.b(((Long) f0.f4151r0.a(null)).longValue());
        return true;
    }

    @Override // v3.g
    public a3.c0 b() {
        y1.d.g(this.f4008v != -1);
        return new a3.u((a3.v) this.f4010x, this.f4008v, 0);
    }

    @Override // v3.g
    public long c(a3.q qVar) {
        long j4 = this.f4009w;
        if (j4 < 0) {
            return -1L;
        }
        long j7 = -(j4 + 2);
        this.f4009w = -1L;
        return j7;
    }

    @Override // v3.g
    public void d(long j4) {
        long[] jArr = (long[]) ((l4.c0) this.f4011y).f7705w;
        this.f4009w = jArr[y1.a0.e(jArr, j4, true)];
    }

    public a4(String str, byte[] bArr, long j4, long j7) {
        this.f4010x = str;
        this.f4011y = bArr;
        this.f4008v = j4;
        this.f4009w = j7;
    }
}
