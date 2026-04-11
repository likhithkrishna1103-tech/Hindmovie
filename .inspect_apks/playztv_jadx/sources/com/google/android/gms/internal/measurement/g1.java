package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g1 extends i0 implements x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final la.b f3009d;

    public g1(la.b bVar) {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
        this.f3009d = bVar;
    }

    @Override // com.google.android.gms.internal.measurement.x0
    public final int a() {
        return System.identityHashCode(this.f3009d);
    }

    @Override // com.google.android.gms.internal.measurement.i0
    public final boolean c(int i, Parcel parcel, Parcel parcel2) {
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            int iIdentityHashCode = System.identityHashCode(this.f3009d);
            parcel2.writeNoException();
            parcel2.writeInt(iIdentityHashCode);
            return true;
        }
        String string = parcel.readString();
        String string2 = parcel.readString();
        Bundle bundle = (Bundle) h0.a(parcel, Bundle.CREATOR);
        long j5 = parcel.readLong();
        h0.d(parcel);
        v(j5, bundle, string, string2);
        parcel2.writeNoException();
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.x0
    public final void v(long j5, Bundle bundle, String str, String str2) {
        this.f3009d.a(j5, bundle, str, str2);
    }
}
