package r5;

import java.util.List;
import o5.i;
import o5.o;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f11519u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f11520v;

    public c(b bVar, b bVar2) {
        this.f11519u = bVar;
        this.f11520v = bVar2;
    }

    @Override // r5.e
    public final o5.e D0() {
        return new o((i) this.f11519u.D0(), (i) this.f11520v.D0());
    }

    @Override // r5.e
    public final List S0() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // r5.e
    public final boolean Y0() {
        return this.f11519u.Y0() && this.f11520v.Y0();
    }
}
