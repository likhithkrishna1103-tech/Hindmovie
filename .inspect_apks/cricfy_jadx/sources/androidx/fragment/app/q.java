package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.measurement.z3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class q extends y implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public boolean B0;
    public Dialog D0;
    public boolean E0;
    public boolean F0;
    public boolean G0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public Handler f1032s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final m f1033t0 = new m(0, this);

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final n f1034u0 = new n(this);

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final o f1035v0 = new o(this);

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f1036w0 = 0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f1037x0 = 0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f1038y0 = true;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f1039z0 = true;
    public int A0 = -1;
    public final p6.c C0 = new p6.c(2, this);
    public boolean H0 = false;

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048 A[Catch: all -> 0x0050, TryCatch #0 {all -> 0x0050, blocks: (B:12:0x001a, B:14:0x0026, B:24:0x003e, B:26:0x0048, B:29:0x0052, B:20:0x0030, B:22:0x0036, B:23:0x003b, B:30:0x006a), top: B:49:0x001a }] */
    @Override // androidx.fragment.app.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.LayoutInflater A(android.os.Bundle r8) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.q.A(android.os.Bundle):android.view.LayoutInflater");
    }

    @Override // androidx.fragment.app.y
    public void D(Bundle bundle) {
        Dialog dialog = this.D0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i = this.f1036w0;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i10 = this.f1037x0;
        if (i10 != 0) {
            bundle.putInt("android:theme", i10);
        }
        boolean z10 = this.f1038y0;
        if (!z10) {
            bundle.putBoolean("android:cancelable", z10);
        }
        boolean z11 = this.f1039z0;
        if (!z11) {
            bundle.putBoolean("android:showsDialog", z11);
        }
        int i11 = this.A0;
        if (i11 != -1) {
            bundle.putInt("android:backStackId", i11);
        }
    }

    @Override // androidx.fragment.app.y
    public void E() {
        this.Z = true;
        Dialog dialog = this.D0;
        if (dialog != null) {
            this.E0 = false;
            dialog.show();
            View decorView = this.D0.getWindow().getDecorView();
            ge.i.e(decorView, "<this>");
            decorView.setTag(s1.a.view_tree_lifecycle_owner, this);
            decorView.setTag(t1.d.view_tree_view_model_store_owner, this);
            decorView.setTag(b5.a.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // androidx.fragment.app.y
    public void F() {
        this.Z = true;
        Dialog dialog = this.D0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.y
    public final void H(Bundle bundle) {
        Bundle bundle2;
        this.Z = true;
        if (this.D0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.D0.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.y
    public final void I(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.I(layoutInflater, viewGroup, bundle);
        if (this.f1103b0 != null || this.D0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.D0.onRestoreInstanceState(bundle2);
    }

    public final void R(boolean z10, boolean z11) {
        if (this.F0) {
            return;
        }
        this.F0 = true;
        this.G0 = false;
        Dialog dialog = this.D0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.D0.dismiss();
            if (!z11) {
                if (Looper.myLooper() == this.f1032s0.getLooper()) {
                    onDismiss(this.D0);
                } else {
                    this.f1032s0.post(this.f1033t0);
                }
            }
        }
        this.E0 = true;
        if (this.A0 >= 0) {
            r0 r0VarL = l();
            int i = this.A0;
            if (i < 0) {
                throw new IllegalArgumentException(l0.e.g(i, "Bad id: "));
            }
            r0VarL.y(new q0(r0VarL, null, i), z10);
            this.A0 = -1;
            return;
        }
        a aVar = new a(l());
        aVar.f924p = true;
        aVar.h(this);
        if (z10) {
            aVar.e(true);
        } else {
            aVar.e(false);
        }
    }

    public Dialog S(Bundle bundle) {
        if (r0.J(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new c.o(K(), this.f1037x0);
    }

    public final Dialog T() {
        Dialog dialog = this.D0;
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void U(r0 r0Var, String str) {
        this.F0 = false;
        this.G0 = true;
        r0Var.getClass();
        a aVar = new a(r0Var);
        aVar.f924p = true;
        aVar.f(0, this, str, 1);
        aVar.e(false);
    }

    @Override // androidx.fragment.app.y
    public final z3 b() {
        return new p(this, new t(this));
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.E0) {
            return;
        }
        if (r0.J(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        R(true, true);
    }

    @Override // androidx.fragment.app.y
    public final void s() {
        this.Z = true;
    }

    @Override // androidx.fragment.app.y
    public final void u(Context context) {
        super.u(context);
        this.f1113l0.d(this.C0);
        if (this.G0) {
            return;
        }
        this.F0 = false;
    }

    @Override // androidx.fragment.app.y
    public void w(Bundle bundle) {
        super.w(bundle);
        this.f1032s0 = new Handler();
        this.f1039z0 = this.S == 0;
        if (bundle != null) {
            this.f1036w0 = bundle.getInt("android:style", 0);
            this.f1037x0 = bundle.getInt("android:theme", 0);
            this.f1038y0 = bundle.getBoolean("android:cancelable", true);
            this.f1039z0 = bundle.getBoolean("android:showsDialog", this.f1039z0);
            this.A0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.y
    public final void y() {
        this.Z = true;
        Dialog dialog = this.D0;
        if (dialog != null) {
            this.E0 = true;
            dialog.setOnDismissListener(null);
            this.D0.dismiss();
            if (!this.F0) {
                onDismiss(this.D0);
            }
            this.D0 = null;
            this.H0 = false;
        }
    }

    @Override // androidx.fragment.app.y
    public final void z() {
        this.Z = true;
        if (!this.G0 && !this.F0) {
            this.F0 = true;
        }
        androidx.lifecycle.y yVar = this.f1113l0;
        yVar.getClass();
        androidx.lifecycle.y.a("removeObserver");
        androidx.lifecycle.x xVar = (androidx.lifecycle.x) yVar.f1213b.b(this.C0);
        if (xVar == null) {
            return;
        }
        xVar.c();
        xVar.b(false);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }
}
