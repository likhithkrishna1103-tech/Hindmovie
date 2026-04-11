package n0;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f8608c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(this.f8606a, bVar.f8606a) && Objects.equals(this.f8607b, bVar.f8607b) && Objects.equals(this.f8608c, bVar.f8608c);
    }

    public final int hashCode() {
        return Objects.hash(this.f8606a, this.f8607b, this.f8608c);
    }
}
