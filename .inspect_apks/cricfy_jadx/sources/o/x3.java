package o;

import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f9408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f9409c;

    static {
        f9409c = Build.VERSION.SDK_INT >= 27;
    }
}
