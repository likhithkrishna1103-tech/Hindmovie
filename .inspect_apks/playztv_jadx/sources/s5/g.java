package s5;

import l5.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11820b;

    public g(String str, boolean z2, int i) {
        this.f11819a = i;
        this.f11820b = z2;
    }

    @Override // s5.b
    public final n5.c a(w wVar, l5.j jVar, t5.b bVar) {
        if (wVar.F) {
            return new n5.l(this);
        }
        x5.b.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("MergePaths{mode=");
        int i = this.f11819a;
        sb2.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "EXCLUDE_INTERSECTIONS" : "INTERSECT" : "SUBTRACT" : "ADD" : "MERGE");
        sb2.append('}');
        return sb2.toString();
    }
}
