package e5;

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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends Drawable implements Animatable {
    public static final LinearInterpolator A = new LinearInterpolator();
    public static final k1.a B = new k1.a(1);
    public static final int[] C = {-16777216};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d f4453u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f4454v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Resources f4455w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ValueAnimator f4456x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f4457y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f4458z;

    public e(Context context) {
        context.getClass();
        this.f4455w = context.getResources();
        d dVar = new d();
        this.f4453u = dVar;
        dVar.i = C;
        dVar.a(0);
        dVar.f4440h = 2.5f;
        dVar.f4435b.setStrokeWidth(2.5f);
        invalidateSelf();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new b(this, dVar));
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(A);
        valueAnimatorOfFloat.addListener(new c(this, dVar));
        this.f4456x = valueAnimatorOfFloat;
    }

    public static void d(float f, d dVar) {
        if (f <= 0.75f) {
            dVar.f4452u = dVar.i[dVar.f4441j];
            return;
        }
        float f4 = (f - 0.75f) / 0.25f;
        int[] iArr = dVar.i;
        int i = dVar.f4441j;
        int i10 = iArr[i];
        int i11 = iArr[(i + 1) % iArr.length];
        dVar.f4452u = ((((i10 >> 24) & 255) + ((int) ((((i11 >> 24) & 255) - r1) * f4))) << 24) | ((((i10 >> 16) & 255) + ((int) ((((i11 >> 16) & 255) - r3) * f4))) << 16) | ((((i10 >> 8) & 255) + ((int) ((((i11 >> 8) & 255) - r4) * f4))) << 8) | ((i10 & 255) + ((int) (f4 * ((i11 & 255) - r2))));
    }

    public final void a(float f, d dVar, boolean z2) {
        float interpolation;
        float interpolation2;
        if (this.f4458z) {
            d(f, dVar);
            float fFloor = (float) (Math.floor(dVar.f4444m / 0.8f) + 1.0d);
            float f4 = dVar.f4442k;
            float f10 = dVar.f4443l;
            dVar.f4438e = (((f10 - 0.01f) - f4) * f) + f4;
            dVar.f = f10;
            float f11 = dVar.f4444m;
            dVar.f4439g = e6.j.g(fFloor, f11, f, f11);
            return;
        }
        if (f != 1.0f || z2) {
            float f12 = dVar.f4444m;
            k1.a aVar = B;
            if (f < 0.5f) {
                interpolation = dVar.f4442k;
                interpolation2 = (aVar.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float f13 = dVar.f4442k + 0.79f;
                interpolation = f13 - (((1.0f - aVar.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                interpolation2 = f13;
            }
            float f14 = (0.20999998f * f) + f12;
            float f15 = (f + this.f4457y) * 216.0f;
            dVar.f4438e = interpolation;
            dVar.f = interpolation2;
            dVar.f4439g = f14;
            this.f4454v = f15;
        }
    }

    public final void b(float f, float f4, float f10, float f11) {
        float f12 = this.f4455w.getDisplayMetrics().density;
        float f13 = f4 * f12;
        d dVar = this.f4453u;
        dVar.f4440h = f13;
        dVar.f4435b.setStrokeWidth(f13);
        dVar.f4448q = f * f12;
        dVar.a(0);
        dVar.f4449r = (int) (f10 * f12);
        dVar.f4450s = (int) (f11 * f12);
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
        canvas.rotate(this.f4454v, bounds.exactCenterX(), bounds.exactCenterY());
        d dVar = this.f4453u;
        Paint paint = dVar.f4435b;
        RectF rectF = dVar.f4434a;
        float f = dVar.f4448q;
        float fMin = (dVar.f4440h / 2.0f) + f;
        if (f <= 0.0f) {
            fMin = (Math.min(bounds.width(), bounds.height()) / 2.0f) - Math.max((dVar.f4449r * dVar.f4447p) / 2.0f, dVar.f4440h / 2.0f);
        }
        rectF.set(bounds.centerX() - fMin, bounds.centerY() - fMin, bounds.centerX() + fMin, bounds.centerY() + fMin);
        float f4 = dVar.f4438e;
        float f10 = dVar.f4439g;
        float f11 = (f4 + f10) * 360.0f;
        float f12 = ((dVar.f + f10) * 360.0f) - f11;
        paint.setColor(dVar.f4452u);
        paint.setAlpha(dVar.f4451t);
        float f13 = dVar.f4440h / 2.0f;
        rectF.inset(f13, f13);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, dVar.f4437d);
        float f14 = -f13;
        rectF.inset(f14, f14);
        canvas.drawArc(rectF, f11, f12, false, paint);
        Paint paint2 = dVar.f4436c;
        if (dVar.f4445n) {
            Path path = dVar.f4446o;
            if (path == null) {
                Path path2 = new Path();
                dVar.f4446o = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float fMin2 = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f15 = (dVar.f4449r * dVar.f4447p) / 2.0f;
            dVar.f4446o.moveTo(0.0f, 0.0f);
            dVar.f4446o.lineTo(dVar.f4449r * dVar.f4447p, 0.0f);
            Path path3 = dVar.f4446o;
            float f16 = dVar.f4449r;
            float f17 = dVar.f4447p;
            path3.lineTo((f16 * f17) / 2.0f, dVar.f4450s * f17);
            dVar.f4446o.offset((rectF.centerX() + fMin2) - f15, (dVar.f4440h / 2.0f) + rectF.centerY());
            dVar.f4446o.close();
            paint2.setColor(dVar.f4452u);
            paint2.setAlpha(dVar.f4451t);
            canvas.save();
            canvas.rotate(f11 + f12, rectF.centerX(), rectF.centerY());
            canvas.drawPath(dVar.f4446o, paint2);
            canvas.restore();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f4453u.f4451t;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f4456x.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f4453u.f4451t = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f4453u.f4435b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f4456x.cancel();
        d dVar = this.f4453u;
        float f = dVar.f4438e;
        dVar.f4442k = f;
        float f4 = dVar.f;
        dVar.f4443l = f4;
        dVar.f4444m = dVar.f4439g;
        if (f4 != f) {
            this.f4458z = true;
            this.f4456x.setDuration(666L);
            this.f4456x.start();
            return;
        }
        dVar.a(0);
        dVar.f4442k = 0.0f;
        dVar.f4443l = 0.0f;
        dVar.f4444m = 0.0f;
        dVar.f4438e = 0.0f;
        dVar.f = 0.0f;
        dVar.f4439g = 0.0f;
        this.f4456x.setDuration(1332L);
        this.f4456x.start();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f4456x.cancel();
        this.f4454v = 0.0f;
        d dVar = this.f4453u;
        if (dVar.f4445n) {
            dVar.f4445n = false;
        }
        dVar.a(0);
        dVar.f4442k = 0.0f;
        dVar.f4443l = 0.0f;
        dVar.f4444m = 0.0f;
        dVar.f4438e = 0.0f;
        dVar.f = 0.0f;
        dVar.f4439g = 0.0f;
        invalidateSelf();
    }
}
