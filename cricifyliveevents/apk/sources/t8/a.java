package t8;

import ib.i;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadFactory f11950b = Executors.defaultThreadFactory();

    public a(String str) {
        this.f11949a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f11950b.newThread(new i(runnable, 1));
        threadNewThread.setName(this.f11949a);
        return threadNewThread;
    }
}
