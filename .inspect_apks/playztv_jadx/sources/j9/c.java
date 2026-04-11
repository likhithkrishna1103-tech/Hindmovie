package j9;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
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
import java.util.WeakHashMap;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public CharSequence A;
    public CharSequence B;
    public boolean C;
    public Bitmap E;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public int K;
    public int[] L;
    public boolean M;
    public final TextPaint N;
    public final TextPaint O;
    public TimeInterpolator P;
    public TimeInterpolator Q;
    public float R;
    public float S;
    public float T;
    public ColorStateList U;
    public float V;
    public float W;
    public float X;
    public StaticLayout Y;
    public float Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f6845a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f6846a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f6847b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f6848b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f6849c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public CharSequence f6850c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f6851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f6853e;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f6858j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f6859k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f6860l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f6861m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f6862n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f6863o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f6864p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f6865q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Typeface f6866r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Typeface f6867s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Typeface f6868t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Typeface f6869u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Typeface f6870v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Typeface f6871w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Typeface f6872x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public n9.a f6873y;
    public int f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6856g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f6857h = 15.0f;
    public float i = 15.0f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextUtils.TruncateAt f6874z = TextUtils.TruncateAt.END;
    public final boolean D = true;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final int f6852d0 = 1;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final float f6854e0 = 1.0f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final int f6855f0 = 1;

    public c(TextInputLayout textInputLayout) {
        this.f6845a = textInputLayout;
        TextPaint textPaint = new TextPaint(129);
        this.N = textPaint;
        this.O = new TextPaint(textPaint);
        this.f6851d = new Rect();
        this.f6849c = new Rect();
        this.f6853e = new RectF();
        g(textInputLayout.getContext().getResources().getConfiguration());
    }

    public static int a(float f, int i, int i10) {
        float f4 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i10) * f) + (Color.alpha(i) * f4)), Math.round((Color.red(i10) * f) + (Color.red(i) * f4)), Math.round((Color.green(i10) * f) + (Color.green(i) * f4)), Math.round((Color.blue(i10) * f) + (Color.blue(i) * f4)));
    }

    public static float f(float f, float f4, float f10, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f10 = timeInterpolator.getInterpolation(f10);
        }
        return q8.a.a(f, f4, f10);
    }

    public final boolean b(CharSequence charSequence) {
        WeakHashMap weakHashMap = o0.f10475a;
        boolean z2 = this.f6845a.getLayoutDirection() == 1;
        if (this.D) {
            return (z2 ? o0.g.f9048d : o0.g.f9047c).h(charSequence, charSequence.length());
        }
        return z2;
    }

    public final void c(float f, boolean z2) {
        float f4;
        float f10;
        Typeface typeface;
        boolean z10;
        Layout.Alignment alignment;
        if (this.A == null) {
            return;
        }
        float fWidth = this.f6851d.width();
        float fWidth2 = this.f6849c.width();
        if (Math.abs(f - 1.0f) < 1.0E-5f) {
            f4 = this.i;
            f10 = this.V;
            this.F = 1.0f;
            typeface = this.f6866r;
        } else {
            float f11 = this.f6857h;
            float f12 = this.W;
            Typeface typeface2 = this.f6869u;
            if (Math.abs(f - 0.0f) < 1.0E-5f) {
                this.F = 1.0f;
            } else {
                this.F = f(this.f6857h, this.i, f, this.Q) / this.f6857h;
            }
            float f13 = this.i / this.f6857h;
            fWidth = (z2 || fWidth2 * f13 <= fWidth) ? fWidth2 : Math.min(fWidth / f13, fWidth2);
            f4 = f11;
            f10 = f12;
            typeface = typeface2;
        }
        TextPaint textPaint = this.N;
        if (fWidth > 0.0f) {
            boolean z11 = this.G != f4;
            boolean z12 = this.X != f10;
            boolean z13 = this.f6872x != typeface;
            StaticLayout staticLayout = this.Y;
            boolean z14 = z11 || z12 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1 : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z13 || this.M;
            this.G = f4;
            this.X = f10;
            this.f6872x = typeface;
            this.M = false;
            textPaint.setLinearText(this.F != 1.0f);
            z10 = z14;
        } else {
            z10 = false;
        }
        if (this.B == null || z10) {
            textPaint.setTextSize(this.G);
            textPaint.setTypeface(this.f6872x);
            textPaint.setLetterSpacing(this.X);
            boolean zB = b(this.A);
            this.C = zB;
            int i = this.f6852d0;
            if (i <= 1 || zB) {
                i = 1;
            }
            if (i == 1) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                int absoluteGravity = Gravity.getAbsoluteGravity(this.f, zB ? 1 : 0) & 7;
                alignment = absoluteGravity != 1 ? absoluteGravity != 5 ? this.C ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.C ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
            }
            y yVar = new y(this.A, textPaint, (int) fWidth);
            yVar.f6921k = this.f6874z;
            yVar.f6920j = zB;
            yVar.f6917e = alignment;
            yVar.i = false;
            yVar.f = i;
            yVar.f6918g = this.f6854e0;
            yVar.f6919h = this.f6855f0;
            StaticLayout staticLayoutA = yVar.a();
            staticLayoutA.getClass();
            this.Y = staticLayoutA;
            this.B = staticLayoutA.getText();
        }
    }

    public final float d() {
        float f = this.i;
        TextPaint textPaint = this.O;
        textPaint.setTextSize(f);
        textPaint.setTypeface(this.f6866r);
        textPaint.setLetterSpacing(this.V);
        return -textPaint.ascent();
    }

    public final int e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.L;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void g(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f6868t;
            if (typeface != null) {
                this.f6867s = b8.h.t(configuration, typeface);
            }
            Typeface typeface2 = this.f6871w;
            if (typeface2 != null) {
                this.f6870v = b8.h.t(configuration, typeface2);
            }
            Typeface typeface3 = this.f6867s;
            if (typeface3 == null) {
                typeface3 = this.f6868t;
            }
            this.f6866r = typeface3;
            Typeface typeface4 = this.f6870v;
            if (typeface4 == null) {
                typeface4 = this.f6871w;
            }
            this.f6869u = typeface4;
            h(true);
        }
    }

    public final void h(boolean z2) {
        float fMeasureText;
        StaticLayout staticLayout;
        TextInputLayout textInputLayout = this.f6845a;
        if ((textInputLayout.getHeight() <= 0 || textInputLayout.getWidth() <= 0) && !z2) {
            return;
        }
        c(1.0f, z2);
        CharSequence charSequence = this.B;
        TextPaint textPaint = this.N;
        if (charSequence != null && (staticLayout = this.Y) != null) {
            this.f6850c0 = TextUtils.ellipsize(charSequence, textPaint, staticLayout.getWidth(), this.f6874z);
        }
        CharSequence charSequence2 = this.f6850c0;
        if (charSequence2 != null) {
            this.Z = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.Z = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f6856g, this.C ? 1 : 0);
        int i = absoluteGravity & 112;
        Rect rect = this.f6851d;
        if (i == 48) {
            this.f6861m = rect.top;
        } else if (i != 80) {
            this.f6861m = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f6861m = textPaint.ascent() + rect.bottom;
        }
        int i10 = absoluteGravity & 8388615;
        if (i10 == 1) {
            this.f6863o = rect.centerX() - (this.Z / 2.0f);
        } else if (i10 != 5) {
            this.f6863o = rect.left;
        } else {
            this.f6863o = rect.right - this.Z;
        }
        c(0.0f, z2);
        float height = this.Y != null ? r1.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.Y;
        if (staticLayout2 == null || this.f6852d0 <= 1) {
            CharSequence charSequence3 = this.B;
            fMeasureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            fMeasureText = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.Y;
        if (staticLayout3 != null) {
            staticLayout3.getLineCount();
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f, this.C ? 1 : 0);
        int i11 = absoluteGravity2 & 112;
        Rect rect2 = this.f6849c;
        if (i11 == 48) {
            this.f6860l = rect2.top;
        } else if (i11 != 80) {
            this.f6860l = rect2.centerY() - (height / 2.0f);
        } else {
            this.f6860l = textPaint.descent() + (rect2.bottom - height);
        }
        int i12 = absoluteGravity2 & 8388615;
        if (i12 == 1) {
            this.f6862n = rect2.centerX() - (fMeasureText / 2.0f);
        } else if (i12 != 5) {
            this.f6862n = rect2.left;
        } else {
            this.f6862n = rect2.right - fMeasureText;
        }
        Bitmap bitmap = this.E;
        if (bitmap != null) {
            bitmap.recycle();
            this.E = null;
        }
        l(this.f6847b);
        float f = this.f6847b;
        float f4 = f(rect2.left, rect.left, f, this.P);
        RectF rectF = this.f6853e;
        rectF.left = f4;
        rectF.top = f(this.f6860l, this.f6861m, f, this.P);
        rectF.right = f(rect2.right, rect.right, f, this.P);
        rectF.bottom = f(rect2.bottom, rect.bottom, f, this.P);
        this.f6864p = f(this.f6862n, this.f6863o, f, this.P);
        this.f6865q = f(this.f6860l, this.f6861m, f, this.P);
        l(f);
        k1.a aVar = q8.a.f11073b;
        this.f6846a0 = 1.0f - f(0.0f, 1.0f, 1.0f - f, aVar);
        WeakHashMap weakHashMap = o0.f10475a;
        textInputLayout.postInvalidateOnAnimation();
        this.f6848b0 = f(1.0f, 0.0f, f, aVar);
        textInputLayout.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.f6859k;
        ColorStateList colorStateList2 = this.f6858j;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(f, e(colorStateList2), e(this.f6859k)));
        } else {
            textPaint.setColor(e(colorStateList));
        }
        float f10 = this.V;
        float f11 = this.W;
        if (f10 != f11) {
            textPaint.setLetterSpacing(f(f11, f10, f, aVar));
        } else {
            textPaint.setLetterSpacing(f10);
        }
        this.H = q8.a.a(0.0f, this.R, f);
        this.I = q8.a.a(0.0f, this.S, f);
        this.J = q8.a.a(0.0f, this.T, f);
        int iA = a(f, 0, e(this.U));
        this.K = iA;
        textPaint.setShadowLayer(this.H, this.I, this.J, iA);
        textInputLayout.postInvalidateOnAnimation();
    }

    public final void i(ColorStateList colorStateList) {
        if (this.f6859k == colorStateList && this.f6858j == colorStateList) {
            return;
        }
        this.f6859k = colorStateList;
        this.f6858j = colorStateList;
        h(false);
    }

    public final boolean j(Typeface typeface) {
        n9.a aVar = this.f6873y;
        if (aVar != null) {
            aVar.f8855c = true;
        }
        if (this.f6868t == typeface) {
            return false;
        }
        this.f6868t = typeface;
        Typeface typefaceT = b8.h.t(this.f6845a.getContext().getResources().getConfiguration(), typeface);
        this.f6867s = typefaceT;
        if (typefaceT == null) {
            typefaceT = this.f6868t;
        }
        this.f6866r = typefaceT;
        return true;
    }

    public final void k(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.f6847b) {
            this.f6847b = f;
            float f4 = this.f6849c.left;
            Rect rect = this.f6851d;
            float f10 = f(f4, rect.left, f, this.P);
            RectF rectF = this.f6853e;
            rectF.left = f10;
            rectF.top = f(this.f6860l, this.f6861m, f, this.P);
            rectF.right = f(r1.right, rect.right, f, this.P);
            rectF.bottom = f(r1.bottom, rect.bottom, f, this.P);
            this.f6864p = f(this.f6862n, this.f6863o, f, this.P);
            this.f6865q = f(this.f6860l, this.f6861m, f, this.P);
            l(f);
            k1.a aVar = q8.a.f11073b;
            this.f6846a0 = 1.0f - f(0.0f, 1.0f, 1.0f - f, aVar);
            WeakHashMap weakHashMap = o0.f10475a;
            TextInputLayout textInputLayout = this.f6845a;
            textInputLayout.postInvalidateOnAnimation();
            this.f6848b0 = f(1.0f, 0.0f, f, aVar);
            textInputLayout.postInvalidateOnAnimation();
            ColorStateList colorStateList = this.f6859k;
            ColorStateList colorStateList2 = this.f6858j;
            TextPaint textPaint = this.N;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(a(f, e(colorStateList2), e(this.f6859k)));
            } else {
                textPaint.setColor(e(colorStateList));
            }
            float f11 = this.V;
            float f12 = this.W;
            if (f11 != f12) {
                textPaint.setLetterSpacing(f(f12, f11, f, aVar));
            } else {
                textPaint.setLetterSpacing(f11);
            }
            this.H = q8.a.a(0.0f, this.R, f);
            this.I = q8.a.a(0.0f, this.S, f);
            this.J = q8.a.a(0.0f, this.T, f);
            int iA = a(f, 0, e(this.U));
            this.K = iA;
            textPaint.setShadowLayer(this.H, this.I, this.J, iA);
            textInputLayout.postInvalidateOnAnimation();
        }
    }

    public final void l(float f) {
        c(f, false);
        WeakHashMap weakHashMap = o0.f10475a;
        this.f6845a.postInvalidateOnAnimation();
    }

    public final void m(Typeface typeface) {
        boolean z2;
        boolean zJ = j(typeface);
        if (this.f6871w != typeface) {
            this.f6871w = typeface;
            Typeface typefaceT = b8.h.t(this.f6845a.getContext().getResources().getConfiguration(), typeface);
            this.f6870v = typefaceT;
            if (typefaceT == null) {
                typefaceT = this.f6871w;
            }
            this.f6869u = typefaceT;
            z2 = true;
        } else {
            z2 = false;
        }
        if (zJ || z2) {
            h(false);
        }
    }
}
