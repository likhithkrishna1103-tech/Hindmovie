package he;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Iterable, ce.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ d f6093u;

    public k(d dVar) {
        this.f6093u = dVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new ie.b(this.f6093u);
    }
}
