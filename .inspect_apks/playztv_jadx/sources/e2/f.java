package e2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4323c;

    public f(String str, String str2, String str3) {
        this.f4321a = str;
        this.f4322b = str2;
        this.f4323c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (Objects.equals(this.f4321a, fVar.f4321a) && Objects.equals(this.f4322b, fVar.f4322b) && Objects.equals(this.f4323c, fVar.f4323c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f4321a.hashCode() * 31;
        String str = this.f4322b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f4323c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
