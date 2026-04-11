package h4;

import a3.i0;
import g2.l0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements i {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final double[] f5658r = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i0 f5660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f5661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y1.t f5663e;
    public final l0 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean[] f5664g = new boolean[4];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j f5665h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5666j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5667k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f5668l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f5669m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f5670n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f5671o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f5672p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f5673q;

    public k(d0 d0Var, String str) {
        this.f5661c = d0Var;
        this.f5662d = str;
        j jVar = new j();
        jVar.f5657d = new byte[128];
        this.f5665h = jVar;
        if (d0Var != null) {
            this.f = new l0(178);
            this.f5663e = new y1.t();
        } else {
            this.f = null;
            this.f5663e = null;
        }
        this.f5669m = -9223372036854775807L;
        this.f5671o = -9223372036854775807L;
    }

    @Override // h4.i
    public final void a() {
        z1.o.a(this.f5664g);
        j jVar = this.f5665h;
        jVar.f5654a = false;
        jVar.f5655b = 0;
        jVar.f5656c = 0;
        l0 l0Var = this.f;
        if (l0Var != null) {
            l0Var.g();
        }
        this.i = 0L;
        this.f5666j = false;
        this.f5669m = -9223372036854775807L;
        this.f5671o = -9223372036854775807L;
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
    @Override // h4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(y1.t r23) {
        /*
            Method dump skipped, instruction units count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.k.b(y1.t):void");
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
    @Override // h4.i
    public final void c(boolean z10) {
        y1.d.h(this.f5660b);
        if (z10) {
            boolean z11 = this.f5672p;
            this.f5660b.e(this.f5671o, z11 ? 1 : 0, (int) (this.i - this.f5670n), 0, null);
        }
    }

    @Override // h4.i
    public final void d(int i, long j4) {
        this.f5669m = j4;
    }

    @Override // h4.i
    public final void e(a3.r rVar, g0 g0Var) {
        g0Var.a();
        g0Var.b();
        this.f5659a = g0Var.f5646e;
        g0Var.b();
        this.f5660b = rVar.p(g0Var.f5645d, 2);
        d0 d0Var = this.f5661c;
        if (d0Var != null) {
            d0Var.b(rVar, g0Var);
        }
    }
}
