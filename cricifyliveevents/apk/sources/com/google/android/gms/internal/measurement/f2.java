package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f2 extends i5 {
    private static final f2 zzu;
    private int zzb;
    private long zzd;
    private String zze = "";
    private int zzf;
    private o5 zzg;
    private o5 zzh;
    private o5 zzi;
    private String zzj;
    private boolean zzk;
    private o5 zzl;
    private o5 zzm;
    private String zzn;
    private String zzo;
    private a2 zzp;
    private h2 zzq;
    private k2 zzr;
    private i2 zzs;
    private g2 zzt;

    static {
        f2 f2Var = new f2();
        zzu = f2Var;
        i5.m(f2.class, f2Var);
    }

    public f2() {
        h6 h6Var = h6.f2472z;
        this.zzg = h6Var;
        this.zzh = h6Var;
        this.zzi = h6Var;
        this.zzj = "";
        this.zzl = h6Var;
        this.zzm = h6Var;
        this.zzn = "";
        this.zzo = "";
    }

    public static e2 F() {
        return (e2) zzu.h();
    }

    public static f2 G() {
        return zzu;
    }

    public final String A() {
        return this.zzn;
    }

    public final boolean B() {
        return (this.zzb & 128) != 0;
    }

    public final a2 C() {
        a2 a2Var = this.zzp;
        return a2Var == null ? a2.v() : a2Var;
    }

    public final boolean D() {
        return (this.zzb & 512) != 0;
    }

    public final k2 E() {
        k2 k2Var = this.zzr;
        return k2Var == null ? k2.r() : k2Var;
    }

    public final void H(int i, d2 d2Var) {
        o5 o5Var = this.zzh;
        if (!((v4) o5Var).f2661v) {
            int size = o5Var.size();
            this.zzh = o5Var.e(size + size);
        }
        this.zzh.set(i, d2Var);
    }

    public final void I() {
        this.zzi = h6.f2472z;
    }

    public final void J() {
        this.zzl = h6.f2472z;
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzu, "\u0004\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", j2.class, "zzh", d2.class, "zzi", m1.class, "zzj", "zzk", "zzl", v3.class, "zzm", b2.class, "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
        }
        if (i10 == 3) {
            return new f2();
        }
        if (i10 == 4) {
            return new e2(zzu);
        }
        if (i10 == 5) {
            return zzu;
        }
        throw null;
    }

    public final boolean p() {
        return (this.zzb & 1) != 0;
    }

    public final long q() {
        return this.zzd;
    }

    public final boolean r() {
        return (this.zzb & 2) != 0;
    }

    public final String s() {
        return this.zze;
    }

    public final o5 t() {
        return this.zzg;
    }

    public final int u() {
        return this.zzh.size();
    }

    public final d2 v(int i) {
        return (d2) this.zzh.get(i);
    }

    public final o5 w() {
        return this.zzi;
    }

    public final o5 x() {
        return this.zzl;
    }

    public final int y() {
        return this.zzl.size();
    }

    public final List z() {
        return this.zzm;
    }
}
