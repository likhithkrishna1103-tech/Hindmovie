package b0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends o {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f1593k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1594l;

    public c(a0.d dVar, int i) {
        a0.d dVar2;
        super(dVar);
        ArrayList arrayList = new ArrayList();
        this.f1593k = arrayList;
        this.f = i;
        a0.d dVar3 = this.f1625b;
        a0.d dVarM = dVar3.m(i);
        while (true) {
            dVar2 = dVar3;
            dVar3 = dVarM;
            if (dVar3 == null) {
                break;
            } else {
                dVarM = dVar3.m(this.f);
            }
        }
        this.f1625b = dVar2;
        int i10 = this.f;
        arrayList.add(i10 == 0 ? dVar2.f32d : i10 == 1 ? dVar2.f34e : null);
        a0.d dVarL = dVar2.l(this.f);
        while (dVarL != null) {
            int i11 = this.f;
            arrayList.add(i11 == 0 ? dVarL.f32d : i11 == 1 ? dVarL.f34e : null);
            dVarL = dVarL.l(this.f);
        }
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList.get(i12);
            i12++;
            o oVar = (o) obj;
            int i13 = this.f;
            if (i13 == 0) {
                oVar.f1625b.f28b = this;
            } else if (i13 == 1) {
                oVar.f1625b.f30c = this;
            }
        }
        if (this.f == 0 && ((a0.e) this.f1625b.T).f70v0 && arrayList.size() > 1) {
            this.f1625b = ((o) arrayList.get(arrayList.size() - 1)).f1625b;
        }
        this.f1594l = this.f == 0 ? this.f1625b.f41i0 : this.f1625b.f43j0;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00dd  */
    @Override // b0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(b0.d r28) {
        /*
            Method dump skipped, instruction units count: 945
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.c.a(b0.d):void");
    }

    @Override // b0.o
    public final void d() {
        ArrayList arrayList = this.f1593k;
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
        a0.d dVar = ((o) arrayList.get(0)).f1625b;
        a0.d dVar2 = ((o) arrayList.get(size2 - 1)).f1625b;
        int i10 = this.f;
        f fVar = this.i;
        f fVar2 = this.f1630h;
        if (i10 == 0) {
            a0.c cVar = dVar.I;
            a0.c cVar2 = dVar2.K;
            f fVarI = o.i(cVar, 0);
            int iE = cVar.e();
            a0.d dVarM = m();
            if (dVarM != null) {
                iE = dVarM.I.e();
            }
            if (fVarI != null) {
                o.b(fVar2, fVarI, iE);
            }
            f fVarI2 = o.i(cVar2, 0);
            int iE2 = cVar2.e();
            a0.d dVarN = n();
            if (dVarN != null) {
                iE2 = dVarN.K.e();
            }
            if (fVarI2 != null) {
                o.b(fVar, fVarI2, -iE2);
            }
        } else {
            a0.c cVar3 = dVar.J;
            a0.c cVar4 = dVar2.L;
            f fVarI3 = o.i(cVar3, 1);
            int iE3 = cVar3.e();
            a0.d dVarM2 = m();
            if (dVarM2 != null) {
                iE3 = dVarM2.J.e();
            }
            if (fVarI3 != null) {
                o.b(fVar2, fVarI3, iE3);
            }
            f fVarI4 = o.i(cVar4, 1);
            int iE4 = cVar4.e();
            a0.d dVarN2 = n();
            if (dVarN2 != null) {
                iE4 = dVarN2.L.e();
            }
            if (fVarI4 != null) {
                o.b(fVar, fVarI4, -iE4);
            }
        }
        fVar2.f1602a = this;
        fVar.f1602a = this;
    }

    @Override // b0.o
    public final void e() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f1593k;
            if (i >= arrayList.size()) {
                return;
            }
            ((o) arrayList.get(i)).e();
            i++;
        }
    }

    @Override // b0.o
    public final void f() {
        this.f1626c = null;
        ArrayList arrayList = this.f1593k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((o) obj).f();
        }
    }

    @Override // b0.o
    public final long j() {
        ArrayList arrayList = this.f1593k;
        int size = arrayList.size();
        long j4 = 0;
        for (int i = 0; i < size; i++) {
            o oVar = (o) arrayList.get(i);
            j4 = ((long) oVar.i.f) + oVar.j() + j4 + ((long) oVar.f1630h.f);
        }
        return j4;
    }

    @Override // b0.o
    public final boolean k() {
        ArrayList arrayList = this.f1593k;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!((o) arrayList.get(i)).k()) {
                return false;
            }
        }
        return true;
    }

    public final a0.d m() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f1593k;
            if (i >= arrayList.size()) {
                return null;
            }
            a0.d dVar = ((o) arrayList.get(i)).f1625b;
            if (dVar.f38g0 != 8) {
                return dVar;
            }
            i++;
        }
    }

    public final a0.d n() {
        ArrayList arrayList = this.f1593k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            a0.d dVar = ((o) arrayList.get(size)).f1625b;
            if (dVar.f38g0 != 8) {
                return dVar;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f == 0 ? "horizontal : " : "vertical : ");
        ArrayList arrayList = this.f1593k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            sb.append("<");
            sb.append((o) obj);
            sb.append("> ");
        }
        return sb.toString();
    }
}
