package r7;

import java.security.MessageDigest;
import s7.f;
import x6.e;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f10892b;

    public b(Object obj) {
        f.c(obj, "Argument must not be null");
        this.f10892b = obj;
    }

    @Override // x6.e
    public final void a(MessageDigest messageDigest) {
        messageDigest.update(this.f10892b.toString().getBytes(e.f14397a));
    }

    @Override // x6.e
    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f10892b.equals(((b) obj).f10892b);
        }
        return false;
    }

    @Override // x6.e
    public final int hashCode() {
        return this.f10892b.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.f10892b + '}';
    }
}
