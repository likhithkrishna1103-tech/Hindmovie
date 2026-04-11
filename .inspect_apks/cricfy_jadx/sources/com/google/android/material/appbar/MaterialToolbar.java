package com.google.android.material.appbar;

import a5.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.bumptech.glide.e;
import da.d0;
import da.e0;
import java.util.ArrayList;
import java.util.Collections;
import k9.k;
import k9.l;
import ka.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final int f2759x0 = k.Widget_MaterialComponents_Toolbar;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final ImageView.ScaleType[] f2760y0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public Integer f2761s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f2762t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f2763u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public ImageView.ScaleType f2764v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public Boolean f2765w0;

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        int i = g.a.toolbarStyle;
        int i10 = f2759x0;
        super(ra.a.a(context, attributeSet, i, i10), attributeSet, i);
        Context context2 = getContext();
        TypedArray typedArrayD = d0.d(context2, attributeSet, l.MaterialToolbar, i, i10, new int[0]);
        if (typedArrayD.hasValue(l.MaterialToolbar_navigationIconTint)) {
            setNavigationIconTint(typedArrayD.getColor(l.MaterialToolbar_navigationIconTint, -1));
        }
        this.f2762t0 = typedArrayD.getBoolean(l.MaterialToolbar_titleCentered, false);
        this.f2763u0 = typedArrayD.getBoolean(l.MaterialToolbar_subtitleCentered, false);
        int i11 = typedArrayD.getInt(l.MaterialToolbar_logoScaleType, -1);
        if (i11 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f2760y0;
            if (i11 < scaleTypeArr.length) {
                this.f2764v0 = scaleTypeArr[i11];
            }
        }
        if (typedArrayD.hasValue(l.MaterialToolbar_logoAdjustViewBounds)) {
            this.f2765w0 = Boolean.valueOf(typedArrayD.getBoolean(l.MaterialToolbar_logoAdjustViewBounds, false));
        }
        typedArrayD.recycle();
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : u8.a.r(background);
        if (colorStateListValueOf != null) {
            i iVar = new i();
            iVar.q(colorStateListValueOf);
            iVar.m(context2);
            iVar.p(getElevation());
            setBackground(iVar);
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f2764v0;
    }

    public Integer getNavigationIconTint() {
        return this.f2761s0;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        e.q(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z10, i, i10, i11, i12);
        int i13 = 0;
        ImageView imageView2 = null;
        if (this.f2762t0 || this.f2763u0) {
            ArrayList arrayListB = e0.b(this, getTitle());
            boolean zIsEmpty = arrayListB.isEmpty();
            f fVar = e0.f3616a;
            TextView textView = zIsEmpty ? null : (TextView) Collections.min(arrayListB, fVar);
            ArrayList arrayListB2 = e0.b(this, getSubtitle());
            TextView textView2 = arrayListB2.isEmpty() ? null : (TextView) Collections.max(arrayListB2, fVar);
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
                if (this.f2762t0 && textView != null) {
                    w(textView, pair);
                }
                if (this.f2763u0 && textView2 != null) {
                    w(textView2, pair);
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
            Boolean bool = this.f2765w0;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f2764v0;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        e.o(this, f);
    }

    public void setLogoAdjustViewBounds(boolean z10) {
        Boolean bool = this.f2765w0;
        if (bool == null || bool.booleanValue() != z10) {
            this.f2765w0 = Boolean.valueOf(z10);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f2764v0 != scaleType) {
            this.f2764v0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.f2761s0 != null) {
            drawable = drawable.mutate();
            drawable.setTint(this.f2761s0.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i) {
        this.f2761s0 = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z10) {
        if (this.f2763u0 != z10) {
            this.f2763u0 = z10;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z10) {
        if (this.f2762t0 != z10) {
            this.f2762t0 = z10;
            requestLayout();
        }
    }

    public final void w(TextView textView, Pair pair) {
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
