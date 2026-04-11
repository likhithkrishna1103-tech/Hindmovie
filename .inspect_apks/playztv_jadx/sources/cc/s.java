package cc;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2709d;

    public s(int i, int i10, String str, boolean z2) {
        this.f2706a = str;
        this.f2707b = i;
        this.f2708c = i10;
        this.f2709d = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return be.h.a(this.f2706a, sVar.f2706a) && this.f2707b == sVar.f2707b && this.f2708c == sVar.f2708c && this.f2709d == sVar.f2709d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final int hashCode() {
        int iHashCode = ((((this.f2706a.hashCode() * 31) + this.f2707b) * 31) + this.f2708c) * 31;
        boolean z2 = this.f2709d;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        return iHashCode + r12;
    }

    public final String toString() {
        return "ProcessDetails(processName=" + this.f2706a + ", pid=" + this.f2707b + ", importance=" + this.f2708c + ", isDefaultProcess=" + this.f2709d + ')';
    }
}
