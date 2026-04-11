package kf;

import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f7461c = new f(sd.j.u0(new ArrayList()), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f7462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w8.e f7463b;

    public f(Set set, w8.e eVar) {
        this.f7462a = set;
        this.f7463b = eVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return ge.i.a(fVar.f7462a, this.f7462a) && ge.i.a(fVar.f7463b, this.f7463b);
    }

    public final int hashCode() {
        int iHashCode = (this.f7462a.hashCode() + 1517) * 41;
        w8.e eVar = this.f7463b;
        return iHashCode + (eVar != null ? eVar.hashCode() : 0);
    }
}
