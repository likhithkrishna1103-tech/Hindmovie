package d4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w2.h0 f3916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3920e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f3921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f3922h;

    public m(w2.h0 h0Var) {
        this.f3916a = h0Var;
    }

    public final void a(byte[] bArr, int i, int i10) {
        if (this.f3918c) {
            int i11 = this.f;
            int i12 = (i + 1) - i11;
            if (i12 >= i10) {
                this.f = (i10 - i) + i11;
            } else {
                this.f3919d = ((bArr[i12] & 192) >> 6) == 0;
                this.f3918c = false;
            }
        }
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
    public final void b(int i, long j5, boolean z2) {
        s1.d.g(this.f3922h != -9223372036854775807L);
        if (this.f3920e == 182 && z2 && this.f3917b) {
            this.f3916a.a(this.f3922h, this.f3919d ? 1 : 0, (int) (j5 - this.f3921g), i, null);
        }
        if (this.f3920e != 179) {
            this.f3921g = j5;
        }
    }
}
