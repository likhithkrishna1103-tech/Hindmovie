package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import k8.x;
import t7.v;
import u7.a;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class Scope extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new x(16);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f2869u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f2870v;

    public Scope(String str, int i) {
        v.e(str, "scopeUri must not be null or empty");
        this.f2869u = i;
        this.f2870v = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f2870v.equals(((Scope) obj).f2870v);
    }

    public final int hashCode() {
        return this.f2870v.hashCode();
    }

    public final String toString() {
        return this.f2870v;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = t1.E(parcel, 20293);
        t1.H(parcel, 1, 4);
        parcel.writeInt(this.f2869u);
        t1.C(parcel, 2, this.f2870v);
        t1.G(parcel, iE);
    }
}
