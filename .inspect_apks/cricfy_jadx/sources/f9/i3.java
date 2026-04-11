package f9;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i3 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4218v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f4219w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f4220x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f4221y;

    public i3(j3 j3Var, f3 f3Var, long j4) {
        this.f4220x = f3Var;
        this.f4219w = j4;
        Objects.requireNonNull(j3Var);
        this.f4221y = j3Var;
    }

    public boolean a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) ((FirebaseMessaging) this.f4221y).f3039b.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean b() throws IOException {
        try {
            if (((FirebaseMessaging) this.f4221y).a() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            }
            Log.d("FirebaseMessaging", "Token successfully retrieved");
            return true;
        } catch (IOException e9) {
            String message = e9.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                if (e9.getMessage() != null) {
                    throw e9;
                }
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            Log.w("FirebaseMessaging", "Token retrieval failed: " + e9.getMessage() + ". Will retry token retrieval");
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4218v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j3 j3Var = (j3) this.f4221y;
                j3Var.q1((f3) this.f4220x, false, this.f4219w);
                j3Var.A = null;
                t3 t3VarJ = ((r1) j3Var.f307w).j();
                t3VarJ.m1();
                t3VarJ.n1();
                t3VarJ.A1(new ya.s(t3VarJ, (f3) null));
                return;
            default:
                PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) this.f4220x;
                nc.p pVarP = nc.p.p();
                FirebaseMessaging firebaseMessaging = (FirebaseMessaging) this.f4221y;
                if (pVarP.r(firebaseMessaging.f3039b)) {
                    wakeLock.acquire();
                }
                try {
                    try {
                        synchronized (firebaseMessaging) {
                            firebaseMessaging.f3045j = true;
                        }
                        if (!firebaseMessaging.i.g()) {
                            firebaseMessaging.f(false);
                            if (!nc.p.p().r(firebaseMessaging.f3039b)) {
                                return;
                            }
                        } else if (!nc.p.p().q(firebaseMessaging.f3039b) || a()) {
                            if (b()) {
                                firebaseMessaging.f(false);
                            } else {
                                firebaseMessaging.h(this.f4219w);
                            }
                            if (!nc.p.p().r(firebaseMessaging.f3039b)) {
                                return;
                            }
                        } else {
                            n8.m mVar = new n8.m();
                            mVar.f8891c = this;
                            mVar.a();
                            if (!nc.p.p().r(firebaseMessaging.f3039b)) {
                                return;
                            }
                        }
                    } catch (IOException e9) {
                        Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e9.getMessage() + ". Won't retry the operation.");
                        firebaseMessaging.f(false);
                        if (!nc.p.p().r(firebaseMessaging.f3039b)) {
                            return;
                        }
                    }
                    wakeLock.release();
                    return;
                } catch (Throwable th) {
                    if (nc.p.p().r(firebaseMessaging.f3039b)) {
                        wakeLock.release();
                    }
                    throw th;
                }
        }
    }

    public i3(FirebaseMessaging firebaseMessaging, long j4) {
        new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new t8.a("firebase-iid-executor"));
        this.f4221y = firebaseMessaging;
        this.f4219w = j4;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) firebaseMessaging.f3039b.getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f4220x = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }
}
