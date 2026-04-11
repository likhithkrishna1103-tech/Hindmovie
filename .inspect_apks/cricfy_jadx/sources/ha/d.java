package ha;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import com.bumptech.glide.e;
import g.j;
import k0.k;
import k9.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f5856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5860e;
    public final float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f5861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f5862h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f5863j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ColorStateList f5864k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f5865l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f5866m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5867n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5868o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Typeface f5869p;

    public d(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, j.TextAppearance);
        this.f5865l = typedArrayObtainStyledAttributes.getDimension(j.TextAppearance_android_textSize, 0.0f);
        this.f5864k = com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, j.TextAppearance_android_textColor);
        com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, j.TextAppearance_android_textColorHint);
        com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, j.TextAppearance_android_textColorLink);
        this.f5859d = typedArrayObtainStyledAttributes.getInt(j.TextAppearance_android_textStyle, 0);
        this.f5860e = typedArrayObtainStyledAttributes.getInt(j.TextAppearance_android_typeface, 1);
        int i10 = j.TextAppearance_fontFamily;
        i10 = typedArrayObtainStyledAttributes.hasValue(i10) ? i10 : j.TextAppearance_android_fontFamily;
        this.f5866m = typedArrayObtainStyledAttributes.getResourceId(i10, 0);
        this.f5857b = typedArrayObtainStyledAttributes.getString(i10);
        typedArrayObtainStyledAttributes.getBoolean(j.TextAppearance_textAllCaps, false);
        this.f5856a = com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, j.TextAppearance_android_shadowColor);
        this.f = typedArrayObtainStyledAttributes.getFloat(j.TextAppearance_android_shadowDx, 0.0f);
        this.f5861g = typedArrayObtainStyledAttributes.getFloat(j.TextAppearance_android_shadowDy, 0.0f);
        this.f5862h = typedArrayObtainStyledAttributes.getFloat(j.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i, l.MaterialTextAppearance);
        this.i = typedArrayObtainStyledAttributes2.hasValue(l.MaterialTextAppearance_android_letterSpacing);
        this.f5863j = typedArrayObtainStyledAttributes2.getFloat(l.MaterialTextAppearance_android_letterSpacing, 0.0f);
        if (Build.VERSION.SDK_INT >= 26) {
            int i11 = l.MaterialTextAppearance_fontVariationSettings;
            this.f5858c = typedArrayObtainStyledAttributes2.getString(typedArrayObtainStyledAttributes2.hasValue(i11) ? i11 : l.MaterialTextAppearance_android_fontVariationSettings);
        }
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.f5869p;
        int i = this.f5859d;
        if (typeface == null && (str = this.f5857b) != null) {
            this.f5869p = Typeface.create(str, i);
        }
        if (this.f5869p == null) {
            int i10 = this.f5860e;
            if (i10 == 1) {
                this.f5869p = Typeface.SANS_SERIF;
            } else if (i10 == 2) {
                this.f5869p = Typeface.SERIF;
            } else if (i10 != 3) {
                this.f5869p = Typeface.DEFAULT;
            } else {
                this.f5869p = Typeface.MONOSPACE;
            }
            this.f5869p = Typeface.create(this.f5869p, i);
        }
    }

    public final void b(Context context, com.bumptech.glide.d dVar) {
        if (!c(context)) {
            a();
        }
        int i = this.f5866m;
        if (i == 0) {
            this.f5867n = true;
        }
        if (this.f5867n) {
            dVar.x(this.f5869p, true);
            return;
        }
        try {
            b bVar = new b(this, dVar);
            ThreadLocal threadLocal = k.f6774a;
            if (context.isRestricted()) {
                bVar.a(-4);
            } else {
                k.b(context, i, new TypedValue(), 0, bVar, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.f5867n = true;
            dVar.w(1);
        } catch (Exception e9) {
            Log.d("TextAppearance", "Error loading font " + this.f5857b, e9);
            this.f5867n = true;
            dVar.w(-3);
        }
    }

    public final boolean c(Context context) {
        Context context2;
        Typeface typefaceB;
        String string;
        Typeface typefaceCreate;
        XmlResourceParser xml;
        if (this.f5867n) {
            return true;
        }
        int i = this.f5866m;
        if (i != 0) {
            ThreadLocal threadLocal = k.f6774a;
            Typeface typefaceCreate2 = null;
            if (context.isRestricted()) {
                context2 = context;
                typefaceB = null;
            } else {
                context2 = context;
                typefaceB = k.b(context2, i, new TypedValue(), 0, null, false, true);
            }
            if (typefaceB != null) {
                this.f5869p = typefaceB;
                this.f5867n = true;
                return true;
            }
            if (!this.f5868o) {
                this.f5868o = true;
                Resources resources = context2.getResources();
                int i10 = this.f5866m;
                if (i10 == 0 || !resources.getResourceTypeName(i10).equals("font")) {
                    string = null;
                    if (string != null && (typefaceCreate = Typeface.create(string, 0)) != Typeface.DEFAULT) {
                        typefaceCreate2 = Typeface.create(typefaceCreate, this.f5859d);
                    }
                } else {
                    try {
                        xml = resources.getXml(i10);
                    } catch (Throwable unused) {
                    }
                    while (xml.getEventType() != 1) {
                        if (xml.getEventType() == 2 && xml.getName().equals("font-family")) {
                            TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), g0.d.FontFamily);
                            string = typedArrayObtainAttributes.getString(g0.d.FontFamily_fontProviderSystemFontFamily);
                            typedArrayObtainAttributes.recycle();
                            break;
                        }
                        xml.next();
                        string = null;
                    }
                    string = null;
                    if (string != null) {
                        typefaceCreate2 = Typeface.create(typefaceCreate, this.f5859d);
                    }
                }
            }
            if (typefaceCreate2 != null) {
                this.f5869p = typefaceCreate2;
                this.f5867n = true;
                return true;
            }
        }
        return false;
    }

    public final void d(Context context, TextPaint textPaint, com.bumptech.glide.d dVar) {
        e(context, textPaint, dVar);
        ColorStateList colorStateList = this.f5864k;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f5856a;
        textPaint.setShadowLayer(this.f5862h, this.f, this.f5861g, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void e(Context context, TextPaint textPaint, com.bumptech.glide.d dVar) {
        Typeface typeface;
        if (c(context) && this.f5867n && (typeface = this.f5869p) != null) {
            f(context, textPaint, typeface);
            return;
        }
        a();
        f(context, textPaint, this.f5869p);
        b(context, new c(this, context, textPaint, dVar));
    }

    public final void f(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceJ = e.j(context.getResources().getConfiguration(), typeface);
        if (typefaceJ != null) {
            typeface = typefaceJ;
        }
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.f5859d;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f5865l);
        if (Build.VERSION.SDK_INT >= 26) {
            textPaint.setFontVariationSettings(this.f5858c);
        }
        if (this.i) {
            textPaint.setLetterSpacing(this.f5863j);
        }
    }
}
