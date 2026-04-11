package l8;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class k extends androidx.fragment.app.q {
    public Dialog I0;
    public DialogInterface.OnCancelListener J0;
    public AlertDialog K0;

    @Override // androidx.fragment.app.q
    public final Dialog S(Bundle bundle) {
        Dialog dialog = this.I0;
        if (dialog != null) {
            return dialog;
        }
        this.f1039z0 = false;
        if (this.K0 == null) {
            Context contextJ = j();
            o8.u.g(contextJ);
            this.K0 = new AlertDialog.Builder(contextJ).create();
        }
        return this.K0;
    }

    @Override // androidx.fragment.app.q, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.J0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
