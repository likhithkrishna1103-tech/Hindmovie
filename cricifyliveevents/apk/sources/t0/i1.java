package t0;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class i1 extends h1 {
    public i1(p1 p1Var, WindowInsets windowInsets) {
        super(p1Var, windowInsets);
    }

    @Override // t0.m1
    public p1 a() {
        return p1.h(null, this.f11756c.consumeDisplayCutout());
    }

    @Override // t0.m1
    public i e() {
        DisplayCutout displayCutout = this.f11756c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new i(displayCutout);
    }

    @Override // t0.g1, t0.m1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i1)) {
            return false;
        }
        i1 i1Var = (i1) obj;
        return Objects.equals(this.f11756c, i1Var.f11756c) && Objects.equals(this.f11759g, i1Var.f11759g) && g1.z(this.f11760h, i1Var.f11760h);
    }

    @Override // t0.m1
    public int hashCode() {
        return this.f11756c.hashCode();
    }
}
