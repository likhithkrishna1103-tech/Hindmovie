package j;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import g.i;
import g.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends Drawable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float f6654m = (float) Math.toRadians(45.0d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f6655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f6656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f6657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f6658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f6659e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f6660g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f6661h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f6662j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f6663k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f6664l;

    public f(Context context) {
        Paint paint = new Paint();
        this.f6655a = paint;
        this.f6660g = new Path();
        this.i = false;
        this.f6664l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, j.DrawerArrowToggle, g.a.drawerArrowStyle, i.Base_Widget_AppCompat_DrawerArrowToggle);
        int color = typedArrayObtainStyledAttributes.getColor(j.DrawerArrowToggle_color, 0);
        if (color != paint.getColor()) {
            paint.setColor(color);
            invalidateSelf();
        }
        float dimension = typedArrayObtainStyledAttributes.getDimension(j.DrawerArrowToggle_thickness, 0.0f);
        if (paint.getStrokeWidth() != dimension) {
            paint.setStrokeWidth(dimension);
            this.f6663k = (float) (Math.cos(f6654m) * ((double) (dimension / 2.0f)));
            invalidateSelf();
        }
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(j.DrawerArrowToggle_spinBars, true);
        if (this.f != z2) {
            this.f = z2;
            invalidateSelf();
        }
        float fRound = Math.round(typedArrayObtainStyledAttributes.getDimension(j.DrawerArrowToggle_gapBetweenBars, 0.0f));
        if (fRound != this.f6659e) {
            this.f6659e = fRound;
            invalidateSelf();
        }
        this.f6661h = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.DrawerArrowToggle_drawableSize, 0);
        this.f6657c = Math.round(typedArrayObtainStyledAttributes.getDimension(j.DrawerArrowToggle_barLength, 0.0f));
        this.f6656b = Math.round(typedArrayObtainStyledAttributes.getDimension(j.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f6658d = typedArrayObtainStyledAttributes.getDimension(j.DrawerArrowToggle_arrowShaftLength, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float a(float f, float f4, float f10) {
        return e6.j.g(f4, f, f10, f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        boolean z2 = false;
        int i = this.f6664l;
        if (i != 0 && (i == 1 || (i == 3 ? getLayoutDirection() == 0 : getLayoutDirection() == 1))) {
            z2 = true;
        }
        float f = this.f6656b;
        float fSqrt = (float) Math.sqrt(f * f * 2.0f);
        float f4 = this.f6662j;
        float f10 = this.f6657c;
        float fA = a(f10, fSqrt, f4);
        float fA2 = a(f10, this.f6658d, this.f6662j);
        float fRound = Math.round(a(0.0f, this.f6663k, this.f6662j));
        float fA3 = a(0.0f, f6654m, this.f6662j);
        float fA4 = a(z2 ? 0.0f : -180.0f, z2 ? 180.0f : 0.0f, this.f6662j);
        double d10 = fA;
        double d11 = fA3;
        float fRound2 = Math.round(Math.cos(d11) * d10);
        float fRound3 = Math.round(Math.sin(d11) * d10);
        Path path = this.f6660g;
        path.rewind();
        float f11 = this.f6659e;
        Paint paint = this.f6655a;
        float fA5 = a(f11 + paint.getStrokeWidth(), -this.f6663k, this.f6662j);
        float f12 = (-fA2) / 2.0f;
        path.moveTo(f12 + fRound, 0.0f);
        path.rLineTo(fA2 - (fRound * 2.0f), 0.0f);
        path.moveTo(f12, fA5);
        path.rLineTo(fRound2, fRound3);
        path.moveTo(f12, -fA5);
        path.rLineTo(fRound2, -fRound3);
        path.close();
        canvas.save();
        float strokeWidth = paint.getStrokeWidth();
        float fHeight = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), (strokeWidth * 1.5f) + this.f6659e + ((((int) (fHeight - (r7 * 2.0f))) / 4) * 2));
        if (this.f) {
            canvas.rotate(fA4 * (this.i ^ z2 ? -1 : 1));
        } else if (z2) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f6661h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f6661h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Paint paint = this.f6655a;
        if (i != paint.getAlpha()) {
            paint.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f6655a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
