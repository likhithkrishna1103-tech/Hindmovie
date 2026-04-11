package b0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends o {
    @Override // b0.d
    public final void a(d dVar) {
        f fVar = this.f1630h;
        if (fVar.f1604c && !fVar.f1609j) {
            fVar.d((int) ((((f) fVar.f1611l.get(0)).f1607g * ((a0.h) this.f1625b).f101q0) + 0.5f));
        }
    }

    @Override // b0.o
    public final void d() {
        a0.d dVar = this.f1625b;
        a0.h hVar = (a0.h) dVar;
        int i = hVar.f102r0;
        int i10 = hVar.f103s0;
        int i11 = hVar.f105u0;
        f fVar = this.f1630h;
        if (i11 == 1) {
            if (i != -1) {
                fVar.f1611l.add(dVar.T.f32d.f1630h);
                this.f1625b.T.f32d.f1630h.f1610k.add(fVar);
                fVar.f = i;
            } else if (i10 != -1) {
                fVar.f1611l.add(dVar.T.f32d.i);
                this.f1625b.T.f32d.i.f1610k.add(fVar);
                fVar.f = -i10;
            } else {
                fVar.f1603b = true;
                fVar.f1611l.add(dVar.T.f32d.i);
                this.f1625b.T.f32d.i.f1610k.add(fVar);
            }
            m(this.f1625b.f32d.f1630h);
            m(this.f1625b.f32d.i);
            return;
        }
        if (i != -1) {
            fVar.f1611l.add(dVar.T.f34e.f1630h);
            this.f1625b.T.f34e.f1630h.f1610k.add(fVar);
            fVar.f = i;
        } else if (i10 != -1) {
            fVar.f1611l.add(dVar.T.f34e.i);
            this.f1625b.T.f34e.i.f1610k.add(fVar);
            fVar.f = -i10;
        } else {
            fVar.f1603b = true;
            fVar.f1611l.add(dVar.T.f34e.i);
            this.f1625b.T.f34e.i.f1610k.add(fVar);
        }
        m(this.f1625b.f34e.f1630h);
        m(this.f1625b.f34e.i);
    }

    @Override // b0.o
    public final void e() {
        a0.d dVar = this.f1625b;
        int i = ((a0.h) dVar).f105u0;
        f fVar = this.f1630h;
        if (i == 1) {
            dVar.Y = fVar.f1607g;
        } else {
            dVar.Z = fVar.f1607g;
        }
    }

    @Override // b0.o
    public final void f() {
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
