package ke;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w0 extends CancellationException {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final transient d1 f7739u;

    public w0(String str, Throwable th, d1 d1Var) {
        super(str);
        this.f7739u = d1Var;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return be.h.a(w0Var.getMessage(), getMessage()) && be.h.a(w0Var.f7739u, this.f7739u) && be.h.a(w0Var.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        be.h.b(message);
        int iHashCode = (this.f7739u.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f7739u;
    }
}
