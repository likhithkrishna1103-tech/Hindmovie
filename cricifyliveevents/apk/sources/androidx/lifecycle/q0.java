package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 extends s0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static q0 f1192c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Application f1193b;

    public q0(Application application) {
        this.f1193b = application;
    }

    @Override // androidx.lifecycle.s0, androidx.lifecycle.r0
    public final o0 a(Class cls) {
        Application application = this.f1193b;
        if (application != null) {
            return c(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.s0, androidx.lifecycle.r0
    public final o0 b(Class cls, t1.c cVar) {
        if (this.f1193b != null) {
            return a(cls);
        }
        Application application = (Application) ((LinkedHashMap) cVar.f307w).get(p0.f1190a);
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
            ge.i.d(o0Var, "{\n                try {\n…          }\n            }");
            return o0Var;
        } catch (IllegalAccessException e9) {
            throw new RuntimeException("Cannot create an instance of " + cls, e9);
        } catch (InstantiationException e10) {
            throw new RuntimeException("Cannot create an instance of " + cls, e10);
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException("Cannot create an instance of " + cls, e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException("Cannot create an instance of " + cls, e12);
        }
    }
}
