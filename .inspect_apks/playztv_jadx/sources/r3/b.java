package r3;

import w2.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements g {
    public long A;
    public long B;
    public long C;
    public long D;
    public long E;
    public long F;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f f11363u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f11364v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f11365w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final i f11366x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f11367y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f11368z;

    public b(i iVar, long j5, long j8, long j10, long j11, boolean z2) {
        s1.d.b(j5 >= 0 && j8 > j5);
        this.f11366x = iVar;
        this.f11364v = j5;
        this.f11365w = j8;
        if (j10 == j8 - j5 || z2) {
            this.f11368z = j11;
            this.f11367y = 4;
        } else {
            this.f11367y = 0;
        }
        this.f11363u = new f();
    }

    @Override // r3.g
    public final b0 c() {
        if (this.f11368z != 0) {
            return new a(this);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c4  */
    @Override // r3.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long d(w2.p r28) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.b.d(w2.p):long");
    }

    @Override // r3.g
    public final void f(long j5) {
        this.B = s1.b0.j(j5, 0L, this.f11368z - 1);
        this.f11367y = 2;
        this.C = this.f11364v;
        this.D = this.f11365w;
        this.E = 0L;
        this.F = this.f11368z;
    }
}
