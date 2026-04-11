package o3;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9470d;

    public k(String str, String str2, String str3) {
        super("----");
        this.f9468b = str;
        this.f9469c = str2;
        this.f9470d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class == obj.getClass()) {
            k kVar = (k) obj;
            if (Objects.equals(this.f9469c, kVar.f9469c) && Objects.equals(this.f9468b, kVar.f9468b) && Objects.equals(this.f9470d, kVar.f9470d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f9468b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f9469c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f9470d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // o3.i
    public final String toString() {
        return this.f9466a + ": domain=" + this.f9468b + ", description=" + this.f9469c;
    }
}
