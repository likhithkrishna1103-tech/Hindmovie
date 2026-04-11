package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import app.cricfy.tv.app.ProApplication;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ta.g f2493a;

    public static String A(X509Certificate x509Certificate) throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder("sha256/");
        ag.h hVar = ag.h.f430y;
        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
        ge.i.d(encoded, "getEncoded(...)");
        int length = encoded.length;
        int i = 0;
        u8.a.f(encoded.length, 0, length);
        byte[] bArrJ = sd.i.j(encoded, 0, length);
        ag.h hVar2 = new ag.h(bArrJ);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bArrJ, 0, hVar2.a());
        byte[] bArrDigest = messageDigest.digest();
        ge.i.b(bArrDigest);
        new ag.h(bArrDigest);
        byte[] bArr = ag.a.f417a;
        ge.i.e(bArr, "map");
        byte[] bArr2 = new byte[((bArrDigest.length + 2) / 3) * 4];
        int length2 = bArrDigest.length - (bArrDigest.length % 3);
        int i10 = 0;
        while (i < length2) {
            byte b8 = bArrDigest[i];
            int i11 = i + 2;
            byte b10 = bArrDigest[i + 1];
            i += 3;
            byte b11 = bArrDigest[i11];
            bArr2[i10] = bArr[(b8 & 255) >> 2];
            bArr2[i10 + 1] = bArr[((b8 & 3) << 4) | ((b10 & 255) >> 4)];
            int i12 = i10 + 3;
            bArr2[i10 + 2] = bArr[((b10 & 15) << 2) | ((b11 & 255) >> 6)];
            i10 += 4;
            bArr2[i12] = bArr[b11 & 63];
        }
        int length3 = bArrDigest.length - length2;
        if (length3 == 1) {
            byte b12 = bArrDigest[i];
            bArr2[i10] = bArr[(b12 & 255) >> 2];
            bArr2[i10 + 1] = bArr[(b12 & 3) << 4];
            bArr2[i10 + 2] = 61;
            bArr2[i10 + 3] = 61;
        } else if (length3 == 2) {
            int i13 = i + 1;
            byte b13 = bArrDigest[i];
            byte b14 = bArrDigest[i13];
            bArr2[i10] = bArr[(b13 & 255) >> 2];
            bArr2[i10 + 1] = bArr[((b13 & 3) << 4) | ((b14 & 255) >> 4)];
            bArr2[i10 + 2] = bArr[(b14 & 15) << 2];
            bArr2[i10 + 3] = 61;
        }
        sb.append(new String(bArr2, ne.a.f9126a));
        return sb.toString();
    }

    public static final void B(int i, int i10, String str) {
        ge.i.e(str, "fileTempDir");
        try {
            String strL = l(i, str);
            long j4 = i10;
            ge.i.e(strL, "filePath");
            File fileS = android.support.v4.media.session.b.s(strL);
            if (fileS.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileS, "rw");
                try {
                    randomAccessFile.seek(0L);
                    randomAccessFile.setLength(0L);
                    randomAccessFile.writeLong(j4);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
                randomAccessFile.close();
            }
        } catch (Exception unused3) {
        }
    }

    public static void C(Context context) {
        try {
            String string = context.getString(q5.o.app_name);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", string);
            intent.putExtra("android.intent.extra.TEXT", (string + " is the world's Number 1 Sports app. You can watch free All Live Sports Events, Worldwide TV Channels and more....\n\nDownload Now! ") + ProApplication.K.H);
            context.startActivity(Intent.createChooser(intent, "choose one"));
        } catch (Exception unused) {
        }
    }

    public static boolean D(Intent intent) {
        Bundle extras;
        if (intent == null || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction()) || (extras = intent.getExtras()) == null) {
            return false;
        }
        return "1".equals(extras.getString("google.c.a.e"));
    }

    public static void E(Activity activity) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT < 30) {
            window.clearFlags(1024);
            window.getDecorView().setSystemUiVisibility(0);
        } else {
            l4.a aVar = new l4.a(window.getDecorView());
            int i = Build.VERSION.SDK_INT;
            (i >= 35 ? new t0.t1(window, aVar) : i >= 30 ? new t0.s1(window, aVar) : i >= 26 ? new t0.r1(window, aVar) : new t0.q1(window, aVar)).D(WindowInsets.Type.systemBars());
            w8.e.l(window, true);
        }
    }

    public static String F(String str) {
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("keys");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String strG = G(jSONObject.getString("kid"), jSONObject.getString("k"));
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(strG);
            }
            return "{\"keys\":[" + sb.toString() + "],\"type\":\"temporary\"}".replaceAll("\\n", "");
        } catch (JSONException e9) {
            Log.e("Pro toClearkeyJson 1", e9.toString());
            return str;
        }
    }

    public static String G(String str, String str2) {
        return "{\"kty\":\"oct\",\"k\":\"" + str2.trim().replaceAll("\\n", "") + "\",\"kid\":\"" + str.trim().replaceAll("\\n", "") + "\"}";
    }

    public static ArrayList H(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 1) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        }
        return arrayList;
    }

    public static void J(int i, Object[] objArr) {
        for (int i10 = 0; i10 < i; i10++) {
            if (objArr[i10] == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 9);
                sb.append("at index ");
                sb.append(i10);
                throw new NullPointerException(sb.toString());
            }
        }
    }

    public static n K(d dVar, b6.f fVar, ArrayList arrayList, boolean z10) {
        n nVarE;
        n5.a.T("reduce", 1, arrayList);
        n5.a.U("reduce", 2, arrayList);
        n nVarC = ((t) fVar.f1801x).c(fVar, (n) arrayList.get(0));
        if (!(nVarC instanceof h)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (arrayList.size() == 2) {
            nVarE = ((t) fVar.f1801x).c(fVar, (n) arrayList.get(1));
            if (nVarE instanceof f) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else {
            if (dVar.m() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            nVarE = null;
        }
        h hVar = (h) nVarC;
        int iM = dVar.m();
        int i = z10 ? 0 : iM - 1;
        int i10 = z10 ? iM - 1 : 0;
        int i11 = true == z10 ? 1 : -1;
        if (nVarE == null) {
            nVarE = dVar.n(i);
            i += i11;
        }
        while ((i10 - i) * i11 >= 0) {
            if (dVar.p(i)) {
                nVarE = hVar.e(fVar, Arrays.asList(nVarE, dVar.n(i), new g(Double.valueOf(i)), dVar));
                if (nVarE instanceof f) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i += i11;
            } else {
                i += i11;
            }
        }
        return nVarE;
    }

    public static d L(d dVar, b6.f fVar, m mVar, Boolean bool, Boolean bool2) {
        d dVar2 = new d();
        Iterator itL = dVar.l();
        while (itL.hasNext()) {
            int iIntValue = ((Integer) itL.next()).intValue();
            if (dVar.p(iIntValue)) {
                n nVarE = mVar.e(fVar, Arrays.asList(dVar.n(iIntValue), new g(Double.valueOf(iIntValue)), dVar));
                if (nVarE.a().equals(bool)) {
                    break;
                }
                if (bool2 == null || nVarE.a().equals(bool2)) {
                    dVar2.o(iIntValue, nVarE);
                }
            }
        }
        return dVar2;
    }

    public static String a(String str) {
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            Charset charset = StandardCharsets.UTF_8;
            try {
                byte[] bytes = new String(bArrDecode, charset).getBytes(charset);
                StringBuilder sb = new StringBuilder();
                for (byte b8 : bytes) {
                    String hexString = Integer.toHexString(b8 & 255);
                    if (hexString.length() == 1) {
                        sb.append('0');
                    }
                    sb.append(hexString);
                }
                return sb.toString();
            } catch (IllegalArgumentException e9) {
                return e9.getMessage();
            }
        } catch (IllegalArgumentException e10) {
            return e10.getMessage();
        }
    }

    public static void b(int i, int i10, int i11) {
        if (i < 0 || i10 > i11) {
            StringBuilder sbR = q4.a.r(i, i10, "fromIndex: ", ", toIndex: ", ", size: ");
            sbR.append(i11);
            throw new IndexOutOfBoundsException(sbR.toString());
        }
        if (i > i10) {
            throw new IllegalArgumentException(q4.a.m(i, i10, "fromIndex: ", " > toIndex: "));
        }
    }

    public static int c(int i, int i10) {
        long j4 = ((long) i) + ((long) i10);
        int i11 = (int) j4;
        if (j4 == ((long) i11)) {
            return i11;
        }
        throw new ArithmeticException("overflow: checkedAdd(" + i + ", " + i10 + ")");
    }

    public static final void d(int i, String str) {
        File[] fileArrListFiles;
        ge.i.e(str, "fileTempDir");
        try {
            File file = new File(str);
            if (!file.exists() || (fileArrListFiles = file.listFiles()) == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            for (File file2 : fileArrListFiles) {
                ge.i.b(file2);
                if (ne.o.Z(ce.a.M(file2), i + ".", false)) {
                    arrayList.add(file2);
                }
            }
            int size = arrayList.size();
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                File file3 = (File) obj;
                if (file3.exists()) {
                    file3.delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    public static boolean e() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            ab.g.c();
            ab.g gVarC = ab.g.c();
            gVarC.a();
            Context context = gVarC.f390a;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
                    return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        } catch (IllegalStateException unused2) {
            Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
            return false;
        }
    }

    public static int f(boolean z10) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        List supportedPerformancePoints;
        try {
            v1.o oVar = new v1.o();
            oVar.f12893m = v1.m0.p("video/avc");
            v1.p pVar = new v1.p(oVar);
            String str = pVar.f12946n;
            if (str != null) {
                List listD = p2.x.d(str, z10, false);
                String strB = p2.x.b(pVar);
                Iterable iterableD = strB == null ? ua.z0.f12413z : p2.x.d(strB, z10, false);
                ua.f0 f0VarJ = ua.i0.j();
                f0VarJ.d(listD);
                f0VarJ.d(iterableD);
                ua.z0 z0VarG = f0VarJ.g();
                for (int i = 0; i < z0VarG.f12415y; i++) {
                    if (((p2.o) z0VarG.get(i)).f9928d != null && (videoCapabilities = ((p2.o) z0VarG.get(i)).f9928d.getVideoCapabilities()) != null && (supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints()) != null && !supportedPerformancePoints.isEmpty()) {
                        o.k1.j();
                        MediaCodecInfo.VideoCapabilities.PerformancePoint performancePointE = o.k1.e();
                        for (int i10 = 0; i10 < supportedPerformancePoints.size(); i10++) {
                            if (o.k1.g(supportedPerformancePoints.get(i10)).covers(performancePointE)) {
                                return 2;
                            }
                        }
                        return 1;
                    }
                }
            }
        } catch (p2.u unused) {
        }
        return 0;
    }

    public static androidx.navigation.p g(View view) {
        androidx.navigation.p pVar;
        View view2 = view;
        while (true) {
            pVar = null;
            if (view2 == null) {
                break;
            }
            Object tag = view2.getTag(androidx.navigation.c0.nav_controller_view_tag);
            androidx.navigation.p pVar2 = tag instanceof WeakReference ? (androidx.navigation.p) ((WeakReference) tag).get() : tag instanceof androidx.navigation.p ? (androidx.navigation.p) tag : null;
            if (pVar2 != null) {
                pVar = pVar2;
                break;
            }
            Object parent = view2.getParent();
            view2 = parent instanceof View ? (View) parent : null;
        }
        if (pVar != null) {
            return pVar;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    public static final String h(int i, int i10, String str) {
        ge.i.e(str, "fileTempDir");
        return str + "/" + i + "." + i10 + ".data";
    }

    public static Drawable i(Context context, int i) {
        return o.o2.d().f(context, i);
    }

    public static SimpleDateFormat j(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static HashMap k(String str) {
        if (str == null) {
            return new HashMap();
        }
        String[] strArrSplit = str.split("\\&");
        HashMap map = new HashMap();
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = str2.split("\\=");
            if (strArrSplit2.length != 1) {
                String str3 = strArrSplit2[1];
                if (strArrSplit2.length > 2) {
                    for (int i = 2; strArrSplit2.length != i; i++) {
                        str3 = str3 + "=" + strArrSplit2[i];
                    }
                }
                if (strArrSplit2[0].equalsIgnoreCase("user-agent")) {
                    map.put("user-agent", str3);
                } else {
                    map.put(strArrSplit2[0], str3);
                }
            } else if (strArrSplit2[0].equalsIgnoreCase("user-agent")) {
                map.put("user-agent", "null");
            } else {
                map.put(strArrSplit2[0], "");
            }
        }
        return map;
    }

    public static final String l(int i, String str) {
        ge.i.e(str, "fileTempDir");
        return str + "/" + i + ".meta.data";
    }

    public static String m(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.contains(".m3u8")) {
            return "application/x-mpegURL";
        }
        if (str.contains(".ts")) {
            return "video/mp2t";
        }
        if (str.contains(".mpd")) {
            return "application/dash+xml";
        }
        if (str.contains(".php") || str.contains(".js") || str.contains(".json")) {
            return (!str.contains("=m3u8") && str.contains("=ts")) ? "video/mp2t" : "application/x-mpegURL";
        }
        return null;
    }

    public static final dd.c n(dd.e eVar, String str) {
        ge.i.e(eVar, "download");
        return p(eVar, -1L, -1L, str, 0, 16);
    }

    public static dd.c p(dd.e eVar, long j4, long j7, String str, int i, int i10) {
        if ((i10 & 8) != 0) {
            str = "GET";
        }
        String str2 = str;
        ge.i.e(eVar, "download");
        if (j4 == -1) {
            j4 = 0;
        }
        String strValueOf = j7 == -1 ? "" : String.valueOf(j7);
        LinkedHashMap linkedHashMapD = sd.s.D(eVar.B);
        linkedHashMapD.put("Range", "bytes=" + j4 + "-" + strValueOf);
        String str3 = eVar.f3678x;
        String str4 = eVar.f3679y;
        return new dd.c(str3, linkedHashMapD, str4, android.support.v4.media.session.b.t(str4), str2, eVar.M);
    }

    public static ArrayList q(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        String str3 = "";
        boolean z10 = true;
        for (String str4 : str.split("&")) {
            String[] strArrSplit = str4.split("=");
            String str5 = strArrSplit[0];
            String strSubstring = strArrSplit.length > 1 ? str4.substring(str5.length() + 1) : "";
            if (str5.toLowerCase().equals(str2)) {
                str3 = strSubstring;
            } else if (z10) {
                sb.append(str5);
                sb.append("=");
                sb.append(strSubstring);
                z10 = false;
            } else {
                sb.append("&");
                sb.append(str5);
                sb.append("=");
                sb.append(strSubstring);
            }
        }
        arrayList.add(sb.toString());
        arrayList.add(str3);
        return arrayList;
    }

    public static String r(Context context) {
        CharSequence text;
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        return (!clipboardManager.hasPrimaryClip() || clipboardManager.getPrimaryClip().getItemCount() <= 0 || (text = clipboardManager.getPrimaryClip().getItemAt(0).getText()) == null) ? "" : text.toString();
    }

    public static String s(String str) {
        try {
            int length = str.length();
            byte[] bArr = new byte[length / 2];
            for (int i = 0; i < length; i += 2) {
                bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
            }
            return Base64.encodeToString(bArr, 0);
        } catch (IllegalArgumentException e9) {
            return e9.getMessage();
        }
    }

    public static void t(Activity activity) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT < 30) {
            window.setFlags(1024, 1024);
            window.getDecorView().setSystemUiVisibility(5638);
            return;
        }
        l4.a aVar = new l4.a(window.getDecorView());
        int i = Build.VERSION.SDK_INT;
        ab.b t1Var = i >= 35 ? new t0.t1(window, aVar) : i >= 30 ? new t0.s1(window, aVar) : i >= 26 ? new t0.r1(window, aVar) : new t0.q1(window, aVar);
        t1Var.p(WindowInsets.Type.systemBars());
        t1Var.C();
        w8.e.l(window, false);
    }

    public static boolean u(String str, String str2) {
        Date date;
        Date date2;
        Date date3;
        Date date4;
        try {
            SimpleDateFormat simpleDateFormatJ = j("dd/MM/yyyy");
            SimpleDateFormat simpleDateFormatJ2 = j("HH:mm:ss");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy|HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            String[] strArrSplit = simpleDateFormat.format(new Date()).split("\\|");
            String str3 = strArrSplit[0];
            String str4 = strArrSplit[1];
            date = simpleDateFormatJ.parse(str);
            date2 = simpleDateFormatJ.parse(str3);
            date3 = simpleDateFormatJ2.parse(str2);
            date4 = simpleDateFormatJ2.parse(str4);
        } catch (ParseException unused) {
        }
        if (!date.before(date2)) {
            if (date.equals(date2)) {
                if (!date4.equals(date3)) {
                    if (date3.before(date4)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static boolean v(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                SimpleDateFormat simpleDateFormatJ = j("dd/MM/yyyy");
                SimpleDateFormat simpleDateFormatJ2 = j("HH:mm:ss");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy|HH:mm:ss");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                String[] strArrSplit = simpleDateFormat.format(new Date()).split("\\|");
                String str3 = strArrSplit[0];
                String str4 = strArrSplit[1];
                Date date = simpleDateFormatJ.parse(str);
                Date date2 = simpleDateFormatJ.parse(str3);
                Date date3 = simpleDateFormatJ2.parse(str2);
                Date date4 = simpleDateFormatJ2.parse(str4);
                if (!date.before(date2)) {
                    if (date.equals(date2)) {
                        if (date4.after(date3)) {
                        }
                    }
                }
                return true;
            } catch (ParseException unused) {
            }
        }
        return false;
    }

    public static String w(String str) {
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit = str.split("\\:");
        for (int i = 0; i < strArrSplit.length; i += 2) {
            try {
                String strG = G(s(strArrSplit[i]).replaceAll("==", ""), s(strArrSplit[i + 1]).replaceAll("==", ""));
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(strG);
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return "{\"keys\":[" + sb.toString() + "],\"type\":\"temporary\"}".replaceAll("\\n", "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00db A[PHI: r6
      0x00db: PHI (r6v22 java.lang.String) = (r6v21 java.lang.String), (r6v34 java.lang.String) binds: [B:46:0x00c3, B:50:0x00d5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void x(android.content.Intent r22) {
        /*
            Method dump skipped, instruction units count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.j4.x(android.content.Intent):void");
    }

    public static void y(String str, Bundle bundle) {
        try {
            ab.g.c();
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = new Bundle();
            String string = bundle.getString("google.c.a.c_id");
            if (string != null) {
                bundle2.putString("_nmid", string);
            }
            String string2 = bundle.getString("google.c.a.c_l");
            if (string2 != null) {
                bundle2.putString("_nmn", string2);
            }
            String string3 = bundle.getString("google.c.a.m_l");
            if (!TextUtils.isEmpty(string3)) {
                bundle2.putString("label", string3);
            }
            String string4 = bundle.getString("google.c.a.m_c");
            if (!TextUtils.isEmpty(string4)) {
                bundle2.putString("message_channel", string4);
            }
            String string5 = bundle.getString("from");
            if (string5 == null || !string5.startsWith("/topics/")) {
                string5 = null;
            }
            if (string5 != null) {
                bundle2.putString("_nt", string5);
            }
            String string6 = bundle.getString("google.c.a.ts");
            if (string6 != null) {
                try {
                    bundle2.putInt("_nmt", Integer.parseInt(string6));
                } catch (NumberFormatException e9) {
                    Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e9);
                }
            }
            String string7 = bundle.containsKey("google.c.a.udt") ? bundle.getString("google.c.a.udt") : null;
            if (string7 != null) {
                try {
                    bundle2.putInt("_ndt", Integer.parseInt(string7));
                } catch (NumberFormatException e10) {
                    Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e10);
                }
            }
            String str2 = l4.q.f(bundle) ? "display" : "data";
            if ("_nr".equals(str) || "_nf".equals(str)) {
                bundle2.putString("_nmc", str2);
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Logging to scion event=" + str + " scionPayload=" + bundle2);
            }
            eb.b bVar = (eb.b) ab.g.c().b(eb.b.class);
            if (bVar != null) {
                ((eb.c) bVar).a("fcm", str, bundle2);
            } else {
                Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
            }
        } catch (IllegalStateException unused) {
            Log.e("FirebaseMessaging", "Default FirebaseApp has not been initialized. Skip logging event to GA.");
        }
    }

    public static String z(String str, String str2, String str3, String str4, String str5) {
        if (str == null) {
            return null;
        }
        if (str2 == null && str3 == null && str4 == null && str5 == null) {
            return str;
        }
        StringBuilder sbB = y.e.b(str.split("\\|")[0]);
        sbB.append(str3 != null ? "|cookie=".concat(str3) : "");
        sbB.append(str5 != null ? "&origin=".concat(str5) : "");
        sbB.append(str4 != null ? "&referer=".concat(str4) : "");
        sbB.append(str2 != null ? "&user-agent=".concat(str2) : "");
        String string = sbB.toString();
        return !string.contains("|") ? string.contains("&origin") ? string.replaceAll("\\&origin", "|origin") : string.contains("&referer") ? string.replaceAll("\\&referer", "|referer") : string.contains("&user-agent") ? string.replaceAll("\\&user-agent", "|user-agent") : string : string;
    }

    public abstract void I(ArrayList arrayList);
}
