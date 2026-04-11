package ua;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g1 extends x0 implements Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final x0 f12334v;

    public g1(x0 x0Var) {
        this.f12334v = x0Var;
    }

    @Override // ua.x0
    public final x0 a() {
        return this.f12334v;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f12334v.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g1) {
            return this.f12334v.equals(((g1) obj).f12334v);
        }
        return false;
    }

    public final int hashCode() {
        return -this.f12334v.hashCode();
    }

    public final String toString() {
        return this.f12334v + ".reverse()";
    }
}
