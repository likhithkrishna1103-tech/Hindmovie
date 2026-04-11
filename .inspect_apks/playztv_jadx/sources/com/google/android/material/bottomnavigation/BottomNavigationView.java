package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import j9.e0;
import j9.f0;
import l9.m;
import p8.b;
import p8.k;
import p8.l;
import v8.c;
import v8.d;
import v8.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationView extends m {
    /* JADX WARN: Illegal instructions before constructor call */
    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        int i = b.bottomNavigationStyle;
        int i10 = k.Widget_Design_BottomNavigationView;
        super(context, attributeSet, i, i10);
        kc.b bVarE = e0.e(getContext(), attributeSet, l.BottomNavigationView, i, i10, new int[0]);
        int i11 = l.BottomNavigationView_itemHorizontalTranslationEnabled;
        TypedArray typedArray = (TypedArray) bVarE.f7621w;
        setItemHorizontalTranslationEnabled(typedArray.getBoolean(i11, true));
        if (typedArray.hasValue(l.BottomNavigationView_android_minHeight)) {
            setMinimumHeight(typedArray.getDimensionPixelSize(l.BottomNavigationView_android_minHeight, 0));
        }
        typedArray.getBoolean(l.BottomNavigationView_compatShadowEnabled, true);
        bVarE.E();
        f0.a(this, new c());
    }

    @Override // l9.m
    public int getMaxItemCount() {
        return 5;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i10) != 1073741824 && suggestedMinimumHeight > 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), getPaddingBottom() + getPaddingTop() + suggestedMinimumHeight), 1073741824);
        }
        super.onMeasure(i, i10);
    }

    public void setItemHorizontalTranslationEnabled(boolean z2) {
        v8.b bVar = (v8.b) getMenuView();
        if (bVar.f13337i0 != z2) {
            bVar.setItemHorizontalTranslationEnabled(z2);
            getPresenter().f(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(d dVar) {
        setOnItemReselectedListener(dVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(e eVar) {
        setOnItemSelectedListener(eVar);
    }
}
