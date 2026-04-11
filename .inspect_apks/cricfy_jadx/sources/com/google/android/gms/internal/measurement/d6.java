package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d6 implements j6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u4 f2366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g5 f2367b;

    public d6(g5 g5Var, u4 u4Var) {
        g5 g5Var2 = d5.f2365a;
        this.f2367b = g5Var;
        this.f2366a = u4Var;
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final i5 a() {
        u4 u4Var = this.f2366a;
        return u4Var instanceof i5 ? (i5) ((i5) u4Var).o(4) : ((h5) ((i5) u4Var).o(5)).d();
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final void b(Object obj) {
        this.f2367b.getClass();
        n6 n6Var = ((i5) obj).zzc;
        if (n6Var.f2554e) {
            n6Var.f2554e = false;
        }
        g5 g5Var = d5.f2365a;
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final void c(Object obj, byte[] bArr, int i, int i10, x4 x4Var) {
        i5 i5Var = (i5) obj;
        if (i5Var.zzc == n6.f) {
            i5Var.zzc = n6.a();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final void d(Object obj, Object obj2) {
        k6.b(obj, obj2);
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final int e(u4 u4Var) {
        n6 n6Var = ((i5) u4Var).zzc;
        int i = n6Var.f2553d;
        if (i != -1) {
            return i;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < n6Var.f2550a; i11++) {
            int i12 = n6Var.f2551b[i11] >>> 3;
            a5 a5Var = (a5) n6Var.f2552c[i11];
            int iV0 = b5.v0(8);
            int iV02 = b5.v0(i12) + b5.v0(16);
            int iV03 = b5.v0(24);
            int iC = a5Var.c();
            i10 += iV0 + iV0 + iV02 + q4.a.i(iC, iC, iV03);
        }
        n6Var.f2553d = i10;
        return i10;
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final int f(i5 i5Var) {
        return i5Var.zzc.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final void g(Object obj, w5 w5Var) {
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final boolean h(Object obj) {
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.measurement.j6
    public final boolean i(i5 i5Var, i5 i5Var2) {
        return i5Var.zzc.equals(i5Var2.zzc);
    }
}
