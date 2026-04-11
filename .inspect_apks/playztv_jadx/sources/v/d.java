package v;

import c0.i;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends b {
    public f[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f[] f13102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13103h;
    public p2.c i;

    @Override // v.b
    public final f d(boolean[] zArr) {
        int i = -1;
        for (int i10 = 0; i10 < this.f13103h; i10++) {
            f[] fVarArr = this.f;
            f fVar = fVarArr[i10];
            if (!zArr[fVar.f13106v]) {
                p2.c cVar = this.i;
                cVar.f10130v = fVar;
                int i11 = 8;
                if (i == -1) {
                    while (i11 >= 0) {
                        float f = ((f) cVar.f10130v).B[i11];
                        if (f <= 0.0f) {
                            if (f < 0.0f) {
                                i = i10;
                                break;
                            }
                            i11--;
                        }
                    }
                } else {
                    f fVar2 = fVarArr[i];
                    while (true) {
                        if (i11 >= 0) {
                            float f4 = fVar2.B[i11];
                            float f10 = ((f) cVar.f10130v).B[i11];
                            if (f10 == f4) {
                                i11--;
                            } else if (f10 < f4) {
                            }
                        }
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.f[i];
    }

    @Override // v.b
    public final boolean e() {
        return this.f13103h == 0;
    }

    @Override // v.b
    public final void i(c cVar, b bVar, boolean z2) {
        f fVar = bVar.f13082a;
        if (fVar == null) {
            return;
        }
        float[] fArr = fVar.B;
        a aVar = bVar.f13085d;
        int iD = aVar.d();
        for (int i = 0; i < iD; i++) {
            f fVarE = aVar.e(i);
            float f = aVar.f(i);
            p2.c cVar2 = this.i;
            cVar2.f10130v = fVarE;
            if (fVarE.f13105u) {
                boolean z10 = true;
                for (int i10 = 0; i10 < 9; i10++) {
                    float[] fArr2 = ((f) cVar2.f10130v).B;
                    float f4 = (fArr[i10] * f) + fArr2[i10];
                    fArr2[i10] = f4;
                    if (Math.abs(f4) < 1.0E-4f) {
                        ((f) cVar2.f10130v).B[i10] = 0.0f;
                    } else {
                        z10 = false;
                    }
                }
                if (z10) {
                    ((d) cVar2.f10131w).k((f) cVar2.f10130v);
                }
            } else {
                for (int i11 = 0; i11 < 9; i11++) {
                    float f10 = fArr[i11];
                    if (f10 != 0.0f) {
                        float f11 = f10 * f;
                        if (Math.abs(f11) < 1.0E-4f) {
                            f11 = 0.0f;
                        }
                        ((f) cVar2.f10130v).B[i11] = f11;
                    } else {
                        ((f) cVar2.f10130v).B[i11] = 0.0f;
                    }
                }
                j(fVarE);
            }
            this.f13083b = (bVar.f13083b * f) + this.f13083b;
        }
        k(fVar);
    }

    public final void j(f fVar) {
        int i;
        int i10 = this.f13103h + 1;
        f[] fVarArr = this.f;
        if (i10 > fVarArr.length) {
            f[] fVarArr2 = (f[]) Arrays.copyOf(fVarArr, fVarArr.length * 2);
            this.f = fVarArr2;
            this.f13102g = (f[]) Arrays.copyOf(fVarArr2, fVarArr2.length * 2);
        }
        f[] fVarArr3 = this.f;
        int i11 = this.f13103h;
        fVarArr3[i11] = fVar;
        int i12 = i11 + 1;
        this.f13103h = i12;
        if (i12 > 1 && fVarArr3[i11].f13106v > fVar.f13106v) {
            int i13 = 0;
            while (true) {
                i = this.f13103h;
                if (i13 >= i) {
                    break;
                }
                this.f13102g[i13] = this.f[i13];
                i13++;
            }
            Arrays.sort(this.f13102g, 0, i, new i(5));
            for (int i14 = 0; i14 < this.f13103h; i14++) {
                this.f[i14] = this.f13102g[i14];
            }
        }
        fVar.f13105u = true;
        fVar.a(this);
    }

    public final void k(f fVar) {
        int i = 0;
        while (i < this.f13103h) {
            if (this.f[i] == fVar) {
                while (true) {
                    int i10 = this.f13103h;
                    if (i >= i10 - 1) {
                        this.f13103h = i10 - 1;
                        fVar.f13105u = false;
                        return;
                    } else {
                        f[] fVarArr = this.f;
                        int i11 = i + 1;
                        fVarArr[i] = fVarArr[i11];
                        i = i11;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // v.b
    public final String toString() {
        p2.c cVar = this.i;
        String str = " goal -> (" + this.f13083b + ") : ";
        for (int i = 0; i < this.f13103h; i++) {
            cVar.f10130v = this.f[i];
            str = str + cVar + " ";
        }
        return str;
    }
}
