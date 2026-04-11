package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.i0;
import androidx.lifecycle.m;
import androidx.lifecycle.o0;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import be.h;
import e6.j;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import l4.a;
import x4.b;
import x4.d;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class Recreator implements q {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d f1689u;

    public Recreator(d dVar) {
        this.f1689u = dVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        if (mVar != m.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        sVar.f().f(this);
        d dVar = this.f1689u;
        Bundle bundleC = dVar.a().c("androidx.savedstate.Restarter");
        if (bundleC == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleC.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        int size = stringArrayList.size();
        int i = 0;
        while (i < size) {
            String str = stringArrayList.get(i);
            i++;
            String str2 = str;
            try {
                Class<? extends U> clsAsSubclass = Class.forName(str2, false, Recreator.class.getClassLoader()).asSubclass(b.class);
                h.d(clsAsSubclass, "{\n                Class.…class.java)\n            }");
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object objNewInstance = declaredConstructor.newInstance(null);
                        h.d(objNewInstance, "{\n                constr…wInstance()\n            }");
                        if (!(dVar instanceof u0)) {
                            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
                        }
                        t0 t0VarE = ((u0) dVar).e();
                        n.s sVarA = dVar.a();
                        t0VarE.getClass();
                        LinkedHashMap linkedHashMap = t0VarE.f1501a;
                        for (String str3 : new HashSet(linkedHashMap.keySet())) {
                            h.e(str3, "key");
                            o0 o0Var = (o0) linkedHashMap.get(str3);
                            h.b(o0Var);
                            i0.a(o0Var, sVarA, dVar.f());
                        }
                        if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                            sVarA.g();
                        }
                    } catch (Exception e10) {
                        throw new RuntimeException(a.m("Failed to instantiate ", str2), e10);
                    }
                } catch (NoSuchMethodException e11) {
                    throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
                }
            } catch (ClassNotFoundException e12) {
                throw new RuntimeException(j.n("Class ", str2, " wasn't found"), e12);
            }
        }
    }
}
