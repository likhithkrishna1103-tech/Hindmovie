package p3;

import v1.i0;
import v1.k0;
import v1.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f9986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9987b;

    public d(int i, float f) {
        this.f9986a = f;
        this.f9987b = i;
    }

    @Override // v1.k0
    public final /* synthetic */ p a() {
        return null;
    }

    @Override // v1.k0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (this.f9986a == dVar.f9986a && this.f9987b == dVar.f9987b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.valueOf(this.f9986a).hashCode() + 527) * 31) + this.f9987b;
    }

    public final String toString() {
        return "smta: captureFrameRate=" + this.f9986a + ", svcTemporalLayerCount=" + this.f9987b;
    }

    @Override // v1.k0
    public final /* synthetic */ void c(i0 i0Var) {
    }
}
