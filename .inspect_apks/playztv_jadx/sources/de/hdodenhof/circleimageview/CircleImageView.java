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
import b9.b;
import kd.a;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class CircleImageView extends ImageView {
    public static final ImageView.ScaleType O = ImageView.ScaleType.CENTER_CROP;
    public static final Bitmap.Config P = Bitmap.Config.ARGB_8888;
    public int A;
    public int B;
    public int C;
    public Bitmap D;
    public BitmapShader E;
    public int F;
    public int G;
    public float H;
    public float I;
    public ColorFilter J;
    public final boolean K;
    public boolean L;
    public boolean M;
    public boolean N;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RectF f4190u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f4191v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Matrix f4192w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Paint f4193x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Paint f4194y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Paint f4195z;

    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f4190u = new RectF();
        this.f4191v = new RectF();
        this.f4192w = new Matrix();
        this.f4193x = new Paint();
        this.f4194y = new Paint();
        this.f4195z = new Paint();
        this.A = -16777216;
        this.B = 0;
        this.C = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.CircleImageView, 0, 0);
        this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(a.CircleImageView_civ_border_width, 0);
        this.A = typedArrayObtainStyledAttributes.getColor(a.CircleImageView_civ_border_color, -16777216);
        this.M = typedArrayObtainStyledAttributes.getBoolean(a.CircleImageView_civ_border_overlay, false);
        this.C = typedArrayObtainStyledAttributes.getColor(a.CircleImageView_civ_circle_background_color, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setScaleType(O);
        this.K = true;
        setOutlineProvider(new b(1, this));
        if (this.L) {
            b();
            this.L = false;
        }
    }

    public final void a() {
        Bitmap bitmap = null;
        if (this.N) {
            this.D = null;
        } else {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                if (drawable instanceof BitmapDrawable) {
                    bitmap = ((BitmapDrawable) drawable).getBitmap();
                } else {
                    try {
                        boolean z2 = drawable instanceof ColorDrawable;
                        Bitmap.Config config = P;
                        Bitmap bitmapCreateBitmap = z2 ? Bitmap.createBitmap(2, 2, config) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), config);
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                        drawable.draw(canvas);
                        bitmap = bitmapCreateBitmap;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }
            this.D = bitmap;
        }
        b();
    }

    public final void b() {
        float fWidth;
        float fHeight;
        int i;
        if (!this.K) {
            this.L = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.D == null) {
            invalidate();
            return;
        }
        Bitmap bitmap = this.D;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.E = new BitmapShader(bitmap, tileMode, tileMode);
        Paint paint = this.f4193x;
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        paint.setShader(this.E);
        Paint.Style style = Paint.Style.STROKE;
        Paint paint2 = this.f4194y;
        paint2.setStyle(style);
        paint2.setAntiAlias(true);
        paint2.setColor(this.A);
        paint2.setStrokeWidth(this.B);
        Paint.Style style2 = Paint.Style.FILL;
        Paint paint3 = this.f4195z;
        paint3.setStyle(style2);
        paint3.setAntiAlias(true);
        paint3.setColor(this.C);
        this.G = this.D.getHeight();
        this.F = this.D.getWidth();
        int iMin = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = ((r1 - iMin) / 2.0f) + getPaddingLeft();
        float paddingTop = ((r2 - iMin) / 2.0f) + getPaddingTop();
        float f = iMin;
        RectF rectF = new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
        RectF rectF2 = this.f4191v;
        rectF2.set(rectF);
        this.I = Math.min((rectF2.height() - this.B) / 2.0f, (rectF2.width() - this.B) / 2.0f);
        RectF rectF3 = this.f4190u;
        rectF3.set(rectF2);
        if (!this.M && (i = this.B) > 0) {
            float f4 = i - 1.0f;
            rectF3.inset(f4, f4);
        }
        this.H = Math.min(rectF3.height() / 2.0f, rectF3.width() / 2.0f);
        if (paint != null) {
            paint.setColorFilter(this.J);
        }
        Matrix matrix = this.f4192w;
        matrix.set(null);
        float fWidth2 = 0.0f;
        if (rectF3.height() * this.F > rectF3.width() * this.G) {
            fWidth = rectF3.height() / this.G;
            fHeight = 0.0f;
            fWidth2 = (rectF3.width() - (this.F * fWidth)) * 0.5f;
        } else {
            fWidth = rectF3.width() / this.F;
            fHeight = (rectF3.height() - (this.G * fWidth)) * 0.5f;
        }
        matrix.setScale(fWidth, fWidth);
        matrix.postTranslate(((int) (fWidth2 + 0.5f)) + rectF3.left, ((int) (fHeight + 0.5f)) + rectF3.top);
        this.E.setLocalMatrix(matrix);
        invalidate();
    }

    public int getBorderColor() {
        return this.A;
    }

    public int getBorderWidth() {
        return this.B;
    }

    public int getCircleBackgroundColor() {
        return this.C;
    }

    @Override // android.widget.ImageView
    public ColorFilter getColorFilter() {
        return this.J;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return O;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.N) {
            super.onDraw(canvas);
            return;
        }
        if (this.D == null) {
            return;
        }
        int i = this.C;
        RectF rectF = this.f4190u;
        if (i != 0) {
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), this.H, this.f4195z);
        }
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), this.H, this.f4193x);
        if (this.B > 0) {
            RectF rectF2 = this.f4191v;
            canvas.drawCircle(rectF2.centerX(), rectF2.centerY(), this.I, this.f4194y);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i10, int i11, int i12) {
        super.onSizeChanged(i, i10, i11, i12);
        b();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.N) {
            return super.onTouchEvent(motionEvent);
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (!this.f4191v.isEmpty()) {
            if (Math.pow(y10 - r2.centerY(), 2.0d) + Math.pow(x10 - r2.centerX(), 2.0d) > Math.pow(this.I, 2.0d)) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z2) {
        if (z2) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(int i) {
        if (i == this.A) {
            return;
        }
        this.A = i;
        this.f4194y.setColor(i);
        invalidate();
    }

    public void setBorderOverlay(boolean z2) {
        if (z2 == this.M) {
            return;
        }
        this.M = z2;
        b();
    }

    public void setBorderWidth(int i) {
        if (i == this.B) {
            return;
        }
        this.B = i;
        b();
    }

    public void setCircleBackgroundColor(int i) {
        if (i == this.C) {
            return;
        }
        this.C = i;
        this.f4195z.setColor(i);
        invalidate();
    }

    public void setCircleBackgroundColorResource(int i) {
        setCircleBackgroundColor(getContext().getResources().getColor(i));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.J) {
            return;
        }
        this.J = colorFilter;
        Paint paint = this.f4193x;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
        invalidate();
    }

    public void setDisableCircularTransformation(boolean z2) {
        if (this.N == z2) {
            return;
        }
        this.N = z2;
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
        if (scaleType == O) {
            return;
        }
        throw new IllegalArgumentException("ScaleType " + scaleType + " not supported.");
    }
}
