package qb;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f10571b;

    public h0(String str, byte[] bArr) {
        this.f10570a = str;
        this.f10571b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r1) {
            r1 r1Var = (r1) obj;
            h0 h0Var = (h0) r1Var;
            if (this.f10570a.equals(h0Var.f10570a)) {
                if (Arrays.equals(this.f10571b, r1Var instanceof h0 ? ((h0) r1Var).f10571b : h0Var.f10571b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f10570a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f10571b);
    }

    public final String toString() {
        return "File{filename=" + this.f10570a + ", contents=" + Arrays.toString(this.f10571b) + "}";
    }
}
