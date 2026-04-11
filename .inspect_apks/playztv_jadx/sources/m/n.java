package m;

import android.view.ActionProvider;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements ActionProvider.VisibilityListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u5.c f8254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActionProvider f8255b;

    public n(r rVar, ActionProvider actionProvider) {
        this.f8255b = actionProvider;
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z2) {
        u5.c cVar = this.f8254a;
        if (cVar != null) {
            k kVar = ((m) cVar.f12782v).f8241n;
            kVar.f8211h = true;
            kVar.p(true);
        }
    }
}
