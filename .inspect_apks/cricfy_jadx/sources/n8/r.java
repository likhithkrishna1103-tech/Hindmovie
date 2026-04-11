package n8;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.bumptech.glide.manager.u;
import com.google.android.gms.common.api.Status;
import f9.c0;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f8897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j9.i f8898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0 f8899d;

    public r(u uVar, j9.i iVar, c0 c0Var) {
        super(2);
        this.f8898c = iVar;
        this.f8897b = uVar;
        this.f8899d = c0Var;
        if (uVar.f2289v) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // n8.n
    public final boolean a(i iVar) {
        return this.f8897b.f2289v;
    }

    @Override // n8.n
    public final l8.d[] b(i iVar) {
        return (l8.d[]) this.f8897b.f2290w;
    }

    @Override // n8.n
    public final void c(Status status) {
        this.f8899d.getClass();
        this.f8898c.b(status.f2308x != null ? new m8.f(status) : new i2.q(status));
    }

    @Override // n8.n
    public final void d(Exception exc) {
        this.f8898c.b(exc);
    }

    @Override // n8.n
    public final void e(i iVar) throws DeadObjectException {
        j9.i iVar2 = this.f8898c;
        try {
            this.f8897b.b(iVar.f8874e, iVar2);
        } catch (DeadObjectException e9) {
            throw e9;
        } catch (RemoteException e10) {
            c(n.g(e10));
        } catch (RuntimeException e11) {
            iVar2.b(e11);
        }
    }

    @Override // n8.n
    public final void f(i2.k kVar, boolean z10) {
        Boolean boolValueOf = Boolean.valueOf(z10);
        Map map = (Map) kVar.f6086w;
        j9.i iVar = this.f8898c;
        map.put(iVar, boolValueOf);
        j9.p pVar = iVar.f6688a;
        i2.k kVar2 = new i2.k(kVar, iVar, false);
        pVar.getClass();
        pVar.f6707b.h(new j9.n(j9.j.f6689a, kVar2));
        pVar.q();
    }
}
