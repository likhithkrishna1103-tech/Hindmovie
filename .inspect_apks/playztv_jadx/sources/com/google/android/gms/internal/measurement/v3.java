package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v3 extends j5 {
    private static final v3 zzc;
    private static volatile e6 zzd;
    private s5 zze = g6.f3017y;

    static {
        v3 v3Var = new v3();
        zzc = v3Var;
        j5.g(v3.class, v3Var);
    }

    public static v3 o() {
        return zzc;
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final Object e(int i) {
        e6 k5Var;
        switch (z3.f3256a[i - 1]) {
            case 1:
                return new v3();
            case 2:
                return new z1(zzc);
            case 3:
                return new i6(zzc, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", w3.class});
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return zzc;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                e6 e6Var = zzd;
                if (e6Var != null) {
                    return e6Var;
                }
                synchronized (v3.class) {
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
        return this.zze.size();
    }

    public final List p() {
        return this.zze;
    }
}
