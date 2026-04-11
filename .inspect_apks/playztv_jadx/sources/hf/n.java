package hf;

import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n extends od.c implements RandomAccess {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final i[] f6129u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int[] f6130v;

    public n(i[] iVarArr, int[] iArr) {
        this.f6129u = iVarArr;
        this.f6130v = iArr;
    }

    @Override // od.c
    public final int b() {
        return this.f6129u.length;
    }

    @Override // od.c, java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof i) {
            return super.contains((i) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return this.f6129u[i];
    }

    @Override // od.c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof i) {
            return super.indexOf((i) obj);
        }
        return -1;
    }

    @Override // od.c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof i) {
            return super.lastIndexOf((i) obj);
        }
        return -1;
    }
}
