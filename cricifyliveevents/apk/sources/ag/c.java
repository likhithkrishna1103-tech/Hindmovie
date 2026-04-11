package ag;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class c extends y {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final o f419h;
    public static c i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReentrantLock f420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Condition f421k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f422l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f423m;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f424e;
    public int f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f425g;

    static {
        o oVar = new o((char) 0, 0);
        oVar.f455x = new c[8];
        f419h = oVar;
        ReentrantLock reentrantLock = new ReentrantLock();
        f420j = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        ge.i.d(conditionNewCondition, "newCondition(...)");
        f421k = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f422l = millis;
        f423m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void h() {
        long j4 = this.f475c;
        boolean z10 = this.f473a;
        if (j4 != 0 || z10) {
            ReentrantLock reentrantLock = f420j;
            reentrantLock.lock();
            try {
                if (this.f424e != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.f424e = 1;
                jb.b.d(this);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final boolean i() {
        ReentrantLock reentrantLock = f420j;
        reentrantLock.lock();
        try {
            int i10 = this.f424e;
            this.f424e = 0;
            if (i10 != 1) {
                return i10 == 2;
            }
            f419h.n(this);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public IOException j(IOException iOException) {
        throw null;
    }

    public void k() {
    }
}
