package t1;

import p1.i0;
import p1.k0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11998a;

    public b(int i) {
        this.f11998a = i;
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
        return (obj instanceof b) && this.f11998a == ((b) obj).f11998a;
    }

    public final int hashCode() {
        return this.f11998a;
    }

    public final String toString() {
        return "Mp4AlternateGroup: " + this.f11998a;
    }

    @Override // p1.k0
    public final /* synthetic */ void a(i0 i0Var) {
    }
}
