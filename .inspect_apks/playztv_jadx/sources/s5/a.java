package s5;

import l5.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r5.e f11791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r5.a f11792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f11794e;

    public a(String str, r5.e eVar, r5.a aVar, boolean z2, boolean z10) {
        this.f11790a = str;
        this.f11791b = eVar;
        this.f11792c = aVar;
        this.f11793d = z2;
        this.f11794e = z10;
    }

    @Override // s5.b
    public final n5.c a(w wVar, l5.j jVar, t5.b bVar) {
        return new n5.f(wVar, bVar, this);
    }
}
