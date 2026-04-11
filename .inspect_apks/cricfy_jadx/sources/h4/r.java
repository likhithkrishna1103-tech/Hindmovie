package h4;

import a3.i0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f5740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f5744e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5746h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5747j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f5748k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f5749l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5750m;

    public r(i0 i0Var) {
        this.f5740a = i0Var;
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
        long j4 = this.f5749l;
        if (j4 != -9223372036854775807L) {
            long j7 = this.f5741b;
            long j10 = this.f5748k;
            if (j7 == j10) {
                return;
            }
            int i10 = (int) (j7 - j10);
            this.f5740a.e(j4, this.f5750m ? 1 : 0, i10, i, null);
        }
    }
}
