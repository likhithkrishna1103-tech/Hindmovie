package o;

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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f9386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kf.j f9387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kf.j f9388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public kf.j f9389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public kf.j f9390e;
    public kf.j f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public kf.j f9391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kf.j f9392h;
    public final f1 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9393j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9394k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Typeface f9395l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f9396m;

    public w0(TextView textView) {
        this.f9386a = textView;
        this.i = new f1(textView);
    }

    public static kf.j c(Context context, r rVar, int i) {
        ColorStateList colorStateListI;
        synchronized (rVar) {
            colorStateListI = rVar.f9337a.i(context, i);
        }
        if (colorStateListI == null) {
            return null;
        }
        kf.j jVar = new kf.j();
        jVar.f7485b = true;
        jVar.f7486c = colorStateListI;
        return jVar;
    }

    public static void h(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i >= 30) {
            v0.b.a(editorInfo, text);
            return;
        }
        text.getClass();
        if (i >= 30) {
            v0.b.a(editorInfo, text);
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
            v0.c.a(editorInfo, null, 0, 0);
            return;
        }
        int i13 = editorInfo.inputType & 4095;
        if (i13 == 129 || i13 == 225 || i13 == 18) {
            v0.c.a(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            v0.c.a(editorInfo, text, i12, i10);
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
        v0.c.a(editorInfo, i15 != i14 ? TextUtils.concat(text.subSequence(i17, i17 + iMin2), text.subSequence(i10, iMin + i10)) : text.subSequence(i17, i18 + iMin + i17), iMin2, i18);
    }

    public final void a(Drawable drawable, kf.j jVar) {
        if (drawable == null || jVar == null) {
            return;
        }
        r.e(drawable, jVar, this.f9386a.getDrawableState());
    }

    public final void b() {
        kf.j jVar = this.f9387b;
        TextView textView = this.f9386a;
        if (jVar != null || this.f9388c != null || this.f9389d != null || this.f9390e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f9387b);
            a(compoundDrawables[1], this.f9388c);
            a(compoundDrawables[2], this.f9389d);
            a(compoundDrawables[3], this.f9390e);
        }
        if (this.f == null && this.f9391g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f);
        a(compoundDrawablesRelative[2], this.f9391g);
    }

    public final ColorStateList d() {
        kf.j jVar = this.f9392h;
        if (jVar != null) {
            return (ColorStateList) jVar.f7486c;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        kf.j jVar = this.f9392h;
        if (jVar != null) {
            return (PorterDuff.Mode) jVar.f7487d;
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
        throw new UnsupportedOperationException("Method not decompiled: o.w0.f(android.util.AttributeSet, int):void");
    }

    public final void g(Context context, int i) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, g.j.TextAppearance);
        l7.a aVar = new l7.a(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(g.j.TextAppearance_textAllCaps);
        TextView textView = this.f9386a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(g.j.TextAppearance_textAllCaps, false));
        }
        int i10 = Build.VERSION.SDK_INT;
        if (typedArrayObtainStyledAttributes.hasValue(g.j.TextAppearance_android_textSize) && typedArrayObtainStyledAttributes.getDimensionPixelSize(g.j.TextAppearance_android_textSize, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, aVar);
        if (i10 >= 26 && typedArrayObtainStyledAttributes.hasValue(g.j.TextAppearance_fontVariationSettings) && (string = typedArrayObtainStyledAttributes.getString(g.j.TextAppearance_fontVariationSettings)) != null) {
            u0.d(textView, string);
        }
        aVar.G();
        Typeface typeface = this.f9395l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f9393j);
        }
    }

    public final void i(int i, int i10, int i11, int i12) {
        f1 f1Var = this.i;
        if (f1Var.j()) {
            DisplayMetrics displayMetrics = f1Var.f9216j.getResources().getDisplayMetrics();
            f1Var.k(TypedValue.applyDimension(i12, i, displayMetrics), TypedValue.applyDimension(i12, i10, displayMetrics), TypedValue.applyDimension(i12, i11, displayMetrics));
            if (f1Var.h()) {
                f1Var.a();
            }
        }
    }

    public final void j(int[] iArr, int i) {
        f1 f1Var = this.i;
        if (f1Var.j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = f1Var.f9216j.getResources().getDisplayMetrics();
                    for (int i10 = 0; i10 < length; i10++) {
                        iArrCopyOf[i10] = Math.round(TypedValue.applyDimension(i, iArr[i10], displayMetrics));
                    }
                }
                f1Var.f = f1.b(iArrCopyOf);
                if (!f1Var.i()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                f1Var.f9214g = false;
            }
            if (f1Var.h()) {
                f1Var.a();
            }
        }
    }

    public final void k(int i) {
        f1 f1Var = this.i;
        if (f1Var.j()) {
            if (i == 0) {
                f1Var.f9209a = 0;
                f1Var.f9212d = -1.0f;
                f1Var.f9213e = -1.0f;
                f1Var.f9211c = -1.0f;
                f1Var.f = new int[0];
                f1Var.f9210b = false;
                return;
            }
            if (i != 1) {
                throw new IllegalArgumentException(l0.e.g(i, "Unknown auto-size text type: "));
            }
            DisplayMetrics displayMetrics = f1Var.f9216j.getResources().getDisplayMetrics();
            f1Var.k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (f1Var.h()) {
                f1Var.a();
            }
        }
    }

    public final void l(ColorStateList colorStateList) {
        if (this.f9392h == null) {
            this.f9392h = new kf.j();
        }
        kf.j jVar = this.f9392h;
        jVar.f7486c = colorStateList;
        jVar.f7485b = colorStateList != null;
        this.f9387b = jVar;
        this.f9388c = jVar;
        this.f9389d = jVar;
        this.f9390e = jVar;
        this.f = jVar;
        this.f9391g = jVar;
    }

    public final void m(PorterDuff.Mode mode) {
        if (this.f9392h == null) {
            this.f9392h = new kf.j();
        }
        kf.j jVar = this.f9392h;
        jVar.f7487d = mode;
        jVar.f7484a = mode != null;
        this.f9387b = jVar;
        this.f9388c = jVar;
        this.f9389d = jVar;
        this.f9390e = jVar;
        this.f = jVar;
        this.f9391g = jVar;
    }

    public final void n(Context context, l7.a aVar) {
        String string;
        int i = g.j.TextAppearance_android_textStyle;
        int i10 = this.f9393j;
        TypedArray typedArray = (TypedArray) aVar.f7867x;
        this.f9393j = typedArray.getInt(i, i10);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            int i12 = typedArray.getInt(g.j.TextAppearance_android_textFontWeight, -1);
            this.f9394k = i12;
            if (i12 != -1) {
                this.f9393j &= 2;
            }
        }
        if (!typedArray.hasValue(g.j.TextAppearance_android_fontFamily) && !typedArray.hasValue(g.j.TextAppearance_fontFamily)) {
            if (typedArray.hasValue(g.j.TextAppearance_android_typeface)) {
                this.f9396m = false;
                int i13 = typedArray.getInt(g.j.TextAppearance_android_typeface, 1);
                if (i13 == 1) {
                    this.f9395l = Typeface.SANS_SERIF;
                    return;
                } else if (i13 == 2) {
                    this.f9395l = Typeface.SERIF;
                    return;
                } else {
                    if (i13 != 3) {
                        return;
                    }
                    this.f9395l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f9395l = null;
        int i14 = typedArray.hasValue(g.j.TextAppearance_fontFamily) ? g.j.TextAppearance_fontFamily : g.j.TextAppearance_android_fontFamily;
        int i15 = this.f9394k;
        int i16 = this.f9393j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceW = aVar.w(i14, this.f9393j, new q0(this, i15, i16, new WeakReference(this.f9386a)));
                if (typefaceW != null) {
                    if (i11 < 28 || this.f9394k == -1) {
                        this.f9395l = typefaceW;
                    } else {
                        this.f9395l = v0.a(Typeface.create(typefaceW, 0), this.f9394k, (this.f9393j & 2) != 0);
                    }
                }
                this.f9396m = this.f9395l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f9395l != null || (string = typedArray.getString(i14)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f9394k == -1) {
            this.f9395l = Typeface.create(string, this.f9393j);
        } else {
            this.f9395l = v0.a(Typeface.create(string, 0), this.f9394k, (this.f9393j & 2) != 0);
        }
    }
}
