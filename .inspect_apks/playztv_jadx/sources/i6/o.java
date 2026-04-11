package i6;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends c2.b0 {
    @Override // c2.b0
    public final void c(Object obj, Object obj2) {
        p pVar = (p) obj;
        pVar.getClass();
        ArrayDeque arrayDeque = p.f6418b;
        synchronized (arrayDeque) {
            arrayDeque.offer(pVar);
        }
    }
}
