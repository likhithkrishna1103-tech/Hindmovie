package b2;

import java.util.Objects;
import o2.d0;
import p1.f1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f1 f1720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d0 f1722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1723e;
    public final f1 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d0 f1725h;
    public final long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f1726j;

    public a(long j5, f1 f1Var, int i, d0 d0Var, long j8, f1 f1Var2, int i10, d0 d0Var2, long j10, long j11) {
        this.f1719a = j5;
        this.f1720b = f1Var;
        this.f1721c = i;
        this.f1722d = d0Var;
        this.f1723e = j8;
        this.f = f1Var2;
        this.f1724g = i10;
        this.f1725h = d0Var2;
        this.i = j10;
        this.f1726j = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f1719a == aVar.f1719a && this.f1721c == aVar.f1721c && this.f1723e == aVar.f1723e && this.f1724g == aVar.f1724g && this.i == aVar.i && this.f1726j == aVar.f1726j && Objects.equals(this.f1720b, aVar.f1720b) && Objects.equals(this.f1722d, aVar.f1722d) && Objects.equals(this.f, aVar.f) && Objects.equals(this.f1725h, aVar.f1725h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f1719a), this.f1720b, Integer.valueOf(this.f1721c), this.f1722d, Long.valueOf(this.f1723e), this.f, Integer.valueOf(this.f1724g), this.f1725h, Long.valueOf(this.i), Long.valueOf(this.f1726j));
    }
}
