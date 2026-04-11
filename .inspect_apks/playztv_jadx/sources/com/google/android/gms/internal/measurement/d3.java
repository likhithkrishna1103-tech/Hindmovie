package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d3 extends j5 {
    private static final d3 zzc;
    private static volatile e6 zzd;
    private int zze;
    private int zzf;
    private long zzg;

    static {
        d3 d3Var = new d3();
        zzc = d3Var;
        j5.g(d3.class, d3Var);
    }

    public static /* synthetic */ void o(d3 d3Var, int i) {
        d3Var.zze |= 1;
        d3Var.zzf = i;
    }

    public static /* synthetic */ void p(d3 d3Var, long j5) {
        d3Var.zze |= 2;
        d3Var.zzg = j5;
    }

    public static c3 r() {
        return (c3) zzc.j();
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final Object e(int i) {
        e6 k5Var;
        switch (u2.f3209a[i - 1]) {
            case 1:
                return new d3();
            case 2:
                return new c3(zzc);
            case 3:
                return new i6(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return zzc;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                e6 e6Var = zzd;
                if (e6Var != null) {
                    return e6Var;
                }
                synchronized (d3.class) {
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

    public final long q() {
        return this.zzg;
    }

    public final boolean s() {
        return (this.zze & 2) != 0;
    }

    public final boolean t() {
        return (this.zze & 1) != 0;
    }
}
