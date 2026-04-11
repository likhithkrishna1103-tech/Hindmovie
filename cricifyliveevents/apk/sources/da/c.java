package da;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.Gravity;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public CharSequence B;
    public CharSequence C;
    public boolean D;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public int K;
    public int L;
    public int[] M;
    public boolean N;
    public final TextPaint O;
    public final TextPaint P;
    public TimeInterpolator Q;
    public TimeInterpolator R;
    public float S;
    public float T;
    public float U;
    public ColorStateList V;
    public float W;
    public float X;
    public float Y;
    public StaticLayout Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f3573a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f3574a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3575b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f3576b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f3577c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public float f3578c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f3579d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public CharSequence f3580d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f3581e;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f3589j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f3591k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f3592k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3593l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3594m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f3595n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3596o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f3597p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f3598q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f3599r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Typeface f3600s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Typeface f3601t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Typeface f3602u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Typeface f3603v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Typeface f3604w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Typeface f3605x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Typeface f3606y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ha.a f3607z;
    public int f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3584g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3586h = 15.0f;
    public float i = 15.0f;
    public final TextUtils.TruncateAt A = TextUtils.TruncateAt.END;
    public final boolean E = true;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f3582e0 = 1;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f3583f0 = 1;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final float f3585g0 = 1.0f;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final int f3587h0 = 1;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f3588i0 = -1;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f3590j0 = -1;

    public c(TextInputLayout textInputLayout) {
        this.f3573a = textInputLayout;
        TextPaint textPaint = new TextPaint(129);
        this.O = textPaint;
        this.P = new TextPaint(textPaint);
        this.f3579d = new Rect();
        this.f3577c = new Rect();
        this.f3581e = new RectF();
        i(textInputLayout.getContext().getResources().getConfiguration());
    }

    public static int a(float f, int i, int i10) {
        float f10 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i10) * f) + (Color.alpha(i) * f10)), Math.round((Color.red(i10) * f) + (Color.red(i) * f10)), Math.round((Color.green(i10) * f) + (Color.green(i) * f10)), Math.round((Color.blue(i10) * f) + (Color.blue(i) * f10)));
    }

    public static float h(float f, float f10, float f11, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f11 = timeInterpolator.getInterpolation(f11);
        }
        return l9.a.a(f, f10, f11);
    }

    public final void b() {
        float f = this.f3575b;
        float f10 = this.f3577c.left;
        Rect rect = this.f3579d;
        float fH = h(f10, rect.left, f, this.Q);
        RectF rectF = this.f3581e;
        rectF.left = fH;
        rectF.top = h(this.f3594m, this.f3595n, f, this.Q);
        rectF.right = h(r1.right, rect.right, f, this.Q);
        rectF.bottom = h(r1.bottom, rect.bottom, f, this.Q);
        this.f3598q = h(this.f3596o, this.f3597p, f, this.Q);
        this.f3599r = h(this.f3594m, this.f3595n, f, this.Q);
        d(f, false);
        TextInputLayout textInputLayout = this.f3573a;
        textInputLayout.postInvalidateOnAnimation();
        q1.a aVar = l9.a.f7926b;
        this.f3576b0 = 1.0f - h(0.0f, 1.0f, 1.0f - f, aVar);
        textInputLayout.postInvalidateOnAnimation();
        this.f3578c0 = h(1.0f, 0.0f, f, aVar);
        textInputLayout.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.f3591k;
        ColorStateList colorStateList2 = this.f3589j;
        TextPaint textPaint = this.O;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(f, g(colorStateList2), g(this.f3591k)));
        } else {
            textPaint.setColor(g(colorStateList));
        }
        float f11 = this.W;
        float f12 = this.X;
        if (f11 != f12) {
            textPaint.setLetterSpacing(h(f12, f11, f, aVar));
        } else {
            textPaint.setLetterSpacing(f11);
        }
        this.H = l9.a.a(0.0f, this.S, f);
        this.I = l9.a.a(0.0f, this.T, f);
        this.J = l9.a.a(0.0f, this.U, f);
        int iA = a(f, 0, g(this.V));
        this.K = iA;
        textPaint.setShadowLayer(this.H, this.I, this.J, iA);
        textInputLayout.postInvalidateOnAnimation();
    }

    public final boolean c(CharSequence charSequence) {
        boolean z10 = this.f3573a.getLayoutDirection() == 1;
        if (this.E) {
            return (z10 ? r0.f.f10846d : r0.f.f10845c).g(charSequence, charSequence.length());
        }
        return z10;
    }

    public final void d(float f, boolean z10) {
        float f10;
        Typeface typeface;
        float f11;
        if (this.B == null) {
            return;
        }
        float fWidth = this.f3579d.width();
        float fWidth2 = this.f3577c.width();
        if (Math.abs(f - 1.0f) < 1.0E-5f) {
            f10 = o() ? this.i : this.f3586h;
            f11 = o() ? this.W : this.X;
            this.F = o() ? 1.0f : h(this.f3586h, this.i, f, this.R) / this.f3586h;
            if (!o()) {
                fWidth = fWidth2;
            }
            typeface = this.f3600s;
            fWidth2 = fWidth;
        } else {
            f10 = this.f3586h;
            float f12 = this.X;
            typeface = this.f3603v;
            if (Math.abs(f - 0.0f) < 1.0E-5f) {
                this.F = 1.0f;
            } else {
                this.F = h(this.f3586h, this.i, f, this.R) / this.f3586h;
            }
            float f13 = this.i / this.f3586h;
            float f14 = fWidth2 * f13;
            if (!z10 && f14 > fWidth && o()) {
                fWidth2 = Math.min(fWidth / f13, fWidth2);
            }
            f11 = f12;
        }
        int i = f < 0.5f ? this.f3582e0 : this.f3583f0;
        TextPaint textPaint = this.O;
        if (fWidth2 > 0.0f) {
            boolean z11 = this.G != f10;
            boolean z12 = this.Y != f11;
            boolean z13 = this.f3606y != typeface;
            StaticLayout staticLayout = this.Z;
            boolean z14 = z11 || z12 || (staticLayout != null && (fWidth2 > ((float) staticLayout.getWidth()) ? 1 : (fWidth2 == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z13 || (this.L != i) || this.N;
            this.G = f10;
            this.Y = f11;
            this.f3606y = typeface;
            this.N = false;
            this.L = i;
            textPaint.setLinearText(this.F != 1.0f);
            z = z14;
        }
        if (this.C == null || z) {
            textPaint.setTextSize(this.G);
            textPaint.setTypeface(this.f3606y);
            textPaint.setLetterSpacing(this.Y);
            boolean zC = c(this.B);
            this.D = zC;
            StaticLayout staticLayoutE = e(((this.f3582e0 > 1 || this.f3583f0 > 1) && !zC) ? i : 1, textPaint, this.B, fWidth2 * (o() ? 1.0f : this.F), this.D);
            this.Z = staticLayoutE;
            this.C = staticLayoutE.getText();
        }
    }

    public final StaticLayout e(int i, TextPaint textPaint, CharSequence charSequence, float f, boolean z10) {
        Layout.Alignment alignment;
        if (i == 1) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(this.f, this.D ? 1 : 0) & 7;
            alignment = absoluteGravity != 1 ? absoluteGravity != 5 ? this.D ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.D ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
        }
        y yVar = new y(charSequence, textPaint, (int) f);
        yVar.f3648l = this.A;
        yVar.f3647k = z10;
        yVar.f3643e = alignment;
        yVar.f3646j = false;
        yVar.f = i;
        float f10 = this.f3585g0;
        yVar.f3644g = 0.0f;
        yVar.f3645h = f10;
        yVar.i = this.f3587h0;
        yVar.f3649m = null;
        StaticLayout staticLayoutA = yVar.a();
        staticLayoutA.getClass();
        return staticLayoutA;
    }

    public final float f() {
        int i = this.f3588i0;
        if (i != -1) {
            return i;
        }
        float f = this.i;
        TextPaint textPaint = this.P;
        textPaint.setTextSize(f);
        textPaint.setTypeface(this.f3600s);
        textPaint.setLetterSpacing(this.W);
        return -textPaint.ascent();
    }

    public final int g(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.M;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void i(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f3602u;
            if (typeface != null) {
                this.f3601t = com.bumptech.glide.e.j(configuration, typeface);
            }
            Typeface typeface2 = this.f3605x;
            if (typeface2 != null) {
                this.f3604w = com.bumptech.glide.e.j(configuration, typeface2);
            }
            Typeface typeface3 = this.f3601t;
            if (typeface3 == null) {
                typeface3 = this.f3602u;
            }
            this.f3600s = typeface3;
            Typeface typeface4 = this.f3604w;
            if (typeface4 == null) {
                typeface4 = this.f3605x;
            }
            this.f3603v = typeface4;
            j(true);
        }
    }

    public final void j(boolean z10) {
        float fMeasureText;
        TextInputLayout textInputLayout = this.f3573a;
        if ((textInputLayout.getHeight() <= 0 || textInputLayout.getWidth() <= 0) && !z10) {
            return;
        }
        d(1.0f, z10);
        CharSequence charSequence = this.C;
        TextPaint textPaint = this.O;
        if (charSequence != null && this.Z != null) {
            this.f3580d0 = o() ? TextUtils.ellipsize(this.C, textPaint, this.Z.getWidth(), this.A) : this.C;
        }
        CharSequence charSequence2 = this.f3580d0;
        if (charSequence2 != null) {
            this.f3574a0 = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f3574a0 = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f3584g, this.D ? 1 : 0);
        int i = absoluteGravity & 112;
        Rect rect = this.f3579d;
        if (i == 48) {
            this.f3595n = rect.top;
        } else if (i != 80) {
            this.f3595n = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f3595n = textPaint.ascent() + rect.bottom;
        }
        int i10 = absoluteGravity & 8388615;
        if (i10 == 1) {
            this.f3597p = rect.centerX() - (this.f3574a0 / 2.0f);
        } else if (i10 != 5) {
            this.f3597p = rect.left;
        } else {
            this.f3597p = rect.right - this.f3574a0;
        }
        if (this.f3574a0 <= rect.width()) {
            float f = this.f3597p;
            float fMax = Math.max(0.0f, rect.left - f) + f;
            this.f3597p = fMax;
            this.f3597p = Math.min(0.0f, rect.right - (this.f3574a0 + fMax)) + fMax;
        }
        float f10 = this.i;
        TextPaint textPaint2 = this.P;
        textPaint2.setTextSize(f10);
        textPaint2.setTypeface(this.f3600s);
        textPaint2.setLetterSpacing(this.W);
        if (textPaint2.descent() + (-textPaint2.ascent()) <= rect.height()) {
            float f11 = this.f3595n;
            float fMax2 = Math.max(0.0f, rect.top - f11) + f11;
            this.f3595n = fMax2;
            this.f3595n = Math.min(0.0f, rect.bottom - (f() + fMax2)) + fMax2;
        }
        d(0.0f, z10);
        float height = this.Z != null ? r15.getHeight() : 0.0f;
        StaticLayout staticLayout = this.Z;
        if (staticLayout == null || this.f3582e0 <= 1) {
            CharSequence charSequence3 = this.C;
            fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            fMeasureText = staticLayout.getWidth();
        }
        StaticLayout staticLayout2 = this.Z;
        this.f3593l = staticLayout2 != null ? staticLayout2.getLineCount() : 0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f, this.D ? 1 : 0);
        int i11 = absoluteGravity2 & 112;
        Rect rect2 = this.f3577c;
        if (i11 == 48) {
            this.f3594m = rect2.top;
        } else if (i11 != 80) {
            this.f3594m = rect2.centerY() - (height / 2.0f);
        } else {
            this.f3594m = (rect2.bottom - height) + (this.f3592k0 ? textPaint.descent() : 0.0f);
        }
        int i12 = absoluteGravity2 & 8388615;
        if (i12 == 1) {
            this.f3596o = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i12 != 5) {
            this.f3596o = rect2.left;
        } else {
            this.f3596o = rect2.right - fMeasureText;
        }
        d(this.f3575b, false);
        textInputLayout.postInvalidateOnAnimation();
        b();
    }

    public final void k(ColorStateList colorStateList) {
        if (this.f3591k == colorStateList && this.f3589j == colorStateList) {
            return;
        }
        this.f3591k = colorStateList;
        this.f3589j = colorStateList;
        j(false);
    }

    public final boolean l(Typeface typeface) {
        ha.a aVar = this.f3607z;
        if (aVar != null) {
            aVar.f5850c = true;
        }
        if (this.f3602u == typeface) {
            return false;
        }
        this.f3602u = typeface;
        Typeface typefaceJ = com.bumptech.glide.e.j(this.f3573a.getContext().getResources().getConfiguration(), typeface);
        this.f3601t = typefaceJ;
        if (typefaceJ == null) {
            typefaceJ = this.f3602u;
        }
        this.f3600s = typefaceJ;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0005 A[PHI: r0
      0x0005: PHI (r0v4 float) = (r0v0 float), (r0v1 float) binds: [B:3:0x0003, B:6:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(float r3) {
        /*
            r2 = this;
            r0 = 0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto L7
        L5:
            r3 = r0
            goto Le
        L7:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto Le
            goto L5
        Le:
            float r0 = r2.f3575b
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 == 0) goto L19
            r2.f3575b = r3
            r2.b()
        L19:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: da.c.m(float):void");
    }

    public final void n(Typeface typeface) {
        boolean z10;
        boolean zL = l(typeface);
        if (this.f3605x != typeface) {
            this.f3605x = typeface;
            Typeface typefaceJ = com.bumptech.glide.e.j(this.f3573a.getContext().getResources().getConfiguration(), typeface);
            this.f3604w = typefaceJ;
            if (typefaceJ == null) {
                typefaceJ = this.f3605x;
            }
            this.f3603v = typefaceJ;
            z10 = true;
        } else {
            z10 = false;
        }
        if (zL || z10) {
            j(false);
        }
    }

    public final boolean o() {
        return this.f3583f0 == 1;
    }
}
