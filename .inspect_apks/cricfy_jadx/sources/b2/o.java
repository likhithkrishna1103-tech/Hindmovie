package b2;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f1714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f1717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f1718e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f1719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1720h;
    public final int i;

    static {
        v1.h0.a("media3.datasource");
    }

    public o(Uri uri, long j4, int i, byte[] bArr, Map map, long j7, long j10, String str, int i10) {
        y1.d.b(j4 + j7 >= 0);
        y1.d.b(j7 >= 0);
        y1.d.b(j10 > 0 || j10 == -1);
        uri.getClass();
        this.f1714a = uri;
        this.f1715b = j4;
        this.f1716c = i;
        this.f1717d = (bArr == null || bArr.length == 0) ? null : bArr;
        this.f1718e = Collections.unmodifiableMap(new HashMap(map));
        this.f = j7;
        this.f1719g = j10;
        this.f1720h = str;
        this.i = i10;
    }

    public static String b(int i) {
        if (i == 1) {
            return "GET";
        }
        if (i == 2) {
            return "POST";
        }
        if (i == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public final n a() {
        n nVar = new n();
        nVar.f1707a = this.f1714a;
        nVar.f1708b = this.f1715b;
        nVar.f1709c = this.f1716c;
        nVar.f1710d = this.f1717d;
        nVar.f1711e = this.f1718e;
        nVar.f = this.f;
        nVar.f1712g = this.f1719g;
        nVar.f1713h = this.f1720h;
        nVar.i = this.i;
        return nVar;
    }

    public final o c(long j4) {
        long j7 = this.f1719g;
        return d(j4, j7 != -1 ? j7 - j4 : -1L);
    }

    public final o d(long j4, long j7) {
        if (j4 == 0 && this.f1719g == j7) {
            return this;
        }
        return new o(this.f1714a, this.f1715b, this.f1716c, this.f1717d, this.f1718e, this.f + j4, j7, this.f1720h, this.i);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DataSpec[");
        sb.append(b(this.f1716c));
        sb.append(" ");
        sb.append(this.f1714a);
        sb.append(", ");
        sb.append(this.f);
        sb.append(", ");
        sb.append(this.f1719g);
        sb.append(", ");
        sb.append(this.f1720h);
        sb.append(", ");
        return q4.a.o(sb, this.i, "]");
    }
}
