package l4;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends ResultReceiver {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final WeakReference f7730v;

    public k(m mVar) {
        super(null);
        this.f7730v = new WeakReference(mVar);
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        i iVar;
        m mVar = (m) this.f7730v.get();
        if (mVar == null || bundle == null) {
            return;
        }
        synchronized (mVar.f7742b) {
            b0 b0Var = mVar.f7745e;
            IBinder binder = bundle.getBinder("android.support.v4.media.session.EXTRA_BINDER");
            int i10 = v.f7763e;
            if (binder == null) {
                iVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = binder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
                if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof i)) {
                    h hVar = new h();
                    hVar.f7715d = binder;
                    iVar = hVar;
                } else {
                    iVar = (i) iInterfaceQueryLocalInterface;
                }
            }
            b0Var.b(iVar);
            mVar.f7745e.c(n5.a.q(bundle));
            mVar.a();
        }
    }
}
