package c;

import android.os.Build;
import android.window.BackEvent;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f1936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f1937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f1938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1940e;

    public c(BackEvent backEvent) {
        ge.i.e(backEvent, "backEvent");
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        float progress = backEvent.getProgress();
        int swipeEdge = backEvent.getSwipeEdge();
        long frameTimeMillis = Build.VERSION.SDK_INT >= 36 ? backEvent.getFrameTimeMillis() : 0L;
        this.f1936a = touchX;
        this.f1937b = touchY;
        this.f1938c = progress;
        this.f1939d = swipeEdge;
        this.f1940e = frameTimeMillis;
    }

    public final String toString() {
        return "BackEventCompat(touchX=" + this.f1936a + ", touchY=" + this.f1937b + ", progress=" + this.f1938c + ", swipeEdge=" + this.f1939d + ", frameTimeMillis=" + this.f1940e + ')';
    }
}
