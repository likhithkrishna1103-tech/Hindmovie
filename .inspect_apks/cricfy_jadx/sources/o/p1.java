package o;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f9304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f9305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f9306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f9307d;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
            f9304a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f9305b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f9306c = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f9307d = true;
        } catch (NoSuchMethodException e9) {
            e9.printStackTrace();
        }
    }
}
