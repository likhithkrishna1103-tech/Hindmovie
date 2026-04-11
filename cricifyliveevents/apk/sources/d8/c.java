package d8;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f3527c;

    public c(long j4, long j7, Set set) {
        this.f3525a = j4;
        this.f3526b = j7;
        this.f3527c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f3525a == cVar.f3525a && this.f3526b == cVar.f3526b && this.f3527c.equals(cVar.f3527c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f3525a;
        int i = (((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003;
        long j7 = this.f3526b;
        return ((i ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003) ^ this.f3527c.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f3525a + ", maxAllowedDelay=" + this.f3526b + ", flags=" + this.f3527c + "}";
    }
}
