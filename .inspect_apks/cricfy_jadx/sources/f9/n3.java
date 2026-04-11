package f9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import java.lang.ref.SoftReference;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n3 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4290v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Parcelable f4291w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ boolean f4292x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f4293y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f4294z;

    public /* synthetic */ n3(FirebaseInstanceIdReceiver firebaseInstanceIdReceiver, Intent intent, Context context, boolean z10, BroadcastReceiver.PendingResult pendingResult) {
        this.f4290v = 3;
        this.f4291w = intent;
        this.f4294z = context;
        this.f4292x = z10;
        this.f4293y = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Executor executor;
        int iA;
        switch (this.f4290v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                t3 t3Var = (t3) this.f4293y;
                i0 i0Var = t3Var.f4420z;
                if (i0Var != null) {
                    t3Var.E1(i0Var, this.f4292x ? null : (s4) this.f4294z, (w4) this.f4291w);
                    t3Var.z1();
                    return;
                } else {
                    w0 w0Var = ((r1) t3Var.f307w).A;
                    r1.g(w0Var);
                    w0Var.B.a("Discarding data. Failed to set user property");
                    return;
                }
            case 1:
                t3 t3Var2 = (t3) this.f4293y;
                i0 i0Var2 = t3Var2.f4420z;
                if (i0Var2 != null) {
                    t3Var2.E1(i0Var2, this.f4292x ? null : (v) this.f4294z, (w4) this.f4291w);
                    t3Var2.z1();
                    return;
                } else {
                    w0 w0Var2 = ((r1) t3Var2.f307w).A;
                    r1.g(w0Var2);
                    w0Var2.B.a("Discarding data. Failed to send event to service");
                    return;
                }
            case 2:
                t3 t3Var3 = (t3) this.f4293y;
                i0 i0Var3 = t3Var3.f4420z;
                if (i0Var3 != null) {
                    t3Var3.E1(i0Var3, this.f4292x ? null : (e) this.f4294z, (w4) this.f4291w);
                    t3Var3.z1();
                    return;
                } else {
                    w0 w0Var3 = ((r1) t3Var3.f307w).A;
                    r1.g(w0Var3);
                    w0Var3.B.a("Discarding data. Failed to send conditional user property to service");
                    return;
                }
            default:
                Intent intent = (Intent) this.f4291w;
                Context context = (Context) this.f4294z;
                boolean z10 = this.f4292x;
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.f4293y;
                try {
                    Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
                    Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
                    if (intent2 == null) {
                        int iIntValue = 500;
                        if (intent.getExtras() != null) {
                            k8.a aVar = new k8.a(intent);
                            CountDownLatch countDownLatch = new CountDownLatch(1);
                            synchronized (FirebaseInstanceIdReceiver.class) {
                                try {
                                    SoftReference softReference = FirebaseInstanceIdReceiver.f3033b;
                                    Executor executorUnconfigurableExecutorService = softReference != null ? (Executor) softReference.get() : null;
                                    if (executorUnconfigurableExecutorService == null) {
                                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new t8.a("pscm-ack-executor"));
                                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                                        executorUnconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
                                        FirebaseInstanceIdReceiver.f3033b = new SoftReference(executorUnconfigurableExecutorService);
                                    }
                                    executor = executorUnconfigurableExecutorService;
                                } finally {
                                }
                                break;
                            }
                            executor.execute(new v1(9, context, aVar, countDownLatch, false));
                            try {
                                iIntValue = ((Integer) vf.g.b(new nc.h(context).b(intent))).intValue();
                            } catch (InterruptedException | ExecutionException e9) {
                                Log.e("FirebaseMessaging", "Failed to send message to service.", e9);
                            }
                            try {
                                if (!countDownLatch.await(TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS)) {
                                    Log.w("CloudMessagingReceiver", "Message ack timed out");
                                }
                            } catch (InterruptedException e10) {
                                Log.w("CloudMessagingReceiver", "Message ack failed: ".concat(e10.toString()));
                            }
                        }
                        iA = iIntValue;
                        break;
                    } else {
                        iA = FirebaseInstanceIdReceiver.a(intent2);
                    }
                    if (z10 && pendingResult != null) {
                        pendingResult.setResultCode(iA);
                    }
                    if (pendingResult != null) {
                        pendingResult.finish();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    throw th;
                }
        }
    }

    public /* synthetic */ n3(t3 t3Var, w4 w4Var, boolean z10, p8.a aVar, int i) {
        this.f4290v = i;
        this.f4291w = w4Var;
        this.f4292x = z10;
        this.f4294z = aVar;
        this.f4293y = t3Var;
    }

    public n3(t3 t3Var, w4 w4Var, boolean z10, e eVar) {
        this.f4290v = 2;
        this.f4291w = w4Var;
        this.f4292x = z10;
        this.f4294z = eVar;
        Objects.requireNonNull(t3Var);
        this.f4293y = t3Var;
    }
}
