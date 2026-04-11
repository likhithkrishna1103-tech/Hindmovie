package h9;

import a2.t1;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import q9.l;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f5962b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f5967h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5968j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5969k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5970l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5971m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public q9.k f5973o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ColorStateList f5974p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1 f5961a = l.f11133a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f5963c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f5964d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f5965e = new RectF();
    public final RectF f = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h5.e f5966g = new h5.e(this);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5972n = true;

    public a(q9.k kVar) {
        this.f5973o = kVar;
        Paint paint = new Paint(1);
        this.f5962b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z2 = this.f5972n;
        Rect rect = this.f5964d;
        Paint paint = this.f5962b;
        if (z2) {
            copyBounds(rect);
            float fHeight = this.f5967h / rect.height();
            paint.setShader(new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{i0.b.b(this.i, this.f5971m), i0.b.b(this.f5968j, this.f5971m), i0.b.b(i0.b.d(this.f5968j, 0), this.f5971m), i0.b.b(i0.b.d(this.f5970l, 0), this.f5971m), i0.b.b(this.f5970l, this.f5971m), i0.b.b(this.f5969k, this.f5971m)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP));
            this.f5972n = false;
        }
        float strokeWidth = paint.getStrokeWidth() / 2.0f;
        copyBounds(rect);
        RectF rectF = this.f5965e;
        rectF.set(rect);
        q9.c cVar = this.f5973o.f11127e;
        Rect bounds = getBounds();
        RectF rectF2 = this.f;
        rectF2.set(bounds);
        float fMin = Math.min(cVar.a(rectF2), rectF.width() / 2.0f);
        q9.k kVar = this.f5973o;
        rectF2.set(getBounds());
        if (kVar.e(rectF2)) {
            rectF.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(rectF, fMin, fMin, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f5966g;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f5967h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        q9.k kVar = this.f5973o;
        Rect bounds = getBounds();
        RectF rectF = this.f;
        rectF.set(bounds);
        if (kVar.e(rectF)) {
            q9.c cVar = this.f5973o.f11127e;
            rectF.set(getBounds());
            outline.setRoundRect(getBounds(), cVar.a(rectF));
            return;
        }
        Rect rect = this.f5964d;
        copyBounds(rect);
        RectF rectF2 = this.f5965e;
        rectF2.set(rect);
        q9.k kVar2 = this.f5973o;
        t1 t1Var = this.f5961a;
        Path path = this.f5963c;
        t1Var.b(kVar2, 1.0f, rectF2, null, path);
        a.a.L(outline, path);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        q9.k kVar = this.f5973o;
        Rect bounds = getBounds();
        RectF rectF = this.f;
        rectF.set(bounds);
        if (!kVar.e(rectF)) {
            return true;
        }
        int iRound = Math.round(this.f5967h);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList = this.f5974p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f5972n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f5974p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f5971m)) != this.f5971m) {
            this.f5972n = true;
            this.f5971m = colorForState;
        }
        if (this.f5972n) {
            invalidateSelf();
        }
        return this.f5972n;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f5962b.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f5962b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
