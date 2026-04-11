package e2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f4336e;

    public i(String str, String str2, String str3, String str4, String str5) {
        this.f4332a = str;
        this.f4333b = str2;
        this.f4334c = str3;
        this.f4335d = str4;
        this.f4336e = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Objects.equals(this.f4332a, iVar.f4332a) && Objects.equals(this.f4333b, iVar.f4333b) && Objects.equals(this.f4334c, iVar.f4334c) && Objects.equals(this.f4335d, iVar.f4335d) && Objects.equals(this.f4336e, iVar.f4336e);
    }

    public final int hashCode() {
        String str = this.f4332a;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f4333b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f4334c;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f4335d;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f4336e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
