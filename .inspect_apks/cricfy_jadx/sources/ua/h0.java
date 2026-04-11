package ua;

import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends i0 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient int f12335x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient int f12336y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ i0 f12337z;

    public h0(i0 i0Var, int i, int i10) {
        this.f12337z = i0Var;
        this.f12335x = i;
        this.f12336y = i10;
    }

    @Override // ua.d0
    public final Object[] c() {
        return this.f12337z.c();
    }

    @Override // ua.d0
    public final int d() {
        return this.f12337z.f() + this.f12335x + this.f12336y;
    }

    @Override // ua.d0
    public final int f() {
        return this.f12337z.f() + this.f12335x;
    }

    @Override // ua.d0
    public final boolean g() {
        return true;
    }

    @Override // java.util.List
    public final Object get(int i) {
        com.bumptech.glide.d.g(i, this.f12336y);
        return this.f12337z.get(i + this.f12335x);
    }

    @Override // ua.i0, ua.d0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // ua.i0, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // ua.i0, java.util.List
    /* JADX INFO: renamed from: s */
    public final i0 subList(int i, int i10) {
        com.bumptech.glide.d.j(i, i10, this.f12336y);
        int i11 = this.f12335x;
        return this.f12337z.subList(i + i11, i10 + i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12336y;
    }

    @Override // ua.i0, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
        return listIterator(i);
    }
}
