package wa;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r0 extends b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f14011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x1 f14012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p1 f14013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u0 f14014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f14015e;

    public r0(List list, t0 t0Var, p1 p1Var, u0 u0Var, List list2) {
        this.f14011a = list;
        this.f14012b = t0Var;
        this.f14013c = p1Var;
        this.f14014d = u0Var;
        this.f14015e = list2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b2)) {
            return false;
        }
        b2 b2Var = (b2) obj;
        List list = this.f14011a;
        if (list == null) {
            if (((r0) b2Var).f14011a != null) {
                return false;
            }
        } else if (!list.equals(((r0) b2Var).f14011a)) {
            return false;
        }
        x1 x1Var = this.f14012b;
        if (x1Var == null) {
            if (((r0) b2Var).f14012b != null) {
                return false;
            }
        } else if (!x1Var.equals(((r0) b2Var).f14012b)) {
            return false;
        }
        p1 p1Var = this.f14013c;
        if (p1Var == null) {
            if (((r0) b2Var).f14013c != null) {
                return false;
            }
        } else if (!p1Var.equals(((r0) b2Var).f14013c)) {
            return false;
        }
        r0 r0Var = (r0) b2Var;
        return this.f14014d.equals(r0Var.f14014d) && this.f14015e.equals(r0Var.f14015e);
    }

    public final int hashCode() {
        List list = this.f14011a;
        int iHashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
        x1 x1Var = this.f14012b;
        int iHashCode2 = (iHashCode ^ (x1Var == null ? 0 : x1Var.hashCode())) * 1000003;
        p1 p1Var = this.f14013c;
        return (((((p1Var != null ? p1Var.hashCode() : 0) ^ iHashCode2) * 1000003) ^ this.f14014d.hashCode()) * 1000003) ^ this.f14015e.hashCode();
    }

    public final String toString() {
        return "Execution{threads=" + this.f14011a + ", exception=" + this.f14012b + ", appExitInfo=" + this.f14013c + ", signal=" + this.f14014d + ", binaries=" + this.f14015e + "}";
    }
}
