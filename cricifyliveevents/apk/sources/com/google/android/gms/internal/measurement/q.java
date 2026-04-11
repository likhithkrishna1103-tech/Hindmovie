package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements Iterable, n {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f2579v;

    public q(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.f2579v = str;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean a() {
        return Boolean.valueOf(!this.f2579v.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double d() {
        String str = this.f2579v;
        if (str.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return this.f2579v.equals(((q) obj).f2579v);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator g() {
        return new p(0, this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02f5 A[PHI: r7
      0x02f5: PHI (r7v6 boolean) = (r7v13 boolean), (r7v14 boolean), (r7v17 boolean) binds: [B:100:0x02e1, B:101:0x02e3, B:103:0x02f3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02ff A[LOOP:0: B:108:0x02fd->B:109:0x02ff, LOOP_END] */
    @Override // com.google.android.gms.internal.measurement.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.n h(java.lang.String r28, b6.f r29, java.util.ArrayList r30) {
        /*
            Method dump skipped, instruction units count: 1626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.q.h(java.lang.String, b6.f, java.util.ArrayList):com.google.android.gms.internal.measurement.n");
    }

    public final int hashCode() {
        return this.f2579v.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String i() {
        return this.f2579v;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new p(1, this);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n j() {
        return new q(this.f2579v);
    }

    public final String toString() {
        String str = this.f2579v;
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("\"");
        sb.append(str);
        sb.append("\"");
        return sb.toString();
    }
}
