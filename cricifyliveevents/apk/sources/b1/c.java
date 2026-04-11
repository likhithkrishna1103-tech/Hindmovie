package b1;

import android.graphics.Rect;
import java.util.Comparator;
import ka.f;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Comparator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Rect f1644v = new Rect();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Rect f1645w = new Rect();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f1646x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final f f1647y;

    public c(boolean z10, f fVar) {
        this.f1646x = z10;
        this.f1647y = fVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        this.f1647y.getClass();
        Rect rect = this.f1644v;
        ((u0.e) obj).f(rect);
        Rect rect2 = this.f1645w;
        ((u0.e) obj2).f(rect2);
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
        boolean z10 = this.f1646x;
        if (i11 < i12) {
            return z10 ? 1 : -1;
        }
        if (i11 > i12) {
            return z10 ? -1 : 1;
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
            return z10 ? 1 : -1;
        }
        if (i15 > i16) {
            return z10 ? -1 : 1;
        }
        return 0;
    }
}
