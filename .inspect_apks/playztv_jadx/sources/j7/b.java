package j7;

import c7.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f6815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c7.i f6816c;

    public b(long j5, j jVar, c7.i iVar) {
        this.f6814a = j5;
        this.f6815b = jVar;
        this.f6816c = iVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f6814a == bVar.f6814a && this.f6815b.equals(bVar.f6815b) && this.f6816c.equals(bVar.f6816c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f6814a;
        return ((((((int) (j5 ^ (j5 >>> 32))) ^ 1000003) * 1000003) ^ this.f6815b.hashCode()) * 1000003) ^ this.f6816c.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f6814a + ", transportContext=" + this.f6815b + ", event=" + this.f6816c + "}";
    }
}
