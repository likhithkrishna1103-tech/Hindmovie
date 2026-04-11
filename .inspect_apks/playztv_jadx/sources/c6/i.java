package c6;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x6.c f2521b = new x6.c(0);

    @Override // c6.f
    public final void b(MessageDigest messageDigest) {
        int i = 0;
        while (true) {
            x6.c cVar = this.f2521b;
            if (i >= cVar.f11635w) {
                return;
            }
            h hVar = (h) cVar.f(i);
            Object objJ = this.f2521b.j(i);
            g gVar = hVar.f2518b;
            if (hVar.f2520d == null) {
                hVar.f2520d = hVar.f2519c.getBytes(f.f2515a);
            }
            gVar.f(hVar.f2520d, objJ, messageDigest);
            i++;
        }
    }

    public final Object c(h hVar) {
        x6.c cVar = this.f2521b;
        return cVar.containsKey(hVar) ? cVar.get(hVar) : hVar.f2517a;
    }

    @Override // c6.f
    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f2521b.equals(((i) obj).f2521b);
        }
        return false;
    }

    @Override // c6.f
    public final int hashCode() {
        return this.f2521b.hashCode();
    }

    public final String toString() {
        return "Options{values=" + this.f2521b + '}';
    }
}
