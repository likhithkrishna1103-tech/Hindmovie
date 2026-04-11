package qb;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 extends m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f10615e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u1 f10616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final l2 f10617h;
    public final k2 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final v1 f10618j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f10619k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f10620l;

    public j0(String str, String str2, String str3, long j4, Long l10, boolean z10, u1 u1Var, l2 l2Var, k2 k2Var, v1 v1Var, List list, int i) {
        this.f10611a = str;
        this.f10612b = str2;
        this.f10613c = str3;
        this.f10614d = j4;
        this.f10615e = l10;
        this.f = z10;
        this.f10616g = u1Var;
        this.f10617h = l2Var;
        this.i = k2Var;
        this.f10618j = v1Var;
        this.f10619k = list;
        this.f10620l = i;
    }

    @Override // qb.m2
    public final i0 a() {
        i0 i0Var = new i0();
        i0Var.f10585a = this.f10611a;
        i0Var.f10586b = this.f10612b;
        i0Var.f10587c = this.f10613c;
        i0Var.f10588d = this.f10614d;
        i0Var.f10589e = this.f10615e;
        i0Var.f = this.f;
        i0Var.f10590g = this.f10616g;
        i0Var.f10591h = this.f10617h;
        i0Var.i = this.i;
        i0Var.f10592j = this.f10618j;
        i0Var.f10593k = this.f10619k;
        i0Var.f10594l = this.f10620l;
        i0Var.f10595m = (byte) 7;
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
            List list2 = j0Var.f10619k;
            v1 v1Var2 = j0Var.f10618j;
            k2 k2Var2 = j0Var.i;
            l2 l2Var2 = j0Var.f10617h;
            Long l11 = j0Var.f10615e;
            String str2 = j0Var.f10613c;
            if (this.f10611a.equals(j0Var.f10611a) && this.f10612b.equals(j0Var.f10612b) && ((str = this.f10613c) != null ? str.equals(str2) : str2 == null) && this.f10614d == j0Var.f10614d && ((l10 = this.f10615e) != null ? l10.equals(l11) : l11 == null) && this.f == j0Var.f && this.f10616g.equals(j0Var.f10616g) && ((l2Var = this.f10617h) != null ? l2Var.equals(l2Var2) : l2Var2 == null) && ((k2Var = this.i) != null ? k2Var.equals(k2Var2) : k2Var2 == null) && ((v1Var = this.f10618j) != null ? v1Var.equals(v1Var2) : v1Var2 == null) && ((list = this.f10619k) != null ? list.equals(list2) : list2 == null) && this.f10620l == j0Var.f10620l) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((this.f10611a.hashCode() ^ 1000003) * 1000003) ^ this.f10612b.hashCode()) * 1000003;
        String str = this.f10613c;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        long j4 = this.f10614d;
        int i = (((iHashCode ^ iHashCode2) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        Long l10 = this.f10615e;
        int iHashCode3 = (((((i ^ (l10 == null ? 0 : l10.hashCode())) * 1000003) ^ (this.f ? 1231 : 1237)) * 1000003) ^ this.f10616g.hashCode()) * 1000003;
        l2 l2Var = this.f10617h;
        int iHashCode4 = (iHashCode3 ^ (l2Var == null ? 0 : l2Var.hashCode())) * 1000003;
        k2 k2Var = this.i;
        int iHashCode5 = (iHashCode4 ^ (k2Var == null ? 0 : k2Var.hashCode())) * 1000003;
        v1 v1Var = this.f10618j;
        int iHashCode6 = (iHashCode5 ^ (v1Var == null ? 0 : v1Var.hashCode())) * 1000003;
        List list = this.f10619k;
        return ((iHashCode6 ^ (list != null ? list.hashCode() : 0)) * 1000003) ^ this.f10620l;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Session{generator=");
        sb.append(this.f10611a);
        sb.append(", identifier=");
        sb.append(this.f10612b);
        sb.append(", appQualitySessionId=");
        sb.append(this.f10613c);
        sb.append(", startedAt=");
        sb.append(this.f10614d);
        sb.append(", endedAt=");
        sb.append(this.f10615e);
        sb.append(", crashed=");
        sb.append(this.f);
        sb.append(", app=");
        sb.append(this.f10616g);
        sb.append(", user=");
        sb.append(this.f10617h);
        sb.append(", os=");
        sb.append(this.i);
        sb.append(", device=");
        sb.append(this.f10618j);
        sb.append(", events=");
        sb.append(this.f10619k);
        sb.append(", generatorType=");
        return q4.a.o(sb, this.f10620l, "}");
    }
}
