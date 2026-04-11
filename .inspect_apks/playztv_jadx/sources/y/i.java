package y;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends o {
    @Override // y.d
    public final void a(d dVar) {
        f fVar = this.f14418h;
        if (fVar.f14392c && !fVar.f14397j) {
            fVar.d((int) ((((f) fVar.f14399l.get(0)).f14395g * ((x.i) this.f14413b).f14195q0) + 0.5f));
        }
    }

    @Override // y.o
    public final void d() {
        x.e eVar = this.f14413b;
        x.i iVar = (x.i) eVar;
        int i = iVar.f14196r0;
        int i10 = iVar.f14197s0;
        int i11 = iVar.f14199u0;
        f fVar = this.f14418h;
        if (i11 == 1) {
            if (i != -1) {
                fVar.f14399l.add(eVar.T.f14127d.f14418h);
                this.f14413b.T.f14127d.f14418h.f14398k.add(fVar);
                fVar.f = i;
            } else if (i10 != -1) {
                fVar.f14399l.add(eVar.T.f14127d.i);
                this.f14413b.T.f14127d.i.f14398k.add(fVar);
                fVar.f = -i10;
            } else {
                fVar.f14391b = true;
                fVar.f14399l.add(eVar.T.f14127d.i);
                this.f14413b.T.f14127d.i.f14398k.add(fVar);
            }
            m(this.f14413b.f14127d.f14418h);
            m(this.f14413b.f14127d.i);
            return;
        }
        if (i != -1) {
            fVar.f14399l.add(eVar.T.f14129e.f14418h);
            this.f14413b.T.f14129e.f14418h.f14398k.add(fVar);
            fVar.f = i;
        } else if (i10 != -1) {
            fVar.f14399l.add(eVar.T.f14129e.i);
            this.f14413b.T.f14129e.i.f14398k.add(fVar);
            fVar.f = -i10;
        } else {
            fVar.f14391b = true;
            fVar.f14399l.add(eVar.T.f14129e.i);
            this.f14413b.T.f14129e.i.f14398k.add(fVar);
        }
        m(this.f14413b.f14129e.f14418h);
        m(this.f14413b.f14129e.i);
    }

    @Override // y.o
    public final void e() {
        x.e eVar = this.f14413b;
        int i = ((x.i) eVar).f14199u0;
        f fVar = this.f14418h;
        if (i == 1) {
            eVar.Y = fVar.f14395g;
        } else {
            eVar.Z = fVar.f14395g;
        }
    }

    @Override // y.o
    public final void f() {
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
