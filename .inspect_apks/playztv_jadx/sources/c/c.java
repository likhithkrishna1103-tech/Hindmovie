package c;

import android.os.Build;
import android.window.BackEvent;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f2152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f2153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f2155e;

    public c(BackEvent backEvent) {
        be.h.e(backEvent, "backEvent");
        float touchX = backEvent.getTouchX();
        float touchY = backEvent.getTouchY();
        float progress = backEvent.getProgress();
        int swipeEdge = backEvent.getSwipeEdge();
        long frameTimeMillis = Build.VERSION.SDK_INT >= 36 ? backEvent.getFrameTimeMillis() : 0L;
        this.f2151a = touchX;
        this.f2152b = touchY;
        this.f2153c = progress;
        this.f2154d = swipeEdge;
        this.f2155e = frameTimeMillis;
    }

    public final String toString() {
        return "BackEventCompat(touchX=" + this.f2151a + ", touchY=" + this.f2152b + ", progress=" + this.f2153c + ", swipeEdge=" + this.f2154d + ", frameTimeMillis=" + this.f2155e + ')';
    }
}
