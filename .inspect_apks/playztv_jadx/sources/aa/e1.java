package aa;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e1 extends o0 {
    public final transient int A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient m0 f664x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient Object[] f665y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final transient int f666z;

    public e1(m0 m0Var, Object[] objArr, int i, int i10) {
        this.f664x = m0Var;
        this.f665y = objArr;
        this.f666z = i;
        this.A = i10;
    }

    @Override // aa.e0, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f664x.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // aa.e0
    public final int d(int i, Object[] objArr) {
        return b().d(i, objArr);
    }

    @Override // aa.e0
    public final boolean i() {
        return true;
    }

    @Override // aa.e0
    /* JADX INFO: renamed from: j */
    public final q1 iterator() {
        return b().listIterator(0);
    }

    @Override // aa.o0
    public final j0 s() {
        return new d1(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.A;
    }
}
