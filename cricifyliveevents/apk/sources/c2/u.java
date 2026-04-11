package c2;

import android.os.ConditionVariable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends Thread {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ ConditionVariable f2046v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ v f2047w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(v vVar, ConditionVariable conditionVariable) {
        super("ExoPlayer:SimpleCacheInit");
        this.f2047w = vVar;
        this.f2046v = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        synchronized (this.f2047w) {
            this.f2046v.open();
            v.a(this.f2047w);
            this.f2047w.f2050b.getClass();
        }
    }
}
