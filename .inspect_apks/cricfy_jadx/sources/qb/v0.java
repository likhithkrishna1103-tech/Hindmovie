package qb;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 extends a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f10753c;

    public v0(String str, int i, List list) {
        this.f10751a = str;
        this.f10752b = i;
        this.f10753c = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a2) {
            v0 v0Var = (v0) ((a2) obj);
            if (this.f10751a.equals(v0Var.f10751a) && this.f10752b == v0Var.f10752b && this.f10753c.equals(v0Var.f10753c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f10751a.hashCode() ^ 1000003) * 1000003) ^ this.f10752b) * 1000003) ^ this.f10753c.hashCode();
    }

    public final String toString() {
        return "Thread{name=" + this.f10751a + ", importance=" + this.f10752b + ", frames=" + this.f10753c + "}";
    }
}
