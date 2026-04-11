package t7;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.internal.measurement.r0;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f12287g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static e0 f12288h;
    public static HandlerThread i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f12289a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f12290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile r0 f12291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w7.a f12292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f12293e;
    public final long f;

    public e0(Context context, Looper looper) {
        p6.f fVar = new p6.f(3, this);
        this.f12290b = context.getApplicationContext();
        r0 r0Var = new r0(looper, fVar);
        Looper.getMainLooper();
        this.f12291c = r0Var;
        this.f12292d = w7.a.b();
        this.f12293e = 5000L;
        this.f = 300000L;
    }

    public static e0 a(Context context) {
        synchronized (f12287g) {
            try {
                if (f12288h == null) {
                    f12288h = new e0(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f12288h;
    }

    public static HandlerThread b() {
        synchronized (f12287g) {
            try {
                HandlerThread handlerThread = i;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                i = handlerThread2;
                handlerThread2.start();
                return i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(String str, ServiceConnection serviceConnection, boolean z2) {
        c0 c0Var = new c0(str, z2);
        v.i(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f12289a) {
            try {
                d0 d0Var = (d0) this.f12289a.get(c0Var);
                if (d0Var == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: ".concat(c0Var.toString()));
                }
                if (!d0Var.f12259u.containsKey(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(c0Var.toString()));
                }
                d0Var.f12259u.remove(serviceConnection);
                if (d0Var.f12259u.isEmpty()) {
                    this.f12291c.sendMessageDelayed(this.f12291c.obtainMessage(0, c0Var), this.f12293e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean d(c0 c0Var, y yVar, String str, Executor executor) {
        boolean z2;
        synchronized (this.f12289a) {
            try {
                d0 d0Var = (d0) this.f12289a.get(c0Var);
                if (executor == null) {
                    executor = null;
                }
                if (d0Var == null) {
                    d0Var = new d0(this, c0Var);
                    d0Var.f12259u.put(yVar, yVar);
                    d0Var.a(str, executor);
                    this.f12289a.put(c0Var, d0Var);
                } else {
                    this.f12291c.removeMessages(0, c0Var);
                    if (d0Var.f12259u.containsKey(yVar)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(c0Var.toString()));
                    }
                    d0Var.f12259u.put(yVar, yVar);
                    int i10 = d0Var.f12260v;
                    if (i10 == 1) {
                        yVar.onServiceConnected(d0Var.f12264z, d0Var.f12262x);
                    } else if (i10 == 2) {
                        d0Var.a(str, executor);
                    }
                }
                z2 = d0Var.f12261w;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }
}
