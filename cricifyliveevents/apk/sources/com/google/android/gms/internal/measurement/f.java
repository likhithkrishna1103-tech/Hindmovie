package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements n {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final n f2384v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f2385w;

    public f(String str) {
        this.f2384v = n.f2536b;
        this.f2385w = str;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean a() {
        throw new IllegalStateException("Control is not a boolean");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double d() {
        throw new IllegalStateException("Control is not a double");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f2385w.equals(fVar.f2385w) && this.f2384v.equals(fVar.f2384v);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator g() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n h(String str, b6.f fVar, ArrayList arrayList) {
        throw new IllegalStateException("Control does not have functions");
    }

    public final int hashCode() {
        return this.f2384v.hashCode() + (this.f2385w.hashCode() * 31);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String i() {
        throw new IllegalStateException("Control is not a String");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n j() {
        return new f(this.f2385w, this.f2384v.j());
    }

    public f(String str, n nVar) {
        this.f2384v = nVar;
        this.f2385w = str;
    }
}
