package hf;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f6155d = new x();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f6157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f6158c;

    public y a() {
        this.f6156a = false;
        return this;
    }

    public y b() {
        this.f6158c = 0L;
        return this;
    }

    public long c() {
        if (this.f6156a) {
            return this.f6157b;
        }
        throw new IllegalStateException("No deadline");
    }

    public y d(long j5) {
        this.f6156a = true;
        this.f6157b = j5;
        return this;
    }

    public boolean e() {
        return this.f6156a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f6156a && this.f6157b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public y g(long j5) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        be.h.e(timeUnit, "unit");
        if (j5 >= 0) {
            this.f6158c = timeUnit.toNanos(j5);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j5).toString());
    }
}
