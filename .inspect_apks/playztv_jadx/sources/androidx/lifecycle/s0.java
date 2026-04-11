package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class s0 implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static s0 f1498a;

    @Override // androidx.lifecycle.r0
    public o0 a(Class cls) throws InvocationTargetException {
        try {
            Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            be.h.d(objNewInstance, "{\n                modelC…wInstance()\n            }");
            return (o0) objNewInstance;
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Cannot create an instance of " + cls, e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("Cannot create an instance of " + cls, e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("Cannot create an instance of " + cls, e12);
        }
    }

    @Override // androidx.lifecycle.r0
    public o0 b(Class cls, n1.c cVar) {
        return a(cls);
    }
}
