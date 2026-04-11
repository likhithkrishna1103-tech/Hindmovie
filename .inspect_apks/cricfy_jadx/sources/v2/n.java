package v2;

import java.util.Objects;
import ua.w0;
import ua.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n extends m {
    public final i A;
    public final boolean B;
    public final boolean C;
    public final boolean D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final boolean K;
    public final int L;
    public final boolean M;
    public final int N;
    public final boolean O;
    public final boolean P;
    public final int Q;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f13111z;

    /* JADX WARN: Removed duplicated region for block: B:133:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public n(int r7, v1.g1 r8, int r9, v2.i r10, int r11, java.lang.String r12, int r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v2.n.<init>(int, v1.g1, int, v2.i, int, java.lang.String, int, boolean):void");
    }

    public static int c(n nVar, n nVar2) {
        y yVarC = y.f12407a.c(nVar.C, nVar2.C);
        Integer numValueOf = Integer.valueOf(nVar.H);
        Integer numValueOf2 = Integer.valueOf(nVar2.H);
        w0 w0Var = w0.f12404x;
        y yVarB = yVarC.b(numValueOf, numValueOf2, w0Var).a(nVar.I, nVar2.I).a(nVar.J, nVar2.J).c(nVar.K, nVar2.K).a(nVar.L, nVar2.L).c(nVar.D, nVar2.D).c(nVar.f13111z, nVar2.f13111z).c(nVar.B, nVar2.B).b(Integer.valueOf(nVar.G), Integer.valueOf(nVar2.G), w0Var);
        boolean z10 = nVar.O;
        y yVarC2 = yVarB.c(z10, nVar2.O);
        boolean z11 = nVar.P;
        y yVarC3 = yVarC2.c(z11, nVar2.P);
        if (z10 && z11) {
            yVarC3 = yVarC3.a(nVar.Q, nVar2.Q);
        }
        return yVarC3.e();
    }

    @Override // v2.m
    public final int a() {
        return this.N;
    }

    @Override // v2.m
    public final boolean b(m mVar) {
        n nVar = (n) mVar;
        if (!this.M && !Objects.equals(this.f13110y.f12946n, nVar.f13110y.f12946n)) {
            return false;
        }
        this.A.getClass();
        return this.O == nVar.O && this.P == nVar.P;
    }
}
