package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o3 extends i5 {
    private static final o3 zzf;
    private int zzb;
    private int zzd;
    private n5 zze = v5.f2663z;

    static {
        o3 o3Var = new o3();
        zzf = o3Var;
        i5.m(o3.class, o3Var);
    }

    public static n3 u() {
        return (n3) zzf.h();
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i10 == 3) {
            return new o3();
        }
        if (i10 == 4) {
            return new n3(zzf);
        }
        if (i10 == 5) {
            return zzf;
        }
        throw null;
    }

    public final boolean p() {
        return (this.zzb & 1) != 0;
    }

    public final int q() {
        return this.zzd;
    }

    public final List r() {
        return this.zze;
    }

    public final int s() {
        return ((v5) this.zze).size();
    }

    public final long t(int i) {
        return ((v5) this.zze).b(i);
    }

    public final /* synthetic */ void v(int i) {
        this.zzb |= 1;
        this.zzd = i;
    }

    public final void w(List list) {
        RandomAccess randomAccess = this.zze;
        if (!((v4) randomAccess).f2661v) {
            v5 v5Var = (v5) randomAccess;
            int i = v5Var.f2665x;
            this.zze = v5Var.e(i + i);
        }
        u4.c(list, this.zze);
    }
}
