package s;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Iterator, Map.Entry {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f11616u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f11617v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f11618w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ e f11619x;

    public c(e eVar) {
        this.f11619x = eVar;
        this.f11616u = eVar.f11635w - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f11618w) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i = this.f11617v;
        e eVar = this.f11619x;
        return be.h.a(key, eVar.f(i)) && be.h.a(entry.getValue(), eVar.j(this.f11617v));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (this.f11618w) {
            return this.f11619x.f(this.f11617v);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f11618w) {
            return this.f11619x.j(this.f11617v);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11617v < this.f11616u;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f11618w) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i = this.f11617v;
        e eVar = this.f11619x;
        Object objF = eVar.f(i);
        Object objJ = eVar.j(this.f11617v);
        return (objF == null ? 0 : objF.hashCode()) ^ (objJ != null ? objJ.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f11617v++;
        this.f11618w = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f11618w) {
            throw new IllegalStateException();
        }
        this.f11619x.h(this.f11617v);
        this.f11617v--;
        this.f11616u--;
        this.f11618w = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (this.f11618w) {
            return this.f11619x.i(this.f11617v, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
