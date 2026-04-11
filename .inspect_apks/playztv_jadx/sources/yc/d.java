package yc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d implements id.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final id.c f14660u = id.c.f6568u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map f14661v;

    public d() {
        Map mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        be.h.d(mapSynchronizedMap, "synchronizedMap(...)");
        this.f14661v = mapSynchronizedMap;
    }

    @Override // id.e
    public final void C(id.d dVar) {
        Map map = this.f14661v;
        if (map.containsKey(dVar)) {
            jd.a aVar = (jd.a) map.get(dVar);
            map.remove(dVar);
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Map map = this.f14661v;
        try {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                ((jd.a) ((Map.Entry) it.next()).getValue()).a();
            }
            map.clear();
        } catch (Exception unused) {
        }
    }

    @Override // id.e
    public final Set s(zc.c cVar) {
        try {
            return android.support.v4.media.session.b.A(cVar, this);
        } catch (Exception unused) {
            return cf.d.s(this.f14660u);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x01f8  */
    @Override // id.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final id.d t(zc.c r26, id.l r27) {
        /*
            Method dump skipped, instruction units count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: yc.d.t(zc.c, id.l):id.d");
    }

    @Override // id.e
    public final id.c w(zc.c cVar, Set set) {
        be.h.e(set, "supportedFileDownloaderTypes");
        return this.f14660u;
    }

    @Override // id.e
    public final void E(zc.c cVar) {
    }

    @Override // id.e
    public final void T(zc.c cVar) {
    }

    @Override // id.e
    public final void u(zc.c cVar) {
    }
}
