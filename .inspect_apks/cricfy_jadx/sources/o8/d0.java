package o8;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9619c;

    public d0(String str, boolean z10) {
        u.d(str);
        this.f9617a = str;
        u.d("com.google.android.gms");
        this.f9618b = "com.google.android.gms";
        this.f9619c = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return u.j(this.f9617a, d0Var.f9617a) && u.j(this.f9618b, d0Var.f9618b) && u.j(null, null) && this.f9619c == d0Var.f9619c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9617a, this.f9618b, null, 4225, Boolean.valueOf(this.f9619c)});
    }

    public final String toString() {
        String str = this.f9617a;
        if (str != null) {
            return str;
        }
        u.g(null);
        throw null;
    }
}
