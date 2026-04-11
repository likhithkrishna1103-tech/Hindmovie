package ya;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class i {
    public static /* synthetic */ boolean a(Unsafe unsafe, o oVar, long j4, n nVar, n nVar2) {
        while (!unsafe.compareAndSwapObject(oVar, j4, nVar, nVar2)) {
            if (unsafe.getObject(oVar, j4) != nVar) {
                return false;
            }
        }
        return true;
    }
}
