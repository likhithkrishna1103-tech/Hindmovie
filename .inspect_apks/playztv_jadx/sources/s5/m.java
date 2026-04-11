package s5;

import java.util.Arrays;
import java.util.List;
import l5.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11846c;

    public m(String str, List list, boolean z2) {
        this.f11844a = str;
        this.f11845b = list;
        this.f11846c = z2;
    }

    @Override // s5.b
    public final n5.c a(w wVar, l5.j jVar, t5.b bVar) {
        return new n5.d(wVar, bVar, this, jVar);
    }

    public final String toString() {
        return "ShapeGroup{name='" + this.f11844a + "' Shapes: " + Arrays.toString(this.f11845b.toArray()) + '}';
    }
}
