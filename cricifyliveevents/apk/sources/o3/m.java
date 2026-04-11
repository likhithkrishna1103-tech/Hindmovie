package o3;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f9476c;

    public m(String str, byte[] bArr) {
        super("PRIV");
        this.f9475b = str;
        this.f9476c = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m.class == obj.getClass()) {
            m mVar = (m) obj;
            if (Objects.equals(this.f9475b, mVar.f9475b) && Arrays.equals(this.f9476c, mVar.f9476c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f9475b;
        return Arrays.hashCode(this.f9476c) + ((527 + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // o3.i
    public final String toString() {
        return this.f9466a + ": owner=" + this.f9475b;
    }
}
