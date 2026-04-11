package androidx.lifecycle;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f1466a = new p0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p0 f1467b = new p0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p0 f1468c = new p0();

    public static final void a(o0 o0Var, n.s sVar, u uVar) {
        Object obj;
        be.h.e(sVar, "registry");
        be.h.e(uVar, "lifecycle");
        HashMap map = o0Var.f1490a;
        if (map == null) {
            obj = null;
        } else {
            synchronized (map) {
                obj = o0Var.f1490a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
        if (savedStateHandleController == null || savedStateHandleController.f1444w) {
            return;
        }
        savedStateHandleController.b(uVar, sVar);
        n nVar = uVar.f1504c;
        if (nVar == n.f1483v || nVar.compareTo(n.f1485x) >= 0) {
            sVar.g();
        } else {
            uVar.a(new LegacySavedStateHandleController$tryToAddRecreator$1(uVar, sVar));
        }
    }

    public static h0 b(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            if (bundle2 == null) {
                return new h0();
            }
            HashMap map = new HashMap();
            for (String str : bundle2.keySet()) {
                be.h.d(str, "key");
                map.put(str, bundle2.get(str));
            }
            return new h0(map);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = parcelableArrayList.size();
        for (int i = 0; i < size; i++) {
            Object obj = parcelableArrayList.get(i);
            be.h.c(obj, "null cannot be cast to non-null type kotlin.String");
            linkedHashMap.put((String) obj, parcelableArrayList2.get(i));
        }
        return new h0(linkedHashMap);
    }

    public static final h0 c(n1.c cVar) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) cVar.f2454v;
        x4.d dVar = (x4.d) linkedHashMap.get(f1466a);
        if (dVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        u0 u0Var = (u0) linkedHashMap.get(f1467b);
        if (u0Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) linkedHashMap.get(f1468c);
        String str = (String) linkedHashMap.get(p0.f1495b);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        x4.c cVarD = dVar.a().d();
        k0 k0Var = cVarD instanceof k0 ? (k0) cVarD : null;
        if (k0Var == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        LinkedHashMap linkedHashMap2 = e(u0Var).f1476d;
        h0 h0Var = (h0) linkedHashMap2.get(str);
        if (h0Var != null) {
            return h0Var;
        }
        Class[] clsArr = h0.f;
        k0Var.b();
        Bundle bundle2 = k0Var.f1473c;
        Bundle bundle3 = bundle2 != null ? bundle2.getBundle(str) : null;
        Bundle bundle4 = k0Var.f1473c;
        if (bundle4 != null) {
            bundle4.remove(str);
        }
        Bundle bundle5 = k0Var.f1473c;
        if (bundle5 != null && bundle5.isEmpty()) {
            k0Var.f1473c = null;
        }
        h0 h0VarB = b(bundle3, bundle);
        linkedHashMap2.put(str, h0VarB);
        return h0VarB;
    }

    public static final void d(x4.d dVar) {
        n nVar = dVar.f().f1504c;
        if (nVar != n.f1483v && nVar != n.f1484w) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (dVar.a().d() == null) {
            k0 k0Var = new k0(dVar.a(), (u0) dVar);
            dVar.a().f("androidx.lifecycle.internal.SavedStateHandlesProvider", k0Var);
            dVar.f().a(new SavedStateHandleAttacher(k0Var));
        }
    }

    public static final l0 e(u0 u0Var) {
        ArrayList arrayList = new ArrayList();
        Class clsA = be.o.a(l0.class).a();
        be.h.c(clsA, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        arrayList.add(new n1.e(clsA));
        n1.e[] eVarArr = (n1.e[]) arrayList.toArray(new n1.e[0]);
        return (l0) new a7.b(u0Var.e(), new n1.b((n1.e[]) Arrays.copyOf(eVarArr, eVarArr.length)), u0Var instanceof i ? ((i) u0Var).d() : n1.a.f8635w).t(l0.class, "androidx.lifecycle.internal.SavedStateHandlesVM");
    }
}
