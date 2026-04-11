package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y1 extends j5 {
    private static final y1 zzc;
    private static volatile e6 zzd;
    private int zze;
    private d2 zzf;
    private a2 zzg;
    private boolean zzh;
    private String zzi = "";

    static {
        y1 y1Var = new y1();
        zzc = y1Var;
        j5.g(y1.class, y1Var);
    }

    public static /* synthetic */ void n(y1 y1Var, String str) {
        y1Var.zze |= 8;
        y1Var.zzi = str;
    }

    public static y1 o() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final Object e(int i) {
        e6 k5Var;
        switch (s1.f3187a[i - 1]) {
            case 1:
                return new y1();
            case 2:
                return new x1(zzc);
            case 3:
                return new i6(zzc, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return zzc;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                e6 e6Var = zzd;
                if (e6Var != null) {
                    return e6Var;
                }
                synchronized (y1.class) {
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

    public final a2 p() {
        a2 a2Var = this.zzg;
        return a2Var == null ? a2.o() : a2Var;
    }

    public final d2 q() {
        d2 d2Var = this.zzf;
        return d2Var == null ? d2.p() : d2Var;
    }

    public final String r() {
        return this.zzi;
    }

    public final boolean s() {
        return this.zzh;
    }

    public final boolean t() {
        return (this.zze & 4) != 0;
    }

    public final boolean u() {
        return (this.zze & 2) != 0;
    }

    public final boolean v() {
        return (this.zze & 8) != 0;
    }

    public final boolean w() {
        return (this.zze & 1) != 0;
    }
}
