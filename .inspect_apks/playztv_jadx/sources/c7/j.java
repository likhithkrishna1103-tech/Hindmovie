package c7;

import android.util.Base64;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f2561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z6.d f2562c;

    public j(String str, byte[] bArr, z6.d dVar) {
        this.f2560a = str;
        this.f2561b = bArr;
        this.f2562c = dVar;
    }

    public static a7.b a() {
        a7.b bVar = new a7.b(7, false);
        bVar.f619w = z6.d.f14891u;
        return bVar;
    }

    public final j b(z6.d dVar) {
        a7.b bVarA = a();
        bVarA.E(this.f2560a);
        if (dVar == null) {
            throw new NullPointerException("Null priority");
        }
        bVarA.f619w = dVar;
        bVarA.f618v = this.f2561b;
        return bVarA.k();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (this.f2560a.equals(jVar.f2560a) && Arrays.equals(this.f2561b, jVar.f2561b) && this.f2562c.equals(jVar.f2562c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f2560a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f2561b)) * 1000003) ^ this.f2562c.hashCode();
    }

    public final String toString() {
        byte[] bArr = this.f2561b;
        String strEncodeToString = bArr == null ? "" : Base64.encodeToString(bArr, 2);
        StringBuilder sb2 = new StringBuilder("TransportContext(");
        sb2.append(this.f2560a);
        sb2.append(", ");
        sb2.append(this.f2562c);
        sb2.append(", ");
        return l4.a.o(sb2, strEncodeToString, ")");
    }
}
