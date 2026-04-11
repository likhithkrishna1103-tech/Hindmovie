package df;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements bf.d, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bf.d f3728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f3730c;

    public p(bf.d dVar) {
        Set setG;
        ge.i.e(dVar, "original");
        this.f3728a = dVar;
        this.f3729b = dVar.b() + '?';
        ge.i.e(dVar, "<this>");
        if (dVar instanceof b) {
            setG = ((b) dVar).g();
        } else {
            HashSet hashSet = new HashSet(dVar.d());
            int iD = dVar.d();
            for (int i = 0; i < iD; i++) {
                hashSet.add(dVar.e(i));
            }
            setG = hashSet;
        }
        this.f3730c = setG;
    }

    @Override // bf.d
    public final int a(String str) {
        ge.i.e(str, "name");
        return this.f3728a.a(str);
    }

    @Override // bf.d
    public final String b() {
        return this.f3729b;
    }

    @Override // bf.d
    public final w8.e c() {
        return this.f3728a.c();
    }

    @Override // bf.d
    public final int d() {
        return this.f3728a.d();
    }

    @Override // bf.d
    public final String e(int i) {
        return this.f3728a.e(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            return ge.i.a(this.f3728a, ((p) obj).f3728a);
        }
        return false;
    }

    @Override // bf.d
    public final boolean f() {
        return this.f3728a.f();
    }

    @Override // df.b
    public final Set g() {
        return this.f3730c;
    }

    @Override // bf.d
    public final List getAnnotations() {
        return this.f3728a.getAnnotations();
    }

    @Override // bf.d
    public final boolean h() {
        return true;
    }

    public final int hashCode() {
        return this.f3728a.hashCode() * 31;
    }

    @Override // bf.d
    public final List i(int i) {
        return this.f3728a.i(i);
    }

    @Override // bf.d
    public final bf.d j(int i) {
        return this.f3728a.j(i);
    }

    @Override // bf.d
    public final boolean k(int i) {
        return this.f3728a.k(i);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3728a);
        sb.append('?');
        return sb.toString();
    }
}
