package ta;

import java.io.File;
import wa.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f12348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f12350c;

    public a(b0 b0Var, String str, File file) {
        this.f12348a = b0Var;
        if (str == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.f12349b = str;
        this.f12350c = file;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f12348a.equals(aVar.f12348a) && this.f12349b.equals(aVar.f12349b) && this.f12350c.equals(aVar.f12350c);
    }

    public final int hashCode() {
        return ((((this.f12348a.hashCode() ^ 1000003) * 1000003) ^ this.f12349b.hashCode()) * 1000003) ^ this.f12350c.hashCode();
    }

    public final String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f12348a + ", sessionId=" + this.f12349b + ", reportFile=" + this.f12350c + "}";
    }
}
