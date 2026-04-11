package q1;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import c.f0;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.playz.tv.app.ProApplication;
import gc.o;
import ie.n;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import ke.p;
import n.n3;
import n.p3;
import o2.i0;
import q0.n0;
import q0.o0;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AudioManager f10533a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f10534b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f10535c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f10536d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Field f10537e;

    public static int A(byte b10, byte b11, byte b12, byte b13) {
        return (b10 << 24) | ((b11 & 255) << 16) | ((b12 & 255) << 8) | (b13 & 255);
    }

    public static rd.f B(rd.f fVar, rd.g gVar) {
        be.h.e(gVar, "key");
        if (be.h.a(fVar.getKey(), gVar)) {
            return fVar;
        }
        return null;
    }

    public static synchronized AudioManager C(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                f10533a = null;
            }
            AudioManager audioManager = f10533a;
            if (audioManager != null) {
                return audioManager;
            }
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper != null && looperMyLooper != Looper.getMainLooper()) {
                s1.g gVar = new s1.g();
                s1.b.i().execute(new i0(applicationContext, 5, gVar));
                gVar.b();
                AudioManager audioManager2 = f10533a;
                audioManager2.getClass();
                return audioManager2;
            }
            AudioManager audioManager3 = (AudioManager) applicationContext.getSystemService("audio");
            f10533a = audioManager3;
            audioManager3.getClass();
            return audioManager3;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static File D(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(cacheDir, str + i);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static int E(int[] iArr, int i, int i10, int i11) {
        while (i10 < i11) {
            if (iArr[i10] == i) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static rd.h F(rd.f fVar, rd.g gVar) {
        be.h.e(gVar, "key");
        return be.h.a(fVar.getKey(), gVar) ? rd.i.f11572u : fVar;
    }

    public static MappedByteBuffer G(Context context, Uri uri) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        try {
            parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                parcelFileDescriptorOpenFileDescriptor.close();
                return null;
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                parcelFileDescriptorOpenFileDescriptor.close();
                return map;
            } finally {
            }
        } finally {
        }
    }

    public static rd.h H(rd.f fVar, rd.h hVar) {
        be.h.e(hVar, "context");
        return hVar == rd.i.f11572u ? fVar : (rd.h) hVar.d(fVar, new p(8));
    }

    public static boolean I(Parcel parcel, int i) {
        X(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static int J(Parcel parcel, int i) {
        X(parcel, i, 4);
        return parcel.readInt();
    }

    public static long K(Parcel parcel, int i) {
        X(parcel, i, 8);
        return parcel.readLong();
    }

    public static int L(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    public static int M(long j5) {
        if (j5 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j5 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j5;
    }

    public static void N(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            n3.a(view, charSequence);
            return;
        }
        p3 p3Var = p3.E;
        if (p3Var != null && p3Var.f8491u == view) {
            p3.b(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new p3(view, charSequence);
            return;
        }
        p3 p3Var2 = p3.F;
        if (p3Var2 != null && p3Var2.f8491u == view) {
            p3Var2.a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public static boolean P(Context context) {
        Activity activity = (Activity) context;
        String str = ((ProApplication) activity.getApplication()).F;
        if (str == null) {
            return false;
        }
        String str2 = qc.a.b("UWLbaW91OMkmgdTbkB8bL29hkBnhkWHbg3IlOBPwjJG0fBIhOMIhfW5skBPugJFrOF==") + str + " )";
        h.f fVar = new h.f(activity);
        fVar.setTitle(str2);
        fVar.a(qc.a.b("VImZIF=="), new hc.g(3, activity));
        fVar.f5489a.f5450m = false;
        h.g gVarCreate = fVar.create();
        gVarCreate.show();
        gVarCreate.getWindow().setBackgroundDrawable(new ColorDrawable(-7829368));
        return true;
    }

    public static void Q(Context context) {
        h.f fVar = new h.f(context);
        fVar.setTitle(qc.a.b("WW91OBDmgok0OMIsSUF=") + context.getString(o.app_name) + qc.a.b("OBnhOPZig3VnSJGASYSqL2Hm"));
        fVar.a(qc.a.b("VImZIF=="), new hc.g(4, context));
        fVar.f5489a.f5450m = false;
        h.g gVarCreate = fVar.create();
        gVarCreate.show();
        gVarCreate.getWindow().setBackgroundDrawable(new ColorDrawable(-16777216));
    }

    public static void R(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + L(parcel, i));
    }

    public static int[] S(Collection collection) {
        if (collection instanceof da.b) {
            da.b bVar = (da.b) collection;
            return Arrays.copyOfRange(bVar.f4114u, bVar.f4115v, bVar.f4116w);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            obj.getClass();
            iArr[i] = ((Number) obj).intValue();
        }
        return iArr;
    }

    public static final String T(String str) {
        be.h.e(str, "<this>");
        int i = 0;
        int i10 = -1;
        if (!ie.e.N(str, ":", false)) {
            try {
                String ascii = IDN.toASCII(str);
                be.h.d(ascii, "toASCII(host)");
                Locale locale = Locale.US;
                be.h.d(locale, "US");
                String lowerCase = ascii.toLowerCase(locale);
                be.h.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    return null;
                }
                int length = lowerCase.length();
                for (int i11 = 0; i11 < length; i11++) {
                    char cCharAt = lowerCase.charAt(i11);
                    if (be.h.f(cCharAt, 31) <= 0 || be.h.f(cCharAt, ModuleDescriptor.MODULE_VERSION) >= 0 || ie.e.S(" #%/:?@[\\]", cCharAt, 0, 6) != -1) {
                        return null;
                    }
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressW = (n.M(str, "[", false) && n.H(str, "]")) ? w(1, str.length() - 1, str) : w(0, str.length(), str);
        if (inetAddressW == null) {
            return null;
        }
        byte[] address = inetAddressW.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressW.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < address.length) {
            int i14 = i12;
            while (i14 < 16 && address[i14] == 0 && address[i14 + 1] == 0) {
                i14 += 2;
            }
            int i15 = i14 - i12;
            if (i15 > i13 && i15 >= 4) {
                i10 = i12;
                i13 = i15;
            }
            i12 = i14 + 2;
        }
        hf.f fVar = new hf.f();
        while (i < address.length) {
            if (i == i10) {
                fVar.j0(58);
                i += i13;
                if (i == 16) {
                    fVar.j0(58);
                }
            } else {
                if (i > 0) {
                    fVar.j0(58);
                }
                byte b10 = address[i];
                byte[] bArr = ve.b.f13497a;
                fVar.k0(((b10 & 255) << 8) | (address[i + 1] & 255));
                i += 2;
            }
        }
        return fVar.J();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Integer U(java.lang.String r19) {
        /*
            r0 = r19
            r0.getClass()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L10
        Lb:
            r0 = 0
            r16 = 0
            goto L86
        L10:
            r1 = 0
            char r3 = r0.charAt(r1)
            r4 = 45
            if (r3 != r4) goto L1a
            r1 = 1
        L1a:
            int r3 = r0.length()
            if (r1 != r3) goto L21
            goto Lb
        L21:
            int r3 = r1 + 1
            char r4 = r0.charAt(r1)
            r5 = -1
            r6 = 128(0x80, float:1.8E-43)
            if (r4 >= r6) goto L31
            byte[] r7 = da.c.f4117a
            r4 = r7[r4]
            goto L34
        L31:
            byte[] r4 = da.c.f4117a
            r4 = r5
        L34:
            if (r4 < 0) goto L60
            r7 = 10
            if (r4 < r7) goto L3b
            goto L60
        L3b:
            int r4 = -r4
            long r8 = (long) r4
            long r10 = (long) r7
            r12 = -9223372036854775808
            long r14 = r12 / r10
        L42:
            int r4 = r0.length()
            if (r3 >= r4) goto L73
            int r4 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 >= r6) goto L55
            byte[] r16 = da.c.f4117a
            r3 = r16[r3]
            goto L58
        L55:
            byte[] r3 = da.c.f4117a
            r3 = r5
        L58:
            if (r3 < 0) goto L60
            if (r3 >= r7) goto L60
            int r16 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r16 >= 0) goto L63
        L60:
            r16 = 0
            goto L6d
        L63:
            long r8 = r8 * r10
            r16 = 0
            long r2 = (long) r3
            long r17 = r2 + r12
            int r17 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r17 >= 0) goto L70
        L6d:
            r0 = r16
            goto L86
        L70:
            long r8 = r8 - r2
            r3 = r4
            goto L42
        L73:
            r16 = 0
            if (r1 == 0) goto L7c
            java.lang.Long r0 = java.lang.Long.valueOf(r8)
            goto L86
        L7c:
            int r0 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r0 != 0) goto L81
            goto L6d
        L81:
            long r0 = -r8
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L86:
            if (r0 == 0) goto L9f
            long r1 = r0.longValue()
            int r3 = r0.intValue()
            long r3 = (long) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L96
            goto L9f
        L96:
            int r0 = r0.intValue()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        L9f:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.c.U(java.lang.String):java.lang.Integer");
    }

    public static int V(Parcel parcel) {
        int i = parcel.readInt();
        int iL = L(parcel, i);
        char c9 = (char) i;
        int iDataPosition = parcel.dataPosition();
        if (c9 != 20293) {
            throw new u7.b("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i))), parcel);
        }
        int i10 = iL + iDataPosition;
        if (i10 < iDataPosition || i10 > parcel.dataSize()) {
            throw new u7.b(l4.a.l(iDataPosition, i10, "Size read is invalid start=", " end="), parcel);
        }
        return i10;
    }

    public static void W(Parcel parcel, int i, int i10) {
        if (i == i10) {
            return;
        }
        throw new u7.b(l4.a.o(l4.a.p(i10, i, "Expected size ", " got ", " (0x"), Integer.toHexString(i), ")"), parcel);
    }

    public static void X(Parcel parcel, int i, int i10) {
        int iL = L(parcel, i);
        if (iL == i10) {
            return;
        }
        throw new u7.b(l4.a.o(l4.a.p(i10, iL, "Expected size ", " got ", " (0x"), Integer.toHexString(iL), ")"), parcel);
    }

    public static void a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public static List c(int... iArr) {
        return iArr.length == 0 ? Collections.EMPTY_LIST : new da.b(0, iArr.length, iArr);
    }

    public static String d(int i, int i10, String str) {
        if (i < 0) {
            return t1.t("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i10 >= 0) {
            return t1.t("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i10));
        }
        throw new IllegalArgumentException(e6.j.l("negative size: ", i10));
    }

    public static String e(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            sb2.append(String.format("%02x", Byte.valueOf(b10)));
        }
        return sb2.toString();
    }

    public static void f(long j5, String str, boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException(t1.t(str, Long.valueOf(j5)));
        }
    }

    public static void g(String str, boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void h(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static void i(int i, int i10) {
        String strT;
        if (i < 0 || i >= i10) {
            if (i < 0) {
                strT = t1.t("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i10 < 0) {
                    throw new IllegalArgumentException(e6.j.l("negative size: ", i10));
                }
                strT = t1.t("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i10));
            }
            throw new IndexOutOfBoundsException(strT);
        }
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void k(int i, int i10) {
        if (i < 0 || i > i10) {
            throw new IndexOutOfBoundsException(d(i, i10, "index"));
        }
    }

    public static void l(int i, int i10, int i11) {
        if (i < 0 || i10 < i || i10 > i11) {
            throw new IndexOutOfBoundsException((i < 0 || i > i11) ? d(i, i11, "start index") : (i10 < 0 || i10 > i11) ? d(i10, i11, "end index") : t1.t("end index (%s) must not be less than start index (%s)", Integer.valueOf(i10), Integer.valueOf(i)));
        }
    }

    public static void m(String str, boolean z2) {
        if (!z2) {
            throw new IllegalStateException(str);
        }
    }

    public static int n(long j5) {
        int i = (int) j5;
        f(j5, "Out of range: %s", ((long) i) == j5);
        return i;
    }

    public static void o(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] p(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = iArr[i];
        }
        return jArr;
    }

    public static boolean q(File file, Resources resources, int i) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i);
            try {
                boolean zR = r(file, inputStreamOpenRawResource);
                o(inputStreamOpenRawResource);
                return zR;
            } catch (Throwable th) {
                th = th;
                o(inputStreamOpenRawResource);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenRawResource = null;
        }
    }

    public static boolean r(File file, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    o(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return true;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e11) {
            e = e11;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            o(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            o(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            throw th;
        }
    }

    public static Bundle s(Parcel parcel, int i) {
        int iL = L(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iL);
        return bundle;
    }

    public static Parcelable t(Parcel parcel, int i, Parcelable.Creator creator) {
        int iL = L(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iL);
        return parcelable;
    }

    public static String u(Parcel parcel, int i) {
        int iL = L(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iL);
        return string;
    }

    public static Object[] v(Parcel parcel, int i, Parcelable.Creator creator) {
        int iL = L(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iL);
        return objArrCreateTypedArray;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00cb, code lost:
    
        if (r7 == 16) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00cd, code lost:
    
        if (r8 != (-1)) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d1, code lost:
    
        r0 = r7 - r8;
        java.lang.System.arraycopy(r3, r8, r3, 16 - r0, r0);
        java.util.Arrays.fill(r3, r8, (16 - r7) + r8, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e1, code lost:
    
        return java.net.InetAddress.getByAddress(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:?, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.net.InetAddress w(int r17, int r18, java.lang.String r19) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.c.w(int, int, java.lang.String):java.net.InetAddress");
    }

    public static boolean x(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int iIndexOfKey;
        WeakHashMap weakHashMap = o0.f10475a;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList2 = n0.f10470d;
        n0 n0Var = (n0) view.getTag(d0.c.tag_unhandled_key_event_manager);
        WeakReference weakReference = null;
        if (n0Var == null) {
            n0Var = new n0();
            n0Var.f10471a = null;
            n0Var.f10472b = null;
            n0Var.f10473c = null;
            view.setTag(d0.c.tag_unhandled_key_event_manager, n0Var);
        }
        WeakReference weakReference2 = n0Var.f10473c;
        if (weakReference2 != null && weakReference2.get() == keyEvent) {
            return false;
        }
        n0Var.f10473c = new WeakReference(keyEvent);
        if (n0Var.f10472b == null) {
            n0Var.f10472b = new SparseArray();
        }
        SparseArray sparseArray = n0Var.f10472b;
        if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReference = (WeakReference) sparseArray.valueAt(iIndexOfKey);
            sparseArray.removeAt(iIndexOfKey);
        }
        if (weakReference == null) {
            weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReference == null) {
            return false;
        }
        View view2 = (View) weakReference.get();
        if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(d0.c.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
            return true;
        }
        arrayList.get(size).getClass();
        throw new ClassCastException();
    }

    public static boolean y(q0.k kVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener;
        boolean zBooleanValue = false;
        if (kVar != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return kVar.b(keyEvent);
            }
            if (callback instanceof Activity) {
                Activity activity = (Activity) callback;
                activity.onUserInteraction();
                Window window = activity.getWindow();
                if (window.hasFeature(8)) {
                    ActionBar actionBar = activity.getActionBar();
                    if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                        if (!f10534b) {
                            try {
                                f10535c = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                            } catch (NoSuchMethodException unused) {
                            }
                            f10534b = true;
                        }
                        Method method = f10535c;
                        if (method != null) {
                            try {
                                Object objInvoke = method.invoke(actionBar, keyEvent);
                                if (objInvoke != null) {
                                    zBooleanValue = ((Boolean) objInvoke).booleanValue();
                                }
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        }
                        if (zBooleanValue) {
                            return true;
                        }
                    }
                }
                if (window.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView = window.getDecorView();
                if (o0.c(decorView, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
            }
            if (callback instanceof Dialog) {
                Dialog dialog = (Dialog) callback;
                if (!f10536d) {
                    try {
                        Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                        f10537e = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused3) {
                    }
                    f10536d = true;
                }
                Field field = f10537e;
                if (field != null) {
                    try {
                        onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
                    } catch (IllegalAccessException unused4) {
                        onKeyListener = null;
                    }
                } else {
                    onKeyListener = null;
                }
                if (onKeyListener != null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                    return true;
                }
                Window window2 = dialog.getWindow();
                if (window2.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView2 = window2.getDecorView();
                if (o0.c(decorView2, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(dialog, decorView2 != null ? decorView2.getKeyDispatcherState() : null, dialog);
            }
            if ((view != null && o0.c(view, keyEvent)) || kVar.b(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public static void z(Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            throw new u7.b(e6.j.l("Overread allowed size end=", i), parcel);
        }
    }

    public abstract void O(f0 f0Var, f0 f0Var2, Window window, View view, boolean z2, boolean z10);

    public void b(Window window) {
    }
}
