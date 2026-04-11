package androidx.lifecycle;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f1163a = new p0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p0 f1164b = new p0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p0 f1165c = new p0();

    public static final void a(o0 o0Var, b5.e eVar, u uVar) {
        Object obj;
        ge.i.e(eVar, "registry");
        ge.i.e(uVar, "lifecycle");
        HashMap map = o0Var.f1186a;
        if (map == null) {
            obj = null;
        } else {
            synchronized (map) {
                obj = o0Var.f1186a.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
        if (savedStateHandleController == null || savedStateHandleController.f1142x) {
            return;
        }
        savedStateHandleController.b(uVar, eVar);
        n nVar = uVar.f1200c;
        if (nVar == n.f1180w || nVar.compareTo(n.f1182y) >= 0) {
            eVar.g();
        } else {
            uVar.a(new LegacySavedStateHandleController$tryToAddRecreator$1(uVar, eVar));
        }
    }

    public static h0 b(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            if (bundle2 == null) {
                return new h0();
            }
            HashMap map = new HashMap();
            for (String str : bundle2.keySet()) {
                ge.i.d(str, "key");
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
            ge.i.c(obj, "null cannot be cast to non-null type kotlin.String");
            linkedHashMap.put((String) obj, parcelableArrayList2.get(i));
        }
        return new h0(linkedHashMap);
    }

    public static final h0 c(t1.c cVar) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) cVar.f307w;
        b5.f fVar = (b5.f) linkedHashMap.get(f1163a);
        if (fVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        u0 u0Var = (u0) linkedHashMap.get(f1164b);
        if (u0Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) linkedHashMap.get(f1165c);
        String str = (String) linkedHashMap.get(p0.f1191b);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        b5.d dVarD = fVar.a().d();
        k0 k0Var = dVarD instanceof k0 ? (k0) dVarD : null;
        if (k0Var == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        LinkedHashMap linkedHashMap2 = e(u0Var).f1173d;
        h0 h0Var = (h0) linkedHashMap2.get(str);
        if (h0Var != null) {
            return h0Var;
        }
        Class[] clsArr = h0.f;
        k0Var.b();
        Bundle bundle2 = k0Var.f1170c;
        Bundle bundle3 = bundle2 != null ? bundle2.getBundle(str) : null;
        Bundle bundle4 = k0Var.f1170c;
        if (bundle4 != null) {
            bundle4.remove(str);
        }
        Bundle bundle5 = k0Var.f1170c;
        if (bundle5 != null && bundle5.isEmpty()) {
            k0Var.f1170c = null;
        }
        h0 h0VarB = b(bundle3, bundle);
        linkedHashMap2.put(str, h0VarB);
        return h0VarB;
    }

    public static final void d(b5.f fVar) {
        n nVar = fVar.f().f1200c;
        if (nVar != n.f1180w && nVar != n.f1181x) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (fVar.a().d() == null) {
            k0 k0Var = new k0(fVar.a(), (u0) fVar);
            fVar.a().f("androidx.lifecycle.internal.SavedStateHandlesProvider", k0Var);
            fVar.f().a(new SavedStateHandleAttacher(k0Var));
        }
    }

    public static final l0 e(u0 u0Var) {
        ArrayList arrayList = new ArrayList();
        Class clsA = ge.q.a(l0.class).a();
        ge.i.c(clsA, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        arrayList.add(new t1.e(clsA));
        t1.e[] eVarArr = (t1.e[]) arrayList.toArray(new t1.e[0]);
        return (l0) new androidx.emoji2.text.v(u0Var.e(), new t1.b((t1.e[]) Arrays.copyOf(eVarArr, eVarArr.length)), u0Var instanceof i ? ((i) u0Var).d() : t1.a.f11832x).s(l0.class, "androidx.lifecycle.internal.SavedStateHandlesVM");
    }
}
