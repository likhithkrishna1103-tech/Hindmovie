package android.support.v4.media.session;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;
import b8.h;
import cf.d;
import dd.n;
import e6.j;
import ea.o;
import ea.p;
import id.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import od.i;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final Set A(zc.c cVar, e eVar) {
        Set setS = d.s(id.c.f6568u);
        try {
            id.d dVarT = eVar.t(cVar, new q9.e(14));
            if (dVarT != null) {
                if (a(dVarT.f6571a, dVarT.f6575e)) {
                    setS.add(id.c.f6569v);
                }
                eVar.C(dVarT);
            }
        } catch (Exception unused) {
        }
        return setS;
    }

    public static final boolean B(long j5, long j8, long j10) {
        return TimeUnit.NANOSECONDS.toMillis(j8 - j5) >= j10;
    }

    public static int C(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 32) {
            return 5;
        }
        if (i == 64) {
            return 6;
        }
        if (i == 128) {
            return 7;
        }
        if (i == 256) {
            return 8;
        }
        if (i == 512) {
            return 9;
        }
        throw new IllegalArgumentException(j.l("type needs to be >= FIRST and <= LAST, type=", i));
    }

    public static void D(Context context) {
        Context applicationContext;
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        if (h.p(context).getBoolean("proxy_notification_initialized", false)) {
            return;
        }
        try {
            applicationContext = context.getApplicationContext();
            packageManager = applicationContext.getPackageManager();
        } catch (PackageManager.NameNotFoundException unused) {
        }
        boolean z2 = (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_notification_delegation_enabled")) ? true : applicationInfo.metaData.getBoolean("firebase_messaging_notification_delegation_enabled");
        if (Build.VERSION.SDK_INT >= 29) {
            new n(2, context, new o8.h(), z2).run();
        } else {
            t1.k(null);
        }
    }

    public static final boolean E(String str) {
        be.h.e(str, "url");
        try {
            if (ie.n.M(str, "fetchlocal://", false) && t(str).length() > 0) {
                if (u(str) > -1) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean F(String str) {
        be.h.e(str, "path");
        if (str.length() <= 0) {
            str = null;
        }
        return str != null && (ie.n.M(str, "content://", false) || ie.n.M(str, "file://", false));
    }

    public static List G(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        be.h.d(listSingletonList, "singletonList(...)");
        return listSingletonList;
    }

    public static String H(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb2 = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb2.append(str.charAt(i));
            if (str2.length() > i) {
                sb2.append(str2.charAt(i));
            }
        }
        return sb2.toString();
    }

    public static void K(t3.d dVar, int i, s1.h hVar) {
        long jF = dVar.f(i);
        List listI = dVar.i(jF);
        if (listI.isEmpty()) {
            return;
        }
        if (i == dVar.j() - 1) {
            throw new IllegalStateException();
        }
        long jF2 = dVar.f(i + 1) - dVar.f(i);
        if (jF2 > 0) {
            hVar.accept(new t3.a(jF, jF2, listI));
        }
    }

    public static final boolean L(String str) {
        be.h.e(str, "method");
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static final void O(String str, int i) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Error code: " + i);
        if (str != null) {
            sb2.append(", message: ".concat(str));
        }
        throw new SQLException(sb2.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void P(t3.d r12, t3.l r13, s1.h r14) {
        /*
            long r0 = r13.f12094a
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r5 = 0
            if (r4 != 0) goto Le
            r4 = r5
            goto L27
        Le:
            int r4 = r12.a(r0)
            r6 = -1
            if (r4 != r6) goto L19
            int r4 = r12.j()
        L19:
            if (r4 <= 0) goto L27
            int r6 = r4 + (-1)
            long r6 = r12.f(r6)
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 != 0) goto L27
            int r4 = r4 + (-1)
        L27:
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L51
            int r2 = r12.j()
            if (r4 >= r2) goto L51
            java.util.List r11 = r12.i(r0)
            long r2 = r12.f(r4)
            boolean r6 = r11.isEmpty()
            if (r6 != 0) goto L51
            long r7 = r13.f12094a
            int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r6 >= 0) goto L51
            t3.a r6 = new t3.a
            long r9 = r2 - r7
            r6.<init>(r7, r9, r11)
            r14.accept(r6)
            r2 = 1
            goto L52
        L51:
            r2 = r5
        L52:
            r3 = r4
        L53:
            int r6 = r12.j()
            if (r3 >= r6) goto L5f
            K(r12, r3, r14)
            int r3 = r3 + 1
            goto L53
        L5f:
            boolean r13 = r13.f12095b
            if (r13 == 0) goto L87
            if (r2 == 0) goto L67
            int r4 = r4 + (-1)
        L67:
            if (r5 >= r4) goto L6f
            K(r12, r5, r14)
            int r5 = r5 + 1
            goto L67
        L6f:
            if (r2 == 0) goto L87
            t3.a r6 = new t3.a
            java.util.List r11 = r12.i(r0)
            long r7 = r12.f(r4)
            long r12 = r12.f(r4)
            long r9 = r0 - r12
            r6.<init>(r7, r9, r11)
            r14.accept(r6)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.b.P(t3.d, t3.l, s1.h):void");
    }

    public static Bundle Q(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(b.class.getClassLoader());
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    public static final boolean a(int i, LinkedHashMap linkedHashMap) {
        String lowerCase;
        String strX = x(linkedHashMap, "Accept-Ranges", "accept-ranges", "AcceptRanges");
        String strX2 = x(linkedHashMap, "Transfer-Encoding", "transfer-encoding", "TransferEncoding");
        long jS = s(linkedHashMap);
        boolean z2 = i == 206 || be.h.a(strX, "bytes");
        if (jS <= -1 || !z2) {
            if (jS > -1) {
                if (strX2 != null) {
                    lowerCase = strX2.toLowerCase(Locale.ROOT);
                    be.h.d(lowerCase, "toLowerCase(...)");
                } else {
                    lowerCase = null;
                }
                if (!be.h.a(lowerCase, "chunked")) {
                }
            }
            return false;
        }
        return true;
    }

    public static void b(SpannableStringBuilder spannableStringBuilder, Object obj, int i, int i10) {
        for (Object obj2 : spannableStringBuilder.getSpans(i, i10, obj.getClass())) {
            if (spannableStringBuilder.getSpanStart(obj2) == i && spannableStringBuilder.getSpanEnd(obj2) == i10 && spannableStringBuilder.getSpanFlags(obj2) == 33) {
                spannableStringBuilder.removeSpan(obj2);
            }
        }
        spannableStringBuilder.setSpan(obj, i, i10, 33);
    }

    public static pd.c c(pd.c cVar) {
        cVar.i();
        cVar.f10349w = true;
        return cVar.f10348v > 0 ? cVar : pd.c.f10346x;
    }

    public static final long d(long j5, long j8, long j10) {
        if (j8 >= 1 && j5 >= 1 && j10 >= 1) {
            return ((long) Math.abs(Math.ceil((j8 - j5) / j10))) * ((long) 1000);
        }
        return -1L;
    }

    public static int h(int i, int i10) {
        long j5 = ((long) i) + ((long) i10);
        int i11 = (int) j5;
        if (j5 == ((long) i11)) {
            return i11;
        }
        throw new ArithmeticException("overflow: checkedAdd(" + i + ", " + i10 + ")");
    }

    public static final int i(y4.c cVar, String str) {
        be.h.e(cVar, "<this>");
        int iJ = j(cVar, str);
        if (iJ >= 0) {
            return iJ;
        }
        int iJ2 = j(cVar, "`" + str + '`');
        if (iJ2 >= 0) {
            return iJ2;
        }
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        int columnCount = cVar.getColumnCount();
        String strConcat = ".".concat(str);
        String str2 = "." + str + '`';
        for (int i = 0; i < columnCount; i++) {
            String columnName = cVar.getColumnName(i);
            if (columnName.length() >= str.length() + 2 && (ie.n.H(columnName, strConcat) || (columnName.charAt(0) == '`' && ie.n.H(columnName, str2)))) {
                return i;
            }
        }
        return -1;
    }

    public static final int j(y4.c cVar, String str) {
        be.h.e(cVar, "<this>");
        be.h.e(str, "name");
        int columnCount = cVar.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            if (str.equals(cVar.getColumnName(i))) {
                return i;
            }
        }
        return -1;
    }

    public static final long k(long j5, je.c cVar, je.c cVar2) {
        be.h.e(cVar, "sourceUnit");
        be.h.e(cVar2, "targetUnit");
        return cVar2.f6966u.convert(j5, cVar.f6966u);
    }

    public static final String l(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb2 = new StringBuilder();
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                sb2.append(line);
                sb2.append('\n');
            }
            return sb2.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static final void m(File file) {
        if (file.exists()) {
            return;
        }
        if (file.getParentFile() != null) {
            File parentFile = file.getParentFile();
            be.h.b(parentFile);
            if (!parentFile.exists()) {
                File parentFile2 = file.getParentFile();
                be.h.b(parentFile2);
                if (!parentFile2.mkdirs()) {
                    throw new FileNotFoundException(file + " file_not_found");
                }
                if (file.createNewFile()) {
                    return;
                }
                throw new FileNotFoundException(file + " file_not_found");
            }
        }
        if (file.createNewFile()) {
            return;
        }
        throw new FileNotFoundException(file + " file_not_found");
    }

    public static pd.c n() {
        return new pd.c(10);
    }

    public static final void o(y4.a aVar, String str) throws Exception {
        be.h.e(aVar, "<this>");
        be.h.e(str, "sql");
        y4.c cVarE0 = aVar.e0(str);
        try {
            cVarE0.W();
            d.g(cVarE0, null);
        } finally {
        }
    }

    public static final int r(y4.c cVar, String str) {
        be.h.e(cVar, "stmt");
        int i = i(cVar, str);
        if (i >= 0) {
            return i;
        }
        int columnCount = cVar.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i10 = 0; i10 < columnCount; i10++) {
            arrayList.add(cVar.getColumnName(i10));
        }
        throw new IllegalArgumentException("Column '" + str + "' does not exist. Available columns: [" + i.b0(arrayList, null, null, null, null, 63) + ']');
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long s(java.util.LinkedHashMap r6) {
        /*
            java.lang.String r0 = "content-range"
            java.lang.String r1 = "ContentRange"
            java.lang.String r2 = "Content-Range"
            java.lang.String[] r0 = new java.lang.String[]{r2, r0, r1}
            java.lang.String r0 = x(r6, r0)
            if (r0 == 0) goto L1b
            java.lang.String r1 = "/"
            int r1 = ie.e.W(r0, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L1c
        L1b:
            r1 = 0
        L1c:
            r2 = -1
            if (r1 == 0) goto L4b
            r4 = -1
            int r5 = r1.intValue()
            if (r5 == r4) goto L4b
            int r4 = r1.intValue()
            int r5 = r0.length()
            if (r4 >= r5) goto L4b
            int r1 = r1.intValue()
            int r1 = r1 + 1
            java.lang.String r0 = r0.substring(r1)
            java.lang.String r1 = "substring(...)"
            be.h.d(r0, r1)
            java.lang.Long r0 = ie.m.G(r0)
            if (r0 == 0) goto L4b
            long r0 = r0.longValue()
            goto L4c
        L4b:
            r0 = r2
        L4c:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            java.lang.String r0 = "Content-Length"
            java.lang.String r1 = "ContentLength"
            java.lang.String r4 = "content-length"
            java.lang.String[] r0 = new java.lang.String[]{r4, r0, r1}
            java.lang.String r6 = x(r6, r0)
            if (r6 == 0) goto L6b
            java.lang.Long r6 = ie.m.G(r6)
            if (r6 == 0) goto L6b
            long r0 = r6.longValue()
            return r0
        L6b:
            return r2
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.b.s(java.util.LinkedHashMap):long");
    }

    public static final String t(String str) {
        be.h.e(str, "url");
        String strSubstring = str.substring(ie.e.R(6, str, "//", false) + 2, ie.e.W(str, ":"));
        be.h.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final int u(String str) {
        be.h.e(str, "url");
        String strSubstring = str.substring(ie.e.W(str, ":") + 1, str.length());
        be.h.d(strSubstring, "substring(...)");
        int iR = ie.e.R(6, strSubstring, "/", false);
        if (iR == -1) {
            return Integer.parseInt(strSubstring);
        }
        String strSubstring2 = strSubstring.substring(0, iR);
        be.h.d(strSubstring2, "substring(...)");
        return Integer.parseInt(strSubstring2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.File v(java.lang.String r1) throws java.io.IOException {
        /*
            java.lang.String r0 = "filePath"
            be.h.e(r1, r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L37
            java.io.File r1 = r0.getParentFile()
            if (r1 == 0) goto L34
            java.io.File r1 = r0.getParentFile()
            be.h.b(r1)
            boolean r1 = r1.exists()
            if (r1 != 0) goto L34
            java.io.File r1 = r0.getParentFile()
            be.h.b(r1)
            boolean r1 = r1.mkdirs()
            if (r1 == 0) goto L37
            r0.createNewFile()
            return r0
        L34:
            r0.createNewFile()
        L37:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.b.v(java.lang.String):java.io.File");
    }

    public static final Uri w(String str) {
        be.h.e(str, "path");
        if (F(str)) {
            Uri uri = Uri.parse(str);
            be.h.d(uri, "parse(...)");
            return uri;
        }
        Uri uriFromFile = Uri.fromFile(new File(str));
        be.h.d(uriFromFile, "fromFile(...)");
        return uriFromFile;
    }

    public static final String x(LinkedHashMap linkedHashMap, String... strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return null;
            }
            List list = (List) linkedHashMap.get(strArr[i]);
            String str = list != null ? (String) i.Y(list) : null;
            if (str != null && !ie.e.U(str)) {
                return str;
            }
            i++;
        }
    }

    public static final Long y(String str) throws IOException {
        be.h.e(str, "filePath");
        File fileV = v(str);
        if (fileV.exists()) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileV, "r");
            try {
                try {
                    Long lValueOf = Long.valueOf(randomAccessFile.readLong());
                    try {
                        randomAccessFile.close();
                        return lValueOf;
                    } catch (Exception unused) {
                        return lValueOf;
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                randomAccessFile.close();
                return null;
            } catch (Throwable th) {
                try {
                    randomAccessFile.close();
                } catch (Exception unused4) {
                }
                throw th;
            }
        }
        return null;
    }

    public static final String z(String str) {
        be.h.e(str, "url");
        try {
            Uri uri = Uri.parse(str);
            return uri.getScheme() + "://" + uri.getAuthority();
        } catch (Exception unused) {
            return "https://google.com";
        }
    }

    public abstract void I(int i);

    public abstract void J(Typeface typeface, boolean z2);

    public abstract void M(o oVar, o oVar2);

    public abstract void N(o oVar, Thread thread);

    public abstract boolean e(p pVar, ea.d dVar, ea.d dVar2);

    public abstract boolean f(p pVar, Object obj, Object obj2);

    public abstract boolean g(p pVar, o oVar, o oVar2);

    public abstract ea.d p(p pVar);

    public abstract o q(p pVar);
}
