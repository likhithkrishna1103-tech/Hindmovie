package g2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s2.c0 f4919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f4923e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f4924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f4925h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f4926j;

    public v0(s2.c0 c0Var, long j4, long j7, long j10, long j11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        boolean z15 = true;
        y1.d.b(!z14 || z12);
        y1.d.b(!z13 || z12);
        if (z11 && (z12 || z13 || z14)) {
            z15 = false;
        }
        y1.d.b(z15);
        this.f4919a = c0Var;
        this.f4920b = j4;
        this.f4921c = j7;
        this.f4922d = j10;
        this.f4923e = j11;
        this.f = z10;
        this.f4924g = z11;
        this.f4925h = z12;
        this.i = z13;
        this.f4926j = z14;
    }

    public final v0 a(long j4) {
        if (j4 == this.f4921c) {
            return this;
        }
        return new v0(this.f4919a, this.f4920b, j4, this.f4922d, this.f4923e, this.f, this.f4924g, this.f4925h, this.i, this.f4926j);
    }

    public final v0 b(long j4) {
        if (j4 == this.f4920b) {
            return this;
        }
        return new v0(this.f4919a, j4, this.f4921c, this.f4922d, this.f4923e, this.f, this.f4924g, this.f4925h, this.i, this.f4926j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && v0.class == obj.getClass()) {
            v0 v0Var = (v0) obj;
            if (this.f4920b == v0Var.f4920b && this.f4921c == v0Var.f4921c && this.f4922d == v0Var.f4922d && this.f4923e == v0Var.f4923e && this.f == v0Var.f && this.f4924g == v0Var.f4924g && this.f4925h == v0Var.f4925h && this.i == v0Var.i && this.f4926j == v0Var.f4926j && Objects.equals(this.f4919a, v0Var.f4919a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((((((this.f4919a.hashCode() + 527) * 31) + ((int) this.f4920b)) * 31) + ((int) this.f4921c)) * 31) + ((int) this.f4922d)) * 31) + ((int) this.f4923e)) * 31) + (this.f ? 1 : 0)) * 31) + (this.f4924g ? 1 : 0)) * 31) + (this.f4925h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.f4926j ? 1 : 0);
    }
}
