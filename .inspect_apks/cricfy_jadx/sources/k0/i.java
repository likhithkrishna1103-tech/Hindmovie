package k0;

import android.content.res.Resources;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f6772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources.Theme f6773b;

    public i(Resources resources, Resources.Theme theme) {
        this.f6772a = resources;
        this.f6773b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (this.f6772a.equals(iVar.f6772a) && Objects.equals(this.f6773b, iVar.f6773b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f6772a, this.f6773b);
    }
}
