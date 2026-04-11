package e2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4298d;

    public b(int i, int i10, String str, String str2) {
        this.f4295a = str;
        this.f4296b = str2;
        this.f4297c = i;
        this.f4298d = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4297c == bVar.f4297c && this.f4298d == bVar.f4298d && Objects.equals(this.f4295a, bVar.f4295a) && Objects.equals(this.f4296b, bVar.f4296b);
    }

    public final int hashCode() {
        return Objects.hash(this.f4295a, this.f4296b, Integer.valueOf(this.f4297c), Integer.valueOf(this.f4298d));
    }
}
