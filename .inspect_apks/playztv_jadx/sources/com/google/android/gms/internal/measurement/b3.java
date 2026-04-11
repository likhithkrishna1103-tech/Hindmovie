package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b3 extends j5 {
    private static final b3 zzc;
    private static volatile e6 zzd;
    private int zze;
    private int zzf;
    private q3 zzg;
    private q3 zzh;
    private boolean zzi;

    static {
        b3 b3Var = new b3();
        zzc = b3Var;
        j5.g(b3.class, b3Var);
    }

    public static /* synthetic */ void o(b3 b3Var, int i) {
        b3Var.zze |= 1;
        b3Var.zzf = i;
    }

    public static /* synthetic */ void p(b3 b3Var, q3 q3Var) {
        b3Var.zzg = q3Var;
        b3Var.zze |= 2;
    }

    public static /* synthetic */ void q(b3 b3Var, boolean z2) {
        b3Var.zze |= 8;
        b3Var.zzi = z2;
    }

    public static a3 r() {
        return (a3) zzc.j();
    }

    public static /* synthetic */ void s(b3 b3Var, q3 q3Var) {
        q3Var.getClass();
        b3Var.zzh = q3Var;
        b3Var.zze |= 4;
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final Object e(int i) {
        e6 k5Var;
        switch (u2.f3209a[i - 1]) {
            case 1:
                return new b3();
            case 2:
                return new a3(zzc);
            case 3:
                return new i6(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return zzc;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                e6 e6Var = zzd;
                if (e6Var != null) {
                    return e6Var;
                }
                synchronized (b3.class) {
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

    public final q3 t() {
        q3 q3Var = this.zzg;
        return q3Var == null ? q3.A() : q3Var;
    }

    public final q3 u() {
        q3 q3Var = this.zzh;
        return q3Var == null ? q3.A() : q3Var;
    }

    public final boolean v() {
        return this.zzi;
    }

    public final boolean w() {
        return (this.zze & 1) != 0;
    }

    public final boolean x() {
        return (this.zze & 8) != 0;
    }

    public final boolean y() {
        return (this.zze & 4) != 0;
    }
}
