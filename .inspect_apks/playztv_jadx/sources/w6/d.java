package w6;

import c6.f;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13748b;

    public d(Object obj) {
        x6.f.c(obj, "Argument must not be null");
        this.f13748b = obj;
    }

    @Override // c6.f
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(this.f13748b.toString().getBytes(f.f2515a));
    }

    @Override // c6.f
    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f13748b.equals(((d) obj).f13748b);
        }
        return false;
    }

    @Override // c6.f
    public final int hashCode() {
        return this.f13748b.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.f13748b + '}';
    }
}
