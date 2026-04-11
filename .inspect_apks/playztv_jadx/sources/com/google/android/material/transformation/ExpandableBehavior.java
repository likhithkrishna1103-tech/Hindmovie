package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c0.b;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import g9.a;
import java.util.ArrayList;
import java.util.WeakHashMap;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableBehavior extends b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3552u = 0;

    public ExpandableBehavior() {
    }

    @Override // c0.b
    public abstract boolean f(View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c0.b
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        Object obj = (a) view2;
        boolean z2 = ((FloatingActionButton) obj).I.f5331a;
        if (z2) {
            int i = this.f3552u;
            if (i != 0 && i != 2) {
                return false;
            }
        } else if (this.f3552u != 1) {
            return false;
        }
        this.f3552u = z2 ? 1 : 2;
        w((View) obj, view, z2, true);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c0.b
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        a aVar;
        int i10;
        WeakHashMap weakHashMap = o0.f10475a;
        if (!view.isLaidOut()) {
            ArrayList arrayListK = coordinatorLayout.k(view);
            int size = arrayListK.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    aVar = null;
                    break;
                }
                View view2 = (View) arrayListK.get(i11);
                if (f(view, view2)) {
                    aVar = (a) view2;
                    break;
                }
                i11++;
            }
            if (aVar != null) {
                boolean z2 = ((FloatingActionButton) aVar).I.f5331a;
                if (!z2 ? this.f3552u == 1 : !((i10 = this.f3552u) != 0 && i10 != 2)) {
                    int i12 = z2 ? 1 : 2;
                    this.f3552u = i12;
                    view.getViewTreeObserver().addOnPreDrawListener(new y9.a(this, view, i12, aVar));
                }
            }
        }
        return false;
    }

    public abstract void w(View view, View view2, boolean z2, boolean z10);

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
    }
}
