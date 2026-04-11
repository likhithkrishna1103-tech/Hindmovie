package ta;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f12378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f12379b;

    public l(m mVar, long j5) {
        this.f12379b = mVar;
        this.f12378a = j5;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Bundle bundle = new Bundle();
        bundle.putInt("fatal", 1);
        bundle.putLong("timestamp", this.f12378a);
        this.f12379b.f12389k.p(bundle);
        return null;
    }
}
