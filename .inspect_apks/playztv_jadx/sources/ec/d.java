package ec;

import ae.p;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends td.g implements p {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public /* synthetic */ Object f4646y;

    @Override // ae.p
    public final Object i(Object obj, Object obj2) {
        d dVar = (d) m((String) obj, (rd.c) obj2);
        nd.k kVar = nd.k.f8990a;
        dVar.o(kVar);
        return kVar;
    }

    @Override // td.a
    public final rd.c m(Object obj, rd.c cVar) {
        d dVar = new d(2, cVar);
        dVar.f4646y = obj;
        return dVar;
    }

    @Override // td.a
    public final Object o(Object obj) throws Throwable {
        i5.a.Q(obj);
        Log.e("SessionConfigFetcher", "Error failing to fetch the remote configs: " + ((String) this.f4646y));
        return nd.k.f8990a;
    }
}
