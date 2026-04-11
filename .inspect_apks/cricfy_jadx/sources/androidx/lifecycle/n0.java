package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f1184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f1185b;

    static {
        Class[] clsArr = {Application.class, h0.class};
        f1184a = clsArr.length > 0 ? sd.i.a(clsArr) : sd.p.f11669v;
        f1185b = n5.a.x(h0.class);
    }

    public static final Constructor a(Class cls, List list) {
        ge.i.e(list, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        ge.i.d(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            ge.i.d(parameterTypes, "constructor.parameterTypes");
            List listG = sd.i.G(parameterTypes);
            if (list.equals(listG)) {
                return constructor;
            }
            if (list.size() == listG.size() && listG.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final o0 b(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (o0) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e9) {
            throw new RuntimeException("Failed to access " + cls, e9);
        } catch (InstantiationException e10) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e11.getCause());
        }
    }
}
