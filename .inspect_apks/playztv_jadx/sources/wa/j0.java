package wa;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f13912e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u1 f13913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l2 f13914h;
    public final k2 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final v1 f13915j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f13916k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f13917l;

    public j0(String str, String str2, String str3, long j5, Long l10, boolean z2, u1 u1Var, l2 l2Var, k2 k2Var, v1 v1Var, List list, int i) {
        this.f13908a = str;
        this.f13909b = str2;
        this.f13910c = str3;
        this.f13911d = j5;
        this.f13912e = l10;
        this.f = z2;
        this.f13913g = u1Var;
        this.f13914h = l2Var;
        this.i = k2Var;
        this.f13915j = v1Var;
        this.f13916k = list;
        this.f13917l = i;
    }

    @Override // wa.m2
    public final i0 a() {
        i0 i0Var = new i0();
        i0Var.f13882a = this.f13908a;
        i0Var.f13883b = this.f13909b;
        i0Var.f13884c = this.f13910c;
        i0Var.f13885d = this.f13911d;
        i0Var.f13886e = this.f13912e;
        i0Var.f = this.f;
        i0Var.f13887g = this.f13913g;
        i0Var.f13888h = this.f13914h;
        i0Var.i = this.i;
        i0Var.f13889j = this.f13915j;
        i0Var.f13890k = this.f13916k;
        i0Var.f13891l = this.f13917l;
        i0Var.f13892m = (byte) 7;
        return i0Var;
    }

    public final boolean equals(Object obj) {
        String str;
        Long l10;
        l2 l2Var;
        k2 k2Var;
        v1 v1Var;
        List list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof m2) {
            j0 j0Var = (j0) ((m2) obj);
            List list2 = j0Var.f13916k;
            v1 v1Var2 = j0Var.f13915j;
            k2 k2Var2 = j0Var.i;
            l2 l2Var2 = j0Var.f13914h;
            Long l11 = j0Var.f13912e;
            String str2 = j0Var.f13910c;
            if (this.f13908a.equals(j0Var.f13908a) && this.f13909b.equals(j0Var.f13909b) && ((str = this.f13910c) != null ? str.equals(str2) : str2 == null) && this.f13911d == j0Var.f13911d && ((l10 = this.f13912e) != null ? l10.equals(l11) : l11 == null) && this.f == j0Var.f && this.f13913g.equals(j0Var.f13913g) && ((l2Var = this.f13914h) != null ? l2Var.equals(l2Var2) : l2Var2 == null) && ((k2Var = this.i) != null ? k2Var.equals(k2Var2) : k2Var2 == null) && ((v1Var = this.f13915j) != null ? v1Var.equals(v1Var2) : v1Var2 == null) && ((list = this.f13916k) != null ? list.equals(list2) : list2 == null) && this.f13917l == j0Var.f13917l) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.f13908a.hashCode() ^ 1000003) * 1000003) ^ this.f13909b.hashCode()) * 1000003;
        String str = this.f13910c;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        long j5 = this.f13911d;
        int i = (((iHashCode ^ iHashCode2) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        Long l10 = this.f13912e;
        int iHashCode3 = (((((i ^ (l10 == null ? 0 : l10.hashCode())) * 1000003) ^ (this.f ? 1231 : 1237)) * 1000003) ^ this.f13913g.hashCode()) * 1000003;
        l2 l2Var = this.f13914h;
        int iHashCode4 = (iHashCode3 ^ (l2Var == null ? 0 : l2Var.hashCode())) * 1000003;
        k2 k2Var = this.i;
        int iHashCode5 = (iHashCode4 ^ (k2Var == null ? 0 : k2Var.hashCode())) * 1000003;
        v1 v1Var = this.f13915j;
        int iHashCode6 = (iHashCode5 ^ (v1Var == null ? 0 : v1Var.hashCode())) * 1000003;
        List list = this.f13916k;
        return ((iHashCode6 ^ (list != null ? list.hashCode() : 0)) * 1000003) ^ this.f13917l;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Session{generator=");
        sb2.append(this.f13908a);
        sb2.append(", identifier=");
        sb2.append(this.f13909b);
        sb2.append(", appQualitySessionId=");
        sb2.append(this.f13910c);
        sb2.append(", startedAt=");
        sb2.append(this.f13911d);
        sb2.append(", endedAt=");
        sb2.append(this.f13912e);
        sb2.append(", crashed=");
        sb2.append(this.f);
        sb2.append(", app=");
        sb2.append(this.f13913g);
        sb2.append(", user=");
        sb2.append(this.f13914h);
        sb2.append(", os=");
        sb2.append(this.i);
        sb2.append(", device=");
        sb2.append(this.f13915j);
        sb2.append(", events=");
        sb2.append(this.f13916k);
        sb2.append(", generatorType=");
        return x.c.a(sb2, this.f13917l, "}");
    }
}
