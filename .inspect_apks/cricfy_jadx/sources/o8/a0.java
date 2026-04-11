package o8;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBinder f9610g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ e f9611h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(e eVar, int i, IBinder iBinder, Bundle bundle) {
        super(eVar, i, bundle);
        this.f9611h = eVar;
        this.f9610g = iBinder;
    }

    @Override // o8.p
    public final boolean a() {
        IBinder iBinder = this.f9610g;
        try {
            u.g(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            e eVar = this.f9611h;
            if (!eVar.v().equals(interfaceDescriptor)) {
                String strV = eVar.v();
                StringBuilder sb = new StringBuilder(strV.length() + 34 + String.valueOf(interfaceDescriptor).length());
                sb.append("service descriptor mismatch: ");
                sb.append(strV);
                sb.append(" vs. ");
                sb.append(interfaceDescriptor);
                Log.w("GmsClient", sb.toString());
                return false;
            }
            IInterface iInterfaceP = eVar.p(iBinder);
            if (iInterfaceP == null || !(eVar.y(2, 4, iInterfaceP) || eVar.y(3, 4, iInterfaceP))) {
                return false;
            }
            eVar.f9638t = null;
            b bVar = eVar.f9633o;
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

    @Override // o8.p
    public final void b(l8.b bVar) {
        c cVar = this.f9611h.f9634p;
        if (cVar != null) {
            cVar.b(bVar);
        }
        System.currentTimeMillis();
    }
}
