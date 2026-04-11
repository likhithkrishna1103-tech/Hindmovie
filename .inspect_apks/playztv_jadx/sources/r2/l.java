package r2;

import aa.a1;
import aa.j0;
import aa.y;
import aa.z0;
import p1.g1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends n implements Comparable {
    public final boolean A;
    public final boolean B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final boolean G;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f11333y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f11334z;

    public l(int i, g1 g1Var, int i10, j jVar, int i11, String str, String str2) {
        int iD;
        super(i, g1Var, i10);
        int i12 = 0;
        this.f11334z = l4.a.h(i11, false);
        int i13 = this.f11338x.f10016e;
        int i14 = jVar.f9933y;
        j0 j0Var = jVar.f9930v;
        int i15 = i13 & (~i14);
        this.A = (i15 & 1) != 0;
        this.B = (i15 & 2) != 0;
        j0 j0VarV = str2 != null ? j0.v(str2) : j0Var.isEmpty() ? j0.v("") : j0Var;
        int i16 = 0;
        while (true) {
            if (i16 >= j0VarV.size()) {
                iD = 0;
                i16 = Integer.MAX_VALUE;
                break;
            } else {
                iD = p.d(this.f11338x, (String) j0VarV.get(i16), jVar.f9934z);
                if (iD > 0) {
                    break;
                } else {
                    i16++;
                }
            }
        }
        this.C = i16;
        this.D = iD;
        int i17 = str2 != null ? 1088 : jVar.f9931w;
        int i18 = this.f11338x.f;
        a1 a1Var = p.f11341k;
        int iBitCount = (i18 == 0 || i18 != i17) ? Integer.bitCount(i17 & i18) : Integer.MAX_VALUE;
        this.E = iBitCount;
        this.G = (1088 & this.f11338x.f) != 0;
        int iD2 = p.d(this.f11338x, str, p.g(str) == null);
        this.F = iD2;
        boolean z2 = iD > 0 || (j0Var.isEmpty() && iBitCount > 0) || this.A || (this.B && iD2 > 0);
        if (l4.a.h(i11, jVar.f11328u0) && z2) {
            i12 = 1;
        }
        this.f11333y = i12;
    }

    @Override // r2.n
    public final int a() {
        return this.f11333y;
    }

    @Override // r2.n
    public final /* bridge */ /* synthetic */ boolean b(n nVar) {
        return false;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(l lVar) {
        y yVarC = y.f763a.c(this.f11334z, lVar.f11334z);
        Integer numValueOf = Integer.valueOf(this.C);
        Integer numValueOf2 = Integer.valueOf(lVar.C);
        z0 z0Var = z0.f767v;
        z0 z0Var2 = z0.f768w;
        y yVarB = yVarC.b(numValueOf, numValueOf2, z0Var2);
        int i = lVar.D;
        int i10 = this.D;
        y yVarA = yVarB.a(i10, i);
        int i11 = lVar.E;
        int i12 = this.E;
        y yVarC2 = yVarA.a(i12, i11).c(this.A, lVar.A);
        Boolean boolValueOf = Boolean.valueOf(this.B);
        Boolean boolValueOf2 = Boolean.valueOf(lVar.B);
        if (i10 != 0) {
            z0Var = z0Var2;
        }
        y yVarA2 = yVarC2.b(boolValueOf, boolValueOf2, z0Var).a(this.F, lVar.F);
        if (i12 == 0) {
            yVarA2 = yVarA2.d(this.G, lVar.G);
        }
        return yVarA2.e();
    }
}
