package z1;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Comparable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f15129w = -9223372036854775807L;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f15128v = new ArrayList();

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f15129w, ((r) obj).f15129w);
    }
}
