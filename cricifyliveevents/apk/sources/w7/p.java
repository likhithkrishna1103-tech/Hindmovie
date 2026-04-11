package w7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f14089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14090b;

    public p(byte[] bArr, byte[] bArr2) {
        this.f14089a = bArr;
        this.f14090b = bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0) {
            b0 b0Var = (b0) obj;
            boolean z10 = b0Var instanceof p;
            p pVar = (p) b0Var;
            if (Arrays.equals(this.f14089a, z10 ? pVar.f14089a : pVar.f14089a)) {
                p pVar2 = (p) b0Var;
                if (Arrays.equals(this.f14090b, z10 ? pVar2.f14090b : pVar2.f14090b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Arrays.hashCode(this.f14089a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f14090b);
    }

    public final String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f14089a) + ", encryptedBlob=" + Arrays.toString(this.f14090b) + "}";
    }
}
