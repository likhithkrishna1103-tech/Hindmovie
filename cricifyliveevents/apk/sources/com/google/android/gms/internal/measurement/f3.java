package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f3 extends i5 {
    private static final f3 zzg;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private p2 zzf;

    static {
        f3 f3Var = new f3();
        zzg = f3Var;
        i5.m(f3.class, f3Var);
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zzd", "zze", "zzf"});
        }
        if (i10 == 3) {
            return new f3();
        }
        if (i10 == 4) {
            return new r1(zzg);
        }
        if (i10 == 5) {
            return zzg;
        }
        throw null;
    }
}
