package rf;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements fe.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final u f11101v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ q f11102w;

    public p(q qVar, u uVar) {
        this.f11102w = qVar;
        this.f11101v = uVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [rf.q] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [rf.b] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
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
    @Override // fe.a
    public final Object b() throws Throwable {
        Throwable th;
        b bVar;
        ?? r02 = this.f11102w;
        u uVar = this.f11101v;
        b bVar2 = b.f11051z;
        ?? r32 = 1;
        IOException e9 = null;
        try {
            try {
                try {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e10) {
                e9 = e10;
                bVar = bVar2;
            }
            if (!uVar.a(true, this)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            do {
                try {
                } catch (Throwable th3) {
                    th = th3;
                }
            } while (uVar.a(false, this));
            bVar = b.f11049x;
            try {
                bVar2 = b.C;
                r02.a(bVar, bVar2, null);
                r32 = bVar;
            } catch (IOException e11) {
                e9 = e11;
                bVar2 = b.f11050y;
                r02.a(bVar2, bVar2, e9);
                r32 = bVar;
            }
            lf.d.b(uVar);
            return rd.l.f11003a;
        } catch (Throwable th4) {
            th = th4;
        }
        r32 = bVar2;
        r02.a(r32, bVar2, e9);
        lf.d.b(uVar);
        throw th;
    }
}
