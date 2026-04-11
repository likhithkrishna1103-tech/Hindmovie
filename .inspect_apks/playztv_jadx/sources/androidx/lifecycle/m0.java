package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m0 implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f1477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q0 f1478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f1479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f1480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n.s f1481e;

    public m0(Application application, x4.d dVar, Bundle bundle) {
        q0 q0Var;
        this.f1481e = dVar.a();
        this.f1480d = dVar.f();
        this.f1479c = bundle;
        this.f1477a = application;
        if (application != null) {
            if (q0.f1496c == null) {
                q0.f1496c = new q0(application);
            }
            q0Var = q0.f1496c;
            be.h.b(q0Var);
        } else {
            q0Var = new q0(null);
        }
        this.f1478b = q0Var;
    }

    @Override // androidx.lifecycle.r0
    public final o0 a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return c(cls, canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.r0
    public final o0 b(Class cls, n1.c cVar) {
        p0 p0Var = p0.f1495b;
        LinkedHashMap linkedHashMap = (LinkedHashMap) cVar.f2454v;
        String str = (String) linkedHashMap.get(p0Var);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (linkedHashMap.get(i0.f1466a) == null || linkedHashMap.get(i0.f1467b) == null) {
            if (this.f1480d != null) {
                return c(cls, str);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) linkedHashMap.get(p0.f1494a);
        boolean zIsAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? n0.a(cls, n0.f1489b) : n0.a(cls, n0.f1488a);
        return constructorA == null ? this.f1478b.b(cls, cVar) : (!zIsAssignableFrom || application == null) ? n0.b(cls, constructorA, i0.c(cVar)) : n0.b(cls, constructorA, application, i0.c(cVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final o0 c(Class cls, String str) {
        Object obj;
        Application application;
        u uVar = this.f1480d;
        if (uVar == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || this.f1477a == null) ? n0.a(cls, n0.f1489b) : n0.a(cls, n0.f1488a);
        if (constructorA == null) {
            if (this.f1477a != null) {
                return this.f1478b.a(cls);
            }
            if (s0.f1498a == null) {
                s0.f1498a = new s0();
            }
            s0 s0Var = s0.f1498a;
            be.h.b(s0Var);
            return s0Var.a(cls);
        }
        n.s sVar = this.f1481e;
        be.h.b(sVar);
        Bundle bundle = this.f1479c;
        Bundle bundleC = sVar.c(str);
        Class[] clsArr = h0.f;
        h0 h0VarB = i0.b(bundleC, bundle);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, h0VarB);
        savedStateHandleController.b(uVar, sVar);
        n nVar = uVar.f1504c;
        if (nVar == n.f1483v || nVar.compareTo(n.f1485x) >= 0) {
            sVar.g();
        } else {
            uVar.a(new LegacySavedStateHandleController$tryToAddRecreator$1(uVar, sVar));
        }
        o0 o0VarB = (!zIsAssignableFrom || (application = this.f1477a) == null) ? n0.b(cls, constructorA, h0VarB) : n0.b(cls, constructorA, application, h0VarB);
        synchronized (o0VarB.f1490a) {
            try {
                obj = o0VarB.f1490a.get("androidx.lifecycle.savedstate.vm.tag");
                if (obj == null) {
                    o0VarB.f1490a.put("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            savedStateHandleController = obj;
        }
        if (o0VarB.f1492c) {
            o0.a(savedStateHandleController);
        }
        return o0VarB;
    }
}
