package qe;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import ge.i;
import java.lang.reflect.InvocationTargetException;
import rd.g;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    private static volatile Choreographer choreographer;

    static {
        Object objE;
        try {
            objE = new c(a(Looper.getMainLooper()), false);
        } catch (Throwable th) {
            objE = com.bumptech.glide.c.e(th);
        }
        if (objE instanceof g) {
            objE = null;
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
        i.c(objInvoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) objInvoke;
    }
}
