package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d6 implements j6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u4 f2937a;

    public d6(u4 u4Var) {
        this.f2937a = u4Var;
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final j5 a() {
        u4 u4Var = this.f2937a;
        return u4Var instanceof j5 ? (j5) ((j5) u4Var).e(4) : ((i5) ((j5) u4Var).e(5)).d();
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final boolean b(Object obj) {
        l4.a.t(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final int c(j5 j5Var) {
        return j5Var.zzb.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final void d(Object obj) {
        k6 k6Var = ((j5) obj).zzb;
        if (k6Var.f3078e) {
            k6Var.f3078e = false;
        }
        l4.a.t(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final int e(j5 j5Var) {
        k6 k6Var = j5Var.zzb;
        int i = k6Var.f3077d;
        if (i != -1) {
            return i;
        }
        int iP = 0;
        for (int i10 = 0; i10 < k6Var.f3074a; i10++) {
            int i11 = k6Var.f3075b[i10] >>> 3;
            iP += b5.p(3, (a5) k6Var.f3076c[i10]) + l4.a.w(i11, b5.w(16), b5.w(8) << 1);
        }
        k6Var.f3077d = iP;
        return iP;
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final void f(Object obj, Object obj2) {
        m4.f(obj, obj2);
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final boolean g(j5 j5Var, j5 j5Var2) {
        return j5Var.zzb.equals(j5Var2.zzb);
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final void h(Object obj, byte[] bArr, int i, int i10, y4 y4Var) {
        j5 j5Var = (j5) obj;
        if (j5Var.zzb == k6.f) {
            j5Var.zzb = k6.e();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final void i(Object obj, x5 x5Var) {
        l4.a.t(obj);
        throw null;
    }
}
