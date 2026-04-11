package hf;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends y {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y f6118e;

    public j(y yVar) {
        be.h.e(yVar, "delegate");
        this.f6118e = yVar;
    }

    @Override // hf.y
    public final y a() {
        return this.f6118e.a();
    }

    @Override // hf.y
    public final y b() {
        return this.f6118e.b();
    }

    @Override // hf.y
    public final long c() {
        return this.f6118e.c();
    }

    @Override // hf.y
    public final y d(long j5) {
        return this.f6118e.d(j5);
    }

    @Override // hf.y
    public final boolean e() {
        return this.f6118e.e();
    }

    @Override // hf.y
    public final void f() throws InterruptedIOException {
        this.f6118e.f();
    }

    @Override // hf.y
    public final y g(long j5) {
        be.h.e(TimeUnit.MILLISECONDS, "unit");
        return this.f6118e.g(j5);
    }
}
