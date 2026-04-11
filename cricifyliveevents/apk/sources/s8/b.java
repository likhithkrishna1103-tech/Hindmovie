package s8;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import l8.g;
import l8.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f11611a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f11612b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f11613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f11614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f11615e;
    public static Boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f11616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f11617h;
    public static Boolean i;

    public static String a(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = (bArr[i10] & 240) >>> 4;
            char[] cArr = f11611a;
            sb.append(cArr[i11]);
            sb.append(cArr[bArr[i10] & 15]);
        }
        return sb.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(4:(5:44|13|38|14|15)|(2:45|16)|40|17) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b() throws java.lang.Throwable {
        /*
            java.lang.String r0 = s8.b.f11616g
            if (r0 != 0) goto L75
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L11
            java.lang.String r0 = l8.h.n()
            s8.b.f11616g = r0
            goto L75
        L11:
            int r0 = s8.b.f11617h
            if (r0 != 0) goto L1b
            int r0 = android.os.Process.myPid()
            s8.b.f11617h = r0
        L1b:
            java.lang.String r1 = "/cmdline"
            java.lang.String r2 = "/proc/"
            r3 = 0
            if (r0 > 0) goto L23
            goto L73
        L23:
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            int r4 = r4.length()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            int r4 = r4 + 14
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.append(r2)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.append(r0)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            r5.append(r1)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L64
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L64
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L64
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L64
            android.os.StrictMode.setThreadPolicy(r1)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L70
            o8.u.g(r0)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L70
            java.lang.String r3 = r0.trim()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L70
        L5b:
            r2.close()     // Catch: java.io.IOException -> L73
            goto L73
        L5f:
            r0 = move-exception
            r3 = r2
            goto L69
        L62:
            r0 = move-exception
            goto L69
        L64:
            r0 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
            throw r0     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L6f
        L69:
            if (r3 == 0) goto L6e
            r3.close()     // Catch: java.io.IOException -> L6e
        L6e:
            throw r0
        L6f:
            r2 = r3
        L70:
            if (r2 == 0) goto L73
            goto L5b
        L73:
            s8.b.f11616g = r3
        L75:
            java.lang.String r0 = s8.b.f11616g
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.b.b():java.lang.String");
    }

    public static byte[] c(Context context, String str) {
        MessageDigest messageDigest;
        PackageInfo packageInfoB = u8.b.a(context).b(64, str);
        Signature[] signatureArr = packageInfoB.signatures;
        if (signatureArr != null && signatureArr.length == 1) {
            int i10 = 0;
            while (true) {
                if (i10 >= 2) {
                    messageDigest = null;
                    break;
                }
                try {
                    messageDigest = MessageDigest.getInstance("SHA1");
                } catch (NoSuchAlgorithmException unused) {
                }
                if (messageDigest != null) {
                    break;
                }
                i10++;
            }
            if (messageDigest != null) {
                return messageDigest.digest(packageInfoB.signatures[0].toByteArray());
            }
        }
        return null;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean e(Context context, int i10) {
        if (g(i10, context, "com.google.android.gms")) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
                i iVarB = i.b(context);
                iVarB.getClass();
                if (packageInfo != null) {
                    if (!i.d(packageInfo, false)) {
                        if (i.d(packageInfo, true)) {
                            if (!g.a((Context) iVarB.f7897v)) {
                                Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                            }
                        }
                    }
                    return true;
                }
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
                if (Log.isLoggable("UidVerifier", 3)) {
                    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
                }
            }
        }
        return false;
    }

    public static boolean f(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f11613c == null) {
            f11613c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (f11613c.booleanValue() && Build.VERSION.SDK_INT < 24) {
            return true;
        }
        if (f11614d == null) {
            f11614d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        if (f11614d.booleanValue()) {
            return !d() || Build.VERSION.SDK_INT >= 30;
        }
        return false;
    }

    public static boolean g(int i10, Context context, String str) {
        b7.e eVarA = u8.b.a(context);
        eVarA.getClass();
        try {
            AppOpsManager appOpsManager = (AppOpsManager) eVarA.f1830a.getSystemService("appops");
            if (appOpsManager == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager.checkPackage(i10, str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
