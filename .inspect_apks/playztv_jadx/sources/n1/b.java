package n1;

import androidx.lifecycle.l0;
import androidx.lifecycle.o0;
import androidx.lifecycle.r0;
import be.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e[] f8636a;

    public b(e... eVarArr) {
        h.e(eVarArr, "initializers");
        this.f8636a = eVarArr;
    }

    @Override // androidx.lifecycle.r0
    public final o0 a(Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    @Override // androidx.lifecycle.r0
    public final o0 b(Class cls, c cVar) {
        l0 l0Var = null;
        for (e eVar : this.f8636a) {
            if (eVar.f8637a.equals(cls)) {
                l0Var = new l0();
            }
        }
        if (l0Var != null) {
            return l0Var;
        }
        throw new IllegalArgumentException("No initializer set for given class ".concat(cls.getName()));
    }
}
