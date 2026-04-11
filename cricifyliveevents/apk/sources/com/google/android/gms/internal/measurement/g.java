package com.google.android.gms.internal.measurement;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements n {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Double f2450v;

    public g(Double d10) {
        if (d10 == null) {
            this.f2450v = Double.valueOf(Double.NaN);
        } else {
            this.f2450v = d10;
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean a() {
        Double d10 = this.f2450v;
        boolean z10 = false;
        if (!Double.isNaN(d10.doubleValue()) && d10.doubleValue() != 0.0d) {
            z10 = true;
        }
        return Boolean.valueOf(z10);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double d() {
        return this.f2450v;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            return this.f2450v.equals(((g) obj).f2450v);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator g() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n h(String str, b6.f fVar, ArrayList arrayList) {
        if ("toString".equals(str)) {
            return new q(i());
        }
        throw new IllegalArgumentException(i() + "." + str + " is not a function.");
    }

    public final int hashCode() {
        return this.f2450v.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String i() {
        Double d10 = this.f2450v;
        if (Double.isNaN(d10.doubleValue())) {
            return "NaN";
        }
        if (Double.isInfinite(d10.doubleValue())) {
            return d10.doubleValue() > 0.0d ? "Infinity" : "-Infinity";
        }
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(d10.doubleValue());
        BigDecimal bigDecimal = bigDecimalValueOf.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimalValueOf.stripTrailingZeros();
        DecimalFormat decimalFormat = new DecimalFormat("0E0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.setMinimumFractionDigits((bigDecimal.scale() > 0 ? bigDecimal.precision() : bigDecimal.scale()) - 1);
        String str = decimalFormat.format(bigDecimal);
        int iIndexOf = str.indexOf("E");
        if (iIndexOf <= 0) {
            return str;
        }
        int i = Integer.parseInt(str.substring(iIndexOf + 1));
        return ((i >= 0 || i <= -7) && (i < 0 || i >= 21)) ? str.replace("E-", "e-").replace("E", "e+") : bigDecimal.toPlainString();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n j() {
        return new g(this.f2450v);
    }

    public final String toString() {
        return i();
    }
}
