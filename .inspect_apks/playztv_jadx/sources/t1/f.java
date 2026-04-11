package t1;

import p1.i0;
import p1.k0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f12005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f12006b;

    public f(float f, float f4) {
        s1.d.a("Invalid latitude or longitude", f >= -90.0f && f <= 90.0f && f4 >= -180.0f && f4 <= 180.0f);
        this.f12005a = f;
        this.f12006b = f4;
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
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (this.f12005a == fVar.f12005a && this.f12006b == fVar.f12006b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.valueOf(this.f12006b).hashCode() + ((Float.valueOf(this.f12005a).hashCode() + 527) * 31);
    }

    public final String toString() {
        return "xyz: latitude=" + this.f12005a + ", longitude=" + this.f12006b;
    }

    @Override // p1.k0
    public final /* synthetic */ void a(i0 i0Var) {
    }
}
