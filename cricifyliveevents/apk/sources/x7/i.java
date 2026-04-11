package x7;

import android.util.Base64;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u7.d f14436c;

    public i(String str, byte[] bArr, u7.d dVar) {
        this.f14434a = str;
        this.f14435b = bArr;
        this.f14436c = dVar;
    }

    public static l7.a a() {
        l7.a aVar = new l7.a(24, false);
        aVar.f7868y = u7.d.f12281v;
        return aVar;
    }

    public final i b(u7.d dVar) {
        l7.a aVarA = a();
        aVarA.J(this.f14434a);
        if (dVar == null) {
            throw new NullPointerException("Null priority");
        }
        aVarA.f7868y = dVar;
        aVarA.f7867x = this.f14435b;
        return aVarA.m();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.f14434a.equals(iVar.f14434a) && Arrays.equals(this.f14435b, iVar.f14435b) && this.f14436c.equals(iVar.f14436c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f14434a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f14435b)) * 1000003) ^ this.f14436c.hashCode();
    }

    public final String toString() {
        byte[] bArr = this.f14435b;
        String strEncodeToString = bArr == null ? "" : Base64.encodeToString(bArr, 2);
        StringBuilder sb = new StringBuilder("TransportContext(");
        sb.append(this.f14434a);
        sb.append(", ");
        sb.append(this.f14436c);
        sb.append(", ");
        return q4.a.q(sb, strEncodeToString, ")");
    }
}
