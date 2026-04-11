package q4;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v extends t {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ w f10948q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(w wVar, Context context) {
        super(context);
        this.f10948q = wVar;
    }

    @Override // q4.t
    public final float d(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // q4.t
    public final int e(int i) {
        return Math.min(100, super.e(i));
    }

    @Override // q4.t
    public final void h(View view, r0 r0Var) {
        w wVar = this.f10948q;
        int[] iArrA = wVar.a(wVar.f10949a.getLayoutManager(), view);
        int i = iArrA[0];
        int i10 = iArrA[1];
        int iCeil = (int) Math.ceil(((double) e(Math.max(Math.abs(i), Math.abs(i10)))) / 0.3356d);
        if (iCeil > 0) {
            r0Var.f10912a = i;
            r0Var.f10913b = i10;
            r0Var.f10914c = iCeil;
            r0Var.f10916e = this.f10928j;
            r0Var.f = true;
        }
    }
}
