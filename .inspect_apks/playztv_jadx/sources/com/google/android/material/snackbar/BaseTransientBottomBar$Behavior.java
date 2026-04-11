package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import e7.c;
import k8.a0;
import s9.b;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {
    public final a0 B;

    public BaseTransientBottomBar$Behavior() {
        a0 a0Var = new a0(26);
        this.f3333y = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.f3334z = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.f3332x = 0;
        this.B = a0Var;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, c0.b
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.B.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (c.f4585v == null) {
                    c.f4585v = new c();
                }
                synchronized (c.f4585v.f4586u) {
                }
            }
        } else if (coordinatorLayout.p(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (c.f4585v == null) {
                c.f4585v = new c();
            }
            c.f4585v.b();
        }
        return super.k(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean w(View view) {
        this.B.getClass();
        return view instanceof b;
    }
}
