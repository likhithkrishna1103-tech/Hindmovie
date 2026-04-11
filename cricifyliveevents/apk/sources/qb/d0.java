package qb;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f10534e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f10535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f10536h;
    public final List i;

    public d0(int i, String str, int i10, int i11, long j4, long j7, long j10, String str2, List list) {
        this.f10530a = i;
        this.f10531b = str;
        this.f10532c = i10;
        this.f10533d = i11;
        this.f10534e = j4;
        this.f = j7;
        this.f10535g = j10;
        this.f10536h = str2;
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
            String str2 = d0Var.f10536h;
            if (this.f10530a == d0Var.f10530a && this.f10531b.equals(d0Var.f10531b) && this.f10532c == d0Var.f10532c && this.f10533d == d0Var.f10533d && this.f10534e == d0Var.f10534e && this.f == d0Var.f && this.f10535g == d0Var.f10535g && ((str = this.f10536h) != null ? str.equals(str2) : str2 == null) && ((list = this.i) != null ? list.equals(list2) : list2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f10530a ^ 1000003) * 1000003) ^ this.f10531b.hashCode()) * 1000003) ^ this.f10532c) * 1000003) ^ this.f10533d) * 1000003;
        long j4 = this.f10534e;
        int i = (iHashCode ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j7 = this.f;
        int i10 = (i ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        long j10 = this.f10535g;
        int i11 = (i10 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        String str = this.f10536h;
        int iHashCode2 = (i11 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.i;
        return iHashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "ApplicationExitInfo{pid=" + this.f10530a + ", processName=" + this.f10531b + ", reasonCode=" + this.f10532c + ", importance=" + this.f10533d + ", pss=" + this.f10534e + ", rss=" + this.f + ", timestamp=" + this.f10535g + ", traceFile=" + this.f10536h + ", buildIdMappingForArch=" + this.i + "}";
    }
}
