package ua;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m1 implements Iterator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Iterator f12360v;

    public m1(Iterator it) {
        it.getClass();
        this.f12360v = it;
    }

    public abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12360v.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f12360v.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f12360v.remove();
    }
}
