package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s3 extends j5 {
    private static final s3 zzc;
    private static volatile e6 zzd;
    private int zze;
    private int zzf;
    private o5 zzg = w5.f3224y;

    static {
        s3 s3Var = new s3();
        zzc = s3Var;
        j5.g(s3.class, s3Var);
    }

    public static /* synthetic */ void p(s3 s3Var, int i) {
        s3Var.zze |= 1;
        s3Var.zzf = i;
    }

    public static void q(s3 s3Var, List list) {
        List list2 = s3Var.zzg;
        if (!((v4) list2).f3217u) {
            s3Var.zzg = ((w5) list2).c(list2.size() << 1);
        }
        u4.b(list, s3Var.zzg);
    }

    public static r3 s() {
        return (r3) zzc.j();
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final Object e(int i) {
        e6 k5Var;
        switch (u2.f3209a[i - 1]) {
            case 1:
                return new s3();
            case 2:
                return new r3(zzc);
            case 3:
                return new i6(zzc, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zze", "zzf", "zzg"});
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return zzc;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                e6 e6Var = zzd;
                if (e6Var != null) {
                    return e6Var;
                }
                synchronized (s3.class) {
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
        return this.zzg.size();
    }

    public final long o(int i) {
        return ((w5) this.zzg).d(i);
    }

    public final int r() {
        return this.zzf;
    }

    public final List t() {
        return this.zzg;
    }

    public final boolean u() {
        return (this.zze & 1) != 0;
    }
}
