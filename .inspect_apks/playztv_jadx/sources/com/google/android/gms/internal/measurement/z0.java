package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends f0 implements x0 {
    public z0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy", 0);
    }

    @Override // com.google.android.gms.internal.measurement.x0
    public final int a() {
        Parcel parcelG = G(c(), 2);
        int i = parcelG.readInt();
        parcelG.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.x0
    public final void v(long j5, Bundle bundle, String str, String str2) {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        h0.c(parcelC, bundle);
        parcelC.writeLong(j5);
        H(parcelC, 1);
    }
}
