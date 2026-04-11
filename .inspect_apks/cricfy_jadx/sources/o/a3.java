package o;

import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f9178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f9179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Method f9180c;

    public a3(Method method, Method method2, Method method3) {
        this.f9178a = method;
        this.f9179b = method2;
        this.f9180c = method3;
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 29) {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }
}
