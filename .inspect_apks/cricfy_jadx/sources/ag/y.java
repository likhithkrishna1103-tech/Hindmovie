package ag;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f472d = new x();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f475c;

    public y a() {
        this.f473a = false;
        return this;
    }

    public y b() {
        this.f475c = 0L;
        return this;
    }

    public long c() {
        if (this.f473a) {
            return this.f474b;
        }
        throw new IllegalStateException("No deadline");
    }

    public y d(long j4) {
        this.f473a = true;
        this.f474b = j4;
        return this;
    }

    public boolean e() {
        return this.f473a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f473a && this.f474b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public y g(long j4) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        ge.i.e(timeUnit, "unit");
        if (j4 >= 0) {
            this.f475c = timeUnit.toNanos(j4);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j4).toString());
    }
}
