package wa;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13868b;

    public h0(String str, byte[] bArr) {
        this.f13867a = str;
        this.f13868b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r1) {
            r1 r1Var = (r1) obj;
            h0 h0Var = (h0) r1Var;
            if (this.f13867a.equals(h0Var.f13867a)) {
                if (Arrays.equals(this.f13868b, r1Var instanceof h0 ? ((h0) r1Var).f13868b : h0Var.f13868b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f13867a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f13868b);
    }

    public final String toString() {
        return "File{filename=" + this.f13867a + ", contents=" + Arrays.toString(this.f13868b) + "}";
    }
}
