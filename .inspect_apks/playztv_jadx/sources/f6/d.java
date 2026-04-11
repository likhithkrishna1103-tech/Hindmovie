package f6;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f4763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Class f4765c;

    public d(e eVar) {
        this.f4763a = eVar;
    }

    @Override // f6.h
    public final void a() {
        this.f4763a.e1(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f4764b == dVar.f4764b && this.f4765c == dVar.f4765c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f4764b * 31;
        Class cls = this.f4765c;
        return i + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "Key{size=" + this.f4764b + "array=" + this.f4765c + '}';
    }
}
