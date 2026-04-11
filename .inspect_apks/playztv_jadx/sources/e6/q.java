package e6;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q implements Iterable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f4551u;

    public q(ArrayList arrayList) {
        this.f4551u = arrayList;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f4551u.iterator();
    }
}
