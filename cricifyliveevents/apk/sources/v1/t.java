package v1;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12991b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f12992a;

    static {
        int i = y1.a0.f14551a;
        f12991b = Integer.toString(0, 36);
    }

    public t(r0 r0Var) {
        this.f12992a = (Uri) r0Var.f12977a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t) && this.f12992a.equals(((t) obj).f12992a);
    }

    public final int hashCode() {
        return this.f12992a.hashCode() * 31;
    }
}
