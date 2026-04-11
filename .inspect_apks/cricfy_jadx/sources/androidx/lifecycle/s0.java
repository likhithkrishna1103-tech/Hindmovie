package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class s0 implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static s0 f1194a;

    @Override // androidx.lifecycle.r0
    public o0 a(Class cls) throws InvocationTargetException {
        try {
            Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            ge.i.d(objNewInstance, "{\n                modelC…wInstance()\n            }");
            return (o0) objNewInstance;
        } catch (IllegalAccessException e9) {
            throw new RuntimeException("Cannot create an instance of " + cls, e9);
        } catch (InstantiationException e10) {
            throw new RuntimeException("Cannot create an instance of " + cls, e10);
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException("Cannot create an instance of " + cls, e11);
        }
    }

    @Override // androidx.lifecycle.r0
    public o0 b(Class cls, t1.c cVar) {
        return a(cls);
    }
}
