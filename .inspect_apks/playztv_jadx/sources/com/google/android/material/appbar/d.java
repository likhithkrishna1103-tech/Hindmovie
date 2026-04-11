package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends x0.b {
    public static final Parcelable.Creator<d> CREATOR = new c();
    public boolean A;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3319w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f3320x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3321y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f3322z;

    public d(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f3319w = parcel.readByte() != 0;
        this.f3320x = parcel.readByte() != 0;
        this.f3321y = parcel.readInt();
        this.f3322z = parcel.readFloat();
        this.A = parcel.readByte() != 0;
    }

    @Override // x0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f3319w ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f3320x ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f3321y);
        parcel.writeFloat(this.f3322z);
        parcel.writeByte(this.A ? (byte) 1 : (byte) 0);
    }
}
