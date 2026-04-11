package v1;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends Binder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f12631e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ua.i0 f12632d;

    static {
        f12631e = Build.VERSION.SDK_INT >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536;
    }

    public e(ArrayList arrayList) {
        this.f12632d = ua.i0.k(arrayList);
    }

    public static ua.i0 a(IBinder iBinder) {
        int i;
        if (iBinder instanceof e) {
            return ((e) iBinder).f12632d;
        }
        ua.f0 f0VarJ = ua.i0.j();
        int i10 = 0;
        int i11 = 1;
        while (i11 != 0) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInt(i10);
                try {
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    while (true) {
                        i = parcelObtain2.readInt();
                        if (i == 1) {
                            Bundle bundle = parcelObtain2.readBundle();
                            bundle.getClass();
                            f0VarJ.a(bundle);
                            i10++;
                        }
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    i11 = i;
                } catch (RemoteException e9) {
                    throw new RuntimeException(e9);
                }
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
        return f0VarJ.g();
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i10) {
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i10);
        }
        if (parcel2 == null) {
            return false;
        }
        ua.i0 i0Var = this.f12632d;
        int size = i0Var.size();
        int i11 = parcel.readInt();
        while (i11 < size && parcel2.dataSize() < f12631e) {
            parcel2.writeInt(1);
            parcel2.writeBundle((Bundle) i0Var.get(i11));
            i11++;
        }
        parcel2.writeInt(i11 < size ? 2 : 0);
        return true;
    }
}
