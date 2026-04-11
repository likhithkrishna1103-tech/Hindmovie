package ua;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends y {
    public static y f(int i) {
        return i < 0 ? y.f12408b : i > 0 ? y.f12409c : y.f12407a;
    }

    @Override // ua.y
    public final y a(int i, int i10) {
        return f(Integer.compare(i, i10));
    }

    @Override // ua.y
    public final y b(Object obj, Object obj2, Comparator comparator) {
        return f(comparator.compare(obj, obj2));
    }

    @Override // ua.y
    public final y c(boolean z10, boolean z11) {
        return f(Boolean.compare(z10, z11));
    }

    @Override // ua.y
    public final y d(boolean z10, boolean z11) {
        return f(Boolean.compare(z11, z10));
    }

    @Override // ua.y
    public final int e() {
        return 0;
    }
}
