package q0;

import android.view.DisplayCutout;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DisplayCutout f10459a;

    public j(DisplayCutout displayCutout) {
        this.f10459a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f10459a, ((j) obj).f10459a);
    }

    public final int hashCode() {
        return this.f10459a.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f10459a + "}";
    }
}
