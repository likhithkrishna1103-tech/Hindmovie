package fc;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f4536b;

    public a(String str, ArrayList arrayList) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f4535a = str;
        this.f4536b = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f4535a.equals(aVar.f4535a) && this.f4536b.equals(aVar.f4536b);
    }

    public final int hashCode() {
        return ((this.f4535a.hashCode() ^ 1000003) * 1000003) ^ this.f4536b.hashCode();
    }

    public final String toString() {
        return "HeartBeatResult{userAgent=" + this.f4535a + ", usedDates=" + this.f4536b + "}";
    }
}
