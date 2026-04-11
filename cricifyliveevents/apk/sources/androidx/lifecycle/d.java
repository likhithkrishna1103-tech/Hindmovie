package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f1152c = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1153a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f1154b = new HashMap();

    public static void b(HashMap map, c cVar, m mVar, Class cls) {
        m mVar2 = (m) map.get(cVar);
        if (mVar2 == null || mVar == mVar2) {
            if (mVar2 == null) {
                map.put(cVar, mVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + cVar.f1146b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + mVar2 + ", new value " + mVar);
    }

    public final b a(Class cls, Method[] methodArr) {
        int i;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.f1153a;
        if (superclass != null) {
            b bVarA = (b) map2.get(superclass);
            if (bVarA == null) {
                bVarA = a(superclass, null);
            }
            map.putAll(bVarA.f1144b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            b bVarA2 = (b) map2.get(cls2);
            if (bVarA2 == null) {
                bVarA2 = a(cls2, null);
            }
            for (Map.Entry entry : bVarA2.f1144b.entrySet()) {
                b(map, (c) entry.getKey(), (m) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e9) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e9);
            }
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            z zVar = (z) method.getAnnotation(z.class);
            if (zVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!s.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                m mVarValue = zVar.value();
                if (parameterTypes.length > 1) {
                    if (!m.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (mVarValue != m.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                b(map, new c(i, method), mVarValue, cls);
                z10 = true;
            }
        }
        b bVar = new b(map);
        map2.put(cls, bVar);
        this.f1154b.put(cls, Boolean.valueOf(z10));
        return bVar;
    }
}
