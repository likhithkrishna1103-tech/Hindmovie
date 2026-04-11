package o8;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y extends a9.i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f9701e;
    public final int f;

    public y(e eVar, int i) {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
        this.f9701e = eVar;
        this.f = i;
    }

    @Override // a9.i
    public final boolean L(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            int i10 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) a9.j.a(parcel, Bundle.CREATOR);
            a9.j.c(parcel);
            u.h(this.f9701e, "onPostInitComplete can be called only once per call to getRemoteService");
            e eVar = this.f9701e;
            int i11 = this.f;
            eVar.getClass();
            a0 a0Var = new a0(eVar, i10, strongBinder, bundle);
            x xVar = eVar.f;
            xVar.sendMessage(xVar.obtainMessage(1, i11, -1, a0Var));
            this.f9701e = null;
        } else if (i == 2) {
            parcel.readInt();
            a9.j.c(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i != 3) {
                return false;
            }
            int i12 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            c0 c0Var = (c0) a9.j.a(parcel, c0.CREATOR);
            a9.j.c(parcel);
            e eVar2 = this.f9701e;
            u.h(eVar2, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            u.g(c0Var);
            eVar2.f9640v = c0Var;
            Bundle bundle2 = c0Var.f9613v;
            u.h(this.f9701e, "onPostInitComplete can be called only once per call to getRemoteService");
            e eVar3 = this.f9701e;
            int i13 = this.f;
            eVar3.getClass();
            a0 a0Var2 = new a0(eVar3, i12, strongBinder2, bundle2);
            x xVar2 = eVar3.f;
            xVar2.sendMessage(xVar2.obtainMessage(1, i13, -1, a0Var2));
            this.f9701e = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
