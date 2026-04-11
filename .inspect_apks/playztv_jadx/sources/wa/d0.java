package wa;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f13831e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f13832g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f13833h;
    public final List i;

    public d0(int i, String str, int i10, int i11, long j5, long j8, long j10, String str2, List list) {
        this.f13827a = i;
        this.f13828b = str;
        this.f13829c = i10;
        this.f13830d = i11;
        this.f13831e = j5;
        this.f = j8;
        this.f13832g = j10;
        this.f13833h = str2;
        this.i = list;
    }

    public final boolean equals(Object obj) {
        String str;
        List list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof p1) {
            d0 d0Var = (d0) ((p1) obj);
            List list2 = d0Var.i;
            String str2 = d0Var.f13833h;
            if (this.f13827a == d0Var.f13827a && this.f13828b.equals(d0Var.f13828b) && this.f13829c == d0Var.f13829c && this.f13830d == d0Var.f13830d && this.f13831e == d0Var.f13831e && this.f == d0Var.f && this.f13832g == d0Var.f13832g && ((str = this.f13833h) != null ? str.equals(str2) : str2 == null) && ((list = this.i) != null ? list.equals(list2) : list2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f13827a ^ 1000003) * 1000003) ^ this.f13828b.hashCode()) * 1000003) ^ this.f13829c) * 1000003) ^ this.f13830d) * 1000003;
        long j5 = this.f13831e;
        int i = (iHashCode ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        long j8 = this.f;
        int i10 = (i ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        long j10 = this.f13832g;
        int i11 = (i10 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        String str = this.f13833h;
        int iHashCode2 = (i11 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.i;
        return iHashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "ApplicationExitInfo{pid=" + this.f13827a + ", processName=" + this.f13828b + ", reasonCode=" + this.f13829c + ", importance=" + this.f13830d + ", pss=" + this.f13831e + ", rss=" + this.f + ", timestamp=" + this.f13832g + ", traceFile=" + this.f13833h + ", buildIdMappingForArch=" + this.i + "}";
    }
}
