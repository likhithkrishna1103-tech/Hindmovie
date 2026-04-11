package pe;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10238c = AtomicIntegerFieldUpdater.newUpdater(i.class, "_resumed$volatile");
    private volatile /* synthetic */ int _resumed$volatile;

    public i(h hVar, Throwable th, boolean z10) {
        if (th == null) {
            th = new CancellationException("Continuation " + hVar + " was cancelled normally");
        }
        super(th, z10);
        this._resumed$volatile = 0;
    }
}
