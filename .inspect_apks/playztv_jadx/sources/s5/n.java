package s5;

import l5.w;
import n5.r;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r5.a f11849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11850d;

    public n(String str, int i, r5.a aVar, boolean z2) {
        this.f11847a = str;
        this.f11848b = i;
        this.f11849c = aVar;
        this.f11850d = z2;
    }

    @Override // s5.b
    public final n5.c a(w wVar, l5.j jVar, t5.b bVar) {
        return new r(wVar, bVar, this);
    }

    public final String toString() {
        return "ShapePath{name=" + this.f11847a + ", index=" + this.f11848b + '}';
    }
}
