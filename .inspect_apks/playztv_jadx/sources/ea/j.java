package ea;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class j {
    public static /* synthetic */ boolean a(Unsafe unsafe, p pVar, long j5, o oVar, o oVar2) {
        while (!unsafe.compareAndSwapObject(pVar, j5, oVar, oVar2)) {
            if (unsafe.getObject(pVar, j5) != oVar) {
                return false;
            }
        }
        return true;
    }
}
