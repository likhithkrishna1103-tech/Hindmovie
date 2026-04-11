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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class n extends v implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public boolean A0;
    public Dialog C0;
    public boolean D0;
    public boolean E0;
    public boolean F0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public Handler f1301r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final e f1302s0 = new e(1, this);

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final k f1303t0 = new k(this);

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final l f1304u0 = new l(this);

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f1305v0 = 0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f1306w0 = 0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f1307x0 = true;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f1308y0 = true;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f1309z0 = -1;
    public final u5.c B0 = new u5.c(2, this);
    public boolean G0 = false;

    @Override // androidx.fragment.app.v
    public void A(Bundle bundle) {
        Dialog dialog = this.C0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i = this.f1305v0;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i10 = this.f1306w0;
        if (i10 != 0) {
            bundle.putInt("android:theme", i10);
        }
        boolean z2 = this.f1307x0;
        if (!z2) {
            bundle.putBoolean("android:cancelable", z2);
        }
        boolean z10 = this.f1308y0;
        if (!z10) {
            bundle.putBoolean("android:showsDialog", z10);
        }
        int i11 = this.f1309z0;
        if (i11 != -1) {
            bundle.putInt("android:backStackId", i11);
        }
    }

    @Override // androidx.fragment.app.v
    public void B() {
        this.Y = true;
        Dialog dialog = this.C0;
        if (dialog != null) {
            this.D0 = false;
            dialog.show();
            View decorView = this.C0.getWindow().getDecorView();
            be.h.e(decorView, "<this>");
            decorView.setTag(m1.a.view_tree_lifecycle_owner, this);
            decorView.setTag(n1.d.view_tree_view_model_store_owner, this);
            decorView.setTag(x4.a.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // androidx.fragment.app.v
    public void C() {
        this.Y = true;
        Dialog dialog = this.C0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.v
    public final void E(Bundle bundle) {
        Bundle bundle2;
        this.Y = true;
        if (this.C0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.C0.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.v
    public final void F(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.F(layoutInflater, viewGroup, bundle);
        if (this.f1378a0 != null || this.C0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.C0.onRestoreInstanceState(bundle2);
    }

    public final void P(boolean z2, boolean z10) {
        if (this.E0) {
            return;
        }
        this.E0 = true;
        this.F0 = false;
        Dialog dialog = this.C0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.C0.dismiss();
            if (!z10) {
                if (Looper.myLooper() == this.f1301r0.getLooper()) {
                    onDismiss(this.C0);
                } else {
                    this.f1301r0.post(this.f1302s0);
                }
            }
        }
        this.D0 = true;
        if (this.f1309z0 >= 0) {
            n0 n0VarL = l();
            int i = this.f1309z0;
            if (i < 0) {
                throw new IllegalArgumentException(e6.j.l("Bad id: ", i));
            }
            n0VarL.v(new m0(n0VarL, i), z2);
            this.f1309z0 = -1;
            return;
        }
        a aVar = new a(l());
        aVar.f1238p = true;
        aVar.g(this);
        if (z2) {
            aVar.d(true);
        } else {
            aVar.d(false);
        }
    }

    public Dialog Q(Bundle bundle) {
        if (n0.G(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new c.n(H(), this.f1306w0);
    }

    public void R(n0 n0Var, String str) {
        this.E0 = false;
        this.F0 = true;
        n0Var.getClass();
        a aVar = new a(n0Var);
        aVar.f1238p = true;
        aVar.e(0, this, str, 1);
        aVar.d(false);
    }

    @Override // androidx.fragment.app.v
    public final ga.b b() {
        return new m(this, new q(this));
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.D0) {
            return;
        }
        if (n0.G(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        P(true, true);
    }

    @Override // androidx.fragment.app.v
    public final void s() {
        this.Y = true;
    }

    @Override // androidx.fragment.app.v
    public final void u(Context context) {
        super.u(context);
        this.f1388k0.d(this.B0);
        if (this.F0) {
            return;
        }
        this.E0 = false;
    }

    @Override // androidx.fragment.app.v
    public void v(Bundle bundle) {
        super.v(bundle);
        this.f1301r0 = new Handler();
        this.f1308y0 = this.R == 0;
        if (bundle != null) {
            this.f1305v0 = bundle.getInt("android:style", 0);
            this.f1306w0 = bundle.getInt("android:theme", 0);
            this.f1307x0 = bundle.getBoolean("android:cancelable", true);
            this.f1308y0 = bundle.getBoolean("android:showsDialog", this.f1308y0);
            this.f1309z0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.v
    public final void x() {
        this.Y = true;
        Dialog dialog = this.C0;
        if (dialog != null) {
            this.D0 = true;
            dialog.setOnDismissListener(null);
            this.C0.dismiss();
            if (!this.E0) {
                onDismiss(this.C0);
            }
            this.C0 = null;
            this.G0 = false;
        }
    }

    @Override // androidx.fragment.app.v
    public final void y() {
        this.Y = true;
        if (!this.F0 && !this.E0) {
            this.E0 = true;
        }
        androidx.lifecycle.y yVar = this.f1388k0;
        yVar.getClass();
        androidx.lifecycle.y.a("removeObserver");
        androidx.lifecycle.x xVar = (androidx.lifecycle.x) yVar.f1517b.d(this.B0);
        if (xVar == null) {
            return;
        }
        xVar.c();
        xVar.b(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048 A[Catch: all -> 0x0050, TryCatch #0 {all -> 0x0050, blocks: (B:12:0x001a, B:14:0x0026, B:24:0x003e, B:26:0x0048, B:29:0x0052, B:20:0x0030, B:22:0x0036, B:23:0x003b, B:30:0x006a), top: B:49:0x001a }] */
    @Override // androidx.fragment.app.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.LayoutInflater z(android.os.Bundle r8) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.n.z(android.os.Bundle):android.view.LayoutInflater");
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }
}
