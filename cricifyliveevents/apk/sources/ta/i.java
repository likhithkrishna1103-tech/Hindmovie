package ta;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements h, Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List f11959v;

    public i(List list) {
        this.f11959v = list;
    }

    @Override // ta.h
    public final boolean apply(Object obj) {
        int i = 0;
        while (true) {
            List list = this.f11959v;
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
            return this.f11959v.equals(((i) obj).f11959v);
        }
        return false;
    }

    public final int hashCode() {
        return this.f11959v.hashCode() + 306654252;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Predicates.and(");
        boolean z10 = true;
        for (Object obj : this.f11959v) {
            if (!z10) {
                sb.append(',');
            }
            sb.append(obj);
            z10 = false;
        }
        sb.append(')');
        return sb.toString();
    }
}
