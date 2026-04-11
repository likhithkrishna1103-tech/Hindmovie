package s5;

import l5.w;
import n5.t;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r5.b f11860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r5.b f11861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r5.b f11862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f11863e;

    public p(String str, int i, r5.b bVar, r5.b bVar2, r5.b bVar3, boolean z2) {
        this.f11859a = i;
        this.f11860b = bVar;
        this.f11861c = bVar2;
        this.f11862d = bVar3;
        this.f11863e = z2;
    }

    @Override // s5.b
    public final n5.c a(w wVar, l5.j jVar, t5.b bVar) {
        return new t(bVar, this);
    }

    public final String toString() {
        return "Trim Path: {start: " + this.f11860b + ", end: " + this.f11861c + ", offset: " + this.f11862d + "}";
    }
}
