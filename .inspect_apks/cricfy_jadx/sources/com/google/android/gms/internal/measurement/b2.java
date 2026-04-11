package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b2 extends i5 {
    private static final b2 zzg;
    private int zzb;
    private String zzd = "";
    private o5 zze = h6.f2472z;
    private boolean zzf;

    static {
        b2 b2Var = new b2();
        zzg = b2Var;
        i5.m(b2.class, b2Var);
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzb", "zzd", "zze", i2.class, "zzf"});
        }
        if (i10 == 3) {
            return new b2();
        }
        if (i10 == 4) {
            return new r1(zzg);
        }
        if (i10 == 5) {
            return zzg;
        }
        throw null;
    }

    public final String p() {
        return this.zzd;
    }
}
