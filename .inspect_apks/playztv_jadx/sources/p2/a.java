package p2;

import p1.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends m {
    public final long E;
    public final long F;
    public c G;
    public int[] H;

    public a(v1.h hVar, v1.m mVar, q qVar, int i, Object obj, long j5, long j8, long j10, long j11, long j12) {
        super(hVar, mVar, qVar, i, obj, j5, j8, j12);
        this.E = j10;
        this.F = j11;
    }

    public final int e(int i) {
        int[] iArr = this.H;
        s1.d.h(iArr);
        return iArr[i];
    }
}
