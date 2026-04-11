package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f1488a = od.j.S(Application.class, h0.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f1489b = android.support.v4.media.session.b.G(h0.class);

    public static final Constructor a(Class cls, List list) {
        be.h.e(list, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        be.h.d(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            be.h.d(parameterTypes, "constructor.parameterTypes");
            List listY = od.h.Y(parameterTypes);
            if (list.equals(listY)) {
                return constructor;
            }
            if (list.size() == listY.size() && listY.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final o0 b(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (o0) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Failed to access " + cls, e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e12.getCause());
        }
    }
}
