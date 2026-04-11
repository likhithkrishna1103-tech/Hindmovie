package k3;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7015c;

    public o(String str, String str2, String str3) {
        super(str);
        this.f7014b = str2;
        this.f7015c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            o oVar = (o) obj;
            if (this.f7001a.equals(oVar.f7001a) && Objects.equals(this.f7014b, oVar.f7014b) && Objects.equals(this.f7015c, oVar.f7015c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iH = e6.j.h(527, 31, this.f7001a);
        String str = this.f7014b;
        int iHashCode = (iH + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f7015c;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // k3.i
    public final String toString() {
        return this.f7001a + ": url=" + this.f7015c;
    }
}
