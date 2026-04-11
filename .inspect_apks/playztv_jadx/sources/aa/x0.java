package aa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x0 extends o implements Serializable {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final transient Map f760x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public transient int f761y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public transient w0 f762z;

    public x0(Map map) {
        q1.c.h(map.isEmpty());
        this.f760x = map;
    }

    @Override // aa.o
    public final Map a() {
        Map map = this.f717w;
        if (map != null) {
            return map;
        }
        Map map2 = this.f760x;
        Map fVar = map2 instanceof NavigableMap ? new f(this, (NavigableMap) map2) : map2 instanceof SortedMap ? new i(this, (SortedMap) map2) : new d(this, map2);
        this.f717w = fVar;
        return fVar;
    }

    public final void b() {
        Map map = this.f760x;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        map.clear();
        this.f761y = 0;
    }

    public final Collection c() {
        return (List) this.f762z.get();
    }
}
