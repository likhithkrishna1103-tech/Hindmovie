package y0;

import android.graphics.Rect;
import java.util.Comparator;
import r0.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Comparator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Rect f14432u = new Rect();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Rect f14433v = new Rect();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f14434w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ua.c f14435x;

    public c(boolean z2, ua.c cVar) {
        this.f14434w = z2;
        this.f14435x = cVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.f14435x.getClass();
        Rect rect = this.f14432u;
        ((e) obj).f(rect);
        Rect rect2 = this.f14433v;
        ((e) obj2).f(rect2);
        int i = rect.top;
        int i10 = rect2.top;
        if (i < i10) {
            return -1;
        }
        if (i > i10) {
            return 1;
        }
        int i11 = rect.left;
        int i12 = rect2.left;
        boolean z2 = this.f14434w;
        if (i11 < i12) {
            return z2 ? 1 : -1;
        }
        if (i11 > i12) {
            return z2 ? -1 : 1;
        }
        int i13 = rect.bottom;
        int i14 = rect2.bottom;
        if (i13 < i14) {
            return -1;
        }
        if (i13 > i14) {
            return 1;
        }
        int i15 = rect.right;
        int i16 = rect2.right;
        if (i15 < i16) {
            return z2 ? 1 : -1;
        }
        if (i15 > i16) {
            return z2 ? -1 : 1;
        }
        return 0;
    }
}
