package qb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.internal.measurement.w3;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static vc.a1 f10740a;

    public static b2.o a(k2.m mVar, String str, k2.j jVar, int i) {
        Map map = Collections.EMPTY_MAP;
        Uri uriO = y1.b.o(str, jVar.f6870c);
        long j4 = jVar.f6868a;
        long j7 = jVar.f6869b;
        String strA = mVar.a();
        if (strA == null) {
            strA = y1.b.o(((k2.b) mVar.f6873w.get(0)).f6827a, jVar.f6870c).toString();
        }
        String str2 = strA;
        y1.d.i(uriO, "The uri must be set.");
        return new b2.o(uriO, 0L, 1, null, ua.e1.B, j4, j7, str2, i);
    }

    public static void b(int i) {
        if (2 > i || i >= 37) {
            StringBuilder sbM = l0.e.m(i, "radix ", " was not in valid range ");
            sbM.append(new ke.c(2, 36, 1));
            throw new IllegalArgumentException(sbM.toString());
        }
    }

    public static w2.h c(v2.q qVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = qVar.length();
        int i = 0;
        for (int i10 = 0; i10 < length; i10++) {
            if (qVar.b(i10, jElapsedRealtime)) {
                i++;
            }
        }
        return new w2.h(1, 0, length, i);
    }

    public static Bitmap e(byte[] bArr, int i, int i10) throws IOException {
        BitmapFactory.Options options;
        int i11 = 0;
        int iE = 1;
        if (i10 != -1) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, i, options);
            options.inJustDecodeBounds = false;
            options.inSampleSize = 1;
            for (int iMax = Math.max(options.outWidth, options.outHeight); iMax > i10; iMax /= 2) {
                options.inSampleSize *= 2;
            }
        } else {
            options = null;
        }
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, i, options);
        if (options != null) {
            options.inSampleSize = 1;
        }
        if (bitmapDecodeByteArray == null) {
            throw v1.n0.a(new IllegalStateException(), "Could not decode image data");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            n1.g gVar = new n1.g(byteArrayInputStream);
            byteArrayInputStream.close();
            n1.c cVarC = gVar.c("Orientation");
            if (cVarC != null) {
                try {
                    iE = cVarC.e(gVar.f);
                } catch (NumberFormatException unused) {
                }
            }
            switch (iE) {
                case 3:
                case g1.h.LONG_FIELD_NUMBER /* 4 */:
                    i11 = 180;
                    break;
                case g1.h.STRING_FIELD_NUMBER /* 5 */:
                case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                    i11 = 270;
                    break;
                case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                    i11 = 90;
                    break;
            }
            if (i11 == 0) {
                return bitmapDecodeByteArray;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(i11);
            return Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, false);
        } finally {
        }
    }

    public static final boolean f(char c9, char c10, boolean z10) {
        if (c9 == c10) {
            return true;
        }
        if (!z10) {
            return false;
        }
        char upperCase = Character.toUpperCase(c9);
        char upperCase2 = Character.toUpperCase(c10);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static kf.s g(String str) {
        ge.i.e(str, "<this>");
        l7.a aVarA = kf.s.f7522c.a(0, str);
        if (aVarA == null) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        if (((ne.e) aVarA.f7868y) == null) {
            aVarA.f7868y = new ne.e(aVarA);
        }
        ne.e eVar = (ne.e) aVarA.f7868y;
        ge.i.b(eVar);
        String str2 = (String) eVar.get(1);
        Locale locale = Locale.ROOT;
        String lowerCase = str2.toLowerCase(locale);
        ge.i.d(lowerCase, "toLowerCase(...)");
        if (((ne.e) aVarA.f7868y) == null) {
            aVarA.f7868y = new ne.e(aVarA);
        }
        ne.e eVar2 = (ne.e) aVarA.f7868y;
        ge.i.b(eVar2);
        String lowerCase2 = ((String) eVar2.get(2)).toLowerCase(locale);
        ge.i.d(lowerCase2, "toLowerCase(...)");
        ArrayList arrayList = new ArrayList();
        Matcher matcher = (Matcher) aVarA.f7866w;
        int i = com.bumptech.glide.f.I(matcher.start(), matcher.end()).f7419w;
        while (true) {
            int i10 = i + 1;
            if (i10 >= str.length()) {
                return new kf.s(str, lowerCase, lowerCase2, (String[]) arrayList.toArray(new String[0]));
            }
            l7.a aVarA2 = kf.s.f7523d.a(i10, str);
            if (aVarA2 == null) {
                StringBuilder sb = new StringBuilder("Parameter is not formatted correctly: \"");
                String strSubstring = str.substring(i10);
                ge.i.d(strSubstring, "substring(...)");
                sb.append(strSubstring);
                sb.append("\" for: \"");
                sb.append(str);
                sb.append('\"');
                throw new IllegalArgumentException(sb.toString().toString());
            }
            Matcher matcher2 = (Matcher) aVarA2.f7866w;
            ne.f fVar = (ne.f) aVarA2.f7867x;
            ne.d dVarB = fVar.b(1);
            String str3 = dVarB != null ? dVarB.f9141a : null;
            if (str3 == null) {
                i = com.bumptech.glide.f.I(matcher2.start(), matcher2.end()).f7419w;
            } else {
                ne.d dVarB2 = fVar.b(2);
                String strSubstring2 = dVarB2 != null ? dVarB2.f9141a : null;
                if (strSubstring2 == null) {
                    ne.d dVarB3 = fVar.b(3);
                    ge.i.b(dVarB3);
                    strSubstring2 = dVarB3.f9141a;
                } else {
                    boolean z10 = false;
                    if (strSubstring2.length() > 0 && f(strSubstring2.charAt(0), '\'', false)) {
                        z10 = true;
                    }
                    if (z10 && strSubstring2.length() > 0 && f(strSubstring2.charAt(ne.h.f0(strSubstring2)), '\'', false) && strSubstring2.length() > 2) {
                        strSubstring2 = strSubstring2.substring(1, strSubstring2.length() - 1);
                        ge.i.d(strSubstring2, "substring(...)");
                    }
                }
                arrayList.add(str3);
                arrayList.add(strSubstring2);
                i = com.bumptech.glide.f.I(matcher2.start(), matcher2.end()).f7419w;
            }
        }
    }

    public static final ze.a h(ze.a aVar) {
        ge.i.e(aVar, "<this>");
        return aVar.d().h() ? aVar : new df.j(aVar);
    }

    public static boolean j(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static final boolean k(char c9) {
        return Character.isWhitespace(c9) || Character.isSpaceChar(c9);
    }

    public static final void l() {
        try {
            if (f10740a == null) {
                vc.a1 a1Var = (vc.a1) ((vc.i) ((vc.r) ab.g.c().b(vc.r.class))).f13645o.get();
                ge.i.e(a1Var, "<set-?>");
                f10740a = a1Var;
            }
            vc.a1 a1Var2 = f10740a;
            if (a1Var2 == null) {
                ge.i.i("sharedSessionRepository");
                throw null;
            }
            if (a1Var2.i) {
                if (a1Var2 != null) {
                    a1Var2.b();
                } else {
                    ge.i.i("sharedSessionRepository");
                    throw null;
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void n(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void o(Parcel parcel, int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int iW = w(parcel, i);
        parcel.writeBundle(bundle);
        y(parcel, iW);
    }

    public static void p(Parcel parcel, int i, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int iW = w(parcel, i);
        parcel.writeStrongBinder(iBinder);
        y(parcel, iW);
    }

    public static void q(Parcel parcel, int i, Parcelable parcelable, int i10) {
        if (parcelable == null) {
            return;
        }
        int iW = w(parcel, i);
        parcelable.writeToParcel(parcel, i10);
        y(parcel, iW);
    }

    public static void r(Parcel parcel, int i, String str) {
        if (str == null) {
            return;
        }
        int iW = w(parcel, i);
        parcel.writeString(str);
        y(parcel, iW);
    }

    public static void s(Parcel parcel, int i, Parcelable[] parcelableArr, int i10) {
        if (parcelableArr == null) {
            return;
        }
        int iW = w(parcel, i);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i10);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        y(parcel, iW);
    }

    public static void t(Parcel parcel, int i, List list) {
        if (list == null) {
            return;
        }
        int iW = w(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i10 = 0; i10 < size; i10++) {
            Parcelable parcelable = (Parcelable) list.get(i10);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        y(parcel, iW);
    }

    public static com.google.android.gms.internal.measurement.n u(Object obj) {
        if (obj == null) {
            return com.google.android.gms.internal.measurement.n.f2537c;
        }
        if (obj instanceof String) {
            return new com.google.android.gms.internal.measurement.q((String) obj);
        }
        if (obj instanceof Double) {
            return new com.google.android.gms.internal.measurement.g((Double) obj);
        }
        if (obj instanceof Long) {
            return new com.google.android.gms.internal.measurement.g(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new com.google.android.gms.internal.measurement.g(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new com.google.android.gms.internal.measurement.e((Boolean) obj);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            com.google.android.gms.internal.measurement.d dVar = new com.google.android.gms.internal.measurement.d();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                dVar.o(dVar.m(), u(it.next()));
            }
            return dVar;
        }
        com.google.android.gms.internal.measurement.k kVar = new com.google.android.gms.internal.measurement.k();
        Map map = (Map) obj;
        for (Object string : map.keySet()) {
            com.google.android.gms.internal.measurement.n nVarU = u(map.get(string));
            if (string != null) {
                if (!(string instanceof String)) {
                    string = string.toString();
                }
                kVar.f((String) string, nVarU);
            }
        }
        return kVar;
    }

    public static void v(Parcel parcel, int i, int i10) {
        parcel.writeInt(i | (i10 << 16));
    }

    public static int w(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static com.google.android.gms.internal.measurement.n x(w3 w3Var) {
        if (w3Var == null) {
            return com.google.android.gms.internal.measurement.n.f2536b;
        }
        int iX = w3Var.x() - 1;
        if (iX == 1) {
            return w3Var.r() ? new com.google.android.gms.internal.measurement.q(w3Var.s()) : com.google.android.gms.internal.measurement.n.i;
        }
        if (iX == 2) {
            return w3Var.v() ? new com.google.android.gms.internal.measurement.g(Double.valueOf(w3Var.w())) : new com.google.android.gms.internal.measurement.g(null);
        }
        if (iX == 3) {
            return w3Var.t() ? new com.google.android.gms.internal.measurement.e(Boolean.valueOf(w3Var.u())) : new com.google.android.gms.internal.measurement.e(null);
        }
        if (iX != 4) {
            throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
        }
        List listP = w3Var.p();
        ArrayList arrayList = new ArrayList();
        Iterator it = listP.iterator();
        while (it.hasNext()) {
            arrayList.add(x((w3) it.next()));
        }
        return new com.google.android.gms.internal.measurement.o(w3Var.q(), arrayList);
    }

    public static void y(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    public abstract Intent d(h.j jVar, Object obj);

    public pc.c i(h.j jVar, Object obj) {
        return null;
    }

    public abstract Object m(Intent intent, int i);
}
