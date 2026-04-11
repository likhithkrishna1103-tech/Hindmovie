package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q0 extends s0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static q0 f1496c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Application f1497b;

    public q0(Application application) {
        this.f1497b = application;
    }

    @Override // androidx.lifecycle.s0, androidx.lifecycle.r0
    public final o0 a(Class cls) {
        Application application = this.f1497b;
        if (application != null) {
            return c(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.s0, androidx.lifecycle.r0
    public final o0 b(Class cls, n1.c cVar) {
        if (this.f1497b != null) {
            return a(cls);
        }
        Application application = (Application) ((LinkedHashMap) cVar.f2454v).get(p0.f1494a);
        if (application != null) {
            return c(cls, application);
        }
        if (a.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
        return super.a(cls);
    }

    public final o0 c(Class cls, Application application) {
        if (!a.class.isAssignableFrom(cls)) {
            return super.a(cls);
        }
        try {
            o0 o0Var = (o0) cls.getConstructor(Application.class).newInstance(application);
            be.h.d(o0Var, "{\n                try {\n…          }\n            }");
            return o0Var;
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Cannot create an instance of " + cls, e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException("Cannot create an instance of " + cls, e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("Cannot create an instance of " + cls, e12);
        } catch (InvocationTargetException e13) {
            throw new RuntimeException("Cannot create an instance of " + cls, e13);
        }
    }
}
