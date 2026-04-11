package ua;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z extends x0 implements Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Comparator[] f12412v;

    public z(p pVar, p pVar2) {
        this.f12412v = new Comparator[]{pVar, pVar2};
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = 0;
        while (true) {
            Comparator[] comparatorArr = this.f12412v;
            if (i >= comparatorArr.length) {
                return 0;
            }
            int iCompare = comparatorArr[i].compare(obj, obj2);
            if (iCompare != 0) {
                return iCompare;
            }
            i++;
        }
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z) {
            return Arrays.equals(this.f12412v, ((z) obj).f12412v);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f12412v);
    }

    public final String toString() {
        return q4.a.q(new StringBuilder("Ordering.compound("), Arrays.toString(this.f12412v), ")");
    }
}
