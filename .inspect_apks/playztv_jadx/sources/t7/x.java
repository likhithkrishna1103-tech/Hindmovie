package t7;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x extends d8.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f12339e;
    public final int f;

    public x(e eVar, int i) {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
        this.f12339e = eVar;
        this.f = i;
    }

    @Override // d8.a
    public final boolean G(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            int i10 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) f8.a.a(parcel, Bundle.CREATOR);
            f8.a.b(parcel);
            v.i(this.f12339e, "onPostInitComplete can be called only once per call to getRemoteService");
            e eVar = this.f12339e;
            int i11 = this.f;
            eVar.getClass();
            z zVar = new z(eVar, i10, strongBinder, bundle);
            w wVar = eVar.f;
            wVar.sendMessage(wVar.obtainMessage(1, i11, -1, zVar));
            this.f12339e = null;
        } else if (i == 2) {
            parcel.readInt();
            f8.a.b(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i != 3) {
                return false;
            }
            int i12 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            b0 b0Var = (b0) f8.a.a(parcel, b0.CREATOR);
            f8.a.b(parcel);
            e eVar2 = this.f12339e;
            v.i(eVar2, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            v.h(b0Var);
            eVar2.f12285v = b0Var;
            Bundle bundle2 = b0Var.f12251u;
            v.i(this.f12339e, "onPostInitComplete can be called only once per call to getRemoteService");
            e eVar3 = this.f12339e;
            int i13 = this.f;
            eVar3.getClass();
            z zVar2 = new z(eVar3, i12, strongBinder2, bundle2);
            w wVar2 = eVar3.f;
            wVar2.sendMessage(wVar2.obtainMessage(1, i13, -1, zVar2));
            this.f12339e = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
