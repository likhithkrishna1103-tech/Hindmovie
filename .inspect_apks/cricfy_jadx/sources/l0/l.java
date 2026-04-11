package l0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends vf.g {
    public static Font e0(FontFamily fontFamily, int i) {
        FontStyle fontStyle = new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iG0 = g0(fontStyle, font.getStyle());
        for (int i10 = 1; i10 < fontFamily.getSize(); i10++) {
            Font font2 = fontFamily.getFont(i10);
            int iG02 = g0(fontStyle, font2.getStyle());
            if (iG02 < iG0) {
                font = font2;
                iG0 = iG02;
            }
        }
        return font;
    }

    public static FontFamily f0(q0.i[] iVarArr, ContentResolver contentResolver) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        FontFamily.Builder builder = null;
        for (q0.i iVar : iVarArr) {
            try {
                parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(iVar.f10344a, "r", null);
            } catch (IOException e9) {
                Log.w("TypefaceCompatApi29Impl", "Font load failed", e9);
            }
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                }
            } else {
                try {
                    Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(iVar.f10346c).setSlant(iVar.f10347d ? 1 : 0).setTtcIndex(iVar.f10345b).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (Throwable th) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            parcelFileDescriptorOpenFileDescriptor.close();
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public static int g0(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // vf.g
    public final Typeface o(Context context, k0.e eVar, Resources resources, int i) {
        try {
            FontFamily.Builder builder = null;
            for (k0.f fVar : eVar.f6758a) {
                try {
                    Font fontBuild = new Font.Builder(resources, fVar.f).setWeight(fVar.f6760b).setSlant(fVar.f6761c ? 1 : 0).setTtcIndex(fVar.f6763e).setFontVariationSettings(fVar.f6762d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(e0(fontFamilyBuild, i).getStyle()).build();
        } catch (Exception e9) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e9);
            return null;
        }
    }

    @Override // vf.g
    public final Typeface p(Context context, q0.i[] iVarArr, int i) {
        try {
            FontFamily fontFamilyF0 = f0(iVarArr, context.getContentResolver());
            if (fontFamilyF0 == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(fontFamilyF0).setStyle(e0(fontFamilyF0, i).getStyle()).build();
        } catch (Exception e9) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e9);
            return null;
        }
    }

    @Override // vf.g
    public final Typeface q(Context context, List list, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily fontFamilyF0 = f0((q0.i[]) list.get(0), contentResolver);
            if (fontFamilyF0 == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(fontFamilyF0);
            for (int i10 = 1; i10 < list.size(); i10++) {
                FontFamily fontFamilyF02 = f0((q0.i[]) list.get(i10), contentResolver);
                if (fontFamilyF02 != null) {
                    customFallbackBuilder.addCustomFallback(fontFamilyF02);
                }
            }
            return customFallbackBuilder.setStyle(e0(fontFamilyF0, i).getStyle()).build();
        } catch (Exception e9) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e9);
            return null;
        }
    }

    @Override // vf.g
    public final Typeface r(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // vf.g
    public final Typeface s(Context context, Resources resources, int i, String str, int i10) {
        try {
            Font fontBuild = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception e9) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e9);
            return null;
        }
    }

    @Override // vf.g
    public final q0.i y(q0.i[] iVarArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
