package j3;

import java.util.Arrays;
import p1.i0;
import p1.k0;
import p1.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f6767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6769c;

    public c(String str, String str2, byte[] bArr) {
        this.f6767a = bArr;
        this.f6768b = str;
        this.f6769c = str2;
    }

    @Override // p1.k0
    public final void a(i0 i0Var) {
        String str = this.f6768b;
        if (str != null) {
            i0Var.f9785a = str;
        }
    }

    @Override // p1.k0
    public final /* synthetic */ q b() {
        return null;
    }

    @Override // p1.k0
    public final /* synthetic */ byte[] c() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f6767a, ((c) obj).f6767a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f6767a);
    }

    public final String toString() {
        int length = this.f6767a.length;
        StringBuilder sb2 = new StringBuilder("ICY: title=\"");
        sb2.append(this.f6768b);
        sb2.append("\", url=\"");
        sb2.append(this.f6769c);
        sb2.append("\", rawMetadata.length=\"");
        return x.c.a(sb2, length, "\"");
    }
}
