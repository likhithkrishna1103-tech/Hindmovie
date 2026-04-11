package pe;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 extends CancellationException {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final transient c1 f10280v;

    public w0(String str, Throwable th, c1 c1Var) {
        super(str);
        this.f10280v = c1Var;
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
        return ge.i.a(w0Var.getMessage(), getMessage()) && ge.i.a(w0Var.f10280v, this.f10280v) && ge.i.a(w0Var.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        ge.i.b(message);
        int iHashCode = (this.f10280v.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f10280v;
    }
}
