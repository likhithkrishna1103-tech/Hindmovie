package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h3 extends i5 {
    private static final h3 zzh;
    private int zzb;
    private o5 zzd = h6.f2472z;
    private String zze = "";
    private String zzf = "";
    private int zzg;

    static {
        h3 h3Var = new h3();
        zzh = h3Var;
        i5.m(h3.class, h3Var);
    }

    public static g3 w() {
        return (g3) zzh.h();
    }

    public static g3 x(h3 h3Var) {
        h5 h5VarH = zzh.h();
        h5VarH.f(h3Var);
        return (g3) h5VarH;
    }

    public final /* synthetic */ void A(ArrayList arrayList) {
        E();
        u4.c(arrayList, this.zzd);
    }

    public final void B() {
        this.zzd = h6.f2472z;
    }

    public final /* synthetic */ void C(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void D(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zzf = str;
    }

    public final void E() {
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
            return new i6(zzh, "\u0004\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001b\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zzb", "zzd", j3.class, "zze", "zzf", "zzg", s1.f2597j});
        }
        if (i10 == 3) {
            return new h3();
        }
        if (i10 == 4) {
            return new g3(zzh);
        }
        if (i10 == 5) {
            return zzh;
        }
        throw null;
    }

    public final List p() {
        return this.zzd;
    }

    public final int q() {
        return this.zzd.size();
    }

    public final j3 r(int i) {
        return (j3) this.zzd.get(i);
    }

    public final boolean s() {
        return (this.zzb & 1) != 0;
    }

    public final String t() {
        return this.zze;
    }

    public final boolean u() {
        return (this.zzb & 2) != 0;
    }

    public final String v() {
        return this.zzf;
    }

    public final /* synthetic */ void y(int i, j3 j3Var) {
        E();
        this.zzd.set(i, j3Var);
    }

    public final /* synthetic */ void z(j3 j3Var) {
        E();
        this.zzd.add(j3Var);
    }
}
