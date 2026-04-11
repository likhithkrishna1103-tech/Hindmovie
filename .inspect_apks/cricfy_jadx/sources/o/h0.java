package o;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements n0, DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public h.h f9237v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public i0 f9238w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f9239x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ o0 f9240y;

    public h0(o0 o0Var) {
        this.f9240y = o0Var;
    }

    @Override // o.n0
    public final boolean a() {
        h.h hVar = this.f9237v;
        if (hVar != null) {
            return hVar.isShowing();
        }
        return false;
    }

    @Override // o.n0
    public final int b() {
        return 0;
    }

    @Override // o.n0
    public final Drawable c() {
        return null;
    }

    @Override // o.n0
    public final void dismiss() {
        h.h hVar = this.f9237v;
        if (hVar != null) {
            hVar.dismiss();
            this.f9237v = null;
        }
    }

    @Override // o.n0
    public final void e(CharSequence charSequence) {
        this.f9239x = charSequence;
    }

    @Override // o.n0
    public final void h(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // o.n0
    public final void i(int i) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // o.n0
    public final void j(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // o.n0
    public final void k(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // o.n0
    public final void l(int i, int i10) {
        if (this.f9238w == null) {
            return;
        }
        o0 o0Var = this.f9240y;
        h.g gVar = new h.g(o0Var.getPopupContext());
        CharSequence charSequence = this.f9239x;
        if (charSequence != null) {
            gVar.setTitle(charSequence);
        }
        i0 i0Var = this.f9238w;
        int selectedItemPosition = o0Var.getSelectedItemPosition();
        h.c cVar = gVar.f5346a;
        cVar.f5303p = i0Var;
        cVar.f5304q = this;
        cVar.f5307t = selectedItemPosition;
        cVar.f5306s = true;
        h.h hVarCreate = gVar.create();
        this.f9237v = hVarCreate;
        AlertController$RecycleListView alertController$RecycleListView = hVarCreate.B.f;
        alertController$RecycleListView.setTextDirection(i);
        alertController$RecycleListView.setTextAlignment(i10);
        this.f9237v.show();
    }

    @Override // o.n0
    public final int m() {
        return 0;
    }

    @Override // o.n0
    public final CharSequence o() {
        return this.f9239x;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        o0 o0Var = this.f9240y;
        o0Var.setSelection(i);
        if (o0Var.getOnItemClickListener() != null) {
            o0Var.performItemClick(null, i, this.f9238w.getItemId(i));
        }
        dismiss();
    }

    @Override // o.n0
    public final void p(ListAdapter listAdapter) {
        this.f9238w = (i0) listAdapter;
    }
}
