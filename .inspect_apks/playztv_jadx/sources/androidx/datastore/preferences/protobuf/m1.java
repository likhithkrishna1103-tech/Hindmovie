package androidx.datastore.preferences.protobuf;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m1 implements Iterator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Iterator f1089u;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1089u.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f1089u.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
