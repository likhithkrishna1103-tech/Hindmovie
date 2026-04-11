package androidx.navigation;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Iterator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1374v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1375w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ n f1376x;

    public m(n nVar) {
        this.f1376x = nVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f1374v + 1 < this.f1376x.D.e();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f1375w = true;
        v.l lVar = this.f1376x.D;
        int i = this.f1374v + 1;
        this.f1374v = i;
        return (l) lVar.f(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        v.l lVar = this.f1376x.D;
        if (!this.f1375w) {
            throw new IllegalStateException("You must call next() before you can remove an element");
        }
        ((l) lVar.f(this.f1374v)).f1370w = null;
        int i = this.f1374v;
        Object[] objArr = lVar.f12545x;
        Object obj = objArr[i];
        Object obj2 = v.i.f12533b;
        if (obj != obj2) {
            objArr[i] = obj2;
            lVar.f12543v = true;
        }
        this.f1374v = i - 1;
        this.f1375w = false;
    }
}
