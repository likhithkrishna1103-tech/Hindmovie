package y1;

import android.os.Handler;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList f14617b = new ArrayList(50);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f14618a;

    public x(Handler handler) {
        this.f14618a = handler;
    }

    public static w b() {
        w wVar;
        ArrayList arrayList = f14617b;
        synchronized (arrayList) {
            try {
                wVar = arrayList.isEmpty() ? new w() : (w) arrayList.remove(arrayList.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return wVar;
    }

    public final w a(int i, Object obj) {
        w wVarB = b();
        wVarB.f14616a = this.f14618a.obtainMessage(i, obj);
        return wVarB;
    }

    public final boolean c(Runnable runnable) {
        return this.f14618a.post(runnable);
    }

    public final void d(int i) {
        d.b(i != 0);
        this.f14618a.removeMessages(i);
    }

    public final boolean e(int i) {
        return this.f14618a.sendEmptyMessage(i);
    }
}
