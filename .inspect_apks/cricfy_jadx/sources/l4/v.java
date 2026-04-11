package l4;

import android.os.Binder;
import android.os.IBinder;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v extends Binder implements i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f7763e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference f7764d;

    public v(w wVar) {
        attachInterface(this, "android.support.v4.media.session.IMediaSession");
        this.f7764d = new WeakReference(wVar);
    }

    public final void b(g gVar) {
        w wVar = (w) this.f7764d.get();
        if (wVar == null || gVar == null) {
            return;
        }
        wVar.f.register(gVar, new e0(Binder.getCallingPid(), Binder.getCallingUid(), "android.media.session.MediaController"));
        synchronized (wVar.f7768d) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0231  */
    @Override // android.os.Binder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTransact(int r33, android.os.Parcel r34, android.os.Parcel r35, int r36) {
        /*
            Method dump skipped, instruction units count: 1270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.v.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
