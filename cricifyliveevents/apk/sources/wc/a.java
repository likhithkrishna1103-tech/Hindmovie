package wc;

import nb.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xe.c f14133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f14134b = null;

    public a(xe.c cVar) {
        this.f14133a = cVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f14133a.equals(aVar.f14133a) && ge.i.a(this.f14134b, aVar.f14134b);
    }

    public final int hashCode() {
        int iHashCode = this.f14133a.hashCode() * 31;
        i iVar = this.f14134b;
        return iHashCode + (iVar == null ? 0 : iVar.hashCode());
    }

    public final String toString() {
        return "Dependency(mutex=" + this.f14133a + ", subscriber=" + this.f14134b + ')';
    }
}
