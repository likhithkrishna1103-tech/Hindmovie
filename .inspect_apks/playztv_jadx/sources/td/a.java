package td;

import be.h;
import df.i;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements rd.c, d, Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final rd.c f12487u;

    public a(rd.c cVar) {
        this.f12487u = cVar;
    }

    public d c() {
        rd.c cVar = this.f12487u;
        if (cVar instanceof d) {
            return (d) cVar;
        }
        return null;
    }

    @Override // rd.c
    public final void g(Object obj) {
        rd.c cVar = this;
        while (true) {
            a aVar = (a) cVar;
            rd.c cVar2 = aVar.f12487u;
            h.b(cVar2);
            try {
                obj = aVar.o(obj);
                if (obj == sd.a.f11942u) {
                    return;
                }
            } catch (Throwable th) {
                obj = i5.a.h(th);
            }
            aVar.p();
            if (!(cVar2 instanceof a)) {
                cVar2.g(obj);
                return;
            }
            cVar = cVar2;
        }
    }

    public rd.c m(Object obj, rd.c cVar) {
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public StackTraceElement n() {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        e eVar = (e) getClass().getAnnotation(e.class);
        String str = null;
        if (eVar == null) {
            return null;
        }
        int iV = eVar.v();
        if (iV > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i = iIntValue >= 0 ? eVar.l()[iIntValue] : -1;
        i iVar = f.f12492b;
        i iVar2 = f.f12491a;
        if (iVar == null) {
            try {
                i iVar3 = new i(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                f.f12492b = iVar3;
                iVar = iVar3;
            } catch (Exception unused2) {
                f.f12492b = iVar2;
                iVar = iVar2;
            }
        }
        if (iVar != iVar2 && (method = iVar.f4207a) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = iVar.f4208b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = iVar.f4209c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strC = eVar.c();
        } else {
            strC = str + '/' + eVar.c();
        }
        return new StackTraceElement(strC, eVar.m(), eVar.f(), i);
    }

    public abstract Object o(Object obj);

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Continuation at ");
        Object objN = n();
        if (objN == null) {
            objN = getClass().getName();
        }
        sb2.append(objN);
        return sb2.toString();
    }

    public void p() {
    }
}
