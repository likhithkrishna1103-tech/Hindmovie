package g2;

import android.os.SystemClock;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends r2.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4859g;

    @Override // r2.r
    public final int m() {
        return 0;
    }

    @Override // r2.r
    public final int n() {
        return this.f4859g;
    }

    @Override // r2.r
    public final Object q() {
        return null;
    }

    @Override // r2.r
    public final void s(long j5, long j8, long j10, List list, p2.n[] nVarArr) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (b(this.f4859g, jElapsedRealtime)) {
            for (int i = this.f11307b - 1; i >= 0; i--) {
                if (!b(i, jElapsedRealtime)) {
                    this.f4859g = i;
                    return;
                }
            }
            throw new IllegalStateException();
        }
    }
}
