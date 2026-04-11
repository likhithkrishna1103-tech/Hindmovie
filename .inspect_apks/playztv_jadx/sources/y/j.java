package y;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends o {
    @Override // y.d
    public final void a(d dVar) {
        x.a aVar = (x.a) this.f14413b;
        int i = aVar.f14095s0;
        f fVar = this.f14418h;
        ArrayList arrayList = fVar.f14399l;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = -1;
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList.get(i12);
            i12++;
            int i13 = ((f) obj).f14395g;
            if (i11 == -1 || i13 < i11) {
                i11 = i13;
            }
            if (i10 < i13) {
                i10 = i13;
            }
        }
        if (i == 0 || i == 2) {
            fVar.d(i11 + aVar.f14097u0);
        } else {
            fVar.d(i10 + aVar.f14097u0);
        }
    }

    @Override // y.o
    public final void d() {
        x.e eVar = this.f14413b;
        if (eVar instanceof x.a) {
            f fVar = this.f14418h;
            fVar.f14391b = true;
            ArrayList arrayList = fVar.f14399l;
            x.a aVar = (x.a) eVar;
            int i = aVar.f14095s0;
            boolean z2 = aVar.f14096t0;
            int i10 = 0;
            if (i == 0) {
                fVar.f14394e = 4;
                while (i10 < aVar.f14202r0) {
                    x.e eVar2 = aVar.f14201q0[i10];
                    if (z2 || eVar2.f14133g0 != 8) {
                        f fVar2 = eVar2.f14127d.f14418h;
                        fVar2.f14398k.add(fVar);
                        arrayList.add(fVar2);
                    }
                    i10++;
                }
                m(this.f14413b.f14127d.f14418h);
                m(this.f14413b.f14127d.i);
                return;
            }
            if (i == 1) {
                fVar.f14394e = 5;
                while (i10 < aVar.f14202r0) {
                    x.e eVar3 = aVar.f14201q0[i10];
                    if (z2 || eVar3.f14133g0 != 8) {
                        f fVar3 = eVar3.f14127d.i;
                        fVar3.f14398k.add(fVar);
                        arrayList.add(fVar3);
                    }
                    i10++;
                }
                m(this.f14413b.f14127d.f14418h);
                m(this.f14413b.f14127d.i);
                return;
            }
            if (i == 2) {
                fVar.f14394e = 6;
                while (i10 < aVar.f14202r0) {
                    x.e eVar4 = aVar.f14201q0[i10];
                    if (z2 || eVar4.f14133g0 != 8) {
                        f fVar4 = eVar4.f14129e.f14418h;
                        fVar4.f14398k.add(fVar);
                        arrayList.add(fVar4);
                    }
                    i10++;
                }
                m(this.f14413b.f14129e.f14418h);
                m(this.f14413b.f14129e.i);
                return;
            }
            if (i != 3) {
                return;
            }
            fVar.f14394e = 7;
            while (i10 < aVar.f14202r0) {
                x.e eVar5 = aVar.f14201q0[i10];
                if (z2 || eVar5.f14133g0 != 8) {
                    f fVar5 = eVar5.f14129e.i;
                    fVar5.f14398k.add(fVar);
                    arrayList.add(fVar5);
                }
                i10++;
            }
            m(this.f14413b.f14129e.f14418h);
            m(this.f14413b.f14129e.i);
        }
    }

    @Override // y.o
    public final void e() {
        x.e eVar = this.f14413b;
        if (eVar instanceof x.a) {
            int i = ((x.a) eVar).f14095s0;
            f fVar = this.f14418h;
            if (i == 0 || i == 1) {
                eVar.Y = fVar.f14395g;
            } else {
                eVar.Z = fVar.f14395g;
            }
        }
    }

    @Override // y.o
    public final void f() {
        this.f14414c = null;
        this.f14418h.c();
    }

    @Override // y.o
    public final boolean k() {
        return false;
    }

    public final void m(f fVar) {
        f fVar2 = this.f14418h;
        fVar2.f14398k.add(fVar);
        fVar.f14399l.add(fVar2);
    }
}
