package ke;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f7710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f7711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ae.q f7712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f7713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f7714e;

    public n(Object obj, i0 i0Var, ae.q qVar, Object obj2, Throwable th) {
        this.f7710a = obj;
        this.f7711b = i0Var;
        this.f7712c = qVar;
        this.f7713d = obj2;
        this.f7714e = th;
    }

    public static n a(n nVar, i0 i0Var, CancellationException cancellationException, int i) {
        Object obj = nVar.f7710a;
        if ((i & 2) != 0) {
            i0Var = nVar.f7711b;
        }
        i0 i0Var2 = i0Var;
        ae.q qVar = nVar.f7712c;
        Object obj2 = nVar.f7713d;
        Throwable th = cancellationException;
        if ((i & 16) != 0) {
            th = nVar.f7714e;
        }
        return new n(obj, i0Var2, qVar, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return be.h.a(this.f7710a, nVar.f7710a) && be.h.a(this.f7711b, nVar.f7711b) && be.h.a(this.f7712c, nVar.f7712c) && be.h.a(this.f7713d, nVar.f7713d) && be.h.a(this.f7714e, nVar.f7714e);
    }

    public final int hashCode() {
        Object obj = this.f7710a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        i0 i0Var = this.f7711b;
        int iHashCode2 = (iHashCode + (i0Var == null ? 0 : i0Var.hashCode())) * 31;
        ae.q qVar = this.f7712c;
        int iHashCode3 = (iHashCode2 + (qVar == null ? 0 : qVar.hashCode())) * 31;
        Object obj2 = this.f7713d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f7714e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f7710a + ", cancelHandler=" + this.f7711b + ", onCancellation=" + this.f7712c + ", idempotentResume=" + this.f7713d + ", cancelCause=" + this.f7714e + ')';
    }

    public /* synthetic */ n(Object obj, i0 i0Var, ae.q qVar, CancellationException cancellationException, int i) {
        this(obj, (i & 2) != 0 ? null : i0Var, (i & 4) != 0 ? null : qVar, (Object) null, (i & 16) != 0 ? null : cancellationException);
    }
}
