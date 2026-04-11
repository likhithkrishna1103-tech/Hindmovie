package g6;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5323e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ActivityManager f5325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u5.d f5326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f5327d;

    static {
        f5323e = Build.VERSION.SDK_INT < 26 ? 4 : 1;
    }

    public e(Context context) {
        this.f5327d = f5323e;
        this.f5324a = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.f5325b = activityManager;
        this.f5326c = new u5.d(12, context.getResources().getDisplayMetrics());
        if (Build.VERSION.SDK_INT < 26 || !activityManager.isLowRamDevice()) {
            return;
        }
        this.f5327d = 0.0f;
    }
}
