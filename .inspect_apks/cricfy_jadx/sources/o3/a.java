package o3;

import java.util.Arrays;
import java.util.Objects;
import v1.i0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f9444e;

    public a(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.f9441b = str;
        this.f9442c = str2;
        this.f9443d = i;
        this.f9444e = bArr;
    }

    @Override // o3.i, v1.k0
    public final void c(i0 i0Var) {
        i0Var.a(this.f9443d, this.f9444e);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f9443d == aVar.f9443d && Objects.equals(this.f9441b, aVar.f9441b) && Objects.equals(this.f9442c, aVar.f9442c) && Arrays.equals(this.f9444e, aVar.f9444e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (527 + this.f9443d) * 31;
        String str = this.f9441b;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f9442c;
        return Arrays.hashCode(this.f9444e) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    @Override // o3.i
    public final String toString() {
        return this.f9466a + ": mimeType=" + this.f9441b + ", description=" + this.f9442c;
    }
}
