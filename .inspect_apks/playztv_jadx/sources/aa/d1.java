package aa;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d1 extends j0 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ e1 f660w;

    public d1(e1 e1Var) {
        this.f660w = e1Var;
    }

    @Override // java.util.List
    public final Object get(int i) {
        e1 e1Var = this.f660w;
        q1.c.i(i, e1Var.A);
        Object[] objArr = e1Var.f665y;
        int i10 = i * 2;
        int i11 = e1Var.f666z;
        Object obj = objArr[i10 + i11];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i10 + (i11 ^ 1)];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // aa.e0
    public final boolean i() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f660w.A;
    }
}
