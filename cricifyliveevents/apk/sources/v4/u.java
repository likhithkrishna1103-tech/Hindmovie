package v4;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends s {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ v f13373q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(v vVar, Context context) {
        super(context);
        this.f13373q = vVar;
    }

    @Override // v4.s
    public final float d(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // v4.s
    public final int e(int i) {
        return Math.min(100, super.e(i));
    }

    @Override // v4.s
    public final void h(View view, r0 r0Var) {
        v vVar = this.f13373q;
        int[] iArrA = vVar.a(vVar.f13374a.getLayoutManager(), view);
        int i = iArrA[0];
        int i10 = iArrA[1];
        int iCeil = (int) Math.ceil(((double) e(Math.max(Math.abs(i), Math.abs(i10)))) / 0.3356d);
        if (iCeil > 0) {
            r0Var.f13340a = i;
            r0Var.f13341b = i10;
            r0Var.f13342c = iCeil;
            r0Var.f13344e = this.f13353j;
            r0Var.f = true;
        }
    }
}
