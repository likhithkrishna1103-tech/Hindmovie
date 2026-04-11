package s1;

import android.os.Handler;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList f11717b = new ArrayList(50);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f11718a;

    public y(Handler handler) {
        this.f11718a = handler;
    }

    public static x b() {
        x xVar;
        ArrayList arrayList = f11717b;
        synchronized (arrayList) {
            try {
                xVar = arrayList.isEmpty() ? new x() : (x) arrayList.remove(arrayList.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return xVar;
    }

    public final x a(int i, Object obj) {
        x xVarB = b();
        xVarB.f11716a = this.f11718a.obtainMessage(i, obj);
        return xVarB;
    }

    public final boolean c(Runnable runnable) {
        return this.f11718a.post(runnable);
    }

    public final void d(int i) {
        d.b(i != 0);
        this.f11718a.removeMessages(i);
    }

    public final boolean e(int i) {
        return this.f11718a.sendEmptyMessage(i);
    }
}
