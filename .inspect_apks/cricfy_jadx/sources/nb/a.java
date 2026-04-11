package nb;

import java.io.File;
import qb.b0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f8922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f8924c;

    public a(b0 b0Var, String str, File file) {
        this.f8922a = b0Var;
        if (str == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.f8923b = str;
        this.f8924c = file;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f8922a.equals(aVar.f8922a) && this.f8923b.equals(aVar.f8923b) && this.f8924c.equals(aVar.f8924c);
    }

    public final int hashCode() {
        return ((((this.f8922a.hashCode() ^ 1000003) * 1000003) ^ this.f8923b.hashCode()) * 1000003) ^ this.f8924c.hashCode();
    }

    public final String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f8922a + ", sessionId=" + this.f8923b + ", reportFile=" + this.f8924c + "}";
    }
}
