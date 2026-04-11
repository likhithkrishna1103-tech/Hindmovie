package k8;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o3 implements r3.g {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f7356u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f7357v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f7358w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f7359x;

    public o3(int i, long j5) {
        s1.d.g(((s2.a) this.f7358w) == null);
        this.f7356u = j5;
        this.f7357v = j5 + ((long) i);
    }

    public boolean a(long j5, boolean z2, boolean z10) {
        p3 p3Var = (p3) this.f7358w;
        k3 k3Var = (k3) this.f7359x;
        k3Var.p1();
        k3Var.t1();
        k1 k1Var = (k1) k3Var.f2454v;
        if (k1Var.h()) {
            a2.e2 e2Var = k3Var.n1().L;
            k1Var.H.getClass();
            e2Var.d(System.currentTimeMillis());
        }
        long j8 = j5 - this.f7356u;
        if (!z2 && j8 < 1000) {
            k3Var.g().I.c(Long.valueOf(j8), "Screen exposed for less than 1000 ms. Event not sent. time");
            return false;
        }
        if (!z10) {
            j8 = j5 - this.f7357v;
            this.f7357v = j5;
        }
        k3Var.g().I.c(Long.valueOf(j8), "Recording user engagement, ms");
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j8);
        h4.S1(k3Var.r1().x1(!k1Var.A.C1()), bundle, true);
        if (!z10) {
            k3Var.q1().T1("auto", "_e", bundle);
        }
        this.f7356u = j5;
        p3Var.a();
        p3Var.b(((Long) w.f7472d0.a(null)).longValue());
        return true;
    }

    @Override // r3.g
    public w2.b0 c() {
        s1.d.g(this.f7356u != -1);
        return new w2.t(0, this.f7356u, (w2.u) this.f7358w);
    }

    @Override // r3.g
    public long d(w2.p pVar) {
        long j5 = this.f7357v;
        if (j5 < 0) {
            return -1L;
        }
        long j8 = -(j5 + 2);
        this.f7357v = -1L;
        return j8;
    }

    @Override // r3.g
    public void f(long j5) {
        long[] jArr = (long[]) ((p2.c) this.f7359x).f10130v;
        this.f7357v = jArr[s1.b0.e(jArr, j5, true)];
    }

    public o3(String str, byte[] bArr, long j5, long j8) {
        this.f7358w = str;
        this.f7359x = bArr;
        this.f7356u = j5;
        this.f7357v = j8;
    }
}
