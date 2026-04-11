package w7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f14093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f14094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a0 f14095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f14096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f14097e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f14098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i0 f14099h;
    public final b0 i;

    public s(long j4, Integer num, a0 a0Var, long j7, byte[] bArr, String str, long j10, i0 i0Var, b0 b0Var) {
        this.f14093a = j4;
        this.f14094b = num;
        this.f14095c = a0Var;
        this.f14096d = j7;
        this.f14097e = bArr;
        this.f = str;
        this.f14098g = j10;
        this.f14099h = i0Var;
        this.i = b0Var;
    }

    public final boolean equals(Object obj) {
        Integer num;
        a0 a0Var;
        String str;
        i0 i0Var;
        b0 b0Var;
        if (obj == this) {
            return true;
        }
        if (obj instanceof e0) {
            e0 e0Var = (e0) obj;
            s sVar = (s) e0Var;
            b0 b0Var2 = sVar.i;
            i0 i0Var2 = sVar.f14099h;
            String str2 = sVar.f;
            a0 a0Var2 = sVar.f14095c;
            Integer num2 = sVar.f14094b;
            if (this.f14093a == sVar.f14093a && ((num = this.f14094b) != null ? num.equals(num2) : num2 == null) && ((a0Var = this.f14095c) != null ? a0Var.equals(a0Var2) : a0Var2 == null) && this.f14096d == sVar.f14096d) {
                if (Arrays.equals(this.f14097e, e0Var instanceof s ? ((s) e0Var).f14097e : sVar.f14097e) && ((str = this.f) != null ? str.equals(str2) : str2 == null) && this.f14098g == sVar.f14098g && ((i0Var = this.f14099h) != null ? i0Var.equals(i0Var2) : i0Var2 == null) && ((b0Var = this.i) != null ? b0Var.equals(b0Var2) : b0Var2 == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f14093a;
        int i = (((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f14094b;
        int iHashCode = (i ^ (num == null ? 0 : num.hashCode())) * 1000003;
        a0 a0Var = this.f14095c;
        int iHashCode2 = (iHashCode ^ (a0Var == null ? 0 : a0Var.hashCode())) * 1000003;
        long j7 = this.f14096d;
        int iHashCode3 = (((iHashCode2 ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f14097e)) * 1000003;
        String str = this.f;
        int iHashCode4 = (iHashCode3 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j10 = this.f14098g;
        int i10 = (iHashCode4 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        i0 i0Var = this.f14099h;
        int iHashCode5 = (i10 ^ (i0Var == null ? 0 : i0Var.hashCode())) * 1000003;
        b0 b0Var = this.i;
        return iHashCode5 ^ (b0Var != null ? b0Var.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f14093a + ", eventCode=" + this.f14094b + ", complianceData=" + this.f14095c + ", eventUptimeMs=" + this.f14096d + ", sourceExtension=" + Arrays.toString(this.f14097e) + ", sourceExtensionJsonProto3=" + this.f + ", timezoneOffsetSeconds=" + this.f14098g + ", networkConnectionInfo=" + this.f14099h + ", experimentIds=" + this.i + "}";
    }
}
