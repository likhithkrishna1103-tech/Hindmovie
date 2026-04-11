package ab;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements n8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference f385a = new AtomicReference();

    @Override // n8.b
    public final void a(boolean z10) {
        synchronized (g.f388k) {
            try {
                ArrayList arrayList = new ArrayList(g.f389l.values());
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    g gVar = (g) obj;
                    if (gVar.f394e.get()) {
                        Log.d("FirebaseApp", "Notifying background state change listeners.");
                        Iterator it = gVar.i.iterator();
                        while (it.hasNext()) {
                            g gVar2 = ((d) it.next()).f384a;
                            if (!z10) {
                                ((fc.d) gVar2.f396h.get()).c();
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
