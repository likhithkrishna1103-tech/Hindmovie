package b0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends o {
    @Override // b0.d
    public final void a(d dVar) {
        a0.a aVar = (a0.a) this.f1625b;
        int i = aVar.f0s0;
        f fVar = this.f1630h;
        ArrayList arrayList = fVar.f1611l;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = -1;
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList.get(i12);
            i12++;
            int i13 = ((f) obj).f1607g;
            if (i11 == -1 || i13 < i11) {
                i11 = i13;
            }
            if (i10 < i13) {
                i10 = i13;
            }
        }
        if (i == 0 || i == 2) {
            fVar.d(i11 + aVar.f2u0);
        } else {
            fVar.d(i10 + aVar.f2u0);
        }
    }

    @Override // b0.o
    public final void d() {
        a0.d dVar = this.f1625b;
        if (dVar instanceof a0.a) {
            f fVar = this.f1630h;
            fVar.f1603b = true;
            ArrayList arrayList = fVar.f1611l;
            a0.a aVar = (a0.a) dVar;
            int i = aVar.f0s0;
            boolean z10 = aVar.f1t0;
            int i10 = 0;
            if (i == 0) {
                fVar.f1606e = 4;
                while (i10 < aVar.f108r0) {
                    a0.d dVar2 = aVar.f107q0[i10];
                    if (z10 || dVar2.f38g0 != 8) {
                        f fVar2 = dVar2.f32d.f1630h;
                        fVar2.f1610k.add(fVar);
                        arrayList.add(fVar2);
                    }
                    i10++;
                }
                m(this.f1625b.f32d.f1630h);
                m(this.f1625b.f32d.i);
                return;
            }
            if (i == 1) {
                fVar.f1606e = 5;
                while (i10 < aVar.f108r0) {
                    a0.d dVar3 = aVar.f107q0[i10];
                    if (z10 || dVar3.f38g0 != 8) {
                        f fVar3 = dVar3.f32d.i;
                        fVar3.f1610k.add(fVar);
                        arrayList.add(fVar3);
                    }
                    i10++;
                }
                m(this.f1625b.f32d.f1630h);
                m(this.f1625b.f32d.i);
                return;
            }
            if (i == 2) {
                fVar.f1606e = 6;
                while (i10 < aVar.f108r0) {
                    a0.d dVar4 = aVar.f107q0[i10];
                    if (z10 || dVar4.f38g0 != 8) {
                        f fVar4 = dVar4.f34e.f1630h;
                        fVar4.f1610k.add(fVar);
                        arrayList.add(fVar4);
                    }
                    i10++;
                }
                m(this.f1625b.f34e.f1630h);
                m(this.f1625b.f34e.i);
                return;
            }
            if (i != 3) {
                return;
            }
            fVar.f1606e = 7;
            while (i10 < aVar.f108r0) {
                a0.d dVar5 = aVar.f107q0[i10];
                if (z10 || dVar5.f38g0 != 8) {
                    f fVar5 = dVar5.f34e.i;
                    fVar5.f1610k.add(fVar);
                    arrayList.add(fVar5);
                }
                i10++;
            }
            m(this.f1625b.f34e.f1630h);
            m(this.f1625b.f34e.i);
        }
    }

    @Override // b0.o
    public final void e() {
        a0.d dVar = this.f1625b;
        if (dVar instanceof a0.a) {
            int i = ((a0.a) dVar).f0s0;
            f fVar = this.f1630h;
            if (i == 0 || i == 1) {
                dVar.Y = fVar.f1607g;
            } else {
                dVar.Z = fVar.f1607g;
            }
        }
    }

    @Override // b0.o
    public final void f() {
        this.f1626c = null;
        this.f1630h.c();
    }

    @Override // b0.o
    public final boolean k() {
        return false;
    }

    public final void m(f fVar) {
        f fVar2 = this.f1630h;
        fVar2.f1610k.add(fVar);
        fVar.f1611l.add(fVar2);
    }
}
