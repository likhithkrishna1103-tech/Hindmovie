package j5;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends Drawable implements Animatable {
    public static final LinearInterpolator B = new LinearInterpolator();
    public static final q1.a C = new q1.a(1);
    public static final int[] D = {-16777216};
    public boolean A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c f6611v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f6612w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Resources f6613x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ValueAnimator f6614y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f6615z;

    public d(Context context) {
        context.getClass();
        this.f6613x = context.getResources();
        c cVar = new c();
        this.f6611v = cVar;
        cVar.i = D;
        cVar.a(0);
        cVar.f6598h = 2.5f;
        cVar.f6593b.setStrokeWidth(2.5f);
        invalidateSelf();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new hf.i(this, cVar));
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(B);
        valueAnimatorOfFloat.addListener(new b(this, cVar));
        this.f6614y = valueAnimatorOfFloat;
    }

    public static void d(float f, c cVar) {
        if (f <= 0.75f) {
            cVar.f6610u = cVar.i[cVar.f6599j];
            return;
        }
        float f10 = (f - 0.75f) / 0.25f;
        int[] iArr = cVar.i;
        int i = cVar.f6599j;
        int i10 = iArr[i];
        int i11 = iArr[(i + 1) % iArr.length];
        cVar.f6610u = ((((i10 >> 24) & 255) + ((int) ((((i11 >> 24) & 255) - r1) * f10))) << 24) | ((((i10 >> 16) & 255) + ((int) ((((i11 >> 16) & 255) - r3) * f10))) << 16) | ((((i10 >> 8) & 255) + ((int) ((((i11 >> 8) & 255) - r4) * f10))) << 8) | ((i10 & 255) + ((int) (f10 * ((i11 & 255) - r2))));
    }

    public final void a(float f, c cVar, boolean z10) {
        float interpolation;
        float interpolation2;
        if (this.A) {
            d(f, cVar);
            float fFloor = (float) (Math.floor(cVar.f6602m / 0.8f) + 1.0d);
            float f10 = cVar.f6600k;
            float f11 = cVar.f6601l;
            cVar.f6596e = (((f11 - 0.01f) - f10) * f) + f10;
            cVar.f = f11;
            float f12 = cVar.f6602m;
            cVar.f6597g = q4.a.h(fFloor, f12, f, f12);
            return;
        }
        if (f != 1.0f || z10) {
            float f13 = cVar.f6602m;
            q1.a aVar = C;
            if (f < 0.5f) {
                interpolation = cVar.f6600k;
                interpolation2 = (aVar.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float f14 = cVar.f6600k + 0.79f;
                interpolation = f14 - (((1.0f - aVar.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                interpolation2 = f14;
            }
            float f15 = (0.20999998f * f) + f13;
            float f16 = (f + this.f6615z) * 216.0f;
            cVar.f6596e = interpolation;
            cVar.f = interpolation2;
            cVar.f6597g = f15;
            this.f6612w = f16;
        }
    }

    public final void b(float f, float f10, float f11, float f12) {
        float f13 = this.f6613x.getDisplayMetrics().density;
        float f14 = f10 * f13;
        c cVar = this.f6611v;
        cVar.f6598h = f14;
        cVar.f6593b.setStrokeWidth(f14);
        cVar.f6606q = f * f13;
        cVar.a(0);
        cVar.f6607r = (int) (f11 * f13);
        cVar.f6608s = (int) (f12 * f13);
    }

    public final void c(int i) {
        if (i == 0) {
            b(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            b(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f6612w, bounds.exactCenterX(), bounds.exactCenterY());
        c cVar = this.f6611v;
        Paint paint = cVar.f6593b;
        RectF rectF = cVar.f6592a;
        float f = cVar.f6606q;
        float fMin = (cVar.f6598h / 2.0f) + f;
        if (f <= 0.0f) {
            fMin = (Math.min(bounds.width(), bounds.height()) / 2.0f) - Math.max((cVar.f6607r * cVar.f6605p) / 2.0f, cVar.f6598h / 2.0f);
        }
        rectF.set(bounds.centerX() - fMin, bounds.centerY() - fMin, bounds.centerX() + fMin, bounds.centerY() + fMin);
        float f10 = cVar.f6596e;
        float f11 = cVar.f6597g;
        float f12 = (f10 + f11) * 360.0f;
        float f13 = ((cVar.f + f11) * 360.0f) - f12;
        paint.setColor(cVar.f6610u);
        paint.setAlpha(cVar.f6609t);
        float f14 = cVar.f6598h / 2.0f;
        rectF.inset(f14, f14);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, cVar.f6595d);
        float f15 = -f14;
        rectF.inset(f15, f15);
        canvas.drawArc(rectF, f12, f13, false, paint);
        Paint paint2 = cVar.f6594c;
        if (cVar.f6603n) {
            Path path = cVar.f6604o;
            if (path == null) {
                Path path2 = new Path();
                cVar.f6604o = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float fMin2 = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f16 = (cVar.f6607r * cVar.f6605p) / 2.0f;
            cVar.f6604o.moveTo(0.0f, 0.0f);
            cVar.f6604o.lineTo(cVar.f6607r * cVar.f6605p, 0.0f);
            Path path3 = cVar.f6604o;
            float f17 = cVar.f6607r;
            float f18 = cVar.f6605p;
            path3.lineTo((f17 * f18) / 2.0f, cVar.f6608s * f18);
            cVar.f6604o.offset((rectF.centerX() + fMin2) - f16, (cVar.f6598h / 2.0f) + rectF.centerY());
            cVar.f6604o.close();
            paint2.setColor(cVar.f6610u);
            paint2.setAlpha(cVar.f6609t);
            canvas.save();
            canvas.rotate(f12 + f13, rectF.centerX(), rectF.centerY());
            canvas.drawPath(cVar.f6604o, paint2);
            canvas.restore();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f6611v.f6609t;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f6614y.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f6611v.f6609t = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f6611v.f6593b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f6614y.cancel();
        c cVar = this.f6611v;
        float f = cVar.f6596e;
        cVar.f6600k = f;
        float f10 = cVar.f;
        cVar.f6601l = f10;
        cVar.f6602m = cVar.f6597g;
        if (f10 != f) {
            this.A = true;
            this.f6614y.setDuration(666L);
            this.f6614y.start();
            return;
        }
        cVar.a(0);
        cVar.f6600k = 0.0f;
        cVar.f6601l = 0.0f;
        cVar.f6602m = 0.0f;
        cVar.f6596e = 0.0f;
        cVar.f = 0.0f;
        cVar.f6597g = 0.0f;
        this.f6614y.setDuration(1332L);
        this.f6614y.start();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f6614y.cancel();
        this.f6612w = 0.0f;
        c cVar = this.f6611v;
        if (cVar.f6603n) {
            cVar.f6603n = false;
        }
        cVar.a(0);
        cVar.f6600k = 0.0f;
        cVar.f6601l = 0.0f;
        cVar.f6602m = 0.0f;
        cVar.f6596e = 0.0f;
        cVar.f = 0.0f;
        cVar.f6597g = 0.0f;
        invalidateSelf();
    }
}
