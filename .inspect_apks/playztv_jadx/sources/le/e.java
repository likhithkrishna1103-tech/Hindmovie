package le;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import be.h;
import java.lang.reflect.InvocationTargetException;
import nd.g;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    private static volatile Choreographer choreographer;

    static {
        Object objH;
        try {
            objH = new d(a(Looper.getMainLooper()), false);
        } catch (Throwable th) {
            objH = i5.a.h(th);
        }
        if (objH instanceof g) {
            objH = null;
        }
    }

    public static final Handler a(Looper looper) throws IllegalAccessException, InvocationTargetException {
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        h.c(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }
}
