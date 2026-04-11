package df;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements bf.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bf.d f3704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bf.d f3705b;

    public g(bf.d dVar, bf.d dVar2) {
        ge.i.e(dVar, "keyDesc");
        ge.i.e(dVar2, "valueDesc");
        this.f3704a = dVar;
        this.f3705b = dVar2;
    }

    @Override // bf.d
    public final int a(String str) {
        ge.i.e(str, "name");
        Integer numA0 = ne.o.a0(str);
        if (numA0 != null) {
            return numA0.intValue();
        }
        throw new IllegalArgumentException(str.concat(" is not a valid map index"));
    }

    @Override // bf.d
    public final String b() {
        return "kotlin.collections.LinkedHashMap";
    }

    @Override // bf.d
    public final w8.e c() {
        return bf.f.f;
    }

    @Override // bf.d
    public final int d() {
        return 2;
    }

    @Override // bf.d
    public final String e(int i) {
        return String.valueOf(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return ge.i.a(this.f3704a, gVar.f3704a) && ge.i.a(this.f3705b, gVar.f3705b);
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
        return this.f3705b.hashCode() + ((this.f3704a.hashCode() + 710441009) * 31);
    }

    @Override // bf.d
    public final List i(int i) {
        if (i >= 0) {
            return sd.p.f11669v;
        }
        throw new IllegalArgumentException(l0.e.h(i, "Illegal index ", ", kotlin.collections.LinkedHashMap expects only non-negative indices").toString());
    }

    @Override // bf.d
    public final bf.d j(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(l0.e.h(i, "Illegal index ", ", kotlin.collections.LinkedHashMap expects only non-negative indices").toString());
        }
        int i10 = i % 2;
        if (i10 == 0) {
            return this.f3704a;
        }
        if (i10 == 1) {
            return this.f3705b;
        }
        throw new IllegalStateException("Unreached");
    }

    @Override // bf.d
    public final boolean k(int i) {
        if (i >= 0) {
            return false;
        }
        throw new IllegalArgumentException(l0.e.h(i, "Illegal index ", ", kotlin.collections.LinkedHashMap expects only non-negative indices").toString());
    }

    public final String toString() {
        return "kotlin.collections.LinkedHashMap(" + this.f3704a + ", " + this.f3705b + ')';
    }
}
