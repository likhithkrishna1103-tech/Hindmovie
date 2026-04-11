package oe;

import cc.v;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends CancellationException {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final transient v f9573u;

    public a(v vVar) {
        super("Flow was aborted, no more elements needed");
        this.f9573u = vVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
