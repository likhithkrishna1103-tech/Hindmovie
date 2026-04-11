package v1;

import android.net.Uri;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p1.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f13157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f13160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f13161e;
    public final long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f13162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f13163h;
    public final int i;

    static {
        h0.a("media3.datasource");
    }

    public m(Uri uri, long j5, int i, byte[] bArr, Map map, long j8, long j10, String str, int i10) {
        s1.d.b(j5 + j8 >= 0);
        s1.d.b(j8 >= 0);
        s1.d.b(j10 > 0 || j10 == -1);
        uri.getClass();
        this.f13157a = uri;
        this.f13158b = j5;
        this.f13159c = i;
        this.f13160d = (bArr == null || bArr.length == 0) ? null : bArr;
        this.f13161e = Collections.unmodifiableMap(new HashMap(map));
        this.f = j8;
        this.f13162g = j10;
        this.f13163h = str;
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

    public final l a() {
        l lVar = new l();
        lVar.f13150a = this.f13157a;
        lVar.f13151b = this.f13158b;
        lVar.f13152c = this.f13159c;
        lVar.f13153d = this.f13160d;
        lVar.f13154e = this.f13161e;
        lVar.f = this.f;
        lVar.f13155g = this.f13162g;
        lVar.f13156h = this.f13163h;
        lVar.i = this.i;
        return lVar;
    }

    public final m c(long j5) {
        long j8 = this.f13162g;
        return d(j5, j8 != -1 ? j8 - j5 : -1L);
    }

    public final m d(long j5, long j8) {
        if (j5 == 0 && this.f13162g == j8) {
            return this;
        }
        return new m(this.f13157a, this.f13158b, this.f13159c, this.f13160d, this.f13161e, this.f + j5, j8, this.f13163h, this.i);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("DataSpec[");
        sb2.append(b(this.f13159c));
        sb2.append(" ");
        sb2.append(this.f13157a);
        sb2.append(", ");
        sb2.append(this.f);
        sb2.append(", ");
        sb2.append(this.f13162g);
        sb2.append(", ");
        sb2.append(this.f13163h);
        sb2.append(", ");
        return x.c.a(sb2, this.i, "]");
    }
}
