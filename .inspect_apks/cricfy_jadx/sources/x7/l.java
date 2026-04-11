package x7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u7.c f14442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14443b;

    public l(u7.c cVar, byte[] bArr) {
        if (cVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f14442a = cVar;
        this.f14443b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f14442a.equals(lVar.f14442a)) {
            return Arrays.equals(this.f14443b, lVar.f14443b);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f14442a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f14443b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f14442a + ", bytes=[...]}";
    }
}
