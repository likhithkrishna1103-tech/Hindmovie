package z9;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements h, Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List f14909u;

    public i(List list) {
        this.f14909u = list;
    }

    @Override // z9.h
    public final boolean apply(Object obj) {
        int i = 0;
        while (true) {
            List list = this.f14909u;
            if (i >= list.size()) {
                return true;
            }
            if (!((h) list.get(i)).apply(obj)) {
                return false;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f14909u.equals(((i) obj).f14909u);
        }
        return false;
    }

    public final int hashCode() {
        return this.f14909u.hashCode() + 306654252;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Predicates.and(");
        boolean z2 = true;
        for (Object obj : this.f14909u) {
            if (!z2) {
                sb2.append(',');
            }
            sb2.append(obj);
            z2 = false;
        }
        sb2.append(')');
        return sb2.toString();
    }
}
