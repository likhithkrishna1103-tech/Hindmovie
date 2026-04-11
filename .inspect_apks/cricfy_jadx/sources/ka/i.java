package ka;

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
import android.util.StateSet;
import g2.h1;
import java.util.BitSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class i extends Drawable implements w {

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final Paint f7331a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final h[] f7332b0;
    public boolean A;
    public boolean B;
    public final Matrix C;
    public final Path D;
    public final Path E;
    public final RectF F;
    public final RectF G;
    public final Region H;
    public final Region I;
    public final Paint J;
    public final Paint K;
    public final ja.a L;
    public final p6.d M;
    public final h1 N;
    public PorterDuffColorFilter O;
    public PorterDuffColorFilter P;
    public int Q;
    public final RectF R;
    public boolean S;
    public boolean T;
    public m U;
    public k1.g V;
    public final k1.f[] W;
    public float[] X;
    public float[] Y;
    public kb.d Z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p6.c f7333v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public g f7334w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final u[] f7335x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final u[] f7336y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final BitSet f7337z;

    static {
        Paint paint = new Paint(1);
        f7331a0 = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        f7332b0 = new h[4];
        int i = 0;
        while (true) {
            h[] hVarArr = f7332b0;
            if (i >= hVarArr.length) {
                return;
            }
            hVarArr[i] = new h(i);
            i++;
        }
    }

    public i() {
        this(new m());
    }

    public static float c(RectF rectF, m mVar, float[] fArr) {
        if (fArr == null) {
            if (mVar.f(rectF)) {
                return mVar.f7354e.a(rectF);
            }
            return -1.0f;
        }
        if (fArr.length > 1) {
            float f = fArr[0];
            for (int i = 1; i < fArr.length; i++) {
                if (fArr[i] != f) {
                    return -1.0f;
                }
            }
        }
        if (mVar.e()) {
            return fArr[0];
        }
        return -1.0f;
    }

    public final void b(RectF rectF, Path path) {
        g gVar = this.f7334w;
        this.N.b(gVar.f7316a, this.X, gVar.f7323j, rectF, this.M, path);
        if (this.f7334w.i != 1.0f) {
            Matrix matrix = this.C;
            matrix.reset();
            float f = this.f7334w.i;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.R, true);
    }

    public final int d(int i) {
        int i10;
        g gVar = this.f7334w;
        float f = gVar.f7327n + 0.0f + gVar.f7326m;
        z9.a aVar = gVar.f7318c;
        if (aVar == null || !aVar.f15336a || l0.b.d(i, 255) != aVar.f15339d) {
            return i;
        }
        float fMin = (aVar.f15340e <= 0.0f || f <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f / r4)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i);
        int iD = com.bumptech.glide.f.D(fMin, l0.b.d(i, 255), aVar.f15337b);
        if (fMin > 0.0f && (i10 = aVar.f15338c) != 0) {
            iD = l0.b.b(l0.b.d(i10, z9.a.f), iD);
        }
        return l0.b.d(iD, iAlpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint;
        PorterDuffColorFilter porterDuffColorFilter = this.O;
        Paint paint2 = this.J;
        paint2.setColorFilter(porterDuffColorFilter);
        int alpha = paint2.getAlpha();
        int i = this.f7334w.f7325l;
        paint2.setAlpha(((i + (i >>> 7)) * alpha) >>> 8);
        PorterDuffColorFilter porterDuffColorFilter2 = this.P;
        Paint paint3 = this.K;
        paint3.setColorFilter(porterDuffColorFilter2);
        paint3.setStrokeWidth(this.f7334w.f7324k);
        int alpha2 = paint3.getAlpha();
        int i10 = this.f7334w.f7325l;
        paint3.setAlpha(((i10 + (i10 >>> 7)) * alpha2) >>> 8);
        Paint.Style style = this.f7334w.f7330q;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            boolean z10 = this.A;
            paint = paint2;
            Path path = this.D;
            if (z10) {
                b(h(), path);
                this.A = false;
            }
            g gVar = this.f7334w;
            gVar.getClass();
            if (gVar.f7328o > 0 && !n() && !path.isConvex() && Build.VERSION.SDK_INT < 29) {
                canvas.save();
                double d10 = 0;
                canvas.translate((int) (Math.sin(Math.toRadians(d10)) * ((double) this.f7334w.f7329p)), (int) (Math.cos(Math.toRadians(d10)) * ((double) this.f7334w.f7329p)));
                if (this.S) {
                    RectF rectF = this.R;
                    int iWidth = (int) (rectF.width() - getBounds().width());
                    int iHeight = (int) (rectF.height() - getBounds().height());
                    if (iWidth < 0 || iHeight < 0) {
                        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.f7334w.f7328o * 2) + ((int) rectF.width()) + iWidth, (this.f7334w.f7328o * 2) + ((int) rectF.height()) + iHeight, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                    float f = (getBounds().left - this.f7334w.f7328o) - iWidth;
                    float f10 = (getBounds().top - this.f7334w.f7328o) - iHeight;
                    canvas2.translate(-f, -f10);
                    e(canvas2);
                    canvas.drawBitmap(bitmapCreateBitmap, f, f10, (Paint) null);
                    bitmapCreateBitmap.recycle();
                    canvas.restore();
                } else {
                    e(canvas);
                    canvas.restore();
                }
            }
            f(canvas, paint, path, this.f7334w.f7316a, this.X, h());
        } else {
            paint = paint2;
        }
        if (l()) {
            if (this.B) {
                m mVar = this.f7334w.f7316a;
                l lVarG = mVar.g();
                d dVar = mVar.f7354e;
                p6.c cVar = this.f7333v;
                lVarG.f7343e = cVar.e(dVar);
                lVarG.f = cVar.e(mVar.f);
                lVarG.f7345h = cVar.e(mVar.f7356h);
                lVarG.f7344g = cVar.e(mVar.f7355g);
                this.U = lVarG.a();
                float[] fArr = this.X;
                if (fArr != null) {
                    if (this.Y == null) {
                        this.Y = new float[fArr.length];
                    }
                    float fJ = j();
                    int i11 = 0;
                    while (true) {
                        float[] fArr2 = this.X;
                        if (i11 >= fArr2.length) {
                            break;
                        }
                        this.Y[i11] = Math.max(0.0f, fArr2[i11] - fJ);
                        i11++;
                    }
                } else {
                    this.Y = null;
                }
                m mVar2 = this.U;
                float[] fArr3 = this.Y;
                float f11 = this.f7334w.f7323j;
                RectF rectFH = h();
                RectF rectF2 = this.G;
                rectF2.set(rectFH);
                float fJ2 = j();
                rectF2.inset(fJ2, fJ2);
                this.N.b(mVar2, fArr3, f11, rectF2, null, this.E);
                this.B = false;
            }
            g(canvas);
        }
        paint.setAlpha(alpha);
        paint3.setAlpha(alpha2);
    }

    public final void e(Canvas canvas) {
        if (this.f7337z.cardinality() > 0) {
            Log.w("i", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i = this.f7334w.f7329p;
        Path path = this.D;
        ja.a aVar = this.L;
        if (i != 0) {
            canvas.drawPath(path, aVar.f6715a);
        }
        for (int i10 = 0; i10 < 4; i10++) {
            u uVar = this.f7335x[i10];
            int i11 = this.f7334w.f7328o;
            Matrix matrix = u.f7376b;
            uVar.a(matrix, aVar, i11, canvas);
            this.f7336y[i10].a(matrix, aVar, this.f7334w.f7328o, canvas);
        }
        if (this.S) {
            double d10 = 0;
            int iSin = (int) (Math.sin(Math.toRadians(d10)) * ((double) this.f7334w.f7329p));
            int iCos = (int) (Math.cos(Math.toRadians(d10)) * ((double) this.f7334w.f7329p));
            canvas.translate(-iSin, -iCos);
            canvas.drawPath(path, f7331a0);
            canvas.translate(iSin, iCos);
        }
    }

    public final void f(Canvas canvas, Paint paint, Path path, m mVar, float[] fArr, RectF rectF) {
        float fC = c(rectF, mVar, fArr);
        if (fC < 0.0f) {
            canvas.drawPath(path, paint);
        } else {
            float f = fC * this.f7334w.f7323j;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    public void g(Canvas canvas) {
        m mVar = this.U;
        float[] fArr = this.Y;
        RectF rectFH = h();
        RectF rectF = this.G;
        rectF.set(rectFH);
        float fJ = j();
        rectF.inset(fJ, fJ);
        f(canvas, this.K, this.E, mVar, fArr, rectF);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f7334w.f7325l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f7334w;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f7334w.getClass();
        RectF rectFH = h();
        if (rectFH.isEmpty()) {
            return;
        }
        float fC = c(rectFH, this.f7334w.f7316a, this.X);
        if (fC >= 0.0f) {
            outline.setRoundRect(getBounds(), fC * this.f7334w.f7323j);
            return;
        }
        boolean z10 = this.A;
        Path path = this.D;
        if (z10) {
            b(rectFH, path);
            this.A = false;
        }
        u8.a.C(outline, path);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f7334w.f7322h;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.H;
        region.set(bounds);
        RectF rectFH = h();
        Path path = this.D;
        b(rectFH, path);
        Region region2 = this.I;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final RectF h() {
        Rect bounds = getBounds();
        RectF rectF = this.F;
        rectF.set(bounds);
        return rectF;
    }

    public final float i() {
        float[] fArr = this.X;
        if (fArr != null) {
            return (((fArr[3] + fArr[2]) - fArr[1]) - fArr[0]) / 2.0f;
        }
        RectF rectFH = h();
        m mVar = this.f7334w.f7316a;
        h1 h1Var = this.N;
        h1Var.getClass();
        float fA = mVar.f7354e.a(rectFH);
        m mVar2 = this.f7334w.f7316a;
        h1Var.getClass();
        float fA2 = mVar2.f7356h.a(rectFH) + fA;
        m mVar3 = this.f7334w.f7316a;
        h1Var.getClass();
        float fA3 = fA2 - mVar3.f7355g.a(rectFH);
        m mVar4 = this.f7334w.f7316a;
        h1Var.getClass();
        return (fA3 - mVar4.f.a(rectFH)) / 2.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.A = true;
        this.B = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f7334w.f;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.f7334w.getClass();
        ColorStateList colorStateList2 = this.f7334w.f7320e;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f7334w.f7319d;
        if (colorStateList3 != null && colorStateList3.isStateful()) {
            return true;
        }
        d0 d0Var = this.f7334w.f7317b;
        return d0Var != null && d0Var.d();
    }

    public final float j() {
        if (l()) {
            return this.K.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public final float k() {
        float[] fArr = this.X;
        return fArr != null ? fArr[3] : this.f7334w.f7316a.f7354e.a(h());
    }

    public final boolean l() {
        Paint.Style style = this.f7334w.f7330q;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.K.getStrokeWidth() > 0.0f;
    }

    public final void m(Context context) {
        this.f7334w.f7318c = new z9.a(context);
        x();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f7334w = new g(this.f7334w);
        return this;
    }

    public final boolean n() {
        if (!this.f7334w.f7316a.f(h())) {
            float[] fArr = this.X;
            if (fArr != null) {
                if (fArr.length > 1) {
                    float f = fArr[0];
                    for (int i = 1; i < fArr.length; i++) {
                        if (fArr[i] != f) {
                            break;
                        }
                    }
                }
                if (this.f7334w.f7316a.e()) {
                }
            }
            return false;
        }
        return true;
    }

    public final void o(k1.g gVar) {
        if (this.V == gVar) {
            return;
        }
        this.V = gVar;
        int i = 0;
        while (true) {
            k1.f[] fVarArr = this.W;
            if (i >= fVarArr.length) {
                v(getState(), true);
                invalidateSelf();
                return;
            }
            if (fVarArr[i] == null) {
                fVarArr[i] = new k1.f(this, f7332b0[i]);
            }
            k1.f fVar = fVarArr[i];
            k1.g gVar2 = new k1.g();
            float f = (float) gVar.f6815b;
            if (f < 0.0f) {
                throw new IllegalArgumentException("Damping ratio must be non-negative");
            }
            gVar2.f6815b = f;
            gVar2.f6816c = false;
            double d10 = gVar.f6814a;
            float f10 = (float) (d10 * d10);
            if (f10 <= 0.0f) {
                throw new IllegalArgumentException("Spring stiffness constant must be positive.");
            }
            gVar2.f6814a = Math.sqrt(f10);
            gVar2.f6816c = false;
            fVar.f6811j = gVar2;
            i++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.A = true;
        this.B = true;
        super.onBoundsChange(rect);
        if (this.f7334w.f7317b != null && !rect.isEmpty()) {
            v(getState(), this.T);
        }
        this.T = rect.isEmpty();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.f7334w.f7317b != null) {
            v(iArr, false);
        }
        boolean z10 = u(iArr) || w();
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    public final void p(float f) {
        g gVar = this.f7334w;
        if (gVar.f7327n != f) {
            gVar.f7327n = f;
            x();
        }
    }

    public final void q(ColorStateList colorStateList) {
        g gVar = this.f7334w;
        if (gVar.f7319d != colorStateList) {
            gVar.f7319d = colorStateList;
            onStateChange(getState());
        }
    }

    public final void r(float f) {
        g gVar = this.f7334w;
        if (gVar.f7323j != f) {
            gVar.f7323j = f;
            this.A = true;
            this.B = true;
            invalidateSelf();
        }
    }

    public final void s() {
        this.L.a(-12303292);
        this.f7334w.getClass();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        g gVar = this.f7334w;
        if (gVar.f7325l != i) {
            gVar.f7325l = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f7334w.getClass();
        super.invalidateSelf();
    }

    @Override // ka.w
    public final void setShapeAppearanceModel(m mVar) {
        g gVar = this.f7334w;
        gVar.f7316a = mVar;
        gVar.f7317b = null;
        this.X = null;
        this.Y = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f7334w.f = colorStateList;
        w();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        g gVar = this.f7334w;
        if (gVar.f7321g != mode) {
            gVar.f7321g = mode;
            w();
            super.invalidateSelf();
        }
    }

    public final void t(d0 d0Var) {
        g gVar = this.f7334w;
        if (gVar.f7317b != d0Var) {
            gVar.f7317b = d0Var;
            v(getState(), true);
            invalidateSelf();
        }
    }

    public final boolean u(int[] iArr) {
        boolean z10;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f7334w.f7319d == null || color2 == (colorForState2 = this.f7334w.f7319d.getColorForState(iArr, (color2 = (paint2 = this.J).getColor())))) {
            z10 = false;
        } else {
            paint2.setColor(colorForState2);
            z10 = true;
        }
        if (this.f7334w.f7320e == null || color == (colorForState = this.f7334w.f7320e.getColorForState(iArr, (color = (paint = this.K).getColor())))) {
            return z10;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final void v(int[] iArr, boolean z10) {
        m mVarA;
        int i;
        RectF rectFH = h();
        if (this.f7334w.f7317b == null || rectFH.isEmpty()) {
            return;
        }
        boolean z11 = z10 | (this.V == null);
        if (this.X == null) {
            this.X = new float[4];
        }
        d0 d0Var = this.f7334w.f7317b;
        m[] mVarArr = d0Var.f7301d;
        int i10 = d0Var.f7298a;
        int[][] iArr2 = d0Var.f7300c;
        b0 b0Var = d0Var.f7304h;
        b0 b0Var2 = d0Var.f7303g;
        b0 b0Var3 = d0Var.f;
        b0 b0Var4 = d0Var.f7302e;
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                i11 = -1;
                break;
            } else if (StateSet.stateSetMatches(iArr2[i11], iArr)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int i12 = 0;
            while (true) {
                if (i12 >= i10) {
                    i = -1;
                    break;
                } else {
                    if (StateSet.stateSetMatches(iArr2[i12], iArr3)) {
                        i = i12;
                        break;
                    }
                    i12++;
                }
            }
            i11 = i;
        }
        if (b0Var4 == null && b0Var3 == null && b0Var2 == null && b0Var == null) {
            mVarA = mVarArr[i11];
        } else {
            l lVarG = mVarArr[i11].g();
            if (b0Var4 != null) {
                lVarG.f7343e = b0Var4.c(iArr);
            }
            if (b0Var3 != null) {
                lVarG.f = b0Var3.c(iArr);
            }
            if (b0Var2 != null) {
                lVarG.f7345h = b0Var2.c(iArr);
            }
            if (b0Var != null) {
                lVarG.f7344g = b0Var.c(iArr);
            }
            mVarA = lVarG.a();
        }
        int i13 = 0;
        while (i13 < 4) {
            this.N.getClass();
            float fA = (i13 != 1 ? i13 != 2 ? i13 != 3 ? mVarA.f : mVarA.f7354e : mVarA.f7356h : mVarA.f7355g).a(rectFH);
            if (z11) {
                this.X[i13] = fA;
            }
            k1.f[] fVarArr = this.W;
            k1.f fVar = fVarArr[i13];
            if (fVar != null) {
                fVar.a(fA);
                if (z11) {
                    fVarArr[i13].d();
                }
            }
            i13++;
        }
        if (z11) {
            invalidateSelf();
        }
    }

    public final boolean w() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.O;
        PorterDuffColorFilter porterDuffColorFilter3 = this.P;
        g gVar = this.f7334w;
        ColorStateList colorStateList = gVar.f;
        PorterDuff.Mode mode = gVar.f7321g;
        if (colorStateList == null || mode == null) {
            int color = this.J.getColor();
            int iD = d(color);
            this.Q = iD;
            porterDuffColorFilter = iD != color ? new PorterDuffColorFilter(iD, PorterDuff.Mode.SRC_IN) : null;
        } else {
            int iD2 = d(colorStateList.getColorForState(getState(), 0));
            this.Q = iD2;
            porterDuffColorFilter = new PorterDuffColorFilter(iD2, mode);
        }
        this.O = porterDuffColorFilter;
        this.f7334w.getClass();
        this.P = null;
        this.f7334w.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.O) && Objects.equals(porterDuffColorFilter3, this.P)) ? false : true;
    }

    public final void x() {
        g gVar = this.f7334w;
        float f = gVar.f7327n + 0.0f;
        gVar.f7328o = (int) Math.ceil(0.75f * f);
        this.f7334w.f7329p = (int) Math.ceil(f * 0.25f);
        w();
        super.invalidateSelf();
    }

    public i(Context context, AttributeSet attributeSet, int i, int i10) {
        this(m.c(context, attributeSet, i, i10).a());
    }

    public i(m mVar) {
        this(new g(mVar));
    }

    public i(g gVar) {
        h1 h1Var;
        this.f7333v = new p6.c(26, this);
        this.f7335x = new u[4];
        this.f7336y = new u[4];
        this.f7337z = new BitSet(8);
        this.C = new Matrix();
        this.D = new Path();
        this.E = new Path();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new Region();
        this.I = new Region();
        Paint paint = new Paint(1);
        this.J = paint;
        Paint paint2 = new Paint(1);
        this.K = paint2;
        this.L = new ja.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            h1Var = n.f7360a;
        } else {
            h1Var = new h1();
        }
        this.N = h1Var;
        this.R = new RectF();
        this.S = true;
        this.T = true;
        this.W = new k1.f[4];
        this.f7334w = gVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        w();
        u(getState());
        this.M = new p6.d(26, this);
    }
}
