package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.x;
import d5.c;
import k1.e;
import k9.l;
import m4.d;
import t9.a;
import t9.b;
import v4.h0;
import v4.i0;
import v4.n0;
import v4.s0;
import v4.t0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class CarouselLayoutManager extends h0 implements s0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e f2834p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public c f2835q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final View.OnLayoutChangeListener f2836r;

    public CarouselLayoutManager() {
        e eVar = new e();
        new a();
        this.f2836r = new d(2, this);
        this.f2834p = eVar;
        p0();
        H0(0);
    }

    @Override // v4.h0
    public final void B0(RecyclerView recyclerView, int i) {
        x xVar = new x(this, recyclerView.getContext());
        xVar.f13346a = i;
        C0(xVar);
    }

    public final float E0(float f, float f10) {
        return G0() ? f - f10 : f + f10;
    }

    public final boolean F0() {
        return this.f2835q.f3393b == 0;
    }

    public final boolean G0() {
        return F0() && this.f13248b.getLayoutDirection() == 1;
    }

    public final void H0(int i) {
        b bVar;
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(l0.e.g(i, "invalid orientation:"));
        }
        c(null);
        c cVar = this.f2835q;
        if (cVar == null || i != cVar.f3393b) {
            if (i == 0) {
                bVar = new b(this, 1);
            } else {
                if (i != 1) {
                    throw new IllegalArgumentException("invalid orientation");
                }
                bVar = new b(this, 0);
            }
            this.f2835q = bVar;
            p0();
        }
    }

    @Override // v4.h0
    public final boolean K() {
        return true;
    }

    @Override // v4.h0
    public final void R(RecyclerView recyclerView) {
        Context context = recyclerView.getContext();
        e eVar = this.f2834p;
        float dimension = eVar.f6796a;
        if (dimension <= 0.0f) {
            dimension = context.getResources().getDimension(k9.d.m3_carousel_small_item_size_min);
        }
        eVar.f6796a = dimension;
        float dimension2 = eVar.f6797b;
        if (dimension2 <= 0.0f) {
            dimension2 = context.getResources().getDimension(k9.d.m3_carousel_small_item_size_max);
        }
        eVar.f6797b = dimension2;
        p0();
        recyclerView.addOnLayoutChangeListener(this.f2836r);
    }

    @Override // v4.h0
    public final void S(RecyclerView recyclerView) {
        recyclerView.removeOnLayoutChangeListener(this.f2836r);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    @Override // v4.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View T(android.view.View r4, int r5, v4.n0 r6, v4.t0 r7) {
        /*
            r3 = this;
            int r6 = r3.v()
            if (r6 != 0) goto L8
            goto L96
        L8:
            d5.c r6 = r3.f2835q
            int r6 = r6.f3393b
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = -1
            r1 = 1
            if (r5 == r1) goto L46
            r2 = 2
            if (r5 == r2) goto L3c
            r2 = 17
            if (r5 == r2) goto L4b
            r2 = 33
            if (r5 == r2) goto L48
            r2 = 66
            if (r5 == r2) goto L3e
            r2 = 130(0x82, float:1.82E-43)
            if (r5 == r2) goto L3a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown focus request:"
            r6.<init>(r2)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "CarouselLayoutManager"
            android.util.Log.d(r6, r5)
        L38:
            r5 = r7
            goto L54
        L3a:
            if (r6 != r1) goto L38
        L3c:
            r5 = r1
            goto L54
        L3e:
            if (r6 != 0) goto L38
            boolean r5 = r3.G0()
            if (r5 == 0) goto L3c
        L46:
            r5 = r0
            goto L54
        L48:
            if (r6 != r1) goto L38
            goto L46
        L4b:
            if (r6 != 0) goto L38
            boolean r5 = r3.G0()
            if (r5 == 0) goto L46
            goto L3c
        L54:
            if (r5 != r7) goto L57
            goto L96
        L57:
            r6 = 0
            if (r5 != r0) goto L8b
            int r4 = v4.h0.G(r4)
            if (r4 != 0) goto L61
            goto L96
        L61:
            android.view.View r4 = r3.u(r6)
            int r4 = v4.h0.G(r4)
            int r4 = r4 - r1
            if (r4 < 0) goto L7a
            int r5 = r3.B()
            if (r4 < r5) goto L73
            goto L7a
        L73:
            d5.c r4 = r3.f2835q
            r4.f()
            r4 = 0
            throw r4
        L7a:
            boolean r4 = r3.G0()
            if (r4 == 0) goto L86
            int r4 = r3.v()
            int r6 = r4 + (-1)
        L86:
            android.view.View r4 = r3.u(r6)
            return r4
        L8b:
            int r4 = v4.h0.G(r4)
            int r5 = r3.B()
            int r5 = r5 - r1
            if (r4 != r5) goto L98
        L96:
            r4 = 0
            return r4
        L98:
            int r4 = r3.v()
            int r4 = r4 - r1
            android.view.View r4 = r3.u(r4)
            int r4 = v4.h0.G(r4)
            int r4 = r4 + r1
            if (r4 < 0) goto Lb6
            int r5 = r3.B()
            if (r4 < r5) goto Laf
            goto Lb6
        Laf:
            d5.c r4 = r3.f2835q
            r4.f()
            r4 = 0
            throw r4
        Lb6:
            boolean r4 = r3.G0()
            if (r4 == 0) goto Lbd
            goto Lc3
        Lbd:
            int r4 = r3.v()
            int r6 = r4 + (-1)
        Lc3:
            android.view.View r4 = r3.u(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.T(android.view.View, int, v4.n0, v4.t0):android.view.View");
    }

    @Override // v4.h0
    public final void U(AccessibilityEvent accessibilityEvent) {
        super.U(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(h0.G(u(0)));
            accessibilityEvent.setToIndex(h0.G(u(v() - 1)));
        }
    }

    @Override // v4.h0
    public final void Z(int i, int i10) {
        B();
    }

    @Override // v4.s0
    public final PointF a(int i) {
        return null;
    }

    @Override // v4.h0
    public final void a0() {
        B();
    }

    @Override // v4.h0
    public final void c0(int i, int i10) {
        B();
    }

    @Override // v4.h0
    public final boolean d() {
        return F0();
    }

    @Override // v4.h0
    public final boolean e() {
        return !F0();
    }

    @Override // v4.h0
    public final void e0(n0 n0Var, t0 t0Var) {
        if (t0Var.b() > 0) {
            if ((F0() ? this.f13258n : this.f13259o) > 0.0f) {
                G0();
                n0Var.d(0);
                throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
            }
        }
        k0(n0Var);
    }

    @Override // v4.h0
    public final void f0(t0 t0Var) {
        if (v() == 0) {
            return;
        }
        h0.G(u(0));
    }

    @Override // v4.h0
    public final int j(t0 t0Var) {
        v();
        return 0;
    }

    @Override // v4.h0
    public final int k(t0 t0Var) {
        return 0;
    }

    @Override // v4.h0
    public final int l(t0 t0Var) {
        return 0;
    }

    @Override // v4.h0
    public final int m(t0 t0Var) {
        v();
        return 0;
    }

    @Override // v4.h0
    public final int n(t0 t0Var) {
        return 0;
    }

    @Override // v4.h0
    public final int o(t0 t0Var) {
        return 0;
    }

    @Override // v4.h0
    public final boolean o0(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
        return false;
    }

    @Override // v4.h0
    public final int q0(int i, n0 n0Var, t0 t0Var) {
        if (!F0() || v() == 0 || i == 0) {
            return 0;
        }
        n0Var.d(0);
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // v4.h0
    public final i0 r() {
        return new i0(-2, -2);
    }

    @Override // v4.h0
    public final int s0(int i, n0 n0Var, t0 t0Var) {
        if (!e() || v() == 0 || i == 0) {
            return 0;
        }
        n0Var.d(0);
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // v4.h0
    public final void y(Rect rect, View view) {
        super.y(rect, view);
        rect.centerY();
        if (F0()) {
            rect.centerX();
        }
        throw null;
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i, int i10) {
        new a();
        this.f2836r = new d(2, this);
        this.f2834p = new e();
        p0();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.Carousel);
            typedArrayObtainStyledAttributes.getInt(l.Carousel_carousel_alignment, 0);
            p0();
            H0(typedArrayObtainStyledAttributes.getInt(u4.c.RecyclerView_android_orientation, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // v4.h0
    public final void r0(int i) {
    }
}
