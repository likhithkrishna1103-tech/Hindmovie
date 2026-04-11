package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements n {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final n f3031u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f3032v;

    public h(String str) {
        this.f3031u = n.f3106a;
        this.f3032v = str;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean b() {
        throw new IllegalStateException("Control is not a boolean");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f3032v.equals(hVar.f3032v) && this.f3031u.equals(hVar.f3031u);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator f() {
        return null;
    }

    public final int hashCode() {
        return this.f3031u.hashCode() + (this.f3032v.hashCode() * 31);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String i() {
        throw new IllegalStateException("Control is not a String");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n j() {
        return new h(this.f3032v, this.f3031u.j());
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n l(String str, ub.o oVar, ArrayList arrayList) {
        throw new IllegalStateException("Control does not have functions");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double n() {
        throw new IllegalStateException("Control is not a double");
    }

    public h(String str, n nVar) {
        this.f3031u = nVar;
        this.f3032v = str;
    }
}
