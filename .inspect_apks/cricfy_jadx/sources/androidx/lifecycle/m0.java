package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f1174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q0 f1175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f1176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f1177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b5.e f1178e;

    public m0(Application application, b5.f fVar, Bundle bundle) {
        q0 q0Var;
        this.f1178e = fVar.a();
        this.f1177d = fVar.f();
        this.f1176c = bundle;
        this.f1174a = application;
        if (application != null) {
            if (q0.f1192c == null) {
                q0.f1192c = new q0(application);
            }
            q0Var = q0.f1192c;
            ge.i.b(q0Var);
        } else {
            q0Var = new q0(null);
        }
        this.f1175b = q0Var;
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
    public final o0 b(Class cls, t1.c cVar) {
        p0 p0Var = p0.f1191b;
        LinkedHashMap linkedHashMap = (LinkedHashMap) cVar.f307w;
        String str = (String) linkedHashMap.get(p0Var);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (linkedHashMap.get(i0.f1163a) == null || linkedHashMap.get(i0.f1164b) == null) {
            if (this.f1177d != null) {
                return c(cls, str);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) linkedHashMap.get(p0.f1190a);
        boolean zIsAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || application == null) ? n0.a(cls, n0.f1185b) : n0.a(cls, n0.f1184a);
        return constructorA == null ? this.f1175b.b(cls, cVar) : (!zIsAssignableFrom || application == null) ? n0.b(cls, constructorA, i0.c(cVar)) : n0.b(cls, constructorA, application, i0.c(cVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final o0 c(Class cls, String str) {
        Object obj;
        Application application;
        u uVar = this.f1177d;
        if (uVar == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor constructorA = (!zIsAssignableFrom || this.f1174a == null) ? n0.a(cls, n0.f1185b) : n0.a(cls, n0.f1184a);
        if (constructorA == null) {
            if (this.f1174a != null) {
                return this.f1175b.a(cls);
            }
            if (s0.f1194a == null) {
                s0.f1194a = new s0();
            }
            s0 s0Var = s0.f1194a;
            ge.i.b(s0Var);
            return s0Var.a(cls);
        }
        b5.e eVar = this.f1178e;
        ge.i.b(eVar);
        Bundle bundle = this.f1176c;
        Bundle bundleC = eVar.c(str);
        Class[] clsArr = h0.f;
        h0 h0VarB = i0.b(bundleC, bundle);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, h0VarB);
        savedStateHandleController.b(uVar, eVar);
        n nVar = uVar.f1200c;
        if (nVar == n.f1180w || nVar.compareTo(n.f1182y) >= 0) {
            eVar.g();
        } else {
            uVar.a(new LegacySavedStateHandleController$tryToAddRecreator$1(uVar, eVar));
        }
        o0 o0VarB = (!zIsAssignableFrom || (application = this.f1174a) == null) ? n0.b(cls, constructorA, h0VarB) : n0.b(cls, constructorA, application, h0VarB);
        synchronized (o0VarB.f1186a) {
            try {
                obj = o0VarB.f1186a.get("androidx.lifecycle.savedstate.vm.tag");
                if (obj == null) {
                    o0VarB.f1186a.put("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            savedStateHandleController = obj;
        }
        if (o0VarB.f1188c) {
            o0.a(savedStateHandleController);
        }
        return o0VarB;
    }
}
