package q0;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class k1 extends j1 {
    public k1(r1 r1Var, WindowInsets windowInsets) {
        super(r1Var, windowInsets);
    }

    @Override // q0.o1
    public r1 a() {
        return r1.h(null, this.f10454c.consumeDisplayCutout());
    }

    @Override // q0.o1
    public j e() {
        DisplayCutout displayCutout = this.f10454c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new j(displayCutout);
    }

    @Override // q0.i1, q0.o1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k1)) {
            return false;
        }
        k1 k1Var = (k1) obj;
        return Objects.equals(this.f10454c, k1Var.f10454c) && Objects.equals(this.f10457g, k1Var.f10457g) && i1.z(this.f10458h, k1Var.f10458h);
    }

    @Override // q0.o1
    public int hashCode() {
        return this.f10454c.hashCode();
    }
}
