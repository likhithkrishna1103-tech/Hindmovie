package k3;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f7005d;

    public k(String str, String str2, String str3) {
        super("----");
        this.f7003b = str;
        this.f7004c = str2;
        this.f7005d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class == obj.getClass()) {
            k kVar = (k) obj;
            if (Objects.equals(this.f7004c, kVar.f7004c) && Objects.equals(this.f7003b, kVar.f7003b) && Objects.equals(this.f7005d, kVar.f7005d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f7003b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f7004c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f7005d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // k3.i
    public final String toString() {
        return this.f7001a + ": domain=" + this.f7003b + ", description=" + this.f7004c;
    }
}
