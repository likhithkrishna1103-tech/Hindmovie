package t1;

import p1.i0;
import p1.k0;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12009c;

    public g(long j5, long j8, long j10) {
        this.f12007a = j5;
        this.f12008b = j8;
        this.f12009c = j10;
    }

    @Override // p1.k0
    public final /* synthetic */ p1.q b() {
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
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f12007a == gVar.f12007a && this.f12008b == gVar.f12008b && this.f12009c == gVar.f12009c;
    }

    public final int hashCode() {
        return t1.r(this.f12009c) + ((t1.r(this.f12008b) + ((t1.r(this.f12007a) + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Mp4Timestamp: creation time=" + this.f12007a + ", modification time=" + this.f12008b + ", timescale=" + this.f12009c;
    }

    @Override // p1.k0
    public final /* synthetic */ void a(i0 i0Var) {
    }
}
