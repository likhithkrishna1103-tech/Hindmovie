package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o0 extends a9.a implements q0 {
    public o0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy", 1);
    }

    @Override // com.google.android.gms.internal.measurement.q0
    public final int g() {
        Parcel parcelE = e(f(), 2);
        int i = parcelE.readInt();
        parcelE.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.q0
    public final void x(long j4, Bundle bundle, String str, String str2) {
        Parcel parcelF = f();
        parcelF.writeString(str);
        parcelF.writeString(str2);
        y.b(parcelF, bundle);
        parcelF.writeLong(j4);
        L(parcelF, 1);
    }
}
