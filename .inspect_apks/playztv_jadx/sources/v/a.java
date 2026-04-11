package v;

import e6.j;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f13075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kc.b f13076c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13074a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13077d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f13078e = new int[8];
    public int[] f = new int[8];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f13079g = new float[8];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13080h = -1;
    public int i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13081j = false;

    public a(b bVar, kc.b bVar2) {
        this.f13075b = bVar;
        this.f13076c = bVar2;
    }

    public final void a(f fVar, float f, boolean z2) {
        if (f <= -0.001f || f >= 0.001f) {
            int i = this.f13080h;
            b bVar = this.f13075b;
            if (i == -1) {
                this.f13080h = 0;
                this.f13079g[0] = f;
                this.f13078e[0] = fVar.f13106v;
                this.f[0] = -1;
                fVar.E++;
                fVar.a(bVar);
                this.f13074a++;
                if (this.f13081j) {
                    return;
                }
                int i10 = this.i + 1;
                this.i = i10;
                int[] iArr = this.f13078e;
                if (i10 >= iArr.length) {
                    this.f13081j = true;
                    this.i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i11 = -1;
            for (int i12 = 0; i != -1 && i12 < this.f13074a; i12++) {
                int i13 = this.f13078e[i];
                int i14 = fVar.f13106v;
                if (i13 == i14) {
                    float[] fArr = this.f13079g;
                    float f4 = fArr[i] + f;
                    if (f4 > -0.001f && f4 < 0.001f) {
                        f4 = 0.0f;
                    }
                    fArr[i] = f4;
                    if (f4 == 0.0f) {
                        if (i == this.f13080h) {
                            this.f13080h = this.f[i];
                        } else {
                            int[] iArr2 = this.f;
                            iArr2[i11] = iArr2[i];
                        }
                        if (z2) {
                            fVar.b(bVar);
                        }
                        if (this.f13081j) {
                            this.i = i;
                        }
                        fVar.E--;
                        this.f13074a--;
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
            if (this.f13081j) {
                int[] iArr3 = this.f13078e;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i15;
            }
            int[] iArr4 = this.f13078e;
            if (length >= iArr4.length && this.f13074a < iArr4.length) {
                int i16 = 0;
                while (true) {
                    int[] iArr5 = this.f13078e;
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
            int[] iArr6 = this.f13078e;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i17 = this.f13077d * 2;
                this.f13077d = i17;
                this.f13081j = false;
                this.i = length - 1;
                this.f13079g = Arrays.copyOf(this.f13079g, i17);
                this.f13078e = Arrays.copyOf(this.f13078e, this.f13077d);
                this.f = Arrays.copyOf(this.f, this.f13077d);
            }
            this.f13078e[length] = fVar.f13106v;
            this.f13079g[length] = f;
            if (i11 != -1) {
                int[] iArr7 = this.f;
                iArr7[length] = iArr7[i11];
                iArr7[i11] = length;
            } else {
                this.f[length] = this.f13080h;
                this.f13080h = length;
            }
            fVar.E++;
            fVar.a(bVar);
            this.f13074a++;
            if (!this.f13081j) {
                this.i++;
            }
            int i18 = this.i;
            int[] iArr8 = this.f13078e;
            if (i18 >= iArr8.length) {
                this.f13081j = true;
                this.i = iArr8.length - 1;
            }
        }
    }

    public final void b() {
        int i = this.f13080h;
        for (int i10 = 0; i != -1 && i10 < this.f13074a; i10++) {
            f fVar = ((f[]) this.f13076c.f7622x)[this.f13078e[i]];
            if (fVar != null) {
                fVar.b(this.f13075b);
            }
            i = this.f[i];
        }
        this.f13080h = -1;
        this.i = -1;
        this.f13081j = false;
        this.f13074a = 0;
    }

    public final float c(f fVar) {
        int i = this.f13080h;
        for (int i10 = 0; i != -1 && i10 < this.f13074a; i10++) {
            if (this.f13078e[i] == fVar.f13106v) {
                return this.f13079g[i];
            }
            i = this.f[i];
        }
        return 0.0f;
    }

    public final int d() {
        return this.f13074a;
    }

    public final f e(int i) {
        int i10 = this.f13080h;
        for (int i11 = 0; i10 != -1 && i11 < this.f13074a; i11++) {
            if (i11 == i) {
                return ((f[]) this.f13076c.f7622x)[this.f13078e[i10]];
            }
            i10 = this.f[i10];
        }
        return null;
    }

    public final float f(int i) {
        int i10 = this.f13080h;
        for (int i11 = 0; i10 != -1 && i11 < this.f13074a; i11++) {
            if (i11 == i) {
                return this.f13079g[i10];
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
        int i = this.f13080h;
        b bVar = this.f13075b;
        if (i == -1) {
            this.f13080h = 0;
            this.f13079g[0] = f;
            this.f13078e[0] = fVar.f13106v;
            this.f[0] = -1;
            fVar.E++;
            fVar.a(bVar);
            this.f13074a++;
            if (this.f13081j) {
                return;
            }
            int i10 = this.i + 1;
            this.i = i10;
            int[] iArr = this.f13078e;
            if (i10 >= iArr.length) {
                this.f13081j = true;
                this.i = iArr.length - 1;
                return;
            }
            return;
        }
        int i11 = -1;
        for (int i12 = 0; i != -1 && i12 < this.f13074a; i12++) {
            int i13 = this.f13078e[i];
            int i14 = fVar.f13106v;
            if (i13 == i14) {
                this.f13079g[i] = f;
                return;
            }
            if (i13 < i14) {
                i11 = i;
            }
            i = this.f[i];
        }
        int length = this.i;
        int i15 = length + 1;
        if (this.f13081j) {
            int[] iArr2 = this.f13078e;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i15;
        }
        int[] iArr3 = this.f13078e;
        if (length >= iArr3.length && this.f13074a < iArr3.length) {
            int i16 = 0;
            while (true) {
                int[] iArr4 = this.f13078e;
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
        int[] iArr5 = this.f13078e;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i17 = this.f13077d * 2;
            this.f13077d = i17;
            this.f13081j = false;
            this.i = length - 1;
            this.f13079g = Arrays.copyOf(this.f13079g, i17);
            this.f13078e = Arrays.copyOf(this.f13078e, this.f13077d);
            this.f = Arrays.copyOf(this.f, this.f13077d);
        }
        this.f13078e[length] = fVar.f13106v;
        this.f13079g[length] = f;
        if (i11 != -1) {
            int[] iArr6 = this.f;
            iArr6[length] = iArr6[i11];
            iArr6[i11] = length;
        } else {
            this.f[length] = this.f13080h;
            this.f13080h = length;
        }
        fVar.E++;
        fVar.a(bVar);
        int i18 = this.f13074a + 1;
        this.f13074a = i18;
        if (!this.f13081j) {
            this.i++;
        }
        int[] iArr7 = this.f13078e;
        if (i18 >= iArr7.length) {
            this.f13081j = true;
        }
        if (this.i >= iArr7.length) {
            this.f13081j = true;
            this.i = iArr7.length - 1;
        }
    }

    public final float h(f fVar, boolean z2) {
        int i = this.f13080h;
        if (i == -1) {
            return 0.0f;
        }
        int i10 = 0;
        int i11 = -1;
        while (i != -1 && i10 < this.f13074a) {
            if (this.f13078e[i] == fVar.f13106v) {
                if (i == this.f13080h) {
                    this.f13080h = this.f[i];
                } else {
                    int[] iArr = this.f;
                    iArr[i11] = iArr[i];
                }
                if (z2) {
                    fVar.b(this.f13075b);
                }
                fVar.E--;
                this.f13074a--;
                this.f13078e[i] = -1;
                if (this.f13081j) {
                    this.i = i;
                }
                return this.f13079g[i];
            }
            i10++;
            i11 = i;
            i = this.f[i];
        }
        return 0.0f;
    }

    public final String toString() {
        int i = this.f13080h;
        String string = "";
        for (int i10 = 0; i != -1 && i10 < this.f13074a; i10++) {
            StringBuilder sbB = e.b(j.m(string, " -> "));
            sbB.append(this.f13079g[i]);
            sbB.append(" : ");
            StringBuilder sbB2 = e.b(sbB.toString());
            sbB2.append(((f[]) this.f13076c.f7622x)[this.f13078e[i]]);
            string = sbB2.toString();
            i = this.f[i];
        }
        return string;
    }
}
