package n;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f8573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d3 f8574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d3 f8575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d3 f8576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d3 f8577e;
    public d3 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d3 f8578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d3 f8579h;
    public final i1 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f8580j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8581k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Typeface f8582l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8583m;

    public y0(TextView textView) {
        this.f8573a = textView;
        this.i = new i1(textView);
    }

    public static d3 c(Context context, t tVar, int i) {
        ColorStateList colorStateListI;
        synchronized (tVar) {
            colorStateListI = tVar.f8534a.i(context, i);
        }
        if (colorStateListI == null) {
            return null;
        }
        d3 d3Var = new d3();
        d3Var.f8374b = true;
        d3Var.f8375c = colorStateListI;
        return d3Var;
    }

    public static void h(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i >= 30) {
            s0.b.a(editorInfo, text);
            return;
        }
        text.getClass();
        if (i >= 30) {
            s0.b.a(editorInfo, text);
            return;
        }
        int i10 = editorInfo.initialSelStart;
        int i11 = editorInfo.initialSelEnd;
        int i12 = i10 > i11 ? i11 : i10;
        if (i10 <= i11) {
            i10 = i11;
        }
        int length = text.length();
        if (i12 < 0 || i10 > length) {
            s0.c.a(editorInfo, null, 0, 0);
            return;
        }
        int i13 = editorInfo.inputType & 4095;
        if (i13 == 129 || i13 == 225 || i13 == 18) {
            s0.c.a(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            s0.c.a(editorInfo, text, i12, i10);
            return;
        }
        int i14 = i10 - i12;
        int i15 = i14 > 1024 ? 0 : i14;
        int i16 = 2048 - i15;
        int iMin = Math.min(text.length() - i10, i16 - Math.min(i12, (int) (((double) i16) * 0.8d)));
        int iMin2 = Math.min(i12, i16 - iMin);
        int i17 = i12 - iMin2;
        if (Character.isLowSurrogate(text.charAt(i17))) {
            i17++;
            iMin2--;
        }
        if (Character.isHighSurrogate(text.charAt((i10 + iMin) - 1))) {
            iMin--;
        }
        int i18 = iMin2 + i15;
        s0.c.a(editorInfo, i15 != i14 ? TextUtils.concat(text.subSequence(i17, i17 + iMin2), text.subSequence(i10, iMin + i10)) : text.subSequence(i17, i18 + iMin + i17), iMin2, i18);
    }

    public final void a(Drawable drawable, d3 d3Var) {
        if (drawable == null || d3Var == null) {
            return;
        }
        t.e(drawable, d3Var, this.f8573a.getDrawableState());
    }

    public final void b() {
        d3 d3Var = this.f8574b;
        TextView textView = this.f8573a;
        if (d3Var != null || this.f8575c != null || this.f8576d != null || this.f8577e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f8574b);
            a(compoundDrawables[1], this.f8575c);
            a(compoundDrawables[2], this.f8576d);
            a(compoundDrawables[3], this.f8577e);
        }
        if (this.f == null && this.f8578g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f);
        a(compoundDrawablesRelative[2], this.f8578g);
    }

    public final ColorStateList d() {
        d3 d3Var = this.f8579h;
        if (d3Var != null) {
            return (ColorStateList) d3Var.f8375c;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        d3 d3Var = this.f8579h;
        if (d3Var != null) {
            return (PorterDuff.Mode) d3Var.f8376d;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:240:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:255:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.util.AttributeSet r20, int r21) {
        /*
            Method dump skipped, instruction units count: 1085
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.y0.f(android.util.AttributeSet, int):void");
    }

    public final void g(Context context, int i) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, g.j.TextAppearance);
        kc.b bVar = new kc.b(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(g.j.TextAppearance_textAllCaps);
        TextView textView = this.f8573a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(g.j.TextAppearance_textAllCaps, false));
        }
        int i10 = Build.VERSION.SDK_INT;
        if (typedArrayObtainStyledAttributes.hasValue(g.j.TextAppearance_android_textSize) && typedArrayObtainStyledAttributes.getDimensionPixelSize(g.j.TextAppearance_android_textSize, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, bVar);
        if (i10 >= 26 && typedArrayObtainStyledAttributes.hasValue(g.j.TextAppearance_fontVariationSettings) && (string = typedArrayObtainStyledAttributes.getString(g.j.TextAppearance_fontVariationSettings)) != null) {
            w0.d(textView, string);
        }
        bVar.E();
        Typeface typeface = this.f8582l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f8580j);
        }
    }

    public final void i(int i, int i10, int i11, int i12) {
        i1 i1Var = this.i;
        if (i1Var.j()) {
            DisplayMetrics displayMetrics = i1Var.f8409j.getResources().getDisplayMetrics();
            i1Var.k(TypedValue.applyDimension(i12, i, displayMetrics), TypedValue.applyDimension(i12, i10, displayMetrics), TypedValue.applyDimension(i12, i11, displayMetrics));
            if (i1Var.h()) {
                i1Var.a();
            }
        }
    }

    public final void j(int[] iArr, int i) {
        i1 i1Var = this.i;
        if (i1Var.j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = i1Var.f8409j.getResources().getDisplayMetrics();
                    for (int i10 = 0; i10 < length; i10++) {
                        iArrCopyOf[i10] = Math.round(TypedValue.applyDimension(i, iArr[i10], displayMetrics));
                    }
                }
                i1Var.f = i1.b(iArrCopyOf);
                if (!i1Var.i()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                i1Var.f8407g = false;
            }
            if (i1Var.h()) {
                i1Var.a();
            }
        }
    }

    public final void k(int i) {
        i1 i1Var = this.i;
        if (i1Var.j()) {
            if (i == 0) {
                i1Var.f8402a = 0;
                i1Var.f8405d = -1.0f;
                i1Var.f8406e = -1.0f;
                i1Var.f8404c = -1.0f;
                i1Var.f = new int[0];
                i1Var.f8403b = false;
                return;
            }
            if (i != 1) {
                throw new IllegalArgumentException(e6.j.l("Unknown auto-size text type: ", i));
            }
            DisplayMetrics displayMetrics = i1Var.f8409j.getResources().getDisplayMetrics();
            i1Var.k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (i1Var.h()) {
                i1Var.a();
            }
        }
    }

    public final void l(ColorStateList colorStateList) {
        if (this.f8579h == null) {
            this.f8579h = new d3();
        }
        d3 d3Var = this.f8579h;
        d3Var.f8375c = colorStateList;
        d3Var.f8374b = colorStateList != null;
        this.f8574b = d3Var;
        this.f8575c = d3Var;
        this.f8576d = d3Var;
        this.f8577e = d3Var;
        this.f = d3Var;
        this.f8578g = d3Var;
    }

    public final void m(PorterDuff.Mode mode) {
        if (this.f8579h == null) {
            this.f8579h = new d3();
        }
        d3 d3Var = this.f8579h;
        d3Var.f8376d = mode;
        d3Var.f8373a = mode != null;
        this.f8574b = d3Var;
        this.f8575c = d3Var;
        this.f8576d = d3Var;
        this.f8577e = d3Var;
        this.f = d3Var;
        this.f8578g = d3Var;
    }

    public final void n(Context context, kc.b bVar) {
        String string;
        int i = g.j.TextAppearance_android_textStyle;
        int i10 = this.f8580j;
        TypedArray typedArray = (TypedArray) bVar.f7621w;
        this.f8580j = typedArray.getInt(i, i10);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            int i12 = typedArray.getInt(g.j.TextAppearance_android_textFontWeight, -1);
            this.f8581k = i12;
            if (i12 != -1) {
                this.f8580j &= 2;
            }
        }
        if (!typedArray.hasValue(g.j.TextAppearance_android_fontFamily) && !typedArray.hasValue(g.j.TextAppearance_fontFamily)) {
            if (typedArray.hasValue(g.j.TextAppearance_android_typeface)) {
                this.f8583m = false;
                int i13 = typedArray.getInt(g.j.TextAppearance_android_typeface, 1);
                if (i13 == 1) {
                    this.f8582l = Typeface.SANS_SERIF;
                    return;
                } else if (i13 == 2) {
                    this.f8582l = Typeface.SERIF;
                    return;
                } else {
                    if (i13 != 3) {
                        return;
                    }
                    this.f8582l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f8582l = null;
        int i14 = typedArray.hasValue(g.j.TextAppearance_fontFamily) ? g.j.TextAppearance_fontFamily : g.j.TextAppearance_android_fontFamily;
        int i15 = this.f8581k;
        int i16 = this.f8580j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceU = bVar.u(i14, this.f8580j, new s0(this, i15, i16, new WeakReference(this.f8573a)));
                if (typefaceU != null) {
                    if (i11 < 28 || this.f8581k == -1) {
                        this.f8582l = typefaceU;
                    } else {
                        this.f8582l = x0.a(Typeface.create(typefaceU, 0), this.f8581k, (this.f8580j & 2) != 0);
                    }
                }
                this.f8583m = this.f8582l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f8582l != null || (string = typedArray.getString(i14)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f8581k == -1) {
            this.f8582l = Typeface.create(string, this.f8580j);
        } else {
            this.f8582l = x0.a(Typeface.create(string, 0), this.f8581k, (this.f8580j & 2) != 0);
        }
    }
}
