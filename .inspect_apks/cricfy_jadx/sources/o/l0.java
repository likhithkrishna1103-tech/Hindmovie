package o;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 extends g2 implements n0 {
    public CharSequence Y;
    public i0 Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final Rect f9259a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f9260b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final /* synthetic */ o0 f9261c0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(o0 o0Var, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0);
        this.f9261c0 = o0Var;
        this.f9259a0 = new Rect();
        this.J = o0Var;
        this.T = true;
        this.U.setFocusable(true);
        this.K = new j0(0, this);
    }

    @Override // o.n0
    public final void e(CharSequence charSequence) {
        this.Y = charSequence;
    }

    @Override // o.n0
    public final void j(int i) {
        this.f9260b0 = i;
    }

    @Override // o.n0
    public final void l(int i, int i10) {
        ViewTreeObserver viewTreeObserver;
        y yVar = this.U;
        boolean zIsShowing = yVar.isShowing();
        s();
        yVar.setInputMethodMode(2);
        d();
        t1 t1Var = this.f9231x;
        t1Var.setChoiceMode(1);
        t1Var.setTextDirection(i);
        t1Var.setTextAlignment(i10);
        o0 o0Var = this.f9261c0;
        int selectedItemPosition = o0Var.getSelectedItemPosition();
        t1 t1Var2 = this.f9231x;
        if (yVar.isShowing() && t1Var2 != null) {
            t1Var2.setListSelectionHidden(false);
            t1Var2.setSelection(selectedItemPosition);
            if (t1Var2.getChoiceMode() != 0) {
                t1Var2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (zIsShowing || (viewTreeObserver = o0Var.getViewTreeObserver()) == null) {
            return;
        }
        fa.e eVar = new fa.e(4, this);
        viewTreeObserver.addOnGlobalLayoutListener(eVar);
        yVar.setOnDismissListener(new k0(this, eVar));
    }

    @Override // o.n0
    public final CharSequence o() {
        return this.Y;
    }

    @Override // o.g2, o.n0
    public final void p(ListAdapter listAdapter) {
        super.p(listAdapter);
        this.Z = (i0) listAdapter;
    }

    public final void s() {
        int i;
        o0 o0Var = this.f9261c0;
        Rect rect = o0Var.C;
        y yVar = this.U;
        Drawable background = yVar.getBackground();
        if (background != null) {
            background.getPadding(rect);
            boolean z10 = x3.f9407a;
            i = o0Var.getLayoutDirection() == 1 ? rect.right : -rect.left;
        } else {
            i = 0;
            rect.right = 0;
            rect.left = 0;
        }
        int paddingLeft = o0Var.getPaddingLeft();
        int paddingRight = o0Var.getPaddingRight();
        int width = o0Var.getWidth();
        int i10 = o0Var.B;
        if (i10 == -2) {
            int iA = o0Var.a(this.Z, yVar.getBackground());
            int i11 = (o0Var.getContext().getResources().getDisplayMetrics().widthPixels - rect.left) - rect.right;
            if (iA > i11) {
                iA = i11;
            }
            r(Math.max(iA, (width - paddingLeft) - paddingRight));
        } else if (i10 == -1) {
            r((width - paddingLeft) - paddingRight);
        } else {
            r(i10);
        }
        boolean z11 = x3.f9407a;
        this.A = o0Var.getLayoutDirection() == 1 ? (((width - paddingRight) - this.f9233z) - this.f9260b0) + i : paddingLeft + this.f9260b0 + i;
    }
}
