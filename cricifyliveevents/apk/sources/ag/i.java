package ag;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends y {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y f434e;

    public i(y yVar) {
        ge.i.e(yVar, "delegate");
        this.f434e = yVar;
    }

    @Override // ag.y
    public final y a() {
        return this.f434e.a();
    }

    @Override // ag.y
    public final y b() {
        return this.f434e.b();
    }

    @Override // ag.y
    public final long c() {
        return this.f434e.c();
    }

    @Override // ag.y
    public final y d(long j4) {
        return this.f434e.d(j4);
    }

    @Override // ag.y
    public final boolean e() {
        return this.f434e.e();
    }

    @Override // ag.y
    public final void f() throws InterruptedIOException {
        this.f434e.f();
    }

    @Override // ag.y
    public final y g(long j4) {
        ge.i.e(TimeUnit.MILLISECONDS, "unit");
        return this.f434e.g(j4);
    }
}
