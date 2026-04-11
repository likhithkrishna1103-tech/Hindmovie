package o5;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List f9369u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public y5.a f9371w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f9372x = -1.0f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public y5.a f9370v = a(0.0f);

    public c(List list) {
        this.f9369u = list;
    }

    public final y5.a a(float f) {
        List list = this.f9369u;
        y5.a aVar = (y5.a) list.get(list.size() - 1);
        if (f >= aVar.b()) {
            return aVar;
        }
        for (int size = list.size() - 2; size >= 1; size--) {
            y5.a aVar2 = (y5.a) list.get(size);
            if (this.f9370v != aVar2 && f >= aVar2.b() && f < aVar2.a()) {
                return aVar2;
            }
        }
        return (y5.a) list.get(0);
    }

    @Override // o5.b
    public final float d() {
        return ((y5.a) this.f9369u.get(r0.size() - 1)).a();
    }

    @Override // o5.b
    public final boolean h(float f) {
        y5.a aVar = this.f9371w;
        y5.a aVar2 = this.f9370v;
        if (aVar == aVar2 && this.f9372x == f) {
            return true;
        }
        this.f9371w = aVar2;
        this.f9372x = f;
        return false;
    }

    @Override // o5.b
    public final boolean isEmpty() {
        return false;
    }

    @Override // o5.b
    public final float j() {
        return ((y5.a) this.f9369u.get(0)).b();
    }

    @Override // o5.b
    public final y5.a k() {
        return this.f9370v;
    }

    @Override // o5.b
    public final boolean n(float f) {
        y5.a aVar = this.f9370v;
        if (f >= aVar.b() && f < aVar.a()) {
            return !this.f9370v.c();
        }
        this.f9370v = a(f);
        return true;
    }
}
