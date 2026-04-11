package ue;

import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f12955c = new f(od.i.j0(new ArrayList()), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f12956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.c f12957b;

    public f(Set set, com.bumptech.glide.c cVar) {
        this.f12956a = set;
        this.f12957b = cVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return be.h.a(fVar.f12956a, this.f12956a) && be.h.a(fVar.f12957b, this.f12957b);
    }

    public final int hashCode() {
        int iHashCode = (this.f12956a.hashCode() + 1517) * 41;
        com.bumptech.glide.c cVar = this.f12957b;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }
}
