package f9;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayDeque;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t2 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4417v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f4418w;

    public t2(x2 x2Var) {
        this.f4417v = 0;
        this.f4418w = x2Var;
    }

    public void a(Intent intent) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f4418w;
        Bundle bundle = null;
        try {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String string = extras.getString("google.message_id");
                if (string == null) {
                    string = extras.getString("message_id");
                }
                if (!TextUtils.isEmpty(string)) {
                    if (arrayDeque.contains(string)) {
                        return;
                    } else {
                        arrayDeque.add(string);
                    }
                }
                bundle = extras.getBundle("gcm.n.analytics_data");
            }
        } catch (RuntimeException e9) {
            Log.w("FirebaseMessaging", "Failed trying to get analytics data from Intent extras.", e9);
        }
        if (bundle == null ? false : "1".equals(bundle.getString("google.c.a.e"))) {
            if (bundle != null) {
                if ("1".equals(bundle.getString("google.c.a.tc"))) {
                    eb.b bVar = (eb.b) ab.g.c().b(eb.b.class);
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                    }
                    if (bVar != null) {
                        String string2 = bundle.getString("google.c.a.c_id");
                        eb.c cVar = (eb.c) bVar;
                        if (fb.a.a("fcm") && fb.a.c("fcm", "_ln")) {
                            com.google.android.gms.internal.measurement.k1 k1Var = (com.google.android.gms.internal.measurement.k1) cVar.f3883a.f10037w;
                            k1Var.c(new com.google.android.gms.internal.measurement.w0(k1Var, string2, 0));
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("source", "Firebase");
                        bundle2.putString("medium", "notification");
                        bundle2.putString("campaign", string2);
                        cVar.a("fcm", "_cmp", bundle2);
                    } else {
                        Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                    }
                } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
                }
            }
            com.google.android.gms.internal.measurement.j4.y("_no", bundle);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049 A[Catch: all -> 0x0028, RuntimeException -> 0x002b, TryCatch #1 {RuntimeException -> 0x002b, blocks: (B:3:0x0005, B:5:0x0019, B:7:0x001f, B:22:0x0049, B:25:0x0050, B:27:0x0063, B:29:0x006b, B:35:0x007b, B:40:0x0088, B:15:0x002e, B:17:0x0035, B:19:0x0041), top: B:49:0x0005, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j(com.google.android.gms.internal.measurement.v0 r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f4418w
            r1 = r0
            f9.x2 r1 = (f9.x2) r1
            java.lang.Object r0 = r1.f307w     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            f9.r1 r0 = (f9.r1) r0     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            f9.w0 r2 = r0.A     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            f9.r1.g(r2)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            f9.u0 r2 = r2.J     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            java.lang.String r3 = "onActivityCreated"
            r2.a(r3)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            android.content.Intent r2 = r9.f2660x     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            if (r2 == 0) goto L97
            android.net.Uri r3 = r2.getData()     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            if (r3 == 0) goto L2e
            boolean r4 = r3.isHierarchical()     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            if (r4 != 0) goto L26
            goto L2e
        L26:
            r5 = r3
            goto L47
        L28:
            r0 = move-exception
            goto Lb9
        L2b:
            r0 = move-exception
            goto La4
        L2e:
            android.os.Bundle r3 = r2.getExtras()     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            r4 = 0
            if (r3 == 0) goto L46
            java.lang.String r5 = "com.android.vending.referral_url"
            java.lang.String r3 = r3.getString(r5)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            if (r5 != 0) goto L46
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            goto L26
        L46:
            r5 = r4
        L47:
            if (r5 == 0) goto L97
            boolean r3 = r5.isHierarchical()     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            if (r3 != 0) goto L50
            goto L97
        L50:
            f9.u4 r3 = r0.D     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            f9.r1.e(r3)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            java.lang.String r3 = "android.intent.extra.REFERRER_NAME"
            java.lang.String r2 = r2.getStringExtra(r3)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            java.lang.String r3 = "android-app://com.google.android.googlequicksearchbox/https/www.google.com"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            if (r3 != 0) goto L78
            java.lang.String r3 = "https://www.google.com"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            if (r3 != 0) goto L78
            java.lang.String r3 = "android-app://com.google.appcrawler"
            boolean r2 = r3.equals(r2)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            if (r2 == 0) goto L74
            goto L78
        L74:
            java.lang.String r2 = "auto"
        L76:
            r6 = r2
            goto L7b
        L78:
            java.lang.String r2 = "gs"
            goto L76
        L7b:
            java.lang.String r2 = "referrer"
            java.lang.String r7 = r5.getQueryParameter(r2)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            if (r10 != 0) goto L86
            r2 = 1
        L84:
            r4 = r2
            goto L88
        L86:
            r2 = 0
            goto L84
        L88:
            f9.p1 r0 = r0.B     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            f9.r1.g(r0)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            f9.n2 r2 = new f9.n2     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            r3 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            r0.v1(r2)     // Catch: java.lang.Throwable -> L28 java.lang.RuntimeException -> L2b
            goto Lb4
        L97:
            java.lang.Object r0 = r1.f307w
            f9.r1 r0 = (f9.r1) r0
        L9b:
            f9.j3 r0 = r0.G
            f9.r1.f(r0)
            r0.u1(r9, r10)
            return
        La4:
            java.lang.Object r2 = r1.f307w     // Catch: java.lang.Throwable -> L28
            f9.r1 r2 = (f9.r1) r2     // Catch: java.lang.Throwable -> L28
            f9.w0 r2 = r2.A     // Catch: java.lang.Throwable -> L28
            f9.r1.g(r2)     // Catch: java.lang.Throwable -> L28
            f9.u0 r2 = r2.B     // Catch: java.lang.Throwable -> L28
            java.lang.String r3 = "Throwable caught in onActivityCreated"
            r2.b(r0, r3)     // Catch: java.lang.Throwable -> L28
        Lb4:
            java.lang.Object r0 = r1.f307w
            f9.r1 r0 = (f9.r1) r0
            goto L9b
        Lb9:
            java.lang.Object r1 = r1.f307w
            f9.r1 r1 = (f9.r1) r1
            f9.j3 r1 = r1.G
            f9.r1.f(r1)
            r1.u1(r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.t2.j(com.google.android.gms.internal.measurement.v0, android.os.Bundle):void");
    }

    public void k(com.google.android.gms.internal.measurement.v0 v0Var) {
        j3 j3Var = ((r1) ((x2) this.f4418w).f307w).G;
        r1.f(j3Var);
        synchronized (j3Var.H) {
            try {
                if (Objects.equals(j3Var.C, v0Var)) {
                    j3Var.C = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (((r1) j3Var.f307w).f4366y.A1()) {
            j3Var.B.remove(Integer.valueOf(v0Var.f2658v));
        }
    }

    public void l(com.google.android.gms.internal.measurement.v0 v0Var) {
        r1 r1Var = (r1) ((x2) this.f4418w).f307w;
        j3 j3Var = r1Var.G;
        r1.f(j3Var);
        synchronized (j3Var.H) {
            j3Var.G = false;
            j3Var.D = true;
        }
        r1 r1Var2 = (r1) j3Var.f307w;
        r1Var2.F.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (r1Var2.f4366y.A1()) {
            f3 f3VarR1 = j3Var.r1(v0Var);
            j3Var.f4243z = j3Var.f4242y;
            j3Var.f4242y = null;
            p1 p1Var = r1Var2.B;
            r1.g(p1Var);
            p1Var.v1(new i3(j3Var, f3VarR1, jElapsedRealtime));
        } else {
            j3Var.f4242y = null;
            p1 p1Var2 = r1Var2.B;
            r1.g(p1Var2);
            p1Var2.v1(new x(j3Var, jElapsedRealtime));
        }
        b4 b4Var = r1Var.C;
        r1.f(b4Var);
        r1 r1Var3 = (r1) b4Var.f307w;
        r1Var3.F.getClass();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        p1 p1Var3 = r1Var3.B;
        r1.g(p1Var3);
        p1Var3.v1(new x3(b4Var, jElapsedRealtime2, 1));
    }

    public void m(com.google.android.gms.internal.measurement.v0 v0Var) {
        r1 r1Var = (r1) ((x2) this.f4418w).f307w;
        b4 b4Var = r1Var.C;
        r1.f(b4Var);
        r1 r1Var2 = (r1) b4Var.f307w;
        r1Var2.F.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        p1 p1Var = r1Var2.B;
        r1.g(p1Var);
        p1Var.v1(new x3(b4Var, jElapsedRealtime, 0));
        j3 j3Var = r1Var.G;
        r1.f(j3Var);
        Object obj = j3Var.H;
        synchronized (obj) {
            j3Var.G = true;
            if (!Objects.equals(v0Var, j3Var.C)) {
                synchronized (obj) {
                    j3Var.C = v0Var;
                    j3Var.D = false;
                    r1 r1Var3 = (r1) j3Var.f307w;
                    if (r1Var3.f4366y.A1()) {
                        j3Var.E = null;
                        p1 p1Var2 = r1Var3.B;
                        r1.g(p1Var2);
                        p1Var2.v1(new h3(j3Var, 1));
                    }
                }
            }
        }
        r1 r1Var4 = (r1) j3Var.f307w;
        if (!r1Var4.f4366y.A1()) {
            j3Var.f4242y = j3Var.E;
            p1 p1Var3 = r1Var4.B;
            r1.g(p1Var3);
            p1Var3.v1(new h3(j3Var, 0));
            return;
        }
        j3Var.v1(v0Var.f2659w, j3Var.r1(v0Var), false);
        y yVar = ((r1) j3Var.f307w).I;
        r1.d(yVar);
        r1 r1Var5 = (r1) yVar.f307w;
        r1Var5.F.getClass();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        p1 p1Var4 = r1Var5.B;
        r1.g(p1Var4);
        p1Var4.v1(new x(yVar, jElapsedRealtime2));
    }

    public void n(com.google.android.gms.internal.measurement.v0 v0Var, Bundle bundle) {
        f3 f3Var;
        j3 j3Var = ((r1) ((x2) this.f4418w).f307w).G;
        r1.f(j3Var);
        if (!((r1) j3Var.f307w).f4366y.A1() || bundle == null || (f3Var = (f3) j3Var.B.get(Integer.valueOf(v0Var.f2658v))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", f3Var.f4177c);
        bundle2.putString("name", f3Var.f4175a);
        bundle2.putString("referrer_name", f3Var.f4176b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        switch (this.f4417v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j(com.google.android.gms.internal.measurement.v0.a(activity), bundle);
                break;
            default:
                Intent intent = activity.getIntent();
                if (intent != null) {
                    if (Build.VERSION.SDK_INT > 25) {
                        a(intent);
                    } else {
                        new Handler(Looper.getMainLooper()).post(new nc.i(0, this, intent));
                    }
                    break;
                }
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        switch (this.f4417v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k(com.google.android.gms.internal.measurement.v0.a(activity));
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        switch (this.f4417v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                l(com.google.android.gms.internal.measurement.v0.a(activity));
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        switch (this.f4417v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                m(com.google.android.gms.internal.measurement.v0.a(activity));
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        switch (this.f4417v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                n(com.google.android.gms.internal.measurement.v0.a(activity), bundle);
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        int i = this.f4417v;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        int i = this.f4417v;
    }

    public t2() {
        this.f4417v = 1;
        this.f4418w = new ArrayDeque(10);
    }

    private final void b(Activity activity) {
    }

    private final void c(Activity activity) {
    }

    private final void d(Activity activity) {
    }

    private final void f(Activity activity) {
    }

    private final void g(Activity activity) {
    }

    private final void h(Activity activity) {
    }

    private final void i(Activity activity) {
    }

    private final void e(Activity activity, Bundle bundle) {
    }
}
