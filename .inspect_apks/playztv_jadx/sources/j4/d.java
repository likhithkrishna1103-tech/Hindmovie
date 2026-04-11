package j4;

import a2.f0;
import c.c0;
import c.z;
import ne.n;
import ub.o;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f6777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6778b;

    public final void a() {
        o oVar = this.f6777a;
        if (oVar == null) {
            throw new IllegalStateException("This input is not added to any dispatcher.");
        }
        if (!this.f6778b) {
            oVar.j(this, null);
        }
        e eVar = (e) oVar.f12869w;
        f0 f0Var = (f0) oVar.f12868v;
        eVar.getClass();
        if (equals(eVar.f6785h) && -1 == eVar.f6784g) {
            z zVarC = eVar.f;
            if (zVarC == null) {
                zVarC = eVar.c(-1);
            }
            eVar.f = null;
            eVar.f6784g = 0;
            eVar.f6785h = null;
            if (zVarC == null) {
                ((c0) f0Var.f220v).f2156a.run();
            } else {
                zVarC.f2206d.a();
            }
            n nVar = eVar.f6779a;
            nVar.getClass();
            nVar.f(null, f.f);
        }
        this.f6778b = false;
    }

    public void b(boolean z2) {
    }
}
