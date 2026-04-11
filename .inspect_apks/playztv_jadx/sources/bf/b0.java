package bf;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f2056b = new int[10];

    public final int a() {
        if ((this.f2055a & 128) != 0) {
            return this.f2056b[7];
        }
        return 65535;
    }

    public final void b(b0 b0Var) {
        be.h.e(b0Var, "other");
        for (int i = 0; i < 10; i++) {
            if (((1 << i) & b0Var.f2055a) != 0) {
                c(i, b0Var.f2056b[i]);
            }
        }
    }

    public final void c(int i, int i10) {
        if (i >= 0) {
            int[] iArr = this.f2056b;
            if (i >= iArr.length) {
                return;
            }
            this.f2055a = (1 << i) | this.f2055a;
            iArr[i] = i10;
        }
    }
}
