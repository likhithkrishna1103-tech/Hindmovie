package c2;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        i iVar = (i) obj;
        i iVar2 = (i) obj2;
        long j4 = iVar.A;
        long j7 = iVar2.A;
        return j4 - j7 == 0 ? iVar.compareTo(iVar2) : j4 < j7 ? -1 : 1;
    }
}
