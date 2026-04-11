package df;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements bf.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bf.c f3727b;

    public o(String str, bf.c cVar) {
        ge.i.e(cVar, "kind");
        this.f3726a = str;
        this.f3727b = cVar;
    }

    @Override // bf.d
    public final int a(String str) {
        ge.i.e(str, "name");
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // bf.d
    public final String b() {
        return this.f3726a;
    }

    @Override // bf.d
    public final w8.e c() {
        return this.f3727b;
    }

    @Override // bf.d
    public final int d() {
        return 0;
    }

    @Override // bf.d
    public final String e(int i) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return ge.i.a(this.f3726a, oVar.f3726a) && ge.i.a(this.f3727b, oVar.f3727b);
    }

    @Override // bf.d
    public final boolean f() {
        return false;
    }

    @Override // bf.d
    public final List getAnnotations() {
        return sd.p.f11669v;
    }

    @Override // bf.d
    public final boolean h() {
        return false;
    }

    public final int hashCode() {
        return (this.f3727b.hashCode() * 31) + this.f3726a.hashCode();
    }

    @Override // bf.d
    public final List i(int i) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // bf.d
    public final bf.d j(int i) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // bf.d
    public final boolean k(int i) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final String toString() {
        return "PrimitiveDescriptor(" + this.f3726a + ')';
    }
}
