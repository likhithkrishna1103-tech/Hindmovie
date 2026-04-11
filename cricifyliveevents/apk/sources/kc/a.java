package kc;

import y.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f7403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7404e;

    public a(String str, String str2, String str3, b bVar, int i) {
        this.f7400a = str;
        this.f7401b = str2;
        this.f7402c = str3;
        this.f7403d = bVar;
        this.f7404e = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        int i = aVar.f7404e;
        b bVar = aVar.f7403d;
        String str = aVar.f7402c;
        String str2 = aVar.f7401b;
        String str3 = aVar.f7400a;
        String str4 = this.f7400a;
        if (str4 == null) {
            if (str3 != null) {
                return false;
            }
        } else if (!str4.equals(str3)) {
            return false;
        }
        String str5 = this.f7401b;
        if (str5 == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str5.equals(str2)) {
            return false;
        }
        String str6 = this.f7402c;
        if (str6 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str6.equals(str)) {
            return false;
        }
        b bVar2 = this.f7403d;
        if (bVar2 == null) {
            if (bVar != null) {
                return false;
            }
        } else if (!bVar2.equals(bVar)) {
            return false;
        }
        int i10 = this.f7404e;
        return i10 == 0 ? i == 0 : e.a(i10, i);
    }

    public final int hashCode() {
        String str = this.f7400a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f7401b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f7402c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        b bVar = this.f7403d;
        int iHashCode4 = (iHashCode3 ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        int i = this.f7404e;
        return (i != 0 ? e.c(i) : 0) ^ iHashCode4;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallationResponse{uri=");
        sb.append(this.f7400a);
        sb.append(", fid=");
        sb.append(this.f7401b);
        sb.append(", refreshToken=");
        sb.append(this.f7402c);
        sb.append(", authToken=");
        sb.append(this.f7403d);
        sb.append(", responseCode=");
        int i = this.f7404e;
        sb.append(i != 1 ? i != 2 ? "null" : "BAD_CONFIG" : "OK");
        sb.append("}");
        return sb.toString();
    }
}
