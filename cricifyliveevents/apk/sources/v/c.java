package v;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Iterator, Map.Entry {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f12514v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f12515w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f12516x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ e f12517y;

    public c(e eVar) {
        this.f12517y = eVar;
        this.f12514v = eVar.f12542x - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f12516x) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i = this.f12515w;
        e eVar = this.f12517y;
        return ge.i.a(key, eVar.f(i)) && ge.i.a(entry.getValue(), eVar.j(this.f12515w));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.f12516x) {
            return this.f12517y.f(this.f12515w);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f12516x) {
            return this.f12517y.j(this.f12515w);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12515w < this.f12514v;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f12516x) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i = this.f12515w;
        e eVar = this.f12517y;
        Object objF = eVar.f(i);
        Object objJ = eVar.j(this.f12515w);
        return (objF == null ? 0 : objF.hashCode()) ^ (objJ != null ? objJ.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f12515w++;
        this.f12516x = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f12516x) {
            throw new IllegalStateException();
        }
        this.f12517y.h(this.f12515w);
        this.f12515w--;
        this.f12514v--;
        this.f12516x = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f12516x) {
            return this.f12517y.i(this.f12515w, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
