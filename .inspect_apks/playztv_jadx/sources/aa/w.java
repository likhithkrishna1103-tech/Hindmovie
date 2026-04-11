package aa;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w extends y {
    public static y f(int i) {
        return i < 0 ? y.f764b : i > 0 ? y.f765c : y.f763a;
    }

    @Override // aa.y
    public final y a(int i, int i10) {
        return f(Integer.compare(i, i10));
    }

    @Override // aa.y
    public final y b(Object obj, Object obj2, Comparator comparator) {
        return f(comparator.compare(obj, obj2));
    }

    @Override // aa.y
    public final y c(boolean z2, boolean z10) {
        return f(Boolean.compare(z2, z10));
    }

    @Override // aa.y
    public final y d(boolean z2, boolean z10) {
        return f(Boolean.compare(z10, z2));
    }

    @Override // aa.y
    public final int e() {
        return 0;
    }
}
