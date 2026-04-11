package oa;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ View f9729v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ k f9730w;

    public j(k kVar, View view) {
        this.f9730w = kVar;
        this.f9729v = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        View view2 = this.f9729v;
        if (view2.getVisibility() == 0) {
            this.f9730w.c(view2);
        }
    }
}
