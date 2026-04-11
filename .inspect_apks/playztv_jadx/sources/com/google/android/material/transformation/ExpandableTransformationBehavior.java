package com.google.android.material.transformation;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import g5.l;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AnimatorSet f3553v;

    public ExpandableTransformationBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    public void w(View view, View view2, boolean z2, boolean z10) {
        AnimatorSet animatorSet = this.f3553v;
        boolean z11 = animatorSet != null;
        if (z11) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSetX = x(view, view2, z2, z11);
        this.f3553v = animatorSetX;
        animatorSetX.addListener(new l(10, this));
        this.f3553v.start();
        if (z10) {
            return;
        }
        this.f3553v.end();
    }

    public abstract AnimatorSet x(View view, View view2, boolean z2, boolean z10);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
