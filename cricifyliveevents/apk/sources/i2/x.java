package i2;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f6146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f6147e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f6148g;

    public x(Context context, int i) {
        switch (i) {
            case 1:
                ge.i.e(context, "context");
                this.f6143a = context;
                this.f6145c = new Object();
                this.f6146d = new HashSet();
                Object systemService = context.getSystemService("connectivity");
                ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
                this.f6147e = connectivityManager;
                com.bumptech.glide.manager.r rVar = new com.bumptech.glide.manager.r(5, this);
                this.f = rVar;
                int i10 = Build.VERSION.SDK_INT;
                if (connectivityManager != null) {
                    NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).addTransportType(3).build();
                    com.bumptech.glide.manager.q qVar = new com.bumptech.glide.manager.q(1, this);
                    this.f6148g = qVar;
                    connectivityManager.registerNetworkCallback(networkRequestBuild, qVar);
                } else {
                    try {
                        if (i10 >= 33) {
                            context.registerReceiver(rVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 2);
                        } else {
                            context.registerReceiver(rVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        }
                        this.f6144b = true;
                    } catch (Exception unused) {
                        return;
                    }
                }
                break;
            default:
                this.f6143a = context;
                this.f6145c = c.f5977c;
                this.f6147e = g0.f6042a;
                this.f = g0.f6043b;
                break;
        }
    }

    public static final void a(x xVar) {
        synchronized (xVar.f6145c) {
            Iterator it = ((HashSet) xVar.f6146d).iterator();
            ge.i.d(it, "iterator(...)");
            while (it.hasNext()) {
                id.d dVar = ((id.c) it.next()).f6443a;
                dVar.f6444v.d(new c.d0(5, dVar));
            }
        }
    }

    public boolean b() {
        return ab.b.r(this.f6143a);
    }

    public void c() {
        synchronized (this.f6145c) {
            ((HashSet) this.f6146d).clear();
            if (this.f6144b) {
                try {
                    this.f6143a.unregisterReceiver((com.bumptech.glide.manager.r) this.f);
                } catch (Exception unused) {
                }
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f6147e;
            if (connectivityManager != null) {
                com.bumptech.glide.manager.q qVar = (com.bumptech.glide.manager.q) this.f6148g;
                if (qVar != null) {
                    connectivityManager.unregisterNetworkCallback(qVar);
                }
            }
        }
    }

    public void d(id.c cVar) {
        ge.i.e(cVar, "networkChangeListener");
        synchronized (this.f6145c) {
            ((HashSet) this.f6146d).remove(cVar);
        }
    }
}
