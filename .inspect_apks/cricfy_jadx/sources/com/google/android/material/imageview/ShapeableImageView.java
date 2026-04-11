package com.google.android.material.imageview;

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
import com.bumptech.glide.c;
import g2.h1;
import k9.k;
import k9.l;
import ka.i;
import ka.m;
import ka.n;
import o.w;
import ra.a;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class ShapeableImageView extends w implements ka.w {
    public static final int Q = k.Widget_MaterialComponents_ShapeableImageView;
    public final RectF A;
    public final Paint B;
    public final Paint C;
    public final Path D;
    public ColorStateList E;
    public i F;
    public m G;
    public float H;
    public final Path I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;
    public boolean P;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final h1 f2917y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RectF f2918z;

    /* JADX WARN: Illegal instructions before constructor call */
    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        int i = Q;
        super(a.a(context, attributeSet, 0, i), attributeSet, 0);
        this.f2917y = n.f7360a;
        this.D = new Path();
        this.P = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.C = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f2918z = new RectF();
        this.A = new RectF();
        this.I = new Path();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, l.ShapeableImageView, 0, i);
        setLayerType(2, null);
        this.E = c.i(context2, typedArrayObtainStyledAttributes, l.ShapeableImageView_strokeColor);
        this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.ShapeableImageView_strokeWidth, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.ShapeableImageView_contentPadding, 0);
        this.J = dimensionPixelSize;
        this.K = dimensionPixelSize;
        this.L = dimensionPixelSize;
        this.M = dimensionPixelSize;
        this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.ShapeableImageView_contentPaddingLeft, dimensionPixelSize);
        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.ShapeableImageView_contentPaddingTop, dimensionPixelSize);
        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.ShapeableImageView_contentPaddingRight, dimensionPixelSize);
        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.ShapeableImageView_contentPaddingBottom, dimensionPixelSize);
        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.ShapeableImageView_contentPaddingStart, Integer.MIN_VALUE);
        this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(l.ShapeableImageView_contentPaddingEnd, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.B = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.G = m.c(context2, attributeSet, 0, i).a();
        setOutlineProvider(new ca.a(this));
    }

    public final boolean a() {
        return getLayoutDirection() == 1;
    }

    public final void d(int i, int i10) {
        float paddingLeft = getPaddingLeft();
        float paddingTop = getPaddingTop();
        float paddingRight = i - getPaddingRight();
        float paddingBottom = i10 - getPaddingBottom();
        RectF rectF = this.f2918z;
        rectF.set(paddingLeft, paddingTop, paddingRight, paddingBottom);
        m mVar = this.G;
        h1 h1Var = this.f2917y;
        Path path = this.D;
        h1Var.b(mVar, null, 1.0f, rectF, null, path);
        Path path2 = this.I;
        path2.rewind();
        path2.addPath(path);
        RectF rectF2 = this.A;
        rectF2.set(0.0f, 0.0f, i, i10);
        path2.addRect(rectF2, Path.Direction.CCW);
    }

    public int getContentPaddingBottom() {
        return this.M;
    }

    public final int getContentPaddingEnd() {
        int i = this.O;
        return i != Integer.MIN_VALUE ? i : a() ? this.J : this.L;
    }

    public int getContentPaddingLeft() {
        int i = this.O;
        int i10 = this.N;
        if (i10 != Integer.MIN_VALUE || i != Integer.MIN_VALUE) {
            if (a() && i != Integer.MIN_VALUE) {
                return i;
            }
            if (!a() && i10 != Integer.MIN_VALUE) {
                return i10;
            }
        }
        return this.J;
    }

    public int getContentPaddingRight() {
        int i = this.O;
        int i10 = this.N;
        if (i10 != Integer.MIN_VALUE || i != Integer.MIN_VALUE) {
            if (a() && i10 != Integer.MIN_VALUE) {
                return i10;
            }
            if (!a() && i != Integer.MIN_VALUE) {
                return i;
            }
        }
        return this.L;
    }

    public final int getContentPaddingStart() {
        int i = this.N;
        return i != Integer.MIN_VALUE ? i : a() ? this.L : this.J;
    }

    public int getContentPaddingTop() {
        return this.K;
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

    public m getShapeAppearanceModel() {
        return this.G;
    }

    public ColorStateList getStrokeColor() {
        return this.E;
    }

    public float getStrokeWidth() {
        return this.H;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.I, this.C);
        if (this.E == null) {
            return;
        }
        float f = this.H;
        Paint paint = this.B;
        paint.setStrokeWidth(f);
        int colorForState = this.E.getColorForState(getDrawableState(), this.E.getDefaultColor());
        if (this.H <= 0.0f || colorForState == 0) {
            return;
        }
        paint.setColor(colorForState);
        canvas.drawPath(this.D, paint);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        if (!this.P && isLayoutDirectionResolved()) {
            this.P = true;
            if (!isPaddingRelative() && this.N == Integer.MIN_VALUE && this.O == Integer.MIN_VALUE) {
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

    @Override // ka.w
    public void setShapeAppearanceModel(m mVar) {
        this.G = mVar;
        i iVar = this.F;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(mVar);
        }
        d(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.E = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i) {
        setStrokeColor(i0.c.c(getContext(), i));
    }

    public void setStrokeWidth(float f) {
        if (this.H != f) {
            this.H = f;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i) {
        setStrokeWidth(getResources().getDimensionPixelSize(i));
    }
}
