package ua;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends x0 implements Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ta.f f12373v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final x0 f12374w;

    public p(ta.f fVar, x0 x0Var) {
        this.f12373v = fVar;
        this.f12374w = x0Var;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        ta.f fVar = this.f12373v;
        return this.f12374w.compare(fVar.apply(obj), fVar.apply(obj2));
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f12373v.equals(pVar.f12373v) && this.f12374w.equals(pVar.f12374w)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f12373v, this.f12374w});
    }

    public final String toString() {
        return this.f12374w + ".onResultOf(" + this.f12373v + ")";
    }
}
