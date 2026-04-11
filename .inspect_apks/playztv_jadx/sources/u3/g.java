package u3;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends t3.i implements Comparable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f12754v;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        g gVar = (g) obj;
        if (isEndOfStream() != gVar.isEndOfStream()) {
            return isEndOfStream() ? 1 : -1;
        }
        long j5 = this.timeUs - gVar.timeUs;
        if (j5 == 0) {
            j5 = this.f12754v - gVar.f12754v;
            if (j5 == 0) {
                return 0;
            }
        }
        return j5 > 0 ? 1 : -1;
    }
}
