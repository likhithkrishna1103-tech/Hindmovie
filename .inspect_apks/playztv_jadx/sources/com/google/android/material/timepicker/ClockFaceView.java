package com.google.android.material.timepicker;

import a0.j;
import a0.o;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n.a1;
import p8.k;
import p8.l;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
class ClockFaceView extends e implements d {
    public final ClockHandView P;
    public final Rect Q;
    public final RectF R;
    public final Rect S;
    public final SparseArray T;
    public final c U;
    public final int[] V;
    public final float[] W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final int f3533a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final int f3534b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final int f3535c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final int f3536d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final String[] f3537e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f3538f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final ColorStateList f3539g0;

    /* JADX WARN: Illegal instructions before constructor call */
    public ClockFaceView(Context context, AttributeSet attributeSet) {
        int i = p8.b.materialClockStyle;
        super(context, attributeSet, i);
        this.Q = new Rect();
        this.R = new RectF();
        this.S = new Rect();
        SparseArray sparseArray = new SparseArray();
        this.T = sparseArray;
        this.W = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ClockFaceView, i, k.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateListI = a.a.i(context, typedArrayObtainStyledAttributes, l.ClockFaceView_clockNumberTextColor);
        this.f3539g0 = colorStateListI;
        LayoutInflater.from(context).inflate(p8.h.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(p8.f.material_clock_hand);
        this.P = clockHandView;
        this.f3533a0 = resources.getDimensionPixelSize(p8.d.material_clock_hand_padding);
        int colorForState = colorStateListI.getColorForState(new int[]{R.attr.state_selected}, colorStateListI.getDefaultColor());
        this.V = new int[]{colorForState, colorForState, colorStateListI.getDefaultColor()};
        clockHandView.f3542w.add(this);
        int defaultColor = f0.c.c(context, p8.c.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateListI2 = a.a.i(context, typedArrayObtainStyledAttributes, l.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateListI2 != null ? colorStateListI2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.U = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.f3537e0 = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z2 = false;
        for (int i10 = 0; i10 < Math.max(this.f3537e0.length, size); i10++) {
            TextView textView = (TextView) sparseArray.get(i10);
            if (i10 >= this.f3537e0.length) {
                removeView(textView);
                sparseArray.remove(i10);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(p8.h.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i10, textView);
                    addView(textView);
                }
                textView.setText(this.f3537e0[i10]);
                textView.setTag(p8.f.material_value_index, Integer.valueOf(i10));
                int i11 = (i10 / 12) + 1;
                textView.setTag(p8.f.material_clock_level, Integer.valueOf(i11));
                z2 = i11 > 1 ? true : z2;
                o0.n(textView, this.U);
                textView.setTextColor(this.f3539g0);
            }
        }
        ClockHandView clockHandView2 = this.P;
        if (clockHandView2.f3541v && !z2) {
            clockHandView2.G = 1;
        }
        clockHandView2.f3541v = z2;
        clockHandView2.invalidate();
        this.f3534b0 = resources.getDimensionPixelSize(p8.d.material_time_picker_minimum_screen_height);
        this.f3535c0 = resources.getDimensionPixelSize(p8.d.material_time_picker_minimum_screen_width);
        this.f3536d0 = resources.getDimensionPixelSize(p8.d.material_clock_size);
    }

    @Override // com.google.android.material.timepicker.e
    public final void m() {
        o oVar = new o();
        oVar.b(this);
        HashMap map = new HashMap();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getId() != p8.f.circle_center && !"skip".equals(childAt.getTag())) {
                int i10 = (Integer) childAt.getTag(p8.f.material_clock_level);
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
            int iRound = ((Integer) entry.getKey()).intValue() == 2 ? Math.round(this.N * 0.66f) : this.N;
            Iterator it = list.iterator();
            float size = 0.0f;
            while (it.hasNext()) {
                int id2 = ((View) it.next()).getId();
                int i11 = p8.f.circle_center;
                Integer numValueOf = Integer.valueOf(id2);
                HashMap map2 = oVar.f149c;
                if (!map2.containsKey(numValueOf)) {
                    map2.put(Integer.valueOf(id2), new j());
                }
                a0.k kVar = ((j) map2.get(Integer.valueOf(id2))).f80d;
                kVar.f120z = i11;
                kVar.A = iRound;
                kVar.B = size;
                size += 360.0f / list.size();
            }
        }
        oVar.a(this);
        setConstraintSet(null);
        requestLayout();
        int i12 = 0;
        while (true) {
            SparseArray sparseArray = this.T;
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
        RectF rectF2 = this.P.A;
        float f = Float.MAX_VALUE;
        TextView textView = null;
        int i = 0;
        while (true) {
            sparseArray = this.T;
            int size = sparseArray.size();
            rect = this.Q;
            rectF = this.R;
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
                textView3.getLineBounds(0, this.S);
                rectF.inset(r8.left, r8.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF2, rectF) ? null : new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.V, this.W, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) a1.x(1, this.f3537e0.length, 1).f8343u);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        super.onLayout(z2, i, i10, i11, i12);
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int iMax = (int) (this.f3536d0 / Math.max(Math.max(this.f3534b0 / displayMetrics.heightPixels, this.f3535c0 / displayMetrics.widthPixels), 1.0f));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
        setMeasuredDimension(iMax, iMax);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }
}
