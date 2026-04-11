package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 extends p8.a {
    public static final Parcelable.Creator<t0> CREATOR = new u0(0);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f2631v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f2632w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f2633x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Bundle f2634y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f2635z;

    public t0(long j4, long j7, boolean z10, Bundle bundle, String str) {
        this.f2631v = j4;
        this.f2632w = j7;
        this.f2633x = z10;
        this.f2634y = bundle;
        this.f2635z = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = qb.t1.w(parcel, 20293);
        qb.t1.v(parcel, 1, 8);
        parcel.writeLong(this.f2631v);
        qb.t1.v(parcel, 2, 8);
        parcel.writeLong(this.f2632w);
        qb.t1.v(parcel, 3, 4);
        parcel.writeInt(this.f2633x ? 1 : 0);
        qb.t1.o(parcel, 7, this.f2634y);
        qb.t1.r(parcel, 8, this.f2635z);
        qb.t1.y(parcel, iW);
    }
}
