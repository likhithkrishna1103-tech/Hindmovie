package k8;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q2 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7383u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f7384v;

    public q2() {
        this.f7383u = 1;
        this.f7384v = new ArrayDeque(10);
    }

    public void a(Intent intent) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f7384v;
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
        } catch (RuntimeException e10) {
            Log.w("FirebaseMessaging", "Failed trying to get analytics data from Intent extras.", e10);
        }
        if (bundle == null ? false : "1".equals(bundle.getString("google.c.a.e"))) {
            if (bundle != null) {
                if ("1".equals(bundle.getString("google.c.a.tc"))) {
                    ka.b bVar = (ka.b) ga.g.c().b(ka.b.class);
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                    }
                    if (bVar != null) {
                        String string2 = bundle.getString("google.c.a.c_id");
                        ka.c cVar = (ka.c) bVar;
                        if (la.a.d("fcm") && la.a.b("fcm", "_ln")) {
                            com.google.android.gms.internal.measurement.i1 i1Var = (com.google.android.gms.internal.measurement.i1) cVar.f7608a.f11562v;
                            i1Var.e(new com.google.android.gms.internal.measurement.j1(i1Var, string2, 1));
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
            a.a.C("_no", bundle);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0073  */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onActivityCreated(android.app.Activity r10, android.os.Bundle r11) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.q2.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        switch (this.f7383u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                v2 v2VarR1 = ((g2) this.f7384v).r1();
                synchronized (v2VarR1.G) {
                    try {
                        if (activity == v2VarR1.B) {
                            v2VarR1.B = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                if (((k1) v2VarR1.f2454v).A.C1()) {
                    v2VarR1.A.remove(Integer.valueOf(activity.hashCode()));
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        switch (this.f7383u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                v2 v2VarR1 = ((g2) this.f7384v).r1();
                synchronized (v2VarR1.G) {
                    v2VarR1.F = false;
                    v2VarR1.C = true;
                    break;
                }
                ((k1) v2VarR1.f2454v).H.getClass();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (((k1) v2VarR1.f2454v).A.C1()) {
                    w2 w2VarC1 = v2VarR1.C1(activity);
                    v2VarR1.f7461y = v2VarR1.f7460x;
                    v2VarR1.f7460x = null;
                    v2VarR1.x().y1(new j2(v2VarR1, w2VarC1, jElapsedRealtime));
                } else {
                    v2VarR1.f7460x = null;
                    v2VarR1.x().y1(new y(v2VarR1, jElapsedRealtime, 1));
                }
                k3 k3VarS1 = ((g2) this.f7384v).s1();
                ((k1) k3VarS1.f2454v).H.getClass();
                k3VarS1.x().y1(new m3(k3VarS1, SystemClock.elapsedRealtime(), 0));
                return;
            default:
                return;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        switch (this.f7383u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k3 k3VarS1 = ((g2) this.f7384v).s1();
                ((k1) k3VarS1.f2454v).H.getClass();
                k3VarS1.x().y1(new m3(k3VarS1, SystemClock.elapsedRealtime(), 1));
                v2 v2VarR1 = ((g2) this.f7384v).r1();
                synchronized (v2VarR1.G) {
                    v2VarR1.F = true;
                    if (activity != v2VarR1.B) {
                        synchronized (v2VarR1.G) {
                            v2VarR1.B = activity;
                            v2VarR1.C = false;
                            break;
                        }
                        if (((k1) v2VarR1.f2454v).A.C1()) {
                            v2VarR1.D = null;
                            v2VarR1.x().y1(new x2(v2VarR1, 1));
                        }
                    }
                }
                if (!((k1) v2VarR1.f2454v).A.C1()) {
                    v2VarR1.f7460x = v2VarR1.D;
                    v2VarR1.x().y1(new x2(v2VarR1, 0));
                    return;
                }
                v2VarR1.z1(activity, v2VarR1.C1(activity), false);
                q qVarK = ((k1) v2VarR1.f2454v).k();
                ((k1) qVarK.f2454v).H.getClass();
                qVarK.x().y1(new y(qVarK, SystemClock.elapsedRealtime(), 0));
                return;
            default:
                return;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        w2 w2Var;
        switch (this.f7383u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                v2 v2VarR1 = ((g2) this.f7384v).r1();
                if (((k1) v2VarR1.f2454v).A.C1() && bundle != null && (w2Var = (w2) v2VarR1.A.get(Integer.valueOf(activity.hashCode()))) != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putLong("id", w2Var.f7528c);
                    bundle2.putString("name", w2Var.f7526a);
                    bundle2.putString("referrer_name", w2Var.f7527b);
                    bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
                }
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        int i = this.f7383u;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        int i = this.f7383u;
    }

    public q2(g2 g2Var) {
        this.f7383u = 0;
        this.f7384v = g2Var;
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
