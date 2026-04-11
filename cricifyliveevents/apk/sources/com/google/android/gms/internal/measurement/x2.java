package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x2 extends i5 {
    private static final x2 zzd;
    private o5 zzb = h6.f2472z;

    static {
        x2 x2Var = new x2();
        zzd = x2Var;
        i5.m(x2.class, x2Var);
    }

    public static u2 q() {
        return (u2) zzd.h();
    }

    public static x2 r() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.measurement.i5
    public final Object o(int i) {
        int i10 = i - 1;
        if (i10 == 0) {
            return (byte) 1;
        }
        if (i10 == 2) {
            return new i6(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", w2.class});
        }
        if (i10 == 3) {
            return new x2();
        }
        if (i10 == 4) {
            return new u2(zzd);
        }
        if (i10 == 5) {
            return zzd;
        }
        throw null;
    }

    public final List p() {
        return this.zzb;
    }

    public final void s(ArrayList arrayList) {
        o5 o5Var = this.zzb;
        if (!((v4) o5Var).f2661v) {
            int size = o5Var.size();
            this.zzb = o5Var.e(size + size);
        }
        u4.c(arrayList, this.zzb);
    }
}
