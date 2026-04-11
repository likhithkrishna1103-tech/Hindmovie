package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n2 extends j5 {
    private static final n2 zzc;
    private static volatile e6 zzd;
    private int zze;
    private long zzf;
    private String zzg = "";
    private int zzh;
    private s5 zzi;
    private s5 zzj;
    private s5 zzk;
    private String zzl;
    private boolean zzm;
    private s5 zzn;
    private s5 zzo;
    private String zzp;
    private String zzq;
    private i2 zzr;
    private p2 zzs;
    private s2 zzt;
    private q2 zzu;
    private o2 zzv;

    static {
        n2 n2Var = new n2();
        zzc = n2Var;
        j5.g(n2.class, n2Var);
    }

    public n2() {
        g6 g6Var = g6.f3017y;
        this.zzi = g6Var;
        this.zzj = g6Var;
        this.zzk = g6Var;
        this.zzl = "";
        this.zzn = g6Var;
        this.zzo = g6Var;
        this.zzp = "";
        this.zzq = "";
    }

    public static void p(n2 n2Var) {
        n2Var.zzk = g6.f3017y;
    }

    public static void q(n2 n2Var, int i, l2 l2Var) {
        s5 s5Var = n2Var.zzj;
        if (!((v4) s5Var).f3217u) {
            n2Var.zzj = s5Var.c(s5Var.size() << 1);
        }
        n2Var.zzj.set(i, l2Var);
    }

    public static m2 u() {
        return (m2) zzc.j();
    }

    public static n2 v() {
        return zzc;
    }

    public final s5 A() {
        return this.zzo;
    }

    public final s5 B() {
        return this.zzn;
    }

    public final s5 C() {
        return this.zzi;
    }

    public final boolean D() {
        return (this.zze & 128) != 0;
    }

    public final boolean E() {
        return (this.zze & 2) != 0;
    }

    public final boolean F() {
        return (this.zze & 512) != 0;
    }

    public final boolean G() {
        return (this.zze & 1) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final Object e(int i) {
        e6 k5Var;
        switch (t2.f3196a[i - 1]) {
            case 1:
                return new n2();
            case 2:
                return new m2(zzc);
            case 3:
                return new i6(zzc, "\u0004\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", r2.class, "zzj", l2.class, "zzk", u1.class, "zzl", "zzm", "zzn", x3.class, "zzo", j2.class, "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv"});
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return zzc;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                e6 e6Var = zzd;
                if (e6Var != null) {
                    return e6Var;
                }
                synchronized (n2.class) {
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
        return this.zzn.size();
    }

    public final l2 o(int i) {
        return (l2) this.zzj.get(i);
    }

    public final int r() {
        return this.zzj.size();
    }

    public final long s() {
        return this.zzf;
    }

    public final i2 t() {
        i2 i2Var = this.zzr;
        return i2Var == null ? i2.n() : i2Var;
    }

    public final s2 w() {
        s2 s2Var = this.zzt;
        return s2Var == null ? s2.o() : s2Var;
    }

    public final String x() {
        return this.zzg;
    }

    public final String y() {
        return this.zzp;
    }

    public final List z() {
        return this.zzk;
    }
}
