package k4;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n extends Binder implements j {
    public static j b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("androidx.media3.session.IMediaController");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof j)) {
            return (j) iInterfaceQueryLocalInterface;
        }
        i iVar = new i();
        iVar.f7039d = iBinder;
        return iVar;
    }
}
