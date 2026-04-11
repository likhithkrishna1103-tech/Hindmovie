package n;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j0 implements p0, DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public h.g f8414u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public k0 f8415v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public CharSequence f8416w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ q0 f8417x;

    public j0(q0 q0Var) {
        this.f8417x = q0Var;
    }

    @Override // n.p0
    public final boolean a() {
        h.g gVar = this.f8414u;
        if (gVar != null) {
            return gVar.isShowing();
        }
        return false;
    }

    @Override // n.p0
    public final int b() {
        return 0;
    }

    @Override // n.p0
    public final Drawable c() {
        return null;
    }

    @Override // n.p0
    public final void dismiss() {
        h.g gVar = this.f8414u;
        if (gVar != null) {
            gVar.dismiss();
            this.f8414u = null;
        }
    }

    @Override // n.p0
    public final void f(CharSequence charSequence) {
        this.f8416w = charSequence;
    }

    @Override // n.p0
    public final void g(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // n.p0
    public final void i(int i) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // n.p0
    public final void j(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // n.p0
    public final void k(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // n.p0
    public final void l(int i, int i10) {
        if (this.f8415v == null) {
            return;
        }
        q0 q0Var = this.f8417x;
        h.f fVar = new h.f(q0Var.getPopupContext());
        CharSequence charSequence = this.f8416w;
        if (charSequence != null) {
            fVar.setTitle(charSequence);
        }
        k0 k0Var = this.f8415v;
        int selectedItemPosition = q0Var.getSelectedItemPosition();
        h.c cVar = fVar.f5489a;
        cVar.f5453p = k0Var;
        cVar.f5454q = this;
        cVar.f5457t = selectedItemPosition;
        cVar.f5456s = true;
        h.g gVarCreate = fVar.create();
        this.f8414u = gVarCreate;
        AlertController$RecycleListView alertController$RecycleListView = gVarCreate.A.f;
        alertController$RecycleListView.setTextDirection(i);
        alertController$RecycleListView.setTextAlignment(i10);
        this.f8414u.show();
    }

    @Override // n.p0
    public final int m() {
        return 0;
    }

    @Override // n.p0
    public final CharSequence n() {
        return this.f8416w;
    }

    @Override // n.p0
    public final void o(ListAdapter listAdapter) {
        this.f8415v = (k0) listAdapter;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        q0 q0Var = this.f8417x;
        q0Var.setSelection(i);
        if (q0Var.getOnItemClickListener() != null) {
            q0Var.performItemClick(null, i, this.f8415v.getItemId(i));
        }
        dismiss();
    }
}
