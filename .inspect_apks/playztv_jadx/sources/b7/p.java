package b7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p extends c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f1894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f1895b;

    public p(byte[] bArr, byte[] bArr2) {
        this.f1894a = bArr;
        this.f1895b = bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            boolean z2 = c0Var instanceof p;
            p pVar = (p) c0Var;
            if (Arrays.equals(this.f1894a, z2 ? pVar.f1894a : pVar.f1894a)) {
                p pVar2 = (p) c0Var;
                if (Arrays.equals(this.f1895b, z2 ? pVar2.f1895b : pVar2.f1895b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Arrays.hashCode(this.f1894a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f1895b);
    }

    public final String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f1894a) + ", encryptedBlob=" + Arrays.toString(this.f1895b) + "}";
    }
}
