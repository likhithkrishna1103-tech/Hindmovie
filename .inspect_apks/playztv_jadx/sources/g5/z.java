package g5;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f5317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f5318b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f5317a = new f0();
        } else {
            f5317a = new e0();
        }
        f5318b = new b(Float.class, "translationAlpha", 5);
        new b(Rect.class, "clipBounds", 6);
    }

    public static void a(View view, int i, int i10, int i11, int i12) {
        f5317a.z(view, i, i10, i11, i12);
    }

    public static void b(View view, int i) {
        f5317a.y(view, i);
    }
}
