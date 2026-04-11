package h4;

import a3.i0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f5679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5683e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5684g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f5685h;

    public m(i0 i0Var) {
        this.f5679a = i0Var;
    }

    public final void a(byte[] bArr, int i, int i10) {
        if (this.f5681c) {
            int i11 = this.f;
            int i12 = (i + 1) - i11;
            if (i12 >= i10) {
                this.f = (i10 - i) + i11;
            } else {
                this.f5682d = ((bArr[i12] & 192) >> 6) == 0;
                this.f5681c = false;
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
    public final void b(int i, long j4, boolean z10) {
        y1.d.g(this.f5685h != -9223372036854775807L);
        if (this.f5683e == 182 && z10 && this.f5680b) {
            this.f5679a.e(this.f5685h, this.f5682d ? 1 : 0, (int) (j4 - this.f5684g), i, null);
        }
        if (this.f5683e != 179) {
            this.f5684g = j4;
        }
    }
}
