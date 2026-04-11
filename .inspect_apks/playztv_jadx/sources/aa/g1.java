package aa;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g1 extends j0 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final transient Object[] f672w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient int f673x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient int f674y;

    public g1(Object[] objArr, int i, int i10) {
        this.f672w = objArr;
        this.f673x = i;
        this.f674y = i10;
    }

    @Override // java.util.List
    public final Object get(int i) {
        q1.c.i(i, this.f674y);
        Object obj = this.f672w[(i * 2) + this.f673x];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // aa.e0
    public final boolean i() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f674y;
    }
}
