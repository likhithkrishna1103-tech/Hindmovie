package o8;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f9652g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static f0 f9653h;
    public static HandlerThread i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f9654a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f9655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile a9.k f9656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r8.a f9657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f9658e;
    public final long f;

    public f0(Context context, Looper looper) {
        k7.f fVar = new k7.f(3, this);
        this.f9655b = context.getApplicationContext();
        a9.k kVar = new a9.k(looper, fVar);
        Looper.getMainLooper();
        this.f9656c = kVar;
        this.f9657d = r8.a.b();
        this.f9658e = 5000L;
        this.f = 300000L;
    }

    public static f0 a(Context context) {
        synchronized (f9652g) {
            try {
                if (f9653h == null) {
                    f9653h = new f0(context.getApplicationContext(), context.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f9653h;
    }

    public static HandlerThread b() {
        synchronized (f9652g) {
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

    public final l8.b c(d0 d0Var, z zVar, String str, Executor executor) {
        HashMap map = this.f9654a;
        synchronized (map) {
            try {
                e0 e0Var = (e0) map.get(d0Var);
                l8.b bVarA = null;
                if (executor == null) {
                    executor = null;
                }
                if (e0Var == null) {
                    e0Var = new e0(this, d0Var);
                    e0Var.f9642v.put(zVar, zVar);
                    bVarA = e0Var.a(str, executor);
                    map.put(d0Var, e0Var);
                } else {
                    this.f9656c.removeMessages(0, d0Var);
                    if (e0Var.f9642v.containsKey(zVar)) {
                        String string = d0Var.toString();
                        StringBuilder sb = new StringBuilder(string.length() + 81);
                        sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                        sb.append(string);
                        throw new IllegalStateException(sb.toString());
                    }
                    e0Var.f9642v.put(zVar, zVar);
                    int i10 = e0Var.f9643w;
                    if (i10 == 1) {
                        zVar.onServiceConnected(e0Var.A, e0Var.f9645y);
                    } else if (i10 == 2) {
                        bVarA = e0Var.a(str, executor);
                    }
                }
                if (e0Var.f9644x) {
                    return l8.b.f7876z;
                }
                if (bVarA == null) {
                    bVarA = new l8.b(-1);
                }
                return bVarA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(String str, ServiceConnection serviceConnection, boolean z10) {
        d0 d0Var = new d0(str, z10);
        u.h(serviceConnection, "ServiceConnection must not be null");
        HashMap map = this.f9654a;
        synchronized (map) {
            try {
                e0 e0Var = (e0) map.get(d0Var);
                if (e0Var == null) {
                    String string = d0Var.toString();
                    StringBuilder sb = new StringBuilder(string.length() + 50);
                    sb.append("Nonexistent connection status for service config: ");
                    sb.append(string);
                    throw new IllegalStateException(sb.toString());
                }
                if (!e0Var.f9642v.containsKey(serviceConnection)) {
                    String string2 = d0Var.toString();
                    StringBuilder sb2 = new StringBuilder(string2.length() + 76);
                    sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                    sb2.append(string2);
                    throw new IllegalStateException(sb2.toString());
                }
                e0Var.f9642v.remove(serviceConnection);
                if (e0Var.f9642v.isEmpty()) {
                    this.f9656c.sendMessageDelayed(this.f9656c.obtainMessage(0, d0Var), this.f9658e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
