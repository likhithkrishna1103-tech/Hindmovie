package b7;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u extends g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f1914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f1915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1916e;
    public final ArrayList f;

    public u(long j5, long j8, n nVar, Integer num, String str, ArrayList arrayList) {
        k0 k0Var = k0.f1879u;
        this.f1912a = j5;
        this.f1913b = j8;
        this.f1914c = nVar;
        this.f1915d = num;
        this.f1916e = str;
        this.f = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        u uVar = (u) ((g0) obj);
        Object obj2 = k0.f1879u;
        ArrayList arrayList = uVar.f;
        String str = uVar.f1916e;
        Integer num = uVar.f1915d;
        n nVar = uVar.f1914c;
        if (this.f1912a != uVar.f1912a || this.f1913b != uVar.f1913b || !this.f1914c.equals(nVar)) {
            return false;
        }
        Integer num2 = this.f1915d;
        if (num2 == null) {
            if (num != null) {
                return false;
            }
        } else if (!num2.equals(num)) {
            return false;
        }
        String str2 = this.f1916e;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        return this.f.equals(arrayList) && obj2.equals(obj2);
    }

    public final int hashCode() {
        long j5 = this.f1912a;
        long j8 = this.f1913b;
        int iHashCode = (((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ this.f1914c.hashCode()) * 1000003;
        Integer num = this.f1915d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f1916e;
        return ((((iHashCode2 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ this.f.hashCode()) * 1000003) ^ k0.f1879u.hashCode();
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f1912a + ", requestUptimeMs=" + this.f1913b + ", clientInfo=" + this.f1914c + ", logSource=" + this.f1915d + ", logSourceName=" + this.f1916e + ", logEvents=" + this.f + ", qosTier=" + k0.f1879u + "}";
    }
}
