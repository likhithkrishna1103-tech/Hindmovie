package q9;

import a2.t1;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class g extends Drawable implements u {
    public static final Paint R;
    public final Path A;
    public final Path B;
    public final RectF C;
    public final RectF D;
    public final Region E;
    public final Region F;
    public k G;
    public final Paint H;
    public final Paint I;
    public final p9.a J;
    public final o4.c K;
    public final t1 L;
    public PorterDuffColorFilter M;
    public PorterDuffColorFilter N;
    public int O;
    public final RectF P;
    public boolean Q;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public f f11105u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final s[] f11106v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final s[] f11107w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final BitSet f11108x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f11109y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Matrix f11110z;

    static {
        Paint paint = new Paint(1);
        R = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public g() {
        this(new k());
    }

    public final void b(RectF rectF, Path path) {
        f fVar = this.f11105u;
        this.L.b(fVar.f11090a, fVar.i, rectF, this.K, path);
        if (this.f11105u.f11096h != 1.0f) {
            Matrix matrix = this.f11110z;
            matrix.reset();
            float f = this.f11105u.f11096h;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.P, true);
    }

    public final int c(int i) {
        int i10;
        f fVar = this.f11105u;
        float f = fVar.f11100m + 0.0f + fVar.f11099l;
        f9.a aVar = fVar.f11091b;
        if (aVar == null || !aVar.f4811a || i0.b.d(i, 255) != aVar.f4814d) {
            return i;
        }
        float fMin = (aVar.f4815e <= 0.0f || f <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f / r4)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i);
        int iR = z7.a.r(fMin, i0.b.d(i, 255), aVar.f4812b);
        if (fMin > 0.0f && (i10 = aVar.f4813c) != 0) {
            iR = i0.b.b(i0.b.d(i10, f9.a.f), iR);
        }
        return i0.b.d(iR, iAlpha);
    }

    public final void d(Canvas canvas) {
        if (this.f11108x.cardinality() > 0) {
            Log.w("g", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i = this.f11105u.f11102o;
        Path path = this.A;
        p9.a aVar = this.J;
        if (i != 0) {
            canvas.drawPath(path, aVar.f10290a);
        }
        for (int i10 = 0; i10 < 4; i10++) {
            s sVar = this.f11106v[i10];
            int i11 = this.f11105u.f11101n;
            Matrix matrix = s.f11149b;
            sVar.a(matrix, aVar, i11, canvas);
            this.f11107w[i10].a(matrix, aVar, this.f11105u.f11101n, canvas);
        }
        if (this.Q) {
            int iSin = (int) (Math.sin(Math.toRadians(r0.f11103p)) * ((double) this.f11105u.f11102o));
            int iCos = (int) (Math.cos(Math.toRadians(r2.f11103p)) * ((double) this.f11105u.f11102o));
            canvas.translate(-iSin, -iCos);
            canvas.drawPath(path, R);
            canvas.translate(iSin, iCos);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        PorterDuffColorFilter porterDuffColorFilter = this.M;
        Paint paint = this.H;
        paint.setColorFilter(porterDuffColorFilter);
        int alpha = paint.getAlpha();
        int i = this.f11105u.f11098k;
        paint.setAlpha(((i + (i >>> 7)) * alpha) >>> 8);
        PorterDuffColorFilter porterDuffColorFilter2 = this.N;
        Paint paint2 = this.I;
        paint2.setColorFilter(porterDuffColorFilter2);
        paint2.setStrokeWidth(this.f11105u.f11097j);
        int alpha2 = paint2.getAlpha();
        int i10 = this.f11105u.f11098k;
        paint2.setAlpha(((i10 + (i10 >>> 7)) * alpha2) >>> 8);
        boolean z2 = this.f11109y;
        Path path = this.A;
        if (z2) {
            float f = -(i() ? paint2.getStrokeWidth() / 2.0f : 0.0f);
            k kVar = this.f11105u.f11090a;
            j jVarF = kVar.f();
            c bVar = kVar.f11127e;
            if (!(bVar instanceof h)) {
                bVar = new b(f, bVar);
            }
            jVarF.f11116e = bVar;
            c bVar2 = kVar.f;
            if (!(bVar2 instanceof h)) {
                bVar2 = new b(f, bVar2);
            }
            jVarF.f = bVar2;
            c bVar3 = kVar.f11129h;
            if (!(bVar3 instanceof h)) {
                bVar3 = new b(f, bVar3);
            }
            jVarF.f11118h = bVar3;
            c bVar4 = kVar.f11128g;
            if (!(bVar4 instanceof h)) {
                bVar4 = new b(f, bVar4);
            }
            jVarF.f11117g = bVar4;
            k kVarA = jVarF.a();
            this.G = kVarA;
            float f4 = this.f11105u.i;
            RectF rectFG = g();
            RectF rectF = this.D;
            rectF.set(rectFG);
            float strokeWidth = i() ? paint2.getStrokeWidth() / 2.0f : 0.0f;
            rectF.inset(strokeWidth, strokeWidth);
            this.L.b(kVarA, f4, rectF, null, this.B);
            b(g(), path);
            this.f11109y = false;
        }
        f fVar = this.f11105u;
        fVar.getClass();
        if (fVar.f11101n > 0) {
            int i11 = Build.VERSION.SDK_INT;
            if (!this.f11105u.f11090a.e(g()) && !path.isConvex() && i11 < 29) {
                canvas.save();
                int iSin = (int) (Math.sin(Math.toRadians(r4.f11103p)) * ((double) this.f11105u.f11102o));
                f fVar2 = this.f11105u;
                canvas.translate(iSin, (int) (Math.cos(Math.toRadians(fVar2.f11103p)) * ((double) fVar2.f11102o)));
                if (this.Q) {
                    RectF rectF2 = this.P;
                    int iWidth = (int) (rectF2.width() - getBounds().width());
                    int iHeight = (int) (rectF2.height() - getBounds().height());
                    if (iWidth < 0 || iHeight < 0) {
                        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.f11105u.f11101n * 2) + ((int) rectF2.width()) + iWidth, (this.f11105u.f11101n * 2) + ((int) rectF2.height()) + iHeight, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                    float f10 = (getBounds().left - this.f11105u.f11101n) - iWidth;
                    float f11 = (getBounds().top - this.f11105u.f11101n) - iHeight;
                    canvas2.translate(-f10, -f11);
                    d(canvas2);
                    canvas.drawBitmap(bitmapCreateBitmap, f10, f11, (Paint) null);
                    bitmapCreateBitmap.recycle();
                    canvas.restore();
                } else {
                    d(canvas);
                    canvas.restore();
                }
            }
        }
        f fVar3 = this.f11105u;
        Paint.Style style = fVar3.f11104q;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            e(canvas, paint, path, fVar3.f11090a, g());
        }
        if (i()) {
            f(canvas);
        }
        paint.setAlpha(alpha);
        paint2.setAlpha(alpha2);
    }

    public final void e(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (!kVar.e(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = kVar.f.a(rectF) * this.f11105u.i;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    public void f(Canvas canvas) {
        k kVar = this.G;
        RectF rectFG = g();
        RectF rectF = this.D;
        rectF.set(rectFG);
        boolean zI = i();
        Paint paint = this.I;
        float strokeWidth = zI ? paint.getStrokeWidth() / 2.0f : 0.0f;
        rectF.inset(strokeWidth, strokeWidth);
        e(canvas, paint, this.B, kVar, rectF);
    }

    public final RectF g() {
        Rect bounds = getBounds();
        RectF rectF = this.C;
        rectF.set(bounds);
        return rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f11105u.f11098k;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f11105u;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f11105u.getClass();
        if (this.f11105u.f11090a.e(g())) {
            outline.setRoundRect(getBounds(), h() * this.f11105u.i);
        } else {
            RectF rectFG = g();
            Path path = this.A;
            b(rectFG, path);
            a.a.L(outline, path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f11105u.f11095g;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.E;
        region.set(bounds);
        RectF rectFG = g();
        Path path = this.A;
        b(rectFG, path);
        Region region2 = this.F;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final float h() {
        return this.f11105u.f11090a.f11127e.a(g());
    }

    public final boolean i() {
        Paint.Style style = this.f11105u.f11104q;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.I.getStrokeWidth() > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f11109y = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f11105u.f11094e;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.f11105u.getClass();
        ColorStateList colorStateList2 = this.f11105u.f11093d;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f11105u.f11092c;
        return colorStateList3 != null && colorStateList3.isStateful();
    }

    public final void j(Context context) {
        this.f11105u.f11091b = new f9.a(context);
        q();
    }

    public final void k(float f) {
        f fVar = this.f11105u;
        if (fVar.f11100m != f) {
            fVar.f11100m = f;
            q();
        }
    }

    public final void l(ColorStateList colorStateList) {
        f fVar = this.f11105u;
        if (fVar.f11092c != colorStateList) {
            fVar.f11092c = colorStateList;
            onStateChange(getState());
        }
    }

    public final void m(float f) {
        f fVar = this.f11105u;
        if (fVar.i != f) {
            fVar.i = f;
            this.f11109y = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f11105u = new f(this.f11105u);
        return this;
    }

    public final void n() {
        this.J.a(-12303292);
        this.f11105u.getClass();
        super.invalidateSelf();
    }

    public final boolean o(int[] iArr) {
        boolean z2;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f11105u.f11092c == null || color2 == (colorForState2 = this.f11105u.f11092c.getColorForState(iArr, (color2 = (paint2 = this.H).getColor())))) {
            z2 = false;
        } else {
            paint2.setColor(colorForState2);
            z2 = true;
        }
        if (this.f11105u.f11093d == null || color == (colorForState = this.f11105u.f11093d.getColorForState(iArr, (color = (paint = this.I).getColor())))) {
            return z2;
        }
        paint.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f11109y = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, j9.z
    public boolean onStateChange(int[] iArr) {
        boolean z2 = o(iArr) || p();
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    public final boolean p() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.M;
        PorterDuffColorFilter porterDuffColorFilter3 = this.N;
        f fVar = this.f11105u;
        ColorStateList colorStateList = fVar.f11094e;
        PorterDuff.Mode mode = fVar.f;
        if (colorStateList == null || mode == null) {
            int color = this.H.getColor();
            int iC = c(color);
            this.O = iC;
            porterDuffColorFilter = iC != color ? new PorterDuffColorFilter(iC, PorterDuff.Mode.SRC_IN) : null;
        } else {
            int iC2 = c(colorStateList.getColorForState(getState(), 0));
            this.O = iC2;
            porterDuffColorFilter = new PorterDuffColorFilter(iC2, mode);
        }
        this.M = porterDuffColorFilter;
        this.f11105u.getClass();
        this.N = null;
        this.f11105u.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.M) && Objects.equals(porterDuffColorFilter3, this.N)) ? false : true;
    }

    public final void q() {
        f fVar = this.f11105u;
        float f = fVar.f11100m + 0.0f;
        fVar.f11101n = (int) Math.ceil(0.75f * f);
        this.f11105u.f11102o = (int) Math.ceil(f * 0.25f);
        p();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        f fVar = this.f11105u;
        if (fVar.f11098k != i) {
            fVar.f11098k = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f11105u.getClass();
        super.invalidateSelf();
    }

    @Override // q9.u
    public final void setShapeAppearanceModel(k kVar) {
        this.f11105u.f11090a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f11105u.f11094e = colorStateList;
        p();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        f fVar = this.f11105u;
        if (fVar.f != mode) {
            fVar.f = mode;
            p();
            super.invalidateSelf();
        }
    }

    public g(Context context, AttributeSet attributeSet, int i, int i10) {
        this(k.c(context, attributeSet, i, i10).a());
    }

    public g(k kVar) {
        this(new f(kVar));
    }

    public g(f fVar) {
        t1 t1Var;
        this.f11106v = new s[4];
        this.f11107w = new s[4];
        this.f11108x = new BitSet(8);
        this.f11110z = new Matrix();
        this.A = new Path();
        this.B = new Path();
        this.C = new RectF();
        this.D = new RectF();
        this.E = new Region();
        this.F = new Region();
        Paint paint = new Paint(1);
        this.H = paint;
        Paint paint2 = new Paint(1);
        this.I = paint2;
        this.J = new p9.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            t1Var = l.f11133a;
        } else {
            t1Var = new t1();
        }
        this.L = t1Var;
        this.P = new RectF();
        this.Q = true;
        this.f11105u = fVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        p();
        o(getState());
        this.K = new o4.c(this);
    }
}
