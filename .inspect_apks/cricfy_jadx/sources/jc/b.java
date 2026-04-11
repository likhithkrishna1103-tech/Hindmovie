package jc;

import l0.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f6735h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f6740e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f6741g;

    static {
        byte b8 = (byte) (((byte) (0 | 2)) | 1);
        if (b8 == 3) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if ((b8 & 1) == 0) {
            sb.append(" expiresInSecs");
        }
        if ((b8 & 2) == 0) {
            sb.append(" tokenCreationEpochInSecs");
        }
        throw new IllegalStateException(e.l("Missing required properties:", sb));
    }

    public b(String str, int i, String str2, String str3, long j4, long j7, String str4) {
        this.f6736a = str;
        this.f6737b = i;
        this.f6738c = str2;
        this.f6739d = str3;
        this.f6740e = j4;
        this.f = j7;
        this.f6741g = str4;
    }

    public final a a() {
        a aVar = new a();
        aVar.f6728a = this.f6736a;
        aVar.f6729b = this.f6737b;
        aVar.f6730c = this.f6738c;
        aVar.f6731d = this.f6739d;
        aVar.f6732e = this.f6740e;
        aVar.f = this.f;
        aVar.f6733g = this.f6741g;
        aVar.f6734h = (byte) 3;
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        String str = bVar.f6741g;
        String str2 = bVar.f6739d;
        String str3 = bVar.f6738c;
        String str4 = bVar.f6736a;
        String str5 = this.f6736a;
        if (str5 == null) {
            if (str4 != null) {
                return false;
            }
        } else if (!str5.equals(str4)) {
            return false;
        }
        if (!y.e.a(this.f6737b, bVar.f6737b)) {
            return false;
        }
        String str6 = this.f6738c;
        if (str6 == null) {
            if (str3 != null) {
                return false;
            }
        } else if (!str6.equals(str3)) {
            return false;
        }
        String str7 = this.f6739d;
        if (str7 == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str7.equals(str2)) {
            return false;
        }
        if (this.f6740e != bVar.f6740e || this.f != bVar.f) {
            return false;
        }
        String str8 = this.f6741g;
        return str8 == null ? str == null : str8.equals(str);
    }

    public final int hashCode() {
        String str = this.f6736a;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ y.e.c(this.f6737b)) * 1000003;
        String str2 = this.f6738c;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f6739d;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j4 = this.f6740e;
        int i = (iHashCode3 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j7 = this.f;
        int i10 = (i ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003;
        String str4 = this.f6741g;
        return (str4 != null ? str4.hashCode() : 0) ^ i10;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PersistedInstallationEntry{firebaseInstallationId=");
        sb.append(this.f6736a);
        sb.append(", registrationStatus=");
        int i = this.f6737b;
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "REGISTER_ERROR" : "REGISTERED" : "UNREGISTERED" : "NOT_GENERATED" : "ATTEMPT_MIGRATION");
        sb.append(", authToken=");
        sb.append(this.f6738c);
        sb.append(", refreshToken=");
        sb.append(this.f6739d);
        sb.append(", expiresInSecs=");
        sb.append(this.f6740e);
        sb.append(", tokenCreationEpochInSecs=");
        sb.append(this.f);
        sb.append(", fisError=");
        return q4.a.q(sb, this.f6741g, "}");
    }
}
