package x3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Comparable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f14300v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final byte[] f14301w;

    public j(long j4, byte[] bArr) {
        this.f14300v = j4;
        this.f14301w = bArr;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f14300v, ((j) obj).f14300v);
    }
}
