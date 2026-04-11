package s1;

import e6.f0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f11683b = new f0(3);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11685d;

    public o(Object obj) {
        this.f11682a = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        return this.f11682a.equals(((o) obj).f11682a);
    }

    public final int hashCode() {
        return this.f11682a.hashCode();
    }
}
