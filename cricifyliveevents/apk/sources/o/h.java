package o;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f9235v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ k f9236w;

    public h(k kVar, f fVar) {
        this.f9236w = kVar;
        this.f9235v = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n.i iVar;
        k kVar = this.f9236w;
        n.k kVar2 = kVar.f9251x;
        if (kVar2 != null && (iVar = kVar2.f8523e) != null) {
            iVar.y(kVar2);
        }
        View view = (View) kVar.C;
        if (view != null && view.getWindowToken() != null) {
            f fVar = this.f9235v;
            if (fVar.b()) {
                kVar.O = fVar;
            } else if (fVar.f8584e != null) {
                fVar.d(0, 0, false, false);
                kVar.O = fVar;
            }
        }
        kVar.Q = null;
    }
}
