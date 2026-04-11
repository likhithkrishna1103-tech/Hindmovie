package t3;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class j extends y1.h implements d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public d f12090u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f12091v;

    @Override // t3.d
    public final int a(long j5) {
        d dVar = this.f12090u;
        dVar.getClass();
        return dVar.a(j5 - this.f12091v);
    }

    @Override // y1.h, y1.a
    public final void clear() {
        super.clear();
        this.f12090u = null;
    }

    @Override // t3.d
    public final long f(int i) {
        d dVar = this.f12090u;
        dVar.getClass();
        return dVar.f(i) + this.f12091v;
    }

    @Override // t3.d
    public final List i(long j5) {
        d dVar = this.f12090u;
        dVar.getClass();
        return dVar.i(j5 - this.f12091v);
    }

    @Override // t3.d
    public final int j() {
        d dVar = this.f12090u;
        dVar.getClass();
        return dVar.j();
    }
}
