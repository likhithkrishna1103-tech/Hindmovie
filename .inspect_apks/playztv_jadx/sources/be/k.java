package be;

import ke.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends l implements ge.c, ae.p {
    public k(Class cls) {
        super(b.f2031u, cls, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0);
    }

    @Override // be.c
    public final ge.a c() {
        o.f2046a.getClass();
        return this;
    }

    public final void g() {
        if (this.A) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        ge.a aVarF = f();
        if (aVarF == this) {
            throw new w("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
        }
        ((k) ((ge.c) aVarF)).g();
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) {
        g();
        throw null;
    }
}
