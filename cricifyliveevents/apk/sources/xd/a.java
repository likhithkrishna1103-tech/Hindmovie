package xd;

import ge.i;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import o.a3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements vd.c, d, Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final vd.c f14482v;

    public a(vd.c cVar) {
        this.f14482v = cVar;
    }

    public d d() {
        vd.c cVar = this.f14482v;
        if (cVar instanceof d) {
            return (d) cVar;
        }
        return null;
    }

    @Override // vd.c
    public final void i(Object obj) {
        vd.c cVar = this;
        while (true) {
            a aVar = (a) cVar;
            vd.c cVar2 = aVar.f14482v;
            i.b(cVar2);
            try {
                obj = aVar.o(obj);
                if (obj == wd.a.f14143v) {
                    return;
                }
            } catch (Throwable th) {
                obj = com.bumptech.glide.c.e(th);
            }
            aVar.p();
            if (!(cVar2 instanceof a)) {
                cVar2.i(obj);
                return;
            }
            cVar = cVar2;
        }
    }

    public vd.c m(Object obj, vd.c cVar) {
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
        if (eVar == null || eVar.v() < 1) {
            return null;
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
        a3 a3Var = f.f14487b;
        a3 a3Var2 = f.f14486a;
        if (a3Var == null) {
            try {
                a3 a3Var3 = new a3(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                f.f14487b = a3Var3;
                a3Var = a3Var3;
            } catch (Exception unused2) {
                f.f14487b = a3Var2;
                a3Var = a3Var2;
            }
        }
        if (a3Var != a3Var2 && (method = a3Var.f9178a) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = a3Var.f9179b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = a3Var.f9180c;
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
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object objN = n();
        if (objN == null) {
            objN = getClass().getName();
        }
        sb.append(objN);
        return sb.toString();
    }

    public void p() {
    }
}
