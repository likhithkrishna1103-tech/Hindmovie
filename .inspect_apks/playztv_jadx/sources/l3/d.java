package l3;

import p1.i0;
import p1.k0;
import p1.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f7815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7816b;

    public d(int i, float f) {
        this.f7815a = f;
        this.f7816b = i;
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
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f7815a == dVar.f7815a && this.f7816b == dVar.f7816b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.valueOf(this.f7815a).hashCode() + 527) * 31) + this.f7816b;
    }

    public final String toString() {
        return "smta: captureFrameRate=" + this.f7815a + ", svcTemporalLayerCount=" + this.f7816b;
    }

    @Override // p1.k0
    public final /* synthetic */ void a(i0 i0Var) {
    }
}
