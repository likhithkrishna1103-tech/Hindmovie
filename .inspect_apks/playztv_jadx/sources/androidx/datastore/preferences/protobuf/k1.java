package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k1 {
    public static boolean a(Object obj, i iVar) throws b0 {
        int iD = iVar.d();
        int i = iD >>> 3;
        int i10 = iD & 7;
        if (i10 == 0) {
            ((j1) obj).c(i << 3, Long.valueOf(iVar.y()));
            return true;
        }
        if (i10 == 1) {
            ((j1) obj).c((i << 3) | 1, Long.valueOf(iVar.p()));
            return true;
        }
        if (i10 == 2) {
            ((j1) obj).c((i << 3) | 2, iVar.g());
            return true;
        }
        if (i10 != 3) {
            if (i10 == 4) {
                return false;
            }
            if (i10 != 5) {
                throw b0.b();
            }
            ((j1) obj).c((i << 3) | 5, Integer.valueOf(iVar.n()));
            return true;
        }
        j1 j1VarB = j1.b();
        int i11 = i << 3;
        int i12 = i11 | 4;
        while (iVar.c() != Integer.MAX_VALUE && a(j1VarB, iVar)) {
        }
        if (i12 != iVar.d()) {
            throw new b0("Protocol message end-group tag did not match expected tag.");
        }
        j1VarB.f1075e = false;
        ((j1) obj).c(i11 | 3, j1VarB);
        return true;
    }
}
