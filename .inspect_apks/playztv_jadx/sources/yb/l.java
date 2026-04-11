package yb;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f14621a;

    public l(m mVar) {
        this.f14621a = mVar;
    }

    public final void a() {
        m mVar = this.f14621a;
        synchronized (mVar) {
            mVar.f14627d = true;
        }
        this.f14621a.g();
    }
}
