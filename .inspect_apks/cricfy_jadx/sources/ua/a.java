package ua;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Iterator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Iterator f12296v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f12297w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Collection f12298x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Iterator f12299y = o0.f12371v;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ v0 f12300z;

    public a(v0 v0Var) {
        this.f12300z = v0Var;
        this.f12296v = v0Var.f12401y.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12296v.hasNext() || this.f12299y.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f12299y.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f12296v.next();
            this.f12297w = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.f12298x = collection;
            this.f12299y = collection.iterator();
        }
        return this.f12299y.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f12299y.remove();
        Collection collection = this.f12298x;
        Objects.requireNonNull(collection);
        if (collection.isEmpty()) {
            this.f12296v.remove();
        }
        v0 v0Var = this.f12300z;
        v0Var.f12402z--;
    }
}
