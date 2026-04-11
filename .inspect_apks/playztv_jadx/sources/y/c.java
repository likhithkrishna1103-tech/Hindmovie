package y;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c extends o {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f14381k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14382l;

    public c(x.e eVar, int i) {
        x.e eVar2;
        super(eVar);
        ArrayList arrayList = new ArrayList();
        this.f14381k = arrayList;
        this.f = i;
        x.e eVar3 = this.f14413b;
        x.e eVarM = eVar3.m(i);
        while (true) {
            eVar2 = eVar3;
            eVar3 = eVarM;
            if (eVar3 == null) {
                break;
            } else {
                eVarM = eVar3.m(this.f);
            }
        }
        this.f14413b = eVar2;
        int i10 = this.f;
        arrayList.add(i10 == 0 ? eVar2.f14127d : i10 == 1 ? eVar2.f14129e : null);
        x.e eVarL = eVar2.l(this.f);
        while (eVarL != null) {
            int i11 = this.f;
            arrayList.add(i11 == 0 ? eVarL.f14127d : i11 == 1 ? eVarL.f14129e : null);
            eVarL = eVarL.l(this.f);
        }
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList.get(i12);
            i12++;
            o oVar = (o) obj;
            int i13 = this.f;
            if (i13 == 0) {
                oVar.f14413b.f14123b = this;
            } else if (i13 == 1) {
                oVar.f14413b.f14125c = this;
            }
        }
        if (this.f == 0 && ((x.f) this.f14413b.T).f14165v0 && arrayList.size() > 1) {
            this.f14413b = ((o) arrayList.get(arrayList.size() - 1)).f14413b;
        }
        this.f14382l = this.f == 0 ? this.f14413b.f14136i0 : this.f14413b.f14138j0;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00dd  */
    @Override // y.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(y.d r28) {
        /*
            Method dump skipped, instruction units count: 945
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.c.a(y.d):void");
    }

    @Override // y.o
    public final void d() {
        ArrayList arrayList = this.f14381k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((o) obj).d();
        }
        int size2 = arrayList.size();
        if (size2 < 1) {
            return;
        }
        x.e eVar = ((o) arrayList.get(0)).f14413b;
        x.e eVar2 = ((o) arrayList.get(size2 - 1)).f14413b;
        int i10 = this.f;
        f fVar = this.i;
        f fVar2 = this.f14418h;
        if (i10 == 0) {
            x.d dVar = eVar.I;
            x.d dVar2 = eVar2.K;
            f fVarI = o.i(dVar, 0);
            int iE = dVar.e();
            x.e eVarM = m();
            if (eVarM != null) {
                iE = eVarM.I.e();
            }
            if (fVarI != null) {
                o.b(fVar2, fVarI, iE);
            }
            f fVarI2 = o.i(dVar2, 0);
            int iE2 = dVar2.e();
            x.e eVarN = n();
            if (eVarN != null) {
                iE2 = eVarN.K.e();
            }
            if (fVarI2 != null) {
                o.b(fVar, fVarI2, -iE2);
            }
        } else {
            x.d dVar3 = eVar.J;
            x.d dVar4 = eVar2.L;
            f fVarI3 = o.i(dVar3, 1);
            int iE3 = dVar3.e();
            x.e eVarM2 = m();
            if (eVarM2 != null) {
                iE3 = eVarM2.J.e();
            }
            if (fVarI3 != null) {
                o.b(fVar2, fVarI3, iE3);
            }
            f fVarI4 = o.i(dVar4, 1);
            int iE4 = dVar4.e();
            x.e eVarN2 = n();
            if (eVarN2 != null) {
                iE4 = eVarN2.L.e();
            }
            if (fVarI4 != null) {
                o.b(fVar, fVarI4, -iE4);
            }
        }
        fVar2.f14390a = this;
        fVar.f14390a = this;
    }

    @Override // y.o
    public final void e() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f14381k;
            if (i >= arrayList.size()) {
                return;
            }
            ((o) arrayList.get(i)).e();
            i++;
        }
    }

    @Override // y.o
    public final void f() {
        this.f14414c = null;
        ArrayList arrayList = this.f14381k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((o) obj).f();
        }
    }

    @Override // y.o
    public final long j() {
        ArrayList arrayList = this.f14381k;
        int size = arrayList.size();
        long j5 = 0;
        for (int i = 0; i < size; i++) {
            o oVar = (o) arrayList.get(i);
            j5 = ((long) oVar.i.f) + oVar.j() + j5 + ((long) oVar.f14418h.f);
        }
        return j5;
    }

    @Override // y.o
    public final boolean k() {
        ArrayList arrayList = this.f14381k;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!((o) arrayList.get(i)).k()) {
                return false;
            }
        }
        return true;
    }

    public final x.e m() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f14381k;
            if (i >= arrayList.size()) {
                return null;
            }
            x.e eVar = ((o) arrayList.get(i)).f14413b;
            if (eVar.f14133g0 != 8) {
                return eVar;
            }
            i++;
        }
    }

    public final x.e n() {
        ArrayList arrayList = this.f14381k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            x.e eVar = ((o) arrayList.get(size)).f14413b;
            if (eVar.f14133g0 != 8) {
                return eVar;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.f == 0 ? "horizontal : " : "vertical : ");
        ArrayList arrayList = this.f14381k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            sb2.append("<");
            sb2.append((o) obj);
            sb2.append("> ");
        }
        return sb2.toString();
    }
}
