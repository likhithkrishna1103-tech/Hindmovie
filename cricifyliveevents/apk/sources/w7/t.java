package w7;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f14102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f14103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f14104e;
    public final ArrayList f;

    public t(long j4, long j7, n nVar, Integer num, String str, ArrayList arrayList) {
        j0 j0Var = j0.f14071v;
        this.f14100a = j4;
        this.f14101b = j7;
        this.f14102c = nVar;
        this.f14103d = num;
        this.f14104e = str;
        this.f = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        t tVar = (t) ((f0) obj);
        Object obj2 = j0.f14071v;
        ArrayList arrayList = tVar.f;
        String str = tVar.f14104e;
        Integer num = tVar.f14103d;
        n nVar = tVar.f14102c;
        if (this.f14100a != tVar.f14100a || this.f14101b != tVar.f14101b || !this.f14102c.equals(nVar)) {
            return false;
        }
        Integer num2 = this.f14103d;
        if (num2 == null) {
            if (num != null) {
                return false;
            }
        } else if (!num2.equals(num)) {
            return false;
        }
        String str2 = this.f14104e;
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
        long j4 = this.f14100a;
        long j7 = this.f14101b;
        int iHashCode = (((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003) ^ this.f14102c.hashCode()) * 1000003;
        Integer num = this.f14103d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f14104e;
        return ((((iHashCode2 ^ (str != null ? str.hashCode() : 0)) * 1000003) ^ this.f.hashCode()) * 1000003) ^ j0.f14071v.hashCode();
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.f14100a + ", requestUptimeMs=" + this.f14101b + ", clientInfo=" + this.f14102c + ", logSource=" + this.f14103d + ", logSourceName=" + this.f14104e + ", logEvents=" + this.f + ", qosTier=" + j0.f14071v + "}";
    }
}
