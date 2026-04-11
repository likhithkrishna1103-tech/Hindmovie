package n8;

import java.util.Arrays;
import o8.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i2.k f8859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o8.m f8860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8861d;

    public a(i2.k kVar, o8.m mVar, String str) {
        this.f8859b = kVar;
        this.f8860c = mVar;
        this.f8861d = str;
        this.f8858a = Arrays.hashCode(new Object[]{kVar, mVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return u.j(this.f8859b, aVar.f8859b) && u.j(this.f8860c, aVar.f8860c) && u.j(this.f8861d, aVar.f8861d);
    }

    public final int hashCode() {
        return this.f8858a;
    }
}
