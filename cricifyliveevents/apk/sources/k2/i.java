package k2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f6867e;

    public i(String str, String str2, String str3, String str4, String str5) {
        this.f6863a = str;
        this.f6864b = str2;
        this.f6865c = str3;
        this.f6866d = str4;
        this.f6867e = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Objects.equals(this.f6863a, iVar.f6863a) && Objects.equals(this.f6864b, iVar.f6864b) && Objects.equals(this.f6865c, iVar.f6865c) && Objects.equals(this.f6866d, iVar.f6866d) && Objects.equals(this.f6867e, iVar.f6867e);
    }

    public final int hashCode() {
        String str = this.f6863a;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f6864b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f6865c;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f6866d;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f6867e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
