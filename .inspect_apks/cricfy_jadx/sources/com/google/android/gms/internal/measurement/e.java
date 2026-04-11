package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements n {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f2371v;

    public e(Boolean bool) {
        this.f2371v = bool == null ? false : bool.booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean a() {
        return Boolean.valueOf(this.f2371v);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double d() {
        return Double.valueOf(true != this.f2371v ? 0.0d : 1.0d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.f2371v == ((e) obj).f2371v;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator g() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n h(String str, b6.f fVar, ArrayList arrayList) {
        boolean zEquals = "toString".equals(str);
        boolean z10 = this.f2371v;
        if (zEquals) {
            return new q(Boolean.toString(z10));
        }
        throw new IllegalArgumentException(Boolean.toString(z10) + "." + str + " is not a function.");
    }

    public final int hashCode() {
        return Boolean.valueOf(this.f2371v).hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String i() {
        return Boolean.toString(this.f2371v);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n j() {
        return new e(Boolean.valueOf(this.f2371v));
    }

    public final String toString() {
        return String.valueOf(this.f2371v);
    }
}
