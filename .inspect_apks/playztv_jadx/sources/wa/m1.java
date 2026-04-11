package wa;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f13961e;
    public final int f;

    public m1(int i, int i10, long j5, long j8, boolean z2, int i11) {
        String str = Build.MODEL;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.PRODUCT;
        this.f13957a = i;
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.f13958b = i10;
        this.f13959c = j5;
        this.f13960d = j8;
        this.f13961e = z2;
        this.f = i11;
        if (str2 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        if (str3 == null) {
            throw new NullPointerException("Null modelClass");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        if (this.f13957a != m1Var.f13957a) {
            return false;
        }
        String str = Build.MODEL;
        if (!str.equals(str) || this.f13958b != m1Var.f13958b || this.f13959c != m1Var.f13959c || this.f13960d != m1Var.f13960d || this.f13961e != m1Var.f13961e || this.f != m1Var.f) {
            return false;
        }
        String str2 = Build.MANUFACTURER;
        if (!str2.equals(str2)) {
            return false;
        }
        String str3 = Build.PRODUCT;
        return str3.equals(str3);
    }

    public final int hashCode() {
        int iHashCode = (((((this.f13957a ^ 1000003) * 1000003) ^ Build.MODEL.hashCode()) * 1000003) ^ this.f13958b) * 1000003;
        long j5 = this.f13959c;
        int i = (iHashCode ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003;
        long j8 = this.f13960d;
        return ((((((((i ^ ((int) (j8 ^ (j8 >>> 32)))) * 1000003) ^ (this.f13961e ? 1231 : 1237)) * 1000003) ^ this.f) * 1000003) ^ Build.MANUFACTURER.hashCode()) * 1000003) ^ Build.PRODUCT.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("DeviceData{arch=");
        sb2.append(this.f13957a);
        sb2.append(", model=");
        sb2.append(Build.MODEL);
        sb2.append(", availableProcessors=");
        sb2.append(this.f13958b);
        sb2.append(", totalRam=");
        sb2.append(this.f13959c);
        sb2.append(", diskSpace=");
        sb2.append(this.f13960d);
        sb2.append(", isEmulator=");
        sb2.append(this.f13961e);
        sb2.append(", state=");
        sb2.append(this.f);
        sb2.append(", manufacturer=");
        sb2.append(Build.MANUFACTURER);
        sb2.append(", modelClass=");
        return l4.a.o(sb2, Build.PRODUCT, "}");
    }
}
