package b8;

import aa.l0;
import android.animation.TimeInterpolator;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import androidx.emoji2.text.t;
import androidx.emoji2.text.u;
import cc.d0;
import ea.v;
import g5.y;
import id.p;
import j9.j0;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import ke.x;
import r2.r;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ClassLoader f1937a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Thread f1938b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f1939c = true;

    public static long A(long j5, long j8) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(~j8) + Long.numberOfLeadingZeros(j8) + Long.numberOfLeadingZeros(~j5) + Long.numberOfLeadingZeros(j5);
        if (iNumberOfLeadingZeros > 65) {
            return j5 * j8;
        }
        long j10 = ((j5 ^ j8) >>> 63) + Long.MAX_VALUE;
        if (!((iNumberOfLeadingZeros < 64) | ((j8 == Long.MIN_VALUE) & (j5 < 0)))) {
            long j11 = j5 * j8;
            if (j5 == 0 || j11 / j5 == j8) {
                return j11;
            }
        }
        return j10;
    }

    public static void F(ViewGroup viewGroup, boolean z2) {
        if (Build.VERSION.SDK_INT >= 29) {
            y.b(viewGroup, z2);
        } else if (f1939c) {
            try {
                y.b(viewGroup, z2);
            } catch (NoSuchMethodError unused) {
                f1939c = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00ab A[Catch: all -> 0x00a7, PHI: r1
      0x00ab: PHI (r1v4 java.lang.Thread) = (r1v3 java.lang.Thread), (r1v15 java.lang.Thread) binds: [B:7:0x000a, B:47:0x00a4] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000c, B:46:0x00a2, B:61:0x00d1, B:12:0x001f, B:52:0x00aa, B:53:0x00ab, B:64:0x00d5, B:65:0x00d6, B:54:0x00ac, B:60:0x00d0, B:59:0x00b6, B:13:0x0020, B:15:0x002d, B:25:0x0047, B:26:0x004e, B:28:0x0059, B:34:0x006e, B:35:0x0075, B:43:0x0086, B:44:0x00a0, B:18:0x003c), top: B:77:0x0003, inners: #2, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized java.lang.ClassLoader G() {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.h.G():java.lang.ClassLoader");
    }

    public static final void a(File file, long j5) throws IOException {
        if (!file.exists()) {
            android.support.v4.media.session.b.m(file);
        }
        if (file.length() != j5 && j5 > 0) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(j5);
                randomAccessFile.close();
            } catch (Exception unused) {
                throw new IOException("file_allocation_error");
            }
        }
    }

    public static final boolean b(int i, int i10, int i11, byte[] bArr, byte[] bArr2) {
        be.h.e(bArr, "a");
        be.h.e(bArr2, "b");
        for (int i12 = 0; i12 < i11; i12++) {
            if (bArr[i12 + i] != bArr2[i12 + i10]) {
                return false;
            }
        }
        return true;
    }

    public static final void c(long j5, long j8, long j10) {
        if ((j8 | j10) < 0 || j8 > j5 || j5 - j8 < j10) {
            throw new ArrayIndexOutOfBoundsException("size=" + j5 + " offset=" + j8 + " byteCount=" + j10);
        }
    }

    public static long d(long j5, long j8) {
        long j10 = j5 + j8;
        if (((j5 ^ j8) < 0) || ((j5 ^ j10) >= 0)) {
            return j10;
        }
        StringBuilder sb2 = new StringBuilder("overflow: checkedAdd(");
        sb2.append(j5);
        sb2.append(", ");
        throw new ArithmeticException(l4.a.n(sb2, j8, ")"));
    }

    public static u e(Context context) {
        ProviderInfo providerInfo;
        n0.d dVar;
        ApplicationInfo applicationInfo;
        q9.e dVar2 = Build.VERSION.SDK_INT >= 28 ? new androidx.emoji2.text.d(2) : new q9.e(2);
        PackageManager packageManager = context.getPackageManager();
        cf.l.j(packageManager, "Package manager required to locate emoji font provider");
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            dVar = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signatureArrL = dVar2.l(packageManager, str2);
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArrL) {
                    arrayList.add(signature.toByteArray());
                }
                dVar = new n0.d(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList));
            } catch (PackageManager.NameNotFoundException e10) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e10);
                dVar = null;
            }
        }
        if (dVar == null) {
            return null;
        }
        return new u(new t(context, dVar));
    }

    public static j0 f(r rVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = rVar.length();
        int i = 0;
        for (int i10 = 0; i10 < length; i10++) {
            if (rVar.b(i10, jElapsedRealtime)) {
                i++;
            }
        }
        return new j0(1, 0, length, i);
    }

    public static final String g(String str, boolean z2) {
        be.h.e(str, "filePath");
        if (!z2) {
            android.support.v4.media.session.b.m(new File(str));
            return str;
        }
        File file = new File(str);
        if (file.exists()) {
            String strM = e6.j.m(file.getParent(), "/");
            String name = file.getName();
            be.h.d(name, "getName(...)");
            String strZ = ie.e.Z(name, "");
            String strY = xd.a.Y(file);
            int i = 0;
            while (file.exists()) {
                i++;
                file = new File(strM + (strY + " (" + i + ")") + "." + strZ);
            }
        }
        android.support.v4.media.session.b.m(file);
        String absolutePath = file.getAbsolutePath();
        be.h.b(absolutePath);
        return absolutePath;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        if (r8 > 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        if (r8 < 0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long h(long r8, long r10, java.math.RoundingMode r12) {
        /*
            r12.getClass()
            long r0 = r8 / r10
            long r2 = r10 * r0
            long r2 = r8 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L10
            goto L53
        L10:
            long r8 = r8 ^ r10
            r7 = 63
            long r8 = r8 >> r7
            int r8 = (int) r8
            r8 = r8 | 1
            int[] r9 = ca.e.f2593a
            int r7 = r12.ordinal()
            r9 = r9[r7]
            switch(r9) {
                case 1: goto L51;
                case 2: goto L53;
                case 3: goto L4c;
                case 4: goto L4e;
                case 5: goto L49;
                case 6: goto L28;
                case 7: goto L28;
                case 8: goto L28;
                default: goto L22;
            }
        L22:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            r8.<init>()
            throw r8
        L28:
            long r2 = java.lang.Math.abs(r2)
            long r9 = java.lang.Math.abs(r10)
            long r9 = r9 - r2
            long r2 = r2 - r9
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 != 0) goto L46
            java.math.RoundingMode r9 = java.math.RoundingMode.HALF_UP
            if (r12 == r9) goto L4e
            java.math.RoundingMode r9 = java.math.RoundingMode.HALF_EVEN
            if (r12 != r9) goto L53
            r9 = 1
            long r9 = r9 & r0
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 == 0) goto L53
            goto L4e
        L46:
            if (r9 <= 0) goto L53
            goto L4e
        L49:
            if (r8 <= 0) goto L53
            goto L4e
        L4c:
            if (r8 >= 0) goto L53
        L4e:
            long r8 = (long) r8
            long r0 = r0 + r8
            return r0
        L51:
            if (r6 != 0) goto L54
        L53:
            return r0
        L54:
            java.lang.ArithmeticException r8 = new java.lang.ArithmeticException
            java.lang.String r9 = "mode was UNNECESSARY, but rounding was necessary"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.h.h(long, long, java.math.RoundingMode):long");
    }

    public static long i(long j5, long j8) {
        cf.d.d("a", j5);
        cf.d.d("b", j8);
        if (j5 == 0) {
            return j8;
        }
        if (j8 == 0) {
            return j5;
        }
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j5);
        long jNumberOfTrailingZeros = j5 >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j8);
        long j10 = j8 >> iNumberOfTrailingZeros2;
        while (jNumberOfTrailingZeros != j10) {
            long j11 = jNumberOfTrailingZeros - j10;
            long j12 = (j11 >> 63) & j11;
            long j13 = (j11 - j12) - j12;
            j10 += j12;
            jNumberOfTrailingZeros = j13 >> Long.numberOfTrailingZeros(j13);
        }
        return jNumberOfTrailingZeros << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros2);
    }

    public static Object j(Future future) {
        Object obj;
        boolean z2 = false;
        if (!future.isDone()) {
            throw new IllegalStateException(t1.t("Future was expected to be done: %s", future));
        }
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static final yc.b k(String str) {
        yc.b bVar = yc.b.f14649w;
        return (str == null || str.length() == 0) ? bVar : (str.equalsIgnoreCase("request_with_file_path_already_exist") || ie.e.N(str, "UNIQUE constraint failed: requests._file (code 2067)", true)) ? yc.b.K : ie.e.N(str, "UNIQUE constraint failed: requests._id", false) ? yc.b.J : ie.e.N(str, "empty_response_body", true) ? yc.b.F : (str.equalsIgnoreCase("FNC") || str.equalsIgnoreCase("open failed: ENOENT (No such file or directory)")) ? yc.b.f14651y : (ie.e.N(str, "recvfrom failed: ETIMEDOUT (Connection timed out)", true) || ie.e.N(str, "timeout", true) || ie.e.N(str, "Software caused connection abort", true) || ie.e.N(str, "Read timed out at", true)) ? yc.b.f14652z : (str.equalsIgnoreCase("java.io.IOException: 404") || ie.e.N(str, "No address associated with hostname", false)) ? yc.b.B : ie.e.N(str, "Unable to resolve host", false) ? yc.b.A : str.equalsIgnoreCase("open failed: EACCES (Permission denied)") ? yc.b.C : (str.equalsIgnoreCase("write failed: ENOSPC (No space left on device)") || str.equalsIgnoreCase("database or disk is full (code 13)")) ? yc.b.D : str.equalsIgnoreCase("UNIQUE constraint failed: requests._id (code 1555)") ? yc.b.G : str.equalsIgnoreCase("fetch download not found") ? yc.b.H : str.equalsIgnoreCase("Fetch data base error") ? yc.b.I : (ie.e.N(str, "request_not_successful", true) || ie.e.N(str, "Failed to connect", true)) ? yc.b.L : ie.e.N(str, "invalid content hash", true) ? yc.b.P : ie.e.N(str, "download_incomplete", true) ? yc.b.M : ie.e.N(str, "failed_to_update_request", true) ? yc.b.Q : ie.e.N(str, "failed_to_add_completed_download", true) ? yc.b.R : ie.e.N(str, "fetch_file_server_invalid_response_type", true) ? yc.b.S : ie.e.N(str, "request_does_not_exist", true) ? yc.b.T : ie.e.N(str, "no_network_connection", true) ? yc.b.E : ie.e.N(str, "file_not_found", true) ? yc.b.N : ie.e.N(str, "fetch_file_server_url_invalid", true) ? yc.b.O : ie.e.N(str, "request_list_not_distinct", true) ? yc.b.W : ie.e.N(str, "enqueue_not_successful", true) ? yc.b.U : ie.e.N(str, "cannot rename file associated with incomplete download", true) ? yc.b.X : ie.e.N(str, "file_cannot_be_renamed", true) ? yc.b.Y : ie.e.N(str, "file_allocation_error", true) ? yc.b.Z : ie.e.N(str, "Cleartext HTTP traffic to", true) ? yc.b.f14646a0 : bVar;
    }

    public static final yc.b l(Exception exc) {
        String message = exc.getMessage();
        if (message == null) {
            message = "";
        }
        boolean z2 = exc instanceof SocketTimeoutException;
        if (z2 && message.length() == 0) {
            message = "timeout";
        }
        yc.b bVarK = k(message);
        yc.b bVar = yc.b.f14649w;
        return (bVarK == bVar && z2) ? yc.b.f14652z : (bVarK == bVar && (exc instanceof IOException)) ? yc.b.M : bVarK;
    }

    public static float m(int i, String[] strArr) {
        float f = Float.parseFloat(strArr[i]);
        if (f >= 0.0f && f <= 1.0f) {
            return f;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f);
    }

    public static final p n(ContentResolver contentResolver, String str) throws FileNotFoundException {
        be.h.e(str, "filePath");
        if (!android.support.v4.media.session.b.F(str)) {
            return o(new File(str));
        }
        Uri uri = Uri.parse(str);
        be.h.d(uri, "parse(...)");
        String scheme = uri.getScheme();
        if (scheme != null) {
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3143036) {
                if (iHashCode == 951530617 && scheme.equals("content")) {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "w");
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        FileDescriptor fileDescriptor = parcelFileDescriptorOpenFileDescriptor.getFileDescriptor();
                        be.h.d(fileDescriptor, "getFileDescriptor(...)");
                        return new p(new FileOutputStream(fileDescriptor));
                    }
                    throw new FileNotFoundException(uri + " file_not_found");
                }
            } else if (scheme.equals("file")) {
                File file = new File(String.valueOf(uri.getPath()));
                if (file.exists() && file.canWrite()) {
                    return o(file);
                }
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor2 = contentResolver.openFileDescriptor(uri, "w");
                if (parcelFileDescriptorOpenFileDescriptor2 != null) {
                    FileDescriptor fileDescriptor2 = parcelFileDescriptorOpenFileDescriptor2.getFileDescriptor();
                    be.h.d(fileDescriptor2, "getFileDescriptor(...)");
                    return new p(new FileOutputStream(fileDescriptor2));
                }
                throw new FileNotFoundException(uri + " file_not_found");
            }
        }
        throw new FileNotFoundException(uri + " file_not_found");
    }

    public static final p o(File file) throws FileNotFoundException {
        if (file.exists()) {
            return new p(new RandomAccessFile(file, "rw"));
        }
        throw new FileNotFoundException(e6.j.m(file.getCanonicalPath(), " file_not_found"));
    }

    public static SharedPreferences p(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    public static v r(Object obj) {
        return obj == null ? v.f4633v : new v(obj);
    }

    public static boolean s(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static Typeface t(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || configuration.fontWeightAdjustment == Integer.MAX_VALUE || configuration.fontWeightAdjustment == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, cf.d.f(configuration.fontWeightAdjustment + typeface.getWeight(), 1, 1000), typeface.isItalic());
    }

    public static l0 u(String str) throws ProtocolException {
        int i;
        String strSubstring;
        be.h.e(str, "statusLine");
        boolean zM = ie.n.M(str, "HTTP/1.", false);
        ue.t tVar = ue.t.f13046v;
        if (zM) {
            i = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int iCharAt = str.charAt(7) - '0';
            if (iCharAt != 0) {
                if (iCharAt != 1) {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                tVar = ue.t.f13047w;
            }
        } else {
            if (!ie.n.M(str, "ICY ", false)) {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            i = 4;
        }
        int i10 = i + 3;
        if (str.length() < i10) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        try {
            String strSubstring2 = str.substring(i, i10);
            be.h.d(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            int i11 = Integer.parseInt(strSubstring2);
            if (str.length() <= i10) {
                strSubstring = "";
            } else {
                if (str.charAt(i10) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                strSubstring = str.substring(i + 4);
                be.h.d(strSubstring, "this as java.lang.String).substring(startIndex)");
            }
            return new l0(tVar, i11, strSubstring, 13);
        } catch (NumberFormatException unused) {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
    }

    public static final List v(y4.c cVar) {
        int i = android.support.v4.media.session.b.i(cVar, "id");
        int i10 = android.support.v4.media.session.b.i(cVar, "seq");
        int i11 = android.support.v4.media.session.b.i(cVar, "from");
        int i12 = android.support.v4.media.session.b.i(cVar, "to");
        pd.c cVarN = android.support.v4.media.session.b.n();
        while (cVar.W()) {
            cVarN.add(new w4.c((int) cVar.getLong(i), (int) cVar.getLong(i10), cVar.j(i11), cVar.j(i12)));
        }
        return od.i.e0(android.support.v4.media.session.b.c(cVarN));
    }

    public static final w4.f w(y4.a aVar, String str, boolean z2) throws Exception {
        y4.c cVarE0 = aVar.e0("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int i = android.support.v4.media.session.b.i(cVarE0, "seqno");
            int i10 = android.support.v4.media.session.b.i(cVarE0, "cid");
            int i11 = android.support.v4.media.session.b.i(cVarE0, "name");
            int i12 = android.support.v4.media.session.b.i(cVarE0, "desc");
            if (i != -1 && i10 != -1 && i11 != -1 && i12 != -1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                while (cVarE0.W()) {
                    if (((int) cVarE0.getLong(i10)) >= 0) {
                        int i13 = (int) cVarE0.getLong(i);
                        String strJ = cVarE0.j(i11);
                        String str2 = cVarE0.getLong(i12) > 0 ? "DESC" : "ASC";
                        linkedHashMap.put(Integer.valueOf(i13), strJ);
                        linkedHashMap2.put(Integer.valueOf(i13), str2);
                    }
                }
                List listF0 = od.i.f0(linkedHashMap.entrySet(), new c0.i(6));
                ArrayList arrayList = new ArrayList(od.k.U(listF0));
                Iterator it = listF0.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Map.Entry) it.next()).getValue());
                }
                List listH0 = od.i.h0(arrayList);
                List listF02 = od.i.f0(linkedHashMap2.entrySet(), new c0.i(7));
                ArrayList arrayList2 = new ArrayList(od.k.U(listF02));
                Iterator it2 = listF02.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((String) ((Map.Entry) it2.next()).getValue());
                }
                w4.f fVar = new w4.f(str, z2, listH0, od.i.h0(arrayList2));
                cf.d.g(cVarE0, null);
                return fVar;
            }
            cf.d.g(cVarE0, null);
            return null;
        } finally {
        }
    }

    public static int x(Context context, int i, int i10) {
        TypedValue typedValueY = z7.a.y(context, i);
        return (typedValueY == null || typedValueY.type != 16) ? i10 : typedValueY.data;
    }

    public static TimeInterpolator y(Context context, int i, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!s(strValueOf, "cubic-bezier") && !s(strValueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (!s(strValueOf, "cubic-bezier")) {
            if (s(strValueOf, "path")) {
                return new PathInterpolator(ga.b.i(strValueOf.substring(5, strValueOf.length() - 1)));
            }
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(strValueOf));
        }
        String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
        if (strArrSplit.length == 4) {
            return new PathInterpolator(m(0, strArrSplit), m(1, strArrSplit), m(2, strArrSplit), m(3, strArrSplit));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }

    public static final Object z(ae.p pVar) {
        Thread.interrupted();
        return x.m(rd.i.f11572u, new d0(pVar, (rd.c) null));
    }

    public abstract void C(boolean z2);

    public abstract void D();

    public abstract void E(int i);

    public abstract void q(int i);

    public void B(boolean z2) {
    }
}
