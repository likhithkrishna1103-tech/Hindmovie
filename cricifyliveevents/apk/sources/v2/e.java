package v2;

import android.text.TextUtils;
import java.util.Objects;
import ua.w0;
import ua.x0;
import ua.y;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends m implements Comparable {
    public final boolean A;
    public final String B;
    public final i C;
    public final boolean D;
    public final int E;
    public final int F;
    public final int G;
    public final boolean H;
    public final boolean I;
    public final int J;
    public final int K;
    public final boolean L;
    public final int M;
    public final int N;
    public final int O;
    public final int P;
    public final boolean Q;
    public final boolean R;
    public final boolean S;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f13090z;

    /* JADX WARN: Removed duplicated region for block: B:49:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(int r14, v1.g1 r15, int r16, v2.i r17, int r18, boolean r19, v2.d r20, int r21) {
        /*
            Method dump skipped, instruction units count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v2.e.<init>(int, v1.g1, int, v2.i, int, boolean, v2.d, int):void");
    }

    @Override // v2.m
    public final int a() {
        return this.f13090z;
    }

    @Override // v2.m
    public final boolean b(m mVar) {
        int i;
        String str;
        e eVar = (e) mVar;
        v1.p pVar = eVar.f13110y;
        this.C.getClass();
        v1.p pVar2 = this.f13110y;
        int i10 = pVar2.F;
        if (i10 == -1 || i10 != pVar.F) {
            return false;
        }
        return (this.H || ((str = pVar2.f12946n) != null && TextUtils.equals(str, pVar.f12946n))) && (i = pVar2.G) != -1 && i == pVar.G && this.Q == eVar.Q && this.R == eVar.R;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(e eVar) {
        boolean z10 = this.D;
        boolean z11 = this.A;
        x0 x0VarA = (z11 && z10) ? o.f13112k : o.f13112k.a();
        boolean z12 = eVar.D;
        int i = eVar.O;
        y yVarC = y.f12407a.c(z10, z12);
        Integer numValueOf = Integer.valueOf(this.F);
        Integer numValueOf2 = Integer.valueOf(eVar.F);
        w0 w0Var = w0.f12404x;
        y yVarB = yVarC.b(numValueOf, numValueOf2, w0Var).a(this.E, eVar.E).a(this.G, eVar.G).c(this.L, eVar.L).c(this.I, eVar.I).b(Integer.valueOf(this.J), Integer.valueOf(eVar.J), w0Var).a(this.K, eVar.K).c(z11, eVar.A).b(Integer.valueOf(this.P), Integer.valueOf(eVar.P), w0Var);
        boolean z13 = this.C.B;
        int i10 = this.O;
        if (z13) {
            yVarB = yVarB.b(Integer.valueOf(i10), Integer.valueOf(i), o.f13112k.a());
        }
        y yVarB2 = yVarB.c(this.Q, eVar.Q).c(this.R, eVar.R).c(this.S, eVar.S).b(Integer.valueOf(this.M), Integer.valueOf(eVar.M), x0VarA).b(Integer.valueOf(this.N), Integer.valueOf(eVar.N), x0VarA);
        if (Objects.equals(this.B, eVar.B)) {
            yVarB2 = yVarB2.b(Integer.valueOf(i10), Integer.valueOf(i), x0VarA);
        }
        return yVarB2.e();
    }
}
