package v9;

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
import da.a0;
import da.b0;
import da.e0;
import g2.h1;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import ka.i;
import ka.l;
import ka.m;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends i implements Drawable.Callback, a0 {

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int[] f13509k1 = {R.attr.state_enabled};

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final ShapeDrawable f13510l1 = new ShapeDrawable(new OvalShape());
    public l9.d A0;
    public float B0;
    public float C0;
    public float D0;
    public float E0;
    public float F0;
    public float G0;
    public float H0;
    public float I0;
    public final Context J0;
    public final Paint K0;
    public final Paint.FontMetrics L0;
    public final RectF M0;
    public final PointF N0;
    public final Path O0;
    public final b0 P0;
    public int Q0;
    public int R0;
    public int S0;
    public int T0;
    public int U0;
    public int V0;
    public boolean W0;
    public int X0;
    public int Y0;
    public ColorFilter Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public PorterDuffColorFilter f13511a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public ColorStateList f13512b1;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public ColorStateList f13513c0;
    public PorterDuff.Mode c1;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public ColorStateList f13514d0;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public int[] f13515d1;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f13516e0;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public ColorStateList f13517e1;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f13518f0;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public WeakReference f13519f1;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public ColorStateList f13520g0;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public TextUtils.TruncateAt f13521g1;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public float f13522h0;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public boolean f13523h1;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public ColorStateList f13524i0;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public int f13525i1;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public CharSequence f13526j0;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public boolean f13527j1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f13528k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public Drawable f13529l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public ColorStateList f13530m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public float f13531n0;
    public boolean o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f13532p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public Drawable f13533q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public RippleDrawable f13534r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public ColorStateList f13535s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public float f13536t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public SpannableStringBuilder f13537u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f13538v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f13539w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public Drawable f13540x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public ColorStateList f13541y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public l9.d f13542z0;

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, Chip.S);
        this.f13518f0 = -1.0f;
        this.K0 = new Paint(1);
        this.L0 = new Paint.FontMetrics();
        this.M0 = new RectF();
        this.N0 = new PointF();
        this.O0 = new Path();
        this.Y0 = 255;
        this.c1 = PorterDuff.Mode.SRC_IN;
        this.f13519f1 = new WeakReference(null);
        m(context);
        this.J0 = context;
        b0 b0Var = new b0(this);
        this.P0 = b0Var;
        this.f13526j0 = "";
        b0Var.f3567a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = f13509k1;
        setState(iArr);
        W(iArr);
        this.f13523h1 = true;
        f13510l1.setTint(-1);
    }

    public static boolean D(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean E(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static void f0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public final float A() {
        if (!d0() && !c0()) {
            return 0.0f;
        }
        float f = this.C0;
        Drawable drawable = this.W0 ? this.f13540x0 : this.f13529l0;
        float intrinsicWidth = this.f13531n0;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f + this.D0;
    }

    public final float B() {
        if (e0()) {
            return this.G0 + this.f13536t0 + this.H0;
        }
        return 0.0f;
    }

    public final float C() {
        return this.f13527j1 ? k() : this.f13518f0;
    }

    public final void F() {
        b bVar = (b) this.f13519f1.get();
        if (bVar != null) {
            Chip chip = (Chip) bVar;
            chip.c(chip.L);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean G(int[] r10, int[] r11) {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v9.c.G(int[], int[]):boolean");
    }

    public final void H(boolean z10) {
        if (this.f13538v0 != z10) {
            this.f13538v0 = z10;
            float fA = A();
            if (!z10 && this.W0) {
                this.W0 = false;
            }
            float fA2 = A();
            invalidateSelf();
            if (fA != fA2) {
                F();
            }
        }
    }

    public final void I(Drawable drawable) {
        if (this.f13540x0 != drawable) {
            float fA = A();
            this.f13540x0 = drawable;
            float fA2 = A();
            f0(this.f13540x0);
            y(this.f13540x0);
            invalidateSelf();
            if (fA != fA2) {
                F();
            }
        }
    }

    public final void J(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f13541y0 != colorStateList) {
            this.f13541y0 = colorStateList;
            if (this.f13539w0 && (drawable = this.f13540x0) != null && this.f13538v0) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void K(boolean z10) {
        if (this.f13539w0 != z10) {
            boolean zC0 = c0();
            this.f13539w0 = z10;
            boolean zC02 = c0();
            if (zC0 != zC02) {
                if (zC02) {
                    y(this.f13540x0);
                } else {
                    f0(this.f13540x0);
                }
                invalidateSelf();
                F();
            }
        }
    }

    public final void L(float f) {
        if (this.f13518f0 != f) {
            this.f13518f0 = f;
            l lVarG = this.f7334w.f7316a.g();
            lVarG.b(f);
            setShapeAppearanceModel(lVarG.a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final void M(Drawable drawable) {
        ?? r02;
        Object obj = this.f13529l0;
        if (obj != null) {
            boolean z10 = obj instanceof m0.b;
            r02 = obj;
            if (z10) {
                r02 = 0;
            }
        } else {
            r02 = 0;
        }
        if (r02 != drawable) {
            float fA = A();
            this.f13529l0 = drawable != null ? drawable.mutate() : null;
            float fA2 = A();
            f0(r02);
            if (d0()) {
                y(this.f13529l0);
            }
            invalidateSelf();
            if (fA != fA2) {
                F();
            }
        }
    }

    public final void N(float f) {
        if (this.f13531n0 != f) {
            float fA = A();
            this.f13531n0 = f;
            float fA2 = A();
            invalidateSelf();
            if (fA != fA2) {
                F();
            }
        }
    }

    public final void O(ColorStateList colorStateList) {
        this.o0 = true;
        if (this.f13530m0 != colorStateList) {
            this.f13530m0 = colorStateList;
            if (d0()) {
                this.f13529l0.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void P(boolean z10) {
        if (this.f13528k0 != z10) {
            boolean zD0 = d0();
            this.f13528k0 = z10;
            boolean zD02 = d0();
            if (zD0 != zD02) {
                if (zD02) {
                    y(this.f13529l0);
                } else {
                    f0(this.f13529l0);
                }
                invalidateSelf();
                F();
            }
        }
    }

    public final void Q(ColorStateList colorStateList) {
        if (this.f13520g0 != colorStateList) {
            this.f13520g0 = colorStateList;
            if (this.f13527j1) {
                ka.g gVar = this.f7334w;
                if (gVar.f7320e != colorStateList) {
                    gVar.f7320e = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void R(float f) {
        if (this.f13522h0 != f) {
            this.f13522h0 = f;
            this.K0.setStrokeWidth(f);
            if (this.f13527j1) {
                this.f7334w.f7324k = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final void S(Drawable drawable) {
        ?? r02;
        Object obj = this.f13533q0;
        if (obj != null) {
            boolean z10 = obj instanceof m0.b;
            r02 = obj;
            if (z10) {
                r02 = 0;
            }
        } else {
            r02 = 0;
        }
        if (r02 != drawable) {
            float fB = B();
            this.f13533q0 = drawable != null ? drawable.mutate() : null;
            this.f13534r0 = new RippleDrawable(ia.a.b(this.f13524i0), this.f13533q0, f13510l1);
            float fB2 = B();
            f0(r02);
            if (e0()) {
                y(this.f13533q0);
            }
            invalidateSelf();
            if (fB != fB2) {
                F();
            }
        }
    }

    public final void T(float f) {
        if (this.H0 != f) {
            this.H0 = f;
            invalidateSelf();
            if (e0()) {
                F();
            }
        }
    }

    public final void U(float f) {
        if (this.f13536t0 != f) {
            this.f13536t0 = f;
            invalidateSelf();
            if (e0()) {
                F();
            }
        }
    }

    public final void V(float f) {
        if (this.G0 != f) {
            this.G0 = f;
            invalidateSelf();
            if (e0()) {
                F();
            }
        }
    }

    public final boolean W(int[] iArr) {
        if (Arrays.equals(this.f13515d1, iArr)) {
            return false;
        }
        this.f13515d1 = iArr;
        if (e0()) {
            return G(getState(), iArr);
        }
        return false;
    }

    public final void X(ColorStateList colorStateList) {
        if (this.f13535s0 != colorStateList) {
            this.f13535s0 = colorStateList;
            if (e0()) {
                this.f13533q0.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void Y(boolean z10) {
        if (this.f13532p0 != z10) {
            boolean zE0 = e0();
            this.f13532p0 = z10;
            boolean zE02 = e0();
            if (zE0 != zE02) {
                if (zE02) {
                    y(this.f13533q0);
                } else {
                    f0(this.f13533q0);
                }
                invalidateSelf();
                F();
            }
        }
    }

    public final void Z(float f) {
        if (this.D0 != f) {
            float fA = A();
            this.D0 = f;
            float fA2 = A();
            invalidateSelf();
            if (fA != fA2) {
                F();
            }
        }
    }

    @Override // da.a0
    public final void a() {
        F();
        invalidateSelf();
    }

    public final void a0(float f) {
        if (this.C0 != f) {
            float fA = A();
            this.C0 = f;
            float fA2 = A();
            invalidateSelf();
            if (fA != fA2) {
                F();
            }
        }
    }

    public final void b0(ColorStateList colorStateList) {
        if (this.f13524i0 != colorStateList) {
            this.f13524i0 = colorStateList;
            this.f13517e1 = null;
            onStateChange(getState());
        }
    }

    public final boolean c0() {
        return this.f13539w0 && this.f13540x0 != null && this.W0;
    }

    public final boolean d0() {
        return this.f13528k0 && this.f13529l0 != null;
    }

    @Override // ka.i, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        Canvas canvas2;
        int iSaveLayerAlpha;
        float f;
        float f10;
        int i10;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i = this.Y0) == 0) {
            return;
        }
        if (i < 255) {
            canvas2 = canvas;
            iSaveLayerAlpha = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i);
        } else {
            canvas2 = canvas;
            iSaveLayerAlpha = 0;
        }
        boolean z10 = this.f13527j1;
        Paint paint = this.K0;
        RectF rectF = this.M0;
        if (!z10) {
            paint.setColor(this.Q0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, C(), C(), paint);
        }
        if (!this.f13527j1) {
            paint.setColor(this.R0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.Z0;
            if (colorFilter == null) {
                colorFilter = this.f13511a1;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, C(), C(), paint);
        }
        if (this.f13527j1) {
            super.draw(canvas);
        }
        if (this.f13522h0 > 0.0f && !this.f13527j1) {
            paint.setColor(this.T0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.f13527j1) {
                ColorFilter colorFilter2 = this.Z0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.f13511a1;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f11 = bounds.left;
            float f12 = this.f13522h0 / 2.0f;
            rectF.set(f11 + f12, bounds.top + f12, bounds.right - f12, bounds.bottom - f12);
            float f13 = this.f13518f0 - (this.f13522h0 / 2.0f);
            canvas2.drawRoundRect(rectF, f13, f13, paint);
        }
        paint.setColor(this.U0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.f13527j1) {
            RectF rectF2 = new RectF(bounds);
            ka.g gVar = this.f7334w;
            m mVar = gVar.f7316a;
            float[] fArr = this.X;
            float f14 = gVar.f7323j;
            p6.d dVar = this.M;
            h1 h1Var = this.N;
            f = 2.0f;
            Path path = this.O0;
            h1Var.b(mVar, fArr, f14, rectF2, dVar, path);
            f(canvas2, paint, path, this.f7334w.f7316a, this.X, h());
        } else {
            canvas2.drawRoundRect(rectF, C(), C(), paint);
            f = 2.0f;
        }
        if (d0()) {
            z(bounds, rectF);
            float f15 = rectF.left;
            float f16 = rectF.top;
            canvas2.translate(f15, f16);
            this.f13529l0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f13529l0.draw(canvas2);
            canvas2.translate(-f15, -f16);
        }
        if (c0()) {
            z(bounds, rectF);
            float f17 = rectF.left;
            float f18 = rectF.top;
            canvas2.translate(f17, f18);
            this.f13540x0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f13540x0.draw(canvas2);
            canvas2.translate(-f17, -f18);
        }
        if (this.f13523h1 && this.f13526j0 != null) {
            PointF pointF = this.N0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.f13526j0;
            b0 b0Var = this.P0;
            if (charSequence != null) {
                float fA = A() + this.B0 + this.E0;
                if (getLayoutDirection() == 0) {
                    pointF.x = bounds.left + fA;
                } else {
                    pointF.x = bounds.right - fA;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = b0Var.f3567a;
                Paint.FontMetrics fontMetrics = this.L0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / f);
            }
            rectF.setEmpty();
            if (this.f13526j0 != null) {
                float fA2 = A() + this.B0 + this.E0;
                float fB = B() + this.I0 + this.F0;
                if (getLayoutDirection() == 0) {
                    rectF.left = bounds.left + fA2;
                    rectF.right = bounds.right - fB;
                } else {
                    rectF.left = bounds.left + fB;
                    rectF.right = bounds.right - fA2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            ha.d dVar2 = b0Var.f3572g;
            TextPaint textPaint2 = b0Var.f3567a;
            if (dVar2 != null) {
                textPaint2.drawableState = getState();
                b0Var.f3572g.d(this.J0, textPaint2, b0Var.f3568b);
            }
            textPaint2.setTextAlign(align);
            String string = this.f13526j0.toString();
            if (b0Var.f3571e) {
                b0Var.a(string);
                f10 = b0Var.f3569c;
            } else {
                f10 = b0Var.f3569c;
            }
            boolean z11 = Math.round(f10) > Math.round(rectF.width());
            if (z11) {
                int iSave = canvas2.save();
                canvas2.clipRect(rectF);
                i10 = iSave;
            } else {
                i10 = 0;
            }
            CharSequence charSequenceEllipsize = this.f13526j0;
            if (z11 && this.f13521g1 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF.width(), this.f13521g1);
            }
            canvas.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z11) {
                canvas2.restoreToCount(i10);
            }
        }
        if (e0()) {
            rectF.setEmpty();
            if (e0()) {
                float f19 = this.I0 + this.H0;
                if (getLayoutDirection() == 0) {
                    float f20 = bounds.right - f19;
                    rectF.right = f20;
                    rectF.left = f20 - this.f13536t0;
                } else {
                    float f21 = bounds.left + f19;
                    rectF.left = f21;
                    rectF.right = f21 + this.f13536t0;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f22 = this.f13536t0;
                float f23 = fExactCenterY - (f22 / f);
                rectF.top = f23;
                rectF.bottom = f23 + f22;
            }
            float f24 = rectF.left;
            float f25 = rectF.top;
            canvas2.translate(f24, f25);
            this.f13533q0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f13534r0.setBounds(this.f13533q0.getBounds());
            this.f13534r0.jumpToCurrentState();
            this.f13534r0.draw(canvas2);
            canvas2.translate(-f24, -f25);
        }
        if (this.Y0 < 255) {
            canvas2.restoreToCount(iSaveLayerAlpha);
        }
    }

    public final boolean e0() {
        return this.f13532p0 && this.f13533q0 != null;
    }

    @Override // ka.i, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.Y0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.Z0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f13516e0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float f;
        float fA = A() + this.B0 + this.E0;
        String string = this.f13526j0.toString();
        b0 b0Var = this.P0;
        if (b0Var.f3571e) {
            b0Var.a(string);
            f = b0Var.f3569c;
        } else {
            f = b0Var.f3569c;
        }
        return Math.min(Math.round(B() + f + fA + this.F0 + this.I0), this.f13525i1);
    }

    @Override // ka.i, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // ka.i, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.f13527j1) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.f13516e0, this.f13518f0);
        } else {
            outline.setRoundRect(bounds, this.f13518f0);
            outline2 = outline;
        }
        outline2.setAlpha(this.Y0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // ka.i, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (D(this.f13513c0) || D(this.f13514d0) || D(this.f13520g0)) {
            return true;
        }
        ha.d dVar = this.P0.f3572g;
        if (dVar == null || (colorStateList = dVar.f5864k) == null || !colorStateList.isStateful()) {
            return (this.f13539w0 && this.f13540x0 != null && this.f13538v0) || E(this.f13529l0) || E(this.f13540x0) || D(this.f13512b1);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (d0()) {
            zOnLayoutDirectionChanged |= this.f13529l0.setLayoutDirection(i);
        }
        if (c0()) {
            zOnLayoutDirectionChanged |= this.f13540x0.setLayoutDirection(i);
        }
        if (e0()) {
            zOnLayoutDirectionChanged |= this.f13533q0.setLayoutDirection(i);
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
        if (d0()) {
            zOnLevelChange |= this.f13529l0.setLevel(i);
        }
        if (c0()) {
            zOnLevelChange |= this.f13540x0.setLevel(i);
        }
        if (e0()) {
            zOnLevelChange |= this.f13533q0.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // ka.i, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        if (this.f13527j1) {
            super.onStateChange(iArr);
        }
        return G(iArr, this.f13515d1);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j4) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j4);
        }
    }

    @Override // ka.i, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.Y0 != i) {
            this.Y0 = i;
            invalidateSelf();
        }
    }

    @Override // ka.i, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.Z0 != colorFilter) {
            this.Z0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // ka.i, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.f13512b1 != colorStateList) {
            this.f13512b1 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // ka.i, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.c1 != mode) {
            this.c1 = mode;
            ColorStateList colorStateList = this.f13512b1;
            this.f13511a1 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (d0()) {
            visible |= this.f13529l0.setVisible(z10, z11);
        }
        if (c0()) {
            visible |= this.f13540x0.setVisible(z10, z11);
        }
        if (e0()) {
            visible |= this.f13533q0.setVisible(z10, z11);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void y(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        drawable.setLayoutDirection(getLayoutDirection());
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f13533q0) {
            if (drawable.isStateful()) {
                drawable.setState(this.f13515d1);
            }
            drawable.setTintList(this.f13535s0);
            return;
        }
        Drawable drawable2 = this.f13529l0;
        if (drawable == drawable2 && this.o0) {
            drawable2.setTintList(this.f13530m0);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void z(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (d0() || c0()) {
            float f = this.B0 + this.C0;
            Drawable drawable = this.W0 ? this.f13540x0 : this.f13529l0;
            float intrinsicWidth = this.f13531n0;
            if (intrinsicWidth <= 0.0f && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (getLayoutDirection() == 0) {
                float f10 = rect.left + f;
                rectF.left = f10;
                rectF.right = f10 + intrinsicWidth;
            } else {
                float f11 = rect.right - f;
                rectF.right = f11;
                rectF.left = f11 - intrinsicWidth;
            }
            Drawable drawable2 = this.W0 ? this.f13540x0 : this.f13529l0;
            float fCeil = this.f13531n0;
            if (fCeil <= 0.0f && drawable2 != null) {
                fCeil = (float) Math.ceil(e0.a(this.J0, 24));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }
}
