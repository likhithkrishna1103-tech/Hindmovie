package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w3 extends i5 {
    private static final w3 zzj;
    private int zzb;
    private int zzd;
    private o5 zze = h6.f2472z;
    private String zzf = "";
    private String zzg = "";
    private boolean zzh;
    private double zzi;

    static {
        w3 w3Var = new w3();
        zzj = w3Var;
        i5.m(w3.class, w3Var);
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zzb", "zzd", s1.f2602o, "zze", w3.class, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i10 == 3) {
            return new w3();
        }
        if (i10 == 4) {
            return new r1(zzj);
        }
        if (i10 == 5) {
            return zzj;
        }
        throw null;
    }

    public final List p() {
        return this.zze;
    }

    public final String q() {
        return this.zzf;
    }

    public final boolean r() {
        return (this.zzb & 4) != 0;
    }

    public final String s() {
        return this.zzg;
    }

    public final boolean t() {
        return (this.zzb & 8) != 0;
    }

    public final boolean u() {
        return this.zzh;
    }

    public final boolean v() {
        return (this.zzb & 16) != 0;
    }

    public final double w() {
        return this.zzi;
    }

    public final int x() {
        int i;
        int i10 = this.zzd;
        if (i10 != 0) {
            i = 2;
            if (i10 != 1) {
                if (i10 != 2) {
                    i = 4;
                    if (i10 != 3) {
                        i = i10 != 4 ? 0 : 5;
                    }
                } else {
                    i = 3;
                }
            }
        } else {
            i = 1;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }
}
