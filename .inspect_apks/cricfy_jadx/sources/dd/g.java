package dd;

import ge.i;
import java.io.Closeable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Closeable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f3686v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f3687w;

    public g(f fVar) {
        this.f3686v = fVar;
        d5.a aVar = fVar.f3681v;
        this.f3687w = new Object();
    }

    public final void A(e eVar) {
        i.e(eVar, "downloadInfo");
        synchronized (this.f3687w) {
            this.f3686v.Q(eVar);
        }
    }

    public final e a(String str) {
        e eVarQ;
        i.e(str, "file");
        synchronized (this.f3687w) {
            eVarQ = this.f3686v.q(str);
        }
        return eVarQ;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f3687w) {
            this.f3686v.close();
        }
    }

    public final List g(int i) {
        List listS;
        synchronized (this.f3687w) {
            listS = this.f3686v.s(i);
        }
        return listS;
    }

    public final p6.d q() {
        p6.d dVar;
        synchronized (this.f3687w) {
            dVar = this.f3686v.f3685z;
        }
        return dVar;
    }

    public final List s(cd.i iVar) {
        List listZ;
        i.e(iVar, "prioritySort");
        synchronized (this.f3687w) {
            listZ = this.f3686v.z(iVar);
        }
        return listZ;
    }

    public final rd.f z(e eVar) {
        rd.f fVarA;
        synchronized (this.f3687w) {
            fVarA = this.f3686v.A(eVar);
        }
        return fVarA;
    }
}
