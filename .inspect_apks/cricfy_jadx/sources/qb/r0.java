package qb;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 extends b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x1 f10715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p1 f10716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u0 f10717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f10718e;

    public r0(List list, t0 t0Var, p1 p1Var, u0 u0Var, List list2) {
        this.f10714a = list;
        this.f10715b = t0Var;
        this.f10716c = p1Var;
        this.f10717d = u0Var;
        this.f10718e = list2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b2)) {
            return false;
        }
        b2 b2Var = (b2) obj;
        List list = this.f10714a;
        if (list == null) {
            if (((r0) b2Var).f10714a != null) {
                return false;
            }
        } else if (!list.equals(((r0) b2Var).f10714a)) {
            return false;
        }
        x1 x1Var = this.f10715b;
        if (x1Var == null) {
            if (((r0) b2Var).f10715b != null) {
                return false;
            }
        } else if (!x1Var.equals(((r0) b2Var).f10715b)) {
            return false;
        }
        p1 p1Var = this.f10716c;
        if (p1Var == null) {
            if (((r0) b2Var).f10716c != null) {
                return false;
            }
        } else if (!p1Var.equals(((r0) b2Var).f10716c)) {
            return false;
        }
        r0 r0Var = (r0) b2Var;
        return this.f10717d.equals(r0Var.f10717d) && this.f10718e.equals(r0Var.f10718e);
    }

    public final int hashCode() {
        List list = this.f10714a;
        int iHashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
        x1 x1Var = this.f10715b;
        int iHashCode2 = (iHashCode ^ (x1Var == null ? 0 : x1Var.hashCode())) * 1000003;
        p1 p1Var = this.f10716c;
        return (((((p1Var != null ? p1Var.hashCode() : 0) ^ iHashCode2) * 1000003) ^ this.f10717d.hashCode()) * 1000003) ^ this.f10718e.hashCode();
    }

    public final String toString() {
        return "Execution{threads=" + this.f10714a + ", exception=" + this.f10715b + ", appExitInfo=" + this.f10716c + ", signal=" + this.f10717d + ", binaries=" + this.f10718e + "}";
    }
}
