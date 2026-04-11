package te;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends CancellationException {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final transient Object f12016v;

    public a(se.d dVar) {
        super("Flow was aborted, no more elements needed");
        this.f12016v = dVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
