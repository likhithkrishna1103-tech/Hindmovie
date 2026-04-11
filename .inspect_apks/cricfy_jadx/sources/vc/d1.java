package vc;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 {
    public static final c1 Companion = new c1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13604c;

    public /* synthetic */ d1(int i, long j4, long j7, long j10) {
        if (1 != (i & 1)) {
            df.k.a(i, 1, b1.f13580a.d());
            throw null;
        }
        this.f13602a = j4;
        this.f13603b = (i & 2) == 0 ? ((long) 1000) * j4 : j7;
        if ((i & 4) == 0) {
            this.f13604c = j4 / ((long) 1000);
        } else {
            this.f13604c = j10;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d1) && this.f13602a == ((d1) obj).f13602a;
    }

    public final int hashCode() {
        long j4 = this.f13602a;
        return (int) (j4 ^ (j4 >>> 32));
    }

    public final String toString() {
        return "Time(ms=" + this.f13602a + ')';
    }

    public d1(long j4) {
        this.f13602a = j4;
        long j7 = 1000;
        this.f13603b = j4 * j7;
        this.f13604c = j4 / j7;
    }
}
