package b7;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f1832e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActivityManager f1834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p6.d f1835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f1836d;

    static {
        f1832e = Build.VERSION.SDK_INT < 26 ? 4 : 1;
    }

    public g(Context context) {
        this.f1836d = f1832e;
        this.f1833a = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.f1834b = activityManager;
        this.f1835c = new p6.d(3, context.getResources().getDisplayMetrics());
        if (Build.VERSION.SDK_INT < 26 || !activityManager.isLowRamDevice()) {
            return;
        }
        this.f1836d = 0.0f;
    }
}
