package y;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f14518d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f14515a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f14516b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f14517c = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14519e = false;

    public b(l7.a aVar) {
        this.f14518d = new a(this, aVar);
    }

    public final void a(c cVar, int i) {
        this.f14518d.g(cVar.j(i), 1.0f);
        this.f14518d.g(cVar.j(i), -1.0f);
    }

    public final void b(f fVar, f fVar2, f fVar3, int i) {
        boolean z10 = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z10 = true;
            }
            this.f14516b = i;
        }
        if (z10) {
            this.f14518d.g(fVar, 1.0f);
            this.f14518d.g(fVar2, -1.0f);
            this.f14518d.g(fVar3, -1.0f);
        } else {
            this.f14518d.g(fVar, -1.0f);
            this.f14518d.g(fVar2, 1.0f);
            this.f14518d.g(fVar3, 1.0f);
        }
    }

    public final void c(f fVar, f fVar2, f fVar3, int i) {
        boolean z10 = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z10 = true;
            }
            this.f14516b = i;
        }
        if (z10) {
            this.f14518d.g(fVar, 1.0f);
            this.f14518d.g(fVar2, -1.0f);
            this.f14518d.g(fVar3, 1.0f);
        } else {
            this.f14518d.g(fVar, -1.0f);
            this.f14518d.g(fVar2, 1.0f);
            this.f14518d.g(fVar3, -1.0f);
        }
    }

    public f d(boolean[] zArr) {
        return f(zArr, null);
    }

    public boolean e() {
        return this.f14515a == null && this.f14516b == 0.0f && this.f14518d.d() == 0;
    }

    public final f f(boolean[] zArr, f fVar) {
        int i;
        int iD = this.f14518d.d();
        f fVar2 = null;
        float f = 0.0f;
        for (int i10 = 0; i10 < iD; i10++) {
            float f10 = this.f14518d.f(i10);
            if (f10 < 0.0f) {
                f fVarE = this.f14518d.e(i10);
                if ((zArr == null || !zArr[fVarE.f14539w]) && fVarE != fVar && (((i = fVarE.G) == 3 || i == 4) && f10 < f)) {
                    f = f10;
                    fVar2 = fVarE;
                }
            }
        }
        return fVar2;
    }

    public final void g(f fVar) {
        f fVar2 = this.f14515a;
        if (fVar2 != null) {
            this.f14518d.g(fVar2, -1.0f);
            this.f14515a.f14540x = -1;
            this.f14515a = null;
        }
        float fH = this.f14518d.h(fVar, true) * (-1.0f);
        this.f14515a = fVar;
        if (fH == 1.0f) {
            return;
        }
        this.f14516b /= fH;
        a aVar = this.f14518d;
        int i = aVar.f14513h;
        for (int i10 = 0; i != -1 && i10 < aVar.f14507a; i10++) {
            float[] fArr = aVar.f14512g;
            fArr[i] = fArr[i] / fH;
            i = aVar.f[i];
        }
    }

    public final void h(c cVar, f fVar, boolean z10) {
        if (fVar.A) {
            float fC = this.f14518d.c(fVar);
            this.f14516b = (fVar.f14542z * fC) + this.f14516b;
            this.f14518d.h(fVar, z10);
            if (z10) {
                fVar.b(this);
            }
            if (this.f14518d.d() == 0) {
                this.f14519e = true;
                cVar.f14522b = true;
            }
        }
    }

    public void i(c cVar, b bVar, boolean z10) {
        a aVar = this.f14518d;
        aVar.getClass();
        float fC = aVar.c(bVar.f14515a);
        aVar.h(bVar.f14515a, z10);
        a aVar2 = bVar.f14518d;
        int iD = aVar2.d();
        for (int i = 0; i < iD; i++) {
            f fVarE = aVar2.e(i);
            aVar.a(fVarE, aVar2.c(fVarE) * fC, z10);
        }
        this.f14516b = (bVar.f14516b * fC) + this.f14516b;
        if (z10) {
            bVar.f14515a.b(this);
        }
        if (this.f14515a == null || this.f14518d.d() != 0) {
            return;
        }
        this.f14519e = true;
        cVar.f14522b = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            y.f r0 = r10.f14515a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            y.f r1 = r10.f14515a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = l0.e.j(r0, r1)
            float r1 = r10.f14516b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L35
            java.lang.StringBuilder r0 = y.e.b(r0)
            float r1 = r10.f14516b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r4
            goto L36
        L35:
            r1 = r3
        L36:
            y.a r5 = r10.f14518d
            int r5 = r5.d()
        L3c:
            if (r3 >= r5) goto L9c
            y.a r6 = r10.f14518d
            y.f r6 = r6.e(r3)
            if (r6 != 0) goto L47
            goto L99
        L47:
            y.a r7 = r10.f14518d
            float r7 = r7.f(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L52
            goto L99
        L52:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L66
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L76
            java.lang.String r1 = "- "
            java.lang.String r0 = l0.e.j(r0, r1)
        L64:
            float r7 = r7 * r9
            goto L76
        L66:
            if (r8 <= 0) goto L6f
            java.lang.String r1 = " + "
            java.lang.String r0 = l0.e.j(r0, r1)
            goto L76
        L6f:
            java.lang.String r1 = " - "
            java.lang.String r0 = l0.e.j(r0, r1)
            goto L64
        L76:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L81
            java.lang.String r0 = l0.e.j(r0, r6)
            goto L98
        L81:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L98:
            r1 = r4
        L99:
            int r3 = r3 + 1
            goto L3c
        L9c:
            if (r1 != 0) goto La4
            java.lang.String r1 = "0.0"
            java.lang.String r0 = l0.e.j(r0, r1)
        La4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y.b.toString():java.lang.String");
    }
}
