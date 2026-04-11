package k4;

import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7075b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ua.m0 f7076a;

    static {
        new l1(new HashSet());
        int i = y1.a0.f14551a;
        f7075b = Integer.toString(0, 36);
    }

    public l1(HashSet hashSet) {
        this.f7076a = ua.m0.k(hashSet);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l1) {
            return this.f7076a.equals(((l1) obj).f7076a);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f7076a);
    }
}
