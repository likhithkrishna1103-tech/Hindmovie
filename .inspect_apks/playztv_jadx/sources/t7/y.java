package t7;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y implements ServiceConnection {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f12340u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ e f12341v;

    public y(e eVar, int i) {
        this.f12341v = eVar;
        this.f12340u = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e eVar = this.f12341v;
        if (iBinder == null) {
            e.y(eVar);
            return;
        }
        synchronized (eVar.f12272h) {
            try {
                e eVar2 = this.f12341v;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                eVar2.i = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof r)) ? new r(iBinder) : (r) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        e eVar3 = this.f12341v;
        int i = this.f12340u;
        a0 a0Var = new a0(eVar3, 0);
        w wVar = eVar3.f;
        wVar.sendMessage(wVar.obtainMessage(7, i, -1, a0Var));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        e eVar;
        synchronized (this.f12341v.f12272h) {
            eVar = this.f12341v;
            eVar.i = null;
        }
        int i = this.f12340u;
        w wVar = eVar.f;
        wVar.sendMessage(wVar.obtainMessage(6, i, 1));
    }
}
