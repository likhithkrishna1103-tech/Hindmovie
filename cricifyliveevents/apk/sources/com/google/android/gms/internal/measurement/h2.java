package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h2 extends i5 {
    private static final h2 zzi;
    private int zzb;
    private int zzd = 14;
    private int zze = 11;
    private int zzf = 60;
    private int zzg = 13;
    private int zzh = 11;

    static {
        h2 h2Var = new h2();
        zzi = h2Var;
        i5.m(h2.class, h2Var);
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i10 == 3) {
            return new h2();
        }
        if (i10 == 4) {
            return new r1(zzi);
        }
        if (i10 == 5) {
            return zzi;
        }
        throw null;
    }
}
