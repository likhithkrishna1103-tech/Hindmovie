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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends Drawable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float f6490m = (float) Math.toRadians(45.0d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f6491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f6492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f6493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f6494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f6495e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f6496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f6497h;
    public boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f6498j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f6499k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f6500l;

    public g(Context context) {
        Paint paint = new Paint();
        this.f6491a = paint;
        this.f6496g = new Path();
        this.i = false;
        this.f6500l = 2;
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
            this.f6499k = (float) (Math.cos(f6490m) * ((double) (dimension / 2.0f)));
            invalidateSelf();
        }
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(j.DrawerArrowToggle_spinBars, true);
        if (this.f != z10) {
            this.f = z10;
            invalidateSelf();
        }
        float fRound = Math.round(typedArrayObtainStyledAttributes.getDimension(j.DrawerArrowToggle_gapBetweenBars, 0.0f));
        if (fRound != this.f6495e) {
            this.f6495e = fRound;
            invalidateSelf();
        }
        this.f6497h = typedArrayObtainStyledAttributes.getDimensionPixelSize(j.DrawerArrowToggle_drawableSize, 0);
        this.f6493c = Math.round(typedArrayObtainStyledAttributes.getDimension(j.DrawerArrowToggle_barLength, 0.0f));
        this.f6492b = Math.round(typedArrayObtainStyledAttributes.getDimension(j.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f6494d = typedArrayObtainStyledAttributes.getDimension(j.DrawerArrowToggle_arrowShaftLength, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float a(float f, float f10, float f11) {
        return q4.a.h(f10, f, f11, f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        boolean z10 = false;
        int i = this.f6500l;
        if (i != 0 && (i == 1 || (i == 3 ? getLayoutDirection() == 0 : getLayoutDirection() == 1))) {
            z10 = true;
        }
        float f = this.f6492b;
        float fSqrt = (float) Math.sqrt(f * f * 2.0f);
        float f10 = this.f6498j;
        float f11 = this.f6493c;
        float fA = a(f11, fSqrt, f10);
        float fA2 = a(f11, this.f6494d, this.f6498j);
        float fRound = Math.round(a(0.0f, this.f6499k, this.f6498j));
        float fA3 = a(0.0f, f6490m, this.f6498j);
        float fA4 = a(z10 ? 0.0f : -180.0f, z10 ? 180.0f : 0.0f, this.f6498j);
        double d10 = fA;
        double d11 = fA3;
        float fRound2 = Math.round(Math.cos(d11) * d10);
        float fRound3 = Math.round(Math.sin(d11) * d10);
        Path path = this.f6496g;
        path.rewind();
        float f12 = this.f6495e;
        Paint paint = this.f6491a;
        float fA5 = a(f12 + paint.getStrokeWidth(), -this.f6499k, this.f6498j);
        float f13 = (-fA2) / 2.0f;
        path.moveTo(f13 + fRound, 0.0f);
        path.rLineTo(fA2 - (fRound * 2.0f), 0.0f);
        path.moveTo(f13, fA5);
        path.rLineTo(fRound2, fRound3);
        path.moveTo(f13, -fA5);
        path.rLineTo(fRound2, -fRound3);
        path.close();
        canvas.save();
        float strokeWidth = paint.getStrokeWidth();
        float fHeight = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), (strokeWidth * 1.5f) + this.f6495e + ((((int) (fHeight - (r7 * 2.0f))) / 4) * 2));
        if (this.f) {
            canvas.rotate(fA4 * (this.i ^ z10 ? -1 : 1));
        } else if (z10) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f6497h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f6497h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Paint paint = this.f6491a;
        if (i != paint.getAlpha()) {
            paint.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f6491a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setProgress(float f) {
        if (this.f6498j != f) {
            this.f6498j = f;
            invalidateSelf();
        }
    }
}
