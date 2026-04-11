package q7;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class j extends androidx.fragment.app.n {
    public Dialog H0;
    public DialogInterface.OnCancelListener I0;
    public AlertDialog J0;

    @Override // androidx.fragment.app.n
    public final Dialog Q(Bundle bundle) {
        Dialog dialog = this.H0;
        if (dialog != null) {
            return dialog;
        }
        this.f1308y0 = false;
        if (this.J0 == null) {
            Context contextJ = j();
            v.h(contextJ);
            this.J0 = new AlertDialog.Builder(contextJ).create();
        }
        return this.J0;
    }

    @Override // androidx.fragment.app.n, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.I0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
