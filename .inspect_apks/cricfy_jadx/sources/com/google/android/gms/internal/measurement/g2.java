package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g2 extends i5 {
    private static final g2 zzd;
    private o5 zzb = h6.f2472z;

    static {
        g2 g2Var = new g2();
        zzd = g2Var;
        i5.m(g2.class, g2Var);
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
        }
        if (i10 == 3) {
            return new g2();
        }
        if (i10 == 4) {
            return new r1(zzd);
        }
        if (i10 == 5) {
            return zzd;
        }
        throw null;
    }
}
