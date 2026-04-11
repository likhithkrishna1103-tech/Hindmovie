package h4;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f5792a;

    public b0(int i, int i10, String str) {
        if (str == null) {
            throw new NullPointerException("package shouldn't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.f5792a = new c0(i, i10, str);
        } else {
            this.f5792a = new d0(i, i10, str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b0) {
            return this.f5792a.equals(((b0) obj).f5792a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5792a.hashCode();
    }
}
