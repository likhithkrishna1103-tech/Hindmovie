package c7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z6.c f2570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f2571b;

    public n(z6.c cVar, byte[] bArr) {
        if (cVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f2570a = cVar;
        this.f2571b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f2570a.equals(nVar.f2570a)) {
            return Arrays.equals(this.f2571b, nVar.f2571b);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f2570a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f2571b);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.f2570a + ", bytes=[...]}";
    }
}
