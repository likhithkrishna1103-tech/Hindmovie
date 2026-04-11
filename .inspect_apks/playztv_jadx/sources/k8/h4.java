package k8;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.measurement.l9;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h4 extends x1 {
    public static final String[] D = {"firebase_", "google_", "ga_"};
    public static final String[] E = {"_err"};
    public m4.a A;
    public Boolean B;
    public Integer C;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public SecureRandom f7232x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AtomicLong f7233y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f7234z;

    public h4(k1 k1Var) {
        super(k1Var);
        this.C = null;
        this.f7233y = new AtomicLong(0L);
    }

    public static Bundle B1(List list) {
        Bundle bundle = new Bundle();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                e4 e4Var = (e4) it.next();
                String str = e4Var.f7167y;
                String str2 = e4Var.f7164v;
                if (str != null) {
                    bundle.putString(str2, str);
                } else {
                    Long l10 = e4Var.f7166x;
                    if (l10 != null) {
                        bundle.putLong(str2, l10.longValue());
                    } else {
                        Double d10 = e4Var.A;
                        if (d10 != null) {
                            bundle.putDouble(str2, d10.doubleValue());
                        }
                    }
                }
            }
        }
        return bundle;
    }

    public static MessageDigest C2() {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static String D1(String str, boolean z2, int i) {
        if (str != null) {
            if (str.codePointCount(0, str.length()) <= i) {
                return str;
            }
            if (z2) {
                return e6.j.m(str.substring(0, str.offsetByCodePoints(0, i)), "...");
            }
        }
        return null;
    }

    public static void F1(Bundle bundle, int i, String str, Object obj) {
        if (l2(i, bundle)) {
            bundle.putString("_ev", D1(str, true, 40));
            if (obj != null) {
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", String.valueOf(obj).length());
                }
            }
        }
    }

    public static void S1(w2 w2Var, Bundle bundle, boolean z2) {
        if (bundle == null || w2Var == null || (bundle.containsKey("_sc") && !z2)) {
            if (bundle != null && w2Var == null && z2) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        String str = w2Var.f7526a;
        if (str != null) {
            bundle.putString("_sn", str);
        } else {
            bundle.remove("_sn");
        }
        String str2 = w2Var.f7527b;
        if (str2 != null) {
            bundle.putString("_sc", str2);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", w2Var.f7528c);
    }

    public static void T1(g4 g4Var, String str, int i, String str2, String str3, int i10) {
        Bundle bundle = new Bundle();
        l2(i, bundle);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i10);
        }
        g4Var.b(str, "_err", bundle);
    }

    public static boolean W1(Context context) {
        ActivityInfo receiverInfo;
        t7.v.h(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean X1(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    public static boolean Y1(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public static boolean c2(String str, String str2, String str3, String str4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            t7.v.h(str);
            return !str.equals(str2);
        }
        if (zIsEmpty && zIsEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (zIsEmpty || !zIsEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public static boolean d2(String str, String[] strArr) {
        t7.v.h(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] f2(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static boolean h2(Context context) {
        ServiceInfo serviceInfo;
        ServiceInfo serviceInfo2;
        t7.v.h(context);
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (serviceInfo2 = packageManager.getServiceInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementJobService"), 0)) != null) {
                    if (serviceInfo2.enabled) {
                        return true;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        }
        try {
            PackageManager packageManager2 = context.getPackageManager();
            if (packageManager2 != null && (serviceInfo = packageManager2.getServiceInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return false;
    }

    public static ArrayList k2(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", dVar.f7128u);
            bundle.putString("origin", dVar.f7129v);
            bundle.putLong("creation_timestamp", dVar.f7131x);
            bundle.putString("name", dVar.f7130w.f7164v);
            Object objA = dVar.f7130w.a();
            t7.v.h(objA);
            c2.e(bundle, objA);
            bundle.putBoolean("active", dVar.f7132y);
            String str = dVar.f7133z;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            v vVar = dVar.A;
            if (vVar != null) {
                bundle.putString("timed_out_event_name", vVar.f7444u);
                u uVar = vVar.f7445v;
                if (uVar != null) {
                    bundle.putBundle("timed_out_event_params", uVar.d());
                }
            }
            bundle.putLong("trigger_timeout", dVar.B);
            v vVar2 = dVar.C;
            if (vVar2 != null) {
                bundle.putString("triggered_event_name", vVar2.f7444u);
                u uVar2 = vVar2.f7445v;
                if (uVar2 != null) {
                    bundle.putBundle("triggered_event_params", uVar2.d());
                }
            }
            bundle.putLong("triggered_timestamp", dVar.f7130w.f7165w);
            bundle.putLong("time_to_live", dVar.D);
            v vVar3 = dVar.E;
            if (vVar3 != null) {
                bundle.putString("expired_event_name", vVar3.f7444u);
                u uVar3 = vVar3.f7445v;
                if (uVar3 != null) {
                    bundle.putBundle("expired_event_params", uVar3.d());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static boolean l2(int i, Bundle bundle) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    public static boolean s2(String str) {
        String str2 = (String) w.A0.a(null);
        return str2.equals("*") || Arrays.asList(str2.split(",")).contains(str);
    }

    public static boolean u2(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean v2(String str) {
        t7.v.d(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static long w1(u uVar) {
        long length = 0;
        if (uVar == null) {
            return 0L;
        }
        Bundle bundle = uVar.f7434u;
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            Object obj = bundle.get(it.next());
            if (obj instanceof Parcelable[]) {
                length += (long) ((Parcelable[]) obj).length;
            }
        }
        return length;
    }

    public static long x1(byte[] bArr) {
        t7.v.h(bArr);
        if (bArr.length <= 0) {
            throw new IllegalStateException();
        }
        int i = 0;
        long j5 = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j5 += (((long) bArr[length]) & 255) << i;
            i += 8;
        }
        return j5;
    }

    public static int x2(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return "_lgclid".equals(str) ? 100 : 36;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle A1(java.lang.String r18, android.os.Bundle r19, java.util.List r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.h4.A1(java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    public final m4.a A2() {
        if (this.A == null) {
            Context context = ((k1) this.f2454v).f7282u;
            be.h.e(context, "context");
            StringBuilder sb2 = new StringBuilder("AdServicesInfo.version=");
            int i = Build.VERSION.SDK_INT;
            k4.a aVar = k4.a.f7016a;
            sb2.append(i >= 30 ? aVar.a() : 0);
            Log.d("MeasurementManager", sb2.toString());
            n4.c cVar = (i >= 30 ? aVar.a() : 0) >= 5 ? new n4.c(context) : null;
            this.A = cVar != null ? new m4.a(cVar) : null;
        }
        return this.A;
    }

    public final String B2() {
        byte[] bArr = new byte[16];
        D2().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final Object C1(int i, Object obj, boolean z2, boolean z10) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return D1(String.valueOf(obj), z2, i);
        }
        if (!z10) {
            return null;
        }
        if (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[])) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleZ1 = z1((Bundle) parcelable);
                if (!bundleZ1.isEmpty()) {
                    arrayList.add(bundleZ1);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final SecureRandom D2() {
        p1();
        if (this.f7232x == null) {
            this.f7232x = new SecureRandom();
        }
        return this.f7232x;
    }

    public final v E1(String str, Bundle bundle, String str2, long j5, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (u1(str) != 0) {
            g().A.c(((k1) this.f2454v).G.g(str), "Invalid conditional property event name");
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        Bundle bundleA1 = A1(str, bundle2, Collections.singletonList("_o"), true);
        if (z2) {
            bundleA1 = z1(bundleA1);
        }
        t7.v.h(bundleA1);
        return new v(str, new u(bundleA1), str2, j5);
    }

    public final void G1(Bundle bundle, long j5) {
        long j8 = bundle.getLong("_et");
        if (j8 != 0) {
            g().D.c(Long.valueOf(j8), "Params already contained engagement");
        }
        bundle.putLong("_et", j5 + j8);
    }

    public final void H1(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                o1().I1(bundle, str, bundle2.get(str));
            }
        }
    }

    public final void I1(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            g().F.b(((k1) this.f2454v).G.f(str), obj != null ? obj.getClass().getSimpleName() : null, "Not putting event parameter. Invalid value type. name, type");
        }
    }

    public final void J1(com.google.android.gms.internal.measurement.w0 w0Var, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            w0Var.h(bundle);
        } catch (RemoteException e10) {
            p0 p0Var = ((k1) this.f2454v).C;
            k1.f(p0Var);
            p0Var.D.c(e10, "Error returning int value to wrapper");
        }
    }

    public final void K1(com.google.android.gms.internal.measurement.w0 w0Var, long j5) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j5);
        try {
            w0Var.h(bundle);
        } catch (RemoteException e10) {
            p0 p0Var = ((k1) this.f2454v).C;
            k1.f(p0Var);
            p0Var.D.c(e10, "Error returning long value to wrapper");
        }
    }

    public final void L1(com.google.android.gms.internal.measurement.w0 w0Var, Bundle bundle) {
        try {
            w0Var.h(bundle);
        } catch (RemoteException e10) {
            p0 p0Var = ((k1) this.f2454v).C;
            k1.f(p0Var);
            p0Var.D.c(e10, "Error returning bundle value to wrapper");
        }
    }

    public final void M1(com.google.android.gms.internal.measurement.w0 w0Var, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            w0Var.h(bundle);
        } catch (RemoteException e10) {
            p0 p0Var = ((k1) this.f2454v).C;
            k1.f(p0Var);
            p0Var.D.c(e10, "Error returning bundle list to wrapper");
        }
    }

    public final void N1(com.google.android.gms.internal.measurement.w0 w0Var, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z2);
        try {
            w0Var.h(bundle);
        } catch (RemoteException e10) {
            p0 p0Var = ((k1) this.f2454v).C;
            k1.f(p0Var);
            p0Var.D.c(e10, "Error returning boolean value to wrapper");
        }
    }

    public final void O1(com.google.android.gms.internal.measurement.w0 w0Var, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            w0Var.h(bundle);
        } catch (RemoteException e10) {
            p0 p0Var = ((k1) this.f2454v).C;
            k1.f(p0Var);
            p0Var.D.c(e10, "Error returning byte array to wrapper");
        }
    }

    public final void P1(String str, com.google.android.gms.internal.measurement.w0 w0Var) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            w0Var.h(bundle);
        } catch (RemoteException e10) {
            p0 p0Var = ((k1) this.f2454v).C;
            k1.f(p0Var);
            p0Var.D.c(e10, "Error returning string value to wrapper");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q1(java.lang.String r18, java.lang.String r19, android.os.Bundle r20, java.util.List r21, boolean r22) {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.h4.Q1(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):void");
    }

    public final void R1(t0 t0Var, int i) {
        k1 k1Var = (k1) this.f2454v;
        Bundle bundle = (Bundle) t0Var.f7429e;
        int i10 = 0;
        for (String str : new TreeSet(bundle.keySet())) {
            if (v2(str) && (i10 = i10 + 1) > i) {
                g().C.b(k1Var.G.b((String) t0Var.f7427c), k1Var.G.a(bundle), e6.j.j(i, "Event can't contain more than ", " params"));
                l2(5, bundle);
                bundle.remove(str);
            }
        }
    }

    public final void U1(Parcelable[] parcelableArr, int i) {
        k1 k1Var = (k1) this.f2454v;
        t7.v.h(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i10 = 0;
            for (String str : new TreeSet(bundle.keySet())) {
                if (v2(str) && !d2(str, c2.f7117j) && (i10 = i10 + 1) > i) {
                    g().C.b(k1Var.G.f(str), k1Var.G.a(bundle), e6.j.j(i, "Param can't contain more than ", " item-scoped custom parameters"));
                    l2(28, bundle);
                    bundle.remove(str);
                }
            }
        }
    }

    public final boolean V1(int i, String str, String str2) {
        if (str2 == null) {
            g().C.c(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        g().C.e("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    public final boolean Z1(String str, double d10) {
        try {
            SharedPreferences.Editor editorEdit = ((k1) this.f2454v).f7282u.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            editorEdit.putString("deeplink", str);
            editorEdit.putLong("timestamp", Double.doubleToRawLongBits(d10));
            return editorEdit.commit();
        } catch (RuntimeException e10) {
            g().A.c(e10, "Failed to persist Deferred Deep Link. exception");
            return false;
        }
    }

    public final boolean a2(String str, String str2) {
        k1 k1Var = (k1) this.f2454v;
        if (!TextUtils.isEmpty(str)) {
            t7.v.h(str);
            if (str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
                return true;
            }
            if (TextUtils.isEmpty(k1Var.f7283v)) {
                g().C.c(p0.v1(str), "Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id");
                return false;
            }
        } else {
            if (!TextUtils.isEmpty(str2)) {
                t7.v.h(str2);
                if (str2.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
                    return true;
                }
                g().C.c(p0.v1(str2), "Invalid admob_app_id. Analytics disabled.");
                return false;
            }
            if (TextUtils.isEmpty(k1Var.f7283v)) {
                g().C.d("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
        }
        return false;
    }

    public final boolean b2(String str, String str2, int i, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String strValueOf = String.valueOf(obj);
        if (strValueOf.codePointCount(0, strValueOf.length()) > i) {
            g().F.e("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(strValueOf.length()));
            return false;
        }
        return true;
    }

    public final boolean e2(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            g().C.c(str, "Name is required and can't be null. Type");
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(D[i])) {
                g().C.b(str, str2, "Name starts with reserved prefix. Type, name");
                return false;
            }
        }
        if (strArr == null || !d2(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && d2(str2, strArr2)) {
            return true;
        }
        g().C.b(str, str2, "Name is reserved. Type, name");
        return false;
    }

    public final boolean g2(int i) {
        Boolean bool = ((k1) this.f2454v).p().f7574z;
        if (t2() < i / 1000) {
            return (bool == null || bool.booleanValue()) ? false : true;
        }
        return true;
    }

    public final int i2(String str) {
        if (!n2("user property", str)) {
            return 6;
        }
        if (e2("user property", c2.f7114e, null, str)) {
            return !V1(24, "user property", str) ? 6 : 0;
        }
        return 15;
    }

    public final Object j2(Object obj, String str) {
        k1 k1Var = (k1) this.f2454v;
        int iMax = 500;
        if ("_ev".equals(str)) {
            k1Var.A.getClass();
            return C1(Math.max(500, 256), obj, true, true);
        }
        if (u2(str)) {
            k1Var.A.getClass();
            iMax = Math.max(500, 256);
        } else {
            k1Var.A.getClass();
        }
        return C1(iMax, obj, false, true);
    }

    public final boolean m2(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfoC = z7.b.a(context).c(str, 64);
            if (packageInfoC == null || (signatureArr = packageInfoC.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e10) {
            g().A.c(e10, "Package name not found");
            return true;
        } catch (CertificateException e11) {
            g().A.c(e11, "Error obtaining certificate");
            return true;
        }
    }

    public final boolean n2(String str, String str2) {
        if (str2 == null) {
            g().C.c(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            g().C.c(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt) && iCodePointAt != 95) {
            g().C.b(str, str2, "Name must start with a letter or _ (underscore). Type, name");
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                g().C.b(str, str2, "Name must consist of letters, digits or _ (underscores). Type, name");
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final Object o2(Object obj, String str) {
        return "_ldl".equals(str) ? C1(x2(str), obj, true, false) : C1(x2(str), obj, false, false);
    }

    public final boolean p2(String str, String str2) {
        if (str2 == null) {
            g().C.c(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            g().C.c(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            g().C.b(str, str2, "Name must start with a letter. Type, name");
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                g().C.b(str, str2, "Name must consist of letters, digits or _ (underscores). Type, name");
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean q2(String str, String str2) {
        l9.a();
        k1 k1Var = (k1) this.f2454v;
        if (k1Var.A.A1(null, w.f7520y0) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return k1Var.A.r1("debug.firebase.analytics.app").equals(str);
    }

    public final boolean r2(String str) {
        p1();
        if (z7.b.a(((k1) this.f2454v).f7282u).f14093a.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        g().H.c(str, "Permission not granted");
        return false;
    }

    @Override // k8.x1
    public final boolean s1() {
        return true;
    }

    public final int t1(Object obj, String str) {
        return "_ldl".equals(str) ? b2("user property referrer", str, x2(str), obj) : b2("user property", str, x2(str), obj) ? 0 : 7;
    }

    public final int t2() {
        if (this.C == null) {
            q7.f fVar = q7.f.f11040b;
            Context context = ((k1) this.f2454v).f7282u;
            fVar.getClass();
            int i = q7.g.f11045e;
            int i10 = 0;
            try {
                i10 = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            }
            this.C = Integer.valueOf(i10 / 1000);
        }
        return this.C.intValue();
    }

    public final int u1(String str) {
        if (!n2("event", str)) {
            return 2;
        }
        if (e2("event", c2.f7110a, c2.f7111b, str)) {
            return !V1(40, "event", str) ? 2 : 0;
        }
        return 13;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int v1(java.lang.String r12, java.lang.String r13, java.lang.Object r14, android.os.Bundle r15, java.util.List r16, boolean r17, boolean r18) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.h4.v1(java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final boolean w2(String str) {
        List<ResolveInfo> listQueryIntentActivities;
        return (TextUtils.isEmpty(str) || (listQueryIntentActivities = ((k1) this.f2454v).f7282u.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 0)) == null || listQueryIntentActivities.isEmpty()) ? false : true;
    }

    public final Bundle y1(Uri uri, boolean z2) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        String queryParameter9;
        String str;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
                queryParameter5 = z2 ? uri.getQueryParameter("gbraid") : null;
                queryParameter6 = uri.getQueryParameter("utm_id");
                queryParameter7 = uri.getQueryParameter("dclid");
                queryParameter8 = uri.getQueryParameter("srsltid");
                queryParameter9 = uri.getQueryParameter("sfmc_id");
            } else {
                queryParameter = null;
                queryParameter2 = null;
                queryParameter3 = null;
                queryParameter4 = null;
                queryParameter5 = null;
                queryParameter6 = null;
                queryParameter7 = null;
                queryParameter8 = null;
                queryParameter9 = null;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && ((!z2 || TextUtils.isEmpty(queryParameter5)) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && TextUtils.isEmpty(queryParameter8) && TextUtils.isEmpty(queryParameter9))) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(queryParameter)) {
                str = "sfmc_id";
            } else {
                str = "sfmc_id";
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            if (z2 && !TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("gbraid", queryParameter5);
            }
            String queryParameter10 = uri.getQueryParameter("gad_source");
            if (z2 && !TextUtils.isEmpty(queryParameter10)) {
                bundle.putString("gad_source", queryParameter10);
            }
            String queryParameter11 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter11)) {
                bundle.putString("term", queryParameter11);
            }
            String queryParameter12 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter12)) {
                bundle.putString("content", queryParameter12);
            }
            String queryParameter13 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter13)) {
                bundle.putString("aclid", queryParameter13);
            }
            String queryParameter14 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter14)) {
                bundle.putString("cp1", queryParameter14);
            }
            String queryParameter15 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter15)) {
                bundle.putString("anid", queryParameter15);
            }
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("campaign_id", queryParameter6);
            }
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("dclid", queryParameter7);
            }
            String queryParameter16 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter16)) {
                bundle.putString("source_platform", queryParameter16);
            }
            String queryParameter17 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter17)) {
                bundle.putString("creative_format", queryParameter17);
            }
            String queryParameter18 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter18)) {
                bundle.putString("marketing_tactic", queryParameter18);
            }
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("srsltid", queryParameter8);
            }
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString(str, queryParameter9);
            }
            return bundle;
        } catch (UnsupportedOperationException e10) {
            g().D.c(e10, "Install referrer url isn't a hierarchical URI");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long y2() {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.h4.y2():long");
    }

    public final Bundle z1(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objJ2 = j2(bundle.get(str), str);
                if (objJ2 == null) {
                    g().F.c(((k1) this.f2454v).G.f(str), "Param value can't be null");
                } else {
                    I1(bundle2, str, objJ2);
                }
            }
        }
        return bundle2;
    }

    public final long z2() {
        long andIncrement;
        long j5;
        if (this.f7233y.get() != 0) {
            synchronized (this.f7233y) {
                this.f7233y.compareAndSet(-1L, 1L);
                andIncrement = this.f7233y.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.f7233y) {
            long jNanoTime = System.nanoTime();
            ((k1) this.f2454v).H.getClass();
            long jNextLong = new Random(jNanoTime ^ System.currentTimeMillis()).nextLong();
            int i = this.f7234z + 1;
            this.f7234z = i;
            j5 = jNextLong + ((long) i);
        }
        return j5;
    }
}
