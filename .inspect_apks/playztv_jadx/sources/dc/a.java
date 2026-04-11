package dc;

import be.h;
import ta.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final se.c f4118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f4119b = null;

    public a(se.c cVar) {
        this.f4118a = cVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f4118a.equals(aVar.f4118a) && h.a(this.f4119b, aVar.f4119b);
    }

    public final int hashCode() {
        int iHashCode = this.f4118a.hashCode() * 31;
        i iVar = this.f4119b;
        return iHashCode + (iVar == null ? 0 : iVar.hashCode());
    }

    public final String toString() {
        return "Dependency(mutex=" + this.f4118a + ", subscriber=" + this.f4119b + ')';
    }
}
