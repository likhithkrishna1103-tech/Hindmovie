package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Iterator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ Iterator f2924u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Iterator f2925v;

    public d(Iterator it, Iterator it2) {
        this.f2924u = it;
        this.f2925v = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f2924u.hasNext()) {
            return true;
        }
        return this.f2925v.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Iterator it = this.f2924u;
        if (it.hasNext()) {
            return new p(((Integer) it.next()).toString());
        }
        Iterator it2 = this.f2925v;
        if (it2.hasNext()) {
            return new p((String) it2.next());
        }
        throw new NoSuchElementException();
    }
}
