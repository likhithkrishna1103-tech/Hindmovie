package o8;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements ServiceConnection {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f9702v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ e f9703w;

    public z(e eVar, int i) {
        this.f9703w = eVar;
        this.f9702v = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e eVar = this.f9703w;
        if (iBinder == null) {
            eVar.z();
            return;
        }
        synchronized (eVar.f9627h) {
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                eVar.i = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof q)) ? new q(iBinder) : (q) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        e eVar2 = this.f9703w;
        int i = this.f9702v;
        eVar2.getClass();
        b0 b0Var = new b0(eVar2, 0, null);
        x xVar = eVar2.f;
        xVar.sendMessage(xVar.obtainMessage(7, i, -1, b0Var));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        e eVar = this.f9703w;
        synchronized (eVar.f9627h) {
            eVar.i = null;
        }
        e eVar2 = this.f9703w;
        int i = this.f9702v;
        x xVar = eVar2.f;
        xVar.sendMessage(xVar.obtainMessage(6, i, 1));
    }
}
