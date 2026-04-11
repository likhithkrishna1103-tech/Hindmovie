package z1;

import v1.i0;
import v1.k0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f15070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f15071b;

    public e(float f, float f10) {
        y1.d.a("Invalid latitude or longitude", f >= -90.0f && f <= 90.0f && f10 >= -180.0f && f10 <= 180.0f);
        this.f15070a = f;
        this.f15071b = f10;
    }

    @Override // v1.k0
    public final /* synthetic */ v1.p a() {
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
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (this.f15070a == eVar.f15070a && this.f15071b == eVar.f15071b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.valueOf(this.f15071b).hashCode() + ((Float.valueOf(this.f15070a).hashCode() + 527) * 31);
    }

    public final String toString() {
        return "xyz: latitude=" + this.f15070a + ", longitude=" + this.f15071b;
    }

    @Override // v1.k0
    public final /* synthetic */ void c(i0 i0Var) {
    }
}
