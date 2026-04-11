package re;

import java.util.concurrent.TimeUnit;
import pe.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f11600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f11603e;
    public static final g f;

    static {
        String property;
        int i = t.f10401a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f11599a = property;
        f11600b = pe.a.i("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int i10 = t.f10401a;
        if (i10 < 2) {
            i10 = 2;
        }
        f11601c = pe.a.j(i10, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        f11602d = pe.a.j(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        f11603e = TimeUnit.SECONDS.toNanos(pe.a.i("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        f = g.f11594a;
    }
}
