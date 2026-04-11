package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ q f1026v;

    public o(q qVar) {
        this.f1026v = qVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        q qVar = this.f1026v;
        Dialog dialog = qVar.D0;
        if (dialog != null) {
            qVar.onDismiss(dialog);
        }
    }
}
