package nc;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements pc.l, e5.j, l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ h f8931u;

    public /* synthetic */ g(h hVar) {
        this.f8931u = hVar;
    }

    @Override // e5.j
    public void a() {
        this.f8931u.T();
    }

    @Override // nc.l
    public void c(m mVar, String str) {
        h hVar = this.f8931u;
        hVar.f8934v0.c(mVar, str);
        ic.c cVar = hVar.f8936x0;
        ArrayList arrayList = hVar.f8935w0;
        cVar.getClass();
        cVar.f = new ArrayList(arrayList);
        cVar.f10982a.b();
    }

    @Override // pc.l
    public void f(String str, boolean z2) {
        h hVar = this.f8931u;
        if (!z2) {
            ((SwipeRefreshLayout) hVar.f8932t0.f12871y).setRefreshing(false);
            return;
        }
        try {
            hVar.V(new JSONArray(str));
        } catch (JSONException unused) {
            ((SwipeRefreshLayout) hVar.f8932t0.f12871y).setRefreshing(false);
        }
    }
}
