package qb;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f10663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f10664e;
    public final int f;

    public m1(int i, int i10, long j4, long j7, boolean z10, int i11) {
        String str = Build.MODEL;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.PRODUCT;
        this.f10660a = i;
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.f10661b = i10;
        this.f10662c = j4;
        this.f10663d = j7;
        this.f10664e = z10;
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
        if (this.f10660a != m1Var.f10660a) {
            return false;
        }
        String str = Build.MODEL;
        if (!str.equals(str) || this.f10661b != m1Var.f10661b || this.f10662c != m1Var.f10662c || this.f10663d != m1Var.f10663d || this.f10664e != m1Var.f10664e || this.f != m1Var.f) {
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
        int iHashCode = (((((this.f10660a ^ 1000003) * 1000003) ^ Build.MODEL.hashCode()) * 1000003) ^ this.f10661b) * 1000003;
        long j4 = this.f10662c;
        int i = (iHashCode ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j7 = this.f10663d;
        return ((((((((i ^ ((int) (j7 ^ (j7 >>> 32)))) * 1000003) ^ (this.f10664e ? 1231 : 1237)) * 1000003) ^ this.f) * 1000003) ^ Build.MANUFACTURER.hashCode()) * 1000003) ^ Build.PRODUCT.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeviceData{arch=");
        sb.append(this.f10660a);
        sb.append(", model=");
        sb.append(Build.MODEL);
        sb.append(", availableProcessors=");
        sb.append(this.f10661b);
        sb.append(", totalRam=");
        sb.append(this.f10662c);
        sb.append(", diskSpace=");
        sb.append(this.f10663d);
        sb.append(", isEmulator=");
        sb.append(this.f10664e);
        sb.append(", state=");
        sb.append(this.f);
        sb.append(", manufacturer=");
        sb.append(Build.MANUFACTURER);
        sb.append(", modelClass=");
        return q4.a.q(sb, Build.PRODUCT, "}");
    }
}
