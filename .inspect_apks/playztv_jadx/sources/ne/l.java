package ne;

import i4.o0;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final n f9016u;

    public l(n nVar) {
        this.f9016u = nVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void a(Set set) {
        n nVar;
        Object objD;
        int[] iArr;
        be.h.e(set, "tableIds");
        if (set.isEmpty()) {
            return;
        }
        do {
            nVar = this.f9016u;
            objD = nVar.d();
            int[] iArr2 = (int[]) objD;
            int length = iArr2.length;
            iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = set.contains(Integer.valueOf(i)) ? iArr2[i] + 1 : iArr2[i];
            }
            o0 o0Var = oe.c.f9578b;
            if (objD == null) {
                objD = o0Var;
            }
        } while (!nVar.f(objD, iArr));
    }

    @Override // ne.b
    public Object o(c cVar, td.c cVar2) throws Throwable {
        this.f9016u.o(cVar, cVar2);
        return sd.a.f11942u;
    }

    public l(int i) {
        this.f9016u = new n(new int[i]);
    }
}
