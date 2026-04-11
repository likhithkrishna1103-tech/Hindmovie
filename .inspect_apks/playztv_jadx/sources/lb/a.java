package lb;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f8071b;

    public a(String str, ArrayList arrayList) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f8070a = str;
        this.f8071b = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f8070a.equals(aVar.f8070a) && this.f8071b.equals(aVar.f8071b);
    }

    public final int hashCode() {
        return ((this.f8070a.hashCode() ^ 1000003) * 1000003) ^ this.f8071b.hashCode();
    }

    public final String toString() {
        return "HeartBeatResult{userAgent=" + this.f8070a + ", usedDates=" + this.f8071b + "}";
    }
}
