package a9;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements IInterface {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IBinder f359e;
    public final String f;

    public /* synthetic */ a(IBinder iBinder, String str, int i) {
        this.f358d = i;
        this.f359e = iBinder;
        this.f = str;
    }

    public void L(Parcel parcel, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f359e.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    public void M(Parcel parcel) {
        try {
            this.f359e.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        switch (this.f358d) {
        }
        return this.f359e;
    }

    public Parcel b(Parcel parcel, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f359e.transact(i, parcel, parcelObtain, 0);
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

    public Parcel e(Parcel parcel, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f359e.transact(i, parcel, parcelObtain, 0);
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

    public final Parcel f() {
        switch (this.f358d) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.writeInterfaceToken(this.f);
                return parcelObtain;
            default:
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain2.writeInterfaceToken(this.f);
                return parcelObtain2;
        }
    }
}
