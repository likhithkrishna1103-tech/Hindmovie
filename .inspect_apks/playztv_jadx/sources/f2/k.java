package f2;

import a2.g1;
import a2.n1;
import java.util.concurrent.CopyOnWriteArrayList;
import o2.d0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f4740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f4741c;

    public k(CopyOnWriteArrayList copyOnWriteArrayList, int i, d0 d0Var) {
        this.f4741c = copyOnWriteArrayList;
        this.f4739a = i;
        this.f4740b = d0Var;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [f2.l, java.lang.Object] */
    public final void a() {
        for (j jVar : this.f4741c) {
            s1.b0.S(jVar.f4737a, new i(this, jVar.f4738b, 2));
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [f2.l, java.lang.Object] */
    public final void b() {
        for (j jVar : this.f4741c) {
            s1.b0.S(jVar.f4737a, new i(this, jVar.f4738b, 1));
        }
    }

    public final void c(int i) {
        for (j jVar : this.f4741c) {
            s1.b0.S(jVar.f4737a, new n1(this, jVar.f4738b, i, 3));
        }
    }

    public final void d(Exception exc) {
        for (j jVar : this.f4741c) {
            s1.b0.S(jVar.f4737a, new g1(this, jVar.f4738b, exc, 3));
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [f2.l, java.lang.Object] */
    public final void e() {
        for (j jVar : this.f4741c) {
            s1.b0.S(jVar.f4737a, new i(this, jVar.f4738b, 0));
        }
    }
}
