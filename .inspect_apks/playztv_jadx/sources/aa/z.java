package aa;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z extends a1 implements Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Comparator[] f766u;

    public z(p pVar, p pVar2) {
        this.f766u = new Comparator[]{pVar, pVar2};
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = 0;
        while (true) {
            Comparator[] comparatorArr = this.f766u;
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
            return Arrays.equals(this.f766u, ((z) obj).f766u);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f766u);
    }

    public final String toString() {
        return l4.a.o(new StringBuilder("Ordering.compound("), Arrays.toString(this.f766u), ")");
    }
}
