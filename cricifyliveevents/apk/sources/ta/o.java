package ta;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements l, Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f11974v;

    public o(Object obj) {
        this.f11974v = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            return com.bumptech.glide.c.h(this.f11974v, ((o) obj).f11974v);
        }
        return false;
    }

    @Override // ta.l
    public final Object get() {
        return this.f11974v;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11974v});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.f11974v + ")";
    }
}
