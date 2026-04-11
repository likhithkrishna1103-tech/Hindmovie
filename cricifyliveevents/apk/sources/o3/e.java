package o3;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9457d;

    public e(String str, String str2, String str3) {
        super("COMM");
        this.f9455b = str;
        this.f9456c = str2;
        this.f9457d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (Objects.equals(this.f9456c, eVar.f9456c) && Objects.equals(this.f9455b, eVar.f9455b) && Objects.equals(this.f9457d, eVar.f9457d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f9455b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f9456c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f9457d;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // o3.i
    public final String toString() {
        return this.f9466a + ": language=" + this.f9455b + ", description=" + this.f9456c + ", text=" + this.f9457d;
    }
}
