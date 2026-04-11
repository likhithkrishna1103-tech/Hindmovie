package n8;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j9.i f8900b;

    public s(j9.i iVar) {
        super(4);
        this.f8900b = iVar;
    }

    @Override // n8.n
    public final boolean a(i iVar) {
        if (iVar.i.get(null) == null) {
            return false;
        }
        throw new ClassCastException();
    }

    @Override // n8.n
    public final l8.d[] b(i iVar) {
        if (iVar.i.get(null) == null) {
            return null;
        }
        throw new ClassCastException();
    }

    @Override // n8.n
    public final void c(Status status) {
        this.f8900b.b(new i2.q(status));
    }

    @Override // n8.n
    public final void d(Exception exc) {
        this.f8900b.b(exc);
    }

    @Override // n8.n
    public final void e(i iVar) throws DeadObjectException {
        try {
            h(iVar);
        } catch (DeadObjectException e9) {
            c(n.g(e9));
            throw e9;
        } catch (RemoteException e10) {
            c(n.g(e10));
        } catch (RuntimeException e11) {
            this.f8900b.b(e11);
        }
    }

    public final void h(i iVar) {
        if (iVar.i.remove(null) != null) {
            throw new ClassCastException();
        }
        this.f8900b.c(Boolean.FALSE);
    }

    @Override // n8.n
    public final /* bridge */ /* synthetic */ void f(i2.k kVar, boolean z10) {
    }
}
