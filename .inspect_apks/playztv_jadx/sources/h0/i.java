package h0;

import android.content.res.Resources;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f5597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources.Theme f5598b;

    public i(Resources resources, Resources.Theme theme) {
        this.f5597a = resources;
        this.f5598b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (this.f5597a.equals(iVar.f5597a) && Objects.equals(this.f5598b, iVar.f5598b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f5597a, this.f5598b);
    }
}
