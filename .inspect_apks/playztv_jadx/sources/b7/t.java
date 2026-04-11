package b7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t extends f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f1906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f1907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f1909e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f1910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final j0 f1911h;
    public final c0 i;

    public t(long j5, Integer num, b0 b0Var, long j8, byte[] bArr, String str, long j10, j0 j0Var, c0 c0Var) {
        this.f1905a = j5;
        this.f1906b = num;
        this.f1907c = b0Var;
        this.f1908d = j8;
        this.f1909e = bArr;
        this.f = str;
        this.f1910g = j10;
        this.f1911h = j0Var;
        this.i = c0Var;
    }

    public final boolean equals(Object obj) {
        Integer num;
        b0 b0Var;
        String str;
        j0 j0Var;
        c0 c0Var;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0) {
            f0 f0Var = (f0) obj;
            t tVar = (t) f0Var;
            c0 c0Var2 = tVar.i;
            j0 j0Var2 = tVar.f1911h;
            String str2 = tVar.f;
            b0 b0Var2 = tVar.f1907c;
            Integer num2 = tVar.f1906b;
            if (this.f1905a == tVar.f1905a && ((num = this.f1906b) != null ? num.equals(num2) : num2 == null) && ((b0Var = this.f1907c) != null ? b0Var.equals(b0Var2) : b0Var2 == null) && this.f1908d == tVar.f1908d) {
                if (Arrays.equals(this.f1909e, f0Var instanceof t ? ((t) f0Var).f1909e : tVar.f1909e) && ((str = this.f) != null ? str.equals(str2) : str2 == null) && this.f1910g == tVar.f1910g && ((j0Var = this.f1911h) != null ? j0Var.equals(j0Var2) : j0Var2 == null) && ((c0Var = this.i) != null ? c0Var.equals(c0Var2) : c0Var2 == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f1905a;
        int i = (((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f1906b;
        int iHashCode = (i ^ (num == null ? 0 : num.hashCode())) * 1000003;
        b0 b0Var = this.f1907c;
        int iHashCode2 = (iHashCode ^ (b0Var == null ? 0 : b0Var.hashCode())) * 1000003;
        long j8 = this.f1908d;
        int iHashCode3 = (((iHashCode2 ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f1909e)) * 1000003;
        String str = this.f;
        int iHashCode4 = (iHashCode3 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j10 = this.f1910g;
        int i10 = (iHashCode4 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        j0 j0Var = this.f1911h;
        int iHashCode5 = (i10 ^ (j0Var == null ? 0 : j0Var.hashCode())) * 1000003;
        c0 c0Var = this.i;
        return iHashCode5 ^ (c0Var != null ? c0Var.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.f1905a + ", eventCode=" + this.f1906b + ", complianceData=" + this.f1907c + ", eventUptimeMs=" + this.f1908d + ", sourceExtension=" + Arrays.toString(this.f1909e) + ", sourceExtensionJsonProto3=" + this.f + ", timezoneOffsetSeconds=" + this.f1910g + ", networkConnectionInfo=" + this.f1911h + ", experimentIds=" + this.i + "}";
    }
}
