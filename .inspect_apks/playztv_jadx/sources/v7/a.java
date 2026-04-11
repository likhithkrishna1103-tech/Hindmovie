package v7;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements IInterface {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IBinder f13322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f13323e;

    public a(IBinder iBinder, String str) {
        this.f13322d = iBinder;
        this.f13323e = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f13322d;
    }
}
