package s9;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.WeakHashMap;
import p8.d;
import p8.l;
import q0.d0;
import q0.f0;
import q0.o0;
import q9.g;
import q9.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b extends FrameLayout {
    public static final a C = new a();
    public ColorStateList A;
    public PorterDuff.Mode B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final k f11933u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f11934v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f11935w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f11936x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f11937y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f11938z;

    public b(Context context, AttributeSet attributeSet) {
        Drawable drawable;
        super(x9.a.a(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, l.SnackbarLayout);
        if (typedArrayObtainStyledAttributes.hasValue(l.SnackbarLayout_elevation)) {
            float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.SnackbarLayout_elevation, 0);
            WeakHashMap weakHashMap = o0.f10475a;
            f0.k(this, dimensionPixelSize);
        }
        this.f11934v = typedArrayObtainStyledAttributes.getInt(l.SnackbarLayout_animationMode, 0);
        if (typedArrayObtainStyledAttributes.hasValue(l.SnackbarLayout_shapeAppearance) || typedArrayObtainStyledAttributes.hasValue(l.SnackbarLayout_shapeAppearanceOverlay)) {
            this.f11933u = k.c(context2, attributeSet, 0, 0).a();
        }
        this.f11935w = typedArrayObtainStyledAttributes.getFloat(l.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
        setBackgroundTintList(a.a.i(context2, typedArrayObtainStyledAttributes, l.SnackbarLayout_backgroundTint));
        setBackgroundTintMode(j9.f0.e(typedArrayObtainStyledAttributes.getInt(l.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
        this.f11936x = typedArrayObtainStyledAttributes.getFloat(l.SnackbarLayout_actionTextColorAlpha, 1.0f);
        this.f11937y = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.SnackbarLayout_android_maxWidth, -1);
        this.f11938z = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.SnackbarLayout_maxActionInlineWidth, -1);
        typedArrayObtainStyledAttributes.recycle();
        setOnTouchListener(C);
        setFocusable(true);
        if (getBackground() == null) {
            int iR = z7.a.r(getBackgroundOverlayColorAlpha(), z7.a.m(this, p8.b.colorSurface), z7.a.m(this, p8.b.colorOnSurface));
            k kVar = this.f11933u;
            if (kVar != null) {
                int i = c.f11939a;
                g gVar = new g(kVar);
                gVar.l(ColorStateList.valueOf(iR));
                drawable = gVar;
            } else {
                Resources resources = getResources();
                int i10 = c.f11939a;
                float dimension = resources.getDimension(d.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                gradientDrawable.setColor(iR);
                drawable = gradientDrawable;
            }
            ColorStateList colorStateList = this.A;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
            WeakHashMap weakHashMap2 = o0.f10475a;
            setBackground(drawable);
        }
    }

    public float getActionTextColorAlpha() {
        return this.f11936x;
    }

    public int getAnimationMode() {
        return this.f11934v;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f11935w;
    }

    public int getMaxInlineActionWidth() {
        return this.f11938z;
    }

    public int getMaxWidth() {
        return this.f11937y;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        WeakHashMap weakHashMap = o0.f10475a;
        d0.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        super.onLayout(z2, i, i10, i11, i12);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        int i11 = this.f11937y;
        if (i11 <= 0 || getMeasuredWidth() <= i11) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), i10);
    }

    public void setAnimationMode(int i) {
        this.f11934v = i;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.A != null) {
            drawable = drawable.mutate();
            drawable.setTintList(this.A);
            drawable.setTintMode(this.B);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.A = colorStateList;
        if (getBackground() != null) {
            Drawable drawableMutate = getBackground().mutate();
            drawableMutate.setTintList(colorStateList);
            drawableMutate.setTintMode(this.B);
            if (drawableMutate != getBackground()) {
                super.setBackgroundDrawable(drawableMutate);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.B = mode;
        if (getBackground() != null) {
            Drawable drawableMutate = getBackground().mutate();
            drawableMutate.setTintMode(mode);
            if (drawableMutate != getBackground()) {
                super.setBackgroundDrawable(drawableMutate);
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : C);
        super.setOnClickListener(onClickListener);
    }

    private void setBaseTransientBottomBar(c cVar) {
    }
}
