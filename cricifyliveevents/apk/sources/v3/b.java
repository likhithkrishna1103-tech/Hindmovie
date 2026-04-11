package v3;

import a3.c0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements g {
    public long A;
    public long B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f13134v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f13135w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f13136x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final i f13137y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13138z;

    public b(i iVar, long j4, long j7, long j10, long j11, boolean z10) {
        y1.d.b(j4 >= 0 && j7 > j4);
        this.f13137y = iVar;
        this.f13135w = j4;
        this.f13136x = j7;
        if (j10 == j7 - j4 || z10) {
            this.A = j11;
            this.f13138z = 4;
        } else {
            this.f13138z = 0;
        }
        this.f13134v = new f();
    }

    @Override // v3.g
    public final c0 b() {
        if (this.A != 0) {
            return new a(this);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c4  */
    @Override // v3.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long c(a3.q r28) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.b.c(a3.q):long");
    }

    @Override // v3.g
    public final void d(long j4) {
        this.C = a0.j(j4, 0L, this.A - 1);
        this.f13138z = 2;
        this.D = this.f13135w;
        this.E = this.f13136x;
        this.F = 0L;
        this.G = this.A;
    }
}
