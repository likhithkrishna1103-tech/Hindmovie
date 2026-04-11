package f9;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements Iterator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Iterator f4408v;

    public t(u uVar) {
        this.f4408v = uVar.f4426v.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4408v.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f4408v.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
