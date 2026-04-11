package we;

import java.util.concurrent.TimeUnit;
import ue.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f14168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f14169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f14170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f14171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f14172e;
    public static final g f;

    static {
        String property;
        int i = t.f12487a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f14168a = property;
        f14169b = ue.a.i("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i10 = t.f12487a;
        if (i10 < 2) {
            i10 = 2;
        }
        f14170c = ue.a.j(i10, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        f14171d = ue.a.j(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        f14172e = TimeUnit.SECONDS.toNanos(ue.a.i("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f = g.f14163a;
    }
}
