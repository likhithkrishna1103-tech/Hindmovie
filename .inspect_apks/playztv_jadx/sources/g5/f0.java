package g5;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f0 extends e0 {
    @Override // g5.e0
    public final void A(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // g5.e0
    public final void B(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    @Override // cf.d
    public final float q(View view) {
        return view.getTransitionAlpha();
    }

    @Override // cf.d
    public final void x(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // g5.e0, cf.d
    public final void y(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // g5.e0
    public final void z(View view, int i, int i10, int i11, int i12) {
        view.setLeftTopRightBottom(i, i10, i11, i12);
    }
}
