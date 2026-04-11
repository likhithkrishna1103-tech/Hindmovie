package u8;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.f1;
import b2.h;
import com.google.android.gms.internal.measurement.a5;
import com.google.android.gms.internal.measurement.c6;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.j5;
import com.google.android.gms.internal.measurement.j6;
import com.google.android.gms.internal.measurement.n6;
import com.google.android.gms.internal.measurement.o5;
import com.google.android.gms.internal.measurement.r5;
import com.google.android.gms.internal.measurement.u6;
import com.google.android.gms.internal.measurement.x4;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import fe.l;
import ge.i;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import p6.c;
import p6.d;
import pe.s;
import t0.b1;
import td.f;
import v1.l0;
import v4.h0;
import v4.t0;
import w8.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f12285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f12286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile d f12287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile c f12288d;

    public static void B(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean zHasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z10 = onLongClickListener != null;
        boolean z11 = zHasOnClickListeners || z10;
        checkableImageButton.setFocusable(z11);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z10);
        checkableImageButton.setImportantForAccessibility(z11 ? 1 : 2);
    }

    public static void C(Outline outline, Path path) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            y9.b.a(outline, path);
            return;
        }
        if (i >= 29) {
            try {
                y9.a.a(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            y9.a.a(outline, path);
        }
    }

    public static final String D(int i) {
        if (i == 0) {
            return "0";
        }
        char[] cArr = bg.b.f1919a;
        int i10 = 0;
        char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
        while (i10 < 8 && cArr2[i10] == '0') {
            i10++;
        }
        if (i10 >= 0) {
            if (i10 <= 8) {
                return new String(cArr2, i10, 8 - i10);
            }
            throw new IllegalArgumentException(q4.a.m(i10, 8, "startIndex: ", " > endIndex: "));
        }
        StringBuilder sbR = q4.a.r(i10, 8, "startIndex: ", ", endIndex: ", ", size: ");
        sbR.append(8);
        throw new IndexOutOfBoundsException(sbR.toString());
    }

    public static int F(byte[] bArr, int i, x4 x4Var) {
        int i10 = i + 1;
        byte b8 = bArr[i];
        if (b8 < 0) {
            return G(b8, bArr, i10, x4Var);
        }
        x4Var.f2719a = b8;
        return i10;
    }

    public static int G(int i, byte[] bArr, int i10, x4 x4Var) {
        byte b8 = bArr[i10];
        int i11 = i10 + 1;
        int i12 = i & 127;
        if (b8 >= 0) {
            x4Var.f2719a = i12 | (b8 << 7);
            return i11;
        }
        int i13 = i12 | ((b8 & 127) << 7);
        int i14 = i10 + 2;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            x4Var.f2719a = i13 | (b10 << 14);
            return i14;
        }
        int i15 = i13 | ((b10 & 127) << 14);
        int i16 = i10 + 3;
        byte b11 = bArr[i14];
        if (b11 >= 0) {
            x4Var.f2719a = i15 | (b11 << 21);
            return i16;
        }
        int i17 = i15 | ((b11 & 127) << 21);
        int i18 = i10 + 4;
        byte b12 = bArr[i16];
        if (b12 >= 0) {
            x4Var.f2719a = i17 | (b12 << 28);
            return i18;
        }
        int i19 = i17 | ((b12 & 127) << 28);
        while (true) {
            int i20 = i18 + 1;
            if (bArr[i18] >= 0) {
                x4Var.f2719a = i19;
                return i20;
            }
            i18 = i20;
        }
    }

    public static int H(byte[] bArr, int i, x4 x4Var) {
        long j4 = bArr[i];
        int i10 = i + 1;
        if (j4 >= 0) {
            x4Var.f2720b = j4;
            return i10;
        }
        int i11 = i + 2;
        byte b8 = bArr[i10];
        long j7 = (j4 & 127) | (((long) (b8 & 127)) << 7);
        int i12 = 7;
        while (b8 < 0) {
            int i13 = i11 + 1;
            byte b10 = bArr[i11];
            i12 += 7;
            j7 |= ((long) (b10 & 127)) << i12;
            b8 = b10;
            i11 = i13;
        }
        x4Var.f2720b = j7;
        return i11;
    }

    public static int I(int i, byte[] bArr) {
        int i10 = bArr[i] & 255;
        int i11 = bArr[i + 1] & 255;
        int i12 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i11 << 8) | i10 | (i12 << 16);
    }

    public static long J(int i, byte[] bArr) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public static int K(byte[] bArr, int i, x4 x4Var) throws r5 {
        int iF = F(bArr, i, x4Var);
        int i10 = x4Var.f2719a;
        if (i10 < 0) {
            throw new r5("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i10 == 0) {
            x4Var.f2721c = "";
            return iF;
        }
        int i11 = u6.f2649a;
        int length = bArr.length;
        if ((((length - iF) - i10) | iF | i10) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iF), Integer.valueOf(i10)));
        }
        int i12 = iF + i10;
        char[] cArr = new char[i10];
        int i13 = 0;
        while (iF < i12) {
            byte b8 = bArr[iF];
            if (b8 < 0) {
                break;
            }
            iF++;
            cArr[i13] = (char) b8;
            i13++;
        }
        while (iF < i12) {
            int i14 = iF + 1;
            byte b10 = bArr[iF];
            if (b10 >= 0) {
                cArr[i13] = (char) b10;
                i13++;
                iF = i14;
                while (iF < i12) {
                    byte b11 = bArr[iF];
                    if (b11 >= 0) {
                        iF++;
                        cArr[i13] = (char) b11;
                        i13++;
                    }
                }
            } else if (b10 < -32) {
                if (i14 >= i12) {
                    throw new r5("Protocol message had invalid UTF-8.");
                }
                int i15 = i13 + 1;
                iF += 2;
                byte b12 = bArr[i14];
                if (b10 < -62 || e.p(b12)) {
                    throw new r5("Protocol message had invalid UTF-8.");
                }
                cArr[i13] = (char) ((b12 & 63) | ((b10 & 31) << 6));
                i13 = i15;
            } else {
                if (b10 < -16) {
                    if (i14 >= i12 - 1) {
                        throw new r5("Protocol message had invalid UTF-8.");
                    }
                    int i16 = i13 + 1;
                    int i17 = iF + 2;
                    byte b13 = bArr[i14];
                    iF += 3;
                    byte b14 = bArr[i17];
                    if (!e.p(b13)) {
                        if (b10 == -32) {
                            if (b13 >= -96) {
                                b10 = -32;
                            }
                        }
                        if (b10 == -19) {
                            if (b13 < -96) {
                                b10 = -19;
                            }
                        }
                        if (!e.p(b14)) {
                            cArr[i13] = (char) (((b13 & 63) << 6) | ((b10 & 15) << 12) | (b14 & 63));
                            i13 = i16;
                        }
                    }
                    throw new r5("Protocol message had invalid UTF-8.");
                }
                if (i14 >= i12 - 2) {
                    throw new r5("Protocol message had invalid UTF-8.");
                }
                byte b15 = bArr[i14];
                int i18 = iF + 3;
                byte b16 = bArr[iF + 2];
                iF += 4;
                byte b17 = bArr[i18];
                if (e.p(b15) || (((b15 + 112) + (b10 << 28)) >> 30) != 0 || e.p(b16) || e.p(b17)) {
                    throw new r5("Protocol message had invalid UTF-8.");
                }
                int i19 = ((b15 & 63) << 12) | ((b10 & 7) << 18) | ((b16 & 63) << 6) | (b17 & 63);
                cArr[i13] = (char) ((i19 >>> 10) + 55232);
                cArr[i13 + 1] = (char) ((i19 & 1023) + 56320);
                i13 += 2;
            }
        }
        x4Var.f2721c = new String(cArr, 0, i13);
        return i12;
    }

    public static int L(byte[] bArr, int i, x4 x4Var) throws r5 {
        int iF = F(bArr, i, x4Var);
        int i10 = x4Var.f2719a;
        if (i10 < 0) {
            throw new r5("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i10 > bArr.length - iF) {
            throw new r5("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i10 == 0) {
            x4Var.f2721c = a5.f2316x;
            return iF;
        }
        x4Var.f2721c = a5.d(bArr, iF, i10);
        return iF + i10;
    }

    public static int M(Object obj, j6 j6Var, byte[] bArr, int i, int i10, x4 x4Var) throws r5 {
        int iG = i + 1;
        int i11 = bArr[i];
        if (i11 < 0) {
            iG = G(i11, bArr, iG, x4Var);
            i11 = x4Var.f2719a;
        }
        int i12 = iG;
        if (i11 < 0 || i11 > i10 - i12) {
            throw new r5("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i13 = x4Var.f2722d + 1;
        x4Var.f2722d = i13;
        if (i13 >= 100) {
            throw new r5("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i14 = i12 + i11;
        j6Var.c(obj, bArr, i12, i14, x4Var);
        x4Var.f2722d--;
        x4Var.f2721c = obj;
        return i14;
    }

    public static int N(Object obj, j6 j6Var, byte[] bArr, int i, int i10, int i11, x4 x4Var) throws r5 {
        c6 c6Var = (c6) j6Var;
        int i12 = x4Var.f2722d + 1;
        x4Var.f2722d = i12;
        if (i12 >= 100) {
            throw new r5("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iT = c6Var.t(obj, bArr, i, i10, i11, x4Var);
        x4Var.f2722d--;
        x4Var.f2721c = obj;
        return iT;
    }

    public static int O(int i, byte[] bArr, int i10, int i11, o5 o5Var, x4 x4Var) {
        j5 j5Var = (j5) o5Var;
        int iF = F(bArr, i10, x4Var);
        j5Var.d(x4Var.f2719a);
        while (iF < i11) {
            int iF2 = F(bArr, iF, x4Var);
            if (i != x4Var.f2719a) {
                break;
            }
            iF = F(bArr, iF2, x4Var);
            j5Var.d(x4Var.f2719a);
        }
        return iF;
    }

    public static int P(byte[] bArr, int i, o5 o5Var, x4 x4Var) throws r5 {
        j5 j5Var = (j5) o5Var;
        int iF = F(bArr, i, x4Var);
        int i10 = x4Var.f2719a + iF;
        while (iF < i10) {
            iF = F(bArr, iF, x4Var);
            j5Var.d(x4Var.f2719a);
        }
        if (iF == i10) {
            return iF;
        }
        throw new r5("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int Q(j6 j6Var, int i, byte[] bArr, int i10, int i11, o5 o5Var, x4 x4Var) throws r5 {
        i5 i5VarA = j6Var.a();
        j6 j6Var2 = j6Var;
        byte[] bArr2 = bArr;
        int i12 = i11;
        x4 x4Var2 = x4Var;
        int iM = M(i5VarA, j6Var2, bArr2, i10, i12, x4Var2);
        j6Var2.b(i5VarA);
        x4Var2.f2721c = i5VarA;
        o5Var.add(i5VarA);
        while (iM < i12) {
            x4 x4Var3 = x4Var2;
            int i13 = i12;
            int iF = F(bArr2, iM, x4Var3);
            if (i != x4Var3.f2719a) {
                break;
            }
            byte[] bArr3 = bArr2;
            j6 j6Var3 = j6Var2;
            i5 i5VarA2 = j6Var3.a();
            iM = M(i5VarA2, j6Var3, bArr3, iF, i13, x4Var3);
            j6Var2 = j6Var3;
            bArr2 = bArr3;
            i12 = i13;
            x4Var2 = x4Var3;
            j6Var2.b(i5VarA2);
            x4Var2.f2721c = i5VarA2;
            o5Var.add(i5VarA2);
        }
        return iM;
    }

    public static int R(int i, byte[] bArr, int i10, int i11, n6 n6Var, x4 x4Var) throws r5 {
        if ((i >>> 3) == 0) {
            throw new r5("Protocol message contained an invalid tag (zero).");
        }
        int i12 = i & 7;
        if (i12 == 0) {
            int iH = H(bArr, i10, x4Var);
            n6Var.d(i, Long.valueOf(x4Var.f2720b));
            return iH;
        }
        if (i12 == 1) {
            n6Var.d(i, Long.valueOf(J(i10, bArr)));
            return i10 + 8;
        }
        if (i12 == 2) {
            int iF = F(bArr, i10, x4Var);
            int i13 = x4Var.f2719a;
            if (i13 < 0) {
                throw new r5("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i13 > bArr.length - iF) {
                throw new r5("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i13 == 0) {
                n6Var.d(i, a5.f2316x);
            } else {
                n6Var.d(i, a5.d(bArr, iF, i13));
            }
            return iF + i13;
        }
        if (i12 != 3) {
            if (i12 != 5) {
                throw new r5("Protocol message contained an invalid tag (zero).");
            }
            n6Var.d(i, Integer.valueOf(I(i10, bArr)));
            return i10 + 4;
        }
        int i14 = (i & (-8)) | 4;
        n6 n6VarA = n6.a();
        int i15 = x4Var.f2722d + 1;
        x4Var.f2722d = i15;
        if (i15 >= 100) {
            throw new r5("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i16 = 0;
        while (true) {
            if (i10 >= i11) {
                break;
            }
            int iF2 = F(bArr, i10, x4Var);
            int i17 = x4Var.f2719a;
            if (i17 == i14) {
                i16 = i17;
                i10 = iF2;
                break;
            }
            i10 = R(i17, bArr, iF2, i11, n6VarA, x4Var);
            i16 = i17;
        }
        x4Var.f2722d--;
        if (i10 > i11 || i16 != i14) {
            throw new r5("Failed to parse the message.");
        }
        n6Var.d(i, n6VarA);
        return i10;
    }

    public static int S(int i, byte[] bArr, int i10, int i11, x4 x4Var) throws r5 {
        if ((i >>> 3) == 0) {
            throw new r5("Protocol message contained an invalid tag (zero).");
        }
        int i12 = i & 7;
        if (i12 == 0) {
            return H(bArr, i10, x4Var);
        }
        if (i12 == 1) {
            return i10 + 8;
        }
        if (i12 == 2) {
            return F(bArr, i10, x4Var) + x4Var.f2719a;
        }
        if (i12 != 3) {
            if (i12 == 5) {
                return i10 + 4;
            }
            throw new r5("Protocol message contained an invalid tag (zero).");
        }
        int i13 = (i & (-8)) | 4;
        int i14 = 0;
        while (i10 < i11) {
            i10 = F(bArr, i10, x4Var);
            i14 = x4Var.f2719a;
            if (i14 == i13) {
                break;
            }
            i10 = S(i14, bArr, i10, i11, x4Var);
        }
        if (i10 > i11 || i14 != i13) {
            throw new r5("Failed to parse the message.");
        }
        return i10;
    }

    public static void a(StringBuilder sb, Object obj, l lVar) {
        if (lVar != null) {
            sb.append((CharSequence) lVar.a(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    public static void b(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                drawable.setTintList(colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static final boolean c(int i, int i10, int i11, byte[] bArr, byte[] bArr2) {
        i.e(bArr, "a");
        i.e(bArr2, "b");
        for (int i12 = 0; i12 < i11; i12++) {
            if (bArr[i12 + i] != bArr2[i12 + i10]) {
                return false;
            }
        }
        return true;
    }

    public static td.i d(td.i iVar) {
        f fVar = iVar.f12015v;
        fVar.b();
        return fVar.D > 0 ? iVar : td.i.f12014w;
    }

    public static boolean e(l0.f[] fVarArr, l0.f[] fVarArr2) {
        if (fVarArr == null || fVarArr2 == null || fVarArr.length != fVarArr2.length) {
            return false;
        }
        for (int i = 0; i < fVarArr.length; i++) {
            l0.f fVar = fVarArr[i];
            char c9 = fVar.f7607a;
            l0.f fVar2 = fVarArr2[i];
            if (c9 != fVar2.f7607a || fVar.f7608b.length != fVar2.f7608b.length) {
                return false;
            }
        }
        return true;
    }

    public static final void f(long j4, long j7, long j10) {
        if ((j7 | j10) < 0 || j7 > j4 || j4 - j7 < j10) {
            throw new ArrayIndexOutOfBoundsException("size=" + j4 + " offset=" + j7 + " byteCount=" + j10);
        }
    }

    public static void g(h hVar) {
        if (hVar != null) {
            try {
                hVar.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int h(t0 t0Var, androidx.emoji2.text.h hVar, View view, View view2, h0 h0Var, boolean z10) {
        if (h0Var.v() == 0 || t0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return Math.abs(h0.G(view) - h0.G(view2)) + 1;
        }
        return Math.min(hVar.n(), hVar.d(view2) - hVar.g(view));
    }

    public static int i(t0 t0Var, androidx.emoji2.text.h hVar, View view, View view2, h0 h0Var, boolean z10, boolean z11) {
        if (h0Var.v() == 0 || t0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z11 ? Math.max(0, (t0Var.b() - Math.max(h0.G(view), h0.G(view2))) - 1) : Math.max(0, Math.min(h0.G(view), h0.G(view2)));
        if (z10) {
            return Math.round((iMax * (Math.abs(hVar.d(view2) - hVar.g(view)) / (Math.abs(h0.G(view) - h0.G(view2)) + 1))) + (hVar.m() - hVar.g(view)));
        }
        return iMax;
    }

    public static int j(t0 t0Var, androidx.emoji2.text.h hVar, View view, View view2, h0 h0Var, boolean z10) {
        if (h0Var.v() == 0 || t0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return t0Var.b();
        }
        return (int) (((hVar.d(view2) - hVar.g(view)) / (Math.abs(h0.G(view) - h0.G(view2)) + 1)) * t0Var.b());
    }

    public static ImageView.ScaleType k(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 5 ? i != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    public static float[] l(float[] fArr, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(i, length);
        float[] fArr2 = new float[i];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0096 A[Catch: NumberFormatException -> 0x00aa, LOOP:3: B:25:0x0068->B:44:0x0096, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b1 A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:44:0x0096, B:46:0x009c, B:52:0x00b1, B:53:0x00b4), top: B:68:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0095 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static l0.f[] m(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u8.a.m(java.lang.String):l0.f[]");
    }

    public static Path n(String str) {
        Path path = new Path();
        try {
            l0.f.b(m(str), path);
            return path;
        } catch (RuntimeException e9) {
            throw new RuntimeException("Error in parsing ".concat(str), e9);
        }
    }

    public static l0.f[] q(l0.f[] fVarArr) {
        l0.f[] fVarArr2 = new l0.f[fVarArr.length];
        for (int i = 0; i < fVarArr.length; i++) {
            fVarArr2[i] = new l0.f(fVarArr[i]);
        }
        return fVarArr2;
    }

    public static ColorStateList r(Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !b1.l(drawable)) {
            return null;
        }
        return b1.c(drawable).getColorStateList();
    }

    public static vd.c t(vd.c cVar) {
        i.e(cVar, "<this>");
        xd.c cVar2 = cVar instanceof xd.c ? (xd.c) cVar : null;
        if (cVar2 == null || (cVar = cVar2.f14485x) != null) {
            return cVar;
        }
        vd.e eVar = (vd.e) cVar2.h().C(vd.d.f13721v);
        vd.c fVar = eVar != null ? new ue.f((s) eVar, cVar2) : cVar2;
        cVar2.f14485x = fVar;
        return fVar;
    }

    public static synchronized boolean v(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f12285a;
        if (context2 != null && (bool = f12286b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f12286b = null;
        if (s8.b.d()) {
            f12286b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f12286b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f12286b = Boolean.FALSE;
            }
        }
        f12285a = applicationContext;
        return f12286b.booleanValue();
    }

    public static Set w(Object... objArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(sd.s.A(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    public static c x(Context context) {
        c cVar;
        Context applicationContext = context.getApplicationContext();
        c cVar2 = f12288d;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (c.class) {
            try {
                cVar = f12288d;
                if (cVar == null) {
                    cVar = new c(0, new f1(15, applicationContext));
                    f12288d = cVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    public static void y(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    public abstract void A(boolean z10);

    public abstract TransformationMethod E(TransformationMethod transformationMethod);

    public l0 o(j3.a aVar) {
        ByteBuffer byteBuffer = aVar.data;
        byteBuffer.getClass();
        y1.d.b(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        return p(aVar, byteBuffer);
    }

    public abstract l0 p(j3.a aVar, ByteBuffer byteBuffer);

    public abstract InputFilter[] s(InputFilter[] inputFilterArr);

    public abstract boolean u();

    public abstract void z(boolean z10);
}
