package s6;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements ThreadFactory {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f11548d = new AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadGroup f11549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f11550b = new AtomicInteger(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11551c;

    public d() {
        SecurityManager securityManager = System.getSecurityManager();
        this.f11549a = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
        this.f11551c = "lottie-" + f11548d.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f11549a, runnable, this.f11551c + this.f11550b.getAndIncrement(), 0L);
        thread.setDaemon(false);
        thread.setPriority(10);
        return thread;
    }
}
