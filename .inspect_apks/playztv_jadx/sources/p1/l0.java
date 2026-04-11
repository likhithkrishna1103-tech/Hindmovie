package p1;

import java.util.Arrays;
import java.util.List;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k0[] f9896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9897b;

    public l0(k0... k0VarArr) {
        this(-9223372036854775807L, k0VarArr);
    }

    public final l0 a(k0... k0VarArr) {
        if (k0VarArr.length == 0) {
            return this;
        }
        int i = s1.b0.f11647a;
        k0[] k0VarArr2 = this.f9896a;
        Object[] objArrCopyOf = Arrays.copyOf(k0VarArr2, k0VarArr2.length + k0VarArr.length);
        System.arraycopy(k0VarArr, 0, objArrCopyOf, k0VarArr2.length, k0VarArr.length);
        return new l0(this.f9897b, (k0[]) objArrCopyOf);
    }

    public final l0 b(l0 l0Var) {
        return l0Var == null ? this : a(l0Var.f9896a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l0.class == obj.getClass()) {
            l0 l0Var = (l0) obj;
            if (Arrays.equals(this.f9896a, l0Var.f9896a) && this.f9897b == l0Var.f9897b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return t1.r(this.f9897b) + (Arrays.hashCode(this.f9896a) * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("entries=");
        sb2.append(Arrays.toString(this.f9896a));
        long j5 = this.f9897b;
        if (j5 == -9223372036854775807L) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j5;
        }
        sb2.append(str);
        return sb2.toString();
    }

    public l0(long j5, k0... k0VarArr) {
        this.f9897b = j5;
        this.f9896a = k0VarArr;
    }

    public l0(List list) {
        this((k0[]) list.toArray(new k0[0]));
    }
}
