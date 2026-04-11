package u3;

import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f12205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f12207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f12208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12209e;
    public final long[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f12210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f12211h;

    public t(q qVar, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j4) {
        y1.d.b(iArr.length == jArr2.length);
        y1.d.b(jArr.length == jArr2.length);
        y1.d.b(iArr2.length == jArr2.length);
        this.f12205a = qVar;
        this.f12207c = jArr;
        this.f12208d = iArr;
        this.f12209e = i;
        this.f = jArr2;
        this.f12210g = iArr2;
        this.f12211h = j4;
        this.f12206b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public final int a(long j4) {
        long[] jArr = this.f;
        for (int iA = a0.a(jArr, j4, true); iA < jArr.length; iA++) {
            if ((this.f12210g[iA] & 1) != 0) {
                return iA;
            }
        }
        return -1;
    }
}
