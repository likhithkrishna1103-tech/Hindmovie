package p1;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9782d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g1 f9783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final aa.j0 f9784b;

    static {
        int i = s1.b0.f11647a;
        f9781c = Integer.toString(0, 36);
        f9782d = Integer.toString(1, 36);
    }

    public h1(g1 g1Var, List list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= g1Var.f9762a)) {
            throw new IndexOutOfBoundsException();
        }
        this.f9783a = g1Var;
        this.f9784b = aa.j0.r(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && h1.class == obj.getClass()) {
            h1 h1Var = (h1) obj;
            if (this.f9783a.equals(h1Var.f9783a) && this.f9784b.equals(h1Var.f9784b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f9784b.hashCode() * 31) + this.f9783a.hashCode();
    }
}
