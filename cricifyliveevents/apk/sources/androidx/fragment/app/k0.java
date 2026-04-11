package androidx.fragment.app;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v.k f1012b = new v.k(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r0 f1013a;

    public k0(r0 r0Var) {
        this.f1013a = r0Var;
    }

    public static Class b(ClassLoader classLoader, String str) throws ClassNotFoundException {
        v.k kVar = f1012b;
        v.k kVar2 = (v.k) kVar.get(classLoader);
        if (kVar2 == null) {
            kVar2 = new v.k(0);
            kVar.put(classLoader, kVar2);
        }
        Class cls = (Class) kVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        kVar2.put(str, cls2);
        return cls2;
    }

    public static Class c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e9) {
            throw new a9.l(l0.e.k("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e9);
        } catch (ClassNotFoundException e10) {
            throw new a9.l(l0.e.k("Unable to instantiate fragment ", str, ": make sure class name exists"), e10);
        }
    }

    public final y a(String str) {
        try {
            return (y) c(this.f1013a.f1062u.f952x.getClassLoader(), str).getConstructor(null).newInstance(null);
        } catch (IllegalAccessException e9) {
            throw new a9.l(l0.e.k("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e9);
        } catch (InstantiationException e10) {
            throw new a9.l(l0.e.k("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e10);
        } catch (NoSuchMethodException e11) {
            throw new a9.l(l0.e.k("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e11);
        } catch (InvocationTargetException e12) {
            throw new a9.l(l0.e.k("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e12);
        }
    }
}
