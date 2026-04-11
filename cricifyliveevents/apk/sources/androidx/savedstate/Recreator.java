package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.i0;
import androidx.lifecycle.m;
import androidx.lifecycle.o0;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import b5.c;
import b5.e;
import b5.f;
import ge.i;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import q4.a;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class Recreator implements q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f1472v;

    public Recreator(f fVar) {
        this.f1472v = fVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        if (mVar != m.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        sVar.f().f(this);
        f fVar = this.f1472v;
        Bundle bundleC = fVar.a().c("androidx.savedstate.Restarter");
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
                Class<? extends U> clsAsSubclass = Class.forName(str2, false, Recreator.class.getClassLoader()).asSubclass(c.class);
                i.d(clsAsSubclass, "{\n                Class.…class.java)\n            }");
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object objNewInstance = declaredConstructor.newInstance(null);
                        i.d(objNewInstance, "{\n                constr…wInstance()\n            }");
                        if (!(fVar instanceof u0)) {
                            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
                        }
                        t0 t0VarE = ((u0) fVar).e();
                        e eVarA = fVar.a();
                        t0VarE.getClass();
                        LinkedHashMap linkedHashMap = t0VarE.f1197a;
                        for (String str3 : new HashSet(linkedHashMap.keySet())) {
                            i.e(str3, "key");
                            o0 o0Var = (o0) linkedHashMap.get(str3);
                            i.b(o0Var);
                            i0.a(o0Var, eVarA, fVar.f());
                        }
                        if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                            eVarA.g();
                        }
                    } catch (Exception e9) {
                        throw new RuntimeException(a.n("Failed to instantiate ", str2), e9);
                    }
                } catch (NoSuchMethodException e10) {
                    throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
                }
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException(l0.e.k("Class ", str2, " wasn't found"), e11);
            }
        }
    }
}
