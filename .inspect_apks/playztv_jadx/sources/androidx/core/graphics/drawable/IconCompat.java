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
import b1.j;
import g0.a;
import j0.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f984k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f989e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f991h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f992j;

    public IconCompat() {
        this.f985a = -1;
        this.f987c = null;
        this.f988d = null;
        this.f989e = 0;
        this.f = 0;
        this.f990g = null;
        this.f991h = f984k;
        this.i = null;
    }

    public static Bitmap a(Bitmap bitmap, boolean z2) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f = iMin;
        float f4 = 0.5f * f;
        float f10 = 0.9166667f * f4;
        if (z2) {
            float f11 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f11, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f4, f4, f10, paint);
            paint.setShadowLayer(f11, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f4, f4, f10, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f4, f4, f10, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat b(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f989e = i;
        iconCompat.f986b = "";
        iconCompat.f992j = "";
        return iconCompat;
    }

    public final int c() {
        int i = this.f985a;
        if (i != -1) {
            if (i == 2) {
                return this.f989e;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        int i10 = Build.VERSION.SDK_INT;
        Object obj = this.f986b;
        if (i10 >= 28) {
            return a.c(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon resource", e10);
            return 0;
        } catch (NoSuchMethodException e11) {
            Log.e("IconCompat", "Unable to get icon resource", e11);
            return 0;
        } catch (InvocationTargetException e12) {
            Log.e("IconCompat", "Unable to get icon resource", e12);
            return 0;
        }
    }

    public final int d() {
        int i = this.f985a;
        if (i != -1) {
            return i;
        }
        int i10 = Build.VERSION.SDK_INT;
        Object obj = this.f986b;
        if (i10 >= 28) {
            return a.k(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e10);
            return -1;
        } catch (NoSuchMethodException e11) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e11);
            return -1;
        } catch (InvocationTargetException e12) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e12);
            return -1;
        }
    }

    public final Uri e() {
        int i = this.f985a;
        if (i != -1) {
            if (i == 4 || i == 6) {
                return Uri.parse((String) this.f986b);
            }
            throw new IllegalStateException("called getUri() on " + this);
        }
        int i10 = Build.VERSION.SDK_INT;
        Object obj = this.f986b;
        if (i10 >= 28) {
            return a.l(obj);
        }
        try {
            return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon uri", e10);
            return null;
        } catch (NoSuchMethodException e11) {
            Log.e("IconCompat", "Unable to get icon uri", e11);
            return null;
        } catch (InvocationTargetException e12) {
            Log.e("IconCompat", "Unable to get icon uri", e12);
            return null;
        }
    }

    public final Icon f(Context context) {
        Icon iconCreateWithBitmap;
        int i = Build.VERSION.SDK_INT;
        int i10 = this.f985a;
        String strD = null;
        inputStreamOpenInputStream = null;
        InputStream inputStreamOpenInputStream = null;
        strD = null;
        strD = null;
        switch (i10) {
            case -1:
                return (Icon) this.f986b;
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) this.f986b);
                break;
            case 2:
                if (i10 == -1) {
                    Object obj = this.f986b;
                    if (i >= 28) {
                        strD = a.d(obj);
                    } else {
                        try {
                            strD = (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
                        } catch (IllegalAccessException e10) {
                            Log.e("IconCompat", "Unable to get icon package", e10);
                        } catch (NoSuchMethodException e11) {
                            Log.e("IconCompat", "Unable to get icon package", e11);
                        } catch (InvocationTargetException e12) {
                            Log.e("IconCompat", "Unable to get icon package", e12);
                        }
                    }
                } else {
                    if (i10 != 2) {
                        throw new IllegalStateException("called getResPackage() on " + this);
                    }
                    String str = this.f992j;
                    strD = (str == null || TextUtils.isEmpty(str)) ? ((String) this.f986b).split(":", -1)[0] : this.f992j;
                }
                iconCreateWithBitmap = Icon.createWithResource(strD, this.f989e);
                break;
            case 3:
                iconCreateWithBitmap = Icon.createWithData((byte[]) this.f986b, this.f989e, this.f);
                break;
            case j.LONG_FIELD_NUMBER /* 4 */:
                iconCreateWithBitmap = Icon.createWithContentUri((String) this.f986b);
                break;
            case j.STRING_FIELD_NUMBER /* 5 */:
                iconCreateWithBitmap = i < 26 ? Icon.createWithBitmap(a((Bitmap) this.f986b, false)) : j0.a.a((Bitmap) this.f986b);
                break;
            case j.STRING_SET_FIELD_NUMBER /* 6 */:
                if (i >= 30) {
                    iconCreateWithBitmap = b.a(e());
                } else {
                    if (context == null) {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + e());
                    }
                    Uri uriE = e();
                    String scheme = uriE.getScheme();
                    if ("content".equals(scheme) || "file".equals(scheme)) {
                        try {
                            inputStreamOpenInputStream = context.getContentResolver().openInputStream(uriE);
                        } catch (Exception e13) {
                            Log.w("IconCompat", "Unable to load image from URI: " + uriE, e13);
                        }
                        break;
                    } else {
                        try {
                            inputStreamOpenInputStream = new FileInputStream(new File((String) this.f986b));
                        } catch (FileNotFoundException e14) {
                            Log.w("IconCompat", "Unable to load image from path: " + uriE, e14);
                        }
                    }
                    if (inputStreamOpenInputStream == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + e());
                    }
                    if (Build.VERSION.SDK_INT < 26) {
                        iconCreateWithBitmap = Icon.createWithBitmap(a(BitmapFactory.decodeStream(inputStreamOpenInputStream), false));
                    } else {
                        iconCreateWithBitmap = j0.a.a(BitmapFactory.decodeStream(inputStreamOpenInputStream));
                    }
                }
                break;
        }
        ColorStateList colorStateList = this.f990g;
        if (colorStateList != null) {
            iconCreateWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f991h;
        if (mode != f984k) {
            iconCreateWithBitmap.setTintMode(mode);
        }
        return iconCreateWithBitmap;
    }

    public final String toString() {
        String str;
        if (this.f985a == -1) {
            return String.valueOf(this.f986b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        switch (this.f985a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case j.LONG_FIELD_NUMBER /* 4 */:
                str = "URI";
                break;
            case j.STRING_FIELD_NUMBER /* 5 */:
                str = "BITMAP_MASKABLE";
                break;
            case j.STRING_SET_FIELD_NUMBER /* 6 */:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb2.append(str);
        switch (this.f985a) {
            case 1:
            case j.STRING_FIELD_NUMBER /* 5 */:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f986b).getWidth());
                sb2.append("x");
                sb2.append(((Bitmap) this.f986b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f992j);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", Integer.valueOf(c())));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.f989e);
                if (this.f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f);
                }
                break;
            case j.LONG_FIELD_NUMBER /* 4 */:
            case j.STRING_SET_FIELD_NUMBER /* 6 */:
                sb2.append(" uri=");
                sb2.append(this.f986b);
                break;
        }
        if (this.f990g != null) {
            sb2.append(" tint=");
            sb2.append(this.f990g);
        }
        if (this.f991h != f984k) {
            sb2.append(" mode=");
            sb2.append(this.f991h);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public IconCompat(int i) {
        this.f987c = null;
        this.f988d = null;
        this.f989e = 0;
        this.f = 0;
        this.f990g = null;
        this.f991h = f984k;
        this.i = null;
        this.f985a = i;
    }
}
