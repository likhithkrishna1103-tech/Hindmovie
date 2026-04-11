package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.bumptech.glide.c;
import da.d0;
import k9.b;
import k9.d;
import k9.k;
import k9.l;
import ka.i;
import ra.a;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialDivider extends View {
    public static final int A = k.Widget_MaterialComponents_MaterialDivider;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final i f2906v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2907w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2908x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2909y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2910z;

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialDivider(Context context, AttributeSet attributeSet) {
        int i = b.materialDividerStyle;
        int i10 = A;
        super(a.a(context, attributeSet, i, i10), attributeSet, i);
        Context context2 = getContext();
        this.f2906v = new i();
        TypedArray typedArrayD = d0.d(context2, attributeSet, l.MaterialDivider, i, i10, new int[0]);
        this.f2907w = typedArrayD.getDimensionPixelSize(l.MaterialDivider_dividerThickness, getResources().getDimensionPixelSize(d.material_divider_thickness));
        this.f2909y = typedArrayD.getDimensionPixelOffset(l.MaterialDivider_dividerInsetStart, 0);
        this.f2910z = typedArrayD.getDimensionPixelOffset(l.MaterialDivider_dividerInsetEnd, 0);
        setDividerColor(c.i(context2, typedArrayD, l.MaterialDivider_dividerColor).getDefaultColor());
        typedArrayD.recycle();
    }

    public int getDividerColor() {
        return this.f2908x;
    }

    public int getDividerInsetEnd() {
        return this.f2910z;
    }

    public int getDividerInsetStart() {
        return this.f2909y;
    }

    public int getDividerThickness() {
        return this.f2907w;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        int i;
        super.onDraw(canvas);
        boolean z10 = getLayoutDirection() == 1;
        int i10 = z10 ? this.f2910z : this.f2909y;
        if (z10) {
            width = getWidth();
            i = this.f2909y;
        } else {
            width = getWidth();
            i = this.f2910z;
        }
        int i11 = width - i;
        int bottom = getBottom() - getTop();
        i iVar = this.f2906v;
        iVar.setBounds(i10, 0, i11, bottom);
        iVar.draw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        int mode = View.MeasureSpec.getMode(i10);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i11 = this.f2907w;
            if (i11 > 0 && measuredHeight != i11) {
                measuredHeight = i11;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i) {
        if (this.f2908x != i) {
            this.f2908x = i;
            this.f2906v.q(ColorStateList.valueOf(i));
            invalidate();
        }
    }

    public void setDividerColorResource(int i) {
        setDividerColor(getContext().getColor(i));
    }

    public void setDividerInsetEnd(int i) {
        this.f2910z = i;
    }

    public void setDividerInsetEndResource(int i) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i));
    }

    public void setDividerInsetStart(int i) {
        this.f2909y = i;
    }

    public void setDividerInsetStartResource(int i) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i));
    }

    public void setDividerThickness(int i) {
        if (this.f2907w != i) {
            this.f2907w = i;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i));
    }
}
