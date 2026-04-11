package s7;

import java.util.Arrays;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pb.c f11875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t7.m f11876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11877d;

    public a(pb.c cVar, t7.m mVar, String str) {
        this.f11875b = cVar;
        this.f11876c = mVar;
        this.f11877d = str;
        this.f11874a = Arrays.hashCode(new Object[]{cVar, mVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return v.k(this.f11875b, aVar.f11875b) && v.k(this.f11876c, aVar.f11876c) && v.k(this.f11877d, aVar.f11877d);
    }

    public final int hashCode() {
        return this.f11874a;
    }
}
