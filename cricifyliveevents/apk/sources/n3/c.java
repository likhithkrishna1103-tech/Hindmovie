package n3;

import java.util.Arrays;
import v1.i0;
import v1.k0;
import v1.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f8762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8764c;

    public c(String str, String str2, byte[] bArr) {
        this.f8762a = bArr;
        this.f8763b = str;
        this.f8764c = str2;
    }

    @Override // v1.k0
    public final /* synthetic */ p a() {
        return null;
    }

    @Override // v1.k0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    @Override // v1.k0
    public final void c(i0 i0Var) {
        String str = this.f8763b;
        if (str != null) {
            i0Var.f12718a = str;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f8762a, ((c) obj).f8762a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f8762a);
    }

    public final String toString() {
        int length = this.f8762a.length;
        StringBuilder sb = new StringBuilder("ICY: title=\"");
        sb.append(this.f8763b);
        sb.append("\", url=\"");
        sb.append(this.f8764c);
        sb.append("\", rawMetadata.length=\"");
        return q4.a.o(sb, length, "\"");
    }
}
