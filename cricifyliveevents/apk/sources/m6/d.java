package m6;

import j6.o;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements f {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f8374v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f8375w;

    public d(b bVar, b bVar2) {
        this.f8374v = bVar;
        this.f8375w = bVar2;
    }

    @Override // m6.f
    public final j6.e D0() {
        return new o(this.f8374v.D0(), this.f8375w.D0());
    }

    @Override // m6.f
    public final List U0() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // m6.f
    public final boolean Y0() {
        return this.f8374v.Y0() && this.f8375w.Y0();
    }
}
