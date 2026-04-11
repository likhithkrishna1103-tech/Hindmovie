package u9;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ View f12811u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ j f12812v;

    public i(j jVar, View view) {
        this.f12812v = jVar;
        this.f12811u = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        View view2 = this.f12811u;
        if (view2.getVisibility() == 0) {
            this.f12812v.c(view2);
        }
    }
}
