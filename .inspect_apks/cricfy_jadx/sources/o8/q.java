package o8;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements IInterface {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IBinder f9693d;

    public q(IBinder iBinder) {
        this.f9693d = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f9693d;
    }

    public final void b(y yVar, g gVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(yVar);
            parcelObtain.writeInt(1);
            l4.p.a(gVar, parcelObtain, 0);
            this.f9693d.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
