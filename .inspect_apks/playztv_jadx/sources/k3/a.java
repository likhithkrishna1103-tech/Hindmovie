package k3;

import java.util.Arrays;
import java.util.Objects;
import p1.i0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f6977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f6978e;

    public a(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.f6975b = str;
        this.f6976c = str2;
        this.f6977d = i;
        this.f6978e = bArr;
    }

    @Override // k3.i, p1.k0
    public final void a(i0 i0Var) {
        i0Var.a(this.f6977d, this.f6978e);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f6977d == aVar.f6977d && Objects.equals(this.f6975b, aVar.f6975b) && Objects.equals(this.f6976c, aVar.f6976c) && Arrays.equals(this.f6978e, aVar.f6978e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (527 + this.f6977d) * 31;
        String str = this.f6975b;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f6976c;
        return Arrays.hashCode(this.f6978e) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    @Override // k3.i
    public final String toString() {
        return this.f7001a + ": mimeType=" + this.f6975b + ", description=" + this.f6976c;
    }
}
