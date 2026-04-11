package s7;

import java.util.Arrays;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f11899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q7.d f11900b;

    public /* synthetic */ k(a aVar, q7.d dVar) {
        this.f11899a = aVar;
        this.f11900b = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof k)) {
            k kVar = (k) obj;
            if (v.k(this.f11899a, kVar.f11899a) && v.k(this.f11900b, kVar.f11900b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11899a, this.f11900b});
    }

    public final String toString() {
        p2.c cVar = new p2.c(this);
        cVar.b(this.f11899a, "key");
        cVar.b(this.f11900b, "feature");
        return cVar.toString();
    }
}
