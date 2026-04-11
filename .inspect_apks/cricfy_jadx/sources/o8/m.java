package o8;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f9681b = new m(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9682a;

    public /* synthetic */ m(String str) {
        this.f9682a = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            return u.j(this.f9682a, ((m) obj).f9682a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9682a});
    }
}
