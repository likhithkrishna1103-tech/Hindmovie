package qb;

import v.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f11172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f11173e;

    public a(String str, String str2, String str3, b bVar, int i) {
        this.f11169a = str;
        this.f11170b = str2;
        this.f11171c = str3;
        this.f11172d = bVar;
        this.f11173e = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        int i = aVar.f11173e;
        b bVar = aVar.f11172d;
        String str = aVar.f11171c;
        String str2 = aVar.f11170b;
        String str3 = aVar.f11169a;
        String str4 = this.f11169a;
        if (str4 == null) {
            if (str3 != null) {
                return false;
            }
        } else if (!str4.equals(str3)) {
            return false;
        }
        String str5 = this.f11170b;
        if (str5 == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str5.equals(str2)) {
            return false;
        }
        String str6 = this.f11171c;
        if (str6 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str6.equals(str)) {
            return false;
        }
        b bVar2 = this.f11172d;
        if (bVar2 == null) {
            if (bVar != null) {
                return false;
            }
        } else if (!bVar2.equals(bVar)) {
            return false;
        }
        int i10 = this.f11173e;
        return i10 == 0 ? i == 0 : e.a(i10, i);
    }

    public final int hashCode() {
        String str = this.f11169a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f11170b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f11171c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        b bVar = this.f11172d;
        int iHashCode4 = (iHashCode3 ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        int i = this.f11173e;
        return (i != 0 ? e.c(i) : 0) ^ iHashCode4;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("InstallationResponse{uri=");
        sb2.append(this.f11169a);
        sb2.append(", fid=");
        sb2.append(this.f11170b);
        sb2.append(", refreshToken=");
        sb2.append(this.f11171c);
        sb2.append(", authToken=");
        sb2.append(this.f11172d);
        sb2.append(", responseCode=");
        int i = this.f11173e;
        sb2.append(i != 1 ? i != 2 ? "null" : "BAD_CONFIG" : "OK");
        sb2.append("}");
        return sb2.toString();
    }
}
