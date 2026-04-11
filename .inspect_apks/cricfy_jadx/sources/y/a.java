package y;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f14508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l7.a f14509c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14507a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14510d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f14511e = new int[8];
    public int[] f = new int[8];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f14512g = new float[8];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14513h = -1;
    public int i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f14514j = false;

    public a(b bVar, l7.a aVar) {
        this.f14508b = bVar;
        this.f14509c = aVar;
    }

    public final void a(f fVar, float f, boolean z10) {
        if (f <= -0.001f || f >= 0.001f) {
            int i = this.f14513h;
            b bVar = this.f14508b;
            if (i == -1) {
                this.f14513h = 0;
                this.f14512g[0] = f;
                this.f14511e[0] = fVar.f14539w;
                this.f[0] = -1;
                fVar.F++;
                fVar.a(bVar);
                this.f14507a++;
                if (this.f14514j) {
                    return;
                }
                int i10 = this.i + 1;
                this.i = i10;
                int[] iArr = this.f14511e;
                if (i10 >= iArr.length) {
                    this.f14514j = true;
                    this.i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i11 = -1;
            for (int i12 = 0; i != -1 && i12 < this.f14507a; i12++) {
                int i13 = this.f14511e[i];
                int i14 = fVar.f14539w;
                if (i13 == i14) {
                    float[] fArr = this.f14512g;
                    float f10 = fArr[i] + f;
                    if (f10 > -0.001f && f10 < 0.001f) {
                        f10 = 0.0f;
                    }
                    fArr[i] = f10;
                    if (f10 == 0.0f) {
                        if (i == this.f14513h) {
                            this.f14513h = this.f[i];
                        } else {
                            int[] iArr2 = this.f;
                            iArr2[i11] = iArr2[i];
                        }
                        if (z10) {
                            fVar.b(bVar);
                        }
                        if (this.f14514j) {
                            this.i = i;
                        }
                        fVar.F--;
                        this.f14507a--;
                        return;
                    }
                    return;
                }
                if (i13 < i14) {
                    i11 = i;
                }
                i = this.f[i];
            }
            int length = this.i;
            int i15 = length + 1;
            if (this.f14514j) {
                int[] iArr3 = this.f14511e;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i15;
            }
            int[] iArr4 = this.f14511e;
            if (length >= iArr4.length && this.f14507a < iArr4.length) {
                int i16 = 0;
                while (true) {
                    int[] iArr5 = this.f14511e;
                    if (i16 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i16] == -1) {
                        length = i16;
                        break;
                    }
                    i16++;
                }
            }
            int[] iArr6 = this.f14511e;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i17 = this.f14510d * 2;
                this.f14510d = i17;
                this.f14514j = false;
                this.i = length - 1;
                this.f14512g = Arrays.copyOf(this.f14512g, i17);
                this.f14511e = Arrays.copyOf(this.f14511e, this.f14510d);
                this.f = Arrays.copyOf(this.f, this.f14510d);
            }
            this.f14511e[length] = fVar.f14539w;
            this.f14512g[length] = f;
            if (i11 != -1) {
                int[] iArr7 = this.f;
                iArr7[length] = iArr7[i11];
                iArr7[i11] = length;
            } else {
                this.f[length] = this.f14513h;
                this.f14513h = length;
            }
            fVar.F++;
            fVar.a(bVar);
            this.f14507a++;
            if (!this.f14514j) {
                this.i++;
            }
            int i18 = this.i;
            int[] iArr8 = this.f14511e;
            if (i18 >= iArr8.length) {
                this.f14514j = true;
                this.i = iArr8.length - 1;
            }
        }
    }

    public final void b() {
        int i = this.f14513h;
        for (int i10 = 0; i != -1 && i10 < this.f14507a; i10++) {
            f fVar = ((f[]) this.f14509c.f7868y)[this.f14511e[i]];
            if (fVar != null) {
                fVar.b(this.f14508b);
            }
            i = this.f[i];
        }
        this.f14513h = -1;
        this.i = -1;
        this.f14514j = false;
        this.f14507a = 0;
    }

    public final float c(f fVar) {
        int i = this.f14513h;
        for (int i10 = 0; i != -1 && i10 < this.f14507a; i10++) {
            if (this.f14511e[i] == fVar.f14539w) {
                return this.f14512g[i];
            }
            i = this.f[i];
        }
        return 0.0f;
    }

    public final int d() {
        return this.f14507a;
    }

    public final f e(int i) {
        int i10 = this.f14513h;
        for (int i11 = 0; i10 != -1 && i11 < this.f14507a; i11++) {
            if (i11 == i) {
                return ((f[]) this.f14509c.f7868y)[this.f14511e[i10]];
            }
            i10 = this.f[i10];
        }
        return null;
    }

    public final float f(int i) {
        int i10 = this.f14513h;
        for (int i11 = 0; i10 != -1 && i11 < this.f14507a; i11++) {
            if (i11 == i) {
                return this.f14512g[i10];
            }
            i10 = this.f[i10];
        }
        return 0.0f;
    }

    public final void g(f fVar, float f) {
        if (f == 0.0f) {
            h(fVar, true);
            return;
        }
        int i = this.f14513h;
        b bVar = this.f14508b;
        if (i == -1) {
            this.f14513h = 0;
            this.f14512g[0] = f;
            this.f14511e[0] = fVar.f14539w;
            this.f[0] = -1;
            fVar.F++;
            fVar.a(bVar);
            this.f14507a++;
            if (this.f14514j) {
                return;
            }
            int i10 = this.i + 1;
            this.i = i10;
            int[] iArr = this.f14511e;
            if (i10 >= iArr.length) {
                this.f14514j = true;
                this.i = iArr.length - 1;
                return;
            }
            return;
        }
        int i11 = -1;
        for (int i12 = 0; i != -1 && i12 < this.f14507a; i12++) {
            int i13 = this.f14511e[i];
            int i14 = fVar.f14539w;
            if (i13 == i14) {
                this.f14512g[i] = f;
                return;
            }
            if (i13 < i14) {
                i11 = i;
            }
            i = this.f[i];
        }
        int length = this.i;
        int i15 = length + 1;
        if (this.f14514j) {
            int[] iArr2 = this.f14511e;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i15;
        }
        int[] iArr3 = this.f14511e;
        if (length >= iArr3.length && this.f14507a < iArr3.length) {
            int i16 = 0;
            while (true) {
                int[] iArr4 = this.f14511e;
                if (i16 >= iArr4.length) {
                    break;
                }
                if (iArr4[i16] == -1) {
                    length = i16;
                    break;
                }
                i16++;
            }
        }
        int[] iArr5 = this.f14511e;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i17 = this.f14510d * 2;
            this.f14510d = i17;
            this.f14514j = false;
            this.i = length - 1;
            this.f14512g = Arrays.copyOf(this.f14512g, i17);
            this.f14511e = Arrays.copyOf(this.f14511e, this.f14510d);
            this.f = Arrays.copyOf(this.f, this.f14510d);
        }
        this.f14511e[length] = fVar.f14539w;
        this.f14512g[length] = f;
        if (i11 != -1) {
            int[] iArr6 = this.f;
            iArr6[length] = iArr6[i11];
            iArr6[i11] = length;
        } else {
            this.f[length] = this.f14513h;
            this.f14513h = length;
        }
        fVar.F++;
        fVar.a(bVar);
        int i18 = this.f14507a + 1;
        this.f14507a = i18;
        if (!this.f14514j) {
            this.i++;
        }
        int[] iArr7 = this.f14511e;
        if (i18 >= iArr7.length) {
            this.f14514j = true;
        }
        if (this.i >= iArr7.length) {
            this.f14514j = true;
            this.i = iArr7.length - 1;
        }
    }

    public final float h(f fVar, boolean z10) {
        int i = this.f14513h;
        if (i == -1) {
            return 0.0f;
        }
        int i10 = 0;
        int i11 = -1;
        while (i != -1 && i10 < this.f14507a) {
            if (this.f14511e[i] == fVar.f14539w) {
                if (i == this.f14513h) {
                    this.f14513h = this.f[i];
                } else {
                    int[] iArr = this.f;
                    iArr[i11] = iArr[i];
                }
                if (z10) {
                    fVar.b(this.f14508b);
                }
                fVar.F--;
                this.f14507a--;
                this.f14511e[i] = -1;
                if (this.f14514j) {
                    this.i = i;
                }
                return this.f14512g[i];
            }
            i10++;
            i11 = i;
            i = this.f[i];
        }
        return 0.0f;
    }

    public final String toString() {
        int i = this.f14513h;
        String string = "";
        for (int i10 = 0; i != -1 && i10 < this.f14507a; i10++) {
            StringBuilder sbB = e.b(l0.e.j(string, " -> "));
            sbB.append(this.f14512g[i]);
            sbB.append(" : ");
            StringBuilder sbB2 = e.b(sbB.toString());
            sbB2.append(((f[]) this.f14509c.f7868y)[this.f14511e[i]]);
            string = sbB2.toString();
            i = this.f[i];
        }
        return string;
    }
}
