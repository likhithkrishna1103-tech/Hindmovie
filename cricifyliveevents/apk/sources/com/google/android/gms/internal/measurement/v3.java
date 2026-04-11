package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v3 extends i5 {
    private static final v3 zzf;
    private int zzb;
    private o5 zzd = h6.f2472z;
    private t3 zze;

    static {
        v3 v3Var = new v3();
        zzf = v3Var;
        i5.m(v3.class, v3Var);
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzb", "zzd", w3.class, "zze"});
        }
        if (i10 == 3) {
            return new v3();
        }
        if (i10 == 4) {
            return new r1(zzf);
        }
        if (i10 == 5) {
            return zzf;
        }
        throw null;
    }

    public final List p() {
        return this.zzd;
    }

    public final t3 q() {
        t3 t3Var = this.zze;
        return t3Var == null ? t3.r() : t3Var;
    }
}
