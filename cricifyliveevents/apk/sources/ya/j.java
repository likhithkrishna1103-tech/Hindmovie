package ya;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class j {
    public static /* synthetic */ boolean a(Unsafe unsafe, o oVar, long j4, c cVar, c cVar2) {
        while (!unsafe.compareAndSwapObject(oVar, j4, cVar, cVar2)) {
            if (unsafe.getObject(oVar, j4) != cVar) {
                return false;
            }
        }
        return true;
    }
}
