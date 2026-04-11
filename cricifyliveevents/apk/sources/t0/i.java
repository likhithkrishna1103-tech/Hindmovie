package t0;

import android.view.DisplayCutout;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DisplayCutout f11762a;

    public i(DisplayCutout displayCutout) {
        this.f11762a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f11762a, ((i) obj).f11762a);
    }

    public final int hashCode() {
        return this.f11762a.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f11762a + "}";
    }
}
