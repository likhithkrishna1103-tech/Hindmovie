package r4;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.MultiInstanceInvalidationService;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends Binder implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f11460d;

    public h(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f11460d = multiInstanceInvalidationService;
        attachInterface(this, e.f11437c);
    }

    @Override // r4.e
    public final void B(int i, String[] strArr) {
        be.h.e(strArr, "tables");
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f11460d;
        synchronized (multiInstanceInvalidationService.f1687w) {
            String str = (String) multiInstanceInvalidationService.f1686v.get(Integer.valueOf(i));
            if (str == null) {
                Log.w("ROOM", "Remote invalidation client ID not registered");
                return;
            }
            int iBeginBroadcast = multiInstanceInvalidationService.f1687w.beginBroadcast();
            for (int i10 = 0; i10 < iBeginBroadcast; i10++) {
                try {
                    Object broadcastCookie = multiInstanceInvalidationService.f1687w.getBroadcastCookie(i10);
                    be.h.c(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                    Integer num = (Integer) broadcastCookie;
                    int iIntValue = num.intValue();
                    String str2 = (String) multiInstanceInvalidationService.f1686v.get(num);
                    if (i != iIntValue && str.equals(str2)) {
                        try {
                            ((d) multiInstanceInvalidationService.f1687w.getBroadcastItem(i10)).q(strArr);
                        } catch (RemoteException e10) {
                            Log.w("ROOM", "Error invoking a remote callback", e10);
                        }
                    }
                } finally {
                    multiInstanceInvalidationService.f1687w.finishBroadcast();
                }
            }
        }
    }

    public final int c(d dVar, String str) {
        be.h.e(dVar, "callback");
        int i = 0;
        if (str == null) {
            return 0;
        }
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f11460d;
        synchronized (multiInstanceInvalidationService.f1687w) {
            try {
                int i10 = multiInstanceInvalidationService.f1685u + 1;
                multiInstanceInvalidationService.f1685u = i10;
                if (multiInstanceInvalidationService.f1687w.register(dVar, Integer.valueOf(i10))) {
                    multiInstanceInvalidationService.f1686v.put(Integer.valueOf(i10), str);
                    i = i10;
                } else {
                    multiInstanceInvalidationService.f1685u--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i10) {
        String str = e.f11437c;
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
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(d.f11433b);
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof d)) {
                    c cVar = new c();
                    cVar.f11429d = strongBinder;
                    dVar = cVar;
                } else {
                    dVar = (d) iInterfaceQueryLocalInterface;
                }
            }
            int iC = c(dVar, parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(iC);
            return true;
        }
        if (i != 2) {
            if (i != 3) {
                return super.onTransact(i, parcel, parcel2, i10);
            }
            B(parcel.readInt(), parcel.createStringArray());
            return true;
        }
        IBinder strongBinder2 = parcel.readStrongBinder();
        if (strongBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface(d.f11433b);
            if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof d)) {
                c cVar2 = new c();
                cVar2.f11429d = strongBinder2;
                dVar2 = cVar2;
            } else {
                dVar2 = (d) iInterfaceQueryLocalInterface2;
            }
        }
        int i11 = parcel.readInt();
        be.h.e(dVar2, "callback");
        MultiInstanceInvalidationService multiInstanceInvalidationService = this.f11460d;
        synchronized (multiInstanceInvalidationService.f1687w) {
            multiInstanceInvalidationService.f1687w.unregister(dVar2);
        }
        parcel2.writeNoException();
        return true;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
