package aa;

import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i0 extends j0 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final transient int f683w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient int f684x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ j0 f685y;

    public i0(j0 j0Var, int i, int i10) {
        this.f685y = j0Var;
        this.f683w = i;
        this.f684x = i10;
    }

    @Override // aa.e0
    public final Object[] e() {
        return this.f685y.e();
    }

    @Override // aa.e0
    public final int f() {
        return this.f685y.h() + this.f683w + this.f684x;
    }

    @Override // java.util.List
    public final Object get(int i) {
        q1.c.i(i, this.f684x);
        return this.f685y.get(i + this.f683w);
    }

    @Override // aa.e0
    public final int h() {
        return this.f685y.h() + this.f683w;
    }

    @Override // aa.e0
    public final boolean i() {
        return true;
    }

    @Override // aa.j0, aa.e0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // aa.j0, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f684x;
    }

    @Override // aa.j0, java.util.List
    /* JADX INFO: renamed from: y */
    public final j0 subList(int i, int i10) {
        q1.c.l(i, i10, this.f684x);
        int i11 = this.f683w;
        return this.f685y.subList(i + i11, i10 + i11);
    }

    @Override // aa.j0, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }
}
