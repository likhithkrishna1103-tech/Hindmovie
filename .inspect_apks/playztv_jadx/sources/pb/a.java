package pb;

import af.h;
import v.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f10304e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f10305g;

    public a(String str, int i, String str2, String str3, long j5, long j8, String str4) {
        this.f10300a = str;
        this.f10301b = i;
        this.f10302c = str2;
        this.f10303d = str3;
        this.f10304e = j5;
        this.f = j8;
        this.f10305g = str4;
    }

    public final h a() {
        h hVar = new h();
        hVar.f814b = this.f10300a;
        hVar.f813a = this.f10301b;
        hVar.f815c = this.f10302c;
        hVar.f816d = this.f10303d;
        hVar.f817e = Long.valueOf(this.f10304e);
        hVar.f = Long.valueOf(this.f);
        hVar.f818g = this.f10305g;
        return hVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        String str = aVar.f10305g;
        String str2 = aVar.f10303d;
        String str3 = aVar.f10302c;
        String str4 = aVar.f10300a;
        String str5 = this.f10300a;
        if (str5 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str5.equals(str4)) {
            return false;
        }
        if (!e.a(this.f10301b, aVar.f10301b)) {
            return false;
        }
        String str6 = this.f10302c;
        if (str6 == null) {
            if (str3 != null) {
                return false;
            }
        } else if (!str6.equals(str3)) {
            return false;
        }
        String str7 = this.f10303d;
        if (str7 == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str7.equals(str2)) {
            return false;
        }
        if (this.f10304e != aVar.f10304e || this.f != aVar.f) {
            return false;
        }
        String str8 = this.f10305g;
        return str8 == null ? str == null : str8.equals(str);
    }

    public final int hashCode() {
        String str = this.f10300a;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ e.c(this.f10301b)) * 1000003;
        String str2 = this.f10302c;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f10303d;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j5 = this.f10304e;
        int i = (iHashCode3 ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        long j8 = this.f;
        int i10 = (i ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003;
        String str4 = this.f10305g;
        return (str4 != null ? str4.hashCode() : 0) ^ i10;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("PersistedInstallationEntry{firebaseInstallationId=");
        sb2.append(this.f10300a);
        sb2.append(", registrationStatus=");
        int i = this.f10301b;
        sb2.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "REGISTER_ERROR" : "REGISTERED" : "UNREGISTERED" : "NOT_GENERATED" : "ATTEMPT_MIGRATION");
        sb2.append(", authToken=");
        sb2.append(this.f10302c);
        sb2.append(", refreshToken=");
        sb2.append(this.f10303d);
        sb2.append(", expiresInSecs=");
        sb2.append(this.f10304e);
        sb2.append(", tokenCreationEpochInSecs=");
        sb2.append(this.f);
        sb2.append(", fisError=");
        return l4.a.o(sb2, this.f10305g, "}");
    }
}
