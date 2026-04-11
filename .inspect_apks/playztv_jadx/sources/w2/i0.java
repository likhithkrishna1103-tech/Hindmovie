package w2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f13639a = new byte[10];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13643e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13644g;

    public final void a(h0 h0Var, g0 g0Var) {
        if (this.f13641c > 0) {
            h0Var.a(this.f13642d, this.f13643e, this.f, this.f13644g, g0Var);
            this.f13641c = 0;
        }
    }

    public final void b(h0 h0Var, long j5, int i, int i10, int i11, g0 g0Var) {
        s1.d.f("TrueHD chunk samples must be contiguous in the sample queue.", this.f13644g <= i10 + i11);
        if (this.f13640b) {
            int i12 = this.f13641c;
            int i13 = i12 + 1;
            this.f13641c = i13;
            if (i12 == 0) {
                this.f13642d = j5;
                this.f13643e = i;
                this.f = 0;
            }
            this.f += i10;
            this.f13644g = i11;
            if (i13 >= 16) {
                a(h0Var, g0Var);
            }
        }
    }

    public final void c(p pVar) {
        if (this.f13640b) {
            return;
        }
        byte[] bArr = this.f13639a;
        pVar.w(bArr, 0, 10);
        pVar.l();
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b10 = bArr[7];
            if ((b10 & 254) == 186) {
                i = 40 << ((bArr[((b10 & 255) == 187 ? 1 : 0) != 0 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        if (i == 0) {
            return;
        }
        this.f13640b = true;
    }
}
