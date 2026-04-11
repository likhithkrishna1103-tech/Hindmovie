package o4;

import java.util.List;
import sd.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f9486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9487b;

    public c(int i, List list) {
        this.f9486a = list;
        this.f9487b = i;
        if (list.isEmpty() && i == -1) {
            return;
        }
        if (!list.isEmpty()) {
            int size = list.size();
            if (i >= 0 && i < size) {
                return;
            }
        }
        StringBuilder sbM = l0.e.m(i, "Invalid 'NavigationEventHistory' state:  'currentIndex' must be within the bounds of 'mergedHistory' (or -1 if empty). Received: currentIndex = '", "', bounds = '");
        sbM.append(new ke.c(0, list.size() - 1, 1));
        sbM.append("'.");
        throw new IllegalArgumentException(sbM.toString().toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f9487b == cVar.f9487b && ge.i.a(this.f9486a, cVar.f9486a);
    }

    public final int hashCode() {
        return this.f9486a.hashCode() + (this.f9487b * 31);
    }

    public final String toString() {
        return "NavigationEventHistory(currentIndex=" + this.f9487b + ", mergedHistory=" + this.f9486a + ')';
    }

    public c() {
        this(-1, p.f11669v);
    }
}
