package v;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Comparable {
    public int F;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f13105u;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f13109y;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13106v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13107w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f13108x = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f13110z = false;
    public final float[] A = new float[9];
    public final float[] B = new float[9];
    public b[] C = new b[16];
    public int D = 0;
    public int E = 0;

    public f(int i) {
        this.F = i;
    }

    public final void a(b bVar) {
        int i = 0;
        while (true) {
            int i10 = this.D;
            if (i >= i10) {
                b[] bVarArr = this.C;
                if (i10 >= bVarArr.length) {
                    this.C = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.C;
                int i11 = this.D;
                bVarArr2[i11] = bVar;
                this.D = i11 + 1;
                return;
            }
            if (this.C[i] == bVar) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void b(b bVar) {
        int i = this.D;
        int i10 = 0;
        while (i10 < i) {
            if (this.C[i10] == bVar) {
                while (i10 < i - 1) {
                    b[] bVarArr = this.C;
                    int i11 = i10 + 1;
                    bVarArr[i10] = bVarArr[i11];
                    i10 = i11;
                }
                this.D--;
                return;
            }
            i10++;
        }
    }

    public final void c() {
        this.F = 5;
        this.f13108x = 0;
        this.f13106v = -1;
        this.f13107w = -1;
        this.f13109y = 0.0f;
        this.f13110z = false;
        int i = this.D;
        for (int i10 = 0; i10 < i; i10++) {
            this.C[i10] = null;
        }
        this.D = 0;
        this.E = 0;
        this.f13105u = false;
        Arrays.fill(this.B, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f13106v - ((f) obj).f13106v;
    }

    public final void d(c cVar, float f) {
        this.f13109y = f;
        this.f13110z = true;
        int i = this.D;
        this.f13107w = -1;
        for (int i10 = 0; i10 < i; i10++) {
            this.C[i10].h(cVar, this, false);
        }
        this.D = 0;
    }

    public final void e(c cVar, b bVar) {
        int i = this.D;
        for (int i10 = 0; i10 < i; i10++) {
            this.C[i10].i(cVar, bVar, false);
        }
        this.D = 0;
    }

    public final String toString() {
        return "" + this.f13106v;
    }
}
