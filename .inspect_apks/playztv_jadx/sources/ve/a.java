package ve;

import be.h;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f13495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f13496b;

    public /* synthetic */ a(String str, boolean z2) {
        this.f13495a = str;
        this.f13496b = z2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.f13495a;
        h.e(str, "$name");
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(this.f13496b);
        return thread;
    }
}
