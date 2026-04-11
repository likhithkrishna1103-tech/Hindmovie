package qb;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 extends d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f10703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f10704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f10705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f10706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c2 f10707e;
    public final List f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f10708g;

    public q0(r0 r0Var, List list, List list2, Boolean bool, c2 c2Var, List list3, int i) {
        this.f10703a = r0Var;
        this.f10704b = list;
        this.f10705c = list2;
        this.f10706d = bool;
        this.f10707e = c2Var;
        this.f = list3;
        this.f10708g = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d2)) {
            return false;
        }
        q0 q0Var = (q0) ((d2) obj);
        List list = q0Var.f;
        c2 c2Var = q0Var.f10707e;
        Boolean bool = q0Var.f10706d;
        List list2 = q0Var.f10705c;
        List list3 = q0Var.f10704b;
        if (!this.f10703a.equals(q0Var.f10703a)) {
            return false;
        }
        List list4 = this.f10704b;
        if (list4 == null) {
            if (list3 != null) {
                return false;
            }
        } else if (!list4.equals(list3)) {
            return false;
        }
        List list5 = this.f10705c;
        if (list5 == null) {
            if (list2 != null) {
                return false;
            }
        } else if (!list5.equals(list2)) {
            return false;
        }
        Boolean bool2 = this.f10706d;
        if (bool2 == null) {
            if (bool != null) {
                return false;
            }
        } else if (!bool2.equals(bool)) {
            return false;
        }
        c2 c2Var2 = this.f10707e;
        if (c2Var2 == null) {
            if (c2Var != null) {
                return false;
            }
        } else if (!c2Var2.equals(c2Var)) {
            return false;
        }
        List list6 = this.f;
        if (list6 == null) {
            if (list != null) {
                return false;
            }
        } else if (!list6.equals(list)) {
            return false;
        }
        return this.f10708g == q0Var.f10708g;
    }

    public final int hashCode() {
        int iHashCode = (this.f10703a.hashCode() ^ 1000003) * 1000003;
        List list = this.f10704b;
        int iHashCode2 = (iHashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List list2 = this.f10705c;
        int iHashCode3 = (iHashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Boolean bool = this.f10706d;
        int iHashCode4 = (iHashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        c2 c2Var = this.f10707e;
        int iHashCode5 = (iHashCode4 ^ (c2Var == null ? 0 : c2Var.hashCode())) * 1000003;
        List list3 = this.f;
        return ((iHashCode5 ^ (list3 != null ? list3.hashCode() : 0)) * 1000003) ^ this.f10708g;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Application{execution=");
        sb.append(this.f10703a);
        sb.append(", customAttributes=");
        sb.append(this.f10704b);
        sb.append(", internalKeys=");
        sb.append(this.f10705c);
        sb.append(", background=");
        sb.append(this.f10706d);
        sb.append(", currentProcessDetails=");
        sb.append(this.f10707e);
        sb.append(", appProcessDetails=");
        sb.append(this.f);
        sb.append(", uiOrientation=");
        return q4.a.o(sb, this.f10708g, "}");
    }
}
