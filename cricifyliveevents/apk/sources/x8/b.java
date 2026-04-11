package x8;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d, IInterface {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IBinder f14455d;

    public b(IBinder iBinder) {
        this.f14455d = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f14455d;
    }

    public final Parcel b(Parcel parcel, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f14455d.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e9) {
                parcelObtain.recycle();
                throw e9;
            }
        } finally {
            parcel.recycle();
        }
    }
}
