package hf;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class d extends y {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReentrantLock f6104h;
    public static final Condition i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f6105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f6106k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static d f6107l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6108e;
    public d f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f6109g;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f6104h = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        be.h.d(conditionNewCondition, "newCondition(...)");
        i = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f6105j = millis;
        f6106k = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void h() {
        d dVar;
        long j5 = this.f6158c;
        boolean z2 = this.f6156a;
        if (j5 != 0 || z2) {
            ReentrantLock reentrantLock = f6104h;
            reentrantLock.lock();
            try {
                if (this.f6108e) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.f6108e = true;
                if (f6107l == null) {
                    f6107l = new d();
                    b8.g gVar = new b8.g("Okio Watchdog");
                    gVar.setDaemon(true);
                    gVar.start();
                }
                long jNanoTime = System.nanoTime();
                if (j5 != 0 && z2) {
                    this.f6109g = Math.min(j5, c() - jNanoTime) + jNanoTime;
                } else if (j5 != 0) {
                    this.f6109g = j5 + jNanoTime;
                } else {
                    if (!z2) {
                        throw new AssertionError();
                    }
                    this.f6109g = c();
                }
                long j8 = this.f6109g - jNanoTime;
                d dVar2 = f6107l;
                be.h.b(dVar2);
                while (true) {
                    dVar = dVar2.f;
                    if (dVar == null || j8 < dVar.f6109g - jNanoTime) {
                        break;
                    } else {
                        dVar2 = dVar;
                    }
                }
                this.f = dVar;
                dVar2.f = this;
                if (dVar2 == f6107l) {
                    i.signal();
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final boolean i() {
        ReentrantLock reentrantLock = f6104h;
        reentrantLock.lock();
        try {
            if (!this.f6108e) {
                return false;
            }
            this.f6108e = false;
            d dVar = f6107l;
            while (dVar != null) {
                d dVar2 = dVar.f;
                if (dVar2 == this) {
                    dVar.f = this.f;
                    this.f = null;
                    return false;
                }
                dVar = dVar2;
            }
            reentrantLock.unlock();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void j() {
    }
}
