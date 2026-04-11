package y;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f14520q = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f14524d;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final l7.a f14531m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f14534p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14521a = 1000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14522b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14523c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14525e = 32;
    public int f = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14527h = false;
    public boolean[] i = new boolean[32];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14528j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14529k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14530l = 32;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f[] f14532n = new f[1000];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14533o = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b[] f14526g = new b[32];

    public c() {
        s();
        l7.a aVar = new l7.a(26, false);
        aVar.f7866w = new s0.d();
        aVar.f7867x = new s0.d();
        aVar.f7868y = new f[32];
        this.f14531m = aVar;
        d dVar = new d(aVar);
        dVar.f = new f[128];
        dVar.f14535g = new f[128];
        dVar.f14536h = 0;
        dVar.i = new vb.b(6, dVar);
        this.f14524d = dVar;
        this.f14534p = new b(aVar);
    }

    public static int n(Object obj) {
        f fVar = ((a0.c) obj).i;
        if (fVar != null) {
            return (int) (fVar.f14542z + 0.5f);
        }
        return 0;
    }

    public final f a(int i) {
        s0.d dVar = (s0.d) this.f14531m.f7867x;
        int i10 = dVar.f11145w;
        Object obj = null;
        if (i10 > 0) {
            int i11 = i10 - 1;
            Object[] objArr = dVar.f11144v;
            Object obj2 = objArr[i11];
            objArr[i11] = null;
            dVar.f11145w = i11;
            obj = obj2;
        }
        f fVar = (f) obj;
        if (fVar == null) {
            fVar = new f(i);
            fVar.G = i;
        } else {
            fVar.c();
            fVar.G = i;
        }
        int i12 = this.f14533o;
        int i13 = this.f14521a;
        if (i12 >= i13) {
            int i14 = i13 * 2;
            this.f14521a = i14;
            this.f14532n = (f[]) Arrays.copyOf(this.f14532n, i14);
        }
        f[] fVarArr = this.f14532n;
        int i15 = this.f14533o;
        this.f14533o = i15 + 1;
        fVarArr[i15] = fVar;
        return fVar;
    }

    public final void b(f fVar, f fVar2, int i, float f, f fVar3, f fVar4, int i10, int i11) {
        b bVarL = l();
        if (fVar2 == fVar3) {
            bVarL.f14518d.g(fVar, 1.0f);
            bVarL.f14518d.g(fVar4, 1.0f);
            bVarL.f14518d.g(fVar2, -2.0f);
        } else if (f == 0.5f) {
            bVarL.f14518d.g(fVar, 1.0f);
            bVarL.f14518d.g(fVar2, -1.0f);
            bVarL.f14518d.g(fVar3, -1.0f);
            bVarL.f14518d.g(fVar4, 1.0f);
            if (i > 0 || i10 > 0) {
                bVarL.f14516b = (-i) + i10;
            }
        } else if (f <= 0.0f) {
            bVarL.f14518d.g(fVar, -1.0f);
            bVarL.f14518d.g(fVar2, 1.0f);
            bVarL.f14516b = i;
        } else if (f >= 1.0f) {
            bVarL.f14518d.g(fVar4, -1.0f);
            bVarL.f14518d.g(fVar3, 1.0f);
            bVarL.f14516b = -i10;
        } else {
            float f10 = 1.0f - f;
            bVarL.f14518d.g(fVar, f10 * 1.0f);
            bVarL.f14518d.g(fVar2, f10 * (-1.0f));
            bVarL.f14518d.g(fVar3, (-1.0f) * f);
            bVarL.f14518d.g(fVar4, 1.0f * f);
            if (i > 0 || i10 > 0) {
                bVarL.f14516b = (i10 * f) + ((-i) * f10);
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
    public final void c(y.b r18) {
        /*
            Method dump skipped, instruction units count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.c.c(y.b):void");
    }

    public final void d(f fVar, int i) {
        int i10 = fVar.f14540x;
        if (i10 == -1) {
            fVar.d(this, i);
            for (int i11 = 0; i11 < this.f14523c + 1; i11++) {
                f fVar2 = ((f[]) this.f14531m.f7868y)[i11];
            }
            return;
        }
        if (i10 == -1) {
            b bVarL = l();
            bVarL.f14515a = fVar;
            float f = i;
            fVar.f14542z = f;
            bVarL.f14516b = f;
            bVarL.f14519e = true;
            c(bVarL);
            return;
        }
        b bVar = this.f14526g[i10];
        if (bVar.f14519e) {
            bVar.f14516b = i;
            return;
        }
        if (bVar.f14518d.d() == 0) {
            bVar.f14519e = true;
            bVar.f14516b = i;
            return;
        }
        b bVarL2 = l();
        if (i < 0) {
            bVarL2.f14516b = i * (-1);
            bVarL2.f14518d.g(fVar, 1.0f);
        } else {
            bVarL2.f14516b = i;
            bVarL2.f14518d.g(fVar, -1.0f);
        }
        c(bVarL2);
    }

    public final void e(f fVar, f fVar2, int i, int i10) {
        if (i10 == 8 && fVar2.A && fVar.f14540x == -1) {
            fVar.d(this, fVar2.f14542z + i);
            return;
        }
        b bVarL = l();
        boolean z10 = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z10 = true;
            }
            bVarL.f14516b = i;
        }
        if (z10) {
            bVarL.f14518d.g(fVar, 1.0f);
            bVarL.f14518d.g(fVar2, -1.0f);
        } else {
            bVarL.f14518d.g(fVar, -1.0f);
            bVarL.f14518d.g(fVar2, 1.0f);
        }
        if (i10 != 8) {
            bVarL.a(this, i10);
        }
        c(bVarL);
    }

    public final void f(f fVar, f fVar2, int i, int i10) {
        b bVarL = l();
        f fVarM = m();
        fVarM.f14541y = 0;
        bVarL.b(fVar, fVar2, fVarM, i);
        if (i10 != 8) {
            bVarL.f14518d.g(j(i10), (int) (bVarL.f14518d.c(fVarM) * (-1.0f)));
        }
        c(bVarL);
    }

    public final void g(f fVar, f fVar2, int i, int i10) {
        b bVarL = l();
        f fVarM = m();
        fVarM.f14541y = 0;
        bVarL.c(fVar, fVar2, fVarM, i);
        if (i10 != 8) {
            bVarL.f14518d.g(j(i10), (int) (bVarL.f14518d.c(fVarM) * (-1.0f)));
        }
        c(bVarL);
    }

    public final void h(b bVar) {
        int i;
        if (bVar.f14519e) {
            bVar.f14515a.d(this, bVar.f14516b);
        } else {
            b[] bVarArr = this.f14526g;
            int i10 = this.f14529k;
            bVarArr[i10] = bVar;
            f fVar = bVar.f14515a;
            fVar.f14540x = i10;
            this.f14529k = i10 + 1;
            fVar.e(this, bVar);
        }
        if (this.f14522b) {
            int i11 = 0;
            while (i11 < this.f14529k) {
                if (this.f14526g[i11] == null) {
                    System.out.println("WTF");
                }
                b bVar2 = this.f14526g[i11];
                if (bVar2 != null && bVar2.f14519e) {
                    bVar2.f14515a.d(this, bVar2.f14516b);
                    ((s0.d) this.f14531m.f7866w).a(bVar2);
                    this.f14526g[i11] = null;
                    int i12 = i11 + 1;
                    int i13 = i12;
                    while (true) {
                        i = this.f14529k;
                        if (i12 >= i) {
                            break;
                        }
                        b[] bVarArr2 = this.f14526g;
                        int i14 = i12 - 1;
                        b bVar3 = bVarArr2[i12];
                        bVarArr2[i14] = bVar3;
                        f fVar2 = bVar3.f14515a;
                        if (fVar2.f14540x == i12) {
                            fVar2.f14540x = i14;
                        }
                        i13 = i12;
                        i12++;
                    }
                    if (i13 < i) {
                        this.f14526g[i13] = null;
                    }
                    this.f14529k = i - 1;
                    i11--;
                }
                i11++;
            }
            this.f14522b = false;
        }
    }

    public final void i() {
        for (int i = 0; i < this.f14529k; i++) {
            b bVar = this.f14526g[i];
            bVar.f14515a.f14542z = bVar.f14516b;
        }
    }

    public final f j(int i) {
        if (this.f14528j + 1 >= this.f) {
            o();
        }
        f fVarA = a(4);
        float[] fArr = fVarA.C;
        int i10 = this.f14523c + 1;
        this.f14523c = i10;
        this.f14528j++;
        fVarA.f14539w = i10;
        fVarA.f14541y = i;
        ((f[]) this.f14531m.f7868y)[i10] = fVarA;
        d dVar = this.f14524d;
        dVar.i.f13551w = fVarA;
        Arrays.fill(fArr, 0.0f);
        fArr[fVarA.f14541y] = 1.0f;
        dVar.j(fVarA);
        return fVarA;
    }

    public final f k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.f14528j + 1 >= this.f) {
            o();
        }
        if (!(obj instanceof a0.c)) {
            return null;
        }
        a0.c cVar = (a0.c) obj;
        f fVar = cVar.i;
        if (fVar == null) {
            cVar.k();
            fVar = cVar.i;
        }
        int i = fVar.f14539w;
        l7.a aVar = this.f14531m;
        if (i != -1 && i <= this.f14523c && ((f[]) aVar.f7868y)[i] != null) {
            return fVar;
        }
        if (i != -1) {
            fVar.c();
        }
        int i10 = this.f14523c + 1;
        this.f14523c = i10;
        this.f14528j++;
        fVar.f14539w = i10;
        fVar.G = 1;
        ((f[]) aVar.f7868y)[i10] = fVar;
        return fVar;
    }

    public final b l() {
        Object obj;
        l7.a aVar = this.f14531m;
        s0.d dVar = (s0.d) aVar.f7866w;
        int i = dVar.f11145w;
        if (i > 0) {
            int i10 = i - 1;
            Object[] objArr = dVar.f11144v;
            obj = objArr[i10];
            objArr[i10] = null;
            dVar.f11145w = i10;
        } else {
            obj = null;
        }
        b bVar = (b) obj;
        if (bVar == null) {
            return new b(aVar);
        }
        bVar.f14515a = null;
        bVar.f14518d.b();
        bVar.f14516b = 0.0f;
        bVar.f14519e = false;
        return bVar;
    }

    public final f m() {
        if (this.f14528j + 1 >= this.f) {
            o();
        }
        f fVarA = a(3);
        int i = this.f14523c + 1;
        this.f14523c = i;
        this.f14528j++;
        fVarA.f14539w = i;
        ((f[]) this.f14531m.f7868y)[i] = fVarA;
        return fVarA;
    }

    public final void o() {
        int i = this.f14525e * 2;
        this.f14525e = i;
        this.f14526g = (b[]) Arrays.copyOf(this.f14526g, i);
        l7.a aVar = this.f14531m;
        aVar.f7868y = (f[]) Arrays.copyOf((f[]) aVar.f7868y, this.f14525e);
        int i10 = this.f14525e;
        this.i = new boolean[i10];
        this.f = i10;
        this.f14530l = i10;
    }

    public final void p() {
        d dVar = this.f14524d;
        if (dVar.e()) {
            i();
            return;
        }
        if (!this.f14527h) {
            q(dVar);
            return;
        }
        for (int i = 0; i < this.f14529k; i++) {
            if (!this.f14526g[i].f14519e) {
                q(dVar);
                return;
            }
        }
        i();
    }

    public final void q(d dVar) {
        int i = 0;
        while (true) {
            if (i >= this.f14529k) {
                break;
            }
            b bVar = this.f14526g[i];
            int i10 = 1;
            if (bVar.f14515a.G != 1) {
                float f = 0.0f;
                if (bVar.f14516b < 0.0f) {
                    boolean z10 = false;
                    int i11 = 0;
                    while (!z10) {
                        i11 += i10;
                        float f10 = Float.MAX_VALUE;
                        int i12 = -1;
                        int i13 = -1;
                        int i14 = 0;
                        int i15 = 0;
                        while (i14 < this.f14529k) {
                            b bVar2 = this.f14526g[i14];
                            if (bVar2.f14515a.G != i10 && !bVar2.f14519e && bVar2.f14516b < f) {
                                int iD = bVar2.f14518d.d();
                                int i16 = 0;
                                while (i16 < iD) {
                                    f fVarE = bVar2.f14518d.e(i16);
                                    float fC = bVar2.f14518d.c(fVarE);
                                    if (fC > f) {
                                        for (int i17 = 0; i17 < 9; i17++) {
                                            float f11 = fVarE.B[i17] / fC;
                                            if ((f11 < f10 && i17 == i15) || i17 > i15) {
                                                i15 = i17;
                                                i13 = fVarE.f14539w;
                                                i12 = i14;
                                                f10 = f11;
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
                            b bVar3 = this.f14526g[i12];
                            bVar3.f14515a.f14540x = -1;
                            bVar3.g(((f[]) this.f14531m.f7868y)[i13]);
                            f fVar = bVar3.f14515a;
                            fVar.f14540x = i12;
                            fVar.e(this, bVar3);
                        } else {
                            z10 = true;
                        }
                        if (i11 > this.f14528j / 2) {
                            z10 = true;
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
    public final void r(y.b r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = 0
            r3 = r2
        L6:
            int r4 = r0.f14528j
            if (r3 >= r4) goto L11
            boolean[] r4 = r0.i
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
            int r6 = r0.f14528j
            int r6 = r6 * 2
            if (r4 < r6) goto L1f
            goto Lb0
        L1f:
            y.f r6 = r1.f14515a
            if (r6 == 0) goto L29
            boolean[] r7 = r0.i
            int r6 = r6.f14539w
            r7[r6] = r5
        L29:
            boolean[] r6 = r0.i
            y.f r6 = r1.d(r6)
            if (r6 == 0) goto L3d
            boolean[] r7 = r0.i
            int r8 = r6.f14539w
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
            int r11 = r0.f14529k
            if (r9 >= r11) goto L97
            y.b[] r11 = r0.f14526g
            r11 = r11[r9]
            y.f r12 = r11.f14515a
            int r12 = r12.G
            if (r12 != r5) goto L54
            goto L92
        L54:
            boolean r12 = r11.f14519e
            if (r12 == 0) goto L59
            goto L92
        L59:
            y.a r12 = r11.f14518d
            int r13 = r12.f14513h
            r15 = -1
            if (r13 != r15) goto L61
            goto L7a
        L61:
            r2 = 0
        L62:
            if (r13 == r15) goto L7a
            int r5 = r12.f14507a
            if (r2 >= r5) goto L7a
            int[] r5 = r12.f14511e
            r5 = r5[r13]
            int r14 = r6.f14539w
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
            y.a r2 = r11.f14518d
            float r2 = r2.c(r6)
            r5 = 0
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 >= 0) goto L92
            float r5 = r11.f14516b
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
            y.b[] r2 = r0.f14526g
            r2 = r2[r10]
            y.f r5 = r2.f14515a
            r5.f14540x = r7
            r2.g(r6)
            y.f r5 = r2.f14515a
            r5.f14540x = r10
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
        throw new UnsupportedOperationException("Method not decompiled: y.c.r(y.b):void");
    }

    public final void s() {
        for (int i = 0; i < this.f14529k; i++) {
            b bVar = this.f14526g[i];
            if (bVar != null) {
                ((s0.d) this.f14531m.f7866w).a(bVar);
            }
            this.f14526g[i] = null;
        }
    }

    public final void t() {
        l7.a aVar;
        int i = 0;
        while (true) {
            aVar = this.f14531m;
            f[] fVarArr = (f[]) aVar.f7868y;
            if (i >= fVarArr.length) {
                break;
            }
            f fVar = fVarArr[i];
            if (fVar != null) {
                fVar.c();
            }
            i++;
        }
        s0.d dVar = (s0.d) aVar.f7867x;
        f[] fVarArr2 = this.f14532n;
        int length = this.f14533o;
        dVar.getClass();
        if (length > fVarArr2.length) {
            length = fVarArr2.length;
        }
        for (int i10 = 0; i10 < length; i10++) {
            f fVar2 = fVarArr2[i10];
            int i11 = dVar.f11145w;
            Object[] objArr = dVar.f11144v;
            if (i11 < objArr.length) {
                objArr[i11] = fVar2;
                dVar.f11145w = i11 + 1;
            }
        }
        this.f14533o = 0;
        Arrays.fill((f[]) aVar.f7868y, (Object) null);
        this.f14523c = 0;
        d dVar2 = this.f14524d;
        dVar2.f14536h = 0;
        dVar2.f14516b = 0.0f;
        this.f14528j = 1;
        for (int i12 = 0; i12 < this.f14529k; i12++) {
            b bVar = this.f14526g[i12];
        }
        s();
        this.f14529k = 0;
        this.f14534p = new b(aVar);
    }
}
