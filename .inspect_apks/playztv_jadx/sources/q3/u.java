package q3;

import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f10730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f10732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f10733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f10734e;
    public final long[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f10735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f10736h;

    public u(r rVar, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j5) {
        s1.d.b(iArr.length == jArr2.length);
        s1.d.b(jArr.length == jArr2.length);
        s1.d.b(iArr2.length == jArr2.length);
        this.f10730a = rVar;
        this.f10732c = jArr;
        this.f10733d = iArr;
        this.f10734e = i;
        this.f = jArr2;
        this.f10735g = iArr2;
        this.f10736h = j5;
        this.f10731b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public final int a(long j5) {
        long[] jArr = this.f;
        for (int iA = b0.a(jArr, j5, true); iA < jArr.length; iA++) {
            if ((this.f10735g[iA] & 1) != 0) {
                return iA;
            }
        }
        return -1;
    }
}
