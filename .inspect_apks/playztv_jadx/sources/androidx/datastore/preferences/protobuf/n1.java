package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n1 extends AbstractList implements e0, RandomAccess {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final d0 f1094u;

    public n1(d0 d0Var) {
        this.f1094u = d0Var;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return (String) this.f1094u.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        m1 m1Var = new m1();
        m1Var.f1089u = this.f1094u.iterator();
        return m1Var;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        l1 l1Var = new l1();
        l1Var.f1086u = this.f1094u.listIterator(i);
        return l1Var;
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final void m(g gVar) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final Object p(int i) {
        return this.f1094u.f1030v.get(i);
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final List q() {
        return Collections.unmodifiableList(this.f1094u.f1030v);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1094u.size();
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final e0 o() {
        return this;
    }
}
