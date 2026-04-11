package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u3 extends j5 {
    private static final u3 zzc;
    private static volatile e6 zzd;
    private int zze;
    private long zzf;
    private String zzg = "";
    private String zzh = "";
    private long zzi;
    private float zzj;
    private double zzk;

    static {
        u3 u3Var = new u3();
        zzc = u3Var;
        j5.g(u3.class, u3Var);
    }

    public static /* synthetic */ void o(u3 u3Var, double d10) {
        u3Var.zze |= 32;
        u3Var.zzk = d10;
    }

    public static /* synthetic */ void p(u3 u3Var, long j5) {
        u3Var.zze |= 8;
        u3Var.zzi = j5;
    }

    public static /* synthetic */ void q(u3 u3Var, String str) {
        str.getClass();
        u3Var.zze |= 2;
        u3Var.zzg = str;
    }

    public static /* synthetic */ void r(u3 u3Var) {
        u3Var.zze &= -33;
        u3Var.zzk = 0.0d;
    }

    public static /* synthetic */ void t(u3 u3Var) {
        u3Var.zze &= -9;
        u3Var.zzi = 0L;
    }

    public static /* synthetic */ void u(u3 u3Var, long j5) {
        u3Var.zze |= 1;
        u3Var.zzf = j5;
    }

    public static /* synthetic */ void v(u3 u3Var, String str) {
        str.getClass();
        u3Var.zze |= 4;
        u3Var.zzh = str;
    }

    public static /* synthetic */ void x(u3 u3Var) {
        u3Var.zze &= -5;
        u3Var.zzh = zzc.zzh;
    }

    public static t3 z() {
        return (t3) zzc.j();
    }

    public final String A() {
        return this.zzg;
    }

    public final String B() {
        return this.zzh;
    }

    public final boolean C() {
        return (this.zze & 32) != 0;
    }

    public final boolean D() {
        return (this.zze & 16) != 0;
    }

    public final boolean E() {
        return (this.zze & 8) != 0;
    }

    public final boolean F() {
        return (this.zze & 1) != 0;
    }

    public final boolean G() {
        return (this.zze & 4) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final Object e(int i) {
        e6 k5Var;
        switch (u2.f3209a[i - 1]) {
            case 1:
                return new u3();
            case 2:
                return new t3(zzc);
            case 3:
                return new i6(zzc, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return zzc;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                e6 e6Var = zzd;
                if (e6Var != null) {
                    return e6Var;
                }
                synchronized (u3.class) {
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

    public final float s() {
        return this.zzj;
    }

    public final long w() {
        return this.zzi;
    }

    public final long y() {
        return this.zzf;
    }
}
