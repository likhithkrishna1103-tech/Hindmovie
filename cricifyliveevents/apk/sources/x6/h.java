package x6;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s7.c f14403b = new s7.c(0);

    @Override // x6.e
    public final void a(MessageDigest messageDigest) {
        int i = 0;
        while (true) {
            s7.c cVar = this.f14403b;
            if (i >= cVar.f12542x) {
                return;
            }
            g gVar = (g) cVar.f(i);
            Object objJ = this.f14403b.j(i);
            f fVar = gVar.f14400b;
            if (gVar.f14402d == null) {
                gVar.f14402d = gVar.f14401c.getBytes(e.f14397a);
            }
            fVar.a(gVar.f14402d, objJ, messageDigest);
            i++;
        }
    }

    public final Object c(g gVar) {
        s7.c cVar = this.f14403b;
        return cVar.containsKey(gVar) ? cVar.get(gVar) : gVar.f14399a;
    }

    @Override // x6.e
    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.f14403b.equals(((h) obj).f14403b);
        }
        return false;
    }

    @Override // x6.e
    public final int hashCode() {
        return this.f14403b.hashCode();
    }

    public final String toString() {
        return "Options{values=" + this.f14403b + '}';
    }
}
