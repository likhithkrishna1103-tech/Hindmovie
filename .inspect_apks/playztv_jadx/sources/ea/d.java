package ea;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f4598d = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f4599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f4600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f4601c;

    public d(Runnable runnable, Executor executor) {
        this.f4599a = runnable;
        this.f4600b = executor;
    }

    public d() {
        this.f4599a = null;
        this.f4600b = null;
    }
}
