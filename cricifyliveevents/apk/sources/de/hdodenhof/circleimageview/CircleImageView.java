package de.hdodenhof.circleimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import ka.y;
import od.a;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class CircleImageView extends ImageView {
    public static final ImageView.ScaleType P = ImageView.ScaleType.CENTER_CROP;
    public static final Bitmap.Config Q = Bitmap.Config.ARGB_8888;
    public final Paint A;
    public int B;
    public int C;
    public int D;
    public Bitmap E;
    public BitmapShader F;
    public int G;
    public int H;
    public float I;
    public float J;
    public ColorFilter K;
    public final boolean L;
    public boolean M;
    public boolean N;
    public boolean O;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f3688v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RectF f3689w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Matrix f3690x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Paint f3691y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Paint f3692z;

    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3688v = new RectF();
        this.f3689w = new RectF();
        this.f3690x = new Matrix();
        this.f3691y = new Paint();
        this.f3692z = new Paint();
        this.A = new Paint();
        this.B = -16777216;
        this.C = 0;
        this.D = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.CircleImageView, 0, 0);
        this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(a.CircleImageView_civ_border_width, 0);
        this.B = typedArrayObtainStyledAttributes.getColor(a.CircleImageView_civ_border_color, -16777216);
        this.N = typedArrayObtainStyledAttributes.getBoolean(a.CircleImageView_civ_border_overlay, false);
        this.D = typedArrayObtainStyledAttributes.getColor(a.CircleImageView_civ_circle_background_color, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setScaleType(P);
        this.L = true;
        setOutlineProvider(new y(2, this));
        if (this.M) {
            b();
            this.M = false;
        }
    }

    public final void a() {
        Bitmap bitmap = null;
        if (this.O) {
            this.E = null;
        } else {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                if (drawable instanceof BitmapDrawable) {
                    bitmap = ((BitmapDrawable) drawable).getBitmap();
                } else {
                    try {
                        boolean z10 = drawable instanceof ColorDrawable;
                        Bitmap.Config config = Q;
                        Bitmap bitmapCreateBitmap = z10 ? Bitmap.createBitmap(2, 2, config) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), config);
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                        drawable.draw(canvas);
                        bitmap = bitmapCreateBitmap;
                    } catch (Exception e9) {
                        e9.printStackTrace();
                    }
                }
            }
            this.E = bitmap;
        }
        b();
    }

    public final void b() {
        float fWidth;
        float fHeight;
        int i;
        if (!this.L) {
            this.M = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.E == null) {
            invalidate();
            return;
        }
        Bitmap bitmap = this.E;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.F = new BitmapShader(bitmap, tileMode, tileMode);
        Paint paint = this.f3691y;
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        paint.setShader(this.F);
        Paint.Style style = Paint.Style.STROKE;
        Paint paint2 = this.f3692z;
        paint2.setStyle(style);
        paint2.setAntiAlias(true);
        paint2.setColor(this.B);
        paint2.setStrokeWidth(this.C);
        Paint.Style style2 = Paint.Style.FILL;
        Paint paint3 = this.A;
        paint3.setStyle(style2);
        paint3.setAntiAlias(true);
        paint3.setColor(this.D);
        this.H = this.E.getHeight();
        this.G = this.E.getWidth();
        int iMin = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = ((r1 - iMin) / 2.0f) + getPaddingLeft();
        float paddingTop = ((r2 - iMin) / 2.0f) + getPaddingTop();
        float f = iMin;
        RectF rectF = new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
        RectF rectF2 = this.f3689w;
        rectF2.set(rectF);
        this.J = Math.min((rectF2.height() - this.C) / 2.0f, (rectF2.width() - this.C) / 2.0f);
        RectF rectF3 = this.f3688v;
        rectF3.set(rectF2);
        if (!this.N && (i = this.C) > 0) {
            float f10 = i - 1.0f;
            rectF3.inset(f10, f10);
        }
        this.I = Math.min(rectF3.height() / 2.0f, rectF3.width() / 2.0f);
        if (paint != null) {
            paint.setColorFilter(this.K);
        }
        Matrix matrix = this.f3690x;
        matrix.set(null);
        float fWidth2 = 0.0f;
        if (rectF3.height() * this.G > rectF3.width() * this.H) {
            fWidth = rectF3.height() / this.H;
            fHeight = 0.0f;
            fWidth2 = (rectF3.width() - (this.G * fWidth)) * 0.5f;
        } else {
            fWidth = rectF3.width() / this.G;
            fHeight = (rectF3.height() - (this.H * fWidth)) * 0.5f;
        }
        matrix.setScale(fWidth, fWidth);
        matrix.postTranslate(((int) (fWidth2 + 0.5f)) + rectF3.left, ((int) (fHeight + 0.5f)) + rectF3.top);
        this.F.setLocalMatrix(matrix);
        invalidate();
    }

    public int getBorderColor() {
        return this.B;
    }

    public int getBorderWidth() {
        return this.C;
    }

    public int getCircleBackgroundColor() {
        return this.D;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.K;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return P;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.O) {
            super.onDraw(canvas);
            return;
        }
        if (this.E == null) {
            return;
        }
        int i = this.D;
        RectF rectF = this.f3688v;
        if (i != 0) {
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), this.I, this.A);
        }
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), this.I, this.f3691y);
        if (this.C > 0) {
            RectF rectF2 = this.f3689w;
            canvas.drawCircle(rectF2.centerX(), rectF2.centerY(), this.J, this.f3692z);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i10, int i11, int i12) {
        super.onSizeChanged(i, i10, i11, i12);
        b();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.O) {
            return super.onTouchEvent(motionEvent);
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (!this.f3689w.isEmpty()) {
            if (Math.pow(y10 - r2.centerY(), 2.0d) + Math.pow(x10 - r2.centerX(), 2.0d) > Math.pow(this.J, 2.0d)) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z10) {
        if (z10) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(int i) {
        if (i == this.B) {
            return;
        }
        this.B = i;
        this.f3692z.setColor(i);
        invalidate();
    }

    public void setBorderOverlay(boolean z10) {
        if (z10 == this.N) {
            return;
        }
        this.N = z10;
        b();
    }

    public void setBorderWidth(int i) {
        if (i == this.C) {
            return;
        }
        this.C = i;
        b();
    }

    public void setCircleBackgroundColor(int i) {
        if (i == this.D) {
            return;
        }
        this.D = i;
        this.A.setColor(i);
        invalidate();
    }

    public void setCircleBackgroundColorResource(int i) {
        setCircleBackgroundColor(getContext().getResources().getColor(i));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.K) {
            return;
        }
        this.K = colorFilter;
        Paint paint = this.f3691y;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
        invalidate();
    }

    public void setDisableCircularTransformation(boolean z10) {
        if (this.O == z10) {
            return;
        }
        this.O = z10;
        a();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        a();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        a();
    }

    @Override // android.view.View
    public final void setPadding(int i, int i10, int i11, int i12) {
        super.setPadding(i, i10, i11, i12);
        b();
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i10, int i11, int i12) {
        super.setPaddingRelative(i, i10, i11, i12);
        b();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == P) {
            return;
        }
        throw new IllegalArgumentException("ScaleType " + scaleType + " not supported.");
    }
}
