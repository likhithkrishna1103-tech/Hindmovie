package r2;

import aa.y;
import aa.z0;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends n {
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final boolean J;
    public final int K;
    public final boolean L;
    public final int M;
    public final boolean N;
    public final boolean O;
    public final int P;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f11339y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final j f11340z;

    /* JADX WARN: Removed duplicated region for block: B:133:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public o(int r7, p1.g1 r8, int r9, r2.j r10, int r11, java.lang.String r12, int r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.o.<init>(int, p1.g1, int, r2.j, int, java.lang.String, int, boolean):void");
    }

    public static int c(o oVar, o oVar2) {
        y yVarC = y.f763a.c(oVar.B, oVar2.B);
        Integer numValueOf = Integer.valueOf(oVar.G);
        Integer numValueOf2 = Integer.valueOf(oVar2.G);
        z0 z0Var = z0.f768w;
        y yVarB = yVarC.b(numValueOf, numValueOf2, z0Var).a(oVar.H, oVar2.H).a(oVar.I, oVar2.I).c(oVar.J, oVar2.J).a(oVar.K, oVar2.K).c(oVar.C, oVar2.C).c(oVar.f11339y, oVar2.f11339y).c(oVar.A, oVar2.A).b(Integer.valueOf(oVar.F), Integer.valueOf(oVar2.F), z0Var);
        boolean z2 = oVar.N;
        y yVarC2 = yVarB.c(z2, oVar2.N);
        boolean z10 = oVar.O;
        y yVarC3 = yVarC2.c(z10, oVar2.O);
        if (z2 && z10) {
            yVarC3 = yVarC3.a(oVar.P, oVar2.P);
        }
        return yVarC3.e();
    }

    @Override // r2.n
    public final int a() {
        return this.M;
    }

    @Override // r2.n
    public final boolean b(n nVar) {
        o oVar = (o) nVar;
        if (!this.L && !Objects.equals(this.f11338x.f10023n, oVar.f11338x.f10023n)) {
            return false;
        }
        this.f11340z.getClass();
        return this.N == oVar.N && this.O == oVar.O;
    }
}
