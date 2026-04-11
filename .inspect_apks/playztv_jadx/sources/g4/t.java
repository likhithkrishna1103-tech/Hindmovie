package g4;

import java.util.List;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aa.j0 f5221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5223c;

    public t(List list, int i, long j5) {
        this.f5221a = aa.j0.r(list);
        this.f5222b = i;
        this.f5223c = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f5221a.equals(tVar.f5221a) && this.f5222b == tVar.f5222b && this.f5223c == tVar.f5223c;
    }

    public final int hashCode() {
        return t1.r(this.f5223c) + (((this.f5221a.hashCode() * 31) + this.f5222b) * 31);
    }
}
