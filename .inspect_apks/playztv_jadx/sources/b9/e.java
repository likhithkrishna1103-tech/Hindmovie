package b9;

import a2.t1;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.chip.Chip;
import j9.a0;
import j9.f0;
import j9.z;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import q9.j;
import q9.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends q9.g implements Drawable.Callback, z {
    public static final int[] a1 = {R.attr.state_enabled};

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final ShapeDrawable f1948b1 = new ShapeDrawable(new OvalShape());
    public final Paint A0;
    public final Paint.FontMetrics B0;
    public final RectF C0;
    public final PointF D0;
    public final Path E0;
    public final a0 F0;
    public int G0;
    public int H0;
    public int I0;
    public int J0;
    public int K0;
    public int L0;
    public boolean M0;
    public int N0;
    public int O0;
    public ColorFilter P0;
    public PorterDuffColorFilter Q0;
    public ColorStateList R0;
    public ColorStateList S;
    public PorterDuff.Mode S0;
    public ColorStateList T;
    public int[] T0;
    public float U;
    public ColorStateList U0;
    public float V;
    public WeakReference V0;
    public ColorStateList W;
    public TextUtils.TruncateAt W0;
    public float X;
    public boolean X0;
    public ColorStateList Y;
    public int Y0;
    public CharSequence Z;
    public boolean Z0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f1949a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public Drawable f1950b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public ColorStateList f1951c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f1952d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f1953e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f1954f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public Drawable f1955g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public RippleDrawable f1956h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public ColorStateList f1957i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public float f1958j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public SpannableStringBuilder f1959k0;
    public boolean l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f1960m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public Drawable f1961n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public ColorStateList f1962o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public q8.d f1963p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public q8.d f1964q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public float f1965r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public float f1966s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public float f1967t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public float f1968u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public float f1969v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public float f1970w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public float f1971x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public float f1972y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final Context f1973z0;

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, Chip.R);
        this.V = -1.0f;
        this.A0 = new Paint(1);
        this.B0 = new Paint.FontMetrics();
        this.C0 = new RectF();
        this.D0 = new PointF();
        this.E0 = new Path();
        this.O0 = 255;
        this.S0 = PorterDuff.Mode.SRC_IN;
        this.V0 = new WeakReference(null);
        j(context);
        this.f1973z0 = context;
        a0 a0Var = new a0(this);
        this.F0 = a0Var;
        this.Z = "";
        a0Var.f6836a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = a1;
        setState(iArr);
        if (!Arrays.equals(this.T0, iArr)) {
            this.T0 = iArr;
            if (W()) {
                z(getState(), iArr);
            }
        }
        this.X0 = true;
        int[] iArr2 = o9.a.f9444a;
        f1948b1.setTint(-1);
    }

    public static void X(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static boolean w(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean x(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A(boolean z2) {
        if (this.l0 != z2) {
            this.l0 = z2;
            float fT = t();
            if (!z2 && this.M0) {
                this.M0 = false;
            }
            float fT2 = t();
            invalidateSelf();
            if (fT != fT2) {
                y();
            }
        }
    }

    public final void B(Drawable drawable) {
        if (this.f1961n0 != drawable) {
            float fT = t();
            this.f1961n0 = drawable;
            float fT2 = t();
            X(this.f1961n0);
            r(this.f1961n0);
            invalidateSelf();
            if (fT != fT2) {
                y();
            }
        }
    }

    public final void C(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f1962o0 != colorStateList) {
            this.f1962o0 = colorStateList;
            if (this.f1960m0 && (drawable = this.f1961n0) != null && this.l0) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void D(boolean z2) {
        if (this.f1960m0 != z2) {
            boolean zU = U();
            this.f1960m0 = z2;
            boolean zU2 = U();
            if (zU != zU2) {
                if (zU2) {
                    r(this.f1961n0);
                } else {
                    X(this.f1961n0);
                }
                invalidateSelf();
                y();
            }
        }
    }

    public final void E(float f) {
        if (this.V != f) {
            this.V = f;
            j jVarF = this.f11105u.f11090a.f();
            jVarF.b(f);
            setShapeAppearanceModel(jVarF.a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final void F(Drawable drawable) {
        ?? r02;
        Object obj = this.f1950b0;
        if (obj != null) {
            boolean z2 = obj instanceof j0.c;
            r02 = obj;
            if (z2) {
                r02 = 0;
            }
        } else {
            r02 = 0;
        }
        if (r02 != drawable) {
            float fT = t();
            this.f1950b0 = drawable != null ? drawable.mutate() : null;
            float fT2 = t();
            X(r02);
            if (V()) {
                r(this.f1950b0);
            }
            invalidateSelf();
            if (fT != fT2) {
                y();
            }
        }
    }

    public final void G(float f) {
        if (this.f1952d0 != f) {
            float fT = t();
            this.f1952d0 = f;
            float fT2 = t();
            invalidateSelf();
            if (fT != fT2) {
                y();
            }
        }
    }

    public final void H(ColorStateList colorStateList) {
        this.f1953e0 = true;
        if (this.f1951c0 != colorStateList) {
            this.f1951c0 = colorStateList;
            if (V()) {
                this.f1950b0.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void I(boolean z2) {
        if (this.f1949a0 != z2) {
            boolean zV = V();
            this.f1949a0 = z2;
            boolean zV2 = V();
            if (zV != zV2) {
                if (zV2) {
                    r(this.f1950b0);
                } else {
                    X(this.f1950b0);
                }
                invalidateSelf();
                y();
            }
        }
    }

    public final void J(ColorStateList colorStateList) {
        if (this.W != colorStateList) {
            this.W = colorStateList;
            if (this.Z0) {
                q9.f fVar = this.f11105u;
                if (fVar.f11093d != colorStateList) {
                    fVar.f11093d = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void K(float f) {
        if (this.X != f) {
            this.X = f;
            this.A0.setStrokeWidth(f);
            if (this.Z0) {
                this.f11105u.f11097j = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public final void L(Drawable drawable) {
        ?? r02;
        Object obj = this.f1955g0;
        if (obj != null) {
            boolean z2 = obj instanceof j0.c;
            r02 = obj;
            if (z2) {
                r02 = 0;
            }
        } else {
            r02 = 0;
        }
        if (r02 != drawable) {
            float fU = u();
            this.f1955g0 = drawable != null ? drawable.mutate() : null;
            int[] iArr = o9.a.f9444a;
            this.f1956h0 = new RippleDrawable(o9.a.c(this.Y), this.f1955g0, f1948b1);
            float fU2 = u();
            X(r02);
            if (W()) {
                r(this.f1955g0);
            }
            invalidateSelf();
            if (fU != fU2) {
                y();
            }
        }
    }

    public final void M(float f) {
        if (this.f1971x0 != f) {
            this.f1971x0 = f;
            invalidateSelf();
            if (W()) {
                y();
            }
        }
    }

    public final void N(float f) {
        if (this.f1958j0 != f) {
            this.f1958j0 = f;
            invalidateSelf();
            if (W()) {
                y();
            }
        }
    }

    public final void O(float f) {
        if (this.f1970w0 != f) {
            this.f1970w0 = f;
            invalidateSelf();
            if (W()) {
                y();
            }
        }
    }

    public final void P(ColorStateList colorStateList) {
        if (this.f1957i0 != colorStateList) {
            this.f1957i0 = colorStateList;
            if (W()) {
                this.f1955g0.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void Q(boolean z2) {
        if (this.f1954f0 != z2) {
            boolean zW = W();
            this.f1954f0 = z2;
            boolean zW2 = W();
            if (zW != zW2) {
                if (zW2) {
                    r(this.f1955g0);
                } else {
                    X(this.f1955g0);
                }
                invalidateSelf();
                y();
            }
        }
    }

    public final void R(float f) {
        if (this.f1967t0 != f) {
            float fT = t();
            this.f1967t0 = f;
            float fT2 = t();
            invalidateSelf();
            if (fT != fT2) {
                y();
            }
        }
    }

    public final void S(float f) {
        if (this.f1966s0 != f) {
            float fT = t();
            this.f1966s0 = f;
            float fT2 = t();
            invalidateSelf();
            if (fT != fT2) {
                y();
            }
        }
    }

    public final void T(ColorStateList colorStateList) {
        if (this.Y != colorStateList) {
            this.Y = colorStateList;
            this.U0 = null;
            onStateChange(getState());
        }
    }

    public final boolean U() {
        return this.f1960m0 && this.f1961n0 != null && this.M0;
    }

    public final boolean V() {
        return this.f1949a0 && this.f1950b0 != null;
    }

    public final boolean W() {
        return this.f1954f0 && this.f1955g0 != null;
    }

    @Override // j9.z
    public final void a() {
        y();
        invalidateSelf();
    }

    @Override // q9.g, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        Canvas canvas2;
        int iSaveLayerAlpha;
        float f;
        int i10;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i = this.O0) == 0) {
            return;
        }
        if (i < 255) {
            canvas2 = canvas;
            iSaveLayerAlpha = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i);
        } else {
            canvas2 = canvas;
            iSaveLayerAlpha = 0;
        }
        boolean z2 = this.Z0;
        Paint paint = this.A0;
        RectF rectF = this.C0;
        if (!z2) {
            paint.setColor(this.G0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, v(), v(), paint);
        }
        if (!this.Z0) {
            paint.setColor(this.H0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.P0;
            if (colorFilter == null) {
                colorFilter = this.Q0;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, v(), v(), paint);
        }
        if (this.Z0) {
            super.draw(canvas);
        }
        if (this.X > 0.0f && !this.Z0) {
            paint.setColor(this.J0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.Z0) {
                ColorFilter colorFilter2 = this.P0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.Q0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f4 = bounds.left;
            float f10 = this.X / 2.0f;
            rectF.set(f4 + f10, bounds.top + f10, bounds.right - f10, bounds.bottom - f10);
            float f11 = this.V - (this.X / 2.0f);
            canvas2.drawRoundRect(rectF, f11, f11, paint);
        }
        paint.setColor(this.K0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.Z0) {
            RectF rectF2 = new RectF(bounds);
            q9.f fVar = this.f11105u;
            k kVar = fVar.f11090a;
            float f12 = fVar.i;
            o4.c cVar = this.K;
            t1 t1Var = this.L;
            Path path = this.E0;
            t1Var.b(kVar, f12, rectF2, cVar, path);
            e(canvas2, paint, path, this.f11105u.f11090a, g());
        } else {
            canvas2.drawRoundRect(rectF, v(), v(), paint);
        }
        if (V()) {
            s(bounds, rectF);
            float f13 = rectF.left;
            float f14 = rectF.top;
            canvas2.translate(f13, f14);
            this.f1950b0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f1950b0.draw(canvas2);
            canvas2.translate(-f13, -f14);
        }
        if (U()) {
            s(bounds, rectF);
            float f15 = rectF.left;
            float f16 = rectF.top;
            canvas2.translate(f15, f16);
            this.f1961n0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f1961n0.draw(canvas2);
            canvas2.translate(-f15, -f16);
        }
        if (this.X0 && this.Z != null) {
            PointF pointF = this.D0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.Z;
            a0 a0Var = this.F0;
            if (charSequence != null) {
                float fT = t() + this.f1965r0 + this.f1968u0;
                if (getLayoutDirection() == 0) {
                    pointF.x = bounds.left + fT;
                } else {
                    pointF.x = bounds.right - fT;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = a0Var.f6836a;
                Paint.FontMetrics fontMetrics = this.B0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF.setEmpty();
            if (this.Z != null) {
                float fT2 = t() + this.f1965r0 + this.f1968u0;
                float fU = u() + this.f1972y0 + this.f1969v0;
                if (getLayoutDirection() == 0) {
                    rectF.left = bounds.left + fT2;
                    rectF.right = bounds.right - fU;
                } else {
                    rectF.left = bounds.left + fU;
                    rectF.right = bounds.right - fT2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            n9.d dVar = a0Var.f6841g;
            TextPaint textPaint2 = a0Var.f6836a;
            if (dVar != null) {
                textPaint2.drawableState = getState();
                a0Var.f6841g.e(this.f1973z0, textPaint2, a0Var.f6837b);
            }
            textPaint2.setTextAlign(align);
            String string = this.Z.toString();
            if (a0Var.f6840e) {
                a0Var.a(string);
                f = a0Var.f6838c;
            } else {
                f = a0Var.f6838c;
            }
            boolean z10 = Math.round(f) > Math.round(rectF.width());
            if (z10) {
                int iSave = canvas2.save();
                canvas2.clipRect(rectF);
                i10 = iSave;
            } else {
                i10 = 0;
            }
            CharSequence charSequenceEllipsize = this.Z;
            if (z10 && this.W0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF.width(), this.W0);
            }
            canvas.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z10) {
                canvas2.restoreToCount(i10);
            }
        }
        if (W()) {
            rectF.setEmpty();
            if (W()) {
                float f17 = this.f1972y0 + this.f1971x0;
                if (getLayoutDirection() == 0) {
                    float f18 = bounds.right - f17;
                    rectF.right = f18;
                    rectF.left = f18 - this.f1958j0;
                } else {
                    float f19 = bounds.left + f17;
                    rectF.left = f19;
                    rectF.right = f19 + this.f1958j0;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f20 = this.f1958j0;
                float f21 = fExactCenterY - (f20 / 2.0f);
                rectF.top = f21;
                rectF.bottom = f21 + f20;
            }
            float f22 = rectF.left;
            float f23 = rectF.top;
            canvas2.translate(f22, f23);
            this.f1955g0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            int[] iArr = o9.a.f9444a;
            this.f1956h0.setBounds(this.f1955g0.getBounds());
            this.f1956h0.jumpToCurrentState();
            this.f1956h0.draw(canvas2);
            canvas2.translate(-f22, -f23);
        }
        if (this.O0 < 255) {
            canvas2.restoreToCount(iSaveLayerAlpha);
        }
    }

    @Override // q9.g, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.O0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.P0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.U;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float f;
        float fT = t() + this.f1965r0 + this.f1968u0;
        String string = this.Z.toString();
        a0 a0Var = this.F0;
        if (a0Var.f6840e) {
            a0Var.a(string);
            f = a0Var.f6838c;
        } else {
            f = a0Var.f6838c;
        }
        return Math.min(Math.round(u() + f + fT + this.f1969v0 + this.f1972y0), this.Y0);
    }

    @Override // q9.g, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // q9.g, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.Z0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.U, this.V);
        } else {
            outline.setRoundRect(bounds, this.V);
            outline2 = outline;
        }
        outline2.setAlpha(this.O0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // q9.g, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (w(this.S) || w(this.T) || w(this.W)) {
            return true;
        }
        n9.d dVar = this.F0.f6841g;
        if (dVar == null || (colorStateList = dVar.f8868j) == null || !colorStateList.isStateful()) {
            return (this.f1960m0 && this.f1961n0 != null && this.l0) || x(this.f1950b0) || x(this.f1961n0) || w(this.R0);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (V()) {
            zOnLayoutDirectionChanged |= this.f1950b0.setLayoutDirection(i);
        }
        if (U()) {
            zOnLayoutDirectionChanged |= this.f1961n0.setLayoutDirection(i);
        }
        if (W()) {
            zOnLayoutDirectionChanged |= this.f1955g0.setLayoutDirection(i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (V()) {
            zOnLevelChange |= this.f1950b0.setLevel(i);
        }
        if (U()) {
            zOnLevelChange |= this.f1961n0.setLevel(i);
        }
        if (W()) {
            zOnLevelChange |= this.f1955g0.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // q9.g, android.graphics.drawable.Drawable, j9.z
    public final boolean onStateChange(int[] iArr) {
        if (this.Z0) {
            super.onStateChange(iArr);
        }
        return z(iArr, this.T0);
    }

    public final void r(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        drawable.setLayoutDirection(getLayoutDirection());
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f1955g0) {
            if (drawable.isStateful()) {
                drawable.setState(this.T0);
            }
            drawable.setTintList(this.f1957i0);
            return;
        }
        Drawable drawable2 = this.f1950b0;
        if (drawable == drawable2 && this.f1953e0) {
            drawable2.setTintList(this.f1951c0);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void s(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (V() || U()) {
            float f = this.f1965r0 + this.f1966s0;
            Drawable drawable = this.M0 ? this.f1961n0 : this.f1950b0;
            float intrinsicWidth = this.f1952d0;
            if (intrinsicWidth <= 0.0f && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (getLayoutDirection() == 0) {
                float f4 = rect.left + f;
                rectF.left = f4;
                rectF.right = f4 + intrinsicWidth;
            } else {
                float f10 = rect.right - f;
                rectF.right = f10;
                rectF.left = f10 - intrinsicWidth;
            }
            Drawable drawable2 = this.M0 ? this.f1961n0 : this.f1950b0;
            float fCeil = this.f1952d0;
            if (fCeil <= 0.0f && drawable2 != null) {
                fCeil = (float) Math.ceil(f0.b(this.f1973z0, 24));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j5);
        }
    }

    @Override // q9.g, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.O0 != i) {
            this.O0 = i;
            invalidateSelf();
        }
    }

    @Override // q9.g, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.P0 != colorFilter) {
            this.P0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // q9.g, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.R0 != colorStateList) {
            this.R0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // q9.g, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.S0 != mode) {
            this.S0 = mode;
            ColorStateList colorStateList = this.R0;
            this.Q0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z2, boolean z10) {
        boolean visible = super.setVisible(z2, z10);
        if (V()) {
            visible |= this.f1950b0.setVisible(z2, z10);
        }
        if (U()) {
            visible |= this.f1961n0.setVisible(z2, z10);
        }
        if (W()) {
            visible |= this.f1955g0.setVisible(z2, z10);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final float t() {
        if (!V() && !U()) {
            return 0.0f;
        }
        float f = this.f1966s0;
        Drawable drawable = this.M0 ? this.f1961n0 : this.f1950b0;
        float intrinsicWidth = this.f1952d0;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f + this.f1967t0;
    }

    public final float u() {
        if (W()) {
            return this.f1970w0 + this.f1958j0 + this.f1971x0;
        }
        return 0.0f;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final float v() {
        return this.Z0 ? h() : this.V;
    }

    public final void y() {
        d dVar = (d) this.V0.get();
        if (dVar != null) {
            Chip chip = (Chip) dVar;
            chip.b(chip.K);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    public final boolean z(int[] iArr, int[] iArr2) {
        boolean z2;
        boolean z10;
        ColorStateList colorStateList;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.S;
        int iC = c(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.G0) : 0);
        boolean state = true;
        if (this.G0 != iC) {
            this.G0 = iC;
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.T;
        int iC2 = c(colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.H0) : 0);
        if (this.H0 != iC2) {
            this.H0 = iC2;
            zOnStateChange = true;
        }
        int iB = i0.b.b(iC2, iC);
        if ((this.I0 != iB) | (this.f11105u.f11092c == null)) {
            this.I0 = iB;
            l(ColorStateList.valueOf(iB));
            zOnStateChange = true;
        }
        ColorStateList colorStateList4 = this.W;
        int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.J0) : 0;
        if (this.J0 != colorForState) {
            this.J0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.U0 == null || !o9.a.d(iArr)) ? 0 : this.U0.getColorForState(iArr, this.K0);
        if (this.K0 != colorForState2) {
            this.K0 = colorForState2;
        }
        n9.d dVar = this.F0.f6841g;
        int colorForState3 = (dVar == null || (colorStateList = dVar.f8868j) == null) ? 0 : colorStateList.getColorForState(iArr, this.L0);
        if (this.L0 != colorForState3) {
            this.L0 = colorForState3;
            zOnStateChange = true;
        }
        int[] state2 = getState();
        if (state2 == null) {
            z2 = false;
        } else {
            int length = state2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (state2[i] != 16842912) {
                    i++;
                } else if (this.l0) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        if (this.M0 == z2 || this.f1961n0 == null) {
            z10 = false;
        } else {
            float fT = t();
            this.M0 = z2;
            if (fT != t()) {
                zOnStateChange = true;
                z10 = true;
            } else {
                z10 = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList5 = this.R0;
        int colorForState4 = colorStateList5 != null ? colorStateList5.getColorForState(iArr, this.N0) : 0;
        if (this.N0 != colorForState4) {
            this.N0 = colorForState4;
            ColorStateList colorStateList6 = this.R0;
            PorterDuff.Mode mode = this.S0;
            this.Q0 = (colorStateList6 == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList6.getColorForState(getState(), 0), mode);
        } else {
            state = zOnStateChange;
        }
        if (x(this.f1950b0)) {
            state |= this.f1950b0.setState(iArr);
        }
        if (x(this.f1961n0)) {
            state |= this.f1961n0.setState(iArr);
        }
        if (x(this.f1955g0)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.f1955g0.setState(iArr3);
        }
        int[] iArr4 = o9.a.f9444a;
        if (x(this.f1956h0)) {
            state |= this.f1956h0.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z10) {
            y();
        }
        return state;
    }
}
