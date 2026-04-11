package l4;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f7711d;

    @Override // l4.g
    public final void J(k0 k0Var) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcelObtain.writeInt(1);
            k0Var.writeToParcel(parcelObtain, 0);
            if (!this.f7711d.transact(3, parcelObtain, null, 1)) {
                int i = l.f7736e;
            }
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f7711d;
    }

    @Override // l4.g
    public final void c(int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcelObtain.writeInt(i);
            if (!this.f7711d.transact(9, parcelObtain, null, 1)) {
                int i10 = l.f7736e;
            }
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // l4.g
    public final void y(int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
            parcelObtain.writeInt(i);
            if (!this.f7711d.transact(12, parcelObtain, null, 1)) {
                int i10 = l.f7736e;
            }
        } finally {
            parcelObtain.recycle();
        }
    }
}
