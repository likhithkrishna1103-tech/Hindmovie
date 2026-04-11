package hf;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f6143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6147e;
    public r f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r f6148g;

    public r() {
        this.f6143a = new byte[8192];
        this.f6147e = true;
        this.f6146d = false;
    }

    public final r a() {
        r rVar = this.f;
        if (rVar == this) {
            rVar = null;
        }
        r rVar2 = this.f6148g;
        be.h.b(rVar2);
        rVar2.f = this.f;
        r rVar3 = this.f;
        be.h.b(rVar3);
        rVar3.f6148g = this.f6148g;
        this.f = null;
        this.f6148g = null;
        return rVar;
    }

    public final void b(r rVar) {
        be.h.e(rVar, "segment");
        rVar.f6148g = this;
        rVar.f = this.f;
        r rVar2 = this.f;
        be.h.b(rVar2);
        rVar2.f6148g = rVar;
        this.f = rVar;
    }

    public final r c() {
        this.f6146d = true;
        return new r(this.f6143a, this.f6144b, this.f6145c, true);
    }

    public final void d(r rVar, int i) {
        be.h.e(rVar, "sink");
        byte[] bArr = rVar.f6143a;
        if (!rVar.f6147e) {
            throw new IllegalStateException("only owner can write");
        }
        int i10 = rVar.f6145c;
        int i11 = i10 + i;
        if (i11 > 8192) {
            if (rVar.f6146d) {
                throw new IllegalArgumentException();
            }
            int i12 = rVar.f6144b;
            if (i11 - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            od.h.R(0, i12, i10, bArr, bArr);
            rVar.f6145c -= rVar.f6144b;
            rVar.f6144b = 0;
        }
        int i13 = rVar.f6145c;
        int i14 = this.f6144b;
        od.h.R(i13, i14, i14 + i, this.f6143a, bArr);
        rVar.f6145c += i;
        this.f6144b += i;
    }

    public r(byte[] bArr, int i, int i10, boolean z2) {
        be.h.e(bArr, "data");
        this.f6143a = bArr;
        this.f6144b = i;
        this.f6145c = i10;
        this.f6146d = z2;
        this.f6147e = false;
    }
}
