package w4;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.MultiInstanceInvalidationService;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends Binder implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f13943d;

    public h(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f13943d = multiInstanceInvalidationService;
        attachInterface(this, e.f13929c);
    }

    @Override // w4.e
    public final void F(int i, String[] strArr) {
        ge.i.e(strArr, "tables");
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f13943d;
        synchronized (multiInstanceInvalidationService.f1470x) {
            String str = (String) multiInstanceInvalidationService.f1469w.get(Integer.valueOf(i));
            if (str == null) {
                Log.w("ROOM", "Remote invalidation client ID not registered");
                return;
            }
            int iBeginBroadcast = multiInstanceInvalidationService.f1470x.beginBroadcast();
            for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                try {
                    Object broadcastCookie = multiInstanceInvalidationService.f1470x.getBroadcastCookie(i10);
                    ge.i.c(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                    Integer num = (Integer) broadcastCookie;
                    int iIntValue = num.intValue();
                    String str2 = (String) multiInstanceInvalidationService.f1469w.get(num);
                    if (i != iIntValue && str.equals(str2)) {
                        try {
                            ((d) multiInstanceInvalidationService.f1470x.getBroadcastItem(i10)).u(strArr);
                        } catch (RemoteException e9) {
                            Log.w("ROOM", "Error invoking a remote callback", e9);
                        }
                    }
                } finally {
                    multiInstanceInvalidationService.f1470x.finishBroadcast();
                }
            }
        }
    }

    public final int b(d dVar, String str) {
        ge.i.e(dVar, "callback");
        int i = 0;
        if (str == null) {
            return 0;
        }
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f13943d;
        synchronized (multiInstanceInvalidationService.f1470x) {
            try {
                int i10 = multiInstanceInvalidationService.f1468v + 1;
                multiInstanceInvalidationService.f1468v = i10;
                if (multiInstanceInvalidationService.f1470x.register(dVar, Integer.valueOf(i10))) {
                    multiInstanceInvalidationService.f1469w.put(Integer.valueOf(i10), str);
                    i = i10;
                } else {
                    multiInstanceInvalidationService.f1468v--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i10) {
        String str = e.f13929c;
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        d dVar = null;
        d dVar2 = null;
        if (i == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(d.f13928b);
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) {
                    c cVar = new c();
                    cVar.f13924d = strongBinder;
                    dVar = cVar;
                } else {
                    dVar = (d) iInterfaceQueryLocalInterface;
                }
            }
            int iB = b(dVar, parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(iB);
            return true;
        }
        if (i != 2) {
            if (i != 3) {
                return super.onTransact(i, parcel, parcel2, i10);
            }
            F(parcel.readInt(), parcel.createStringArray());
            return true;
        }
        IBinder strongBinder2 = parcel.readStrongBinder();
        if (strongBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface(d.f13928b);
            if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof d)) {
                c cVar2 = new c();
                cVar2.f13924d = strongBinder2;
                dVar2 = cVar2;
            } else {
                dVar2 = (d) iInterfaceQueryLocalInterface2;
            }
        }
        int i11 = parcel.readInt();
        ge.i.e(dVar2, "callback");
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f13943d;
        synchronized (multiInstanceInvalidationService.f1470x) {
            multiInstanceInvalidationService.f1470x.unregister(dVar2);
        }
        parcel2.writeNoException();
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
