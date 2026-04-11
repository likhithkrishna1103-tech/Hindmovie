package n;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f8480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f8481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f8482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f8483d;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
            f8480a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f8481b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f8482c = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f8483d = true;
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
        }
    }
}
