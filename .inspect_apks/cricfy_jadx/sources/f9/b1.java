package f9;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 {
    public Long A;
    public long B;
    public String C;
    public int D;
    public int E;
    public long F;
    public String G;
    public byte[] H;
    public int I;
    public long J;
    public long K;
    public long L;
    public long M;
    public long N;
    public long O;
    public String P;
    public boolean Q;
    public long R;
    public long S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r1 f4024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4028e;
    public String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4030h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f4031j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f4032k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f4033l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f4034m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f4035n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4036o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f4037p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Boolean f4038q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f4039r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ArrayList f4040s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f4041t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f4042u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f4043v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f4044w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f4045x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f4046y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Long f4047z;

    public b1(r1 r1Var, String str) {
        o8.u.g(r1Var);
        o8.u.d(str);
        this.f4024a = r1Var;
        this.f4025b = str;
        p1 p1Var = r1Var.B;
        r1.g(p1Var);
        p1Var.m1();
    }

    public final void A(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.f4044w != j4;
        this.f4044w = j4;
    }

    public final void B(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.B != j4;
        this.B = j4;
    }

    public final String C() {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        return this.C;
    }

    public final String D() {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        return this.f4025b;
    }

    public final String E() {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        return this.f4026c;
    }

    public final void F(String str) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= !Objects.equals(this.f4026c, str);
        this.f4026c = str;
    }

    public final String G() {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        return this.f4027d;
    }

    public final void H(String str) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.Q |= true ^ Objects.equals(this.f4027d, str);
        this.f4027d = str;
    }

    public final void I(String str) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= !Objects.equals(this.f4028e, str);
        this.f4028e = str;
    }

    public final String J() {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        return this.f;
    }

    public final void K(String str) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= !Objects.equals(this.f, str);
        this.f = str;
    }

    public final void L(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.f4030h != j4;
        this.f4030h = j4;
    }

    public final void M(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.i != j4;
        this.i = j4;
    }

    public final String N() {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        return this.f4031j;
    }

    public final void O(String str) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= !Objects.equals(this.f4031j, str);
        this.f4031j = str;
    }

    public final long P() {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        return this.f4032k;
    }

    public final void Q(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.f4032k != j4;
        this.f4032k = j4;
    }

    public final void R(String str) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= !Objects.equals(this.f4033l, str);
        this.f4033l = str;
    }

    public final void S(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.f4034m != j4;
        this.f4034m = j4;
    }

    public final void a(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.f4035n != j4;
        this.f4035n = j4;
    }

    public final long b() {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        return this.f4039r;
    }

    public final void c(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.f4039r != j4;
        this.f4039r = j4;
    }

    public final void d(boolean z10) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.f4036o != z10;
        this.f4036o = z10;
    }

    public final void e(long j4) {
        o8.u.b(j4 >= 0);
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.f4029g != j4;
        this.f4029g = j4;
    }

    public final void f(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.R != j4;
        this.R = j4;
    }

    public final void g(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.S != j4;
        this.S = j4;
    }

    public final void h(long j4) {
        r1 r1Var = this.f4024a;
        p1 p1Var = r1Var.B;
        w0 w0Var = r1Var.A;
        r1.g(p1Var);
        p1Var.m1();
        long j7 = this.f4029g + j4;
        String str = this.f4025b;
        if (j7 > 2147483647L) {
            r1.g(w0Var);
            w0Var.E.b(w0.u1(str), "Bundle index overflow. appId");
            j7 = (-1) + j4;
        }
        long j10 = this.F + 1;
        if (j10 > 2147483647L) {
            r1.g(w0Var);
            w0Var.E.b(w0.u1(str), "Delivery index overflow. appId");
            j10 = 0;
        }
        this.Q = true;
        this.f4029g = j7;
        this.F = j10;
    }

    public final void i(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.J != j4;
        this.J = j4;
    }

    public final void j(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.K != j4;
        this.K = j4;
    }

    public final void k(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.L != j4;
        this.L = j4;
    }

    public final void l(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.M != j4;
        this.M = j4;
    }

    public final void m(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.O != j4;
        this.O = j4;
    }

    public final void n(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.N != j4;
        this.N = j4;
    }

    public final boolean o() {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        return this.Q;
    }

    public final void p(int i) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.D != i;
        this.D = i;
    }

    public final void q(int i) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.E != i;
        this.E = i;
    }

    public final void r(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.F != j4;
        this.F = j4;
    }

    public final String s() {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        return this.G;
    }

    public final int t() {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        return this.I;
    }

    public final String u() {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        String str = this.P;
        v(null);
        return str;
    }

    public final void v(String str) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= !Objects.equals(this.P, str);
        this.P = str;
    }

    public final Boolean w() {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        return this.f4038q;
    }

    public final void x(List list) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        if (Objects.equals(this.f4040s, list)) {
            return;
        }
        this.Q = true;
        this.f4040s = list != null ? new ArrayList(list) : null;
    }

    public final boolean y() {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        return this.f4042u;
    }

    public final void z(long j4) {
        p1 p1Var = this.f4024a.B;
        r1.g(p1Var);
        p1Var.m1();
        this.Q |= this.f4043v != j4;
        this.f4043v = j4;
    }
}
