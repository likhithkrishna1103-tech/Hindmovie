package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r2 extends i5 {
    private static final r2 zzk;
    private int zzb;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        r2 r2Var = new r2();
        zzk = r2Var;
        i5.m(r2.class, r2Var);
    }

    public static q2 w() {
        return (q2) zzk.h();
    }

    public static r2 x() {
        return zzk;
    }

    public final /* synthetic */ void A(boolean z10) {
        this.zzb |= 4;
        this.zzf = z10;
    }

    public final /* synthetic */ void B(boolean z10) {
        this.zzb |= 8;
        this.zzg = z10;
    }

    public final /* synthetic */ void C(boolean z10) {
        this.zzb |= 16;
        this.zzh = z10;
    }

    public final /* synthetic */ void D(boolean z10) {
        this.zzb |= 32;
        this.zzi = z10;
    }

    public final /* synthetic */ void E(boolean z10) {
        this.zzb |= 64;
        this.zzj = z10;
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzk, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i10 == 3) {
            return new r2();
        }
        if (i10 == 4) {
            return new q2(zzk);
        }
        if (i10 == 5) {
            return zzk;
        }
        throw null;
    }

    public final boolean p() {
        return this.zzd;
    }

    public final boolean q() {
        return this.zze;
    }

    public final boolean r() {
        return this.zzf;
    }

    public final boolean s() {
        return this.zzg;
    }

    public final boolean t() {
        return this.zzh;
    }

    public final boolean u() {
        return this.zzi;
    }

    public final boolean v() {
        return this.zzj;
    }

    public final /* synthetic */ void y(boolean z10) {
        this.zzb |= 1;
        this.zzd = z10;
    }

    public final /* synthetic */ void z(boolean z10) {
        this.zzb |= 2;
        this.zze = z10;
    }
}
