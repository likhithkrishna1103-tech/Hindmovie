package g2;

import java.util.Map;
import o2.b1;
import p1.k0;
import p1.l0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p extends b1 {
    public final Map H;
    public p1.m I;

    public p(s2.e eVar, f2.n nVar, f2.k kVar, Map map) {
        super(eVar, nVar, kVar);
        this.H = map;
    }

    @Override // o2.b1
    public final p1.q p(p1.q qVar) {
        p1.m mVar;
        p1.m mVar2 = this.I;
        if (mVar2 == null) {
            mVar2 = qVar.f10027r;
        }
        if (mVar2 != null && (mVar = (p1.m) this.H.get(mVar2.f9937w)) != null) {
            mVar2 = mVar;
        }
        l0 l0Var = qVar.f10021l;
        l0 l0Var2 = null;
        if (l0Var == null) {
            l0Var = l0Var2;
        } else {
            k0[] k0VarArr = l0Var.f9896a;
            int length = k0VarArr.length;
            int i = 0;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    i10 = -1;
                    break;
                }
                k0 k0Var = k0VarArr[i10];
                if ((k0Var instanceof k3.m) && "com.apple.streaming.transportStreamTimestamp".equals(((k3.m) k0Var).f7010b)) {
                    break;
                }
                i10++;
            }
            if (i10 != -1) {
                if (length != 1) {
                    k0[] k0VarArr2 = new k0[length - 1];
                    while (i < length) {
                        if (i != i10) {
                            k0VarArr2[i < i10 ? i : i - 1] = k0VarArr[i];
                        }
                        i++;
                    }
                    l0Var2 = new l0(k0VarArr2);
                }
                l0Var = l0Var2;
            }
        }
        if (mVar2 != qVar.f10027r || l0Var != qVar.f10021l) {
            p1.p pVarA = qVar.a();
            pVarA.f9971q = mVar2;
            pVarA.f9965k = l0Var;
            qVar = new p1.q(pVarA);
        }
        return super.p(qVar);
    }
}
