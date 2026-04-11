package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 extends x implements q0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fb.b f2468d;

    public h1(fb.b bVar) {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
        this.f2468d = bVar;
    }

    @Override // com.google.android.gms.internal.measurement.x
    public final boolean b(int i, Parcel parcel, Parcel parcel2) {
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            int iIdentityHashCode = System.identityHashCode(this.f2468d);
            parcel2.writeNoException();
            parcel2.writeInt(iIdentityHashCode);
            return true;
        }
        String string = parcel.readString();
        String string2 = parcel.readString();
        Bundle bundle = (Bundle) y.a(parcel, Bundle.CREATOR);
        long j4 = parcel.readLong();
        y.d(parcel);
        x(j4, bundle, string, string2);
        parcel2.writeNoException();
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.q0
    public final int g() {
        return System.identityHashCode(this.f2468d);
    }

    @Override // com.google.android.gms.internal.measurement.q0
    public final void x(long j4, Bundle bundle, String str, String str2) {
        this.f2468d.a(j4, bundle, str, str2);
    }
}
