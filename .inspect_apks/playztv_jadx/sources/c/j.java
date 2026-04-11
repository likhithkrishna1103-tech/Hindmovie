package c;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements ViewTreeObserver.OnDrawListener, Runnable, Executor {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f2171u = SystemClock.uptimeMillis() + ((long) 10000);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Runnable f2172v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2173w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ h.j f2174x;

    public j(h.j jVar) {
        this.f2174x = jVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        be.h.e(runnable, "runnable");
        this.f2172v = runnable;
        View decorView = this.f2174x.getWindow().getDecorView();
        be.h.d(decorView, "getDecorView(...)");
        if (!this.f2173w) {
            decorView.postOnAnimation(new a2.a(7, this));
        } else if (be.h.a(Looper.myLooper(), Looper.getMainLooper())) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z2;
        Runnable runnable = this.f2172v;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.f2171u) {
                this.f2173w = false;
                this.f2174x.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.f2172v = null;
        v vVar = (v) this.f2174x.A.getValue();
        synchronized (vVar.f2196a) {
            z2 = vVar.f2197b;
        }
        if (z2) {
            this.f2173w = false;
            this.f2174x.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2174x.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
