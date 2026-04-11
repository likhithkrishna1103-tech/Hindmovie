package of;

import java.net.Proxy;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kf.a f9856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m2.e f9857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f9859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9860e;
    public Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f9861g;

    public u(kf.a aVar, m2.e eVar, n nVar, boolean z10) {
        List listJ;
        ge.i.e(eVar, "routeDatabase");
        this.f9856a = aVar;
        this.f9857b = eVar;
        this.f9858c = z10;
        sd.p pVar = sd.p.f11669v;
        this.f9859d = pVar;
        this.f = pVar;
        this.f9861g = new ArrayList();
        kf.q qVar = aVar.f7432h;
        ge.i.e(qVar, "url");
        URI uriG = qVar.g();
        if (uriG.getHost() == null) {
            listJ = lf.f.j(new Proxy[]{Proxy.NO_PROXY});
        } else {
            List<Proxy> listSelect = aVar.f7431g.select(uriG);
            listJ = (listSelect == null || listSelect.isEmpty()) ? lf.f.j(new Proxy[]{Proxy.NO_PROXY}) : lf.f.i(listSelect);
        }
        this.f9859d = listJ;
        this.f9860e = 0;
    }

    public final boolean a() {
        return this.f9860e < this.f9859d.size() || !this.f9861g.isEmpty();
    }
}
