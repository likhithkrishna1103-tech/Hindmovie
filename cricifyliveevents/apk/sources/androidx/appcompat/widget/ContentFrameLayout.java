package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import h.a0;
import o.f;
import o.h1;
import o.i1;
import o.k;
import o.p3;
import t0.q0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {
    public TypedValue A;
    public final Rect B;
    public h1 C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TypedValue f550v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TypedValue f551w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TypedValue f552x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TypedValue f553y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TypedValue f554z;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.B = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f554z == null) {
            this.f554z = new TypedValue();
        }
        return this.f554z;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.A == null) {
            this.A = new TypedValue();
        }
        return this.A;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f552x == null) {
            this.f552x = new TypedValue();
        }
        return this.f552x;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f553y == null) {
            this.f553y = new TypedValue();
        }
        return this.f553y;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f550v == null) {
            this.f550v = new TypedValue();
        }
        return this.f550v;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f551w == null) {
            this.f551w = new TypedValue();
        }
        return this.f551w;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        h1 h1Var = this.C;
        if (h1Var != null) {
            h1Var.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        k kVar;
        super.onDetachedFromWindow();
        h1 h1Var = this.C;
        if (h1Var != null) {
            a0 a0Var = (a0) ((p6.c) h1Var).f10035w;
            i1 i1Var = a0Var.M;
            if (i1Var != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) i1Var;
                actionBarOverlayLayout.k();
                ActionMenuView actionMenuView = ((p3) actionBarOverlayLayout.f542z).f9308a.f619v;
                if (actionMenuView != null && (kVar = actionMenuView.O) != null) {
                    kVar.d();
                    f fVar = kVar.P;
                    if (fVar != null && fVar.b()) {
                        fVar.i.dismiss();
                    }
                }
            }
            if (a0Var.R != null) {
                a0Var.G.getDecorView().removeCallbacks(a0Var.S);
                if (a0Var.R.isShowing()) {
                    try {
                        a0Var.R.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                a0Var.R = null;
            }
            q0 q0Var = a0Var.T;
            if (q0Var != null) {
                q0Var.b();
            }
            n.k kVar2 = a0Var.C(0).f5417h;
            if (kVar2 != null) {
                kVar2.c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(h1 h1Var) {
        this.C = h1Var;
    }
}
