package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a2 extends i5 {
    private static final a2 zzi;
    private int zzb;
    private o5 zzd;
    private o5 zze;
    private o5 zzf;
    private boolean zzg;
    private o5 zzh;

    static {
        a2 a2Var = new a2();
        zzi = a2Var;
        i5.m(a2.class, a2Var);
    }

    public a2() {
        h6 h6Var = h6.f2472z;
        this.zzd = h6Var;
        this.zze = h6Var;
        this.zzf = h6Var;
        this.zzh = h6Var;
    }

    public static a2 v() {
        return zzi;
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zzb", "zzd", x1.class, "zze", y1.class, "zzf", z1.class, "zzg", "zzh", x1.class});
        }
        if (i10 == 3) {
            return new a2();
        }
        if (i10 == 4) {
            return new r1(zzi);
        }
        if (i10 == 5) {
            return zzi;
        }
        throw null;
    }

    public final List p() {
        return this.zzd;
    }

    public final List q() {
        return this.zze;
    }

    public final List r() {
        return this.zzf;
    }

    public final boolean s() {
        return (this.zzb & 1) != 0;
    }

    public final boolean t() {
        return this.zzg;
    }

    public final o5 u() {
        return this.zzh;
    }
}
