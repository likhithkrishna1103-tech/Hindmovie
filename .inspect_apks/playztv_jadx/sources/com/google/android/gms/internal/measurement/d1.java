package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d1 extends u7.a {
    public static final Parcelable.Creator<d1> CREATOR = new c1();
    public final Bundle A;
    public final String B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f2927u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f2928v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f2929w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f2930x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f2931y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f2932z;

    public d1(long j5, long j8, boolean z2, String str, String str2, String str3, Bundle bundle, String str4) {
        this.f2927u = j5;
        this.f2928v = j8;
        this.f2929w = z2;
        this.f2930x = str;
        this.f2931y = str2;
        this.f2932z = str3;
        this.A = bundle;
        this.B = str4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = wa.t1.E(parcel, 20293);
        wa.t1.H(parcel, 1, 8);
        parcel.writeLong(this.f2927u);
        wa.t1.H(parcel, 2, 8);
        parcel.writeLong(this.f2928v);
        wa.t1.H(parcel, 3, 4);
        parcel.writeInt(this.f2929w ? 1 : 0);
        wa.t1.C(parcel, 4, this.f2930x);
        wa.t1.C(parcel, 5, this.f2931y);
        wa.t1.C(parcel, 6, this.f2932z);
        wa.t1.z(parcel, 7, this.A);
        wa.t1.C(parcel, 8, this.B);
        wa.t1.G(parcel, iE);
    }
}
