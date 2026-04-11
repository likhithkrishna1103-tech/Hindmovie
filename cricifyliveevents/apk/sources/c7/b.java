package c7;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import ya.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2101b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicInteger f2104e = new AtomicInteger();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f2102c = c.f2105a;

    public b(a aVar, String str, boolean z10) {
        this.f2100a = aVar;
        this.f2101b = str;
        this.f2103d = z10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        s sVar = new s(1, this, runnable, false);
        this.f2100a.getClass();
        ag.b bVar = new ag.b(sVar);
        bVar.setName("glide-" + this.f2101b + "-thread-" + this.f2104e.getAndIncrement());
        return bVar;
    }
}
