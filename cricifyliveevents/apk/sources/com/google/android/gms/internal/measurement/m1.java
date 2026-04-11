package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m1 extends i5 {
    private static final m1 zzi;
    private int zzb;
    private int zzd;
    private o5 zze;
    private o5 zzf;
    private boolean zzg;
    private boolean zzh;

    static {
        m1 m1Var = new m1();
        zzi = m1Var;
        i5.m(m1.class, m1Var);
    }

    public m1() {
        h6 h6Var = h6.f2472z;
        this.zze = h6Var;
        this.zzf = h6Var;
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzb", "zzd", "zze", v1.class, "zzf", o1.class, "zzg", "zzh"});
        }
        if (i10 == 3) {
            return new m1();
        }
        if (i10 == 4) {
            return new l1(zzi);
        }
        if (i10 == 5) {
            return zzi;
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
        return this.zze.size();
    }

    public final v1 t(int i) {
        return (v1) this.zze.get(i);
    }

    public final o5 u() {
        return this.zzf;
    }

    public final int v() {
        return this.zzf.size();
    }

    public final o1 w(int i) {
        return (o1) this.zzf.get(i);
    }

    public final void x(int i, v1 v1Var) {
        o5 o5Var = this.zze;
        if (!((v4) o5Var).f2661v) {
            int size = o5Var.size();
            this.zze = o5Var.e(size + size);
        }
        this.zze.set(i, v1Var);
    }

    public final void y(int i, o1 o1Var) {
        o5 o5Var = this.zzf;
        if (!((v4) o5Var).f2661v) {
            int size = o5Var.size();
            this.zzf = o5Var.e(size + size);
        }
        this.zzf.set(i, o1Var);
    }
}
