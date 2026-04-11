package q7;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class c extends DialogFragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Dialog f11031u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public DialogInterface.OnCancelListener f11032v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public AlertDialog f11033w;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f11032v;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f11031u;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.f11033w == null) {
            Activity activity = getActivity();
            v.h(activity);
            this.f11033w = new AlertDialog.Builder(activity).create();
        }
        return this.f11033w;
    }
}
