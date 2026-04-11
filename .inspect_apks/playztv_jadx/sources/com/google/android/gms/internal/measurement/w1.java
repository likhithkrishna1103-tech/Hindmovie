package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w1 extends j5 {
    private static final w1 zzc;
    private static volatile e6 zzd;
    private int zze;
    private int zzf;
    private String zzg = "";
    private s5 zzh = g6.f3017y;
    private boolean zzi;
    private a2 zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;

    static {
        w1 w1Var = new w1();
        zzc = w1Var;
        j5.g(w1.class, w1Var);
    }

    public static void p(w1 w1Var, int i, y1 y1Var) {
        s5 s5Var = w1Var.zzh;
        if (!((v4) s5Var).f3217u) {
            w1Var.zzh = s5Var.c(s5Var.size() << 1);
        }
        w1Var.zzh.set(i, y1Var);
    }

    public static /* synthetic */ void q(w1 w1Var, String str) {
        w1Var.zze |= 2;
        w1Var.zzg = str;
    }

    public static v1 s() {
        return (v1) zzc.j();
    }

    public final boolean A() {
        return (this.zze & 1) != 0;
    }

    public final boolean B() {
        return (this.zze & 64) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final Object e(int i) {
        e6 k5Var;
        switch (s1.f3187a[i - 1]) {
            case 1:
                return new w1();
            case 2:
                return new v1(zzc);
            case 3:
                return new i6(zzc, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", y1.class, "zzi", "zzj", "zzk", "zzl", "zzm"});
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return zzc;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                e6 e6Var = zzd;
                if (e6Var != null) {
                    return e6Var;
                }
                synchronized (w1.class) {
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
        return this.zzh.size();
    }

    public final y1 o(int i) {
        return (y1) this.zzh.get(i);
    }

    public final int r() {
        return this.zzf;
    }

    public final a2 t() {
        a2 a2Var = this.zzj;
        return a2Var == null ? a2.o() : a2Var;
    }

    public final String u() {
        return this.zzg;
    }

    public final s5 v() {
        return this.zzh;
    }

    public final boolean w() {
        return this.zzk;
    }

    public final boolean x() {
        return this.zzl;
    }

    public final boolean y() {
        return this.zzm;
    }

    public final boolean z() {
        return (this.zze & 8) != 0;
    }
}
