package rf;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f11056b = new int[10];

    public final int a() {
        if ((this.f11055a & 16) != 0) {
            return this.f11056b[4];
        }
        return 65535;
    }

    public final void b(c0 c0Var) {
        ge.i.e(c0Var, "other");
        for (int i = 0; i < 10; i++) {
            if (((1 << i) & c0Var.f11055a) != 0) {
                c(i, c0Var.f11056b[i]);
            }
        }
    }

    public final void c(int i, int i10) {
        if (i >= 0) {
            int[] iArr = this.f11056b;
            if (i >= iArr.length) {
                return;
            }
            this.f11055a = (1 << i) | this.f11055a;
            iArr[i] = i10;
        }
    }
}
