package cc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s0 implements ServiceConnection {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ ub.o f2710u;

    public s0(ub.o oVar) {
        this.f2710u = oVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        StringBuilder sb2 = new StringBuilder("Connected to SessionLifecycleService. Queue size ");
        ub.o oVar = this.f2710u;
        LinkedBlockingDeque linkedBlockingDeque = (LinkedBlockingDeque) oVar.f12870x;
        sb2.append(linkedBlockingDeque.size());
        Log.d("SessionLifecycleClient", sb2.toString());
        oVar.f12869w = new Messenger(iBinder);
        ArrayList arrayList = new ArrayList();
        linkedBlockingDeque.drainTo(arrayList);
        ke.x.j(ke.x.a((rd.h) oVar.f12868v), null, new e0(oVar, arrayList, null, 1), 3);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Log.d("SessionLifecycleClient", "Disconnected from SessionLifecycleService");
        ub.o oVar = this.f2710u;
        oVar.f12869w = null;
        oVar.getClass();
    }
}
