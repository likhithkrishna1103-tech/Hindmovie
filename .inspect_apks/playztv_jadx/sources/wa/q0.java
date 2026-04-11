package wa;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q0 extends d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f14000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f14001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f14002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f14003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c2 f14004e;
    public final List f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f14005g;

    public q0(r0 r0Var, List list, List list2, Boolean bool, c2 c2Var, List list3, int i) {
        this.f14000a = r0Var;
        this.f14001b = list;
        this.f14002c = list2;
        this.f14003d = bool;
        this.f14004e = c2Var;
        this.f = list3;
        this.f14005g = i;
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
        c2 c2Var = q0Var.f14004e;
        Boolean bool = q0Var.f14003d;
        List list2 = q0Var.f14002c;
        List list3 = q0Var.f14001b;
        if (!this.f14000a.equals(q0Var.f14000a)) {
            return false;
        }
        List list4 = this.f14001b;
        if (list4 == null) {
            if (list3 != null) {
                return false;
            }
        } else if (!list4.equals(list3)) {
            return false;
        }
        List list5 = this.f14002c;
        if (list5 == null) {
            if (list2 != null) {
                return false;
            }
        } else if (!list5.equals(list2)) {
            return false;
        }
        Boolean bool2 = this.f14003d;
        if (bool2 == null) {
            if (bool != null) {
                return false;
            }
        } else if (!bool2.equals(bool)) {
            return false;
        }
        c2 c2Var2 = this.f14004e;
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
        return this.f14005g == q0Var.f14005g;
    }

    public final int hashCode() {
        int iHashCode = (this.f14000a.hashCode() ^ 1000003) * 1000003;
        List list = this.f14001b;
        int iHashCode2 = (iHashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List list2 = this.f14002c;
        int iHashCode3 = (iHashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Boolean bool = this.f14003d;
        int iHashCode4 = (iHashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        c2 c2Var = this.f14004e;
        int iHashCode5 = (iHashCode4 ^ (c2Var == null ? 0 : c2Var.hashCode())) * 1000003;
        List list3 = this.f;
        return ((iHashCode5 ^ (list3 != null ? list3.hashCode() : 0)) * 1000003) ^ this.f14005g;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Application{execution=");
        sb2.append(this.f14000a);
        sb2.append(", customAttributes=");
        sb2.append(this.f14001b);
        sb2.append(", internalKeys=");
        sb2.append(this.f14002c);
        sb2.append(", background=");
        sb2.append(this.f14003d);
        sb2.append(", currentProcessDetails=");
        sb2.append(this.f14004e);
        sb2.append(", appProcessDetails=");
        sb2.append(this.f);
        sb2.append(", uiOrientation=");
        return x.c.a(sb2, this.f14005g, "}");
    }
}
