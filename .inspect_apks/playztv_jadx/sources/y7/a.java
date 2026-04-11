package y7;

import c7.q;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadFactory f14540b = Executors.defaultThreadFactory();

    public a(String str) {
        this.f14539a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f14540b.newThread(new q(runnable, 3));
        threadNewThread.setName(this.f14539a);
        return threadNewThread;
    }
}
