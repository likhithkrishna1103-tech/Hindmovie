package l4;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g0 f7710a;

    public e0(int i, int i10, String str) {
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.f7710a = new f0(i, i10, str);
        } else {
            this.f7710a = new g0(i, i10, str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e0) {
            return this.f7710a.equals(((e0) obj).f7710a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7710a.hashCode();
    }
}
