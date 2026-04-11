package ua;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 extends o implements Serializable {
    public transient u0 A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final transient Map f12401y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public transient int f12402z;

    public v0(Map map) {
        if (!map.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.f12401y = map;
    }

    @Override // ua.o
    public final Map a() {
        Map map = this.f12370x;
        if (map != null) {
            return map;
        }
        Map map2 = this.f12401y;
        Map fVar = map2 instanceof NavigableMap ? new f(this, (NavigableMap) map2) : map2 instanceof SortedMap ? new i(this, (SortedMap) map2) : new d(this, map2);
        this.f12370x = fVar;
        return fVar;
    }

    public final void b() {
        Map map = this.f12401y;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        map.clear();
        this.f12402z = 0;
    }

    public final Collection c() {
        return (List) this.A.get();
    }
}
