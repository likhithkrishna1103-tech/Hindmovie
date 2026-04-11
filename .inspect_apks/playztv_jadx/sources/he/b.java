package he;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f6077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6078b;

    public b(e eVar, int i) {
        this.f6077a = eVar;
        this.f6078b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // he.e
    public final Iterator iterator() {
        return new be.a(this);
    }
}
