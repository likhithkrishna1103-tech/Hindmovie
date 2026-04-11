package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.versionedparcelable.CustomVersionedParcelable;
import g1.h;
import j0.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f658k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f663e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f665h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f666j;

    public IconCompat() {
        this.f659a = -1;
        this.f661c = null;
        this.f662d = null;
        this.f663e = 0;
        this.f = 0;
        this.f664g = null;
        this.f665h = f658k;
        this.i = null;
    }

    public static Bitmap a(Bitmap bitmap, boolean z10) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f = iMin;
        float f10 = 0.5f * f;
        float f11 = 0.9166667f * f10;
        if (z10) {
            float f12 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f12, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f10, f10, f11, paint);
            paint.setShadowLayer(f12, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f10, f10, f11, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f10, f10, f11, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat b(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f663e = i;
        iconCompat.f660b = "";
        iconCompat.f666j = "";
        return iconCompat;
    }

    public final int c() {
        int i = this.f659a;
        if (i != -1) {
            if (i == 2) {
                return this.f663e;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        int i10 = Build.VERSION.SDK_INT;
        Object obj = this.f660b;
        if (i10 >= 28) {
            return a.c(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e9) {
            Log.e("IconCompat", "Unable to get icon resource", e9);
            return 0;
        } catch (NoSuchMethodException e10) {
            Log.e("IconCompat", "Unable to get icon resource", e10);
            return 0;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon resource", e11);
            return 0;
        }
    }

    public final int d() {
        int i = this.f659a;
        if (i != -1) {
            return i;
        }
        int i10 = Build.VERSION.SDK_INT;
        Object obj = this.f660b;
        if (i10 >= 28) {
            return a.k(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e9) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e9);
            return -1;
        } catch (NoSuchMethodException e10) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e10);
            return -1;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e11);
            return -1;
        }
    }

    public final Uri e() {
        int i = this.f659a;
        if (i != -1) {
            if (i == 4 || i == 6) {
                return Uri.parse((String) this.f660b);
            }
            throw new IllegalStateException("called getUri() on " + this);
        }
        int i10 = Build.VERSION.SDK_INT;
        Object obj = this.f660b;
        if (i10 >= 28) {
            return a.l(obj);
        }
        try {
            return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
        } catch (IllegalAccessException e9) {
            Log.e("IconCompat", "Unable to get icon uri", e9);
            return null;
        } catch (NoSuchMethodException e10) {
            Log.e("IconCompat", "Unable to get icon uri", e10);
            return null;
        } catch (InvocationTargetException e11) {
            Log.e("IconCompat", "Unable to get icon uri", e11);
            return null;
        }
    }

    public final Icon f(Context context) {
        Icon iconCreateWithBitmap;
        int i = Build.VERSION.SDK_INT;
        int i10 = this.f659a;
        String strD = null;
        inputStreamOpenInputStream = null;
        InputStream inputStreamOpenInputStream = null;
        strD = null;
        strD = null;
        switch (i10) {
            case -1:
                return (Icon) this.f660b;
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) this.f660b);
                break;
            case 2:
                if (i10 == -1) {
                    Object obj = this.f660b;
                    if (i >= 28) {
                        strD = a.d(obj);
                    } else {
                        try {
                            strD = (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
                        } catch (IllegalAccessException e9) {
                            Log.e("IconCompat", "Unable to get icon package", e9);
                        } catch (NoSuchMethodException e10) {
                            Log.e("IconCompat", "Unable to get icon package", e10);
                        } catch (InvocationTargetException e11) {
                            Log.e("IconCompat", "Unable to get icon package", e11);
                        }
                    }
                } else {
                    if (i10 != 2) {
                        throw new IllegalStateException("called getResPackage() on " + this);
                    }
                    String str = this.f666j;
                    strD = (str == null || TextUtils.isEmpty(str)) ? ((String) this.f660b).split(":", -1)[0] : this.f666j;
                }
                iconCreateWithBitmap = Icon.createWithResource(strD, this.f663e);
                break;
            case 3:
                iconCreateWithBitmap = Icon.createWithData((byte[]) this.f660b, this.f663e, this.f);
                break;
            case h.LONG_FIELD_NUMBER /* 4 */:
                iconCreateWithBitmap = Icon.createWithContentUri((String) this.f660b);
                break;
            case h.STRING_FIELD_NUMBER /* 5 */:
                iconCreateWithBitmap = i < 26 ? Icon.createWithBitmap(a((Bitmap) this.f660b, false)) : d1.a.a((Bitmap) this.f660b);
                break;
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                if (i >= 30) {
                    iconCreateWithBitmap = m0.a.a(e());
                } else {
                    if (context == null) {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + e());
                    }
                    Uri uriE = e();
                    String scheme = uriE.getScheme();
                    if ("content".equals(scheme) || "file".equals(scheme)) {
                        try {
                            inputStreamOpenInputStream = context.getContentResolver().openInputStream(uriE);
                        } catch (Exception e12) {
                            Log.w("IconCompat", "Unable to load image from URI: " + uriE, e12);
                        }
                        break;
                    } else {
                        try {
                            inputStreamOpenInputStream = new FileInputStream(new File((String) this.f660b));
                        } catch (FileNotFoundException e13) {
                            Log.w("IconCompat", "Unable to load image from path: " + uriE, e13);
                        }
                    }
                    if (inputStreamOpenInputStream == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + e());
                    }
                    if (Build.VERSION.SDK_INT < 26) {
                        iconCreateWithBitmap = Icon.createWithBitmap(a(BitmapFactory.decodeStream(inputStreamOpenInputStream), false));
                    } else {
                        iconCreateWithBitmap = d1.a.a(BitmapFactory.decodeStream(inputStreamOpenInputStream));
                    }
                }
                break;
        }
        ColorStateList colorStateList = this.f664g;
        if (colorStateList != null) {
            iconCreateWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f665h;
        if (mode != f658k) {
            iconCreateWithBitmap.setTintMode(mode);
        }
        return iconCreateWithBitmap;
    }

    public final String toString() {
        String str;
        if (this.f659a == -1) {
            return String.valueOf(this.f660b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f659a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case h.LONG_FIELD_NUMBER /* 4 */:
                str = "URI";
                break;
            case h.STRING_FIELD_NUMBER /* 5 */:
                str = "BITMAP_MASKABLE";
                break;
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f659a) {
            case 1:
            case h.STRING_FIELD_NUMBER /* 5 */:
                sb.append(" size=");
                sb.append(((Bitmap) this.f660b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f660b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f666j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(c())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f663e);
                if (this.f != 0) {
                    sb.append(" off=");
                    sb.append(this.f);
                }
                break;
            case h.LONG_FIELD_NUMBER /* 4 */:
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                sb.append(" uri=");
                sb.append(this.f660b);
                break;
        }
        if (this.f664g != null) {
            sb.append(" tint=");
            sb.append(this.f664g);
        }
        if (this.f665h != f658k) {
            sb.append(" mode=");
            sb.append(this.f665h);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i) {
        this.f661c = null;
        this.f662d = null;
        this.f663e = 0;
        this.f = 0;
        this.f664g = null;
        this.f665h = f658k;
        this.i = null;
        this.f659a = i;
    }
}
