package h4;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f5796d;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f5796d;
    }

    @Override // h4.f
    public final void d(int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcelObtain.writeInt(i);
            if (!this.f5796d.transact(9, parcelObtain, null, 1)) {
                int i10 = k.f5822e;
            }
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // h4.f
    public final void l(h0 h0Var) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcelObtain.writeInt(1);
            h0Var.writeToParcel(parcelObtain, 0);
            if (!this.f5796d.transact(3, parcelObtain, null, 1)) {
                int i = k.f5822e;
            }
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // h4.f
    public final void s(int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcelObtain.writeInt(i);
            if (!this.f5796d.transact(12, parcelObtain, null, 1)) {
                int i10 = k.f5822e;
            }
        } finally {
            parcelObtain.recycle();
        }
    }
}
