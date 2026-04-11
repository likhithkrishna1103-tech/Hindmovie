package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i4 implements ya.r {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static i4 f2480z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f2481v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2482w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f2483x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f2484y;

    public i4(int i) {
        this.f2481v = i;
        switch (i) {
            case 1:
                this.f2483x = Collections.newSetFromMap(new WeakHashMap());
                this.f2484y = new HashSet();
                break;
            case 2:
            default:
                this.f2482w = false;
                this.f2483x = null;
                this.f2484y = null;
                break;
            case 3:
                break;
        }
    }

    public static i4 c(Context context) {
        i4 i4Var;
        synchronized (i4.class) {
            try {
                if (f2480z == null) {
                    f2480z = i0.c.b(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new i4(context) : new i4(0);
                }
                i4 i4Var2 = f2480z;
                if (i4Var2 != null && ((h4) i4Var2.f2484y) != null && !i4Var2.f2482w) {
                    try {
                        context.getContentResolver().registerContentObserver(y3.f2731a, true, (h4) f2480z.f2484y);
                        i4 i4Var3 = f2480z;
                        i4Var3.getClass();
                        i4Var3.f2482w = true;
                    } catch (SecurityException e9) {
                        Log.e("GservicesLoader", "Unable to register Gservices content observer", e9);
                    }
                }
                i4Var = f2480z;
                i4Var.getClass();
            } catch (Throwable th) {
                throw th;
            }
        }
        return i4Var;
    }

    public static synchronized void e() {
        Context context;
        try {
            i4 i4Var = f2480z;
            if (i4Var != null && (context = (Context) i4Var.f2483x) != null && ((h4) i4Var.f2484y) != null && i4Var.f2482w) {
                context.getContentResolver().unregisterContentObserver((h4) f2480z.f2484y);
            }
            f2480z = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // ya.r
    public void a(Object obj) {
        k4.b0 b0Var = (k4.b0) this.f2484y;
        k4.s sVar = (k4.s) this.f2483x;
        boolean z10 = this.f2482w;
        ab.b.B(b0Var.f6924t, (k4.t) obj);
        y1.a0.F(b0Var.f6924t);
        if (z10) {
            b0Var.p(sVar);
        }
    }

    public boolean b(o7.c cVar) {
        boolean z10 = true;
        if (cVar == null) {
            return true;
        }
        boolean zRemove = ((Set) this.f2483x).remove(cVar);
        if (!((HashSet) this.f2484y).remove(cVar) && !zRemove) {
            z10 = false;
        }
        if (z10) {
            cVar.clear();
        }
        return z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String d(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f2483x
            android.content.Context r0 = (android.content.Context) r0
            r1 = 0
            if (r0 == 0) goto L93
            boolean r2 = com.google.android.gms.internal.measurement.c4.a()
            if (r2 == 0) goto L65
            boolean r2 = com.google.android.gms.internal.measurement.c4.f2341b
            r3 = 1
            if (r2 == 0) goto L13
            goto L60
        L13:
            java.lang.Class<com.google.android.gms.internal.measurement.c4> r2 = com.google.android.gms.internal.measurement.c4.class
            monitor-enter(r2)
            boolean r4 = com.google.android.gms.internal.measurement.c4.f2341b     // Catch: java.lang.Throwable -> L1c
            if (r4 == 0) goto L1e
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
            goto L60
        L1c:
            r9 = move-exception
            goto L63
        L1e:
            r4 = r3
        L1f:
            r5 = 2
            r6 = 0
            if (r4 > r5) goto L56
            android.os.UserManager r5 = com.google.android.gms.internal.measurement.c4.f2340a     // Catch: java.lang.Throwable -> L1c
            if (r5 != 0) goto L31
            java.lang.Class<android.os.UserManager> r5 = android.os.UserManager.class
            java.lang.Object r5 = r0.getSystemService(r5)     // Catch: java.lang.Throwable -> L1c
            android.os.UserManager r5 = (android.os.UserManager) r5     // Catch: java.lang.Throwable -> L1c
            com.google.android.gms.internal.measurement.c4.f2340a = r5     // Catch: java.lang.Throwable -> L1c
        L31:
            android.os.UserManager r5 = com.google.android.gms.internal.measurement.c4.f2340a     // Catch: java.lang.Throwable -> L1c
            if (r5 != 0) goto L37
            r6 = r3
            goto L5a
        L37:
            boolean r7 = a9.b.A(r5)     // Catch: java.lang.Throwable -> L1c java.lang.NullPointerException -> L49
            if (r7 != 0) goto L47
            android.os.UserHandle r7 = android.os.Process.myUserHandle()     // Catch: java.lang.Throwable -> L1c java.lang.NullPointerException -> L49
            boolean r0 = r5.isUserRunning(r7)     // Catch: java.lang.Throwable -> L1c java.lang.NullPointerException -> L49
            if (r0 != 0) goto L56
        L47:
            r6 = r3
            goto L56
        L49:
            r5 = move-exception
            java.lang.String r6 = "DirectBootUtils"
            java.lang.String r7 = "Failed to check if user is unlocked."
            android.util.Log.w(r6, r7, r5)     // Catch: java.lang.Throwable -> L1c
            com.google.android.gms.internal.measurement.c4.f2340a = r1     // Catch: java.lang.Throwable -> L1c
            int r4 = r4 + 1
            goto L1f
        L56:
            if (r6 == 0) goto L5a
            com.google.android.gms.internal.measurement.c4.f2340a = r1     // Catch: java.lang.Throwable -> L1c
        L5a:
            if (r6 == 0) goto L5e
            com.google.android.gms.internal.measurement.c4.f2341b = r3     // Catch: java.lang.Throwable -> L1c
        L5e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
            r3 = r6
        L60:
            if (r3 != 0) goto L65
            goto L93
        L63:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
            throw r9
        L65:
            com.google.android.gms.internal.measurement.t r0 = new com.google.android.gms.internal.measurement.t     // Catch: java.lang.NullPointerException -> L7d java.lang.SecurityException -> L7f java.lang.IllegalStateException -> L81
            r0.<init>(r8, r9)     // Catch: java.lang.NullPointerException -> L7d java.lang.SecurityException -> L7f java.lang.IllegalStateException -> L81
            java.lang.Object r0 = r0.a()     // Catch: java.lang.SecurityException -> L6f java.lang.NullPointerException -> L7d java.lang.IllegalStateException -> L81
            goto L7a
        L6f:
            long r2 = android.os.Binder.clearCallingIdentity()     // Catch: java.lang.NullPointerException -> L7d java.lang.SecurityException -> L7f java.lang.IllegalStateException -> L81
            java.lang.Object r0 = r0.a()     // Catch: java.lang.Throwable -> L83
            android.os.Binder.restoreCallingIdentity(r2)     // Catch: java.lang.NullPointerException -> L7d java.lang.SecurityException -> L7f java.lang.IllegalStateException -> L81
        L7a:
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.NullPointerException -> L7d java.lang.SecurityException -> L7f java.lang.IllegalStateException -> L81
            return r0
        L7d:
            r0 = move-exception
            goto L88
        L7f:
            r0 = move-exception
            goto L88
        L81:
            r0 = move-exception
            goto L88
        L83:
            r0 = move-exception
            android.os.Binder.restoreCallingIdentity(r2)     // Catch: java.lang.NullPointerException -> L7d java.lang.SecurityException -> L7f java.lang.IllegalStateException -> L81
            throw r0     // Catch: java.lang.NullPointerException -> L7d java.lang.SecurityException -> L7f java.lang.IllegalStateException -> L81
        L88:
            java.lang.String r2 = "Unable to read GServices for: "
            java.lang.String r9 = r2.concat(r9)
            java.lang.String r2 = "GservicesLoader"
            android.util.Log.e(r2, r9, r0)
        L93:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.i4.d(java.lang.String):java.lang.String");
    }

    @Override // ya.r
    public void g(Throwable th) {
        k4.b0 b0Var = (k4.b0) this.f2484y;
        if (th instanceof UnsupportedOperationException) {
            y1.b.q("MediaSessionImpl", "UnsupportedOperationException: Make sure to implement MediaSession.Callback.onPlaybackResumption() if you add a media button receiver to your manifest or if you implement the recent media item contract with your MediaLibraryService.", th);
        } else {
            y1.b.h("MediaSessionImpl", "Failure calling MediaSession.Callback.onPlaybackResumption(): " + th.getMessage(), th);
        }
        y1.a0.F(b0Var.f6924t);
        if (this.f2482w) {
            b0Var.p((k4.s) this.f2483x);
        }
    }

    public String toString() {
        switch (this.f2481v) {
            case 1:
                return super.toString() + "{numRequests=" + ((Set) this.f2483x).size() + ", isPaused=" + this.f2482w + "}";
            default:
                return super.toString();
        }
    }

    public i4(Context context) {
        this.f2481v = 0;
        this.f2482w = false;
        this.f2483x = context;
        this.f2484y = new h4(null);
    }

    public i4(k4.b0 b0Var, k4.s sVar, boolean z10, v1.s0 s0Var) {
        this.f2481v = 2;
        this.f2484y = b0Var;
        this.f2483x = sVar;
        this.f2482w = z10;
    }
}
