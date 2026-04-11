package qb;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 extends x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f10737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x1 f10738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10739e;

    public t0(String str, String str2, List list, x1 x1Var, int i) {
        this.f10735a = str;
        this.f10736b = str2;
        this.f10737c = list;
        this.f10738d = x1Var;
        this.f10739e = i;
    }

    public final boolean equals(Object obj) {
        String str;
        x1 x1Var;
        if (obj == this) {
            return true;
        }
        if (obj instanceof x1) {
            t0 t0Var = (t0) ((x1) obj);
            x1 x1Var2 = t0Var.f10738d;
            String str2 = t0Var.f10736b;
            if (this.f10735a.equals(t0Var.f10735a) && ((str = this.f10736b) != null ? str.equals(str2) : str2 == null) && this.f10737c.equals(t0Var.f10737c) && ((x1Var = this.f10738d) != null ? x1Var.equals(x1Var2) : x1Var2 == null) && this.f10739e == t0Var.f10739e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f10735a.hashCode() ^ 1000003) * 1000003;
        String str = this.f10736b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f10737c.hashCode()) * 1000003;
        x1 x1Var = this.f10738d;
        return ((iHashCode2 ^ (x1Var != null ? x1Var.hashCode() : 0)) * 1000003) ^ this.f10739e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Exception{type=");
        sb.append(this.f10735a);
        sb.append(", reason=");
        sb.append(this.f10736b);
        sb.append(", frames=");
        sb.append(this.f10737c);
        sb.append(", causedBy=");
        sb.append(this.f10738d);
        sb.append(", overflowCount=");
        return q4.a.o(sb, this.f10739e, "}");
    }
}
