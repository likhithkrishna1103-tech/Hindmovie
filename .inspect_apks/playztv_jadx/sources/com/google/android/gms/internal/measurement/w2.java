package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w2 extends j5 {
    private static final w2 zzc;
    private static volatile e6 zzd;
    private int zze;
    private long zzi;
    private long zzm;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";

    static {
        w2 w2Var = new w2();
        zzc = w2Var;
        j5.g(w2.class, w2Var);
    }

    public static w2 A() {
        return zzc;
    }

    public static /* synthetic */ void B(w2 w2Var) {
        w2Var.zze &= -33;
        w2Var.zzk = zzc.zzk;
    }

    public static /* synthetic */ void C(w2 w2Var, String str) {
        w2Var.zze |= 32;
        w2Var.zzk = str;
    }

    public static /* synthetic */ void E(w2 w2Var) {
        w2Var.zze &= -17;
        w2Var.zzj = zzc.zzj;
    }

    public static /* synthetic */ void F(w2 w2Var, String str) {
        w2Var.zze |= 16;
        w2Var.zzj = str;
    }

    public static /* synthetic */ void o(w2 w2Var) {
        w2Var.zze &= -5;
        w2Var.zzh = zzc.zzh;
    }

    public static /* synthetic */ void p(w2 w2Var, long j5) {
        w2Var.zze |= 8;
        w2Var.zzi = j5;
    }

    public static /* synthetic */ void q(w2 w2Var, String str) {
        w2Var.zze |= 4;
        w2Var.zzh = str;
    }

    public static /* synthetic */ void s(w2 w2Var) {
        w2Var.zze &= -3;
        w2Var.zzg = zzc.zzg;
    }

    public static /* synthetic */ void t(w2 w2Var, long j5) {
        w2Var.zze |= 128;
        w2Var.zzm = j5;
    }

    public static /* synthetic */ void u(w2 w2Var, String str) {
        w2Var.zze |= 2;
        w2Var.zzg = str;
    }

    public static /* synthetic */ void v(w2 w2Var) {
        w2Var.zze &= -2;
        w2Var.zzf = zzc.zzf;
    }

    public static /* synthetic */ void w(w2 w2Var, String str) {
        w2Var.zze |= 1;
        w2Var.zzf = str;
    }

    public static v2 x() {
        return (v2) zzc.j();
    }

    public static /* synthetic */ void y(w2 w2Var) {
        w2Var.zze &= -65;
        w2Var.zzl = zzc.zzl;
    }

    public static /* synthetic */ void z(w2 w2Var, String str) {
        w2Var.zze |= 64;
        w2Var.zzl = str;
    }

    public final String D() {
        return this.zzh;
    }

    public final String G() {
        return this.zzg;
    }

    public final String H() {
        return this.zzf;
    }

    public final String I() {
        return this.zzl;
    }

    public final String J() {
        return this.zzk;
    }

    public final String K() {
        return this.zzj;
    }

    public final boolean L() {
        return (this.zze & 4) != 0;
    }

    public final boolean M() {
        return (this.zze & 2) != 0;
    }

    public final boolean N() {
        return (this.zze & 1) != 0;
    }

    public final boolean O() {
        return (this.zze & 8) != 0;
    }

    public final boolean P() {
        return (this.zze & 128) != 0;
    }

    public final boolean Q() {
        return (this.zze & 64) != 0;
    }

    public final boolean R() {
        return (this.zze & 32) != 0;
    }

    public final boolean S() {
        return (this.zze & 16) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final Object e(int i) {
        e6 k5Var;
        switch (u2.f3209a[i - 1]) {
            case 1:
                return new w2();
            case 2:
                return new v2(zzc);
            case 3:
                return new i6(zzc, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဂ\u0007", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return zzc;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                e6 e6Var = zzd;
                if (e6Var != null) {
                    return e6Var;
                }
                synchronized (w2.class) {
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

    public final long n() {
        return this.zzi;
    }

    public final long r() {
        return this.zzm;
    }
}
