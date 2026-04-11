package g4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Comparable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f5009v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f5010w;

    public g(int i, b bVar) {
        this.f5009v = i;
        this.f5010w = bVar;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Integer.compare(this.f5009v, ((g) obj).f5009v);
    }
}
