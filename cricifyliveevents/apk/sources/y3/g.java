package y3;

import x3.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends l implements Comparable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f14830w;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        g gVar = (g) obj;
        if (isEndOfStream() != gVar.isEndOfStream()) {
            return isEndOfStream() ? 1 : -1;
        }
        long j4 = this.timeUs - gVar.timeUs;
        if (j4 == 0) {
            j4 = this.f14830w - gVar.f14830w;
            if (j4 == 0) {
                return 0;
            }
        }
        return j4 > 0 ? 1 : -1;
    }
}
