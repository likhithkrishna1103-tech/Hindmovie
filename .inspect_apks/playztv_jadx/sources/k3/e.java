package k3;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6991d;

    public e(String str, String str2, String str3) {
        super("COMM");
        this.f6989b = str;
        this.f6990c = str2;
        this.f6991d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (Objects.equals(this.f6990c, eVar.f6990c) && Objects.equals(this.f6989b, eVar.f6989b) && Objects.equals(this.f6991d, eVar.f6991d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f6989b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f6990c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f6991d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // k3.i
    public final String toString() {
        return this.f7001a + ": language=" + this.f6989b + ", description=" + this.f6990c + ", text=" + this.f6991d;
    }
}
