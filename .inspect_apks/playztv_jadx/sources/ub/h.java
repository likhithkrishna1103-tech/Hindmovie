package ub;

import a2.g1;
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
import n.a1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends Service {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ExecutorService f12847u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public x f12848v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f12849w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f12850x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f12851y;

    public h() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new y7.a("Firebase-Messaging-Intent-Handle"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f12847u = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.f12849w = new Object();
        this.f12851y = 0;
    }

    public final void a(Intent intent) {
        if (intent != null) {
            w.b(intent);
        }
        synchronized (this.f12849w) {
            try {
                int i = this.f12851y - 1;
                this.f12851y = i;
                if (i == 0) {
                    stopSelfResult(this.f12850x);
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
            if (this.f12848v == null) {
                this.f12848v = new x(new a1(this));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f12848v;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.f12847u.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i10) {
        synchronized (this.f12849w) {
            this.f12850x = i10;
            this.f12851y++;
        }
        Intent intent2 = (Intent) ((ArrayDeque) o.z().f12871y).poll();
        if (intent2 == null) {
            a(intent);
            return 2;
        }
        o8.h hVar = new o8.h();
        this.f12847u.execute(new g1(this, intent2, hVar, 11));
        o8.o oVar = hVar.f9421a;
        if (oVar.i()) {
            a(intent);
            return 2;
        }
        oVar.b(new n4.b(0), new b2.b(this, 20, intent));
        return 3;
    }
}
