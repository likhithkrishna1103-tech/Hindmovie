package c2;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f2414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f2415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f2416e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f2417g;

    public x(Context context, int i) {
        switch (i) {
            case 1:
                be.h.e(context, "context");
                this.f2412a = context;
                this.f2414c = new Object();
                this.f2415d = new HashSet();
                Object systemService = context.getSystemService("connectivity");
                ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
                this.f2416e = connectivityManager;
                e eVar = new e(3, this);
                this.f = eVar;
                int i10 = Build.VERSION.SDK_INT;
                if (connectivityManager != null) {
                    NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(0).addTransportType(1).addTransportType(3).build();
                    com.bumptech.glide.manager.p pVar = new com.bumptech.glide.manager.p(1, this);
                    this.f2417g = pVar;
                    connectivityManager.registerNetworkCallback(networkRequestBuild, pVar);
                } else {
                    try {
                        if (i10 >= 33) {
                            context.registerReceiver(eVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 2);
                        } else {
                            context.registerReceiver(eVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        }
                        this.f2413b = true;
                    } catch (Exception unused) {
                        return;
                    }
                }
                break;
            default:
                this.f2412a = context;
                this.f2414c = b.f2243c;
                this.f2416e = f0.f2307a;
                this.f = f0.f2308b;
                break;
        }
    }

    public static final void a(x xVar) {
        synchronized (xVar.f2414c) {
            Iterator it = ((HashSet) xVar.f2415d).iterator();
            be.h.d(it, "iterator(...)");
            while (it.hasNext()) {
                ed.d dVar = ((ed.c) it.next()).f4680a;
                dVar.f4681u.d(new a5.e(4, dVar));
            }
        }
    }

    public boolean b() {
        return a.a.A(this.f2412a);
    }

    public void c() {
        synchronized (this.f2414c) {
            ((HashSet) this.f2415d).clear();
            if (this.f2413b) {
                try {
                    this.f2412a.unregisterReceiver((e) this.f);
                } catch (Exception unused) {
                }
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f2416e;
            if (connectivityManager != null) {
                com.bumptech.glide.manager.p pVar = (com.bumptech.glide.manager.p) this.f2417g;
                if (pVar != null) {
                    connectivityManager.unregisterNetworkCallback(pVar);
                }
            }
        }
    }

    public void d(ed.c cVar) {
        be.h.e(cVar, "networkChangeListener");
        synchronized (this.f2414c) {
            ((HashSet) this.f2415d).remove(cVar);
        }
    }
}
