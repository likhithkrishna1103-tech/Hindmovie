package com.google.android.material.imageview;

import a2.t1;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import f0.c;
import n.y;
import p8.k;
import q9.g;
import q9.l;
import q9.u;
import x9.a;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class ShapeableImageView extends y implements u {
    public static final int P = k.Widget_MaterialComponents_ShapeableImageView;
    public final Paint A;
    public final Paint B;
    public final Path C;
    public ColorStateList D;
    public g E;
    public q9.k F;
    public float G;
    public final Path H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public boolean O;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final t1 f3454x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RectF f3455y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RectF f3456z;

    /* JADX WARN: Illegal instructions before constructor call */
    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        int i = P;
        super(a.a(context, attributeSet, 0, i), attributeSet, 0);
        this.f3454x = l.f11133a;
        this.C = new Path();
        this.O = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.B = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f3455y = new RectF();
        this.f3456z = new RectF();
        this.H = new Path();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, p8.l.ShapeableImageView, 0, i);
        setLayerType(2, null);
        this.D = a.a.i(context2, typedArrayObtainStyledAttributes, p8.l.ShapeableImageView_strokeColor);
        this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(p8.l.ShapeableImageView_strokeWidth, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(p8.l.ShapeableImageView_contentPadding, 0);
        this.I = dimensionPixelSize;
        this.J = dimensionPixelSize;
        this.K = dimensionPixelSize;
        this.L = dimensionPixelSize;
        this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(p8.l.ShapeableImageView_contentPaddingLeft, dimensionPixelSize);
        this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(p8.l.ShapeableImageView_contentPaddingTop, dimensionPixelSize);
        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(p8.l.ShapeableImageView_contentPaddingRight, dimensionPixelSize);
        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(p8.l.ShapeableImageView_contentPaddingBottom, dimensionPixelSize);
        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(p8.l.ShapeableImageView_contentPaddingStart, Integer.MIN_VALUE);
        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(p8.l.ShapeableImageView_contentPaddingEnd, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.A = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.F = q9.k.c(context2, attributeSet, 0, i).a();
        setOutlineProvider(new i9.a(this));
    }

    public final boolean a() {
        return getLayoutDirection() == 1;
    }

    public final void d(int i, int i10) {
        float paddingLeft = getPaddingLeft();
        float paddingTop = getPaddingTop();
        float paddingRight = i - getPaddingRight();
        float paddingBottom = i10 - getPaddingBottom();
        RectF rectF = this.f3455y;
        rectF.set(paddingLeft, paddingTop, paddingRight, paddingBottom);
        q9.k kVar = this.F;
        t1 t1Var = this.f3454x;
        Path path = this.C;
        t1Var.b(kVar, 1.0f, rectF, null, path);
        Path path2 = this.H;
        path2.rewind();
        path2.addPath(path);
        RectF rectF2 = this.f3456z;
        rectF2.set(0.0f, 0.0f, i, i10);
        path2.addRect(rectF2, Path.Direction.CCW);
    }

    public int getContentPaddingBottom() {
        return this.L;
    }

    public final int getContentPaddingEnd() {
        int i = this.N;
        return i != Integer.MIN_VALUE ? i : a() ? this.I : this.K;
    }

    public int getContentPaddingLeft() {
        int i = this.N;
        int i10 = this.M;
        if (i10 != Integer.MIN_VALUE || i != Integer.MIN_VALUE) {
            if (a() && i != Integer.MIN_VALUE) {
                return i;
            }
            if (!a() && i10 != Integer.MIN_VALUE) {
                return i10;
            }
        }
        return this.I;
    }

    public int getContentPaddingRight() {
        int i = this.N;
        int i10 = this.M;
        if (i10 != Integer.MIN_VALUE || i != Integer.MIN_VALUE) {
            if (a() && i10 != Integer.MIN_VALUE) {
                return i10;
            }
            if (!a() && i != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.K;
    }

    public final int getContentPaddingStart() {
        int i = this.M;
        return i != Integer.MIN_VALUE ? i : a() ? this.K : this.I;
    }

    public int getContentPaddingTop() {
        return this.J;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    public q9.k getShapeAppearanceModel() {
        return this.F;
    }

    public ColorStateList getStrokeColor() {
        return this.D;
    }

    public float getStrokeWidth() {
        return this.G;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.H, this.B);
        if (this.D == null) {
            return;
        }
        float f = this.G;
        Paint paint = this.A;
        paint.setStrokeWidth(f);
        int colorForState = this.D.getColorForState(getDrawableState(), this.D.getDefaultColor());
        if (this.G <= 0.0f || colorForState == 0) {
            return;
        }
        paint.setColor(colorForState);
        canvas.drawPath(this.C, paint);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        if (!this.O && isLayoutDirectionResolved()) {
            this.O = true;
            if (!isPaddingRelative() && this.M == Integer.MIN_VALUE && this.N == Integer.MIN_VALUE) {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            } else {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i10, int i11, int i12) {
        super.onSizeChanged(i, i10, i11, i12);
        d(i, i10);
    }

    @Override // android.view.View
    public final void setPadding(int i, int i10, int i11, int i12) {
        super.setPadding(getContentPaddingLeft() + i, getContentPaddingTop() + i10, getContentPaddingRight() + i11, getContentPaddingBottom() + i12);
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i10, int i11, int i12) {
        super.setPaddingRelative(getContentPaddingStart() + i, getContentPaddingTop() + i10, getContentPaddingEnd() + i11, getContentPaddingBottom() + i12);
    }

    @Override // q9.u
    public void setShapeAppearanceModel(q9.k kVar) {
        this.F = kVar;
        g gVar = this.E;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
        d(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.D = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i) {
        setStrokeColor(c.c(getContext(), i));
    }

    public void setStrokeWidth(float f) {
        if (this.G != f) {
            this.G = f;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i) {
        setStrokeWidth(getResources().getDimensionPixelSize(i));
    }
}
