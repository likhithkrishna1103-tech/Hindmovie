package com.google.android.material.transformation;

import aa.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import f0.b;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableBehavior extends b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3015v = 0;

    public ExpandableBehavior() {
    }

    @Override // f0.b
    public abstract boolean f(View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f0.b
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        Object obj = (a) view2;
        boolean z10 = ((FloatingActionButton) obj).J.f374a;
        if (z10) {
            int i = this.f3015v;
            if (i != 0 && i != 2) {
                return false;
            }
        } else if (this.f3015v != 1) {
            return false;
        }
        this.f3015v = z10 ? 1 : 2;
        w((View) obj, view, z10, true);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f0.b
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        a aVar;
        int i10;
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
                boolean z10 = ((FloatingActionButton) aVar).J.f374a;
                if (!z10 ? this.f3015v == 1 : !((i10 = this.f3015v) != 0 && i10 != 2)) {
                    int i12 = z10 ? 1 : 2;
                    this.f3015v = i12;
                    view.getViewTreeObserver().addOnPreDrawListener(new sa.a(this, view, i12, aVar));
                }
            }
        }
        return false;
    }

    public abstract void w(View view, View view2, boolean z10, boolean z11);

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
    }
}
