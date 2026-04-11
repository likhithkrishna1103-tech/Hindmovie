package k3;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f6995e;

    public f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f6992b = str;
        this.f6993c = str2;
        this.f6994d = str3;
        this.f6995e = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (Objects.equals(this.f6992b, fVar.f6992b) && Objects.equals(this.f6993c, fVar.f6993c) && Objects.equals(this.f6994d, fVar.f6994d) && Arrays.equals(this.f6995e, fVar.f6995e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f6992b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f6993c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f6994d;
        return Arrays.hashCode(this.f6995e) + ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    @Override // k3.i
    public final String toString() {
        return this.f7001a + ": mimeType=" + this.f6992b + ", filename=" + this.f6993c + ", description=" + this.f6994d;
    }
}
