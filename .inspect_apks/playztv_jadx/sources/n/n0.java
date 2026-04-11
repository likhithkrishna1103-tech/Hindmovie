package n;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n0 extends f2 implements p0 {
    public CharSequence X;
    public k0 Y;
    public final Rect Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f8456a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final /* synthetic */ q0 f8457b0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(q0 q0Var, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        this.f8457b0 = q0Var;
        this.Z = new Rect();
        this.I = q0Var;
        this.S = true;
        this.T.setFocusable(true);
        this.J = new l0(0, this);
    }

    @Override // n.p0
    public final void f(CharSequence charSequence) {
        this.X = charSequence;
    }

    @Override // n.p0
    public final void j(int i) {
        this.f8456a0 = i;
    }

    @Override // n.p0
    public final void l(int i, int i10) {
        ViewTreeObserver viewTreeObserver;
        a0 a0Var = this.T;
        boolean zIsShowing = a0Var.isShowing();
        r();
        a0Var.setInputMethodMode(2);
        d();
        t1 t1Var = this.f8383w;
        t1Var.setChoiceMode(1);
        t1Var.setTextDirection(i);
        t1Var.setTextAlignment(i10);
        q0 q0Var = this.f8457b0;
        int selectedItemPosition = q0Var.getSelectedItemPosition();
        t1 t1Var2 = this.f8383w;
        if (a0Var.isShowing() && t1Var2 != null) {
            t1Var2.setListSelectionHidden(false);
            t1Var2.setSelection(selectedItemPosition);
            if (t1Var2.getChoiceMode() != 0) {
                t1Var2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (zIsShowing || (viewTreeObserver = q0Var.getViewTreeObserver()) == null) {
            return;
        }
        l9.o oVar = new l9.o(4, this);
        viewTreeObserver.addOnGlobalLayoutListener(oVar);
        a0Var.setOnDismissListener(new m0(this, oVar));
    }

    @Override // n.p0
    public final CharSequence n() {
        return this.X;
    }

    @Override // n.f2, n.p0
    public final void o(ListAdapter listAdapter) {
        super.o(listAdapter);
        this.Y = (k0) listAdapter;
    }

    public final void r() {
        int i;
        q0 q0Var = this.f8457b0;
        Rect rect = q0Var.B;
        a0 a0Var = this.T;
        Drawable background = a0Var.getBackground();
        if (background != null) {
            background.getPadding(rect);
            boolean z2 = u3.f8547a;
            i = q0Var.getLayoutDirection() == 1 ? rect.right : -rect.left;
        } else {
            i = 0;
            rect.right = 0;
            rect.left = 0;
        }
        int paddingLeft = q0Var.getPaddingLeft();
        int paddingRight = q0Var.getPaddingRight();
        int width = q0Var.getWidth();
        int i10 = q0Var.A;
        if (i10 == -2) {
            int iA = q0Var.a(this.Y, a0Var.getBackground());
            int i11 = (q0Var.getContext().getResources().getDisplayMetrics().widthPixels - rect.left) - rect.right;
            if (iA > i11) {
                iA = i11;
            }
            q(Math.max(iA, (width - paddingLeft) - paddingRight));
        } else if (i10 == -1) {
            q((width - paddingLeft) - paddingRight);
        } else {
            q(i10);
        }
        boolean z10 = u3.f8547a;
        this.f8386z = q0Var.getLayoutDirection() == 1 ? (((width - paddingRight) - this.f8385y) - this.f8456a0) + i : paddingLeft + this.f8456a0 + i;
    }
}
