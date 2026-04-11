package k2;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends n {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f6881j;

    public o(j jVar, long j4, long j7, long j10, long j11, List list, long j12, List list2, long j13, long j14) {
        super(jVar, j4, j7, j10, j11, list, j12, j13, j14);
        this.f6881j = list2;
    }

    @Override // k2.n
    public final long d(long j4) {
        return this.f6881j.size();
    }

    @Override // k2.n
    public final j h(k kVar, long j4) {
        return (j) this.f6881j.get((int) (j4 - this.f6877d));
    }

    @Override // k2.n
    public final boolean i() {
        return true;
    }
}
