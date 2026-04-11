package c;

import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f2203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ub.o f2205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.fragment.app.f0 f2206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2207e;

    public z(androidx.fragment.app.f0 f0Var, a0 a0Var) {
        be.h.e(f0Var, "onBackPressedCallback");
        boolean z2 = f0Var.f1274b;
        this.f2203a = a0Var;
        this.f2204b = z2;
        this.f2206d = f0Var;
        this.f2207e = true;
    }

    public final void a() {
        ub.o oVar = this.f2205c;
        if (oVar == null || !((LinkedHashSet) oVar.f12870x).remove(this)) {
            return;
        }
        j4.e eVar = (j4.e) oVar.f12869w;
        eVar.getClass();
        if (equals(eVar.f)) {
            if (eVar.f6784g == -1) {
                this.f2206d.getClass();
            }
            eVar.f = null;
            eVar.f6784g = 0;
            eVar.f6785h = null;
        }
        eVar.f6782d.remove(this);
        eVar.f6783e.remove(this);
        this.f2205c = null;
        eVar.b();
    }

    public final void b(boolean z2) {
        j4.e eVar;
        if (this.f2204b == z2) {
            return;
        }
        this.f2204b = z2;
        ub.o oVar = this.f2205c;
        if (oVar == null || (eVar = (j4.e) oVar.f12869w) == null) {
            return;
        }
        eVar.b();
    }

    public final void c(boolean z2) {
        this.f2207e = z2;
        b(z2 && this.f2206d.f1274b);
    }
}
