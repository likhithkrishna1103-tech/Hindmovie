package k8;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j2 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7257u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f7258v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f7259w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f7260x;

    public /* synthetic */ j2() {
    }

    public boolean a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ((FirebaseMessaging) this.f7260x).f3576b.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean b() throws IOException {
        try {
            if (((FirebaseMessaging) this.f7260x).a() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            }
            Log.d("FirebaseMessaging", "Token successfully retrieved");
            return true;
        } catch (IOException e10) {
            String message = e10.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                if (e10.getMessage() != null) {
                    throw e10;
                }
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            Log.w("FirebaseMessaging", "Token retrieval failed: " + e10.getMessage() + ". Will retry token retrieval");
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7257u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g2 g2Var = (g2) this.f7259w;
                Bundle bundle = (Bundle) this.f7260x;
                long j5 = this.f7258v;
                if (TextUtils.isEmpty(((k1) g2Var.f2454v).m().x1())) {
                    g2Var.y1(bundle, 0, j5);
                    return;
                } else {
                    g2Var.g().F.d("Using developer consent only; google app id found");
                    return;
                }
            case 1:
                v2 v2Var = (v2) this.f7260x;
                v2Var.B1((w2) this.f7259w, false, this.f7258v);
                v2Var.f7462z = null;
                z2 z2VarP = ((k1) v2Var.f2454v).p();
                z2VarP.p1();
                z2VarP.t1();
                z2VarP.w1(new ea.t(17, z2VarP, null, false));
                return;
            default:
                PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) this.f7259w;
                ub.o oVarZ = ub.o.z();
                FirebaseMessaging firebaseMessaging = (FirebaseMessaging) this.f7260x;
                if (oVarZ.E(firebaseMessaging.f3576b)) {
                    wakeLock.acquire();
                }
                try {
                    try {
                        synchronized (firebaseMessaging) {
                            firebaseMessaging.f3582j = true;
                        }
                        if (!firebaseMessaging.i.g()) {
                            firebaseMessaging.f(false);
                            if (!ub.o.z().E(firebaseMessaging.f3576b)) {
                                return;
                            }
                        } else if (!ub.o.z().D(firebaseMessaging.f3576b) || a()) {
                            if (b()) {
                                firebaseMessaging.f(false);
                            } else {
                                firebaseMessaging.h(this.f7258v);
                            }
                            if (!ub.o.z().E(firebaseMessaging.f3576b)) {
                                return;
                            }
                        } else {
                            c2.e eVar = new c2.e();
                            eVar.f2259b = this;
                            eVar.a();
                            if (!ub.o.z().E(firebaseMessaging.f3576b)) {
                                return;
                            }
                        }
                    } catch (IOException e10) {
                        Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e10.getMessage() + ". Won't retry the operation.");
                        firebaseMessaging.f(false);
                        if (!ub.o.z().E(firebaseMessaging.f3576b)) {
                            return;
                        }
                    }
                    wakeLock.release();
                    return;
                } catch (Throwable th) {
                    if (ub.o.z().E(firebaseMessaging.f3576b)) {
                        wakeLock.release();
                    }
                    throw th;
                }
        }
    }

    public j2(v2 v2Var, w2 w2Var, long j5) {
        this.f7259w = w2Var;
        this.f7258v = j5;
        this.f7260x = v2Var;
    }

    public j2(FirebaseMessaging firebaseMessaging, long j5) {
        new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new y7.a("firebase-iid-executor"));
        this.f7260x = firebaseMessaging;
        this.f7258v = j5;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) firebaseMessaging.f3576b.getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f7259w = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }
}
