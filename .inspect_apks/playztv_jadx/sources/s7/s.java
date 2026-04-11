package s7;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o8.h f11911b;

    public s(o8.h hVar) {
        super(4);
        this.f11911b = hVar;
    }

    @Override // s7.n
    public final boolean a(j jVar) {
        if (jVar.i.get(null) == null) {
            return false;
        }
        throw new ClassCastException();
    }

    @Override // s7.n
    public final q7.d[] b(j jVar) {
        if (jVar.i.get(null) == null) {
            return null;
        }
        throw new ClassCastException();
    }

    @Override // s7.n
    public final void c(Status status) {
        this.f11911b.b(new c2.o(status));
    }

    @Override // s7.n
    public final void d(Exception exc) {
        this.f11911b.b(exc);
    }

    @Override // s7.n
    public final void e(j jVar) throws DeadObjectException {
        try {
            h(jVar);
        } catch (DeadObjectException e10) {
            c(n.g(e10));
            throw e10;
        } catch (RemoteException e11) {
            c(n.g(e11));
        } catch (RuntimeException e12) {
            this.f11911b.b(e12);
        }
    }

    public final void h(j jVar) {
        if (jVar.i.remove(null) != null) {
            throw new ClassCastException();
        }
        this.f11911b.c(Boolean.FALSE);
    }

    @Override // s7.n
    public final /* bridge */ /* synthetic */ void f(p2.c cVar, boolean z2) {
    }
}
