package k2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6854c;

    public f(String str, String str2, String str3) {
        this.f6852a = str;
        this.f6853b = str2;
        this.f6854c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (Objects.equals(this.f6852a, fVar.f6852a) && Objects.equals(this.f6853b, fVar.f6853b) && Objects.equals(this.f6854c, fVar.f6854c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f6852a.hashCode() * 31;
        String str = this.f6853b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f6854c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
