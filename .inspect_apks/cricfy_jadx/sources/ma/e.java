package ma;

import android.os.Handler;
import android.os.Looper;
import k7.f;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements xc.b {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static e f8416w;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f8417v;

    public e() {
        this.f8417v = new Object();
        new Handler(Looper.getMainLooper(), new f(2, this));
    }

    public static e a(Object obj) {
        if (obj != null) {
            return new e(obj);
        }
        throw new NullPointerException("instance cannot be null");
    }

    public void b() {
        synchronized (this.f8417v) {
        }
    }

    @Override // qd.a
    public Object get() {
        return this.f8417v;
    }

    public e(Object obj) {
        this.f8417v = obj;
    }
}
