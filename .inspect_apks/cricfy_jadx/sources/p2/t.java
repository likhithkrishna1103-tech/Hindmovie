package p2;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9975c;

    public t(String str, boolean z10, boolean z11) {
        this.f9973a = str;
        this.f9974b = z10;
        this.f9975c = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == t.class) {
            t tVar = (t) obj;
            if (TextUtils.equals(this.f9973a, tVar.f9973a) && this.f9974b == tVar.f9974b && this.f9975c == tVar.f9975c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((l0.e.e(31, 31, this.f9973a) + (this.f9974b ? 1231 : 1237)) * 31) + (this.f9975c ? 1231 : 1237);
    }
}
