package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b3 extends i5 {
    private static final b3 zzj;
    private int zzb;
    private o5 zzd = h6.f2472z;
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;
    private long zzi;

    static {
        b3 b3Var = new b3();
        zzj = b3Var;
        i5.m(b3.class, b3Var);
    }

    public static a3 z() {
        return (a3) zzj.h();
    }

    public final /* synthetic */ void A(int i, e3 e3Var) {
        J();
        this.zzd.set(i, e3Var);
    }

    public final /* synthetic */ void B(e3 e3Var) {
        e3Var.getClass();
        J();
        this.zzd.add(e3Var);
    }

    public final /* synthetic */ void C(Iterable iterable) {
        J();
        u4.c(iterable, this.zzd);
    }

    public final void D() {
        this.zzd = h6.f2472z;
    }

    public final /* synthetic */ void E(int i) {
        J();
        this.zzd.remove(i);
    }

    public final /* synthetic */ void F(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void G(long j4) {
        this.zzb |= 2;
        this.zzf = j4;
    }

    public final /* synthetic */ void H(long j4) {
        this.zzb |= 4;
        this.zzg = j4;
    }

    public final /* synthetic */ void I(long j4) {
        this.zzb |= 16;
        this.zzi = j4;
    }

    public final void J() {
        o5 o5Var = this.zzd;
        if (((v4) o5Var).f2661v) {
            return;
        }
        int size = o5Var.size();
        this.zzd = o5Var.e(size + size);
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003\u0006ဂ\u0004", new Object[]{"zzb", "zzd", e3.class, "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i10 == 3) {
            return new b3();
        }
        if (i10 == 4) {
            return new a3(zzj);
        }
        if (i10 == 5) {
            return zzj;
        }
        throw null;
    }

    public final List p() {
        return this.zzd;
    }

    public final int q() {
        return this.zzd.size();
    }

    public final e3 r(int i) {
        return (e3) this.zzd.get(i);
    }

    public final String s() {
        return this.zze;
    }

    public final boolean t() {
        return (this.zzb & 2) != 0;
    }

    public final long u() {
        return this.zzf;
    }

    public final boolean v() {
        return (this.zzb & 4) != 0;
    }

    public final long w() {
        return this.zzg;
    }

    public final boolean x() {
        return (this.zzb & 8) != 0;
    }

    public final int y() {
        return this.zzh;
    }
}
