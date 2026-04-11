package l5;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends c0 {
    @Override // android.support.v4.media.session.b
    public final void L(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // l5.c0, android.support.v4.media.session.b
    public final void M(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // l5.c0
    public final void R(View view, int i, int i10, int i11, int i12) {
        view.setLeftTopRightBottom(i, i10, i11, i12);
    }

    @Override // l5.c0
    public final void S(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // l5.c0
    public final void T(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    @Override // android.support.v4.media.session.b
    public final float z(View view) {
        return view.getTransitionAlpha();
    }
}
