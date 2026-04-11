package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f3 extends j5 {
    private static final f3 zzc;
    private static volatile e6 zzd;
    private int zze;
    private s5 zzf = g6.f3017y;
    private String zzg = "";
    private long zzh;
    private long zzi;
    private int zzj;

    static {
        f3 f3Var = new f3();
        zzc = f3Var;
        j5.g(f3.class, f3Var);
    }

    public static e3 A() {
        return (e3) zzc.j();
    }

    public static /* synthetic */ void p(int i, f3 f3Var) {
        f3Var.G();
        f3Var.zzf.remove(i);
    }

    public static /* synthetic */ void q(long j5, f3 f3Var) {
        f3Var.zze |= 4;
        f3Var.zzi = j5;
    }

    public static void r(f3 f3Var) {
        f3Var.zzf = g6.f3017y;
    }

    public static /* synthetic */ void s(f3 f3Var, int i, i3 i3Var) {
        f3Var.G();
        f3Var.zzf.set(i, i3Var);
    }

    public static /* synthetic */ void t(f3 f3Var, i3 i3Var) {
        i3Var.getClass();
        f3Var.G();
        f3Var.zzf.add(i3Var);
    }

    public static /* synthetic */ void u(f3 f3Var, Iterable iterable) {
        f3Var.G();
        u4.b(iterable, f3Var.zzf);
    }

    public static /* synthetic */ void v(f3 f3Var, String str) {
        str.getClass();
        f3Var.zze |= 1;
        f3Var.zzg = str;
    }

    public static /* synthetic */ void x(long j5, f3 f3Var) {
        f3Var.zze |= 2;
        f3Var.zzh = j5;
    }

    public final String B() {
        return this.zzg;
    }

    public final s5 C() {
        return this.zzf;
    }

    public final boolean D() {
        return (this.zze & 8) != 0;
    }

    public final boolean E() {
        return (this.zze & 4) != 0;
    }

    public final boolean F() {
        return (this.zze & 2) != 0;
    }

    public final void G() {
        s5 s5Var = this.zzf;
        if (((v4) s5Var).f3217u) {
            return;
        }
        this.zzf = s5Var.c(s5Var.size() << 1);
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final Object e(int i) {
        e6 k5Var;
        int i10 = 6;
        switch (u2.f3209a[i - 1]) {
            case 1:
                return new f3();
            case 2:
                return new e3(zzc);
            case 3:
                return new i6(zzc, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zze", "zzf", i3.class, "zzg", "zzh", "zzi", "zzj"});
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return zzc;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                e6 e6Var = zzd;
                if (e6Var != null) {
                    return e6Var;
                }
                synchronized (f3.class) {
                    try {
                        k5Var = zzd;
                        if (k5Var == null) {
                            k5Var = new k5(i10);
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
        return this.zzj;
    }

    public final i3 o(int i) {
        return (i3) this.zzf.get(i);
    }

    public final int w() {
        return this.zzf.size();
    }

    public final long y() {
        return this.zzi;
    }

    public final long z() {
        return this.zzh;
    }
}
