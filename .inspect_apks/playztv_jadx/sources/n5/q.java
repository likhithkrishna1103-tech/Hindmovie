package n5;

import java.util.List;
import l5.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q implements o5.a, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f8798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o5.e f8799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s5.k f8800c;

    public q(w wVar, t5.b bVar, s5.j jVar) {
        this.f8798a = wVar;
        o5.e eVarD0 = jVar.f11835a.D0();
        this.f8799b = eVarD0;
        bVar.d(eVarD0);
        eVarD0.a(this);
    }

    public static int d(int i, int i10) {
        int i11 = i / i10;
        if ((i ^ i10) < 0 && i11 * i10 != i) {
            i11--;
        }
        return i - (i11 * i10);
    }

    @Override // o5.a
    public final void b() {
        this.f8798a.invalidateSelf();
    }

    @Override // n5.c
    public final void c(List list, List list2) {
    }
}
