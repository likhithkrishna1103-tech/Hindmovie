package q4;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w extends j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f10949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z0 f10950b = new z0(this);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u f10951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u f10952d;

    public static int b(View view, androidx.emoji2.text.h hVar) {
        return ((hVar.e(view) / 2) + hVar.g(view)) - ((hVar.n() / 2) + hVar.m());
    }

    public static View c(h0 h0Var, androidx.emoji2.text.h hVar) {
        int iV = h0Var.v();
        View view = null;
        if (iV == 0) {
            return null;
        }
        int iN = (hVar.n() / 2) + hVar.m();
        int i = Integer.MAX_VALUE;
        for (int i10 = 0; i10 < iV; i10++) {
            View viewU = h0Var.u(i10);
            int iAbs = Math.abs(((hVar.e(viewU) / 2) + hVar.g(viewU)) - iN);
            if (iAbs < i) {
                view = viewU;
                i = iAbs;
            }
        }
        return view;
    }

    public final int[] a(h0 h0Var, View view) {
        int[] iArr = new int[2];
        if (h0Var.d()) {
            iArr[0] = b(view, d(h0Var));
        } else {
            iArr[0] = 0;
        }
        if (h0Var.e()) {
            iArr[1] = b(view, e(h0Var));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    public final androidx.emoji2.text.h d(h0 h0Var) {
        u uVar = this.f10952d;
        if (uVar == null || ((h0) uVar.f1175b) != h0Var) {
            this.f10952d = new u(h0Var, 0);
        }
        return this.f10952d;
    }

    public final androidx.emoji2.text.h e(h0 h0Var) {
        u uVar = this.f10951c;
        if (uVar == null || ((h0) uVar.f1175b) != h0Var) {
            this.f10951c = new u(h0Var, 1);
        }
        return this.f10951c;
    }

    public final void f() {
        h0 layoutManager;
        RecyclerView recyclerView = this.f10949a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        View viewC = layoutManager.e() ? c(layoutManager, e(layoutManager)) : layoutManager.d() ? c(layoutManager, d(layoutManager)) : null;
        if (viewC == null) {
            return;
        }
        int[] iArrA = a(layoutManager, viewC);
        int i = iArrA[0];
        if (i == 0 && iArrA[1] == 0) {
            return;
        }
        this.f10949a.i0(i, iArrA[1], false);
    }
}
