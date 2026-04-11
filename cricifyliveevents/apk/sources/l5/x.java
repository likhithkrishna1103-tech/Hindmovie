package l5;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f7832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f7833b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f7832a = new d0();
        } else {
            f7832a = new c0();
        }
        f7833b = new b(Float.class, "translationAlpha", 5);
        new b(Rect.class, "clipBounds", 6);
    }

    public static void a(View view, int i, int i10, int i11, int i12) {
        f7832a.R(view, i, i10, i11, i12);
    }

    public static void b(View view, int i) {
        f7832a.M(view, i);
    }
}
