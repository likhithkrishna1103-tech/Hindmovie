package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t2 extends i5 {
    private static final t2 zzh;
    private int zzb;
    private int zzd;
    private m3 zze;
    private m3 zzf;
    private boolean zzg;

    static {
        t2 t2Var = new t2();
        zzh = t2Var;
        i5.m(t2.class, t2Var);
    }

    public static s2 w() {
        return (s2) zzh.h();
    }

    public final /* synthetic */ void A(boolean z10) {
        this.zzb |= 8;
        this.zzg = z10;
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        }
        if (i10 == 3) {
            return new t2();
        }
        if (i10 == 4) {
            return new s2(zzh);
        }
        if (i10 == 5) {
            return zzh;
        }
        throw null;
    }

    public final boolean p() {
        return (this.zzb & 1) != 0;
    }

    public final int q() {
        return this.zzd;
    }

    public final m3 r() {
        m3 m3Var = this.zze;
        return m3Var == null ? m3.y() : m3Var;
    }

    public final boolean s() {
        return (this.zzb & 4) != 0;
    }

    public final m3 t() {
        m3 m3Var = this.zzf;
        return m3Var == null ? m3.y() : m3Var;
    }

    public final boolean u() {
        return (this.zzb & 8) != 0;
    }

    public final boolean v() {
        return this.zzg;
    }

    public final /* synthetic */ void x(int i) {
        this.zzb |= 1;
        this.zzd = i;
    }

    public final /* synthetic */ void y(m3 m3Var) {
        this.zze = m3Var;
        this.zzb |= 2;
    }

    public final /* synthetic */ void z(m3 m3Var) {
        this.zzf = m3Var;
        this.zzb |= 4;
    }
}
