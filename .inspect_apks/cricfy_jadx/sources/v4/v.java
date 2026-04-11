package v4;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f13374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z0 f13375b = new z0(this);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f13376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t f13377d;

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
        t tVar = this.f13377d;
        if (tVar == null || ((h0) tVar.f857b) != h0Var) {
            this.f13377d = new t(h0Var, 0);
        }
        return this.f13377d;
    }

    public final androidx.emoji2.text.h e(h0 h0Var) {
        t tVar = this.f13376c;
        if (tVar == null || ((h0) tVar.f857b) != h0Var) {
            this.f13376c = new t(h0Var, 1);
        }
        return this.f13376c;
    }

    public final void f() {
        h0 layoutManager;
        RecyclerView recyclerView = this.f13374a;
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
        this.f13374a.i0(i, iArrA[1], false);
    }
}
