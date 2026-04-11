package w1;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        i iVar = (i) obj;
        i iVar2 = (i) obj2;
        long j5 = iVar.f13532z;
        long j8 = iVar2.f13532z;
        return j5 - j8 == 0 ? iVar.compareTo(iVar2) : j5 < j8 ? -1 : 1;
    }
}
