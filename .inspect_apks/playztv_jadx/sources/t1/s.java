package t1;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s implements Comparable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f12064v = -9223372036854775807L;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f12063u = new ArrayList();

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f12064v, ((s) obj).f12064v);
    }
}
