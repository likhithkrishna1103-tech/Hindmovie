package s;

import java.util.ConcurrentModificationException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f11631a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f11632b = new Object();

    public static final void a(f fVar, int i) {
        fVar.f11624u = new int[i];
        fVar.f11625v = new Object[i];
    }

    public static final int b(f fVar, Object obj, int i) {
        int i10 = fVar.f11626w;
        if (i10 == 0) {
            return -1;
        }
        try {
            int iA = t.a.a(i10, i, fVar.f11624u);
            if (iA < 0 || be.h.a(obj, fVar.f11625v[iA])) {
                return iA;
            }
            int i11 = iA + 1;
            while (i11 < i10 && fVar.f11624u[i11] == i) {
                if (be.h.a(obj, fVar.f11625v[i11])) {
                    return i11;
                }
                i11++;
            }
            for (int i12 = iA - 1; i12 >= 0 && fVar.f11624u[i12] == i; i12--) {
                if (be.h.a(obj, fVar.f11625v[i12])) {
                    return i12;
                }
            }
            return ~i11;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }
}
