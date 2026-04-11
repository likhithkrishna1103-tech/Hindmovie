package y4;

import w4.c0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends xd.h implements fe.l {
    public final /* synthetic */ n A;
    public final /* synthetic */ c0 B;
    public final /* synthetic */ xd.h C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f14865z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public m(n nVar, c0 c0Var, fe.p pVar, vd.c cVar) {
        super(1, cVar);
        this.A = nVar;
        this.B = c0Var;
        this.C = (xd.h) pVar;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [fe.p, xd.h] */
    @Override // fe.l
    public final Object a(Object obj) {
        c0 c0Var = this.B;
        ?? r22 = this.C;
        return new m(this.A, c0Var, r22, (vd.c) obj).o(rd.l.f11003a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [fe.p, xd.h] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        int i = this.f14865z;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.bumptech.glide.c.C(obj);
            return obj;
        }
        com.bumptech.glide.c.C(obj);
        this.f14865z = 1;
        Object objE = this.A.e(this.B, this.C, this);
        wd.a aVar = wd.a.f14143v;
        return objE == aVar ? aVar : objE;
    }
}
