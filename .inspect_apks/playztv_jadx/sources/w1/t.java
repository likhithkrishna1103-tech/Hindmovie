package w1;

import android.os.ConditionVariable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t extends Thread {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ ConditionVariable f13556u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ u f13557v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(u uVar, ConditionVariable conditionVariable) {
        super("ExoPlayer:SimpleCacheInit");
        this.f13557v = uVar;
        this.f13556u = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        synchronized (this.f13557v) {
            this.f13556u.open();
            u.a(this.f13557v);
            this.f13557v.f13560b.getClass();
        }
    }
}
