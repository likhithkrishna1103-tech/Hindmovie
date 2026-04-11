package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m3 extends i5 {
    private static final m3 zzg;
    private n5 zzb;
    private n5 zzd;
    private o5 zze;
    private o5 zzf;

    static {
        m3 m3Var = new m3();
        zzg = m3Var;
        i5.m(m3.class, m3Var);
    }

    public m3() {
        v5 v5Var = v5.f2663z;
        this.zzb = v5Var;
        this.zzd = v5Var;
        h6 h6Var = h6.f2472z;
        this.zze = h6Var;
        this.zzf = h6Var;
    }

    public static l3 x() {
        return (l3) zzg.h();
    }

    public static m3 y() {
        return zzg;
    }

    public final void A() {
        this.zzb = v5.f2663z;
    }

    public final void B(List list) {
        RandomAccess randomAccess = this.zzd;
        if (!((v4) randomAccess).f2661v) {
            v5 v5Var = (v5) randomAccess;
            int i = v5Var.f2665x;
            this.zzd = v5Var.e(i + i);
        }
        u4.c(list, this.zzd);
    }

    public final void C() {
        this.zzd = v5.f2663z;
    }

    public final void D(ArrayList arrayList) {
        o5 o5Var = this.zze;
        if (!((v4) o5Var).f2661v) {
            int size = o5Var.size();
            this.zze = o5Var.e(size + size);
        }
        u4.c(arrayList, this.zze);
    }

    public final void E() {
        this.zze = h6.f2472z;
    }

    public final void F(Iterable iterable) {
        o5 o5Var = this.zzf;
        if (!((v4) o5Var).f2661v) {
            int size = o5Var.size();
            this.zzf = o5Var.e(size + size);
        }
        u4.c(iterable, this.zzf);
    }

    public final void G() {
        this.zzf = h6.f2472z;
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzg, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzb", "zzd", "zze", z2.class, "zzf", o3.class});
        }
        if (i10 == 3) {
            return new m3();
        }
        if (i10 == 4) {
            return new l3(zzg);
        }
        if (i10 == 5) {
            return zzg;
        }
        throw null;
    }

    public final List p() {
        return this.zzb;
    }

    public final int q() {
        return ((v5) this.zzb).size();
    }

    public final List r() {
        return this.zzd;
    }

    public final int s() {
        return ((v5) this.zzd).size();
    }

    public final o5 t() {
        return this.zze;
    }

    public final int u() {
        return this.zze.size();
    }

    public final List v() {
        return this.zzf;
    }

    public final int w() {
        return this.zzf.size();
    }

    public final void z(Iterable iterable) {
        RandomAccess randomAccess = this.zzb;
        if (!((v4) randomAccess).f2661v) {
            v5 v5Var = (v5) randomAccess;
            int i = v5Var.f2665x;
            this.zzb = v5Var.e(i + i);
        }
        u4.c(iterable, this.zzb);
    }
}
