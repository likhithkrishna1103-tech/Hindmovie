package p2;

import p1.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class m extends f {
    public final long D;

    public m(v1.h hVar, v1.m mVar, q qVar, int i, Object obj, long j5, long j8, long j10) {
        super(hVar, mVar, 1, qVar, i, obj, j5, j8);
        qVar.getClass();
        this.D = j10;
    }

    public long a() {
        long j5 = this.D;
        if (j5 != -1) {
            return j5 + 1;
        }
        return -1L;
    }

    public abstract boolean d();
}
