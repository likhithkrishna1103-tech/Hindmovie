package i7;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f6448c;

    public b(long j5, long j8, Set set) {
        this.f6446a = j5;
        this.f6447b = j8;
        this.f6448c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f6446a == bVar.f6446a && this.f6447b == bVar.f6447b && this.f6448c.equals(bVar.f6448c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f6446a;
        int i = (((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003;
        long j8 = this.f6447b;
        return ((i ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ this.f6448c.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f6446a + ", maxAllowedDelay=" + this.f6447b + ", flags=" + this.f6448c + "}";
    }
}
