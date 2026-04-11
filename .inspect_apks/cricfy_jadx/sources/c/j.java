package c;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements ViewTreeObserver.OnDrawListener, Runnable, Executor {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f1960v = SystemClock.uptimeMillis() + ((long) 10000);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Runnable f1961w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1962x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ h.j f1963y;

    public j(h.j jVar) {
        this.f1963y = jVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        ge.i.e(runnable, "runnable");
        this.f1961w = runnable;
        View decorView = this.f1963y.getWindow().getDecorView();
        ge.i.d(decorView, "getDecorView(...)");
        if (!this.f1962x) {
            decorView.postOnAnimation(new androidx.emoji2.text.w(3, this));
        } else if (ge.i.a(Looper.myLooper(), Looper.getMainLooper())) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z10;
        Runnable runnable = this.f1961w;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.f1960v) {
                this.f1962x = false;
                this.f1963y.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.f1961w = null;
        w wVar = (w) this.f1963y.B.getValue();
        synchronized (wVar.f1988a) {
            z10 = wVar.f1989b;
        }
        if (z10) {
            this.f1962x = false;
            this.f1963y.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1963y.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
