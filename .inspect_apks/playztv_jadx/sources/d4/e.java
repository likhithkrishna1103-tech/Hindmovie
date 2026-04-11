package d4;

import java.util.Arrays;
import p1.m0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements i {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final byte[] f3814x = {73, 68, 51};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3815a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3819e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f3820g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public w2.h0 f3821h;
    public w2.h0 i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3825m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f3826n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3829q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3830r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3832t;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public w2.h0 f3834v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f3835w;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1.t f3816b = new s1.t(7, new byte[7]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s1.u f3817c = new s1.u(Arrays.copyOf(f3814x, 10));

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3827o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3828p = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f3831s = -9223372036854775807L;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f3833u = -9223372036854775807L;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3822j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3823k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3824l = 256;

    public e(int i, String str, String str2, boolean z2) {
        this.f3815a = z2;
        this.f3818d = str;
        this.f3819e = i;
        this.f = str2;
    }

    @Override // d4.i
    public final void a() {
        this.f3833u = -9223372036854775807L;
        this.f3826n = false;
        this.f3822j = 0;
        this.f3823k = 0;
        this.f3824l = 256;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f4  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // d4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(s1.u r24) throws p1.n0 {
        /*
            Method dump skipped, instruction units count: 792
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.e.d(s1.u):void");
    }

    @Override // d4.i
    public final void f(int i, long j5) {
        this.f3833u = j5;
    }

    @Override // d4.i
    public final void g(w2.q qVar, h0 h0Var) {
        h0Var.a();
        h0Var.b();
        this.f3820g = h0Var.f3889e;
        h0Var.b();
        w2.h0 h0VarQ = qVar.q(h0Var.f3888d, 1);
        this.f3821h = h0VarQ;
        this.f3834v = h0VarQ;
        if (!this.f3815a) {
            this.i = new w2.n();
            return;
        }
        h0Var.a();
        h0Var.b();
        w2.h0 h0VarQ2 = qVar.q(h0Var.f3888d, 5);
        this.i = h0VarQ2;
        p1.p pVar = new p1.p();
        h0Var.b();
        pVar.f9957a = h0Var.f3889e;
        pVar.f9966l = m0.p(this.f);
        pVar.f9967m = m0.p("application/id3");
        e6.j.s(pVar, h0VarQ2);
    }

    @Override // d4.i
    public final void e(boolean z2) {
    }
}
