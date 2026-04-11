package k3;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f7011c;

    public m(String str, byte[] bArr) {
        super("PRIV");
        this.f7010b = str;
        this.f7011c = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m.class == obj.getClass()) {
            m mVar = (m) obj;
            if (Objects.equals(this.f7010b, mVar.f7010b) && Arrays.equals(this.f7011c, mVar.f7011c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f7010b;
        return Arrays.hashCode(this.f7011c) + ((527 + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // k3.i
    public final String toString() {
        return this.f7001a + ": owner=" + this.f7010b;
    }
}
