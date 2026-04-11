package qb;

import aa.l0;
import v.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f11175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11176c;

    public b(int i, long j5, String str) {
        this.f11174a = str;
        this.f11175b = j5;
        this.f11176c = i;
    }

    public static l0 a() {
        l0 l0Var = new l0();
        l0Var.f707x = 0L;
        return l0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        int i = bVar.f11176c;
        String str = bVar.f11174a;
        String str2 = this.f11174a;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (this.f11175b != bVar.f11175b) {
            return false;
        }
        int i10 = this.f11176c;
        return i10 == 0 ? i == 0 : e.a(i10, i);
    }

    public final int hashCode() {
        String str = this.f11174a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j5 = this.f11175b;
        int i = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        int i10 = this.f11176c;
        return (i10 != 0 ? e.c(i10) : 0) ^ i;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("TokenResult{token=");
        sb2.append(this.f11174a);
        sb2.append(", tokenExpirationTimestamp=");
        sb2.append(this.f11175b);
        sb2.append(", responseCode=");
        int i = this.f11176c;
        sb2.append(i != 1 ? i != 2 ? i != 3 ? "null" : "AUTH_ERROR" : "BAD_CONFIG" : "OK");
        sb2.append("}");
        return sb2.toString();
    }
}
