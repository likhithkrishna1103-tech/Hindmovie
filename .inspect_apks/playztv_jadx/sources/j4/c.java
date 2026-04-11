package j4;

import java.util.List;
import od.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f6775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6776b;

    public c(int i, List list) {
        this.f6775a = list;
        this.f6776b = i;
        if (list.isEmpty() && i == -1) {
            return;
        }
        List list2 = list;
        if (!list2.isEmpty()) {
            int size = list2.size();
            if (i >= 0 && i < size) {
                return;
            }
        }
        throw new IllegalArgumentException(("Invalid 'NavigationEventHistory' state:  'currentIndex' must be within the bounds of 'mergedHistory' (or -1 if empty). Received: currentIndex = '" + i + "', bounds = '" + new fe.c(0, list2.size() - 1, 1) + "'.").toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f6776b == cVar.f6776b && be.h.a(this.f6775a, cVar.f6775a);
    }

    public final int hashCode() {
        return this.f6775a.hashCode() + (this.f6776b * 31);
    }

    public final String toString() {
        return "NavigationEventHistory(currentIndex=" + this.f6776b + ", mergedHistory=" + this.f6775a + ')';
    }

    public c() {
        this(-1, q.f9570u);
    }
}
