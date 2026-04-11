package e6;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements c6.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c6.f f4495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c6.f f4496c;

    public e(c6.f fVar, c6.f fVar2) {
        this.f4495b = fVar;
        this.f4496c = fVar2;
    }

    @Override // c6.f
    public final void b(MessageDigest messageDigest) {
        this.f4495b.b(messageDigest);
        this.f4496c.b(messageDigest);
    }

    @Override // c6.f
    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f4495b.equals(eVar.f4495b) && this.f4496c.equals(eVar.f4496c)) {
                return true;
            }
        }
        return false;
    }

    @Override // c6.f
    public final int hashCode() {
        return this.f4496c.hashCode() + (this.f4495b.hashCode() * 31);
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.f4495b + ", signature=" + this.f4496c + '}';
    }
}
