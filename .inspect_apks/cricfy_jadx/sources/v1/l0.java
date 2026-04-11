package v1;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k0[] f12828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12829b;

    public l0(k0... k0VarArr) {
        this(-9223372036854775807L, k0VarArr);
    }

    public final l0 a(k0... k0VarArr) {
        if (k0VarArr.length == 0) {
            return this;
        }
        int i = y1.a0.f14551a;
        k0[] k0VarArr2 = this.f12828a;
        Object[] objArrCopyOf = Arrays.copyOf(k0VarArr2, k0VarArr2.length + k0VarArr.length);
        System.arraycopy(k0VarArr, 0, objArrCopyOf, k0VarArr2.length, k0VarArr.length);
        return new l0(this.f12829b, (k0[]) objArrCopyOf);
    }

    public final l0 b(l0 l0Var) {
        return l0Var == null ? this : a(l0Var.f12828a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l0.class == obj.getClass()) {
            l0 l0Var = (l0) obj;
            if (Arrays.equals(this.f12828a, l0Var.f12828a) && this.f12829b == l0Var.f12829b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return com.bumptech.glide.e.g(this.f12829b) + (Arrays.hashCode(this.f12828a) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("entries=");
        sb.append(Arrays.toString(this.f12828a));
        long j4 = this.f12829b;
        if (j4 == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j4;
        }
        sb.append(str);
        return sb.toString();
    }

    public l0(long j4, k0... k0VarArr) {
        this.f12829b = j4;
        this.f12828a = k0VarArr;
    }

    public l0(List list) {
        this((k0[]) list.toArray(new k0[0]));
    }
}
