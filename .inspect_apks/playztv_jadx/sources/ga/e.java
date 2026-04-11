package ga;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements s7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference f5341a = new AtomicReference();

    @Override // s7.b
    public final void a(boolean z2) {
        synchronized (g.f5344k) {
            try {
                ArrayList arrayList = new ArrayList(g.f5345l.values());
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    g gVar = (g) obj;
                    if (gVar.f5350e.get()) {
                        Log.d("FirebaseApp", "Notifying background state change listeners.");
                        Iterator it = gVar.i.iterator();
                        while (it.hasNext()) {
                            g gVar2 = ((d) it.next()).f5340a;
                            if (!z2) {
                                ((lb.d) gVar2.f5352h.get()).c();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
