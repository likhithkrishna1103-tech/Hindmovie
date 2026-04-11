package l8;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class c extends DialogFragment {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Dialog f7881v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public DialogInterface.OnCancelListener f7882w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public AlertDialog f7883x;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f7882w;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f7881v;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f7883x == null) {
            Activity activity = getActivity();
            o8.u.g(activity);
            this.f7883x = new AlertDialog.Builder(activity).create();
        }
        return this.f7883x;
    }
}
