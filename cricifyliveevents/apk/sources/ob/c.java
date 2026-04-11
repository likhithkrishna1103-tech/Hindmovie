package ob;

import android.util.Log;
import ge.i;
import java.util.concurrent.ExecutorService;
import ne.h;
import vf.g;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f9742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f9743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f9744c;

    public c(ExecutorService executorService, ExecutorService executorService2) {
        i.e(executorService, "backgroundExecutorService");
        i.e(executorService2, "blockingExecutorService");
        this.f9742a = new b(executorService);
        this.f9743b = new b(executorService);
        g.A(null);
        this.f9744c = new b(executorService2);
    }

    public static final void a() {
        String name = Thread.currentThread().getName();
        i.d(name, "<get-threadName>(...)");
        if (h.c0(name, "Firebase Background Thread #", false)) {
            return;
        }
        String str = "Must be called on a background thread, was called on " + Thread.currentThread().getName() + '.';
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }

    public static final void b() {
        String name = Thread.currentThread().getName();
        i.d(name, "<get-threadName>(...)");
        if (h.c0(name, "Firebase Blocking Thread #", false)) {
            return;
        }
        String str = "Must be called on a blocking thread, was called on " + Thread.currentThread().getName() + '.';
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }
}
