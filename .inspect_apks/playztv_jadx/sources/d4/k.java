package d4;

import a2.u0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements i {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final double[] f3895r = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w2.h0 f3897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f3898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s1.u f3900e;
    public final u0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean[] f3901g = new boolean[4];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f3902h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3903j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3904k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f3905l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f3906m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f3907n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f3908o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3909p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3910q;

    public k(d0 d0Var, String str) {
        this.f3898c = d0Var;
        this.f3899d = str;
        j jVar = new j();
        jVar.f3894d = new byte[128];
        this.f3902h = jVar;
        if (d0Var != null) {
            this.f = new u0(178);
            this.f3900e = new s1.u();
        } else {
            this.f = null;
            this.f3900e = null;
        }
        this.f3906m = -9223372036854775807L;
        this.f3908o = -9223372036854775807L;
    }

    @Override // d4.i
    public final void a() {
        t1.p.a(this.f3901g);
        j jVar = this.f3902h;
        jVar.f3891a = false;
        jVar.f3892b = 0;
        jVar.f3893c = 0;
        u0 u0Var = this.f;
        if (u0Var != null) {
            u0Var.g();
        }
        this.i = 0L;
        this.f3903j = false;
        this.f3906m = -9223372036854775807L;
        this.f3908o = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0205  */
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
    public final void d(s1.u r23) {
        /*
            Method dump skipped, instruction units count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.k.d(s1.u):void");
    }

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
    public final void e(boolean z2) {
        s1.d.h(this.f3897b);
        if (z2) {
            boolean z10 = this.f3909p;
            this.f3897b.a(this.f3908o, z10 ? 1 : 0, (int) (this.i - this.f3907n), 0, null);
        }
    }

    @Override // d4.i
    public final void f(int i, long j5) {
        this.f3906m = j5;
    }

    @Override // d4.i
    public final void g(w2.q qVar, h0 h0Var) {
        h0Var.a();
        h0Var.b();
        this.f3896a = h0Var.f3889e;
        h0Var.b();
        this.f3897b = qVar.q(h0Var.f3888d, 2);
        d0 d0Var = this.f3898c;
        if (d0Var != null) {
            d0Var.b(qVar, h0Var);
        }
    }
}
