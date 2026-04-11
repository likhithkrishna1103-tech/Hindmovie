package df;

import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f4207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f4208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Method f4209c;

    public /* synthetic */ i(Method method, Method method2, Method method3) {
        this.f4207a = method;
        this.f4208b = method2;
        this.f4209c = method3;
    }

    public static void a() {
        if (Build.VERSION.SDK_INT >= 29) {
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }
}
