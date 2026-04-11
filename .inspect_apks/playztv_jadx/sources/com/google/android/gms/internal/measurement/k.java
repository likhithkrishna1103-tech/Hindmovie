package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Iterator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ Iterator f3068u;

    public k(Iterator it) {
        this.f3068u = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3068u.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return new p((String) this.f3068u.next());
    }
}
