package d4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w2.h0 f3977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f3981e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3982g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3983h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f3985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f3986l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3987m;

    public r(w2.h0 h0Var) {
        this.f3977a = h0Var;
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
    public final void a(int i) {
        long j5 = this.f3986l;
        if (j5 != -9223372036854775807L) {
            long j8 = this.f3978b;
            long j10 = this.f3985k;
            if (j8 == j10) {
                return;
            }
            int i10 = (int) (j8 - j10);
            this.f3977a.a(j5, this.f3987m ? 1 : 0, i10, i, null);
        }
    }
}
