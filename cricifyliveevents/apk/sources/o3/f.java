package o3;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f9461e;

    public f(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f9458b = str;
        this.f9459c = str2;
        this.f9460d = str3;
        this.f9461e = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (Objects.equals(this.f9458b, fVar.f9458b) && Objects.equals(this.f9459c, fVar.f9459c) && Objects.equals(this.f9460d, fVar.f9460d) && Arrays.equals(this.f9461e, fVar.f9461e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f9458b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f9459c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f9460d;
        return Arrays.hashCode(this.f9461e) + ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    @Override // o3.i
    public final String toString() {
        return this.f9466a + ": mimeType=" + this.f9458b + ", filename=" + this.f9459c + ", description=" + this.f9460d;
    }
}
