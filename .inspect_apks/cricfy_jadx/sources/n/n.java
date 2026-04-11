package n;

import android.view.ActionProvider;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements ActionProvider.VisibilityListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kf.i f8568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActionProvider f8569b;

    public n(r rVar, ActionProvider actionProvider) {
        this.f8569b = actionProvider;
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z10) {
        kf.i iVar = this.f8568a;
        if (iVar != null) {
            k kVar = ((m) iVar.f7483w).f8555n;
            kVar.f8525h = true;
            kVar.p(true);
        }
    }
}
