package nc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g extends Service {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ExecutorService f9045v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public y f9046w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f9047x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f9048y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f9049z;

    public g() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new t8.a("Firebase-Messaging-Intent-Handle"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f9045v = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f9047x = new Object();
        this.f9049z = 0;
    }

    public final void a(Intent intent) {
        if (intent != null) {
            x.b(intent);
        }
        synchronized (this.f9047x) {
            try {
                int i = this.f9049z - 1;
                this.f9049z = i;
                if (i == 0) {
                    stopSelfResult(this.f9048y);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void b(Intent intent);

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if (this.f9046w == null) {
                this.f9046w = new y(new m2.e(this));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f9046w;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.f9045v.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i10) {
        synchronized (this.f9047x) {
            this.f9048y = i10;
            this.f9049z++;
        }
        Intent intent2 = (Intent) ((ArrayDeque) p.p().f9072d).poll();
        if (intent2 == null) {
            a(intent);
            return 2;
        }
        j9.i iVar = new j9.i();
        this.f9045v.execute(new androidx.emoji2.text.n(this, intent2, iVar, 7));
        j9.p pVar = iVar.f6688a;
        if (pVar.i()) {
            a(intent);
            return 2;
        }
        pVar.b(new p.a(1), new androidx.fragment.app.e(14, this, intent));
        return 3;
    }
}
