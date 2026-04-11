package a2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o2.d0 f221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f225e;
    public final boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f227h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f228j;

    public f1(o2.d0 d0Var, long j5, long j8, long j10, long j11, boolean z2, boolean z10, boolean z11, boolean z12, boolean z13) {
        boolean z14 = true;
        s1.d.b(!z13 || z11);
        s1.d.b(!z12 || z11);
        if (z10 && (z11 || z12 || z13)) {
            z14 = false;
        }
        s1.d.b(z14);
        this.f221a = d0Var;
        this.f222b = j5;
        this.f223c = j8;
        this.f224d = j10;
        this.f225e = j11;
        this.f = z2;
        this.f226g = z10;
        this.f227h = z11;
        this.i = z12;
        this.f228j = z13;
    }

    public final f1 a(long j5) {
        if (j5 == this.f223c) {
            return this;
        }
        return new f1(this.f221a, this.f222b, j5, this.f224d, this.f225e, this.f, this.f226g, this.f227h, this.i, this.f228j);
    }

    public final f1 b(long j5) {
        if (j5 == this.f222b) {
            return this;
        }
        return new f1(this.f221a, j5, this.f223c, this.f224d, this.f225e, this.f, this.f226g, this.f227h, this.i, this.f228j);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f1.class == obj.getClass()) {
            f1 f1Var = (f1) obj;
            if (this.f222b == f1Var.f222b && this.f223c == f1Var.f223c && this.f224d == f1Var.f224d && this.f225e == f1Var.f225e && this.f == f1Var.f && this.f226g == f1Var.f226g && this.f227h == f1Var.f227h && this.i == f1Var.i && this.f228j == f1Var.f228j && Objects.equals(this.f221a, f1Var.f221a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((((((this.f221a.hashCode() + 527) * 31) + ((int) this.f222b)) * 31) + ((int) this.f223c)) * 31) + ((int) this.f224d)) * 31) + ((int) this.f225e)) * 31) + (this.f ? 1 : 0)) * 31) + (this.f226g ? 1 : 0)) * 31) + (this.f227h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.f228j ? 1 : 0);
    }
}
