package p1;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends Binder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f9727e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final aa.j0 f9728d;

    static {
        f9727e = Build.VERSION.SDK_INT >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536;
    }

    public f(ArrayList arrayList) {
        this.f9728d = aa.j0.r(arrayList);
    }

    public static aa.j0 a(IBinder iBinder) {
        int i;
        if (iBinder instanceof f) {
            return ((f) iBinder).f9728d;
        }
        aa.g0 g0VarN = aa.j0.n();
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
                            g0VarN.a(bundle);
                            i10++;
                        }
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    i11 = i;
                } catch (RemoteException e10) {
                    throw new RuntimeException(e10);
                }
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
        return g0VarN.g();
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i10) {
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i10);
        }
        if (parcel2 == null) {
            return false;
        }
        aa.j0 j0Var = this.f9728d;
        int size = j0Var.size();
        int i11 = parcel.readInt();
        while (i11 < size && parcel2.dataSize() < f9727e) {
            parcel2.writeInt(1);
            parcel2.writeBundle((Bundle) j0Var.get(i11));
            i11++;
        }
        parcel2.writeInt(i11 < size ? 2 : 0);
        return true;
    }
}
