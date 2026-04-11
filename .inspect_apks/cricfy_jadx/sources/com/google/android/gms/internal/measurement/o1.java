package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o1 extends i5 {
    private static final o1 zzl;
    private int zzb;
    private int zzd;
    private String zze = "";
    private o5 zzf = h6.f2472z;
    private boolean zzg;
    private t1 zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    static {
        o1 o1Var = new o1();
        zzl = o1Var;
        i5.m(o1.class, o1Var);
    }

    public static n1 B() {
        return (n1) zzl.h();
    }

    public final boolean A() {
        return this.zzk;
    }

    public final /* synthetic */ void C(String str) {
        this.zzb |= 2;
        this.zze = str;
    }

    public final void D(int i, q1 q1Var) {
        o5 o5Var = this.zzf;
        if (!((v4) o5Var).f2661v) {
            int size = o5Var.size();
            this.zzf = o5Var.e(size + size);
        }
        this.zzf.set(i, q1Var);
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzl, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", q1.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i10 == 3) {
            return new o1();
        }
        if (i10 == 4) {
            return new n1(zzl);
        }
        if (i10 == 5) {
            return zzl;
        }
        throw null;
    }

    public final boolean p() {
        return (this.zzb & 1) != 0;
    }

    public final int q() {
        return this.zzd;
    }

    public final String r() {
        return this.zze;
    }

    public final List s() {
        return this.zzf;
    }

    public final int t() {
        return this.zzf.size();
    }

    public final q1 u(int i) {
        return (q1) this.zzf.get(i);
    }

    public final boolean v() {
        return (this.zzb & 8) != 0;
    }

    public final t1 w() {
        t1 t1Var = this.zzh;
        return t1Var == null ? t1.y() : t1Var;
    }

    public final boolean x() {
        return this.zzi;
    }

    public final boolean y() {
        return this.zzj;
    }

    public final boolean z() {
        return (this.zzb & 64) != 0;
    }
}
