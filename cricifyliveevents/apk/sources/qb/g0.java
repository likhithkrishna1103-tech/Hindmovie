package qb;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10567b;

    public g0(String str, List list) {
        this.f10566a = list;
        this.f10567b = str;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof s1) {
            g0 g0Var = (g0) ((s1) obj);
            String str2 = g0Var.f10567b;
            if (this.f10566a.equals(g0Var.f10566a) && ((str = this.f10567b) != null ? str.equals(str2) : str2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f10566a.hashCode() ^ 1000003) * 1000003;
        String str = this.f10567b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FilesPayload{files=");
        sb.append(this.f10566a);
        sb.append(", orgId=");
        return q4.a.q(sb, this.f10567b, "}");
    }
}
