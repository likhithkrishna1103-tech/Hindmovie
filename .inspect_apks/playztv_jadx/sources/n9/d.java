package n9;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import b8.h;
import h0.k;
import p8.l;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f8861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f8865e;
    public final float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f8866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f8867h;
    public final float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ColorStateList f8868j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f8869k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f8870l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8871m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Typeface f8872n;

    public d(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, l.TextAppearance);
        this.f8869k = typedArrayObtainStyledAttributes.getDimension(l.TextAppearance_android_textSize, 0.0f);
        this.f8868j = a.a.i(context, typedArrayObtainStyledAttributes, l.TextAppearance_android_textColor);
        a.a.i(context, typedArrayObtainStyledAttributes, l.TextAppearance_android_textColorHint);
        a.a.i(context, typedArrayObtainStyledAttributes, l.TextAppearance_android_textColorLink);
        this.f8863c = typedArrayObtainStyledAttributes.getInt(l.TextAppearance_android_textStyle, 0);
        this.f8864d = typedArrayObtainStyledAttributes.getInt(l.TextAppearance_android_typeface, 1);
        int i10 = l.TextAppearance_fontFamily;
        i10 = typedArrayObtainStyledAttributes.hasValue(i10) ? i10 : l.TextAppearance_android_fontFamily;
        this.f8870l = typedArrayObtainStyledAttributes.getResourceId(i10, 0);
        this.f8862b = typedArrayObtainStyledAttributes.getString(i10);
        typedArrayObtainStyledAttributes.getBoolean(l.TextAppearance_textAllCaps, false);
        this.f8861a = a.a.i(context, typedArrayObtainStyledAttributes, l.TextAppearance_android_shadowColor);
        this.f8865e = typedArrayObtainStyledAttributes.getFloat(l.TextAppearance_android_shadowDx, 0.0f);
        this.f = typedArrayObtainStyledAttributes.getFloat(l.TextAppearance_android_shadowDy, 0.0f);
        this.f8866g = typedArrayObtainStyledAttributes.getFloat(l.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i, l.MaterialTextAppearance);
        this.f8867h = typedArrayObtainStyledAttributes2.hasValue(l.MaterialTextAppearance_android_letterSpacing);
        this.i = typedArrayObtainStyledAttributes2.getFloat(l.MaterialTextAppearance_android_letterSpacing, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.f8872n;
        int i = this.f8863c;
        if (typeface == null && (str = this.f8862b) != null) {
            this.f8872n = Typeface.create(str, i);
        }
        if (this.f8872n == null) {
            int i10 = this.f8864d;
            if (i10 == 1) {
                this.f8872n = Typeface.SANS_SERIF;
            } else if (i10 == 2) {
                this.f8872n = Typeface.SERIF;
            } else if (i10 != 3) {
                this.f8872n = Typeface.DEFAULT;
            } else {
                this.f8872n = Typeface.MONOSPACE;
            }
            this.f8872n = Typeface.create(this.f8872n, i);
        }
    }

    public final Typeface b(Context context) {
        if (this.f8871m) {
            return this.f8872n;
        }
        if (!context.isRestricted()) {
            try {
                int i = this.f8870l;
                ThreadLocal threadLocal = k.f5599a;
                Typeface typefaceB = context.isRestricted() ? null : k.b(context, i, new TypedValue(), 0, null, false, false);
                this.f8872n = typefaceB;
                if (typefaceB != null) {
                    this.f8872n = Typeface.create(typefaceB, this.f8863c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e10) {
                Log.d("TextAppearance", "Error loading font " + this.f8862b, e10);
            }
        }
        a();
        this.f8871m = true;
        return this.f8872n;
    }

    public final void c(Context context, android.support.v4.media.session.b bVar) {
        if (d(context)) {
            b(context);
        } else {
            a();
        }
        int i = this.f8870l;
        if (i == 0) {
            this.f8871m = true;
        }
        if (this.f8871m) {
            bVar.J(this.f8872n, true);
            return;
        }
        try {
            b bVar2 = new b(this, bVar);
            ThreadLocal threadLocal = k.f5599a;
            if (context.isRestricted()) {
                bVar2.a(-4);
            } else {
                k.b(context, i, new TypedValue(), 0, bVar2, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.f8871m = true;
            bVar.I(1);
        } catch (Exception e10) {
            Log.d("TextAppearance", "Error loading font " + this.f8862b, e10);
            this.f8871m = true;
            bVar.I(-3);
        }
    }

    public final boolean d(Context context) {
        Typeface typefaceB = null;
        int i = this.f8870l;
        if (i != 0) {
            ThreadLocal threadLocal = k.f5599a;
            if (!context.isRestricted()) {
                typefaceB = k.b(context, i, new TypedValue(), 0, null, false, true);
            }
        }
        return typefaceB != null;
    }

    public final void e(Context context, TextPaint textPaint, android.support.v4.media.session.b bVar) {
        f(context, textPaint, bVar);
        ColorStateList colorStateList = this.f8868j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f8861a;
        textPaint.setShadowLayer(this.f8866g, this.f8865e, this.f, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void f(Context context, TextPaint textPaint, android.support.v4.media.session.b bVar) {
        if (d(context)) {
            g(context, textPaint, b(context));
            return;
        }
        a();
        g(context, textPaint, this.f8872n);
        c(context, new c(this, context, textPaint, bVar));
    }

    public final void g(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceT = h.t(context.getResources().getConfiguration(), typeface);
        if (typefaceT != null) {
            typeface = typefaceT;
        }
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.f8863c;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f8869k);
        if (this.f8867h) {
            textPaint.setLetterSpacing(this.i);
        }
    }
}
