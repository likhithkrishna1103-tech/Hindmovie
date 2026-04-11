package h6;

import b8.g;
import ea.t;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f5947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5948b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicInteger f5951e = new AtomicInteger();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f5949c = c.f5952a;

    public b(a aVar, String str, boolean z2) {
        this.f5947a = aVar;
        this.f5948b = str;
        this.f5950d = z2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        t tVar = new t(6, this, runnable, false);
        this.f5947a.getClass();
        g gVar = new g(tVar);
        gVar.setName("glide-" + this.f5948b + "-thread-" + this.f5951e.getAndIncrement());
        return gVar;
    }
}
