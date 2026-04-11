package v;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f13085d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f13082a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f13083b = 0.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f13084c = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13086e = false;

    public b(kc.b bVar) {
        this.f13085d = new a(this, bVar);
    }

    public final void a(c cVar, int i) {
        this.f13085d.g(cVar.j(i), 1.0f);
        this.f13085d.g(cVar.j(i), -1.0f);
    }

    public final void b(f fVar, f fVar2, f fVar3, int i) {
        boolean z2 = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z2 = true;
            }
            this.f13083b = i;
        }
        if (z2) {
            this.f13085d.g(fVar, 1.0f);
            this.f13085d.g(fVar2, -1.0f);
            this.f13085d.g(fVar3, -1.0f);
        } else {
            this.f13085d.g(fVar, -1.0f);
            this.f13085d.g(fVar2, 1.0f);
            this.f13085d.g(fVar3, 1.0f);
        }
    }

    public final void c(f fVar, f fVar2, f fVar3, int i) {
        boolean z2 = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z2 = true;
            }
            this.f13083b = i;
        }
        if (z2) {
            this.f13085d.g(fVar, 1.0f);
            this.f13085d.g(fVar2, -1.0f);
            this.f13085d.g(fVar3, 1.0f);
        } else {
            this.f13085d.g(fVar, -1.0f);
            this.f13085d.g(fVar2, 1.0f);
            this.f13085d.g(fVar3, -1.0f);
        }
    }

    public f d(boolean[] zArr) {
        return f(zArr, null);
    }

    public boolean e() {
        return this.f13082a == null && this.f13083b == 0.0f && this.f13085d.d() == 0;
    }

    public final f f(boolean[] zArr, f fVar) {
        int i;
        int iD = this.f13085d.d();
        f fVar2 = null;
        float f = 0.0f;
        for (int i10 = 0; i10 < iD; i10++) {
            float f4 = this.f13085d.f(i10);
            if (f4 < 0.0f) {
                f fVarE = this.f13085d.e(i10);
                if ((zArr == null || !zArr[fVarE.f13106v]) && fVarE != fVar && (((i = fVarE.F) == 3 || i == 4) && f4 < f)) {
                    f = f4;
                    fVar2 = fVarE;
                }
            }
        }
        return fVar2;
    }

    public final void g(f fVar) {
        f fVar2 = this.f13082a;
        if (fVar2 != null) {
            this.f13085d.g(fVar2, -1.0f);
            this.f13082a.f13107w = -1;
            this.f13082a = null;
        }
        float fH = this.f13085d.h(fVar, true) * (-1.0f);
        this.f13082a = fVar;
        if (fH == 1.0f) {
            return;
        }
        this.f13083b /= fH;
        a aVar = this.f13085d;
        int i = aVar.f13080h;
        for (int i10 = 0; i != -1 && i10 < aVar.f13074a; i10++) {
            float[] fArr = aVar.f13079g;
            fArr[i] = fArr[i] / fH;
            i = aVar.f[i];
        }
    }

    public final void h(c cVar, f fVar, boolean z2) {
        if (fVar.f13110z) {
            float fC = this.f13085d.c(fVar);
            this.f13083b = (fVar.f13109y * fC) + this.f13083b;
            this.f13085d.h(fVar, z2);
            if (z2) {
                fVar.b(this);
            }
            if (this.f13085d.d() == 0) {
                this.f13086e = true;
                cVar.f13089a = true;
            }
        }
    }

    public void i(c cVar, b bVar, boolean z2) {
        a aVar = this.f13085d;
        aVar.getClass();
        float fC = aVar.c(bVar.f13082a);
        aVar.h(bVar.f13082a, z2);
        a aVar2 = bVar.f13085d;
        int iD = aVar2.d();
        for (int i = 0; i < iD; i++) {
            f fVarE = aVar2.e(i);
            aVar.a(fVarE, aVar2.c(fVarE) * fC, z2);
        }
        this.f13083b = (bVar.f13083b * fC) + this.f13083b;
        if (z2) {
            bVar.f13082a.b(this);
        }
        if (this.f13082a == null || this.f13085d.d() != 0) {
            return;
        }
        this.f13086e = true;
        cVar.f13089a = true;
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
            v.f r0 = r10.f13082a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            v.f r1 = r10.f13082a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = e6.j.m(r0, r1)
            float r1 = r10.f13083b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L35
            java.lang.StringBuilder r0 = v.e.b(r0)
            float r1 = r10.f13083b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r4
            goto L36
        L35:
            r1 = r3
        L36:
            v.a r5 = r10.f13085d
            int r5 = r5.d()
        L3c:
            if (r3 >= r5) goto L9c
            v.a r6 = r10.f13085d
            v.f r6 = r6.e(r3)
            if (r6 != 0) goto L47
            goto L99
        L47:
            v.a r7 = r10.f13085d
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
            java.lang.String r0 = e6.j.m(r0, r1)
        L64:
            float r7 = r7 * r9
            goto L76
        L66:
            if (r8 <= 0) goto L6f
            java.lang.String r1 = " + "
            java.lang.String r0 = e6.j.m(r0, r1)
            goto L76
        L6f:
            java.lang.String r1 = " - "
            java.lang.String r0 = e6.j.m(r0, r1)
            goto L64
        L76:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L81
            java.lang.String r0 = e6.j.m(r0, r6)
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
            java.lang.String r0 = e6.j.m(r0, r1)
        La4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v.b.toString():java.lang.String");
    }
}
