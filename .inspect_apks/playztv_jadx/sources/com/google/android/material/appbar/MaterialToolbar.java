package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import c0.i;
import j9.e0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import p8.k;
import p8.l;
import q0.f0;
import q0.o0;
import q9.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final int f3307w0 = k.Widget_MaterialComponents_Toolbar;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final ImageView.ScaleType[] f3308x0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public Integer f3309r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f3310s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f3311t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public ImageView.ScaleType f3312u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public Boolean f3313v0;

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        int i = p8.b.toolbarStyle;
        int i10 = f3307w0;
        super(x9.a.a(context, attributeSet, i, i10), attributeSet, i);
        Context context2 = getContext();
        TypedArray typedArrayD = e0.d(context2, attributeSet, l.MaterialToolbar, i, i10, new int[0]);
        if (typedArrayD.hasValue(l.MaterialToolbar_navigationIconTint)) {
            setNavigationIconTint(typedArrayD.getColor(l.MaterialToolbar_navigationIconTint, -1));
        }
        this.f3310s0 = typedArrayD.getBoolean(l.MaterialToolbar_titleCentered, false);
        this.f3311t0 = typedArrayD.getBoolean(l.MaterialToolbar_subtitleCentered, false);
        int i11 = typedArrayD.getInt(l.MaterialToolbar_logoScaleType, -1);
        if (i11 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f3308x0;
            if (i11 < scaleTypeArr.length) {
                this.f3312u0 = scaleTypeArr[i11];
            }
        }
        if (typedArrayD.hasValue(l.MaterialToolbar_logoAdjustViewBounds)) {
            this.f3313v0 = Boolean.valueOf(typedArrayD.getBoolean(l.MaterialToolbar_logoAdjustViewBounds, false));
        }
        typedArrayD.recycle();
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : a.a.k(background);
        if (colorStateListValueOf != null) {
            g gVar = new g();
            gVar.l(colorStateListValueOf);
            gVar.j(context2);
            WeakHashMap weakHashMap = o0.f10475a;
            gVar.k(f0.e(this));
            setBackground(gVar);
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f3312u0;
    }

    public Integer getNavigationIconTint() {
        return this.f3309r0;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void m(int i) {
        Menu menu = getMenu();
        boolean z2 = menu instanceof m.k;
        if (z2) {
            ((m.k) menu).y();
        }
        super.m(i);
        if (z2) {
            ((m.k) menu).x();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        i5.a.O(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z2, i, i10, i11, i12);
        int i13 = 0;
        ImageView imageView2 = null;
        if (this.f3310s0 || this.f3311t0) {
            ArrayList arrayListC = j9.f0.c(this, getTitle());
            boolean zIsEmpty = arrayListC.isEmpty();
            i iVar = j9.f0.f6883a;
            TextView textView = zIsEmpty ? null : (TextView) Collections.min(arrayListC, iVar);
            ArrayList arrayListC2 = j9.f0.c(this, getSubtitle());
            TextView textView2 = arrayListC2.isEmpty() ? null : (TextView) Collections.max(arrayListC2, iVar);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i14 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i15 = 0; i15 < getChildCount(); i15++) {
                    View childAt = getChildAt(i15);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i14 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i14 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.f3310s0 && textView != null) {
                    x(textView, pair);
                }
                if (this.f3311t0 && textView2 != null) {
                    x(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i13 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i13);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i13++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.f3313v0;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f3312u0;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        i5.a.K(this, f);
    }

    public void setLogoAdjustViewBounds(boolean z2) {
        Boolean bool = this.f3313v0;
        if (bool == null || bool.booleanValue() != z2) {
            this.f3313v0 = Boolean.valueOf(z2);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f3312u0 != scaleType) {
            this.f3312u0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.f3309r0 != null) {
            drawable = drawable.mutate();
            drawable.setTint(this.f3309r0.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i) {
        this.f3309r0 = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z2) {
        if (this.f3311t0 != z2) {
            this.f3311t0 = z2;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z2) {
        if (this.f3310s0 != z2) {
            this.f3310s0 = z2;
            requestLayout();
        }
    }

    public final void x(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i10 = measuredWidth2 + i;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i, 0), Math.max(i10 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i += iMax;
            i10 -= iMax;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i10 - i, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i, textView.getTop(), i10, textView.getBottom());
    }
}
