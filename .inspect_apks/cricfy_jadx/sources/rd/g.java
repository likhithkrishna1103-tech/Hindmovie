package rd;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Throwable f10995v;

    public g(Throwable th) {
        ge.i.e(th, "exception");
        this.f10995v = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return ge.i.a(this.f10995v, ((g) obj).f10995v);
        }
        return false;
    }

    public final int hashCode() {
        return this.f10995v.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f10995v + ')';
    }
}
