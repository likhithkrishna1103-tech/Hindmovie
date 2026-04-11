package e6;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d0 implements c6.f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c2.b0 f4488j = new c2.b0(50);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f6.f f4489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c6.f f4490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c6.f f4491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4492e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class f4493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c6.i f4494h;
    public final c6.m i;

    public d0(f6.f fVar, c6.f fVar2, c6.f fVar3, int i, int i10, c6.m mVar, Class cls, c6.i iVar) {
        this.f4489b = fVar;
        this.f4490c = fVar2;
        this.f4491d = fVar3;
        this.f4492e = i;
        this.f = i10;
        this.i = mVar;
        this.f4493g = cls;
        this.f4494h = iVar;
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
    @Override // c6.f
    public final void b(MessageDigest messageDigest) {
        Object objF;
        f6.f fVar = this.f4489b;
        synchronized (fVar) {
            f6.e eVar = fVar.f4768b;
            f6.h hVarQ1 = (f6.h) ((ArrayDeque) eVar.f2454v).poll();
            if (hVarQ1 == null) {
                hVarQ1 = eVar.q1();
            }
            f6.d dVar = (f6.d) hVarQ1;
            dVar.f4764b = 8;
            dVar.f4765c = byte[].class;
            objF = fVar.f(dVar, byte[].class);
        }
        byte[] bArr = (byte[]) objF;
        ByteBuffer.wrap(bArr).putInt(this.f4492e).putInt(this.f).array();
        this.f4491d.b(messageDigest);
        this.f4490c.b(messageDigest);
        messageDigest.update(bArr);
        c6.m mVar = this.i;
        if (mVar != null) {
            mVar.b(messageDigest);
        }
        this.f4494h.b(messageDigest);
        c2.b0 b0Var = f4488j;
        Class cls = this.f4493g;
        byte[] bytes = (byte[]) b0Var.a(cls);
        if (bytes == null) {
            bytes = cls.getName().getBytes(c6.f.f2515a);
            b0Var.d(cls, bytes);
        }
        messageDigest.update(bytes);
        this.f4489b.h(bArr);
    }

    @Override // c6.f
    public final boolean equals(Object obj) {
        if (obj instanceof d0) {
            d0 d0Var = (d0) obj;
            if (this.f == d0Var.f && this.f4492e == d0Var.f4492e && x6.m.b(this.i, d0Var.i) && this.f4493g.equals(d0Var.f4493g) && this.f4490c.equals(d0Var.f4490c) && this.f4491d.equals(d0Var.f4491d) && this.f4494h.equals(d0Var.f4494h)) {
                return true;
            }
        }
        return false;
    }

    @Override // c6.f
    public final int hashCode() {
        int iHashCode = ((((this.f4491d.hashCode() + (this.f4490c.hashCode() * 31)) * 31) + this.f4492e) * 31) + this.f;
        c6.m mVar = this.i;
        if (mVar != null) {
            iHashCode = (iHashCode * 31) + mVar.hashCode();
        }
        return this.f4494h.f2521b.hashCode() + ((this.f4493g.hashCode() + (iHashCode * 31)) * 31);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f4490c + ", signature=" + this.f4491d + ", width=" + this.f4492e + ", height=" + this.f + ", decodedResourceClass=" + this.f4493g + ", transformation='" + this.i + "', options=" + this.f4494h + '}';
    }
}
