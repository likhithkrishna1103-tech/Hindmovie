package k8;

import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.material.behavior.SwipeDismissBehavior;
import i2.q;
import java.util.Set;
import pe.q0;
import pe.s;
import pe.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7265v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f7266w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f7267x;

    public /* synthetic */ j(int i, Object obj, Object obj2) {
        this.f7265v = i;
        this.f7266w = obj;
        this.f7267x = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o8.h hVar;
        switch (this.f7265v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k kVar = (k) this.f7266w;
                int i = ((l) this.f7267x).f7273a;
                synchronized (kVar) {
                    l lVar = (l) kVar.f7272z.get(i);
                    if (lVar != null) {
                        Log.w("MessengerIpcClient", "Timing out request: " + i);
                        kVar.f7272z.remove(i);
                        lVar.b(new q("Timed out waiting for response", null));
                        kVar.c();
                    }
                    break;
                }
                return;
            case 1:
                l8.b bVar = (l8.b) this.f7266w;
                n8.k kVar2 = (n8.k) this.f7267x;
                m8.a aVar = (m8.a) kVar2.f8885w;
                n8.i iVar = (n8.i) ((n8.d) kVar2.A).E.get((n8.a) kVar2.f8886x);
                if (iVar == null) {
                    return;
                }
                if (bVar.f7878w != 0) {
                    iVar.o(bVar, null);
                    return;
                }
                kVar2.f8884v = true;
                if (aVar.j()) {
                    if (!kVar2.f8884v || (hVar = (o8.h) kVar2.f8887y) == null) {
                        return;
                    }
                    aVar.n(hVar, (Set) kVar2.f8888z);
                    return;
                }
                try {
                    aVar.n(null, aVar.b());
                    return;
                } catch (SecurityException e9) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e9);
                    aVar.c("Failed to get service from broker.");
                    iVar.o(new l8.b(10), null);
                    return;
                }
            case 2:
                b1.e eVar = ((SwipeDismissBehavior) this.f7267x).f2784v;
                if (eVar == null || !eVar.g()) {
                    return;
                }
                ((View) this.f7266w).postOnAnimation(this);
                return;
            case 3:
                ((pe.h) this.f7267x).G((q0) this.f7266w);
                return;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                kf.i iVar2 = (kf.i) this.f7266w;
                Typeface typeface = (Typeface) this.f7267x;
                k0.b bVar2 = (k0.b) iVar2.f7483w;
                if (bVar2 != null) {
                    bVar2.i(typeface);
                    return;
                }
                return;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                ((q0.f) this.f7266w).accept(this.f7267x);
                return;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                ((pe.h) this.f7266w).G((qe.c) this.f7267x);
                return;
            default:
                ue.g gVar = (ue.g) this.f7267x;
                s sVar = gVar.f12467y;
                int i10 = 0;
                while (true) {
                    try {
                        ((Runnable) this.f7266w).run();
                    } catch (Throwable th) {
                        x.i(th, vd.i.f13722v);
                    }
                    Runnable runnableK0 = gVar.k0();
                    if (runnableK0 == null) {
                        return;
                    }
                    this.f7266w = runnableK0;
                    i10++;
                    if (i10 >= 16 && sVar.i0(gVar)) {
                        sVar.h0(gVar, this);
                        return;
                    }
                    break;
                }
                break;
        }
    }

    public /* synthetic */ j(int i, Object obj, Object obj2, boolean z10) {
        this.f7265v = i;
        this.f7267x = obj;
        this.f7266w = obj2;
    }

    public j(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z10) {
        this.f7265v = 2;
        this.f7267x = swipeDismissBehavior;
        this.f7266w = view;
    }
}
