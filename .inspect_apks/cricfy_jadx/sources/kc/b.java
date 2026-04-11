package kc;

import y.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f7406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7407c;

    public b(int i, long j4, String str) {
        this.f7405a = str;
        this.f7406b = j4;
        this.f7407c = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        int i = bVar.f7407c;
        String str = bVar.f7405a;
        String str2 = this.f7405a;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (this.f7406b != bVar.f7406b) {
            return false;
        }
        int i10 = this.f7407c;
        return i10 == 0 ? i == 0 : e.a(i10, i);
    }

    public final int hashCode() {
        String str = this.f7405a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j4 = this.f7406b;
        int i = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        int i10 = this.f7407c;
        return (i10 != 0 ? e.c(i10) : 0) ^ i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TokenResult{token=");
        sb.append(this.f7405a);
        sb.append(", tokenExpirationTimestamp=");
        sb.append(this.f7406b);
        sb.append(", responseCode=");
        int i = this.f7407c;
        sb.append(i != 1 ? i != 2 ? i != 3 ? "null" : "AUTH_ERROR" : "BAD_CONFIG" : "OK");
        sb.append("}");
        return sb.toString();
    }
}
