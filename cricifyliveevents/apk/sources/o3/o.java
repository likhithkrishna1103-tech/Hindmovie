package o3;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9480c;

    public o(String str, String str2, String str3) {
        super(str);
        this.f9479b = str2;
        this.f9480c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            o oVar = (o) obj;
            if (this.f9466a.equals(oVar.f9466a) && Objects.equals(this.f9479b, oVar.f9479b) && Objects.equals(this.f9480c, oVar.f9480c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iE = l0.e.e(527, 31, this.f9466a);
        String str = this.f9479b;
        int iHashCode = (iE + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f9480c;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // o3.i
    public final String toString() {
        return this.f9466a + ": url=" + this.f9480c;
    }
}
