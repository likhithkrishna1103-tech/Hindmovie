package t2;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements l {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f11835v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f11836w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f11837x;

    public b(long j4, long j7) {
        this.f11835v = j4;
        this.f11836w = j7;
        this.f11837x = j4 - 1;
    }

    public final void a() {
        long j4 = this.f11837x;
        if (j4 < this.f11835v || j4 > this.f11836w) {
            throw new NoSuchElementException();
        }
    }

    @Override // t2.l
    public final boolean next() {
        long j4 = this.f11837x + 1;
        this.f11837x = j4;
        return !(j4 > this.f11836w);
    }
}
