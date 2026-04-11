package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b1.e;
import f0.b;
import l4.a;
import o9.c;
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public e f2784v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2785w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2786x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2787y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f2788z = 0.0f;
    public float A = 0.5f;
    public final c B = new c(this);

    @Override // f0.b
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zP = this.f2785w;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zP = coordinatorLayout.p(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f2785w = zP;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2785w = false;
        }
        if (zP) {
            if (this.f2784v == null) {
                this.f2784v = new e(coordinatorLayout.getContext(), coordinatorLayout, this.B);
            }
            if (!this.f2786x && this.f2784v.r(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // f0.b
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            m0.k(view, 1048576);
            m0.h(view, 0);
            if (w(view)) {
                m0.l(view, u0.c.f12051l, new a(this));
            }
        }
        return false;
    }

    @Override // f0.b
    public final boolean v(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f2784v == null) {
            return false;
        }
        if (this.f2786x && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f2784v.k(motionEvent);
        return true;
    }

    public boolean w(View view) {
        return true;
    }
}
