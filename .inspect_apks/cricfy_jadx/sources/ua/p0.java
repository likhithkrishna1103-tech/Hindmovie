package ua;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 extends n1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f12375v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12376w;

    public p0(Object obj) {
        this.f12375v = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f12376w;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f12376w) {
            throw new NoSuchElementException();
        }
        this.f12376w = true;
        return this.f12375v;
    }
}
