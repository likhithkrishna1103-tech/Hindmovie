package w4;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f13924d;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f13924d;
    }

    @Override // w4.d
    public final void u(String[] strArr) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken(d.f13928b);
            parcelObtain.writeStringArray(strArr);
            this.f13924d.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
