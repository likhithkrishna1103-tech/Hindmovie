package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c2 extends j5 {
    private static final c2 zzc;
    private static volatile e6 zzd;
    private int zze;
    private int zzf;
    private String zzg = "";
    private y1 zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    static {
        c2 c2Var = new c2();
        zzc = c2Var;
        j5.g(c2.class, c2Var);
    }

    public static /* synthetic */ void o(c2 c2Var, String str) {
        c2Var.zze |= 2;
        c2Var.zzg = str;
    }

    public static b2 q() {
        return (b2) zzc.j();
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final Object e(int i) {
        e6 k5Var;
        switch (s1.f3187a[i - 1]) {
            case 1:
                return new c2();
            case 2:
                return new b2(zzc);
            case 3:
                return new i6(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return zzc;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                e6 e6Var = zzd;
                if (e6Var != null) {
                    return e6Var;
                }
                synchronized (c2.class) {
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

    public final y1 p() {
        y1 y1Var = this.zzh;
        return y1Var == null ? y1.o() : y1Var;
    }

    public final String r() {
        return this.zzg;
    }

    public final boolean s() {
        return this.zzi;
    }

    public final boolean t() {
        return this.zzj;
    }

    public final boolean u() {
        return this.zzk;
    }

    public final boolean v() {
        return (this.zze & 1) != 0;
    }

    public final boolean w() {
        return (this.zze & 32) != 0;
    }
}
