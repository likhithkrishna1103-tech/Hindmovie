package ge;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements g, Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f5235v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f5236w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f5237x = 2;

    public a(Object obj) {
        this.f5235v = obj;
    }

    @Override // ge.g
    public final int e() {
        return 2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f5236w == aVar.f5236w && this.f5237x == aVar.f5237x && i.a(this.f5235v, aVar.f5235v) && AtomicReference.class.equals(AtomicReference.class);
    }

    public final int hashCode() {
        return ((((((((((AtomicReference.class.hashCode() + ((this.f5235v != null ? r0.hashCode() : 0) * 31)) * 31) + 113762) * 31) - 869290769) * 31) + (this.f5236w ? 1231 : 1237)) * 31) + 2) * 31) + this.f5237x;
    }

    public final String toString() {
        q.f5255a.getClass();
        return r.a(this);
    }
}
