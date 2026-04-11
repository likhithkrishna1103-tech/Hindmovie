package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import f9.z;
import ma.c;
import ma.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {
    public final z C;

    public BaseTransientBottomBar$Behavior() {
        z zVar = new z(18);
        this.f2788z = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.A = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.f2787y = 0;
        this.C = zVar;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, f0.b
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.C.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (e.f8416w == null) {
                    e.f8416w = new e();
                }
                synchronized (e.f8416w.f8417v) {
                }
            }
        } else if (coordinatorLayout.p(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (e.f8416w == null) {
                e.f8416w = new e();
            }
            e.f8416w.b();
        }
        return super.k(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean w(View view) {
        this.C.getClass();
        return view instanceof c;
    }
}
