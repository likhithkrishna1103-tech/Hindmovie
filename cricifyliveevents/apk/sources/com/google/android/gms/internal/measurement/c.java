package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Iterator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Iterator f2335v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Iterator f2336w;

    public c(d dVar, Iterator it, Iterator it2) {
        this.f2335v = it;
        this.f2336w = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f2335v.hasNext()) {
            return true;
        }
        return this.f2336w.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Iterator it = this.f2335v;
        if (it.hasNext()) {
            return new q(((Integer) it.next()).toString());
        }
        Iterator it2 = this.f2336w;
        if (it2.hasNext()) {
            return new q((String) it2.next());
        }
        throw new NoSuchElementException();
    }
}
