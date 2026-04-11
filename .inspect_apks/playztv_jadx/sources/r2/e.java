package r2;

import aa.a1;
import aa.y;
import aa.z0;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends n implements Comparable {
    public final String A;
    public final j B;
    public final boolean C;
    public final int D;
    public final int E;
    public final int F;
    public final boolean G;
    public final boolean H;
    public final int I;
    public final int J;
    public final boolean K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;
    public final boolean P;
    public final boolean Q;
    public final boolean R;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f11313y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f11314z;

    /* JADX WARN: Removed duplicated region for block: B:49:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(int r14, p1.g1 r15, int r16, r2.j r17, int r18, boolean r19, r2.d r20, int r21) {
        /*
            Method dump skipped, instruction units count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.e.<init>(int, p1.g1, int, r2.j, int, boolean, r2.d, int):void");
    }

    @Override // r2.n
    public final int a() {
        return this.f11313y;
    }

    @Override // r2.n
    public final boolean b(n nVar) {
        int i;
        String str;
        e eVar = (e) nVar;
        p1.q qVar = eVar.f11338x;
        this.B.getClass();
        p1.q qVar2 = this.f11338x;
        int i10 = qVar2.F;
        if (i10 == -1 || i10 != qVar.F) {
            return false;
        }
        return (this.G || ((str = qVar2.f10023n) != null && TextUtils.equals(str, qVar.f10023n))) && (i = qVar2.G) != -1 && i == qVar.G && this.P == eVar.P && this.Q == eVar.Q;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final int compareTo(e eVar) {
        boolean z2 = this.C;
        boolean z10 = this.f11314z;
        a1 a1VarA = (z10 && z2) ? p.f11341k : p.f11341k.a();
        boolean z11 = eVar.C;
        int i = eVar.N;
        y yVarC = y.f763a.c(z2, z11);
        Integer numValueOf = Integer.valueOf(this.E);
        Integer numValueOf2 = Integer.valueOf(eVar.E);
        z0 z0Var = z0.f768w;
        y yVarB = yVarC.b(numValueOf, numValueOf2, z0Var).a(this.D, eVar.D).a(this.F, eVar.F).c(this.K, eVar.K).c(this.H, eVar.H).b(Integer.valueOf(this.I), Integer.valueOf(eVar.I), z0Var).a(this.J, eVar.J).c(z10, eVar.f11314z).b(Integer.valueOf(this.O), Integer.valueOf(eVar.O), z0Var);
        boolean z12 = this.B.B;
        int i10 = this.N;
        if (z12) {
            yVarB = yVarB.b(Integer.valueOf(i10), Integer.valueOf(i), p.f11341k.a());
        }
        y yVarB2 = yVarB.c(this.P, eVar.P).c(this.Q, eVar.Q).c(this.R, eVar.R).b(Integer.valueOf(this.L), Integer.valueOf(eVar.L), a1VarA).b(Integer.valueOf(this.M), Integer.valueOf(eVar.M), a1VarA);
        if (Objects.equals(this.A, eVar.A)) {
            yVarB2 = yVarB2.b(Integer.valueOf(i10), Integer.valueOf(i), a1VarA);
        }
        return yVarB2.e();
    }
}
