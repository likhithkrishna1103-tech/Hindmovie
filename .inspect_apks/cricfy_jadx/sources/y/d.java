package y;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends b {
    public f[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f[] f14535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14536h;
    public vb.b i;

    @Override // y.b
    public final f d(boolean[] zArr) {
        int i = -1;
        for (int i10 = 0; i10 < this.f14536h; i10++) {
            f[] fVarArr = this.f;
            f fVar = fVarArr[i10];
            if (!zArr[fVar.f14539w]) {
                vb.b bVar = this.i;
                bVar.f13551w = fVar;
                int i11 = 8;
                if (i == -1) {
                    while (i11 >= 0) {
                        float f = ((f) bVar.f13551w).C[i11];
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
                            float f10 = fVar2.C[i11];
                            float f11 = ((f) bVar.f13551w).C[i11];
                            if (f11 == f10) {
                                i11--;
                            } else if (f11 < f10) {
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

    @Override // y.b
    public final boolean e() {
        return this.f14536h == 0;
    }

    @Override // y.b
    public final void i(c cVar, b bVar, boolean z10) {
        f fVar = bVar.f14515a;
        if (fVar == null) {
            return;
        }
        float[] fArr = fVar.C;
        a aVar = bVar.f14518d;
        int iD = aVar.d();
        for (int i = 0; i < iD; i++) {
            f fVarE = aVar.e(i);
            float f = aVar.f(i);
            vb.b bVar2 = this.i;
            bVar2.f13551w = fVarE;
            if (fVarE.f14538v) {
                boolean z11 = true;
                for (int i10 = 0; i10 < 9; i10++) {
                    float[] fArr2 = ((f) bVar2.f13551w).C;
                    float f10 = (fArr[i10] * f) + fArr2[i10];
                    fArr2[i10] = f10;
                    if (Math.abs(f10) < 1.0E-4f) {
                        ((f) bVar2.f13551w).C[i10] = 0.0f;
                    } else {
                        z11 = false;
                    }
                }
                if (z11) {
                    ((d) bVar2.f13552x).k((f) bVar2.f13551w);
                }
            } else {
                for (int i11 = 0; i11 < 9; i11++) {
                    float f11 = fArr[i11];
                    if (f11 != 0.0f) {
                        float f12 = f11 * f;
                        if (Math.abs(f12) < 1.0E-4f) {
                            f12 = 0.0f;
                        }
                        ((f) bVar2.f13551w).C[i11] = f12;
                    } else {
                        ((f) bVar2.f13551w).C[i11] = 0.0f;
                    }
                }
                j(fVarE);
            }
            this.f14516b = (bVar.f14516b * f) + this.f14516b;
        }
        k(fVar);
    }

    public final void j(f fVar) {
        int i;
        int i10 = this.f14536h + 1;
        f[] fVarArr = this.f;
        if (i10 > fVarArr.length) {
            f[] fVarArr2 = (f[]) Arrays.copyOf(fVarArr, fVarArr.length * 2);
            this.f = fVarArr2;
            this.f14535g = (f[]) Arrays.copyOf(fVarArr2, fVarArr2.length * 2);
        }
        f[] fVarArr3 = this.f;
        int i11 = this.f14536h;
        fVarArr3[i11] = fVar;
        int i12 = i11 + 1;
        this.f14536h = i12;
        if (i12 > 1 && fVarArr3[i11].f14539w > fVar.f14539w) {
            int i13 = 0;
            while (true) {
                i = this.f14536h;
                if (i13 >= i) {
                    break;
                }
                this.f14535g[i13] = this.f[i13];
                i13++;
            }
            Arrays.sort(this.f14535g, 0, i, new a5.f(9));
            for (int i14 = 0; i14 < this.f14536h; i14++) {
                this.f[i14] = this.f14535g[i14];
            }
        }
        fVar.f14538v = true;
        fVar.a(this);
    }

    public final void k(f fVar) {
        int i = 0;
        while (i < this.f14536h) {
            if (this.f[i] == fVar) {
                while (true) {
                    int i10 = this.f14536h;
                    if (i >= i10 - 1) {
                        this.f14536h = i10 - 1;
                        fVar.f14538v = false;
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

    @Override // y.b
    public final String toString() {
        vb.b bVar = this.i;
        String str = " goal -> (" + this.f14516b + ") : ";
        for (int i = 0; i < this.f14536h; i++) {
            bVar.f13551w = this.f[i];
            str = str + bVar + " ";
        }
        return str;
    }
}
