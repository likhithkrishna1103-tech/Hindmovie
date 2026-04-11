package nb;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f8951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f8952b;

    public k(l lVar, long j4) {
        this.f8952b = lVar;
        this.f8951a = j4;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Bundle bundle = new Bundle();
        bundle.putInt("fatal", 1);
        bundle.putLong("timestamp", this.f8951a);
        this.f8952b.f8963k.q(bundle);
        return null;
    }
}
