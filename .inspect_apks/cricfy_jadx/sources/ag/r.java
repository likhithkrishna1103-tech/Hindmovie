package ag;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f466e;
    public r f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r f467g;

    public r() {
        this.f462a = new byte[8192];
        this.f466e = true;
        this.f465d = false;
    }

    public final r a() {
        r rVar = this.f;
        if (rVar == this) {
            rVar = null;
        }
        r rVar2 = this.f467g;
        ge.i.b(rVar2);
        rVar2.f = this.f;
        r rVar3 = this.f;
        ge.i.b(rVar3);
        rVar3.f467g = this.f467g;
        this.f = null;
        this.f467g = null;
        return rVar;
    }

    public final void b(r rVar) {
        ge.i.e(rVar, "segment");
        rVar.f467g = this;
        rVar.f = this.f;
        r rVar2 = this.f;
        ge.i.b(rVar2);
        rVar2.f467g = rVar;
        this.f = rVar;
    }

    public final r c() {
        this.f465d = true;
        return new r(this.f462a, this.f463b, this.f464c, true);
    }

    public final void d(r rVar, int i) {
        ge.i.e(rVar, "sink");
        byte[] bArr = rVar.f462a;
        if (!rVar.f466e) {
            throw new IllegalStateException("only owner can write");
        }
        int i10 = rVar.f464c;
        int i11 = i10 + i;
        if (i11 > 8192) {
            if (rVar.f465d) {
                throw new IllegalArgumentException();
            }
            int i12 = rVar.f463b;
            if (i11 - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            sd.i.f(0, i12, i10, bArr, bArr);
            rVar.f464c -= rVar.f463b;
            rVar.f463b = 0;
        }
        int i13 = rVar.f464c;
        int i14 = this.f463b;
        sd.i.f(i13, i14, i14 + i, this.f462a, bArr);
        rVar.f464c += i;
        this.f463b += i;
    }

    public r(byte[] bArr, int i, int i10, boolean z10) {
        ge.i.e(bArr, "data");
        this.f462a = bArr;
        this.f463b = i;
        this.f464c = i10;
        this.f465d = z10;
        this.f466e = false;
    }
}
