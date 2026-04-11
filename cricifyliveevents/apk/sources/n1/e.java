package n1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f8605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f8606b;

    public e(long j4, long j7) {
        if (j7 == 0) {
            this.f8605a = 0L;
            this.f8606b = 1L;
        } else {
            this.f8605a = j4;
            this.f8606b = j7;
        }
    }

    public final String toString() {
        return this.f8605a + "/" + this.f8606b;
    }
}
