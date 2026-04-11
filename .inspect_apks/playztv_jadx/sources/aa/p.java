package aa;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p extends a1 implements Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final z9.f f721u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a1 f722v;

    public p(z9.f fVar, a1 a1Var) {
        this.f721u = fVar;
        this.f722v = a1Var;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        z9.f fVar = this.f721u;
        return this.f722v.compare(fVar.apply(obj), fVar.apply(obj2));
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f721u.equals(pVar.f721u) && this.f722v.equals(pVar.f722v)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f721u, this.f722v});
    }

    public final String toString() {
        return this.f722v + ".onResultOf(" + this.f721u + ")";
    }
}
