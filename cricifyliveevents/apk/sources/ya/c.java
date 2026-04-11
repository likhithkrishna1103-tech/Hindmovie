package ya;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f14984d = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f14985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f14986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f14987c;

    public c(Runnable runnable, Executor executor) {
        this.f14985a = runnable;
        this.f14986b = executor;
    }

    public c() {
        this.f14985a = null;
        this.f14986b = null;
    }
}
