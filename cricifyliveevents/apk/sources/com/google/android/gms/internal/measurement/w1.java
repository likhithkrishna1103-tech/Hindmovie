package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w1 extends i5 {
    private static final w1 zzh;
    private int zzb;
    private int zzd;
    private boolean zzf;
    private String zze = "";
    private o5 zzg = h6.f2472z;

    static {
        w1 w1Var = new w1();
        zzh = w1Var;
        i5.m(w1.class, w1Var);
    }

    public static w1 w() {
        return zzh;
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzb", "zzd", s1.f2592c, "zze", "zzf", "zzg"});
        }
        if (i10 == 3) {
            return new w1();
        }
        if (i10 == 4) {
            return new r1(zzh);
        }
        if (i10 == 5) {
            return zzh;
        }
        throw null;
    }

    public final boolean p() {
        return (this.zzb & 1) != 0;
    }

    public final boolean q() {
        return (this.zzb & 2) != 0;
    }

    public final String r() {
        return this.zze;
    }

    public final boolean s() {
        return (this.zzb & 4) != 0;
    }

    public final boolean t() {
        return this.zzf;
    }

    public final o5 u() {
        return this.zzg;
    }

    public final int v() {
        return this.zzg.size();
    }

    public final int x() {
        int i;
        switch (this.zzd) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i = 1;
                break;
            case 1:
                i = 2;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 4;
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                i = 5;
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                i = 6;
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                i = 7;
                break;
            default:
                i = 0;
                break;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }
}
