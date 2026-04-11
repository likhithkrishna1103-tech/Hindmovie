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
import java.util.WeakHashMap;
import p8.l;
import q0.o0;
import q9.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class e extends ConstraintLayout {
    public final a2.a M;
    public int N;
    public final q9.g O;

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(p8.h.material_radial_view_group, this);
        q9.g gVar = new q9.g();
        this.O = gVar;
        q9.h hVar = new q9.h(0.5f);
        j jVarF = gVar.f11105u.f11090a.f();
        jVarF.f11116e = hVar;
        jVarF.f = hVar;
        jVarF.f11117g = hVar;
        jVarF.f11118h = hVar;
        gVar.setShapeAppearanceModel(jVarF.a());
        this.O.l(ColorStateList.valueOf(-1));
        q9.g gVar2 = this.O;
        WeakHashMap weakHashMap = o0.f10475a;
        setBackground(gVar2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.RadialViewGroup, i, 0);
        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.RadialViewGroup_materialCircleRadius, 0);
        this.M = new a2.a(10, this);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            WeakHashMap weakHashMap = o0.f10475a;
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            a2.a aVar = this.M;
            handler.removeCallbacks(aVar);
            handler.post(aVar);
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
            a2.a aVar = this.M;
            handler.removeCallbacks(aVar);
            handler.post(aVar);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        this.O.l(ColorStateList.valueOf(i));
    }
}
