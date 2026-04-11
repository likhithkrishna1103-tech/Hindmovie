package s7;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.Map;
import k8.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.manager.s f11908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o8.h f11909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f11910d;

    public r(com.bumptech.glide.manager.s sVar, o8.h hVar, z zVar) {
        super(2);
        this.f11909c = hVar;
        this.f11908b = sVar;
        this.f11910d = zVar;
        if (sVar.f2862w) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // s7.n
    public final boolean a(j jVar) {
        return this.f11908b.f2862w;
    }

    @Override // s7.n
    public final q7.d[] b(j jVar) {
        return (q7.d[]) this.f11908b.f2863x;
    }

    @Override // s7.n
    public final void c(Status status) {
        this.f11910d.getClass();
        this.f11909c.b(status.f2873w != null ? new r7.f(status) : new c2.o(status));
    }

    @Override // s7.n
    public final void d(Exception exc) {
        this.f11909c.b(exc);
    }

    @Override // s7.n
    public final void e(j jVar) throws DeadObjectException {
        o8.h hVar = this.f11909c;
        try {
            this.f11908b.b(jVar.f11891e, hVar);
        } catch (DeadObjectException e10) {
            throw e10;
        } catch (RemoteException e11) {
            c(n.g(e11));
        } catch (RuntimeException e12) {
            hVar.b(e12);
        }
    }

    @Override // s7.n
    public final void f(p2.c cVar, boolean z2) {
        Boolean boolValueOf = Boolean.valueOf(z2);
        Map map = (Map) cVar.f10131w;
        o8.h hVar = this.f11909c;
        map.put(hVar, boolValueOf);
        o8.o oVar = hVar.f9421a;
        pb.c cVar2 = new pb.c(8, cVar, hVar, false);
        oVar.getClass();
        oVar.f9440b.i(new o8.m(o8.i.f9422a, cVar2));
        oVar.q();
    }
}
