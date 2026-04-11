package l3;

import p1.i0;
import p1.k0;
import p1.q;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f7806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f7807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f7808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f7809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f7810e;

    public a(long j5, long j8, long j10, long j11, long j12) {
        this.f7806a = j5;
        this.f7807b = j8;
        this.f7808c = j10;
        this.f7809d = j11;
        this.f7810e = j12;
    }

    @Override // p1.k0
    public final /* synthetic */ q b() {
        return null;
    }

    @Override // p1.k0
    public final /* synthetic */ byte[] c() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f7806a == aVar.f7806a && this.f7807b == aVar.f7807b && this.f7808c == aVar.f7808c && this.f7809d == aVar.f7809d && this.f7810e == aVar.f7810e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return t1.r(this.f7810e) + ((t1.r(this.f7809d) + ((t1.r(this.f7808c) + ((t1.r(this.f7807b) + ((t1.r(this.f7806a) + 527) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f7806a + ", photoSize=" + this.f7807b + ", photoPresentationTimestampUs=" + this.f7808c + ", videoStartPosition=" + this.f7809d + ", videoSize=" + this.f7810e;
    }

    @Override // p1.k0
    public final /* synthetic */ void a(i0 i0Var) {
    }
}
