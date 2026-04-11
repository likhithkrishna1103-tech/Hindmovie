package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c0.b;
import java.util.WeakHashMap;
import n.a1;
import q0.o0;
import t8.a;
import y0.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public d f3329u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3330v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3331w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3332x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f3333y = 0.0f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f3334z = 0.5f;
    public final a A = new a(this);

    @Override // c0.b
    public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zP = this.f3330v;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zP = coordinatorLayout.p(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f3330v = zP;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f3330v = false;
        }
        if (zP) {
            if (this.f3329u == null) {
                this.f3329u = new d(coordinatorLayout.getContext(), coordinatorLayout, this.A);
            }
            if (!this.f3331w && this.f3329u.r(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // c0.b
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        WeakHashMap weakHashMap = o0.f10475a;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            o0.k(view, 1048576);
            o0.h(view, 0);
            if (w(view)) {
                o0.l(view, r0.d.f11216l, new a1(this));
            }
        }
        return false;
    }

    @Override // c0.b
    public final boolean v(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f3329u == null) {
            return false;
        }
        if (this.f3331w && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f3329u.k(motionEvent);
        return true;
    }

    public boolean w(View view) {
        return true;
    }
}
