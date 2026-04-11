package r2;

import aa.y;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Comparable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f11317u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f11318v;

    public g(p1.q qVar, int i) {
        this.f11317u = (qVar.f10016e & 1) != 0;
        this.f11318v = l4.a.h(i, false);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        g gVar = (g) obj;
        return y.f763a.c(this.f11318v, gVar.f11318v).c(this.f11317u, gVar.f11317u).e();
    }
}
