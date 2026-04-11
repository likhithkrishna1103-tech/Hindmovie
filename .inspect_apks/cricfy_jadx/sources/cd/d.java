package cd;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements md.e {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final md.c f2161v = md.c.f8424v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Map f2162w;

    public d() {
        Map mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        ge.i.d(mapSynchronizedMap, "synchronizedMap(...)");
        this.f2162w = mapSynchronizedMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x01f8  */
    @Override // md.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final md.d D(dd.c r26, md.k r27) {
        /*
            Method dump skipped, instruction units count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cd.d.D(dd.c, md.k):md.d");
    }

    @Override // md.e
    public final void H(md.d dVar) {
        Map map = this.f2162w;
        if (map.containsKey(dVar)) {
            nd.a aVar = (nd.a) map.get(dVar);
            map.remove(dVar);
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    @Override // md.e
    public final md.c X(dd.c cVar, Set set) {
        ge.i.e(set, "supportedFileDownloaderTypes");
        return this.f2161v;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Map map = this.f2162w;
        try {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                ((nd.a) ((Map.Entry) it.next()).getValue()).a();
            }
            map.clear();
        } catch (Exception unused) {
        }
    }

    @Override // md.e
    public final Set x(dd.c cVar) {
        try {
            return android.support.v4.media.session.b.y(cVar, this);
        } catch (Exception unused) {
            return u8.a.w(this.f2161v);
        }
    }

    @Override // md.e
    public final void B(dd.c cVar) {
    }

    @Override // md.e
    public final void F(dd.c cVar) {
    }

    @Override // md.e
    public final void y(dd.c cVar) {
    }
}
