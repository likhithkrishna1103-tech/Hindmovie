package t7;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z extends p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBinder f12342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ e f12343h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(e eVar, int i, IBinder iBinder, Bundle bundle) {
        super(eVar, i, bundle);
        this.f12343h = eVar;
        this.f12342g = iBinder;
    }

    @Override // t7.p
    public final void a(q7.b bVar) {
        c cVar = this.f12343h.f12279p;
        if (cVar != null) {
            cVar.c(bVar);
        }
        System.currentTimeMillis();
    }

    @Override // t7.p
    public final boolean b() {
        IBinder iBinder = this.f12342g;
        try {
            v.h(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            e eVar = this.f12343h;
            if (!eVar.v().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + eVar.v() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceP = eVar.p(iBinder);
            if (iInterfaceP == null || !(e.z(eVar, 2, 4, iInterfaceP) || e.z(eVar, 3, 4, iInterfaceP))) {
                return false;
            }
            eVar.f12283t = null;
            b bVar = eVar.f12278o;
            if (bVar == null) {
                return true;
            }
            bVar.f();
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
