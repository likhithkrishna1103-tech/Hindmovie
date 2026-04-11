package k4;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f7039d;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f7039d;
    }

    public final void b(int i, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("androidx.media3.session.IMediaController");
            parcelObtain.writeInt(i);
            w8.e.a(parcelObtain, bundle);
            this.f7039d.transact(3001, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }
}
