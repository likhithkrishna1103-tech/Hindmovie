package ma;

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
import com.bumptech.glide.f;
import da.e0;
import k9.l;
import ka.i;
import ka.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends FrameLayout {
    public static final b D = new b();
    public final int A;
    public ColorStateList B;
    public PorterDuff.Mode C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final m f8410v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8411w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f8412x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f8413y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f8414z;

    public c(Context context, AttributeSet attributeSet) {
        Drawable drawable;
        super(ra.a.a(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, l.SnackbarLayout);
        if (typedArrayObtainStyledAttributes.hasValue(l.SnackbarLayout_elevation)) {
            setElevation(typedArrayObtainStyledAttributes.getDimensionPixelSize(l.SnackbarLayout_elevation, 0));
        }
        this.f8411w = typedArrayObtainStyledAttributes.getInt(l.SnackbarLayout_animationMode, 0);
        if (typedArrayObtainStyledAttributes.hasValue(l.SnackbarLayout_shapeAppearance) || typedArrayObtainStyledAttributes.hasValue(l.SnackbarLayout_shapeAppearanceOverlay)) {
            this.f8410v = m.c(context2, attributeSet, 0, 0).a();
        }
        this.f8412x = typedArrayObtainStyledAttributes.getFloat(l.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
        setBackgroundTintList(com.bumptech.glide.c.i(context2, typedArrayObtainStyledAttributes, l.SnackbarLayout_backgroundTint));
        setBackgroundTintMode(e0.c(typedArrayObtainStyledAttributes.getInt(l.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
        this.f8413y = typedArrayObtainStyledAttributes.getFloat(l.SnackbarLayout_actionTextColorAlpha, 1.0f);
        this.f8414z = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.SnackbarLayout_android_maxWidth, -1);
        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.SnackbarLayout_maxActionInlineWidth, -1);
        typedArrayObtainStyledAttributes.recycle();
        setOnTouchListener(D);
        setFocusable(true);
        if (getBackground() == null) {
            int iD = f.D(getBackgroundOverlayColorAlpha(), f.n(this, k9.b.colorSurface), f.n(this, k9.b.colorOnSurface));
            m mVar = this.f8410v;
            if (mVar != null) {
                int i = d.f8415a;
                i iVar = new i(mVar);
                iVar.q(ColorStateList.valueOf(iD));
                drawable = iVar;
            } else {
                Resources resources = getResources();
                int i10 = d.f8415a;
                float dimension = resources.getDimension(k9.d.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                gradientDrawable.setColor(iD);
                drawable = gradientDrawable;
            }
            ColorStateList colorStateList = this.B;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
            setBackground(drawable);
        }
    }

    public float getActionTextColorAlpha() {
        return this.f8413y;
    }

    public int getAnimationMode() {
        return this.f8411w;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f8412x;
    }

    public int getMaxInlineActionWidth() {
        return this.A;
    }

    public int getMaxWidth() {
        return this.f8414z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        super.onLayout(z10, i, i10, i11, i12);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        int i11 = this.f8414z;
        if (i11 <= 0 || getMeasuredWidth() <= i11) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), i10);
    }

    public void setAnimationMode(int i) {
        this.f8411w = i;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.B != null) {
            drawable = drawable.mutate();
            drawable.setTintList(this.B);
            drawable.setTintMode(this.C);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.B = colorStateList;
        if (getBackground() != null) {
            Drawable drawableMutate = getBackground().mutate();
            drawableMutate.setTintList(colorStateList);
            drawableMutate.setTintMode(this.C);
            if (drawableMutate != getBackground()) {
                super.setBackgroundDrawable(drawableMutate);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.C = mode;
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
        setOnTouchListener(onClickListener != null ? null : D);
        super.setOnClickListener(onClickListener);
    }

    private void setBaseTransientBottomBar(d dVar) {
    }
}
