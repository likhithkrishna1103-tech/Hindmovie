package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements n {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f2963u;

    public f(Boolean bool) {
        if (bool == null) {
            this.f2963u = false;
        } else {
            this.f2963u = bool.booleanValue();
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean b() {
        return Boolean.valueOf(this.f2963u);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && this.f2963u == ((f) obj).f2963u;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator f() {
        return null;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.f2963u).hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String i() {
        return Boolean.toString(this.f2963u);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n j() {
        return new f(Boolean.valueOf(this.f2963u));
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n l(String str, ub.o oVar, ArrayList arrayList) {
        boolean zEquals = "toString".equals(str);
        boolean z2 = this.f2963u;
        if (zEquals) {
            return new p(Boolean.toString(z2));
        }
        throw new IllegalArgumentException(Boolean.toString(z2) + "." + str + " is not a function.");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double n() {
        return Double.valueOf(this.f2963u ? 1.0d : 0.0d);
    }

    public final String toString() {
        return String.valueOf(this.f2963u);
    }
}
