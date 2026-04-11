package k4;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ua.i0 f7164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f7166c;

    public t(List list, int i, long j4) {
        this.f7164a = ua.i0.k(list);
        this.f7165b = i;
        this.f7166c = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f7164a.equals(tVar.f7164a) && this.f7165b == tVar.f7165b && this.f7166c == tVar.f7166c;
    }

    public final int hashCode() {
        return com.bumptech.glide.e.g(this.f7166c) + (((this.f7164a.hashCode() * 31) + this.f7165b) * 31);
    }
}
