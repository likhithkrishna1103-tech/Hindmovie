package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g4 implements j4 {
    public static final s.e B = new s.e(0);
    public static final String[] C = {"key", "value"};
    public final ArrayList A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ContentResolver f3010u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Uri f3011v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f3012w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final d4 f3013x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f3014y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile Map f3015z;

    public g4(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        d4 d4Var = new d4(1, this);
        this.f3013x = d4Var;
        this.f3014y = new Object();
        this.A = new ArrayList();
        contentResolver.getClass();
        uri.getClass();
        this.f3010u = contentResolver;
        this.f3011v = uri;
        this.f3012w = runnable;
        contentResolver.registerContentObserver(uri, false, d4Var);
    }

    public static g4 a(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        g4 g4Var;
        synchronized (g4.class) {
            s.e eVar = B;
            g4Var = (g4) eVar.get(uri);
            if (g4Var == null) {
                try {
                    g4 g4Var2 = new g4(contentResolver, uri, runnable);
                    try {
                        eVar.put(uri, g4Var2);
                    } catch (SecurityException unused) {
                    }
                    g4Var = g4Var2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return g4Var;
    }

    public static synchronized void c() {
        try {
            for (g4 g4Var : (s.d) B.values()) {
                g4Var.f3010u.unregisterContentObserver(g4Var.f3013x);
            }
            B.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0056  */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.os.StrictMode$ThreadPolicy, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map b() {
        /*
            r5 = this;
            java.util.Map r0 = r5.f3015z
            if (r0 != 0) goto L53
            java.lang.Object r1 = r5.f3014y
            monitor-enter(r1)
            java.util.Map r0 = r5.f3015z     // Catch: java.lang.Throwable -> L49
            if (r0 != 0) goto L4f
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskReads()     // Catch: java.lang.Throwable -> L49
            com.google.android.gms.internal.measurement.x5 r2 = new com.google.android.gms.internal.measurement.x5     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
            r2.<init>()     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
            r2.f3235a = r5     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
            java.lang.Object r2 = r2.c()     // Catch: java.lang.SecurityException -> L1b java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30
            goto L26
        L1b:
            long r3 = android.os.Binder.clearCallingIdentity()     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
            java.lang.Object r2 = r2.c()     // Catch: java.lang.Throwable -> L34
            android.os.Binder.restoreCallingIdentity(r3)     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
        L26:
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
            android.os.StrictMode.setThreadPolicy(r0)     // Catch: java.lang.Throwable -> L49
            goto L45
        L2c:
            r2 = move-exception
            goto L4b
        L2e:
            r2 = move-exception
            goto L39
        L30:
            r2 = move-exception
            goto L39
        L32:
            r2 = move-exception
            goto L39
        L34:
            r2 = move-exception
            android.os.Binder.restoreCallingIdentity(r3)     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
            throw r2     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
        L39:
            java.lang.String r3 = "ConfigurationContentLdr"
            java.lang.String r4 = "Unable to query ContentProvider, using default values"
            android.util.Log.w(r3, r4, r2)     // Catch: java.lang.Throwable -> L2c
            java.util.Map r2 = java.util.Collections.EMPTY_MAP     // Catch: java.lang.Throwable -> L2c
            android.os.StrictMode.setThreadPolicy(r0)     // Catch: java.lang.Throwable -> L49
        L45:
            r5.f3015z = r2     // Catch: java.lang.Throwable -> L49
            r0 = r2
            goto L4f
        L49:
            r0 = move-exception
            goto L51
        L4b:
            android.os.StrictMode.setThreadPolicy(r0)     // Catch: java.lang.Throwable -> L49
            throw r2     // Catch: java.lang.Throwable -> L49
        L4f:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L49
            goto L53
        L51:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L49
            throw r0
        L53:
            if (r0 == 0) goto L56
            return r0
        L56:
            java.util.Map r0 = java.util.Collections.EMPTY_MAP
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.g4.b():java.util.Map");
    }

    @Override // com.google.android.gms.internal.measurement.j4
    public final /* synthetic */ Object d(String str) {
        return (String) b().get(str);
    }
}
