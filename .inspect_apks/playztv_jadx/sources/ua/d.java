package ua;

import android.util.Log;
import be.h;
import ie.e;
import java.util.concurrent.ExecutorService;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f12823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f12824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f12825c;

    public d(ExecutorService executorService, ExecutorService executorService2) {
        h.e(executorService, "backgroundExecutorService");
        h.e(executorService2, "blockingExecutorService");
        this.f12823a = new b(executorService);
        this.f12824b = new b(executorService);
        t1.k(null);
        this.f12825c = new b(executorService2);
    }

    public static final void a() {
        String name = Thread.currentThread().getName();
        h.d(name, "threadName");
        if (e.N(name, "Firebase Background Thread #", false)) {
            return;
        }
        String str = "Must be called on a background thread, was called on " + Thread.currentThread().getName() + '.';
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }

    public static final void b() {
        String name = Thread.currentThread().getName();
        h.d(name, "threadName");
        if (e.N(name, "Firebase Blocking Thread #", false)) {
            return;
        }
        String str = "Must be called on a blocking thread, was called on " + Thread.currentThread().getName() + '.';
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }
}
