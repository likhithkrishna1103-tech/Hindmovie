package d7;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends i2.c0 {
    @Override // i2.c0
    public final void c(Object obj, Object obj2) {
        r rVar = (r) obj;
        rVar.getClass();
        ArrayDeque arrayDeque = r.f3505b;
        synchronized (arrayDeque) {
            arrayDeque.offer(rVar);
        }
    }
}
