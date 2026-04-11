package com.google.android.material.timepicker;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import d0.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
class ClockFaceView extends h implements f {
    public final ClockHandView O;
    public final Rect P;
    public final RectF Q;
    public final Rect R;
    public final SparseArray S;
    public final c T;
    public final int[] U;
    public final float[] V;
    public final int W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final int f2996a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final int f2997b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final int f2998c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final String[] f2999d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f3000e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final ColorStateList f3001f0;

    /* JADX WARN: Illegal instructions before constructor call */
    public ClockFaceView(Context context, AttributeSet attributeSet) {
        int i = k9.b.materialClockStyle;
        super(context, attributeSet, i);
        this.P = new Rect();
        this.Q = new RectF();
        this.R = new Rect();
        SparseArray sparseArray = new SparseArray();
        this.S = sparseArray;
        this.V = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k9.l.ClockFaceView, i, k9.k.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListI = com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, k9.l.ClockFaceView_clockNumberTextColor);
        this.f3001f0 = colorStateListI;
        LayoutInflater.from(context).inflate(k9.h.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(k9.f.material_clock_hand);
        this.O = clockHandView;
        this.W = resources.getDimensionPixelSize(k9.d.material_clock_hand_padding);
        int colorForState = colorStateListI.getColorForState(new int[]{R.attr.state_selected}, colorStateListI.getDefaultColor());
        this.U = new int[]{colorForState, colorForState, colorStateListI.getDefaultColor()};
        clockHandView.f3004x.add(this);
        int defaultColor = i0.c.c(context, k9.c.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListI2 = com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, k9.l.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateListI2 != null ? colorStateListI2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(false);
        typedArrayObtainStyledAttributes.recycle();
        this.T = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.f2999d0 = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < Math.max(this.f2999d0.length, size); i10++) {
            TextView textView = (TextView) sparseArray.get(i10);
            if (i10 >= this.f2999d0.length) {
                removeView(textView);
                sparseArray.remove(i10);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(k9.h.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i10, textView);
                    addView(textView);
                }
                textView.setText(this.f2999d0[i10]);
                textView.setTag(k9.f.material_value_index, Integer.valueOf(i10));
                int i11 = (i10 / 12) + 1;
                textView.setTag(k9.f.material_clock_level, Integer.valueOf(i11));
                z10 = i11 > 1 ? true : z10;
                m0.n(textView, this.T);
                textView.setTextColor(this.f3001f0);
            }
        }
        ClockHandView clockHandView2 = this.O;
        if (clockHandView2.f3003w && !z10) {
            clockHandView2.H = 1;
        }
        clockHandView2.f3003w = z10;
        clockHandView2.invalidate();
        this.f2996a0 = resources.getDimensionPixelSize(k9.d.material_time_picker_minimum_screen_height);
        this.f2997b0 = resources.getDimensionPixelSize(k9.d.material_time_picker_minimum_screen_width);
        this.f2998c0 = resources.getDimensionPixelSize(k9.d.material_clock_size);
    }

    @Override // com.google.android.material.timepicker.h
    public final void m() {
        n nVar = new n();
        nVar.b(this);
        HashMap map = new HashMap();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() != k9.f.circle_center && !"skip".equals(childAt.getTag())) {
                int i10 = (Integer) childAt.getTag(k9.f.material_clock_level);
                if (i10 == null) {
                    i10 = 1;
                }
                if (!map.containsKey(i10)) {
                    map.put(i10, new ArrayList());
                }
                ((List) map.get(i10)).add(childAt);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            List list = (List) entry.getValue();
            int iRound = ((Integer) entry.getKey()).intValue() == 2 ? Math.round(this.M * 0.66f) : this.M;
            Iterator it = list.iterator();
            float size = 0.0f;
            while (it.hasNext()) {
                int id2 = ((View) it.next()).getId();
                int i11 = k9.f.circle_center;
                Integer numValueOf = Integer.valueOf(id2);
                HashMap map2 = nVar.f3202c;
                if (!map2.containsKey(numValueOf)) {
                    map2.put(Integer.valueOf(id2), new d0.i());
                }
                d0.j jVar = ((d0.i) map2.get(Integer.valueOf(id2))).f3133d;
                jVar.f3173z = i11;
                jVar.A = iRound;
                jVar.B = size;
                size += 360.0f / list.size();
            }
        }
        nVar.a(this);
        setConstraintSet(null);
        requestLayout();
        int i12 = 0;
        while (true) {
            SparseArray sparseArray = this.S;
            if (i12 >= sparseArray.size()) {
                return;
            }
            ((TextView) sparseArray.get(i12)).setVisibility(0);
            i12++;
        }
    }

    public final void n() {
        SparseArray sparseArray;
        Rect rect;
        RectF rectF;
        RectF rectF2 = this.O.B;
        float f = Float.MAX_VALUE;
        TextView textView = null;
        int i = 0;
        while (true) {
            sparseArray = this.S;
            int size = sparseArray.size();
            rect = this.P;
            rectF = this.Q;
            if (i >= size) {
                break;
            }
            TextView textView2 = (TextView) sparseArray.get(i);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float fHeight = rectF.height() * rectF.width();
                if (fHeight < f) {
                    textView = textView2;
                    f = fHeight;
                }
            }
            i++;
        }
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            TextView textView3 = (TextView) sparseArray.get(i10);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.R);
                rectF.inset(r8.left, r8.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF2, rectF) ? null : new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.U, this.V, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, this.f2999d0.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        super.onLayout(z10, i, i10, i11, i12);
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = (int) (this.f2998c0 / Math.max(Math.max(this.f2996a0 / displayMetrics.heightPixels, this.f2997b0 / displayMetrics.widthPixels), 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
        setMeasuredDimension(iMax, iMax);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }
}
