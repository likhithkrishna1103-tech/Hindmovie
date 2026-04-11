package m2;

import java.util.Map;
import s2.z0;
import v1.k0;
import v1.l0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends z0 {
    public final Map H;
    public v1.l I;

    public q(w2.e eVar, l2.n nVar, l2.k kVar, Map map) {
        super(eVar, nVar, kVar);
        this.H = map;
    }

    @Override // s2.z0
    public final v1.p p(v1.p pVar) {
        v1.l lVar;
        v1.l lVar2 = this.I;
        if (lVar2 == null) {
            lVar2 = pVar.f12950r;
        }
        if (lVar2 != null && (lVar = (v1.l) this.H.get(lVar2.f12826x)) != null) {
            lVar2 = lVar;
        }
        l0 l0Var = pVar.f12944l;
        l0 l0Var2 = null;
        if (l0Var == null) {
            l0Var = l0Var2;
        } else {
            k0[] k0VarArr = l0Var.f12828a;
            int length = k0VarArr.length;
            int i = 0;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    i10 = -1;
                    break;
                }
                k0 k0Var = k0VarArr[i10];
                if ((k0Var instanceof o3.m) && "com.apple.streaming.transportStreamTimestamp".equals(((o3.m) k0Var).f9475b)) {
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
        if (lVar2 != pVar.f12950r || l0Var != pVar.f12944l) {
            v1.o oVarA = pVar.a();
            oVarA.f12897q = lVar2;
            oVarA.f12891k = l0Var;
            pVar = new v1.p(oVarA);
        }
        return super.p(pVar);
    }
}
