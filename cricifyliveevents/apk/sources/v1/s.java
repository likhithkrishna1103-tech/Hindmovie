package v1;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12985d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12987b;

    static {
        int i = y1.a0.f14551a;
        f12984c = Integer.toString(0, 36);
        f12985d = Integer.toString(1, 36);
    }

    public s(String str, String str2) {
        this.f12986a = y1.a0.P(str);
        this.f12987b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && s.class == obj.getClass()) {
            s sVar = (s) obj;
            if (Objects.equals(this.f12986a, sVar.f12986a) && Objects.equals(this.f12987b, sVar.f12987b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f12987b.hashCode() * 31;
        String str = this.f12986a;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }
}
