package z6;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements x6.e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final i2.c0 f15244j = new i2.c0(50);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a7.g f15245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x6.e f15246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x6.e f15247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f15248e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class f15249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x6.h f15250h;
    public final x6.l i;

    public d0(a7.g gVar, x6.e eVar, x6.e eVar2, int i, int i10, x6.l lVar, Class cls, x6.h hVar) {
        this.f15245b = gVar;
        this.f15246c = eVar;
        this.f15247d = eVar2;
        this.f15248e = i;
        this.f = i10;
        this.i = lVar;
        this.f15249g = cls;
        this.f15250h = hVar;
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
    @Override // x6.e
    public final void a(MessageDigest messageDigest) {
        Object objF;
        a7.g gVar = this.f15245b;
        synchronized (gVar) {
            a7.f fVar = gVar.f318b;
            a7.j jVarN1 = (a7.j) ((ArrayDeque) fVar.f307w).poll();
            if (jVarN1 == null) {
                jVarN1 = fVar.n1();
            }
            a7.e eVar = (a7.e) jVarN1;
            eVar.f314b = 8;
            eVar.f315c = byte[].class;
            objF = gVar.f(eVar, byte[].class);
        }
        byte[] bArr = (byte[]) objF;
        ByteBuffer.wrap(bArr).putInt(this.f15248e).putInt(this.f).array();
        this.f15247d.a(messageDigest);
        this.f15246c.a(messageDigest);
        messageDigest.update(bArr);
        x6.l lVar = this.i;
        if (lVar != null) {
            lVar.a(messageDigest);
        }
        this.f15250h.a(messageDigest);
        i2.c0 c0Var = f15244j;
        Class cls = this.f15249g;
        byte[] bytes = (byte[]) c0Var.a(cls);
        if (bytes == null) {
            bytes = cls.getName().getBytes(x6.e.f14397a);
            c0Var.d(cls, bytes);
        }
        messageDigest.update(bytes);
        this.f15245b.h(bArr);
    }

    @Override // x6.e
    public final boolean equals(Object obj) {
        if (obj instanceof d0) {
            d0 d0Var = (d0) obj;
            if (this.f == d0Var.f && this.f15248e == d0Var.f15248e && s7.m.b(this.i, d0Var.i) && this.f15249g.equals(d0Var.f15249g) && this.f15246c.equals(d0Var.f15246c) && this.f15247d.equals(d0Var.f15247d) && this.f15250h.equals(d0Var.f15250h)) {
                return true;
            }
        }
        return false;
    }

    @Override // x6.e
    public final int hashCode() {
        int iHashCode = ((((this.f15247d.hashCode() + (this.f15246c.hashCode() * 31)) * 31) + this.f15248e) * 31) + this.f;
        x6.l lVar = this.i;
        if (lVar != null) {
            iHashCode = (iHashCode * 31) + lVar.hashCode();
        }
        return this.f15250h.f14403b.hashCode() + ((this.f15249g.hashCode() + (iHashCode * 31)) * 31);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f15246c + ", signature=" + this.f15247d + ", width=" + this.f15248e + ", height=" + this.f + ", decodedResourceClass=" + this.f15249g + ", transformation='" + this.i + "', options=" + this.f15250h + '}';
    }
}
