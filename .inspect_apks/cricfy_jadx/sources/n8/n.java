package n8;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8892a;

    public n(int i) {
        this.f8892a = i;
    }

    public static Status g(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage(), null, null);
    }

    public abstract boolean a(i iVar);

    public abstract l8.d[] b(i iVar);

    public abstract void c(Status status);

    public abstract void d(Exception exc);

    public abstract void e(i iVar);

    public abstract void f(i2.k kVar, boolean z10);
}
