package pe;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f10255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fe.q f10256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f10257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f10258e;

    public o(Object obj, e eVar, fe.q qVar, Object obj2, Throwable th) {
        this.f10254a = obj;
        this.f10255b = eVar;
        this.f10256c = qVar;
        this.f10257d = obj2;
        this.f10258e = th;
    }

    public static o a(o oVar, e eVar, CancellationException cancellationException, int i) {
        Object obj = oVar.f10254a;
        if ((i & 2) != 0) {
            eVar = oVar.f10255b;
        }
        e eVar2 = eVar;
        fe.q qVar = oVar.f10256c;
        Object obj2 = oVar.f10257d;
        Throwable th = cancellationException;
        if ((i & 16) != 0) {
            th = oVar.f10258e;
        }
        return new o(obj, eVar2, qVar, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return ge.i.a(this.f10254a, oVar.f10254a) && ge.i.a(this.f10255b, oVar.f10255b) && ge.i.a(this.f10256c, oVar.f10256c) && ge.i.a(this.f10257d, oVar.f10257d) && ge.i.a(this.f10258e, oVar.f10258e);
    }

    public final int hashCode() {
        Object obj = this.f10254a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        e eVar = this.f10255b;
        int iHashCode2 = (iHashCode + (eVar == null ? 0 : eVar.hashCode())) * 31;
        fe.q qVar = this.f10256c;
        int iHashCode3 = (iHashCode2 + (qVar == null ? 0 : qVar.hashCode())) * 31;
        Object obj2 = this.f10257d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f10258e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f10254a + ", cancelHandler=" + this.f10255b + ", onCancellation=" + this.f10256c + ", idempotentResume=" + this.f10257d + ", cancelCause=" + this.f10258e + ')';
    }

    public /* synthetic */ o(Object obj, e eVar, fe.q qVar, CancellationException cancellationException, int i) {
        this(obj, (i & 2) != 0 ? null : eVar, (i & 4) != 0 ? null : qVar, (Object) null, (i & 16) != 0 ? null : cancellationException);
    }
}
