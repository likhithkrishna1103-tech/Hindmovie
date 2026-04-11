package g4;

import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5140b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aa.o0 f5141a;

    static {
        new n1(new HashSet());
        int i = s1.b0.f11647a;
        f5140b = Integer.toString(0, 36);
    }

    public n1(HashSet hashSet) {
        this.f5141a = aa.o0.r(hashSet);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n1) {
            return this.f5141a.equals(((n1) obj).f5141a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f5141a);
    }
}
