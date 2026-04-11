package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends a1.c {
    public static final Parcelable.Creator<d> CREATOR = new c();
    public float A;
    public boolean B;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2771x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f2772y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f2773z;

    public d(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f2771x = parcel.readByte() != 0;
        this.f2772y = parcel.readByte() != 0;
        this.f2773z = parcel.readInt();
        this.A = parcel.readFloat();
        this.B = parcel.readByte() != 0;
    }

    @Override // a1.c, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte(this.f2771x ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2772y ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f2773z);
        parcel.writeFloat(this.A);
        parcel.writeByte(this.B ? (byte) 1 : (byte) 0);
    }
}
