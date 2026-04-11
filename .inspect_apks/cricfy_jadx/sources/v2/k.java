package v2;

import ua.i0;
import ua.w0;
import ua.x0;
import ua.y;
import v1.g1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends m implements Comparable {
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final boolean H;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f13106z;

    public k(int i, g1 g1Var, int i10, i iVar, int i11, String str, String str2) {
        int iD;
        super(i, g1Var, i10);
        int i12 = 0;
        this.A = q4.a.g(i11, false);
        int i13 = this.f13110y.f12939e;
        int i14 = iVar.f12866y;
        i0 i0Var = iVar.f12863v;
        int i15 = i13 & (~i14);
        this.B = (i15 & 1) != 0;
        this.C = (i15 & 2) != 0;
        i0 i0VarO = str2 != null ? i0.o(str2) : i0Var.isEmpty() ? i0.o("") : i0Var;
        int i16 = 0;
        while (true) {
            if (i16 >= i0VarO.size()) {
                iD = 0;
                i16 = Integer.MAX_VALUE;
                break;
            } else {
                iD = o.d(this.f13110y, (String) i0VarO.get(i16), iVar.f12867z);
                if (iD > 0) {
                    break;
                } else {
                    i16++;
                }
            }
        }
        this.D = i16;
        this.E = iD;
        int i17 = str2 != null ? 1088 : iVar.f12864w;
        int i18 = this.f13110y.f;
        x0 x0Var = o.f13112k;
        int iBitCount = (i18 == 0 || i18 != i17) ? Integer.bitCount(i17 & i18) : Integer.MAX_VALUE;
        this.F = iBitCount;
        this.H = (1088 & this.f13110y.f) != 0;
        int iD2 = o.d(this.f13110y, str, o.g(str) == null);
        this.G = iD2;
        boolean z10 = iD > 0 || (i0Var.isEmpty() && iBitCount > 0) || this.B || (this.C && iD2 > 0);
        if (q4.a.g(i11, iVar.f13101u0) && z10) {
            i12 = 1;
        }
        this.f13106z = i12;
    }

    @Override // v2.m
    public final int a() {
        return this.f13106z;
    }

    @Override // v2.m
    public final /* bridge */ /* synthetic */ boolean b(m mVar) {
        return false;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(k kVar) {
        y yVarC = y.f12407a.c(this.A, kVar.A);
        Integer numValueOf = Integer.valueOf(this.D);
        Integer numValueOf2 = Integer.valueOf(kVar.D);
        w0 w0Var = w0.f12403w;
        w0 w0Var2 = w0.f12404x;
        y yVarB = yVarC.b(numValueOf, numValueOf2, w0Var2);
        int i = kVar.E;
        int i10 = this.E;
        y yVarA = yVarB.a(i10, i);
        int i11 = kVar.F;
        int i12 = this.F;
        y yVarC2 = yVarA.a(i12, i11).c(this.B, kVar.B);
        Boolean boolValueOf = Boolean.valueOf(this.C);
        Boolean boolValueOf2 = Boolean.valueOf(kVar.C);
        if (i10 != 0) {
            w0Var = w0Var2;
        }
        y yVarA2 = yVarC2.b(boolValueOf, boolValueOf2, w0Var).a(this.G, kVar.G);
        if (i12 == 0) {
            yVarA2 = yVarA2.d(this.H, kVar.H);
        }
        return yVarA2.e();
    }
}
