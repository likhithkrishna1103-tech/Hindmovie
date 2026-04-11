package h;

import android.app.Activity;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    public static OnBackInvokedDispatcher a(Activity activity) {
        return activity.getOnBackInvokedDispatcher();
    }

    public static OnBackInvokedCallback b(Object obj, a0 a0Var) {
        Objects.requireNonNull(a0Var);
        ea.c cVar = new ea.c(1, a0Var);
        c.d.h(obj).registerOnBackInvokedCallback(1000000, cVar);
        return cVar;
    }

    public static void c(Object obj, Object obj2) {
        c.d.h(obj).unregisterOnBackInvokedCallback(c.d.c(obj2));
    }
}
