package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y3 extends j5 {
    private static final y3 zzc;
    private static volatile e6 zzd;
    private int zze;
    private int zzf;
    private s5 zzg = g6.f3017y;
    private String zzh = "";
    private String zzi = "";
    private boolean zzj;
    private double zzk;

    static {
        y3 y3Var = new y3();
        zzc = y3Var;
        j5.g(y3.class, y3Var);
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final Object e(int i) {
        e6 k5Var;
        switch (z3.f3256a[i - 1]) {
            case 1:
                return new y3();
            case 2:
                return new z1(zzc);
            case 3:
                return new i6(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zze", "zzf", e2.i, "zzg", y3.class, "zzh", "zzi", "zzj", "zzk"});
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return zzc;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                e6 e6Var = zzd;
                if (e6Var != null) {
                    return e6Var;
                }
                synchronized (y3.class) {
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

    public final double n() {
        return this.zzk;
    }

    public final int o() {
        int iF = l4.a.f(this.zzf);
        if (iF == 0) {
            return 1;
        }
        return iF;
    }

    public final String p() {
        return this.zzh;
    }

    public final String q() {
        return this.zzi;
    }

    public final List r() {
        return this.zzg;
    }

    public final boolean s() {
        return this.zzj;
    }

    public final boolean t() {
        return (this.zze & 8) != 0;
    }

    public final boolean u() {
        return (this.zze & 16) != 0;
    }

    public final boolean v() {
        return (this.zze & 4) != 0;
    }
}
