package k8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import java.lang.ref.SoftReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c3 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7119u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Parcelable f7120v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ boolean f7121w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f7122x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f7123y;

    public /* synthetic */ c3(FirebaseInstanceIdReceiver firebaseInstanceIdReceiver, Intent intent, Context context, boolean z2, BroadcastReceiver.PendingResult pendingResult) {
        this.f7119u = 3;
        this.f7120v = intent;
        this.f7123y = context;
        this.f7121w = z2;
        this.f7122x = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Executor executorUnconfigurableExecutorService;
        int iA;
        switch (this.f7119u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a4 a4Var = (a4) this.f7120v;
                z2 z2Var = (z2) this.f7122x;
                h0 h0Var = z2Var.f7573y;
                if (h0Var == null) {
                    z2Var.g().A.d("Discarding data. Failed to set user property");
                    return;
                } else {
                    z2Var.z1(h0Var, this.f7121w ? null : (e4) this.f7123y, a4Var);
                    z2Var.H1();
                    return;
                }
            case 1:
                a4 a4Var2 = (a4) this.f7120v;
                z2 z2Var2 = (z2) this.f7122x;
                h0 h0Var2 = z2Var2.f7573y;
                if (h0Var2 == null) {
                    z2Var2.g().A.d("Discarding data. Failed to send event to service");
                    return;
                } else {
                    z2Var2.z1(h0Var2, this.f7121w ? null : (v) this.f7123y, a4Var2);
                    z2Var2.H1();
                    return;
                }
            case 2:
                a4 a4Var3 = (a4) this.f7120v;
                z2 z2Var3 = (z2) this.f7122x;
                h0 h0Var3 = z2Var3.f7573y;
                if (h0Var3 == null) {
                    z2Var3.g().A.d("Discarding data. Failed to send conditional user property to service");
                    return;
                } else {
                    z2Var3.z1(h0Var3, this.f7121w ? null : (d) this.f7123y, a4Var3);
                    z2Var3.H1();
                    return;
                }
            default:
                Intent intent = (Intent) this.f7120v;
                Context context = (Context) this.f7123y;
                boolean z2 = this.f7121w;
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.f7122x;
                try {
                    Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
                    Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
                    if (intent2 == null) {
                        int iIntValue = 500;
                        if (intent.getExtras() != null) {
                            p7.a aVar = new p7.a(intent);
                            CountDownLatch countDownLatch = new CountDownLatch(1);
                            synchronized (FirebaseInstanceIdReceiver.class) {
                                try {
                                    SoftReference softReference = FirebaseInstanceIdReceiver.f3570b;
                                    executorUnconfigurableExecutorService = softReference != null ? (Executor) softReference.get() : null;
                                    if (executorUnconfigurableExecutorService == null) {
                                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new y7.a("pscm-ack-executor"));
                                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                                        executorUnconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
                                        FirebaseInstanceIdReceiver.f3570b = new SoftReference(executorUnconfigurableExecutorService);
                                    }
                                } finally {
                                }
                                break;
                            }
                            executorUnconfigurableExecutorService.execute(new ab.c(context, aVar, countDownLatch));
                            try {
                                iIntValue = ((Integer) wa.t1.d(new ub.i(context).b(intent))).intValue();
                            } catch (InterruptedException | ExecutionException e10) {
                                Log.e("FirebaseMessaging", "Failed to send message to service.", e10);
                            }
                            try {
                                if (!countDownLatch.await(TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS)) {
                                    Log.w("CloudMessagingReceiver", "Message ack timed out");
                                }
                            } catch (InterruptedException e11) {
                                Log.w("CloudMessagingReceiver", "Message ack failed: ".concat(e11.toString()));
                            }
                        }
                        iA = iIntValue;
                        break;
                    } else {
                        iA = FirebaseInstanceIdReceiver.a(intent2);
                    }
                    if (z2 && pendingResult != null) {
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

    public /* synthetic */ c3(z2 z2Var, a4 a4Var, boolean z2, u7.a aVar, int i) {
        this.f7119u = i;
        this.f7120v = a4Var;
        this.f7121w = z2;
        this.f7123y = aVar;
        this.f7122x = z2Var;
    }

    public c3(z2 z2Var, a4 a4Var, boolean z2, d dVar, d dVar2) {
        this.f7119u = 2;
        this.f7120v = a4Var;
        this.f7121w = z2;
        this.f7123y = dVar;
        this.f7122x = z2Var;
    }
}
