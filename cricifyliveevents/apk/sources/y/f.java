package y;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Comparable {
    public int G;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f14538v;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f14542z;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f14539w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f14540x = -1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14541y = 0;
    public boolean A = false;
    public final float[] B = new float[9];
    public final float[] C = new float[9];
    public b[] D = new b[16];
    public int E = 0;
    public int F = 0;

    public f(int i) {
        this.G = i;
    }

    public final void a(b bVar) {
        int i = 0;
        while (true) {
            int i10 = this.E;
            if (i >= i10) {
                b[] bVarArr = this.D;
                if (i10 >= bVarArr.length) {
                    this.D = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.D;
                int i11 = this.E;
                bVarArr2[i11] = bVar;
                this.E = i11 + 1;
                return;
            }
            if (this.D[i] == bVar) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void b(b bVar) {
        int i = this.E;
        int i10 = 0;
        while (i10 < i) {
            if (this.D[i10] == bVar) {
                while (i10 < i - 1) {
                    b[] bVarArr = this.D;
                    int i11 = i10 + 1;
                    bVarArr[i10] = bVarArr[i11];
                    i10 = i11;
                }
                this.E--;
                return;
            }
            i10++;
        }
    }

    public final void c() {
        this.G = 5;
        this.f14541y = 0;
        this.f14539w = -1;
        this.f14540x = -1;
        this.f14542z = 0.0f;
        this.A = false;
        int i = this.E;
        for (int i10 = 0; i10 < i; i10++) {
            this.D[i10] = null;
        }
        this.E = 0;
        this.F = 0;
        this.f14538v = false;
        Arrays.fill(this.C, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f14539w - ((f) obj).f14539w;
    }

    public final void d(c cVar, float f) {
        this.f14542z = f;
        this.A = true;
        int i = this.E;
        this.f14540x = -1;
        for (int i10 = 0; i10 < i; i10++) {
            this.D[i10].h(cVar, this, false);
        }
        this.E = 0;
    }

    public final void e(c cVar, b bVar) {
        int i = this.E;
        for (int i10 = 0; i10 < i; i10++) {
            this.D[i10].i(cVar, bVar, false);
        }
        this.E = 0;
    }

    public final String toString() {
        return "" + this.f14539w;
    }
}
