package f9;

import android.adservices.measurement.MeasurementManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u4 extends b2 {
    public static final String[] E = {"firebase_", "google_", "ga_"};
    public static final String[] F = {"_err"};
    public int A;
    public r4.b B;
    public Boolean C;
    public Integer D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public SecureRandom f4439y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AtomicLong f4440z;

    public u4(r1 r1Var) {
        super(r1Var);
        this.D = null;
        this.f4440z = new AtomicLong(0L);
    }

    public static void C1(p6.d dVar, String str, int i, String str2, String str3, int i10) {
        Bundle bundle = new Bundle();
        g2(i, bundle);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i10);
        }
        dVar.A(str, "_err", bundle);
    }

    public static MessageDigest D1() {
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

    public static long E1(byte[] bArr) {
        o8.u.g(bArr);
        int length = bArr.length;
        if (length <= 0) {
            throw new IllegalStateException();
        }
        int i = 0;
        long j4 = 0;
        for (int i10 = length - 1; i10 >= 0 && i10 >= bArr.length - 8; i10--) {
            j4 += (((long) bArr[i10]) & 255) << i;
            i += 8;
        }
        return j4;
    }

    public static boolean F1(Context context) {
        o8.u.g(context);
        return Build.VERSION.SDK_INT >= 24 ? G1(context, "com.google.android.gms.measurement.AppMeasurementJobService") : G1(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean G1(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean J1(String str) {
        String str2 = (String) f0.f4153s0.a(null);
        return str2.equals("*") || Arrays.asList(str2.split(",")).contains(str);
    }

    public static boolean L1(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean M1(String str, String[] strArr) {
        o8.u.g(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] R1(Parcelable parcelable) {
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

    public static ArrayList c2(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", eVar.f4083v);
            bundle.putString("origin", eVar.f4084w);
            bundle.putLong("creation_timestamp", eVar.f4086y);
            bundle.putString("name", eVar.f4085x.f4404w);
            Object objA = eVar.f4085x.a();
            o8.u.g(objA);
            h2.c(bundle, objA);
            bundle.putBoolean("active", eVar.f4087z);
            String str = eVar.A;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            v vVar = eVar.B;
            if (vVar != null) {
                bundle.putString("timed_out_event_name", vVar.f4441v);
                u uVar = vVar.f4442w;
                if (uVar != null) {
                    bundle.putBundle("timed_out_event_params", uVar.d());
                }
            }
            bundle.putLong("trigger_timeout", eVar.C);
            v vVar2 = eVar.D;
            if (vVar2 != null) {
                bundle.putString("triggered_event_name", vVar2.f4441v);
                u uVar2 = vVar2.f4442w;
                if (uVar2 != null) {
                    bundle.putBundle("triggered_event_params", uVar2.d());
                }
            }
            bundle.putLong("triggered_timestamp", eVar.f4085x.f4405x);
            bundle.putLong("time_to_live", eVar.E);
            v vVar3 = eVar.F;
            if (vVar3 != null) {
                bundle.putString("expired_event_name", vVar3.f4441v);
                u uVar3 = vVar3.f4442w;
                if (uVar3 != null) {
                    bundle.putBundle("expired_event_params", uVar3.d());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static boolean d2(Context context) {
        ActivityInfo receiverInfo;
        o8.u.g(context);
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

    public static void e2(f3 f3Var, Bundle bundle, boolean z10) {
        if (bundle != null && f3Var != null) {
            if (!bundle.containsKey("_sc") || z10) {
                String str = f3Var.f4175a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = f3Var.f4176b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", f3Var.f4177c);
                return;
            }
            z10 = false;
        }
        if (bundle != null && f3Var == null && z10) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static final boolean g2(int i, Bundle bundle) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    public static boolean l2(String str) {
        o8.u.d(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static String r1(String str, boolean z10, int i) {
        if (str != null) {
            if (str.codePointCount(0, str.length()) <= i) {
                return str;
            }
            if (z10) {
                return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
            }
        }
        return null;
    }

    public static boolean v2(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public final Object A1(Object obj, String str) {
        return "_ldl".equals(str) ? h2(i2(str), obj, true, false) : h2(i2(str), obj, false, false);
    }

    public final void B1(Bundle bundle, String str, Object obj) {
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
            return;
        }
        if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
            return;
        }
        if (str != null) {
            String simpleName = obj != null ? obj.getClass().getSimpleName() : null;
            r1 r1Var = (r1) this.f307w;
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.G.c(r1Var.E.b(str), simpleName, "Not putting event parameter. Invalid value type. name, type");
        }
    }

    public final r4.b H1() {
        s4.c cVar;
        if (this.B == null) {
            Context context = ((r1) this.f307w).f4363v;
            ge.i.e(context, "context");
            StringBuilder sb = new StringBuilder("AdServicesInfo.version=");
            int i = Build.VERSION.SDK_INT;
            p4.b bVar = p4.b.f9989a;
            sb.append(i >= 33 ? bVar.a() : 0);
            Log.d("MeasurementManager", sb.toString());
            if ((i >= 33 ? bVar.a() : 0) >= 5) {
                Object systemService = context.getSystemService((Class<Object>) s4.b.d());
                ge.i.d(systemService, "context.getSystemService…ementManager::class.java)");
                cVar = new s4.c(s4.b.c(systemService));
            } else {
                p4.a aVar = p4.a.f9988a;
                if (((i == 31 || i == 32) ? aVar.a() : 0) >= 9) {
                    try {
                        MeasurementManager measurementManager = MeasurementManager.get(context);
                        ge.i.d(measurementManager, "get(context)");
                        cVar = new s4.c(measurementManager);
                    } catch (NoClassDefFoundError unused) {
                        StringBuilder sb2 = new StringBuilder("Unable to find adservices code, check manifest for uses-library tag, versionS=");
                        int i10 = Build.VERSION.SDK_INT;
                        sb2.append((i10 == 31 || i10 == 32) ? aVar.a() : 0);
                        Log.d("MeasurementManager", sb2.toString());
                        cVar = null;
                    }
                } else {
                    cVar = null;
                }
            }
            this.B = cVar != null ? new r4.b(cVar) : null;
        }
        return this.B;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long I1() {
        /*
            r11 = this;
            r11.m1()
            java.lang.Object r0 = r11.f307w
            f9.r1 r0 = (f9.r1) r0
            f9.n0 r1 = r0.l()
            f9.w0 r0 = r0.A
            java.lang.String r1 = r1.s1()
            boolean r1 = J1(r1)
            r2 = 0
            if (r1 != 0) goto L1a
            return r2
        L1a:
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 0
            r5 = 0
            r6 = 30
            if (r1 >= r6) goto L25
            r6 = 4
            goto L50
        L25:
            int r7 = uf.a.h()
            r8 = 4
            if (r7 >= r8) goto L2f
            r6 = 8
            goto L50
        L2f:
            if (r1 < r6) goto L3d
            int r1 = uf.a.h()
            r6 = 3
            if (r1 <= r6) goto L3d
            int r1 = f9.u2.u()
            goto L3e
        L3d:
            r1 = r4
        L3e:
            f9.e0 r6 = f9.f0.f4142m0
            java.lang.Object r6 = r6.a(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r1 >= r6) goto L4f
            r6 = 16
            goto L50
        L4f:
            r6 = r2
        L50:
            java.lang.String r1 = "android.permission.ACCESS_ADSERVICES_ATTRIBUTION"
            boolean r1 = r11.K1(r1)
            if (r1 != 0) goto L5b
            r8 = 2
            long r6 = r6 | r8
        L5b:
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 != 0) goto Lc0
            java.lang.Boolean r1 = r11.C
            if (r1 != 0) goto Lb6
            r4.b r1 = r11.H1()
            if (r1 != 0) goto L6a
            goto Lbc
        L6a:
            ya.w r1 = r1.b()
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.util.concurrent.TimeoutException -> L94 java.lang.InterruptedException -> L97 java.util.concurrent.ExecutionException -> L99 java.util.concurrent.CancellationException -> L9b
            r9 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r1 = r1.get(r9, r8)     // Catch: java.util.concurrent.TimeoutException -> L94 java.lang.InterruptedException -> L97 java.util.concurrent.ExecutionException -> L99 java.util.concurrent.CancellationException -> L9b
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.util.concurrent.TimeoutException -> L94 java.lang.InterruptedException -> L97 java.util.concurrent.ExecutionException -> L99 java.util.concurrent.CancellationException -> L9b
            if (r1 == 0) goto L8b
            int r5 = r1.intValue()     // Catch: java.util.concurrent.TimeoutException -> L83 java.lang.InterruptedException -> L85 java.util.concurrent.ExecutionException -> L87 java.util.concurrent.CancellationException -> L89
            r8 = 1
            if (r5 != r8) goto L8b
            r4 = r8
            goto L8b
        L83:
            r4 = move-exception
            goto L92
        L85:
            r4 = move-exception
            goto L92
        L87:
            r4 = move-exception
            goto L92
        L89:
            r4 = move-exception
            goto L92
        L8b:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.util.concurrent.TimeoutException -> L83 java.lang.InterruptedException -> L85 java.util.concurrent.ExecutionException -> L87 java.util.concurrent.CancellationException -> L89
            r11.C = r4     // Catch: java.util.concurrent.TimeoutException -> L83 java.lang.InterruptedException -> L85 java.util.concurrent.ExecutionException -> L87 java.util.concurrent.CancellationException -> L89
            goto Lac
        L92:
            r5 = r1
            goto L9d
        L94:
            r1 = move-exception
        L95:
            r4 = r1
            goto L9d
        L97:
            r1 = move-exception
            goto L95
        L99:
            r1 = move-exception
            goto L95
        L9b:
            r1 = move-exception
            goto L95
        L9d:
            f9.r1.g(r0)
            f9.u0 r1 = r0.E
            java.lang.String r8 = "Measurement manager api exception"
            r1.b(r4, r8)
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r11.C = r1
            r1 = r5
        Lac:
            f9.r1.g(r0)
            f9.u0 r0 = r0.J
            java.lang.String r4 = "Measurement manager api status result"
            r0.b(r1, r4)
        Lb6:
            java.lang.Boolean r0 = r11.C
            boolean r4 = r0.booleanValue()
        Lbc:
            if (r4 != 0) goto Lc0
            r6 = 64
        Lc0:
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 != 0) goto Lc7
            r0 = 1
            return r0
        Lc7:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.u4.I1():long");
    }

    public final boolean K1(String str) {
        m1();
        r1 r1Var = (r1) this.f307w;
        if (u8.b.a(r1Var.f4363v).f1830a.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        w0 w0Var = r1Var.A;
        r1.g(w0Var);
        w0Var.I.b(str, "Permission not granted");
        return false;
    }

    public final boolean N1(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ((r1) this.f307w).f4366y.q1("debug.firebase.analytics.app").equals(str);
    }

    public final Bundle O1(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objT1 = t1(bundle.get(str), str);
                if (objT1 == null) {
                    r1 r1Var = (r1) this.f307w;
                    w0 w0Var = r1Var.A;
                    r1.g(w0Var);
                    w0Var.G.b(r1Var.E.b(str), "Param value can't be null");
                } else {
                    B1(bundle2, str, objT1);
                }
            }
        }
        return bundle2;
    }

    public final v P1(String str, Bundle bundle, String str2, long j4, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (r2(str) != 0) {
            r1 r1Var = (r1) this.f307w;
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.b(r1Var.E.c(str), "Invalid conditional property event name");
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        Bundle bundleU1 = u1(str, bundle2, Collections.singletonList("_o"), true);
        if (z10) {
            bundleU1 = O1(bundleU1);
        }
        o8.u.g(bundleU1);
        return new v(str, new u(bundleU1), str2, j4);
    }

    public final boolean Q1(Context context, String str) {
        Signature[] signatureArr;
        r1 r1Var = (r1) this.f307w;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfoB = u8.b.a(context).b(64, str);
            if (packageInfoB == null || (signatureArr = packageInfoB.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e9) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.B.b(e9, "Package name not found");
            return true;
        } catch (CertificateException e10) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.B.b(e10, "Error obtaining certificate");
            return true;
        }
    }

    public final boolean S1(int i) {
        Boolean bool = ((r1) this.f307w).j().A;
        if (T1() < i / 1000) {
            return (bool == null || bool.booleanValue()) ? false : true;
        }
        return true;
    }

    public final int T1() {
        if (this.D == null) {
            r1 r1Var = (r1) this.f307w;
            l8.f fVar = l8.f.f7890b;
            Context context = r1Var.f4363v;
            fVar.getClass();
            AtomicBoolean atomicBoolean = l8.g.f7891a;
            int i = 0;
            try {
                i = context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            }
            this.D = Integer.valueOf(i / 1000);
        }
        return this.D.intValue();
    }

    public final void U1(Bundle bundle, long j4) {
        long j7 = bundle.getLong("_et");
        if (j7 != 0) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.E.b(Long.valueOf(j7), "Params already contained engagement");
        } else {
            j7 = 0;
        }
        bundle.putLong("_et", j4 + j7);
    }

    public final void V1(String str, com.google.android.gms.internal.measurement.l0 l0Var) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            l0Var.t(bundle);
        } catch (RemoteException e9) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.E.b(e9, "Error returning string value to wrapper");
        }
    }

    public final void W1(com.google.android.gms.internal.measurement.l0 l0Var, long j4) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j4);
        try {
            l0Var.t(bundle);
        } catch (RemoteException e9) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.E.b(e9, "Error returning long value to wrapper");
        }
    }

    public final void X1(com.google.android.gms.internal.measurement.l0 l0Var, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            l0Var.t(bundle);
        } catch (RemoteException e9) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.E.b(e9, "Error returning int value to wrapper");
        }
    }

    public final void Y1(com.google.android.gms.internal.measurement.l0 l0Var, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            l0Var.t(bundle);
        } catch (RemoteException e9) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.E.b(e9, "Error returning byte array to wrapper");
        }
    }

    public final void Z1(com.google.android.gms.internal.measurement.l0 l0Var, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z10);
        try {
            l0Var.t(bundle);
        } catch (RemoteException e9) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.E.b(e9, "Error returning boolean value to wrapper");
        }
    }

    public final void a2(com.google.android.gms.internal.measurement.l0 l0Var, Bundle bundle) {
        try {
            l0Var.t(bundle);
        } catch (RemoteException e9) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.E.b(e9, "Error returning bundle value to wrapper");
        }
    }

    public final void b2(com.google.android.gms.internal.measurement.l0 l0Var, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            l0Var.t(bundle);
        } catch (RemoteException e9) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.E.b(e9, "Error returning bundle list to wrapper");
        }
    }

    public final String f2() {
        byte[] bArr = new byte[16];
        k2().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final Object h2(int i, Object obj, boolean z10, boolean z11) {
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
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return r1(obj.toString(), z10, i);
        }
        if (!z11) {
            return null;
        }
        if (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[])) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleO1 = O1((Bundle) parcelable);
                if (!bundleO1.isEmpty()) {
                    arrayList.add(bundleO1);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final int i2(String str) {
        r1 r1Var = (r1) this.f307w;
        if ("_ldl".equals(str)) {
            r1Var.getClass();
            return 2048;
        }
        if ("_id".equals(str)) {
            r1Var.getClass();
            return 256;
        }
        if ("_lgclid".equals(str)) {
            r1Var.getClass();
            return 100;
        }
        r1Var.getClass();
        return 36;
    }

    public final long j2() {
        long andIncrement;
        long j4;
        AtomicLong atomicLong = this.f4440z;
        if (atomicLong.get() != 0) {
            AtomicLong atomicLong2 = this.f4440z;
            synchronized (atomicLong2) {
                atomicLong2.compareAndSet(-1L, 1L);
                andIncrement = atomicLong2.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (atomicLong) {
            long jNanoTime = System.nanoTime();
            ((r1) this.f307w).F.getClass();
            long jNextLong = new Random(jNanoTime ^ System.currentTimeMillis()).nextLong();
            int i = this.A + 1;
            this.A = i;
            j4 = jNextLong + ((long) i);
        }
        return j4;
    }

    public final SecureRandom k2() {
        m1();
        if (this.f4439y == null) {
            this.f4439y = new SecureRandom();
        }
        return this.f4439y;
    }

    public final Bundle m2(Uri uri) {
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
                queryParameter5 = uri.getQueryParameter("gbraid");
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
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && TextUtils.isEmpty(queryParameter8) && TextUtils.isEmpty(queryParameter9)) {
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
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("gbraid", queryParameter5);
            }
            String queryParameter10 = uri.getQueryParameter("gad_source");
            if (!TextUtils.isEmpty(queryParameter10)) {
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
            for (String str2 : uri.getQueryParameterNames()) {
                if (str2.startsWith("gad_")) {
                    String queryParameter19 = uri.getQueryParameter(str2);
                    if (!TextUtils.isEmpty(queryParameter19)) {
                        bundle.putString(str2, queryParameter19);
                    }
                }
            }
            return bundle;
        } catch (UnsupportedOperationException e9) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.E.b(e9, "Install referrer url isn't a hierarchical URI");
            return null;
        }
    }

    @Override // f9.b2
    public final boolean n1() {
        return true;
    }

    public final boolean n2(String str, String str2) {
        r1 r1Var = (r1) this.f307w;
        if (str2 == null) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.D.b(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.D.b(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            w0 w0Var3 = r1Var.A;
            r1.g(w0Var3);
            w0Var3.D.c(str, str2, "Name must start with a letter. Type, name");
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                w0 w0Var4 = r1Var.A;
                r1.g(w0Var4);
                w0Var4.D.c(str, str2, "Name must consist of letters, digits or _ (underscores). Type, name");
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean o2(String str, String str2) {
        r1 r1Var = (r1) this.f307w;
        if (str2 == null) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.D.b(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            w0 w0Var2 = r1Var.A;
            r1.g(w0Var2);
            w0Var2.D.b(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            if (iCodePointAt != 95) {
                w0 w0Var3 = r1Var.A;
                r1.g(w0Var3);
                w0Var3.D.c(str, str2, "Name must start with a letter or _ (underscore). Type, name");
                return false;
            }
            iCodePointAt = 95;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                w0 w0Var4 = r1Var.A;
                r1.g(w0Var4);
                w0Var4.D.c(str, str2, "Name must consist of letters, digits or _ (underscores). Type, name");
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean p2(String str, String[] strArr, String[] strArr2, String str2) {
        r1 r1Var = (r1) this.f307w;
        if (str2 == null) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.D.b(str, "Name is required and can't be null. Type");
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(E[i])) {
                w0 w0Var2 = r1Var.A;
                r1.g(w0Var2);
                w0Var2.D.c(str, str2, "Name starts with reserved prefix. Type, name");
                return false;
            }
        }
        if (strArr == null || !M1(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && M1(str2, strArr2)) {
            return true;
        }
        w0 w0Var3 = r1Var.A;
        r1.g(w0Var3);
        w0Var3.D.c(str, str2, "Name is reserved. Type, name");
        return false;
    }

    public final boolean q1(String str) {
        r1 r1Var = (r1) this.f307w;
        if (TextUtils.isEmpty(str)) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.D.a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        o8.u.g(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        w0 w0Var2 = r1Var.A;
        r1.g(w0Var2);
        w0Var2.D.b(w0.u1(str), "Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id");
        return false;
    }

    public final boolean q2(int i, String str, String str2) {
        r1 r1Var = (r1) this.f307w;
        if (str2 == null) {
            w0 w0Var = r1Var.A;
            r1.g(w0Var);
            w0Var.D.b(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        w0 w0Var2 = r1Var.A;
        r1.g(w0Var2);
        w0Var2.D.d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    public final int r2(String str) {
        if (!o2("event", str)) {
            return 2;
        }
        if (!p2("event", h2.f4204a, h2.f4205b, str)) {
            return 13;
        }
        ((r1) this.f307w).getClass();
        return !q2(40, "event", str) ? 2 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int s1(java.lang.String r13, java.lang.String r14, java.lang.Object r15, android.os.Bundle r16, java.util.List r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.u4.s1(java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final int s2(String str) {
        if (!o2("user property", str)) {
            return 6;
        }
        if (!p2("user property", h2.i, null, str)) {
            return 15;
        }
        ((r1) this.f307w).getClass();
        return !q2(24, "user property", str) ? 6 : 0;
    }

    public final Object t1(Object obj, String str) {
        r1 r1Var = (r1) this.f307w;
        int iMax = 500;
        if ("_ev".equals(str)) {
            r1Var.f4366y.getClass();
            return h2(Math.max(500, 256), obj, true, true);
        }
        if (L1(str)) {
            r1Var.f4366y.getClass();
            iMax = Math.max(500, 256);
        } else {
            r1Var.f4366y.getClass();
        }
        return h2(iMax, obj, false, true);
    }

    public final int t2(String str) {
        if (!n2("event param", str)) {
            return 3;
        }
        if (!p2("event param", null, null, str)) {
            return 14;
        }
        ((r1) this.f307w).getClass();
        return !q2(40, "event param", str) ? 3 : 0;
    }

    public final Bundle u1(String str, Bundle bundle, List list, boolean z10) {
        int iT2;
        String str2;
        List list2 = list;
        boolean zM1 = M1(str, h2.f4207d);
        String str3 = null;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        r1 r1Var = (r1) this.f307w;
        g gVar = r1Var.f4366y;
        q0 q0Var = r1Var.E;
        u4 u4Var = ((r1) gVar.f307w).D;
        r1.e(u4Var);
        int i = u4Var.S1(201500000) ? 100 : 25;
        int i10 = 0;
        boolean z11 = false;
        for (String str4 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str4)) {
                iT2 = !z10 ? t2(str4) : 0;
                if (iT2 == 0) {
                    iT2 = u2(str4);
                }
            } else {
                iT2 = 0;
            }
            if (iT2 != 0) {
                y1(bundle2, iT2, str4, iT2 == 3 ? str4 : str3);
                bundle2.remove(str4);
            } else {
                int iS1 = s1(str, str4, bundle.get(str4), bundle2, list2, z10, zM1);
                if (iS1 == 17) {
                    y1(bundle2, 17, str4, Boolean.FALSE);
                } else if (iS1 != 0 && !"_ev".equals(str4)) {
                    y1(bundle2, iS1, iS1 == 21 ? str : str4, bundle.get(str4));
                    bundle2.remove(str4);
                }
                if (l2(str4)) {
                    i10++;
                    if (i10 > i) {
                        if (r1Var.f4366y.w1(str3, f0.f4123f1) && z11) {
                            str2 = str3;
                        } else {
                            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 37);
                            sb.append("Event can't contain more than ");
                            sb.append(i);
                            sb.append(" params");
                            String string = sb.toString();
                            w0 w0Var = r1Var.A;
                            r1.g(w0Var);
                            str2 = str3;
                            w0Var.D.c(q0Var.a(str), q0Var.e(bundle), string);
                        }
                        g2(5, bundle2);
                        bundle2.remove(str4);
                        z11 = true;
                        list2 = list;
                        str3 = str2;
                    } else {
                        list2 = list;
                    }
                }
            }
            str2 = str3;
            list2 = list;
            str3 = str2;
        }
        return bundle2;
    }

    public final int u2(String str) {
        if (!o2("event param", str)) {
            return 3;
        }
        if (!p2("event param", null, null, str)) {
            return 14;
        }
        ((r1) this.f307w).getClass();
        return !q2(40, "event param", str) ? 3 : 0;
    }

    public final void v1(x0 x0Var, int i) {
        Bundle bundle = (Bundle) x0Var.f4474e;
        int i10 = 0;
        boolean z10 = false;
        for (String str : new TreeSet(bundle.keySet())) {
            if (l2(str) && (i10 = i10 + 1) > i) {
                r1 r1Var = (r1) this.f307w;
                g gVar = r1Var.f4366y;
                q0 q0Var = r1Var.E;
                if (!gVar.w1(null, f0.f4123f1) || !z10) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 37);
                    sb.append("Event can't contain more than ");
                    sb.append(i);
                    sb.append(" params");
                    String string = sb.toString();
                    w0 w0Var = r1Var.A;
                    r1.g(w0Var);
                    w0Var.D.c(q0Var.a((String) x0Var.f4472c), q0Var.e(bundle), string);
                    g2(5, bundle);
                }
                bundle.remove(str);
                z10 = true;
            }
        }
    }

    public final void w1(Parcelable[] parcelableArr, int i) {
        o8.u.g(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i10 = 0;
            boolean z10 = false;
            for (String str : new TreeSet(bundle.keySet())) {
                if (l2(str) && !M1(str, h2.f4210h) && (i10 = i10 + 1) > i) {
                    r1 r1Var = (r1) this.f307w;
                    g gVar = r1Var.f4366y;
                    q0 q0Var = r1Var.E;
                    if (!gVar.w1(null, f0.f4123f1) || !z10) {
                        w0 w0Var = r1Var.A;
                        r1.g(w0Var);
                        u0 u0Var = w0Var.D;
                        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 60);
                        sb.append("Param can't contain more than ");
                        sb.append(i);
                        sb.append(" item-scoped custom parameters");
                        u0Var.c(q0Var.b(str), q0Var.e(bundle), sb.toString());
                    }
                    g2(28, bundle);
                    bundle.remove(str);
                    z10 = true;
                }
            }
        }
    }

    public final boolean w2(String str, String str2, int i, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String string = obj.toString();
        if (string.codePointCount(0, string.length()) > i) {
            w0 w0Var = ((r1) this.f307w).A;
            r1.g(w0Var);
            w0Var.G.d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(string.length()));
            return false;
        }
        return true;
    }

    public final void x1(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                u4 u4Var = ((r1) this.f307w).D;
                r1.e(u4Var);
                u4Var.B1(bundle, str, bundle2.get(str));
            }
        }
    }

    public final void x2(String str, String str2, Bundle bundle, List list, boolean z10) {
        int iT2;
        String str3;
        int iS1;
        List list2 = list;
        if (bundle == null) {
            return;
        }
        r1 r1Var = (r1) this.f307w;
        g gVar = r1Var.f4366y;
        w0 w0Var = r1Var.A;
        q0 q0Var = r1Var.E;
        u4 u4Var = ((r1) gVar.f307w).D;
        r1.e(u4Var);
        int i = true != u4Var.S1(231100000) ? 0 : 35;
        int i10 = 0;
        boolean z11 = false;
        for (String str4 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str4)) {
                iT2 = !z10 ? t2(str4) : 0;
                if (iT2 == 0) {
                    iT2 = u2(str4);
                }
            } else {
                iT2 = 0;
            }
            if (iT2 != 0) {
                y1(bundle, iT2, str4, iT2 == 3 ? str4 : null);
                bundle.remove(str4);
            } else {
                if (v2(bundle.get(str4))) {
                    r1.g(w0Var);
                    w0Var.G.d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str, str2, str4);
                    iS1 = 22;
                    str3 = null;
                } else {
                    str3 = null;
                    iS1 = s1(str, str4, bundle.get(str4), bundle, list2, z10, false);
                }
                if (iS1 != 0 && !"_ev".equals(str4)) {
                    y1(bundle, iS1, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (l2(str4) && !M1(str4, h2.f4210h)) {
                    int i11 = i10 + 1;
                    if (!S1(231100000)) {
                        r1.g(w0Var);
                        w0Var.D.c(q0Var.a(str), q0Var.e(bundle), "Item array not supported on client's version of Google Play Services (Android Only)");
                        g2(23, bundle);
                        bundle.remove(str4);
                    } else if (i11 > i) {
                        if (!r1Var.f4366y.w1(str3, f0.f4123f1) || !z11) {
                            r1.g(w0Var);
                            u0 u0Var = w0Var.D;
                            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 55);
                            sb.append("Item can't contain more than ");
                            sb.append(i);
                            sb.append(" item-scoped custom params");
                            u0Var.c(q0Var.a(str), q0Var.e(bundle), sb.toString());
                        }
                        g2(28, bundle);
                        bundle.remove(str4);
                        list2 = list;
                        i10 = i11;
                        z11 = true;
                    }
                    list2 = list;
                    i10 = i11;
                }
            }
            list2 = list;
        }
    }

    public final void y1(Bundle bundle, int i, String str, Object obj) {
        if (g2(i, bundle)) {
            ((r1) this.f307w).getClass();
            bundle.putString("_ev", r1(str, true, 40));
            if (obj != null) {
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    public final int z1(Object obj, String str) {
        return "_ldl".equals(str) ? w2("user property referrer", str, i2(str), obj) : w2("user property", str, i2(str), obj) ? 0 : 7;
    }
}
