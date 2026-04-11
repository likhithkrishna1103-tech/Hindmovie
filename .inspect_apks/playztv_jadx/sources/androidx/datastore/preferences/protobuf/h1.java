package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h1 implements Iterator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1060u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1061v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Iterator f1062w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ d1 f1063x;

    public h1(d1 d1Var) {
        this.f1063x = d1Var;
    }

    public final Iterator a() {
        if (this.f1062w == null) {
            this.f1062w = this.f1063x.f1033w.entrySet().iterator();
        }
        return this.f1062w;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.f1060u + 1;
        d1 d1Var = this.f1063x;
        return i < d1Var.f1032v.size() || (!d1Var.f1033w.isEmpty() && a().hasNext());
    }

    @Override // java.util.Iterator
    public final Object next() {
        this.f1061v = true;
        int i = this.f1060u + 1;
        this.f1060u = i;
        d1 d1Var = this.f1063x;
        return i < d1Var.f1032v.size() ? (Map.Entry) d1Var.f1032v.get(this.f1060u) : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f1061v) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f1061v = false;
        int i = d1.A;
        d1 d1Var = this.f1063x;
        d1Var.b();
        if (this.f1060u >= d1Var.f1032v.size()) {
            a().remove();
            return;
        }
        int i10 = this.f1060u;
        this.f1060u = i10 - 1;
        d1Var.g(i10);
    }
}
