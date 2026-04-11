package w2;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13634d;

    public g0(int i, int i10, int i11, byte[] bArr) {
        this.f13631a = i;
        this.f13632b = bArr;
        this.f13633c = i10;
        this.f13634d = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g0.class == obj.getClass()) {
            g0 g0Var = (g0) obj;
            if (this.f13631a == g0Var.f13631a && this.f13633c == g0Var.f13633c && this.f13634d == g0Var.f13634d && Arrays.equals(this.f13632b, g0Var.f13632b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.f13632b) + (this.f13631a * 31)) * 31) + this.f13633c) * 31) + this.f13634d;
    }
}
