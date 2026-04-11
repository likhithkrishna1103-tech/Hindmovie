package a3;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f191d;

    public h0(int i, int i10, int i11, byte[] bArr) {
        this.f188a = i;
        this.f189b = bArr;
        this.f190c = i10;
        this.f191d = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && h0.class == obj.getClass()) {
            h0 h0Var = (h0) obj;
            if (this.f188a == h0Var.f188a && this.f190c == h0Var.f190c && this.f191d == h0Var.f191d && Arrays.equals(this.f189b, h0Var.f189b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.f189b) + (this.f188a * 31)) * 31) + this.f190c) * 31) + this.f191d;
    }
}
