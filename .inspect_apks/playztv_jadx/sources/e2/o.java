package e2;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends n {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f4352j;

    public o(j jVar, long j5, long j8, long j10, long j11, List list, long j12, List list2, long j13, long j14) {
        super(jVar, j5, j8, j10, j11, list, j12, j13, j14);
        this.f4352j = list2;
    }

    @Override // e2.n
    public final long d(long j5) {
        return this.f4352j.size();
    }

    @Override // e2.n
    public final j h(k kVar, long j5) {
        return (j) this.f4352j.get((int) (j5 - this.f4348d));
    }

    @Override // e2.n
    public final boolean i() {
        return true;
    }
}
