package z9;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o implements l, Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f14925u;

    public o(Object obj) {
        this.f14925u = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            return i5.a.o(this.f14925u, ((o) obj).f14925u);
        }
        return false;
    }

    @Override // z9.l
    public final Object get() {
        return this.f14925u;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f14925u});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.f14925u + ")";
    }
}
