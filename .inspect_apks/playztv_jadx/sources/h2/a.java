package h2;

import android.net.Uri;
import android.os.SystemClock;
import j9.j0;
import java.util.HashMap;
import java.util.List;
import k8.a0;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements t {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ c f5653u;

    public a(c cVar) {
        this.f5653u = cVar;
    }

    @Override // h2.t
    public final void b() {
        this.f5653u.f5664y.remove(this);
    }

    @Override // h2.t
    public final boolean d(Uri uri, e6.i iVar, boolean z2) {
        b bVar;
        c cVar = this.f5653u;
        HashMap map = cVar.f5663x;
        if (cVar.F == null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            o oVar = cVar.D;
            int i = b0.f11647a;
            List list = oVar.f5742e;
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                b bVar2 = (b) map.get(((n) list.get(i11)).f5735a);
                if (bVar2 != null && jElapsedRealtime < bVar2.B) {
                    i10++;
                }
            }
            j0 j0Var = new j0(1, 0, cVar.D.f5742e.size(), i10);
            cVar.f5662w.getClass();
            e4.f fVarJ = a0.j(j0Var, iVar);
            if (fVarJ != null && fVarJ.f4419a == 2 && (bVar = (b) map.get(uri)) != null) {
                b.a(bVar, fVarJ.f4420b);
            }
        }
        return false;
    }
}
