package h4;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends ResultReceiver {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final WeakReference f5821u;

    public j(l lVar) {
        super(null);
        this.f5821u = new WeakReference(lVar);
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        h hVar;
        l lVar = (l) this.f5821u.get();
        if (lVar == null || bundle == null) {
            return;
        }
        synchronized (lVar.f5825b) {
            y yVar = lVar.f5828e;
            IBinder binder = bundle.getBinder("android.support.v4.media.session.EXTRA_BINDER");
            int i10 = s.f5845e;
            if (binder == null) {
                hVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = binder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof h)) {
                    g gVar = new g();
                    gVar.f5806d = binder;
                    hVar = gVar;
                } else {
                    hVar = (h) iInterfaceQueryLocalInterface;
                }
            }
            yVar.b(hVar);
            lVar.f5828e.c(i5.a.A(bundle));
            lVar.a();
        }
    }
}
