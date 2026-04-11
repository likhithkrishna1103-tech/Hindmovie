package a3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f196a = new byte[10];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f200e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f201g;

    public final void a(i0 i0Var, h0 h0Var) {
        if (this.f198c > 0) {
            i0Var.e(this.f199d, this.f200e, this.f, this.f201g, h0Var);
            this.f198c = 0;
        }
    }

    public final void b(i0 i0Var, long j4, int i, int i10, int i11, h0 h0Var) {
        y1.d.f("TrueHD chunk samples must be contiguous in the sample queue.", this.f201g <= i10 + i11);
        if (this.f197b) {
            int i12 = this.f198c;
            int i13 = i12 + 1;
            this.f198c = i13;
            if (i12 == 0) {
                this.f199d = j4;
                this.f200e = i;
                this.f = 0;
            }
            this.f += i10;
            this.f201g = i11;
            if (i13 >= 16) {
                a(i0Var, h0Var);
            }
        }
    }

    public final void c(q qVar) {
        if (this.f197b) {
            return;
        }
        byte[] bArr = this.f196a;
        qVar.z(bArr, 0, 10);
        qVar.k();
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b8 = bArr[7];
            if ((b8 & 254) == 186) {
                i = 40 << ((bArr[((b8 & 255) == 187 ? 1 : 0) != 0 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        if (i == 0) {
            return;
        }
        this.f197b = true;
    }
}
