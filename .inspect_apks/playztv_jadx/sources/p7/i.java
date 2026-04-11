package p7;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import c2.o;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledExecutorService;
import ke.r;
import ke.x;
import o2.p;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f10266u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f10267v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f10268w;

    public /* synthetic */ i(Object obj, int i, Object obj2) {
        this.f10266u = i;
        this.f10268w = obj;
        this.f10267v = obj2;
    }

    private final void a() {
        k kVar = (k) this.f10267v;
        int i = ((l) this.f10268w).f10277a;
        synchronized (kVar) {
            l lVar = (l) kVar.f10275y.get(i);
            if (lVar != null) {
                Log.w("MessengerIpcClient", "Timing out request: " + i);
                kVar.f10275y.remove(i);
                lVar.b(new o("Timed out waiting for response", null));
                kVar.c();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        t7.h hVar;
        int i = 0;
        switch (this.f10266u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k kVar = (k) this.f10267v;
                IBinder iBinder = (IBinder) this.f10268w;
                synchronized (kVar) {
                    if (iBinder == null) {
                        kVar.a("Null service connection");
                    } else {
                        try {
                            kVar.f10273w = new p2.c(iBinder);
                            kVar.f10271u = 2;
                            ((ScheduledExecutorService) kVar.f10276z.f10285w).execute(new j(kVar, i));
                        } catch (RemoteException e10) {
                            kVar.a(e10.getMessage());
                        }
                    }
                }
                return;
            case 1:
                a();
                return;
            case 2:
                pe.g gVar = (pe.g) this.f10268w;
                r rVar = gVar.f10380x;
                while (true) {
                    try {
                        ((Runnable) this.f10267v).run();
                    } catch (Throwable th) {
                        x.h(th, rd.i.f11572u);
                    }
                    Runnable runnableK0 = gVar.k0();
                    if (runnableK0 == null) {
                        return;
                    }
                    this.f10267v = runnableK0;
                    i++;
                    if (i >= 16 && rVar.i0(gVar)) {
                        rVar.h0(gVar, this);
                        return;
                    }
                    break;
                }
                break;
            case 3:
                q7.b bVar = (q7.b) this.f10267v;
                p pVar = (p) this.f10268w;
                r7.a aVar = (r7.a) pVar.f9185v;
                s7.j jVar = (s7.j) ((s7.d) pVar.f9189z).D.get((s7.a) pVar.f9186w);
                if (jVar == null) {
                    return;
                }
                if (bVar.f11028v != 0) {
                    jVar.o(bVar, null);
                    return;
                }
                pVar.f9184u = true;
                if (aVar.m()) {
                    if (!pVar.f9184u || (hVar = (t7.h) pVar.f9187x) == null) {
                        return;
                    }
                    aVar.a(hVar, (Set) pVar.f9188y);
                    return;
                }
                try {
                    aVar.a(null, aVar.c());
                    return;
                } catch (SecurityException e11) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e11);
                    aVar.d("Failed to get service from broker.");
                    jVar.o(new q7.b(10), null);
                    return;
                }
            default:
                y0.d dVar = ((SwipeDismissBehavior) this.f10268w).f3329u;
                if (dVar == null || !dVar.g()) {
                    return;
                }
                View view = (View) this.f10267v;
                WeakHashMap weakHashMap = o0.f10475a;
                view.postOnAnimation(this);
                return;
        }
    }

    public /* synthetic */ i(k kVar, Object obj, int i) {
        this.f10266u = i;
        this.f10267v = kVar;
        this.f10268w = obj;
    }

    public i(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z2) {
        this.f10266u = 4;
        this.f10268w = swipeDismissBehavior;
        this.f10267v = view;
    }
}
