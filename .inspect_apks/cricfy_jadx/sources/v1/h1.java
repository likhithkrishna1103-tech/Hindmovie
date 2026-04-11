package v1;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12710d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g1 f12711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ua.i0 f12712b;

    static {
        int i = y1.a0.f14551a;
        f12709c = Integer.toString(0, 36);
        f12710d = Integer.toString(1, 36);
    }

    public h1(g1 g1Var, List list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= g1Var.f12702a)) {
            throw new IndexOutOfBoundsException();
        }
        this.f12711a = g1Var;
        this.f12712b = ua.i0.k(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && h1.class == obj.getClass()) {
            h1 h1Var = (h1) obj;
            if (this.f12711a.equals(h1Var.f12711a) && this.f12712b.equals(h1Var.f12712b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f12712b.hashCode() * 31) + this.f12711a.hashCode();
    }
}
