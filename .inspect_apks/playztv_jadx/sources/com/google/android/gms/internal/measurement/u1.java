package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u1 extends j5 {
    private static final u1 zzc;
    private static volatile e6 zzd;
    private int zze;
    private int zzf;
    private s5 zzg;
    private s5 zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        u1 u1Var = new u1();
        zzc = u1Var;
        j5.g(u1.class, u1Var);
    }

    public u1() {
        g6 g6Var = g6.f3017y;
        this.zzg = g6Var;
        this.zzh = g6Var;
    }

    public static void p(u1 u1Var, int i, w1 w1Var) {
        s5 s5Var = u1Var.zzh;
        if (!((v4) s5Var).f3217u) {
            u1Var.zzh = s5Var.c(s5Var.size() << 1);
        }
        u1Var.zzh.set(i, w1Var);
    }

    public static void q(u1 u1Var, int i, c2 c2Var) {
        s5 s5Var = u1Var.zzg;
        if (!((v4) s5Var).f3217u) {
            u1Var.zzg = s5Var.c(s5Var.size() << 1);
        }
        u1Var.zzg.set(i, c2Var);
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final Object e(int i) {
        e6 k5Var;
        switch (s1.f3187a[i - 1]) {
            case 1:
                return new u1();
            case 2:
                return new t1(zzc);
            case 3:
                return new i6(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zze", "zzf", "zzg", c2.class, "zzh", w1.class, "zzi", "zzj"});
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return zzc;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                e6 e6Var = zzd;
                if (e6Var != null) {
                    return e6Var;
                }
                synchronized (u1.class) {
                    try {
                        k5Var = zzd;
                        if (k5Var == null) {
                            k5Var = new k5(6);
                            zzd = k5Var;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return k5Var;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return (byte) 1;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final int n() {
        return this.zzf;
    }

    public final w1 o(int i) {
        return (w1) this.zzh.get(i);
    }

    public final int r() {
        return this.zzh.size();
    }

    public final c2 s(int i) {
        return (c2) this.zzg.get(i);
    }

    public final int t() {
        return this.zzg.size();
    }

    public final List u() {
        return this.zzh;
    }

    public final List v() {
        return this.zzg;
    }

    public final boolean w() {
        return (this.zze & 1) != 0;
    }
}
