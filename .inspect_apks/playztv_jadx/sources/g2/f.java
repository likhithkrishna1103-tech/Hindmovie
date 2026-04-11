package g2;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends p2.b {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List f4857x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f4858y;

    public f(long j5, List list) {
        super(0L, list.size() - 1);
        this.f4858y = j5;
        this.f4857x = list;
    }

    @Override // p2.n
    public final long b() {
        a();
        h2.j jVar = (h2.j) this.f4857x.get((int) this.f10128w);
        return this.f4858y + jVar.f5707y + jVar.f5705w;
    }

    @Override // p2.n
    public final long e() {
        a();
        return this.f4858y + ((h2.j) this.f4857x.get((int) this.f10128w)).f5707y;
    }
}
