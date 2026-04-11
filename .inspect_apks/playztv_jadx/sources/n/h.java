package n;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f f8394u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ k f8395v;

    public h(k kVar, f fVar) {
        this.f8395v = kVar;
        this.f8394u = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.i iVar;
        k kVar = this.f8395v;
        m.k kVar2 = kVar.f8423w;
        if (kVar2 != null && (iVar = kVar2.f8209e) != null) {
            iVar.s(kVar2);
        }
        View view = (View) kVar.B;
        if (view != null && view.getWindowToken() != null) {
            f fVar = this.f8394u;
            if (fVar.b()) {
                kVar.N = fVar;
            } else if (fVar.f8270e != null) {
                fVar.d(0, 0, false, false);
                kVar.N = fVar;
            }
        }
        kVar.P = null;
    }
}
