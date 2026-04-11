package aa;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Iterator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Iterator f637u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f638v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Collection f639w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Iterator f640x = q0.f730u;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ x0 f641y;

    public a(x0 x0Var) {
        this.f641y = x0Var;
        this.f637u = x0Var.f760x.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f637u.hasNext() || this.f640x.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f640x.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f637u.next();
            this.f638v = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.f639w = collection;
            this.f640x = collection.iterator();
        }
        return this.f640x.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f640x.remove();
        Collection collection = this.f639w;
        Objects.requireNonNull(collection);
        if (collection.isEmpty()) {
            this.f637u.remove();
        }
        x0 x0Var = this.f641y;
        x0Var.f761y--;
    }
}
