package k2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6886b;

    public q(long j4, long j7) {
        this.f6885a = j4;
        this.f6886b = j7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && q.class == obj.getClass()) {
            q qVar = (q) obj;
            if (this.f6885a == qVar.f6885a && this.f6886b == qVar.f6886b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f6885a) * 31) + ((int) this.f6886b);
    }
}
