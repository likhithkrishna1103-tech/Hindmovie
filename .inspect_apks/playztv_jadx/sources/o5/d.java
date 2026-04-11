package o5;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final y5.a f9373u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f9374v = -1.0f;

    public d(List list) {
        this.f9373u = (y5.a) list.get(0);
    }

    @Override // o5.b
    public final float d() {
        return this.f9373u.a();
    }

    @Override // o5.b
    public final boolean h(float f) {
        if (this.f9374v == f) {
            return true;
        }
        this.f9374v = f;
        return false;
    }

    @Override // o5.b
    public final boolean isEmpty() {
        return false;
    }

    @Override // o5.b
    public final float j() {
        return this.f9373u.b();
    }

    @Override // o5.b
    public final y5.a k() {
        return this.f9373u;
    }

    @Override // o5.b
    public final boolean n(float f) {
        return !this.f9373u.c();
    }
}
