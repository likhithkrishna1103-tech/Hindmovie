package k0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float[][] f6751a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[][] f6752b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float[] f6753c = {95.047f, 100.0f, 108.883f};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float[][] f6754d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f6755e = new Object();
    public static Method f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f6756g;

    public static f3.a b(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i) {
        f3.a aVarD;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i10 = typedValue.type;
            if (i10 >= 28 && i10 <= 31) {
                return new f3.a((Shader) null, (ColorStateList) null, typedValue.data);
            }
            try {
                aVarD = f3.a.d(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            } catch (Exception e9) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e9);
                aVarD = null;
            }
            if (aVarD != null) {
                return aVarD;
            }
        }
        return new f3.a((Shader) null, (ColorStateList) null, 0);
    }

    public static String c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (d(xmlPullParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    public static boolean d(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int e(float f10) {
        if (f10 < 1.0f) {
            return -16777216;
        }
        if (f10 > 99.0f) {
            return -1;
        }
        float f11 = (f10 + 16.0f) / 116.0f;
        float f12 = f10 > 8.0f ? f11 * f11 * f11 : f10 / 903.2963f;
        float f13 = f11 * f11 * f11;
        boolean z10 = f13 > 0.008856452f;
        float f14 = z10 ? f13 : ((f11 * 116.0f) - 16.0f) / 903.2963f;
        if (!z10) {
            f13 = ((f11 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f6753c;
        return l0.b.a(f14 * fArr[0], f12 * fArr[1], f13 * fArr[2]);
    }

    public static float f(int i) {
        float f10 = i / 255.0f;
        return (f10 <= 0.04045f ? f10 / 12.92f : (float) Math.pow((f10 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static TypedArray g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static d j(XmlResourceParser xmlResourceParser, Resources resources) {
        int next;
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlResourceParser.require(2, null, "font-family");
        if (!xmlResourceParser.getName().equals("font-family")) {
            m(xmlResourceParser);
            return null;
        }
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), g0.d.FontFamily);
        String string = typedArrayObtainAttributes.getString(g0.d.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(g0.d.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(g0.d.FontFamily_fontProviderQuery);
        String string4 = typedArrayObtainAttributes.getString(g0.d.FontFamily_fontProviderFallbackQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(g0.d.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(g0.d.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(g0.d.FontFamily_fontProviderFetchTimeout, 500);
        String string5 = typedArrayObtainAttributes.getString(g0.d.FontFamily_fontProviderSystemFontFamily);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlResourceParser.next() != 3) {
                m(xmlResourceParser);
            }
            List listK = k(resources, resourceId);
            return new g(new q0.d(string, string2, string3, listK), string4 != null ? new q0.d(string, string2, string4, listK) : null, integer, integer2, string5);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlResourceParser.next() != 3) {
            if (xmlResourceParser.getEventType() == 2) {
                if (xmlResourceParser.getName().equals("font")) {
                    TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), g0.d.FontFamilyFont);
                    int i = typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(g0.d.FontFamilyFont_fontWeight) ? g0.d.FontFamilyFont_fontWeight : g0.d.FontFamilyFont_android_fontWeight, 400);
                    boolean z10 = 1 == typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(g0.d.FontFamilyFont_fontStyle) ? g0.d.FontFamilyFont_fontStyle : g0.d.FontFamilyFont_android_fontStyle, 0);
                    int i10 = typedArrayObtainAttributes2.hasValue(g0.d.FontFamilyFont_ttcIndex) ? g0.d.FontFamilyFont_ttcIndex : g0.d.FontFamilyFont_android_ttcIndex;
                    String string6 = typedArrayObtainAttributes2.getString(typedArrayObtainAttributes2.hasValue(g0.d.FontFamilyFont_fontVariationSettings) ? g0.d.FontFamilyFont_fontVariationSettings : g0.d.FontFamilyFont_android_fontVariationSettings);
                    int i11 = typedArrayObtainAttributes2.getInt(i10, 0);
                    int i12 = typedArrayObtainAttributes2.hasValue(g0.d.FontFamilyFont_font) ? g0.d.FontFamilyFont_font : g0.d.FontFamilyFont_android_font;
                    int resourceId2 = typedArrayObtainAttributes2.getResourceId(i12, 0);
                    String string7 = typedArrayObtainAttributes2.getString(i12);
                    typedArrayObtainAttributes2.recycle();
                    while (xmlResourceParser.next() != 3) {
                        m(xmlResourceParser);
                    }
                    arrayList.add(new f(i, i11, resourceId2, string7, string6, z10));
                } else {
                    m(xmlResourceParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new e((f[]) arrayList.toArray(new f[0]));
    }

    public static List k(Resources resources, int i) {
        if (i == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (typedArrayObtainTypedArray.getType(0) == 1) {
                for (int i10 = 0; i10 < typedArrayObtainTypedArray.length(); i10++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i10, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void l(android.content.res.Resources.Theme r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto La
            k0.j.a(r6)
            return
        La:
            java.lang.Object r0 = k0.b.f6755e
            monitor-enter(r0)
            boolean r1 = k0.b.f6756g     // Catch: java.lang.Throwable -> L21
            r2 = 0
            if (r1 != 0) goto L2d
            r1 = 1
            java.lang.Class<android.content.res.Resources$Theme> r3 = android.content.res.Resources.Theme.class
            java.lang.String r4 = "rebase"
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r2)     // Catch: java.lang.Throwable -> L21 java.lang.NoSuchMethodException -> L23
            k0.b.f = r3     // Catch: java.lang.Throwable -> L21 java.lang.NoSuchMethodException -> L23
            r3.setAccessible(r1)     // Catch: java.lang.Throwable -> L21 java.lang.NoSuchMethodException -> L23
            goto L2b
        L21:
            r6 = move-exception
            goto L43
        L23:
            r3 = move-exception
            java.lang.String r4 = "ResourcesCompat"
            java.lang.String r5 = "Failed to retrieve rebase() method"
            android.util.Log.i(r4, r5, r3)     // Catch: java.lang.Throwable -> L21
        L2b:
            k0.b.f6756g = r1     // Catch: java.lang.Throwable -> L21
        L2d:
            java.lang.reflect.Method r1 = k0.b.f     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L41
            r1.invoke(r6, r2)     // Catch: java.lang.Throwable -> L21 java.lang.reflect.InvocationTargetException -> L35 java.lang.IllegalAccessException -> L37
            goto L41
        L35:
            r6 = move-exception
            goto L38
        L37:
            r6 = move-exception
        L38:
            java.lang.String r1 = "ResourcesCompat"
            java.lang.String r3 = "Failed to invoke rebase() method via reflection"
            android.util.Log.i(r1, r3, r6)     // Catch: java.lang.Throwable -> L21
            k0.b.f = r2     // Catch: java.lang.Throwable -> L21
        L41:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L21
            return
        L43:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L21
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.b.l(android.content.res.Resources$Theme):void");
    }

    public static void m(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    public static float n() {
        return ((float) Math.pow((((double) 50.0f) + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }

    public void a(int i) {
        new Handler(Looper.getMainLooper()).post(new d6.i(i, 3, this));
    }

    public abstract void h(int i);

    public abstract void i(Typeface typeface);
}
