package android.support.v4.media.session;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.TypedArray;
import android.database.SQLException;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.emoji2.text.y;
import androidx.fragment.app.e;
import c2.v;
import com.bumptech.glide.f;
import com.google.android.gms.internal.measurement.z3;
import f9.a0;
import ge.i;
import hd.j;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kf.p;
import kf.u;
import kf.w;
import kf.x;
import lf.d;
import ne.h;
import ne.o;
import of.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rd.k;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f507a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static v f510d;

    public static final boolean A(long j4, long j7, long j10) {
        return TimeUnit.NANOSECONDS.toMillis(j7 - j4) >= j10;
    }

    public static final boolean C(String str) {
        i.e(str, "url");
        try {
            if (o.Z(str, "fetchlocal://", false) && q(str).length() > 0) {
                if (r(str) > -1) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean D(w4.a aVar, int i, int i10) {
        i.e(aVar, "<this>");
        if (i > i10 && aVar.f13911l) {
            return false;
        }
        Set set = aVar.f13912m;
        return aVar.f13910k && (set == null || !set.contains(Integer.valueOf(i)));
    }

    public static final boolean E(String str) {
        i.e(str, "path");
        if (str.length() <= 0) {
            str = null;
        }
        return str != null && (o.Z(str, "content://", false) || o.Z(str, "file://", false));
    }

    public static rd.c F(fe.a aVar) {
        k kVar = k.f11002a;
        rd.i iVar = new rd.i();
        iVar.f10997v = aVar;
        iVar.f10998w = kVar;
        return iVar;
    }

    public static TypedValue G(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean H(Context context, int i, boolean z10) {
        TypedValue typedValueG = G(context, i);
        return (typedValueG == null || typedValueG.type != 18) ? z10 : typedValueG.data != 0;
    }

    public static TypedValue I(int i, Context context, String str) {
        TypedValue typedValueG = G(context, i);
        if (typedValueG != null) {
            return typedValueG;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static void J(Context context, String str, boolean z10, x xVar, p pVar, z5.k kVar) {
        boolean z11 = false;
        try {
            dd.c cVar = new dd.c();
            if (pVar != null) {
                cVar.f3674y = pVar.c();
            }
            if (z10) {
                if (xVar == null) {
                    int i = x.f7580a;
                    long j4 = 0;
                    d.a(j4, j4, j4);
                    xVar = new w(null, 0, new byte[0]);
                }
                cVar.p("POST", xVar);
            } else {
                cVar.p("GET", null);
            }
            cVar.u(str);
            u uVarB = z5.c.b();
            c2.o oVar = new c2.o(cVar);
            uVarB.getClass();
            new n(uVarB, oVar).e(new vb.b(12, kVar, context, z11));
        } catch (IllegalArgumentException e9) {
            K(kVar, false, e9.getMessage());
        }
    }

    public static void K(z5.k kVar, boolean z10, String str) {
        new Handler(Looper.getMainLooper()).post(new j(2, kVar, str, z10));
    }

    public static final void N(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error code: " + i);
        if (str != null) {
            sb.append(", message: ".concat(str));
        }
        throw new SQLException(sb.toString());
    }

    public static String O(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c9 = charArray[i];
                    if (c9 >= 'A' && c9 <= 'Z') {
                        charArray[i] = (char) (c9 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static String P(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'a' && cCharAt <= 'z') {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c9 = charArray[i];
                    if (c9 >= 'a' && c9 <= 'z') {
                        charArray[i] = (char) (c9 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
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
        String strU = u(linkedHashMap, "Accept-Ranges", "accept-ranges", "AcceptRanges");
        String strU2 = u(linkedHashMap, "Transfer-Encoding", "transfer-encoding", "TransferEncoding");
        long jO = o(linkedHashMap);
        boolean z10 = i == 206 || i.a(strU, "bytes");
        if (jO <= -1 || !z10) {
            if (jO > -1) {
                if (strU2 != null) {
                    lowerCase = strU2.toLowerCase(Locale.ROOT);
                    i.d(lowerCase, "toLowerCase(...)");
                } else {
                    lowerCase = null;
                }
                if (!i.a(lowerCase, "chunked")) {
                }
            }
            return false;
        }
        return true;
    }

    public static final long c(long j4, long j7, long j10) {
        if (j7 >= 1 && j4 >= 1 && j10 >= 1) {
            return ((long) Math.abs(Math.ceil((j7 - j4) / j10))) * ((long) 1000);
        }
        return -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(c5.c cVar, Throwable th) throws Exception {
        if (cVar != 0) {
            if (th != null) {
                try {
                    q4.a.t(cVar);
                    return;
                } catch (Throwable th2) {
                    ab.b.c(th, th2);
                    return;
                }
            }
            if (cVar instanceof AutoCloseable) {
                cVar.close();
                return;
            }
            if (cVar instanceof ExecutorService) {
                a9.b.y((ExecutorService) cVar);
                return;
            }
            if (cVar instanceof TypedArray) {
                ((TypedArray) cVar).recycle();
                return;
            }
            if (cVar instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) cVar).release();
                return;
            }
            if (cVar instanceof MediaDrm) {
                ((MediaDrm) cVar).release();
            } else if (cVar instanceof DrmManagerClient) {
                ((DrmManagerClient) cVar).release();
            } else {
                if (!(cVar instanceof ContentProviderClient)) {
                    throw new IllegalArgumentException();
                }
                ((ContentProviderClient) cVar).release();
            }
        }
    }

    public static final String e(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                sb.append(line);
                sb.append('\n');
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static y f(Context context) {
        ProviderInfo providerInfo;
        q0.d dVar;
        ApplicationInfo applicationInfo;
        o8.j dVar2 = Build.VERSION.SDK_INT >= 28 ? new androidx.emoji2.text.d(2) : new o8.j(2);
        PackageManager packageManager = context.getPackageManager();
        f.f(packageManager, "Package manager required to locate emoji font provider");
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
                Signature[] signatureArrI = dVar2.i(packageManager, str2);
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArrI) {
                    arrayList.add(signature.toByteArray());
                }
                dVar = new q0.d(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList));
            } catch (PackageManager.NameNotFoundException e9) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e9);
                dVar = null;
            }
        }
        if (dVar == null) {
            return null;
        }
        return new y(new androidx.emoji2.text.x(context, dVar));
    }

    public static final void g(File file) {
        if (file.exists()) {
            return;
        }
        if (file.getParentFile() != null) {
            File parentFile = file.getParentFile();
            i.b(parentFile);
            if (!parentFile.exists()) {
                File parentFile2 = file.getParentFile();
                i.b(parentFile2);
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

    public static void i(k4.j jVar) {
        try {
            k4.i iVar = (k4.i) jVar;
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
                parcelObtain.writeInt(0);
                iVar.f7039d.transact(3006, parcelObtain, null, 1);
            } finally {
                parcelObtain.recycle();
            }
        } catch (RemoteException unused) {
        }
    }

    public static boolean j(String str, String str2) {
        char c9;
        int length = str.length();
        if (str == str2) {
            return true;
        }
        if (length == str2.length()) {
            for (int i = 0; i < length; i++) {
                if (str.charAt(i) == str2.charAt(i) || ((c9 = (char) ((r3 | ' ') - 97)) < 26 && c9 == ((char) ((r4 | ' ') - 97)))) {
                }
            }
            return true;
        }
        return false;
    }

    public static final void k(c5.a aVar, String str) throws Exception {
        i.e(aVar, "<this>");
        i.e(str, "sql");
        c5.c cVarC0 = aVar.c0(str);
        try {
            cVarC0.V();
            d(cVarC0, null);
        } finally {
        }
    }

    public static View l(View view, int i) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View viewFindViewById = viewGroup.getChildAt(i10).findViewById(i);
            if (viewFindViewById != null) {
                return viewFindViewById;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0090 A[EDGE_INSN: B:45:0x0090->B:41:0x0090 BREAK  A[LOOP:0: B:11:0x0018->B:49:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List m(w.b r9, int r10, int r11) {
        /*
            java.lang.String r0 = "<this>"
            ge.i.e(r9, r0)
            java.util.LinkedHashMap r9 = r9.f13746a
            if (r10 != r11) goto Lc
            sd.p r9 = sd.p.f11669v
            return r9
        Lc:
            r0 = 0
            r1 = 1
            if (r11 <= r10) goto L12
            r2 = r1
            goto L13
        L12:
            r2 = r0
        L13:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
        L18:
            if (r2 == 0) goto L1d
            if (r10 >= r11) goto L91
            goto L1f
        L1d:
            if (r10 <= r11) goto L91
        L1f:
            r4 = 0
            if (r2 == 0) goto L3a
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)
            java.lang.Object r5 = r9.get(r5)
            java.util.TreeMap r5 = (java.util.TreeMap) r5
            if (r5 != 0) goto L30
        L2e:
            r7 = r4
            goto L50
        L30:
            java.util.NavigableSet r6 = r5.descendingKeySet()
            rd.f r7 = new rd.f
            r7.<init>(r5, r6)
            goto L50
        L3a:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)
            java.lang.Object r5 = r9.get(r5)
            java.util.TreeMap r5 = (java.util.TreeMap) r5
            if (r5 != 0) goto L47
            goto L2e
        L47:
            java.util.Set r6 = r5.keySet()
            rd.f r7 = new rd.f
            r7.<init>(r5, r6)
        L50:
            if (r7 != 0) goto L53
            goto L90
        L53:
            java.lang.Object r5 = r7.f10993v
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r7.f10994w
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L5f:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L8d
            java.lang.Object r7 = r6.next()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            if (r2 == 0) goto L78
            int r8 = r10 + 1
            if (r8 > r7) goto L5f
            if (r7 > r11) goto L5f
            goto L7c
        L78:
            if (r11 > r7) goto L5f
            if (r7 >= r10) goto L5f
        L7c:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r7)
            java.lang.Object r10 = r5.get(r10)
            ge.i.b(r10)
            r3.add(r10)
            r5 = r1
            r10 = r7
            goto L8e
        L8d:
            r5 = r0
        L8e:
            if (r5 != 0) goto L18
        L90:
            return r4
        L91:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.b.m(w.b, int, int):java.util.List");
    }

    public static String n(Context context, String str) {
        return com.bumptech.glide.d.s(context) + str;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long o(java.util.LinkedHashMap r6) {
        /*
            java.lang.String r0 = "content-range"
            java.lang.String r1 = "ContentRange"
            java.lang.String r2 = "Content-Range"
            java.lang.String[] r0 = new java.lang.String[]{r2, r0, r1}
            java.lang.String r0 = u(r6, r0)
            if (r0 == 0) goto L1b
            java.lang.String r1 = "/"
            int r1 = ne.h.m0(r0, r1)
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
            ge.i.d(r0, r1)
            java.lang.Long r0 = ne.o.b0(r0)
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
            java.lang.String r6 = u(r6, r0)
            if (r6 == 0) goto L6b
            java.lang.Long r6 = ne.o.b0(r6)
            if (r6 == 0) goto L6b
            long r0 = r6.longValue()
            return r0
        L6b:
            return r2
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.b.o(java.util.LinkedHashMap):long");
    }

    public static void p(Context context, String str, p pVar, z5.k kVar, boolean z10) {
        if (z10) {
            try {
                if (!com.bumptech.glide.d.t(context).getBoolean("is_tv", false)) {
                    if (new ad.b(context, false).c()) {
                        z3.v(context);
                        return;
                    } else {
                        if (z3.u(context)) {
                            throw new Exception("p");
                        }
                        p(context, str, pVar, kVar, false);
                        return;
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (z3.u(context)) {
            throw new Exception("p");
        }
        J(context, str, false, null, pVar, kVar);
    }

    public static final String q(String str) {
        i.e(str, "url");
        String strSubstring = str.substring(h.i0(str, "//", 0, false, 6) + 2, h.m0(str, ":"));
        i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final int r(String str) {
        i.e(str, "url");
        String strSubstring = str.substring(h.m0(str, ":") + 1, str.length());
        i.d(strSubstring, "substring(...)");
        int iI0 = h.i0(strSubstring, "/", 0, false, 6);
        if (iI0 == -1) {
            return Integer.parseInt(strSubstring);
        }
        String strSubstring2 = strSubstring.substring(0, iI0);
        i.d(strSubstring2, "substring(...)");
        return Integer.parseInt(strSubstring2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.File s(java.lang.String r1) throws java.io.IOException {
        /*
            java.lang.String r0 = "filePath"
            ge.i.e(r1, r0)
            java.io.File r0 = new java.io.File
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L37
            java.io.File r1 = r0.getParentFile()
            if (r1 == 0) goto L34
            java.io.File r1 = r0.getParentFile()
            ge.i.b(r1)
            boolean r1 = r1.exists()
            if (r1 != 0) goto L34
            java.io.File r1 = r0.getParentFile()
            ge.i.b(r1)
            boolean r1 = r1.mkdirs()
            if (r1 == 0) goto L37
            r0.createNewFile()
            return r0
        L34:
            r0.createNewFile()
        L37:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.b.s(java.lang.String):java.io.File");
    }

    public static final Uri t(String str) {
        i.e(str, "path");
        if (E(str)) {
            Uri uri = Uri.parse(str);
            i.d(uri, "parse(...)");
            return uri;
        }
        Uri uriFromFile = Uri.fromFile(new File(str));
        i.d(uriFromFile, "fromFile(...)");
        return uriFromFile;
    }

    public static final String u(LinkedHashMap linkedHashMap, String... strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return null;
            }
            List list = (List) linkedHashMap.get(strArr[i]);
            String str = list != null ? (String) sd.j.i0(list) : null;
            if (str != null && !h.k0(str)) {
                return str;
            }
            i++;
        }
    }

    public static void v(String str, z5.k kVar) {
        try {
            JSONObject jSONObject = new JSONArray(str).getJSONObject(0);
            J(null, jSONObject.getString("playlist"), false, null, null, new e(26, jSONObject.getString("channel"), kVar));
        } catch (ArrayIndexOutOfBoundsException | JSONException unused) {
            kVar.f("https://error.m3u8", false);
        }
    }

    public static final Long w(String str) throws IOException {
        i.e(str, "filePath");
        File fileS = s(str);
        if (fileS.exists()) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileS, "r");
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

    public static final String x(String str) {
        i.e(str, "url");
        try {
            Uri uri = Uri.parse(str);
            return uri.getScheme() + "://" + uri.getAuthority();
        } catch (Exception unused) {
            return "https://google.com";
        }
    }

    public static final Set y(dd.c cVar, md.e eVar) {
        Set setW = u8.a.w(md.c.f8424v);
        try {
            md.d dVarD = eVar.D(cVar, new a0(18));
            if (dVarD != null) {
                if (a(dVarD.f8427a, dVarD.f8431e)) {
                    setW.add(md.c.f8425w);
                }
                eVar.H(dVarD);
            }
        } catch (Exception unused) {
        }
        return setW;
    }

    public void B(c5.a aVar, Object obj) throws Exception {
        i.e(aVar, "connection");
        c5.c cVarC0 = aVar.c0(h());
        try {
            b(cVarC0, obj);
            cVarC0.V();
            d(cVarC0, null);
        } finally {
        }
    }

    public void L(View view, float f) {
        if (f507a) {
            try {
                l5.y.b(view, f);
                return;
            } catch (NoSuchMethodError unused) {
                f507a = false;
            }
        }
        view.setAlpha(f);
    }

    public void M(View view, int i) {
        if (!f509c) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f508b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            f509c = true;
        }
        Field field = f508b;
        if (field != null) {
            try {
                f508b.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract void b(c5.c cVar, Object obj);

    public abstract String h();

    public float z(View view) {
        if (f507a) {
            try {
                return l5.y.a(view);
            } catch (NoSuchMethodError unused) {
                f507a = false;
            }
        }
        return view.getAlpha();
    }
}
