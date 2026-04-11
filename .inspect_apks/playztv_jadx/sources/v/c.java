package v;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f13087p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f13088q = 1000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f13091c;
    public b[] f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final kc.b f13098l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b f13101o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13089a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13090b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13092d = 32;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13093e = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13094g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean[] f13095h = new boolean[32];
    public int i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13096j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13097k = 32;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f[] f13099m = new f[f13088q];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13100n = 0;

    public c() {
        this.f = null;
        this.f = new b[32];
        s();
        kc.b bVar = new kc.b(19);
        bVar.f7620v = new p0.d();
        bVar.f7621w = new p0.d();
        bVar.f7622x = new f[32];
        this.f13098l = bVar;
        d dVar = new d(bVar);
        dVar.f = new f[128];
        dVar.f13102g = new f[128];
        dVar.f13103h = 0;
        dVar.i = new p2.c(20, dVar);
        this.f13091c = dVar;
        this.f13101o = new b(bVar);
    }

    public static int n(Object obj) {
        f fVar = ((x.d) obj).i;
        if (fVar != null) {
            return (int) (fVar.f13109y + 0.5f);
        }
        return 0;
    }

    public final f a(int i) {
        p0.d dVar = (p0.d) this.f13098l.f7621w;
        int i10 = dVar.f9608v;
        Object obj = null;
        if (i10 > 0) {
            int i11 = i10 - 1;
            Object[] objArr = dVar.f9607u;
            Object obj2 = objArr[i11];
            objArr[i11] = null;
            dVar.f9608v = i11;
            obj = obj2;
        }
        f fVar = (f) obj;
        if (fVar == null) {
            fVar = new f(i);
            fVar.F = i;
        } else {
            fVar.c();
            fVar.F = i;
        }
        int i12 = this.f13100n;
        int i13 = f13088q;
        if (i12 >= i13) {
            int i14 = i13 * 2;
            f13088q = i14;
            this.f13099m = (f[]) Arrays.copyOf(this.f13099m, i14);
        }
        f[] fVarArr = this.f13099m;
        int i15 = this.f13100n;
        this.f13100n = i15 + 1;
        fVarArr[i15] = fVar;
        return fVar;
    }

    public final void b(f fVar, f fVar2, int i, float f, f fVar3, f fVar4, int i10, int i11) {
        b bVarL = l();
        if (fVar2 == fVar3) {
            bVarL.f13085d.g(fVar, 1.0f);
            bVarL.f13085d.g(fVar4, 1.0f);
            bVarL.f13085d.g(fVar2, -2.0f);
        } else if (f == 0.5f) {
            bVarL.f13085d.g(fVar, 1.0f);
            bVarL.f13085d.g(fVar2, -1.0f);
            bVarL.f13085d.g(fVar3, -1.0f);
            bVarL.f13085d.g(fVar4, 1.0f);
            if (i > 0 || i10 > 0) {
                bVarL.f13083b = (-i) + i10;
            }
        } else if (f <= 0.0f) {
            bVarL.f13085d.g(fVar, -1.0f);
            bVarL.f13085d.g(fVar2, 1.0f);
            bVarL.f13083b = i;
        } else if (f >= 1.0f) {
            bVarL.f13085d.g(fVar4, -1.0f);
            bVarL.f13085d.g(fVar3, 1.0f);
            bVarL.f13083b = -i10;
        } else {
            float f4 = 1.0f - f;
            bVarL.f13085d.g(fVar, f4 * 1.0f);
            bVarL.f13085d.g(fVar2, f4 * (-1.0f));
            bVarL.f13085d.g(fVar3, (-1.0f) * f);
            bVarL.f13085d.g(fVar4, 1.0f * f);
            if (i > 0 || i10 > 0) {
                bVarL.f13083b = (i10 * f) + ((-i) * f4);
            }
        }
        if (i11 != 8) {
            bVarL.a(this, i11);
        }
        c(bVarL);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(v.b r18) {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.c.c(v.b):void");
    }

    public final void d(f fVar, int i) {
        int i10 = fVar.f13107w;
        if (i10 == -1) {
            fVar.d(this, i);
            for (int i11 = 0; i11 < this.f13090b + 1; i11++) {
                f fVar2 = ((f[]) this.f13098l.f7622x)[i11];
            }
            return;
        }
        if (i10 == -1) {
            b bVarL = l();
            bVarL.f13082a = fVar;
            float f = i;
            fVar.f13109y = f;
            bVarL.f13083b = f;
            bVarL.f13086e = true;
            c(bVarL);
            return;
        }
        b bVar = this.f[i10];
        if (bVar.f13086e) {
            bVar.f13083b = i;
            return;
        }
        if (bVar.f13085d.d() == 0) {
            bVar.f13086e = true;
            bVar.f13083b = i;
            return;
        }
        b bVarL2 = l();
        if (i < 0) {
            bVarL2.f13083b = i * (-1);
            bVarL2.f13085d.g(fVar, 1.0f);
        } else {
            bVarL2.f13083b = i;
            bVarL2.f13085d.g(fVar, -1.0f);
        }
        c(bVarL2);
    }

    public final void e(f fVar, f fVar2, int i, int i10) {
        if (i10 == 8 && fVar2.f13110z && fVar.f13107w == -1) {
            fVar.d(this, fVar2.f13109y + i);
            return;
        }
        b bVarL = l();
        boolean z2 = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z2 = true;
            }
            bVarL.f13083b = i;
        }
        if (z2) {
            bVarL.f13085d.g(fVar, 1.0f);
            bVarL.f13085d.g(fVar2, -1.0f);
        } else {
            bVarL.f13085d.g(fVar, -1.0f);
            bVarL.f13085d.g(fVar2, 1.0f);
        }
        if (i10 != 8) {
            bVarL.a(this, i10);
        }
        c(bVarL);
    }

    public final void f(f fVar, f fVar2, int i, int i10) {
        b bVarL = l();
        f fVarM = m();
        fVarM.f13108x = 0;
        bVarL.b(fVar, fVar2, fVarM, i);
        if (i10 != 8) {
            bVarL.f13085d.g(j(i10), (int) (bVarL.f13085d.c(fVarM) * (-1.0f)));
        }
        c(bVarL);
    }

    public final void g(f fVar, f fVar2, int i, int i10) {
        b bVarL = l();
        f fVarM = m();
        fVarM.f13108x = 0;
        bVarL.c(fVar, fVar2, fVarM, i);
        if (i10 != 8) {
            bVarL.f13085d.g(j(i10), (int) (bVarL.f13085d.c(fVarM) * (-1.0f)));
        }
        c(bVarL);
    }

    public final void h(b bVar) {
        int i;
        if (bVar.f13086e) {
            bVar.f13082a.d(this, bVar.f13083b);
        } else {
            b[] bVarArr = this.f;
            int i10 = this.f13096j;
            bVarArr[i10] = bVar;
            f fVar = bVar.f13082a;
            fVar.f13107w = i10;
            this.f13096j = i10 + 1;
            fVar.e(this, bVar);
        }
        if (this.f13089a) {
            int i11 = 0;
            while (i11 < this.f13096j) {
                if (this.f[i11] == null) {
                    System.out.println("WTF");
                }
                b bVar2 = this.f[i11];
                if (bVar2 != null && bVar2.f13086e) {
                    bVar2.f13082a.d(this, bVar2.f13083b);
                    ((p0.d) this.f13098l.f7620v).a(bVar2);
                    this.f[i11] = null;
                    int i12 = i11 + 1;
                    int i13 = i12;
                    while (true) {
                        i = this.f13096j;
                        if (i12 >= i) {
                            break;
                        }
                        b[] bVarArr2 = this.f;
                        int i14 = i12 - 1;
                        b bVar3 = bVarArr2[i12];
                        bVarArr2[i14] = bVar3;
                        f fVar2 = bVar3.f13082a;
                        if (fVar2.f13107w == i12) {
                            fVar2.f13107w = i14;
                        }
                        i13 = i12;
                        i12++;
                    }
                    if (i13 < i) {
                        this.f[i13] = null;
                    }
                    this.f13096j = i - 1;
                    i11--;
                }
                i11++;
            }
            this.f13089a = false;
        }
    }

    public final void i() {
        for (int i = 0; i < this.f13096j; i++) {
            b bVar = this.f[i];
            bVar.f13082a.f13109y = bVar.f13083b;
        }
    }

    public final f j(int i) {
        if (this.i + 1 >= this.f13093e) {
            o();
        }
        f fVarA = a(4);
        float[] fArr = fVarA.B;
        int i10 = this.f13090b + 1;
        this.f13090b = i10;
        this.i++;
        fVarA.f13106v = i10;
        fVarA.f13108x = i;
        ((f[]) this.f13098l.f7622x)[i10] = fVarA;
        d dVar = this.f13091c;
        dVar.i.f10130v = fVarA;
        Arrays.fill(fArr, 0.0f);
        fArr[fVarA.f13108x] = 1.0f;
        dVar.j(fVarA);
        return fVarA;
    }

    public final f k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.i + 1 >= this.f13093e) {
            o();
        }
        if (!(obj instanceof x.d)) {
            return null;
        }
        x.d dVar = (x.d) obj;
        f fVar = dVar.i;
        if (fVar == null) {
            dVar.k();
            fVar = dVar.i;
        }
        int i = fVar.f13106v;
        kc.b bVar = this.f13098l;
        if (i != -1 && i <= this.f13090b && ((f[]) bVar.f7622x)[i] != null) {
            return fVar;
        }
        if (i != -1) {
            fVar.c();
        }
        int i10 = this.f13090b + 1;
        this.f13090b = i10;
        this.i++;
        fVar.f13106v = i10;
        fVar.F = 1;
        ((f[]) bVar.f7622x)[i10] = fVar;
        return fVar;
    }

    public final b l() {
        Object obj;
        kc.b bVar = this.f13098l;
        p0.d dVar = (p0.d) bVar.f7620v;
        int i = dVar.f9608v;
        if (i > 0) {
            int i10 = i - 1;
            Object[] objArr = dVar.f9607u;
            obj = objArr[i10];
            objArr[i10] = null;
            dVar.f9608v = i10;
        } else {
            obj = null;
        }
        b bVar2 = (b) obj;
        if (bVar2 == null) {
            return new b(bVar);
        }
        bVar2.f13082a = null;
        bVar2.f13085d.b();
        bVar2.f13083b = 0.0f;
        bVar2.f13086e = false;
        return bVar2;
    }

    public final f m() {
        if (this.i + 1 >= this.f13093e) {
            o();
        }
        f fVarA = a(3);
        int i = this.f13090b + 1;
        this.f13090b = i;
        this.i++;
        fVarA.f13106v = i;
        ((f[]) this.f13098l.f7622x)[i] = fVarA;
        return fVarA;
    }

    public final void o() {
        int i = this.f13092d * 2;
        this.f13092d = i;
        this.f = (b[]) Arrays.copyOf(this.f, i);
        kc.b bVar = this.f13098l;
        bVar.f7622x = (f[]) Arrays.copyOf((f[]) bVar.f7622x, this.f13092d);
        int i10 = this.f13092d;
        this.f13095h = new boolean[i10];
        this.f13093e = i10;
        this.f13097k = i10;
    }

    public final void p() {
        d dVar = this.f13091c;
        if (dVar.e()) {
            i();
            return;
        }
        if (!this.f13094g) {
            q(dVar);
            return;
        }
        for (int i = 0; i < this.f13096j; i++) {
            if (!this.f[i].f13086e) {
                q(dVar);
                return;
            }
        }
        i();
    }

    public final void q(d dVar) {
        int i = 0;
        while (true) {
            if (i >= this.f13096j) {
                break;
            }
            b bVar = this.f[i];
            int i10 = 1;
            if (bVar.f13082a.F != 1) {
                float f = 0.0f;
                if (bVar.f13083b < 0.0f) {
                    boolean z2 = false;
                    int i11 = 0;
                    while (!z2) {
                        i11 += i10;
                        float f4 = Float.MAX_VALUE;
                        int i12 = -1;
                        int i13 = -1;
                        int i14 = 0;
                        int i15 = 0;
                        while (i14 < this.f13096j) {
                            b bVar2 = this.f[i14];
                            if (bVar2.f13082a.F != i10 && !bVar2.f13086e && bVar2.f13083b < f) {
                                int iD = bVar2.f13085d.d();
                                int i16 = 0;
                                while (i16 < iD) {
                                    f fVarE = bVar2.f13085d.e(i16);
                                    float fC = bVar2.f13085d.c(fVarE);
                                    if (fC > f) {
                                        for (int i17 = 0; i17 < 9; i17++) {
                                            float f10 = fVarE.A[i17] / fC;
                                            if ((f10 < f4 && i17 == i15) || i17 > i15) {
                                                i15 = i17;
                                                i13 = fVarE.f13106v;
                                                i12 = i14;
                                                f4 = f10;
                                            }
                                        }
                                    }
                                    i16++;
                                    f = 0.0f;
                                }
                            }
                            i14++;
                            f = 0.0f;
                            i10 = 1;
                        }
                        if (i12 != -1) {
                            b bVar3 = this.f[i12];
                            bVar3.f13082a.f13107w = -1;
                            bVar3.g(((f[]) this.f13098l.f7622x)[i13]);
                            f fVar = bVar3.f13082a;
                            fVar.f13107w = i12;
                            fVar.e(this, bVar3);
                        } else {
                            z2 = true;
                        }
                        if (i11 > this.i / 2) {
                            z2 = true;
                        }
                        f = 0.0f;
                        i10 = 1;
                    }
                }
            }
            i++;
        }
        r(dVar);
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0092 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(v.b r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = 0
            r3 = r2
        L6:
            int r4 = r0.i
            if (r3 >= r4) goto L11
            boolean[] r4 = r0.f13095h
            r4[r3] = r2
            int r3 = r3 + 1
            goto L6
        L11:
            r3 = r2
            r4 = r3
        L13:
            if (r3 != 0) goto Lb0
            r5 = 1
            int r4 = r4 + r5
            int r6 = r0.i
            int r6 = r6 * 2
            if (r4 < r6) goto L1f
            goto Lb0
        L1f:
            v.f r6 = r1.f13082a
            if (r6 == 0) goto L29
            boolean[] r7 = r0.f13095h
            int r6 = r6.f13106v
            r7[r6] = r5
        L29:
            boolean[] r6 = r0.f13095h
            v.f r6 = r1.d(r6)
            if (r6 == 0) goto L3d
            boolean[] r7 = r0.f13095h
            int r8 = r6.f13106v
            boolean r9 = r7[r8]
            if (r9 == 0) goto L3b
            goto Lb0
        L3b:
            r7[r8] = r5
        L3d:
            if (r6 == 0) goto Lac
            r7 = -1
            r8 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r9 = r2
            r10 = r7
        L45:
            int r11 = r0.f13096j
            if (r9 >= r11) goto L97
            v.b[] r11 = r0.f
            r11 = r11[r9]
            v.f r12 = r11.f13082a
            int r12 = r12.F
            if (r12 != r5) goto L54
            goto L92
        L54:
            boolean r12 = r11.f13086e
            if (r12 == 0) goto L59
            goto L92
        L59:
            v.a r12 = r11.f13085d
            int r13 = r12.f13080h
            r15 = -1
            if (r13 != r15) goto L61
            goto L7a
        L61:
            r2 = 0
        L62:
            if (r13 == r15) goto L7a
            int r5 = r12.f13074a
            if (r2 >= r5) goto L7a
            int[] r5 = r12.f13078e
            r5 = r5[r13]
            int r14 = r6.f13106v
            if (r5 != r14) goto L72
            r14 = 1
            goto L7b
        L72:
            int[] r5 = r12.f
            r13 = r5[r13]
            int r2 = r2 + 1
            r5 = 1
            goto L62
        L7a:
            r14 = 0
        L7b:
            if (r14 == 0) goto L92
            v.a r2 = r11.f13085d
            float r2 = r2.c(r6)
            r5 = 0
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 >= 0) goto L92
            float r5 = r11.f13083b
            float r5 = -r5
            float r5 = r5 / r2
            int r2 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r2 >= 0) goto L92
            r8 = r5
            r10 = r9
        L92:
            int r9 = r9 + 1
            r2 = 0
            r5 = 1
            goto L45
        L97:
            if (r10 <= r7) goto Lad
            v.b[] r2 = r0.f
            r2 = r2[r10]
            v.f r5 = r2.f13082a
            r5.f13107w = r7
            r2.g(r6)
            v.f r5 = r2.f13082a
            r5.f13107w = r10
            r5.e(r0, r2)
            goto Lad
        Lac:
            r3 = 1
        Lad:
            r2 = 0
            goto L13
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v.c.r(v.b):void");
    }

    public final void s() {
        for (int i = 0; i < this.f13096j; i++) {
            b bVar = this.f[i];
            if (bVar != null) {
                ((p0.d) this.f13098l.f7620v).a(bVar);
            }
            this.f[i] = null;
        }
    }

    public final void t() {
        kc.b bVar;
        int i = 0;
        while (true) {
            bVar = this.f13098l;
            f[] fVarArr = (f[]) bVar.f7622x;
            if (i >= fVarArr.length) {
                break;
            }
            f fVar = fVarArr[i];
            if (fVar != null) {
                fVar.c();
            }
            i++;
        }
        p0.d dVar = (p0.d) bVar.f7621w;
        f[] fVarArr2 = this.f13099m;
        int length = this.f13100n;
        dVar.getClass();
        if (length > fVarArr2.length) {
            length = fVarArr2.length;
        }
        for (int i10 = 0; i10 < length; i10++) {
            f fVar2 = fVarArr2[i10];
            int i11 = dVar.f9608v;
            Object[] objArr = dVar.f9607u;
            if (i11 < objArr.length) {
                objArr[i11] = fVar2;
                dVar.f9608v = i11 + 1;
            }
        }
        this.f13100n = 0;
        Arrays.fill((f[]) bVar.f7622x, (Object) null);
        this.f13090b = 0;
        d dVar2 = this.f13091c;
        dVar2.f13103h = 0;
        dVar2.f13083b = 0.0f;
        this.i = 1;
        for (int i12 = 0; i12 < this.f13096j; i12++) {
            b bVar2 = this.f[i12];
        }
        s();
        this.f13096j = 0;
        this.f13101o = new b(bVar);
    }
}
