package h4;

import android.os.Binder;
import android.os.IBinder;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s extends Binder implements h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f5845e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference f5846d;

    public s(t tVar) {
        attachInterface(this, "android.support.v4.media.session.IMediaSession");
        this.f5846d = new WeakReference(tVar);
    }

    public final void c(f fVar) {
        t tVar = (t) this.f5846d.get();
        if (tVar == null || fVar == null) {
            return;
        }
        tVar.f.register(fVar, new b0(Binder.getCallingPid(), Binder.getCallingUid(), "android.media.session.MediaController"));
        synchronized (tVar.f5850d) {
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
        throw new UnsupportedOperationException("Method not decompiled: h4.s.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
