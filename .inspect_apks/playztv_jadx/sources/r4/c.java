package r4;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f11429d;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f11429d;
    }

    @Override // r4.d
    public final void q(String[] strArr) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(d.f11433b);
            parcelObtain.writeStringArray(strArr);
            this.f11429d.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
