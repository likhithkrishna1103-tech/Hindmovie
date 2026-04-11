package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y1 extends i5 {
    private static final y1 zzf;
    private int zzb;
    private int zzd;
    private int zze;

    static {
        y1 y1Var = new y1();
        zzf = y1Var;
        i5.m(y1.class, y1Var);
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            s1 s1Var = s1.f2594e;
            return new i6(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzb", "zzd", s1Var, "zze", s1Var});
        }
        if (i10 == 3) {
            return new y1();
        }
        if (i10 == 4) {
            return new r1(zzf);
        }
        if (i10 == 5) {
            return zzf;
        }
        throw null;
    }

    public final int p() {
        int iH = sd.i.H(this.zzd);
        if (iH == 0) {
            return 1;
        }
        return iH;
    }

    public final int q() {
        int iH = sd.i.H(this.zze);
        if (iH == 0) {
            return 1;
        }
        return iH;
    }
}
