package z1;

import v1.i0;
import v1.k0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15065a;

    public b(int i) {
        this.f15065a = i;
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
        return (obj instanceof b) && this.f15065a == ((b) obj).f15065a;
    }

    public final int hashCode() {
        return this.f15065a;
    }

    public final String toString() {
        return "Mp4AlternateGroup: " + this.f15065a;
    }

    @Override // v1.k0
    public final /* synthetic */ void c(i0 i0Var) {
    }
}
