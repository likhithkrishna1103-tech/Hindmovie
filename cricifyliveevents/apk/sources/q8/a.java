package q8;

import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements IInterface {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IBinder f10446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f10447e;

    public a(IBinder iBinder, String str) {
        this.f10446d = iBinder;
        this.f10447e = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f10446d;
    }
}
