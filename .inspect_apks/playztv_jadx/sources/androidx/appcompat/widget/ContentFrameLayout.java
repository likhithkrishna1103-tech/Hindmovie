package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import h.b0;
import n.f;
import n.k;
import n.k1;
import n.l1;
import n.m3;
import q0.t0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {
    public final Rect A;
    public k1 B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TypedValue f893u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TypedValue f894v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TypedValue f895w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TypedValue f896x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public TypedValue f897y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TypedValue f898z;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.A = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f897y == null) {
            this.f897y = new TypedValue();
        }
        return this.f897y;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f898z == null) {
            this.f898z = new TypedValue();
        }
        return this.f898z;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f895w == null) {
            this.f895w = new TypedValue();
        }
        return this.f895w;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f896x == null) {
            this.f896x = new TypedValue();
        }
        return this.f896x;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f893u == null) {
            this.f893u = new TypedValue();
        }
        return this.f893u;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f894v == null) {
            this.f894v = new TypedValue();
        }
        return this.f894v;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        k1 k1Var = this.B;
        if (k1Var != null) {
            k1Var.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        k kVar;
        super.onDetachedFromWindow();
        k1 k1Var = this.B;
        if (k1Var != null) {
            b0 b0Var = (b0) ((u5.d) k1Var).f12784v;
            l1 l1Var = b0Var.L;
            if (l1Var != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) l1Var;
                actionBarOverlayLayout.k();
                ActionMenuView actionMenuView = ((m3) actionBarOverlayLayout.f884y).f8443a.f942u;
                if (actionMenuView != null && (kVar = actionMenuView.N) != null) {
                    kVar.d();
                    f fVar = kVar.O;
                    if (fVar != null && fVar.b()) {
                        fVar.i.dismiss();
                    }
                }
            }
            if (b0Var.Q != null) {
                b0Var.F.getDecorView().removeCallbacks(b0Var.R);
                if (b0Var.Q.isShowing()) {
                    try {
                        b0Var.Q.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                b0Var.Q = null;
            }
            t0 t0Var = b0Var.S;
            if (t0Var != null) {
                t0Var.b();
            }
            m.k kVar2 = b0Var.C(0).f5405h;
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

    public void setAttachListener(k1 k1Var) {
        this.B = k1Var;
    }
}
