package wa;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f13863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13864b;

    public g0(String str, List list) {
        this.f13863a = list;
        this.f13864b = str;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof s1) {
            g0 g0Var = (g0) ((s1) obj);
            String str2 = g0Var.f13864b;
            if (this.f13863a.equals(g0Var.f13863a) && ((str = this.f13864b) != null ? str.equals(str2) : str2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f13863a.hashCode() ^ 1000003) * 1000003;
        String str = this.f13864b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FilesPayload{files=");
        sb2.append(this.f13863a);
        sb2.append(", orgId=");
        return l4.a.o(sb2, this.f13864b, "}");
    }
}
