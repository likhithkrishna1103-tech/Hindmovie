package v1;

import android.net.Uri;
import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d0 f12622d = new d0(new l7.a(20, false));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12623e;
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12624g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f12625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f12627c;

    static {
        int i = y1.a0.f14551a;
        f12623e = Integer.toString(0, 36);
        f = Integer.toString(1, 36);
        f12624g = Integer.toString(2, 36);
    }

    public d0(l7.a aVar) {
        this.f12625a = (Uri) aVar.f7866w;
        this.f12626b = (String) aVar.f7867x;
        this.f12627c = (Bundle) aVar.f7868y;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        if (Objects.equals(this.f12625a, d0Var.f12625a) && Objects.equals(this.f12626b, d0Var.f12626b)) {
            if ((this.f12627c == null) == (d0Var.f12627c == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Uri uri = this.f12625a;
        int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
        String str = this.f12626b;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + (this.f12627c != null ? 1 : 0);
    }
}
