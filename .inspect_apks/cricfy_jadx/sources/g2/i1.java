package g2;

import android.os.SystemClock;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final s2.c0 f4749u = new s2.c0(new Object());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v1.f1 f4750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s2.c0 f4751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4754e;
    public final n f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f4755g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final s2.l1 f4756h;
    public final v2.u i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f4757j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final s2.c0 f4758k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f4759l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f4760m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f4761n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final v1.q0 f4762o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f4763p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile long f4764q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile long f4765r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile long f4766s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile long f4767t;

    public i1(v1.f1 f1Var, s2.c0 c0Var, long j4, long j7, int i, n nVar, boolean z10, s2.l1 l1Var, v2.u uVar, List list, s2.c0 c0Var2, boolean z11, int i10, int i11, v1.q0 q0Var, long j10, long j11, long j12, long j13, boolean z12) {
        this.f4750a = f1Var;
        this.f4751b = c0Var;
        this.f4752c = j4;
        this.f4753d = j7;
        this.f4754e = i;
        this.f = nVar;
        this.f4755g = z10;
        this.f4756h = l1Var;
        this.i = uVar;
        this.f4757j = list;
        this.f4758k = c0Var2;
        this.f4759l = z11;
        this.f4760m = i10;
        this.f4761n = i11;
        this.f4762o = q0Var;
        this.f4764q = j10;
        this.f4765r = j11;
        this.f4766s = j12;
        this.f4767t = j13;
        this.f4763p = z12;
    }

    public static i1 k(v2.u uVar) {
        v1.b1 b1Var = v1.f1.f12674a;
        s2.l1 l1Var = s2.l1.f11260d;
        ua.z0 z0Var = ua.z0.f12413z;
        v1.q0 q0Var = v1.q0.f12966d;
        s2.c0 c0Var = f4749u;
        return new i1(b1Var, c0Var, -9223372036854775807L, 0L, 1, null, false, l1Var, uVar, z0Var, c0Var, false, 1, 0, q0Var, 0L, 0L, 0L, 0L, false);
    }

    public final i1 a() {
        return new i1(this.f4750a, this.f4751b, this.f4752c, this.f4753d, this.f4754e, this.f, this.f4755g, this.f4756h, this.i, this.f4757j, this.f4758k, this.f4759l, this.f4760m, this.f4761n, this.f4762o, this.f4764q, this.f4765r, l(), SystemClock.elapsedRealtime(), this.f4763p);
    }

    public final i1 b(boolean z10) {
        return new i1(this.f4750a, this.f4751b, this.f4752c, this.f4753d, this.f4754e, this.f, z10, this.f4756h, this.i, this.f4757j, this.f4758k, this.f4759l, this.f4760m, this.f4761n, this.f4762o, this.f4764q, this.f4765r, this.f4766s, this.f4767t, this.f4763p);
    }

    public final i1 c(s2.c0 c0Var) {
        return new i1(this.f4750a, this.f4751b, this.f4752c, this.f4753d, this.f4754e, this.f, this.f4755g, this.f4756h, this.i, this.f4757j, c0Var, this.f4759l, this.f4760m, this.f4761n, this.f4762o, this.f4764q, this.f4765r, this.f4766s, this.f4767t, this.f4763p);
    }

    public final i1 d(s2.c0 c0Var, long j4, long j7, long j10, long j11, s2.l1 l1Var, v2.u uVar, List list) {
        return new i1(this.f4750a, c0Var, j7, j10, this.f4754e, this.f, this.f4755g, l1Var, uVar, list, this.f4758k, this.f4759l, this.f4760m, this.f4761n, this.f4762o, this.f4764q, j11, j4, SystemClock.elapsedRealtime(), this.f4763p);
    }

    public final i1 e(int i, int i10, boolean z10) {
        return new i1(this.f4750a, this.f4751b, this.f4752c, this.f4753d, this.f4754e, this.f, this.f4755g, this.f4756h, this.i, this.f4757j, this.f4758k, z10, i, i10, this.f4762o, this.f4764q, this.f4765r, this.f4766s, this.f4767t, this.f4763p);
    }

    public final i1 f(n nVar) {
        return new i1(this.f4750a, this.f4751b, this.f4752c, this.f4753d, this.f4754e, nVar, this.f4755g, this.f4756h, this.i, this.f4757j, this.f4758k, this.f4759l, this.f4760m, this.f4761n, this.f4762o, this.f4764q, this.f4765r, this.f4766s, this.f4767t, this.f4763p);
    }

    public final i1 g(v1.q0 q0Var) {
        return new i1(this.f4750a, this.f4751b, this.f4752c, this.f4753d, this.f4754e, this.f, this.f4755g, this.f4756h, this.i, this.f4757j, this.f4758k, this.f4759l, this.f4760m, this.f4761n, q0Var, this.f4764q, this.f4765r, this.f4766s, this.f4767t, this.f4763p);
    }

    public final i1 h(int i) {
        return new i1(this.f4750a, this.f4751b, this.f4752c, this.f4753d, i, this.f, this.f4755g, this.f4756h, this.i, this.f4757j, this.f4758k, this.f4759l, this.f4760m, this.f4761n, this.f4762o, this.f4764q, this.f4765r, this.f4766s, this.f4767t, this.f4763p);
    }

    public final i1 i(boolean z10) {
        return new i1(this.f4750a, this.f4751b, this.f4752c, this.f4753d, this.f4754e, this.f, this.f4755g, this.f4756h, this.i, this.f4757j, this.f4758k, this.f4759l, this.f4760m, this.f4761n, this.f4762o, this.f4764q, this.f4765r, this.f4766s, this.f4767t, z10);
    }

    public final i1 j(v1.f1 f1Var) {
        return new i1(f1Var, this.f4751b, this.f4752c, this.f4753d, this.f4754e, this.f, this.f4755g, this.f4756h, this.i, this.f4757j, this.f4758k, this.f4759l, this.f4760m, this.f4761n, this.f4762o, this.f4764q, this.f4765r, this.f4766s, this.f4767t, this.f4763p);
    }

    public final long l() {
        long j4;
        long j7;
        if (!m()) {
            return this.f4766s;
        }
        do {
            j4 = this.f4767t;
            j7 = this.f4766s;
        } while (j4 != this.f4767t);
        return y1.a0.O(y1.a0.b0(j7) + ((long) ((SystemClock.elapsedRealtime() - j4) * this.f4762o.f12968a)));
    }

    public final boolean m() {
        return this.f4754e == 3 && this.f4759l && this.f4761n == 0;
    }
}
