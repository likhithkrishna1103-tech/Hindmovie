package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ n f1296u;

    public l(n nVar) {
        this.f1296u = nVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        n nVar = this.f1296u;
        Dialog dialog = nVar.C0;
        if (dialog != null) {
            nVar.onDismiss(dialog);
        }
    }
}
