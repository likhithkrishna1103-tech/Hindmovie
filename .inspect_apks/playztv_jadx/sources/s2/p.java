package s2;

import android.net.Uri;
import o2.u;
import s1.b0;
import v1.c0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p implements j {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f11770u = u.f9216b.getAndIncrement();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final v1.m f11771v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f11772w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final c0 f11773x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final o f11774y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile Object f11775z;

    public p(v1.h hVar, v1.m mVar, int i, o oVar) {
        this.f11773x = new c0(hVar);
        this.f11771v = mVar;
        this.f11772w = i;
        this.f11774y = oVar;
    }

    @Override // s2.j
    public final void b() {
        this.f11773x.f13127v = 0L;
        v1.k kVar = new v1.k(this.f11773x, this.f11771v);
        try {
            kVar.a();
            Uri uriO = this.f11773x.f13126u.o();
            uriO.getClass();
            this.f11775z = this.f11774y.e(uriO, kVar);
        } finally {
            b0.g(kVar);
        }
    }

    @Override // s2.j
    public final void c() {
    }
}
