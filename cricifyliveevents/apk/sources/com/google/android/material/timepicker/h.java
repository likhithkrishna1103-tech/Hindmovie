package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends ConstraintLayout {
    public final g L;
    public int M;
    public final ka.i N;

    /* JADX WARN: Type inference failed for: r5v3, types: [com.google.android.material.timepicker.g] */
    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(k9.h.material_radial_view_group, this);
        ka.i iVar = new ka.i();
        this.N = iVar;
        ka.j jVar = new ka.j(0.5f);
        ka.l lVarG = iVar.f7334w.f7316a.g();
        lVarG.f7343e = jVar;
        lVarG.f = jVar;
        lVarG.f7344g = jVar;
        lVarG.f7345h = jVar;
        iVar.setShapeAppearanceModel(lVarG.a());
        this.N.q(ColorStateList.valueOf(-1));
        setBackground(this.N);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k9.l.RadialViewGroup, i, 0);
        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(k9.l.RadialViewGroup_materialCircleRadius, 0);
        this.L = new Runnable() { // from class: com.google.android.material.timepicker.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f3011v.m();
            }
        };
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            g gVar = this.L;
            handler.removeCallbacks(gVar);
            handler.post(gVar);
        }
    }

    public abstract void m();

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        m();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            g gVar = this.L;
            handler.removeCallbacks(gVar);
            handler.post(gVar);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        this.N.q(ColorStateList.valueOf(i));
    }
}
