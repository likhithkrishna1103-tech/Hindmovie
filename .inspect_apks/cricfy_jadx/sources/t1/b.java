package t1;

import androidx.lifecycle.l0;
import androidx.lifecycle.o0;
import androidx.lifecycle.r0;
import ge.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e[] f11833a;

    public b(e... eVarArr) {
        i.e(eVarArr, "initializers");
        this.f11833a = eVarArr;
    }

    @Override // androidx.lifecycle.r0
    public final o0 a(Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    @Override // androidx.lifecycle.r0
    public final o0 b(Class cls, c cVar) {
        l0 l0Var = null;
        for (e eVar : this.f11833a) {
            if (eVar.f11834a.equals(cls)) {
                l0Var = new l0();
            }
        }
        if (l0Var != null) {
            return l0Var;
        }
        throw new IllegalArgumentException("No initializer set for given class ".concat(cls.getName()));
    }
}
