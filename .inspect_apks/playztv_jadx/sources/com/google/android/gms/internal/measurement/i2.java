package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i2 extends j5 {
    private static final i2 zzc;
    private static volatile e6 zzd;
    private int zze;
    private s5 zzf;
    private s5 zzg;
    private s5 zzh;
    private boolean zzi;
    private s5 zzj;

    static {
        i2 i2Var = new i2();
        zzc = i2Var;
        j5.g(i2.class, i2Var);
    }

    public i2() {
        g6 g6Var = g6.f3017y;
        this.zzf = g6Var;
        this.zzg = g6Var;
        this.zzh = g6Var;
        this.zzj = g6Var;
    }

    public static i2 n() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final Object e(int i) {
        e6 k5Var;
        switch (t2.f3196a[i - 1]) {
            case 1:
                return new i2();
            case 2:
                return new z1(zzc);
            case 3:
                return new i6(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zze", "zzf", f2.class, "zzg", g2.class, "zzh", h2.class, "zzi", "zzj", f2.class});
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return zzc;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                e6 e6Var = zzd;
                if (e6Var != null) {
                    return e6Var;
                }
                synchronized (i2.class) {
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

    public final s5 o() {
        return this.zzh;
    }

    public final List p() {
        return this.zzf;
    }

    public final List q() {
        return this.zzg;
    }

    public final List r() {
        return this.zzj;
    }

    public final boolean s() {
        return this.zzi;
    }

    public final boolean t() {
        return (this.zze & 1) != 0;
    }
}
