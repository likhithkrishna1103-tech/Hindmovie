package ea;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class l {
    public static /* synthetic */ boolean a(Unsafe unsafe, p pVar, long j5, Object obj, Object obj2) {
        while (!unsafe.compareAndSwapObject(pVar, j5, obj, obj2)) {
            if (unsafe.getObject(pVar, j5) != obj) {
                return false;
            }
        }
        return true;
    }
}
