package m2;

import android.os.SystemClock;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends v2.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8053g;

    @Override // v2.q
    public final int k() {
        return 0;
    }

    @Override // v2.q
    public final int l() {
        return this.f8053g;
    }

    @Override // v2.q
    public final Object p() {
        return null;
    }

    @Override // v2.q
    public final void r(long j4, long j7, long j10, List list, t2.l[] lVarArr) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (b(this.f8053g, jElapsedRealtime)) {
            for (int i = this.f13084b - 1; i >= 0; i--) {
                if (!b(i, jElapsedRealtime)) {
                    this.f8053g = i;
                    return;
                }
            }
            throw new IllegalStateException();
        }
    }
}
