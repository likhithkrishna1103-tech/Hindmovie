package ba;

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
import g2.h1;
import ka.m;
import ka.n;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends Drawable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f1843b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f1848h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1849j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1850k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1851l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1852m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m f1854o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ColorStateList f1855p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h1 f1842a = n.f7360a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f1844c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f1845d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f1846e = new RectF();
    public final RectF f = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f1847g = new a(this);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1853n = true;

    public b(m mVar) {
        this.f1854o = mVar;
        Paint paint = new Paint(1);
        this.f1843b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z10 = this.f1853n;
        Rect rect = this.f1845d;
        Paint paint = this.f1843b;
        if (z10) {
            copyBounds(rect);
            float fHeight = this.f1848h / rect.height();
            paint.setShader(new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{l0.b.b(this.i, this.f1852m), l0.b.b(this.f1849j, this.f1852m), l0.b.b(l0.b.d(this.f1849j, 0), this.f1852m), l0.b.b(l0.b.d(this.f1851l, 0), this.f1852m), l0.b.b(this.f1851l, this.f1852m), l0.b.b(this.f1850k, this.f1852m)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP));
            this.f1853n = false;
        }
        float strokeWidth = paint.getStrokeWidth() / 2.0f;
        copyBounds(rect);
        RectF rectF = this.f1846e;
        rectF.set(rect);
        ka.d dVar = this.f1854o.f7354e;
        Rect bounds = getBounds();
        RectF rectF2 = this.f;
        rectF2.set(bounds);
        float fMin = Math.min(dVar.a(rectF2), rectF.width() / 2.0f);
        m mVar = this.f1854o;
        rectF2.set(getBounds());
        if (mVar.f(rectF2)) {
            rectF.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(rectF, fMin, fMin, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f1847g;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f1848h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        m mVar = this.f1854o;
        Rect bounds = getBounds();
        RectF rectF = this.f;
        rectF.set(bounds);
        if (mVar.f(rectF)) {
            ka.d dVar = this.f1854o.f7354e;
            rectF.set(getBounds());
            outline.setRoundRect(getBounds(), dVar.a(rectF));
            return;
        }
        Rect rect = this.f1845d;
        copyBounds(rect);
        RectF rectF2 = this.f1846e;
        rectF2.set(rect);
        m mVar2 = this.f1854o;
        h1 h1Var = this.f1842a;
        Path path = this.f1844c;
        h1Var.b(mVar2, null, 1.0f, rectF2, null, path);
        u8.a.C(outline, path);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        m mVar = this.f1854o;
        Rect bounds = getBounds();
        RectF rectF = this.f;
        rectF.set(bounds);
        if (!mVar.f(rectF)) {
            return true;
        }
        int iRound = Math.round(this.f1848h);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList = this.f1855p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f1853n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f1855p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f1852m)) != this.f1852m) {
            this.f1853n = true;
            this.f1852m = colorForState;
        }
        if (this.f1853n) {
            invalidateSelf();
        }
        return this.f1853n;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f1843b.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f1843b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
