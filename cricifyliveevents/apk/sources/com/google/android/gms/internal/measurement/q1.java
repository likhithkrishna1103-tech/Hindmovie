package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q1 extends i5 {
    private static final q1 zzh;
    private int zzb;
    private w1 zzd;
    private t1 zze;
    private boolean zzf;
    private String zzg = "";

    static {
        q1 q1Var = new q1();
        zzh = q1Var;
        i5.m(q1.class, q1Var);
    }

    public static q1 x() {
        return zzh;
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        }
        if (i10 == 3) {
            return new q1();
        }
        if (i10 == 4) {
            return new p1(zzh);
        }
        if (i10 == 5) {
            return zzh;
        }
        throw null;
    }

    public final boolean p() {
        return (this.zzb & 1) != 0;
    }

    public final w1 q() {
        w1 w1Var = this.zzd;
        return w1Var == null ? w1.w() : w1Var;
    }

    public final boolean r() {
        return (this.zzb & 2) != 0;
    }

    public final t1 s() {
        t1 t1Var = this.zze;
        return t1Var == null ? t1.y() : t1Var;
    }

    public final boolean t() {
        return (this.zzb & 4) != 0;
    }

    public final boolean u() {
        return this.zzf;
    }

    public final boolean v() {
        return (this.zzb & 8) != 0;
    }

    public final String w() {
        return this.zzg;
    }

    public final /* synthetic */ void y(String str) {
        this.zzb |= 8;
        this.zzg = str;
    }
}
